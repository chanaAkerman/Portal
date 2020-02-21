package com.example.portal.ui.Word_Package;

import androidx.annotation.NonNull;

public class Word {
    private String Hebrew_value;
    private String Arabic_value;
    private String Italian_value;
    private Type type;

    public Word(){}

    public Word(String h, String A, String I, Type type)
    {
        this.Hebrew_value = h;
        this.Arabic_value = A;
        this.Italian_value = I;
        this.type = type;
    }

    public String getArabic_value() {
        return Arabic_value;
    }

    public String getHebrew_value() {
        return Hebrew_value;
    }

    public String getItalian_value() {
        return Italian_value;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setArabic_value(String arabic_value) {
        Arabic_value = arabic_value;
    }

    public void setHebrew_value(String hebrew_value) {
        Hebrew_value = hebrew_value;
    }

    public void setItalian_value(String italian_value) {
        Italian_value = italian_value;
    }

    @NonNull
    @Override
    public String toString() {
        return super.toString();
    }

}