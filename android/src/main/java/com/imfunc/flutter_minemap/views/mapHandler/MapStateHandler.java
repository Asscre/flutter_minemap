package com.imfunc.flutter_minemap.views.mapHandler;

import android.content.Context;
import android.text.TextUtils;

import com.imfunc.flutter_minemap.FMMMapController;
import com.imfunc.flutter_minemap.unil.Constants;
import com.minedata.minemap.map.MineMap;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

public class MapStateHandler extends MMapHandler {
    private static final String TAG = MapStateHandler.class.getSimpleName();
    private MineMap mineMap;
    
    

    public MapStateHandler(FMMMapController mMapController) {
        super(mMapController);
        mineMap = mMapController.getMineMap();
    }

    @Override
    public void handlerMethodCallResult(Context context, MethodCall call, MethodChannel.Result result) {
        if (null == call) {
            return;
        }
        String methodId = call.method;
        if (TextUtils.isEmpty(methodId)) {
            return;
        }

        switch (methodId) {
            case Constants.FMMMapStateMethodId.sMapSetStyleMethod:
                setMapType(call, result);
                break;
            default:
                break;
        }
    }

    /**
     * 设置地图样式
     * @param call
     * @param result
     */
    private void setMapType(MethodCall call,
                            MethodChannel.Result result) {
        Integer mapType = call.arguments();

        mMapController.setMapType(mapType);
        
        result.success(true);
    }
}
