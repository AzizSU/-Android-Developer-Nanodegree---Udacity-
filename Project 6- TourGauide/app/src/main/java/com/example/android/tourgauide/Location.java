package com.example.android.tourgauide;

/**
 * Created by Alarfaj on 8/14/17.
 */

public class Location {

    private String locName;
    private String loclocatin;
    private String locDesc;
    private static final int NO_IMAGE = -1;
    private int imgRes = NO_IMAGE;

    public String getLocDesc() {
        return locDesc;
    }

    public void setLocDesc(String locDesc) {
        this.locDesc = locDesc;
    }

    public Location(String locName, String loclocatin, String locDesc , int imgRes){
        this.locName = locName;
        this.loclocatin = loclocatin;
        this.imgRes = imgRes;
        this.locDesc=locDesc;

    }

    public Location(String locName, String loclocatin, String locDesc ){
        this.locName = locName;
        this.loclocatin = loclocatin;
        this.locDesc=locDesc;
    }

    public String getLocName() {

        return locName;
    }

    public String getLoclocatin() {
        return loclocatin;
    }

    public int getImgRes() {
        return imgRes;
    }

    public boolean hasImage() {
        return  imgRes != NO_IMAGE;
    }
}
