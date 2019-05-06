package com.pokidin.a.noteist;

public class Note {
    private String text;
    private String date;
    private String time;

    public Note(String text, String date, String time) {
        this.text = text;
        this.date = date;
        this.time = time;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
