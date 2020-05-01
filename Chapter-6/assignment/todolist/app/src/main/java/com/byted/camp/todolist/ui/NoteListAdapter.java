package com.byted.camp.todolist.ui;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.byted.camp.todolist.MainActivity;
import com.byted.camp.todolist.NoteOperator;
import com.byted.camp.todolist.R;
import com.byted.camp.todolist.beans.Note;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2019/1/23.
 *
 * @author xuyingyi@bytedance.com (Yingyi Xu)
 */
public class NoteListAdapter extends RecyclerView.Adapter<NoteViewHolder> {

//    private final NoteOperator operator;
    private final MainActivity.Adapter operator;
    private final List<Note> notes = new ArrayList<>();

//    public NoteListAdapter(NoteOperator operator) {
//        this.operator = operator;
//    }
    public NoteListAdapter(MainActivity.Adapter adapter) { this.operator = adapter; }

    public void refresh(List<Note> newNotes) {
        notes.clear();
        if (newNotes != null) {
            notes.addAll(newNotes);
        }
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int pos) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_note, parent, false);
        return new NoteViewHolder(itemView, operator);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int pos) {
        int priority = notes.get(pos).getPriority();
        switch (priority){
            case 1:
                holder.itemView.setBackgroundColor(Color.RED);
                break;
            case 2:
                holder.itemView.setBackgroundColor(Color.GREEN);
                break;
            case 3:
                holder.itemView.setBackgroundColor(Color.BLUE);
                break;
            default:
                break;
        }
        holder.bind(notes.get(pos));
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }
}
