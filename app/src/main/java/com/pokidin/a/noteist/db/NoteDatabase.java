package com.pokidin.a.noteist.db;

import com.pokidin.a.noteist.entity.Note;

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
            allNotes.add(new Note(tpm));
        }
    }

    public static NoteDatabase getInstance() {
        if (instance == null) {
            instance = new NoteDatabase();
        }
        return instance;
    }

    // A new note is added to the 0 position,
    // to be displayed at the top of the list by default.
    public void setNewNote(Note note) {
        allNotes.add(0, note);
    }

    public List<Note> getAllNotes() {
        return allNotes;
    }

    public Note getNoteAtPosition(int position) {
        return allNotes.get(position);
    }

    public void removeNoteAtPosition(int position) {
        allNotes.remove(position);
    }
}
