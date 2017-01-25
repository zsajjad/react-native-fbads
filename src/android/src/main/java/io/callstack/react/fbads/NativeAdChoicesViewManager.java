
package io.callstack.react.fbads;


import com.facebook.ads.NativeAdsManager;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;

public class NativeAdChoicesViewManager extends SimpleViewManager<NativeAdChoicesView> {
  ReactApplicationContext mReactContext;


  public NativeAdChoicesViewManager(ReactApplicationContext context) {
    super();
    mReactContext = context;
  }

  @ReactProp(name = "adsManager")
  public void adsManager(NativeAdChoicesView view, String adsManagerId) {
    NativeAdManager adManager = mReactContext.getNativeModule(NativeAdManager.class);
    NativeAdsManager adsManager = adManager.getFBAdsManager(adsManagerId);

    view.setNativeAd(adsManager.nextNativeAd());
  }

  @Override
  protected NativeAdChoicesView createViewInstance(ThemedReactContext reactContext) {
    return new NativeAdChoicesView(reactContext);
  }


  @Override
  public String getName() {
    return "CTKAdChoicesView";
  }
}
