package com.example.aaaaaaaa;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.UUID;

@Entity(tableName = "Notfication")
public class Notfication implements Serializable {

    @NotNull
    @PrimaryKey
    public UUID id;

    @ColumnInfo(name="Title")
    public String title;

    @ColumnInfo(name="Text")
    public String text;

    @ColumnInfo(name="Time")
    public String time;



    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public Notfication(@NotNull UUID id, String title, String text, String time) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.time = time;
    }

    public void setTime(String time) {
        this.time = time;
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
