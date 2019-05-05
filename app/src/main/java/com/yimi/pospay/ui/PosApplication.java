package com.yimi.pospay.ui;

import android.app.Application;

/**
 * @author: lj
 * Date: 2019/5/5 16:12
 */
public class PosApplication extends Application {
    private static volatile PosApplication instance = null;

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;
    }

    public static PosApplication getInstance() {
        return instance;
    }
}
