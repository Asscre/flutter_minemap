package com.imfunc.flutter_minemap.views;

import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;

import com.imfunc.flutter_minemap.FMMMapController;
import com.imfunc.flutter_minemap.unil.conveter.FMMMapConveter;
import com.minedata.minemap.geometry.LatLng;
import com.minedata.minemap.map.MapView;

import java.util.Map;

import io.flutter.Log;
import io.flutter.plugin.platform.PlatformView;

public class FlutterMapView implements PlatformView {

    private static final String TAG = "FlutterMapView";

    private MapView mapView;

    private FMMMapController mMapController;

    public FlutterMapView(FMMMapController fmmMapController) {

        this.mMapController = fmmMapController;

        mapView = mMapController.getMapView();
    }

    @Override
    public View getView() {
        Log.d(TAG, "getView");
        return mapView;
    }

    @Override
    public void dispose() {
        Log.d(TAG, "dispose");

//        if (null != mMapController) {
//            mMapController.release();
//        }
//
//        if (null != mapView) {
//            mapView.onDestroy();
//            mapView = null;
//        }
    }
}