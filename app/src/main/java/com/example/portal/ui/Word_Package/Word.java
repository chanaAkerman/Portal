package com.example.portal.ui.Word_Package;

import androidx.annotation.NonNull;

public class Word {
    private String hebrew_value;
    private String italian_value;
    private String arabic_value;
    private String arabic_word_pronunciation;
    private Type type;
    private String hebrew_proverb;
    private String italian_proverb;
    private String arabic_proverb;
    private String arabic_dialect;
    private String note;

    public Word(){}

    public Word(String hebrew_value, String italian_value, String arabic_value,String arabic_word_pronunciation, Type type,
                String hebrew_proverb, String italian_proverb, String arabic_proverb, String arabic_dialect, String note) {
        this.hebrew_value = hebrew_value;
        this.italian_value = italian_value;
        this.arabic_value = arabic_value;
        this.arabic_word_pronunciation = arabic_word_pronunciation;
        this.type = type;
        this.hebrew_proverb = hebrew_proverb;
        this.italian_proverb = italian_proverb;
        this.arabic_proverb = arabic_proverb;
        this.arabic_dialect = arabic_dialect;
        this.note = note;
    }

    public String getHebrew_value() {
        return hebrew_value;
    }

    public void setHebrew_value(String hebrew_value) {
        this.hebrew_value = hebrew_value;
    }

    public String getItalian_value() {
        return italian_value;
    }

    public void setItalian_value(String italian_value) {
        this.italian_value = italian_value;
    }

    public String getArabic_value() {
        return arabic_value;
    }

    public void setArabic_value(String arabic_value) {
        this.arabic_value = arabic_value;
    }

    public String getArabic_word_pronunciation() {
        return arabic_word_pronunciation;
    }

    public void setArabic_word_pronunciation(String arabic_word_pronunciation) {
        this.arabic_word_pronunciation = arabic_word_pronunciation;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getHebrew_proverb() {
        return hebrew_proverb;
    }

    public void setHebrew_proverb(String hebrew_proverb) {
        this.hebrew_proverb = hebrew_proverb;
    }

    public String getItalian_proverb() {
        return italian_proverb;
    }

    public void setItalian_proverb(String italian_proverb) {
        this.italian_proverb = italian_proverb;
    }

    public String getArabic_proverb() {
        return arabic_proverb;
    }

    public void setArabic_proverb(String arabic_proverb) {
        this.arabic_proverb = arabic_proverb;
    }

    public String getArabic_dialect() {
        return arabic_dialect;
    }

    public void setArabic_dialect(String arabic_dialect) {
        this.arabic_dialect = arabic_dialect;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @NonNull
    @Override
    public String toString() {
        return super.toString();
    }

}

/*
<TextView
        android:id="@+id/heading_label"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:paddingRight="10dp"
        android:text="הוספת מילה חדשה"
        android:textStyle="bold"
        android:paddingTop="10dp"
        android:textSize="30sp"/>

    <RelativeLayout
        android:id="@+id/layout_1"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_below="@id/heading_label">

        <TextView
            android:id="@+id/text_1"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="ערך בעברית          "
            android:layout_alignParentRight="true"
            android:paddingTop="2dp"
            android:paddingRight="10dp"/>


        <EditText
            android:id="@+id/hebrew_value"
            android:layout_width="@dimen/nav_header_height"
            android:layout_height="wrap_content"
            android:hint="כתוב כאן"
            android:paddingRight="10dp"
            android:singleLine="true"
            android:layout_toLeftOf="@+id/text_1"
            android:background="@drawable/round_frame"/>


    </RelativeLayout>

    <RelativeLayout
        android:id="@+id/layout_2"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_below="@id/layout_1"
        android:paddingTop="10dp">

        <TextView
            android:id="@+id/text_2"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="משמעות בעברית  "
            android:layout_alignParentRight="true"
            android:paddingTop="2dp"
            android:paddingRight="10dp"/>


        <EditText
            android:id="@+id/hebrew_translating"
            android:layout_width="@dimen/nav_header_height"
            android:layout_height="wrap_content"
            android:hint="כתוב כאן"
            android:paddingRight="10dp"
            android:singleLine="true"
            android:layout_toLeftOf="@+id/text_2"
            android:background="@drawable/round_frame"/>


    </RelativeLayout>

    <RelativeLayout
        android:id="@+id/layout_3"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_below="@id/layout_2"
        android:paddingTop="10dp">

        <TextView
            android:id="@+id/text_3"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="תרגום לאיטלקית   "
            android:layout_alignParentRight="true"
            android:paddingTop="2dp"
            android:paddingRight="10dp"/>


        <EditText
            android:id="@+id/italian_translating"
            android:layout_width="@dimen/nav_header_height"
            android:layout_height="wrap_content"
            android:hint="כתוב כאן"
            android:paddingRight="10dp"
            android:singleLine="true"
            android:layout_toLeftOf="@+id/text_3"
            android:background="@drawable/round_frame"/>

    </RelativeLayout>

    <RelativeLayout
        android:id="@+id/layout_4"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_below="@id/layout_3">

        <TextView
            android:id="@+id/text_4"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="קטגוריה                "
            android:layout_alignParentRight="true"
            android:paddingTop="10dp"
            android:paddingRight="10dp" />


        <TextView
            android:id="@+id/chosenCategory"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="שפת תקשורת"
            android:layout_toLeftOf="@id/text_4"
            android:paddingTop="10dp"
            android:paddingRight="10dp" />

        <Button
            android:id="@+id/category"
            android:layout_width="wrap_content"
            android:layout_height="40dp"
            android:text="בחר"
            android:singleLine="true"
            android:layout_alignParentLeft="true"
            android:layout_marginLeft="70dp">

        </Button>


    </RelativeLayout>
 */