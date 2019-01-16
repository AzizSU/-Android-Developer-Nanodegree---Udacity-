package com.example.android.tourgauide;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Alarfaj on 8/14/17.
 */

public class LocationAdapter extends ArrayAdapter<Location> {

    private int colorId;

    public LocationAdapter(Activity context, ArrayList<Location> words, int colorId) {
        super(context, 0, words);
        this.colorId = colorId;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_of_locations, parent, false);
        }

        Location locationItem = getItem(position);
        TextView locname = (TextView) listItemView.findViewById(R.id.loc_name);
        locname.setText(locationItem.getLocName());

        TextView locLoc = (TextView) listItemView.findViewById(R.id.loce_loc);
        locLoc.setText(locationItem.getLoclocatin());

        ImageView locIMge = (ImageView) listItemView.findViewById(R.id.image);
        if(locationItem.hasImage()) {
            locIMge.setImageResource(locationItem.getImgRes());
            locIMge.setVisibility(View.VISIBLE);
        }
        else {
            locIMge.setVisibility(View.GONE);
        }

        return listItemView;
    }
}
