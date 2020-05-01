package com.byted.camp.todolist.beans;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created on 2019/1/23.
 *
 * @author xuyingyi@bytedance.com (Yingyi Xu)
 */
@Entity(tableName = "todo_list")
public class Note {

    @PrimaryKey(autoGenerate = true)
    public long id;

    @ColumnInfo(name = "date")
    private String date;

    @ColumnInfo(name = "state")
    private int state;

    @ColumnInfo(name = "content")
    private String content;

    @ColumnInfo(name = "priority")
    private int priority;

    public Note() { }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getState() {
        return this.state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getPriority(){ return priority; }

    public void setPriority(int priority) { this.priority = priority; }
}
