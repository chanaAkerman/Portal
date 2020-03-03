package com.example.portal.ui.dictionary;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.portal.R;
import com.example.portal.ui.Word_Package.Word;

import java.util.List;

public class WordList extends ArrayAdapter {
    private Activity context;
    private List<Word> words;

    public WordList(Activity context, List<Word> words) {
        super(context, R.layout.word_list, words);
        this.context = context;
        this.words = words;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.word_list, null, true);

        TextView textViewWord = listViewItem.findViewById(R.id.word);
        TextView textViewTranslating = listViewItem.findViewById(R.id.translating);

        Word word = words.get(position);

        textViewWord.setText(word.getHebrew_value());
        textViewTranslating.setText(word.getHebrew_proverb());

        listViewItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClick();
            }
        });

        return listViewItem;
    }

    private void itemClick()
    {
        //TO DO
    }

}
