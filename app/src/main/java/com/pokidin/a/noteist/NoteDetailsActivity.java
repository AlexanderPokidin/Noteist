package com.pokidin.a.noteist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NoteDetailsActivity extends AppCompatActivity {

    private Button mButton;
    private EditText mText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_details);

        mText = findViewById(R.id.et_text);

        mButton = findViewById(R.id.btn_done);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tmp = String.valueOf(mText.getText());
                Toast toast = Toast.makeText(getApplicationContext(), tmp, Toast.LENGTH_LONG);
                toast.show();
            }
        });
    }
}
