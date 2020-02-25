package com.example.portal.ui.Word_Package;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.telecom.Call;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.portal.R;
import com.example.portal.ui.Database.CallBack;
import com.example.portal.ui.Database.DatabaseManager;
import com.example.portal.ui.dictionary.DictionaryFragment;
import com.google.android.material.snackbar.Snackbar;

public class WordInput extends AppCompatActivity {
    DatabaseManager manager;
    TextView hebrew;
    TextView hebrew_Translating;
    TextView italian;
    TextView chosenCategory;
    Button category;
    Button save;
    Type type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_input);

        hebrew = findViewById(R.id.hebrew_value);
        hebrew_Translating = findViewById(R.id.hebrew_translating);
        italian = findViewById(R.id.italian_translating);
        category = findViewById(R.id.category);
        chosenCategory = findViewById(R.id.chosenCategory);
        save = findViewById(R.id.save);
        type = null;

        manager = new DatabaseManager(new CallBack());
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Word word = new Word(hebrew.getText()+"", hebrew_Translating.getText()+"", italian.getText()+"", type);
                if(IntegrityCheck(word)) {
                    manager.addWord(word);
                    sendToManagerDialog();
                }
                else
                    Snackbar.make(v, "Invalid value", Snackbar.LENGTH_LONG).setAction("Action", null).show();

            }
        });

        category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                categoryDialog();
            }
        });
    }

    public boolean IntegrityCheck(Word word)
    {
        if( (word.getHebrew_value()!=null && !word.getHebrew_value().equals("")) &&
                (word.getHebrew_translating()!=null && !word.getHebrew_translating().equals("")) &&
                (word.getItalian_value()!=null && !word.getItalian_value().equals("")) &&
                (word.getType()!=null))
        {
            return true;
        }
        return false;
    }

    public void categoryDialog() {
        final String[] listItems = getResources().getStringArray(R.array.items);
        new AlertDialog.Builder(this)
                .setTitle("בחר קטגוריה:")
                .setSingleChoiceItems(listItems, 0, null)
                .setPositiveButton("אוקי", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        dialog.dismiss();
                        int selectedPosition = ((AlertDialog)dialog).getListView().getCheckedItemPosition();
                        switch (selectedPosition) {
                            case 0:
                                chosenCategory.setText("שם עצם");
                                type = Type.Noun;
                                break;
                            case 1:
                                chosenCategory.setText("פועל");
                                type = Type.Verb;
                                break;

                            default:
                                break;
                        }
                    }
                }).show();

    }

    public void sendToManagerDialog()
    {
        new AlertDialog.Builder(this)
                .setMessage("הערך נשלח לאישור מנהל")
                .setPositiveButton("אוקי", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent intent = new Intent(getBaseContext(), DictionaryFragment.class);
                        startActivity(intent);
                    }
                }).show();
    }
}
