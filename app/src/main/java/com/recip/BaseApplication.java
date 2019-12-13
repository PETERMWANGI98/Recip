package com.recip;

import android.app.Application;

import com.recip.BuildConfig;

import io.sentry.Sentry;
import io.sentry.android.AndroidSentryClientFactory;
import timber.log.Timber;

public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
        Sentry.init("https://bfbe326ed92945da91d6de9749e2af8c@sentry.io/1855991",
                new AndroidSentryClientFactory(this));

    }
}
