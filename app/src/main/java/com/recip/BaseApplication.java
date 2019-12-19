package com.recip;

import android.app.Application;

import com.microsoft.appcenter.AppCenter;
import com.microsoft.appcenter.analytics.Analytics;
import com.microsoft.appcenter.crashes.Crashes;

import io.realm.Realm;
import io.realm.RealmConfiguration;
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

        AppCenter.start(this, "5e5f581e-ef97-46a8-9558-7b35b197449a",
                Analytics.class, Crashes.class);

        Realm.init(this);
        RealmConfiguration configuration = new RealmConfiguration.Builder()
                .name("recipes")
                .build();
        Realm.setDefaultConfiguration(configuration);

    }
}
