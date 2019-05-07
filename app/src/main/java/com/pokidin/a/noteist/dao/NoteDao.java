package com.pokidin.a.noteist.dao;

import com.pokidin.a.noteist.entity.Note;

import java.util.List;

public interface NoteDao {
    void setNewNote(Note note);

    List<Note> getAllNotes();

    Note getNoteAtPosition(int position);

    void removeNoteAtPosition(int position);
}
