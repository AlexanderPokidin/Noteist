package com.pokidin.a.noteist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.pokidin.a.noteist.db.NoteDatabase;

import java.util.List;

public class NoteDetailsActivity extends AppCompatActivity {

    private Button mButton;
    private EditText mText;
    private NoteDatabase mDatabase;
    private List<Note> mNotes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_details);

        mDatabase = NoteDatabase.getInstance();
        mText = findViewById(R.id.et_text);

        mButton = findViewById(R.id.btn_done);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tmp = String.valueOf(mText.getText());
                onBackPressed();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        mDatabase.setNewNote(getUserText(mText));
        Intent intent = new Intent(NoteDetailsActivity.this, MainActivity.class);
        startActivity(intent);
    }

    private Note getUserText(EditText editText) {
        String userText = String.valueOf(editText.getText());
        return new Note(userText, null, null);
    }

    private void addNote(Note note) {
        mNotes = mDatabase.getAllNotes();
        mNotes.add(note);
    }
}
