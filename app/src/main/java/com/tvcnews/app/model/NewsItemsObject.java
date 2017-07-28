package com.tvcnews.app.model;

import android.graphics.drawable.Drawable;

/**
 * Created by iFwAxTel on 19/02/2017.
 */

public class NewsItemsObject {

    boolean checked;
    private String title;
    private String body;
    private Drawable image;
    private boolean isAward;


    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Drawable getImage() {
        return image;
    }

    public void setImage(Drawable image) {
        this.image = image;
    }

    public boolean isAward() {
        return isAward;
    }

    public void setAward(boolean award) {
        isAward = award;
    }
}
