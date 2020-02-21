package com.example.portal.ui.dictionary;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.portal.ui.Word_Package.Type;
import com.example.portal.ui.Word_Package.Word;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DictionaryViewModel extends ViewModel {

    private MutableLiveData<String> mText;
    private DatabaseReference ref;

    public DictionaryViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is dictionary fragment");
        ref = FirebaseDatabase.getInstance().getReference().child("Dictionary");
        save();
    }

    public LiveData<String> getText() {
        return mText;
    }

    public void save()
    {
        Word w = new Word("f", "f","f", Type.Noun);
        ref.push().setValue(w);
    }
}
