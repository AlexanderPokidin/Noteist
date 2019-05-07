package com.pokidin.a.noteist.entity;

public class Note {
    private String text;
    private String date;
    private String time;

    public Note(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
