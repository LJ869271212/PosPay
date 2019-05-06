package com.yimi.pospay.ui;

import android.app.Application;
import android.content.Context;

/**
 * @author: lj
 * Date: 2019/5/5 16:12
 */
public class PosApplication extends Application {
    private static volatile PosApplication instance = null;
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;
        mContext = getApplicationContext();
    }

    public static PosApplication getInstance() {
        return instance;
    }

    public static Context getAppContext() {
        return mContext;
    }
}
