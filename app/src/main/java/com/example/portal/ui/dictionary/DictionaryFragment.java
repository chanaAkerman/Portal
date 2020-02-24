package com.example.portal.ui.dictionary;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.portal.ui.Database.CallBack;
import com.example.portal.ui.Database.DatabaseManager;
import com.example.portal.R;
import com.example.portal.ui.Word_Package.Word;

import java.util.ArrayList;

public class DictionaryFragment extends Fragment {
    private DictionaryViewModel dictionaryViewModel;
    DatabaseManager manager;
    ArrayList<Word> words;
    ListView listView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dictionaryViewModel =
                ViewModelProviders.of(this).get(DictionaryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dictionary, container, false);
        /*final TextView textView = root.findViewById(R.id.text_dictionary);
        dictionaryViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/

        words = new ArrayList<>();
        listView = root.findViewById(R.id.wordsList);

        manager = new DatabaseManager(new CallBack(){
            public void fetch(){
                words = manager.getWords();
                if(words==null)
                    listView.setAdapter(null);
                else
                {
                    WordList wordAdapter = new WordList(getActivity(), words);
                    listView.setAdapter(wordAdapter);
                }
            }
        });

        return root;
    }

}
