package com.byted.camp.todolist;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.byted.camp.todolist.beans.Note;

import java.util.List;

/**
 * Created on 2019/1/23.
 *
 * @author xuyingyi@bytedance.com (Yingyi Xu)
 */
@Dao
public interface NoteOperator {

    @Query("SELECT * FROM todo_list ORDER BY priority DESC")
    List<Note> getAll();

    @Insert
    void insertAll(Note... notes);

    @Delete
    void deleteNote(Note note);

    @Update
    void updateNote(Note note);
}
