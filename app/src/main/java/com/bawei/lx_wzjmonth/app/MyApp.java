package com.bawei.lx_wzjmonth.app;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;


/**
 * Created by Zhang on 2017/11/9.
 */

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Fresco.initialize(this);


    }

}
