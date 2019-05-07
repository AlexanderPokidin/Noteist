package com.pokidin.a.noteist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.pokidin.a.noteist.db.NoteDatabase;

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
        setNoteTextToEt();

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

//    private Note getUserTextFromEt() {
//        String userText = String.valueOf(mText.getText());
//        return new Note(userText, null, null);
//    }

    private void setNoteTextToEt() {
        Intent intent = getIntent();
        int position = intent.getIntExtra(MainActivity.POSITION, 0);
        if (position > 0) {
            String currentText = mDatabase.getNoteAtPosition(position).getText();
            mText.setText(currentText);
            mDatabase.removeNoteAtPosition(position);
        }
    }

    private void updateDatabase(){
        String userText = String.valueOf(mText.getText());
        if (userText.length() > 0){
            mDatabase.setNewNote(new Note(userText, null, null));
        }
        Intent intent = new Intent(NoteDetailsActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
