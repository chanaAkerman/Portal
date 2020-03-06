package com.example.portal.ui.dictionary;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.baoyz.swipemenulistview.SwipeMenu;
import com.baoyz.swipemenulistview.SwipeMenuCreator;
import com.baoyz.swipemenulistview.SwipeMenuItem;
import com.example.portal.ui.Database.CallBack;
import com.example.portal.ui.Database.DatabaseManager;
import com.example.portal.R;
import com.example.portal.ui.Word_Package.Word;
import com.example.portal.ui.Word_Package.WordInput;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import com.baoyz.swipemenulistview.SwipeMenuListView;


public class DictionaryFragment extends Fragment {
    private DictionaryViewModel dictionaryViewModel;
    private DatabaseManager manager;
    private ArrayList<Word> words;
    private ListView listView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dictionaryViewModel = ViewModelProviders.of(this).get(DictionaryViewModel.class);
        final View root = inflater.inflate(R.layout.fragment_dictionary, container, false);
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
                    //WordList wordAdapter = new WordList(getActivity(), words);
                    //listView.setAdapter(wordAdapter);
                    SwipeMenuListView list = root.findViewById(R.id.wordsList);
                    WordList wordAdapter = new WordList(getActivity(), words);
                    list.setAdapter(wordAdapter);

                    SwipeMenuCreator creator = new SwipeMenuCreator() {

                        @Override
                        public void create(SwipeMenu menu) {
                            // create "open" item
                            //SwipeMenuItem shareItem = new SwipeMenuItem(getContext());
                            // set item background
//                            shareItem.setBackground(new ColorDrawable(Color.rgb(0xF9, 0x3F,
//                                    0x25)));
//                            // set item width
//                            shareItem.setWidth(300);
//                            // set item title
//                            shareItem.setTitle("Open");
//                            // set item title fontsize
//                            shareItem.setTitleSize(18);
//                            // set item title font color
//                            shareItem.setTitleColor(Color.WHITE);
//                            // add to menu
//                            menu.addMenuItem(shareItem);

                            SwipeMenuItem shareItem = new SwipeMenuItem(
                                    getContext());
                            // set item background
                            shareItem.setBackground(new ColorDrawable(Color.rgb(0x6B,
                                    0xD1, 0x6F)));
                            // set item width
                            shareItem.setWidth(250);
                            // set a icon
                            shareItem.setIcon(R.drawable.ic_menu_share);
                            // add to menu
                            menu.addMenuItem(shareItem);


                            // create "delete" item
                            SwipeMenuItem deleteItem = new SwipeMenuItem(
                                    getContext());
                            // set item background
                            deleteItem.setBackground(new ColorDrawable(Color.rgb(0x6B,
                                    0xD1, 0x6F)));;
                            // set item width
                            deleteItem.setWidth(250);
                            // set a icon
                            deleteItem.setIcon(R.drawable.ic_delete);
                            // add to menu
                            menu.addMenuItem(deleteItem);
                        }
                    };
                    list.setMenuCreator(creator);
                    list.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(int position, SwipeMenu menu, int index) {
                            switch (index) {
                                case 0:
                                    // share
                                    Toast.makeText(getContext(), "share", Toast.LENGTH_LONG).show();
                                    break;
                                case 1:
                                    // delete
                                    Toast.makeText(getContext(), "delete", Toast.LENGTH_LONG).show();
                                    break;
                            }
                            // false : close the menu; true : not close the menu
                            return false;
                        }
                    });

                    // Right
                    list.setSwipeDirection(SwipeMenuListView.DIRECTION_RIGHT);

                    // Left
                    //list.setSwipeDirection(SwipeMenuListView.DIRECTION_LEFT);

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

