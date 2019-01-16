package com.example.android.tourgauide;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import static com.example.android.tourgauide.R.layout.location_zoom;


/**
 * Created by Alarfaj on 8/14/17.
 */

public class LocationZoom extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(location_zoom);
        TextView nameOfLocation = (TextView) findViewById(R.id.nameOfLocation);
        TextView descOfLocation = (TextView) findViewById(R.id.descOfLocation);
        TextView locOfLoc = (TextView) findViewById(R.id.locOfLoc);

        Bundle bundle = getIntent().getExtras();
        if(bundle!=null){
            String NameofLocationText = bundle.getString(getString(R.string.NameKey));
            String descOfLocationText = bundle.getString(getString(R.string.DescKey));
            String locOfLocText = bundle.getString(getString(R.string.LocationKey));

            if(NameofLocationText!=null && descOfLocationText!=null && locOfLocText!=null ){
                nameOfLocation.setText(NameofLocationText);
                descOfLocation.setText(descOfLocationText);
                locOfLoc.setText(locOfLocText);
            } }
    }
}
