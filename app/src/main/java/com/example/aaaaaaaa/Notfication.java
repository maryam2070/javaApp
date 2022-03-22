package com.example.aaaaaaaa;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.UUID;

@Entity(tableName = "Notfication")
public class Notfication implements Serializable {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NotNull
    @PrimaryKey
    public int id;
    @ColumnInfo(name="Title")
    public String title;
    @ColumnInfo(name="Text")
    public String text;



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
