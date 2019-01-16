package com.example.android.project8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;


public class StoryAdapter  extends ArrayAdapter<Story> {

    public StoryAdapter(Context context) {
        super(context, -1, new ArrayList<Story>());
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list, parent, false);
        }
        Story story = getItem(position);
        TextView nameOftheStory = (TextView) listItemView.findViewById(R.id.title);
        TextView nameOftheSection = (TextView) listItemView.findViewById(R.id.section);
        TextView theDate = (TextView) listItemView.findViewById(R.id.Date);
        nameOftheStory.setText(story.getTitle());
        nameOftheSection.setText("Section: "+story.getSection());
        theDate.setText(story.getDate());
        return listItemView;
    }
}