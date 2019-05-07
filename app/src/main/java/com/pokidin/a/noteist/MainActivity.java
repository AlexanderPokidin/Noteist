package com.pokidin.a.noteist;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.pokidin.a.noteist.db.NoteDatabase;
import com.pokidin.a.noteist.entity.Note;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final String POSITION = "position";
    private List<Note> allNotes;
    private NoteDatabase mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mDatabase = NoteDatabase.getInstance();
        allNotes = mDatabase.getAllNotes();

        RecyclerView recyclerView = findViewById(R.id.rv_list);
        final NoteListAdapter adapter = new NoteListAdapter(this, allNotes);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter.setOnItemClickListener(new NoteListAdapter.ClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                // Pass "position" as an Extra argument to open a new Activity with text.
                startSecondActivity(position);
            }
        });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Pass 0 as an Extra argument to open a new Activity with an empty field.
                startSecondActivity(0);
            }
        });
    }

    private void startSecondActivity(int position){
        Intent intent = new Intent(getApplicationContext(), NoteDetailsActivity.class);
        intent.putExtra(POSITION, position);
        startActivity(intent);
        finish();
    }
}
