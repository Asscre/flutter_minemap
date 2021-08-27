package com.imfunc.flutter_minemap.views.mapHandler;

import android.content.Context;

import com.imfunc.flutter_minemap.FMMMapController;
import com.minedata.minemap.map.MineMap;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

public abstract class MMapHandler {
    protected FMMMapController mMapController;
    protected MineMap mMineMap;

    public MMapHandler(FMMMapController mMapController) {
        this.mMapController = mMapController;
        if (mMapController != null) {
            this.mMineMap = mMapController.getMineMap();
        }
    }

    public abstract void handlerMethodCallResult(Context context, MethodCall call,
                                                 MethodChannel.Result result);

    public void clean() {
    }
}
