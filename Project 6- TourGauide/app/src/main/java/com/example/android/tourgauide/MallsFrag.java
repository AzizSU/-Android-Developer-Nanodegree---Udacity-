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


/**
 * Created by Alarfaj on 8/14/17.
 */

public class MallsFrag extends Fragment {


    @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.locatons, container, false);
            final ArrayList<Location> locations = new ArrayList<Location>();

            locations.add(new Location(getString(R.string.SaharaMall_name), getString(R.string.SaharaMall_adress), getString(R.string.SaharaMall_desc), R.drawable.launcher_sahara));
            locations.add(new Location(getString(R.string.HayatMall_name), getString(R.string.HayatMall_adress), getString(R.string.HayatMall_desc), R.drawable.launcher_hayat));
            locations.add(new Location(getString(R.string.KingdomMall_name), getString(R.string.KingdomMall_adress), getString(R.string.KingdomMall_desc), R.drawable.launcher));
            LocationAdapter itemsAdapter = new LocationAdapter(getActivity(), locations, R.color.colorAccent);
            ListView listView = (ListView) rootView.findViewById(R.id.locatinsList);
            listView.setAdapter(itemsAdapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> adapter, View view, int position, long arg) {
                    Intent i = new Intent(MallsFrag.this.getActivity(), LocationZoom.class);
                    i.putExtra(getString(R.string.NameKey), locations.get(position).getLocName());
                    i.putExtra(getString(R.string.DescKey), locations.get(position).getLocDesc());
                    i.putExtra(getString(R.string.LocationKey),locations.get(position).getLoclocatin());
                    startActivity(i);
                }
            });
            return rootView;
        }
}