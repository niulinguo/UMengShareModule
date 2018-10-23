package com.niles.umengsharemodule;

import android.app.Application;

import com.niles.umeng.UMengConfig;
import com.niles.umeng.UMengManager;

/**
 * Created by Niles
 * Date 2018/10/22 22:11
 * Email niulinguo@163.com
 */
public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        UMengManager.init(this, BuildConfig.DEBUG, new UMengConfig.Builder()
                .setAppkey("")
                .build());
    }
}
