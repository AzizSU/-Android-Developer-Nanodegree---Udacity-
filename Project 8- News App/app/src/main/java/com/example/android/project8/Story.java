package com.example.android.project8;


public class Story {
    private String title;
    private String date;
    private String section;
    private String url;

    public Story(String title, String section, String date, String url ) {
        this.title=title;
        this.section=section;
        this.date=date;
        this.url=url;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public String getSection() {
        return section;
    }

    public String getUrl() {
        return url;
    }
}
