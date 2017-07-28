package com.tvcnews.app.model;

import android.graphics.drawable.Drawable;

/**
 * Created by iFwAxTel on 25/02/2017.
 */

public class ScheduleObject {
    private String title;
    private String anchor;
    private Drawable image;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Drawable getImage() {
        return image;
    }

    public void setImage(Drawable image) {
        this.image = image;
    }

    public String getAnchor() {
        return anchor;
    }

    public void setAnchor(String anchor) {
        this.anchor = anchor;
    }
}
