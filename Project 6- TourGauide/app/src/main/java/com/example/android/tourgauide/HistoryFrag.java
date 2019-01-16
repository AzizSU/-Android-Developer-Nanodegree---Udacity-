package com.example.android.tourgauide;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import static com.example.android.tourgauide.R.string.NameKey;

/**
 * Created by Alarfaj on 8/14/17.
 */

public class HistoryFrag extends Fragment{


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.locatons, container, false);
        final ArrayList<Location> locations = new ArrayList<Location>();
        locations.add(new Location(getString(R.string.National_name), getString(R.string.National_adress), getString(R.string.National_desc)));
        locations.add(new Location(getString(R.string.Abdulaziz_name), getString(R.string.Abdulaziz_adress) , getString(R.string.Abdulaziz_desc)));
        locations.add(new Location(getString(R.string.Masmak_name), getString(R.string.Masmak_adress) , getString(R.string.Masmak_desc)));
        LocationAdapter itemsAdapter = new LocationAdapter(getActivity(), locations, R.color.colorAccent);
        ListView listView = (ListView) rootView.findViewById(R.id.locatinsList);
        listView.setAdapter(itemsAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int position, long arg) {
                Intent i = new Intent(HistoryFrag.this.getActivity(), LocationZoom.class);
                i.putExtra(getString(R.string.NameKey), locations.get(position).getLocName());
                i.putExtra(getString(R.string.DescKey), locations.get(position).getLocDesc());
                i.putExtra(getString(R.string.LocationKey),locations.get(position).getLoclocatin());
                startActivity(i);
            }
        });
        return rootView;
    }
}