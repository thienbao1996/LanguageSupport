package com.thienbao.localizedemo;

import android.app.Application;
import android.content.Context;

import com.thienbao.localizedemo.utils.LocaleHelper;

public class MyApplication extends Application {
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(LocaleHelper.onAttach(base, "en"));
    }
}
