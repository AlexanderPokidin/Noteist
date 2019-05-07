package com.pokidin.a.noteist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.pokidin.a.noteist.db.NoteDatabase;
import com.pokidin.a.noteist.entity.Note;

public class NoteDetailsActivity extends AppCompatActivity {

    private Button mButton;
    private EditText mText;
    private NoteDatabase mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_details);

        mDatabase = NoteDatabase.getInstance();
        mText = findViewById(R.id.et_text);
        createNewNoteWithUserText();

        mButton = findViewById(R.id.btn_done);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        updateDatabase();
    }

    private void createNewNoteWithUserText() {
        Intent intent = getIntent();
        // If the Extra argument is larger than 0, fill in the EditText`s field.
        // Otherwise, leave the field blank.
        int position = intent.getIntExtra(MainActivity.POSITION, 0);
        if (position > 0) {
            String currentText = mDatabase.getNoteAtPosition(position).getText();
            mText.setText(currentText);
            mDatabase.removeNoteAtPosition(position);
        }
    }

    private void updateDatabase() {
        String userText = String.valueOf(mText.getText());
        if (userText.length() > 0) {
            mDatabase.setNewNote(new Note(userText));
        }
        Intent intent = new Intent(NoteDetailsActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
