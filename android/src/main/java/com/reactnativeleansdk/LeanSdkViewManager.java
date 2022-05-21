package com.reactnativeleansdk;

import android.graphics.Color;
import android.view.View;

import androidx.annotation.NonNull;

import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import java.util.HashMap;
import com.lean.leansdk.Lean;

public class LeanSdkViewManager extends SimpleViewManager<View> {
    public static final String REACT_CLASS = "LeanSdkView";

    @Override
    @NonNull
    public String getName() {
        return REACT_CLASS;
    }

    @Override
    @NonNull
    public View createViewInstance(ThemedReactContext reactContext) {

      Lean lean =  new Lean();
      HashMap<String, String> options = new HashMap<>();
      options.put("environment", "STAGING");
      String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6ImN1c3RvbWVyX3RialpvcjBOakwweVdINjI1X2NLViIsImVtYWlsIjoidGltK2N1c3RvbWVyNzMwQHdpdGhsZWFuLmNvbSIsImludGVyZmFjZUlkIjoiaW50ZXJmYWNlX09MVGFmTlY0QVM4NHNQNm1uQzFQMSIsInN0YXR1cyI6IkNPTkZJUk1FRCIsImlhdCI6MTY1MjgzNTcxNCwiZXhwIjoxNjUzNDQwNTE0fQ.EmMWNgI8IkvQIIa1VxGJeCUnLlx9HfukF6Kt8huQty4";
      return lean.viewCardInfo(reactContext, token, options);
    }

    @ReactProp(name = "color")
    public void setColor(View view, String color) {
        view.setBackgroundColor(Color.parseColor(color));
    }
}
