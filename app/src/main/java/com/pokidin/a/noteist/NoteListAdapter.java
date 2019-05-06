package com.pokidin.a.noteist;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class NoteListAdapter extends RecyclerView.Adapter<NoteListAdapter.NoteViewHolder> {
    private static ClickListener sClickListener;

    private final LayoutInflater mInflater;
    private List<Note> mNotes;

    public NoteListAdapter(Context context, List<Note> notes) {
        mInflater = LayoutInflater.from(context);
        mNotes = notes;
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = mInflater.inflate(R.layout.note_item, parent, false);
        return new NoteViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        if (mNotes != null) {
            Note current = mNotes.get(position);
            holder.mText.setText(current.getText());
            holder.mDate.setText(current.getDate());
            holder.mTime.setText(current.getTime());
        } else {
            holder.mText.setText("No note");
        }
    }

    @Override
    public int getItemCount() {
        if (mNotes != null) {
            return mNotes.size();
        } else {
            return 0;
        }
    }

    void setNotes(List<Note> notes) {
        mNotes = notes;
        notifyDataSetChanged();
    }

    public Note getNoteAtPosition(int position) {
        return mNotes.get(position);
    }

    class NoteViewHolder extends RecyclerView.ViewHolder {
        private final TextView mText;
        private final TextView mDate;
        private final TextView mTime;

        public NoteViewHolder(@NonNull final View itemView) {
            super(itemView);
            mText = itemView.findViewById(R.id.tv_text);
            mDate = itemView.findViewById(R.id.tv_date);
            mTime = itemView.findViewById(R.id.tv_time);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sClickListener.onItemClick(itemView, getAdapterPosition());
                }
            });
        }
    }

    public void setOnItemClickListener(ClickListener clickListener) {
        NoteListAdapter.sClickListener = clickListener;
    }

    public interface ClickListener {
        void onItemClick(View view, int position);
    }
}
