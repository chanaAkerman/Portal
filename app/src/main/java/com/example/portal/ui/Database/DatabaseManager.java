package com.example.portal.ui.Database;
import android.util.Log;

import androidx.annotation.NonNull;

import com.example.portal.ui.Word_Package.Word;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class DatabaseManager {
    private FirebaseDatabase database;
    private DatabaseReference dictionaryRef;
    private ArrayList<Word> words;
    private CallBack callBack;

    public DatabaseManager(CallBack callBack)
    {
        this.database = FirebaseDatabase.getInstance();
        this.dictionaryRef = database.getReference("Dictionary");
        this.callBack = callBack;
        this.words = new ArrayList<>();
        setDictionaryRef();
    }

    public void addWord(Word word)
    {
        dictionaryRef.push().setValue(word);
    }

    public ArrayList<Word> getWords()
    {
        return words;
    }

    private void setDictionaryRef()
    {
        dictionaryRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    Word word = ds.getValue(Word.class);
                    words.add(word);
                }
                // finish fetch all data
                callBack.fetch();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Failed to read value
                Log.w("Failed to read data.", databaseError.toException());
            }
        });
    }
}
