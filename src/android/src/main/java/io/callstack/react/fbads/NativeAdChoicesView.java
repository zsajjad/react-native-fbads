package io.callstack.react.fbads;

import com.facebook.ads.NativeAd;
import com.facebook.ads.AdChoicesView;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.views.view.ReactViewGroup;


public class NativeAdChoicesView extends ReactViewGroup {
  private ReactContext mContext;


  public NativeAdChoicesView(ThemedReactContext context) {
    super(context);
    mContext = context;
  }

  public void setNativeAd(NativeAd nativeAd) {
    AdChoicesView adChoicesView = new AdChoicesView(mContext, nativeAd, true);
    adChoicesView.measure(500, 500);
    adChoicesView.layout(0, 150, 500, 650);
    adChoicesView.bringToFront();

    addView(adChoicesView);
  }
}
