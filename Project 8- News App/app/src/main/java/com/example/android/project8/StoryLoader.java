package com.example.android.project8;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;
import android.util.Log;
import java.io.IOException;
import java.net.URL;
import java.util.List;

public class StoryLoader  extends AsyncTaskLoader<List<Story>> {

    public StoryLoader(Context context) {
        super(context);
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }

    @Override
    public List<Story> loadInBackground() {
        List<Story> listOfStories = null;
        try {
            URL url = QueryUtils.createUrl();
            String jsonResponse = QueryUtils.makehttpRequest(url);
            listOfStories = QueryUtils.extractStories(jsonResponse);
        } catch (IOException e) {
            Log.e("StoryLoader", "Error Loader LoadInBackground: ", e);
        }
        return listOfStories;
    }
}
