package com.example.android.project7;

/**
 * Created by Alarfaj on 9/17/17.
 */

public class Book   {
    String name;
    String author;


    public Book(String name, String author) {
        this.name=name;
        this.author = author;
    }

    public String getAuthor() {

        return author;
    }

    public String getName() {

        return name;
    }
}
