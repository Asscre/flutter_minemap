package com.imfunc.flutter_minemap.views;

import android.content.Context;

import com.imfunc.flutter_minemap.FMMMapController;
import com.imfunc.flutter_minemap.unil.Config;
import com.imfunc.flutter_minemap.unil.Constants;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

public class FMMMapHandler {

    FMMMapController mFmmMapController;

    public FMMMapHandler(FMMMapController fmmMapController) {
        init(fmmMapController);
    }

    private void init(FMMMapController fmmMapController) {
        this.mFmmMapController = fmmMapController;
    }

    public void dispatchMethodHandler(MethodCall call,
                                      MethodChannel.Result result) {

        String methodId = call.method;
        switch (methodId) {
            case Constants.FMMMapStateMethodId.sMapSetStyleMethod:
                setMapType(call, result);
                break;
            default:
                result.error(null, "没有找到对应的方法", "error");
        }
    }

    /// 设置地图样式
    private void setMapType(MethodCall call,
                            MethodChannel.Result result) {
        Integer mapType = call.arguments();

        if (mFmmMapController.getMineMap() != null && mapType != null) {
            String url;
            if (mapType == 0) {
                url = Config.mBase;
            } else if (mapType == 1) {
                url = Config.mBlack;
            } else {
                url = Config.mGPS;
            }
            mFmmMapController.getMineMap().setStyleUrl(url);
            result.success(true);
        }
    }
}
