package com.pokidin.a.noteist.db;

import com.pokidin.a.noteist.Note;

import java.util.ArrayList;
import java.util.List;

public class NoteDatabase {
    private static NoteDatabase instance;

    private List<Note> allNotes;

    private NoteDatabase() {
        allNotes = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            String tpm = i + " and a few more words, but for more than 100 letters. " +
                    "This is an important point and it must be checked. " +
                    "Somewhere here the words no longer fit into the list.";
            allNotes.add(new Note(tpm, (i + 1) + ".05.2005", "15:" + i));
        }
    }

    public static NoteDatabase getInstance() {
        if (instance == null) {
            instance = new NoteDatabase();
        }
        return instance;
    }

    public void setNewNote(Note note) {
        allNotes.add(note);
    }

    public List<Note> getAllNotes() {
        return allNotes;
    }
}
