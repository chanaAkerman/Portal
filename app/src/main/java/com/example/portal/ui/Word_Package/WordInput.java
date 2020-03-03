package com.example.portal.ui.Word_Package;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import com.example.portal.R;
import com.example.portal.ui.Database.CallBack;
import com.example.portal.ui.Database.DatabaseManager;
import com.example.portal.ui.dictionary.DictionaryFragment;
import com.google.android.material.textfield.TextInputLayout;

public class WordInput extends AppCompatActivity {
    DatabaseManager manager;

    private TextInputLayout input_layout_hebrew_value, input_layout_italian_value, input_layout_arabic_value,input_layout_arabic_pronunciation_value,
    input_layout_hebrew_proverb_value, input_layout_italian_proverb_value, input_layout_arabic_proverb_value, input_layout_arabic_dialect_value,input_layout_note;
    private EditText hebrew_value, italian_value, arabic_value, arabic_pronunciation_value, hebrew_proverb_value,
            italian_proverb_value, arabic_proverb_value, arabic_dialect_value, note_value;

    Button btnAdd;
    Type type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_input);

        input_layout_hebrew_value = findViewById(R.id.input_layout_hebrew_value);
        input_layout_italian_value = findViewById(R.id.input_layout_italian_value);
        input_layout_arabic_value = findViewById(R.id.input_layout_arabic_value);
        input_layout_arabic_pronunciation_value = findViewById(R.id.input_layout_arabic_pronunciation_value);
        input_layout_hebrew_proverb_value = findViewById(R.id.input_layout_hebrew_proverb_value);
        input_layout_italian_proverb_value = findViewById(R.id.input_layout_italian_proverb_value);
        input_layout_arabic_proverb_value = findViewById(R.id.input_layout_arabic_proverb_value);
        input_layout_arabic_dialect_value = findViewById(R.id.input_layout_arabic_dialect_value);
        input_layout_note = findViewById(R.id.input_layout_note);

        hebrew_value = findViewById(R.id.input_hebrew_value);
        italian_value = findViewById(R.id.input_italian_value);
        arabic_value = findViewById(R.id.input_arabic_value);
        arabic_pronunciation_value = findViewById(R.id.input_arabic_pronunciation_value);
        hebrew_proverb_value = findViewById(R.id.input_hebrew_proverb_value);
        italian_proverb_value = findViewById(R.id.input_italian_proverb_value);
        arabic_proverb_value = findViewById(R.id.input_arabic_proverb_value);
        arabic_dialect_value = findViewById(R.id.input_arabic_dialect_value);
        note_value = findViewById(R.id.input_note);

        hebrew_value.addTextChangedListener(new MyTextWatcher(hebrew_value));
        italian_value.addTextChangedListener(new MyTextWatcher(italian_value));
        arabic_value.addTextChangedListener(new MyTextWatcher(arabic_value));
        arabic_pronunciation_value.addTextChangedListener(new MyTextWatcher(arabic_pronunciation_value));
        hebrew_proverb_value.addTextChangedListener(new MyTextWatcher(hebrew_proverb_value));
        italian_proverb_value.addTextChangedListener(new MyTextWatcher(italian_proverb_value));
        arabic_proverb_value.addTextChangedListener(new MyTextWatcher(arabic_proverb_value));
        arabic_dialect_value.addTextChangedListener(new MyTextWatcher(arabic_dialect_value));
        note_value.addTextChangedListener(new MyTextWatcher(note_value));

        btnAdd = findViewById(R.id.btn_add_value);
        type = null;

        manager = new DatabaseManager(new CallBack());
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Word word = new Word(hebrew_value.getText().toString(), italian_value.getText().toString(), arabic_value.getText().toString(),
                        arabic_pronunciation_value.getText().toString(), Type.Verb, hebrew_proverb_value.getText().toString(), italian_proverb_value.getText().toString(),
                        arabic_proverb_value.getText().toString(), arabic_dialect_value.getText().toString(), note_value.getText().toString());
                if(submitForm()){
                    manager.addWord(word);
                    sendToManagerDialog();
                }
//               Snackbar.make(v, "Invalid value", Snackbar.LENGTH_LONG).setAction("Action", null).show();

            }
        });
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
                               // .setText("שם עצם");
                                type = Type.Noun;
                                break;
                            case 1:
                                //.setText("פועל");
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


    private boolean submitForm() {
        if (!validateHebrewValue()) {
            return false;
        }

        if (!validateItalianValue()) {
            return false;
        }

        if (!validateArabicValue()) {
            return false;
        }

        if(!validateArabicPronunciationValue()){
            return false;
        }

        if(!validateHebrewProverbValue()){
            return false;
        }

        if(!validateItalianProverbValue()){
            return false;
        }

        if(!validateArabicProverbValue()){
            return false;
        }

        if(!validateArabicDialectValue()){
            return false;
        }
        return true;
    }


    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }

    private boolean validateHebrewValue() {
        if (hebrew_value.getText().toString().trim().isEmpty()) {
            hebrew_value.setError(getString(R.string.err_msg_hebrew_value));
            requestFocus(hebrew_value);
            return false;
        } else {
            input_layout_hebrew_value.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validateItalianValue() {
        if (italian_value.getText().toString().trim().isEmpty()) {
            italian_value.setError(getString(R.string.err_msg_italian_value));
            requestFocus(italian_value);
            return false;
        } else {
            input_layout_italian_value.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validateArabicValue() {
        if (arabic_value.getText().toString().trim().isEmpty()) {
            arabic_value.setError(getString(R.string.err_msg_arabic_value));
            requestFocus(arabic_value);
            return false;
        } else {
            input_layout_arabic_value.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validateArabicPronunciationValue() {
        if (arabic_pronunciation_value.getText().toString().trim().isEmpty()) {
            arabic_pronunciation_value.setError(getString(R.string.err_msg_arabic_pronunciation_value));
            requestFocus(arabic_pronunciation_value);
            return false;
        } else {
            input_layout_arabic_pronunciation_value.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validateHebrewProverbValue() {
        if (hebrew_proverb_value.getText().toString().trim().isEmpty()) {
            hebrew_proverb_value.setError(getString(R.string.err_msg_hebrew_proverb_value));
            requestFocus(hebrew_proverb_value);
            return false;
        } else {
            input_layout_hebrew_proverb_value.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validateItalianProverbValue() {
        if (italian_proverb_value.getText().toString().trim().isEmpty()) {
            italian_proverb_value.setError(getString(R.string.err_msg_italian_proverb_value));
            requestFocus(italian_proverb_value);
            return false;
        } else {
            input_layout_italian_proverb_value.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validateArabicProverbValue() {
        if (arabic_proverb_value.getText().toString().trim().isEmpty()) {
            arabic_proverb_value.setError(getString(R.string.err_msg_arabic_proverb_value));
            requestFocus(arabic_proverb_value);
            return false;
        } else {
            input_layout_arabic_proverb_value.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validateArabicDialectValue() {
        if (arabic_dialect_value.getText().toString().trim().isEmpty()) {
            arabic_dialect_value.setError(getString(R.string.err_msg_arabic_dialect));
            requestFocus(arabic_dialect_value);
            return false;
        } else {
            input_layout_arabic_dialect_value.setErrorEnabled(false);
        }

        return true;
    }

    private class MyTextWatcher implements TextWatcher {

        private View view;

        private MyTextWatcher(View view) {
            this.view = view;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void afterTextChanged(Editable editable) {
            switch (view.getId()) {
                case R.id.input_hebrew_value:
                    validateHebrewValue();
                    break;
                case R.id.input_italian_value:
                    validateItalianValue();
                    break;
                case R.id.input_arabic_value:
                    validateArabicValue();
                    break;
                case R.id.input_arabic_pronunciation_value:
                    validateArabicPronunciationValue();
                    break;
                case R.id.input_hebrew_proverb_value:
                    validateHebrewProverbValue();
                    break;
                case R.id.input_italian_proverb_value:
                    validateItalianProverbValue();
                    break;
                case R.id.input_arabic_proverb_value:
                    validateArabicProverbValue();
                    break;
                case R.id.input_arabic_dialect_value:
                    validateArabicDialectValue();
                    break;
                case R.id.input_layout_note:
                    // Can be empty
                    break;
            }
        }
    }
}
