package com.example.portal.ui.dictionary;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.portal.ui.Database.CallBack;
import com.example.portal.ui.Database.DatabaseManager;
import com.example.portal.R;
import com.example.portal.ui.Word_Package.Word;
import com.example.portal.ui.Word_Package.WordInput;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class DictionaryFragment extends Fragment {
    private DictionaryViewModel dictionaryViewModel;
    private DatabaseManager manager;
    private ArrayList<Word> words;
    private ListView listView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dictionaryViewModel = ViewModelProviders.of(this).get(DictionaryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dictionary, container, false);
        /*final TextView textView = root.findViewById(R.id.text_dictionary);
        dictionaryViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/

        listView = root.findViewById(R.id.wordsList);

        FloatingActionButton fab = root.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), WordInput.class);
                startActivity(intent);
            }
        });

        manager = new DatabaseManager(new CallBack() {
            public void fetch() {
                words = new ArrayList<>();

                words = manager.getWords();

                if (words == null)
                    listView.setAdapter(null);
                else {
                    WordList wordAdapter = new WordList(getActivity(), words);
                    listView.setAdapter(wordAdapter);
                }
            }
        });
//        manager.addWord(new Word("זאב", "תעלב", "Lupo", Type.Verb));
//        manager.addWord(new Word("זאטוט", "יל צגיר", "bimbo, infant", Type.Noun));
//        manager.addWord(new Word("זאת מ\"נ", "חאדי", "Questa", Type.Noun));
//        manager.addWord(new Word("זבדה", "זבדה", "crema del latte, panna", Type.Noun));
//        manager.addWord(new Word("זבוב", "דבאנה", "Mosca", Type.Noun));
//
//        manager.addWord(new Word("זבח", "קרבן", "Sacrificio", Type.Noun));
//        manager.addWord(new Word("זבל", "זבל", "Concime", Type.Noun));
//        manager.addWord(new Word("זבן", "ביאע", "Venditore", Type.Noun));
//        manager.addWord(new Word("זגוגית", "יזאז", "Vetro", Type.Noun));
//        manager.addWord(new Word("זדון", "רשעות", "cattiveria, scelleraetzza", Type.Noun));

        return root;
    }

}
