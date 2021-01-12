package com.iblogstreet.googlepush;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * @author junwang
 * @date 2021/1/12 3:32 PM
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ARouter.openLog();
        ARouter.openDebug();
        ARouter.init(this);
    }
}
