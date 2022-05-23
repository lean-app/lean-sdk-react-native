package com.reactnativeleansdk;

import android.view.View;

import androidx.annotation.NonNull;
import kotlin.Function;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.events.RCTEventEmitter;

import java.util.HashMap;
import java.util.Map;
import com.lean.leansdk.LeanView;
import com.lean.leansdk.EventFuncInterface;

public class LeanSdkViewManager extends SimpleViewManager<View> {
    public static final String REACT_CLASS = "LeanSdkView";
    private LeanView leanView;

    @Override
    @NonNull
    public String getName() {
        return REACT_CLASS;
    }

    @Override
    @NonNull
    public View createViewInstance(ThemedReactContext reactContext) {
      EventFuncInterface fn =
        parameter -> {
          WritableMap event = Arguments.createMap();
          WritableMap action = Arguments.createMap();
          action.putString("action", parameter);
          event.putMap("data", action);
          reactContext
            .getJSModule(RCTEventEmitter.class)
            .receiveEvent(leanView.getId(), "topChange", event);
        };
      leanView = new LeanView(reactContext, null, null, null, fn);
      return leanView;
    }

    @ReactProp(name = "userToken")
    public void setUserToken(View view, String userToken) {
      leanView.setToken(userToken);
      leanView.refresh();
    }

    @ReactProp(name = "options")
    public void setOptions(View view, ReadableMap options) {
      leanView.setOptions(options.toHashMap());
      leanView.refresh();
    }

    @ReactProp(name = "theme")
    public void setTheme(View view, ReadableMap theme) {
      leanView.setTheme(theme.toHashMap());
      leanView.refreshStyles();
    }

    public Map getExportedCustomBubblingEventTypeConstants() {
      return MapBuilder.builder().put(
        "topChange",
        MapBuilder.of(
          "phasedRegistrationNames",
          MapBuilder.of("bubbled", "onLeanEvent")
        )
      ).build();
    }
}
