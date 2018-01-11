package com.reactnativenavigation;

import android.app.*;

import com.facebook.react.uimanager.events.EventDispatcher;

import org.mockito.Mockito;

public class TestApplication extends Application implements AppModule {
    @Override
    public void onCreate() {
        super.onCreate();
        setTheme(R.style.Theme_AppCompat);
    }

    @Override
    public EventDispatcher getEventDispatcher() {
        return Mockito.mock(EventDispatcher.class);
    }
}
