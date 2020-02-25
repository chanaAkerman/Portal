package com.example.portal.ui.Word_Package;

import androidx.annotation.NonNull;

public class Word {
    private String Hebrew_value;
    private String Hebrew_translating;
    private String Italian_value;
    private Type type;

    public Word(){}

    public Word(String h, String A, String I, Type type)
    {
        this.Hebrew_value = h;

        this.Hebrew_translating = A;
        this.Italian_value = I;
        this.type = type;
    }

    public String getHebrew_translating() {
        return Hebrew_translating;
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

    public void setHebrew_translating(String hebrew_translating) {
        Hebrew_translating = hebrew_translating;
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