package com.pokidin.a.noteist.db;

import com.pokidin.a.noteist.dao.NoteDao;
import com.pokidin.a.noteist.entity.Note;

import java.util.ArrayList;
import java.util.List;

public class NoteDatabase implements NoteDao {
    private static NoteDatabase instance;

    private List<Note> allNotes;

    private NoteDatabase() {
        allNotes = new ArrayList<>();
    }

    public static NoteDatabase getInstance() {
        if (instance == null) {
            instance = new NoteDatabase();
        }
        return instance;
    }

    // A new note is added to the 0 position,
    // to be displayed at the top of the list by default.
    @Override
    public void setNewNote(Note note) {
        allNotes.add(0, note);
    }

    @Override
    public List<Note> getAllNotes() {
        return allNotes;
    }

    @Override
    public Note getNoteAtPosition(int position) {
        return allNotes.get(position);
    }

    @Override
    public void removeNoteAtPosition(int position) {
        allNotes.remove(position);
    }
}
