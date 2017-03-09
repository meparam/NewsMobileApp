package com.tvcnews.app.util;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

/**
 * Created by iFwAxTel on 06/01/2017.
 */
public class GetDeviceMetrics {
    Context context;
    public GetDeviceMetrics(Context mContext){
        this.context = mContext;
    }
    public DisplayMetrics getMetrics(){
        DisplayMetrics metrics = new DisplayMetrics();
        WindowManager wm = (WindowManager)context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        display.getMetrics(metrics);
        return metrics;
    }
}
