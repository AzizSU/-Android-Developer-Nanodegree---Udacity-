package com.example.android.project7;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import java.util.List;


public class BookAdapter extends ArrayAdapter<Book> {

    public BookAdapter(Context context, List<Book> books) {
        super(context, 0, books);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.book_items_list, parent, false);
        }
        Book book = getItem(position);
        TextView nameOftheBook = (TextView) listItemView.findViewById(R.id.bookname);
        TextView nameOftheAuther = (TextView) listItemView.findViewById(R.id.aothur_name);
        nameOftheBook.setText(book.getName());
        nameOftheAuther.setText(book.getAuthor());

        return listItemView;
    }
}