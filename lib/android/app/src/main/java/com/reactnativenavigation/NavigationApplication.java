package com.reactnativenavigation;

import android.app.Application;
import android.content.Context;
import android.support.annotation.Nullable;

import com.facebook.react.ReactApplication;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.reactnativenavigation.react.ReactGateway;

import java.util.List;

public abstract class NavigationApplication extends Application implements ReactApplication, AppModule {

	private ReactGateway reactGateway;

    public static AppModule get(Context context) {
        return (AppModule) context.getApplicationContext();
    }

	@Override
	public void onCreate() {
		super.onCreate();
		reactGateway = new ReactGateway(this, isDebug(), createAdditionalReactPackages());
	}

	public ReactGateway getReactGateway() {
		return reactGateway;
	}

	@Override
	public ReactNativeHost getReactNativeHost() {
		return getReactGateway().getReactNativeHost();
	}

	@Nullable
    @Override
    public EventDispatcher getEventDispatcher() {
        ReactContext reactContext = getReactNativeHost().getReactInstanceManager().getCurrentReactContext();
        return reactContext == null ? null : reactContext.getNativeModule(UIManagerModule.class).getEventDispatcher();
    }

	public abstract boolean isDebug();

	@Nullable
	public abstract List<ReactPackage> createAdditionalReactPackages();
}
