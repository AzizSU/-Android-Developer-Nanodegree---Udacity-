package com.example.android.project8;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.List;
import static com.example.android.project8.QueryUtils.flag;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<Story>> {
    private StoryAdapter mAdapter ;
    private static int LOADER_ID = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView storesList = (ListView) findViewById(R.id.list);
        mAdapter = new StoryAdapter(this);
        storesList.setAdapter(mAdapter);
        storesList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Story stories = mAdapter.getItem(i);
                String url = stories.getUrl();
                Intent mIntent = new Intent(Intent.ACTION_VIEW);
                mIntent.setData(Uri.parse(url));
                startActivity(mIntent);
            }
        });
        getSupportLoaderManager().initLoader(LOADER_ID, null, MainActivity.this);
    }

    @Override
    public Loader<List<Story>> onCreateLoader(int id, Bundle args) {
        return new StoryLoader(this);
    }

    @Override
    public void onLoadFinished(android.support.v4.content.Loader<List<Story>> loader, List<Story> data) {
        if (data != null) {
            mAdapter.clear();
            mAdapter.addAll(data);
        }
        if (flag) {
            TextView noDatatxt = (TextView) findViewById(R.id.noData);
            noDatatxt.setText("No connection, please try again");
            RelativeLayout noDataParent = (RelativeLayout) findViewById(R.id.noDataParent);
            noDataParent.setVisibility(View.VISIBLE);
            flag = false;
        }
    }

    @Override
    public void onLoaderReset(Loader<List<Story>> loader) {
        mAdapter.clear();
    }
}
