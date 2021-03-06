package com.imfunc.flutter_minemap.views.mapHandler;

import android.content.Context;
import android.text.TextUtils;

import com.imfunc.flutter_minemap.FMMMapController;
import com.imfunc.flutter_minemap.unil.Constants;
import com.imfunc.flutter_minemap.unil.conveter.FMMMapConveter;
import com.minedata.minemap.geometry.LatLng;
import com.minedata.minemap.map.MineMap;

import java.util.Map;

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
            case Constants.FMMMapStateMethodId.sMapSetCenterMethod:
                setCenter(call, result);
                break;
            case Constants.FMMMapStateMethodId.sMapSetZoomMethod:
                setZoom(call, result);
                break;
            case Constants.FMMMapStateMethodId.sMapSetMinZoomPreferenceMethod:
                setMinZoom(call, result);
                break;
            case Constants.FMMMapStateMethodId.sMapSetMaxZoomPreferenceMethod:
                setMaxZoom(call, result);
                break;
            default:
                break;
        }
    }

    /**
     *
     * @param call
     * @param result
     */
    private void setMaxZoom(MethodCall call, MethodChannel.Result result) {
        Integer zoom = FMMMapConveter.toInt(call.arguments);
        if (zoom != null) {
            mMapController.setMaxZoomLevel(zoom);
            result.success(true);
        }
    }

    /**
     *
     * @param call
     * @param result
     */
    private void setMinZoom(MethodCall call, MethodChannel.Result result) {
        Integer zoom = FMMMapConveter.toInt(call.arguments);
        if (zoom != null) {
            mMapController.setMinZoomLevel(zoom);
            result.success(true);
        }
    }

    /**
     *
     * @param call
     * @param result
     */
    private void setZoom(MethodCall call, MethodChannel.Result result) {
        Integer zoom = FMMMapConveter.toInt(call.arguments);
        if (zoom != null) {
            mMapController.setZoomLevel(zoom);
            result.success(true);
        }
    }

    /**
     * @param call
     * @param result
     */
    private void setCenter(MethodCall call, MethodChannel.Result result) {
        LatLng center = FMMMapConveter.mapToLatlng((Map<String, Object>) call.arguments);
        mMapController.setCenter(center);
        result.success(true);
    }

    /**
     * ??????????????????
     *
     * @param call
     * @param result
     */
    private void setMapType(MethodCall call,
                            MethodChannel.Result result) {
        String mapType = call.arguments();

        mMapController.setMapType(mapType);

        result.success(true);
    }
}
