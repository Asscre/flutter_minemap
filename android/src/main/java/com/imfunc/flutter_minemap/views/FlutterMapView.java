package com.imfunc.flutter_minemap.views;

import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;

import com.imfunc.flutter_minemap.FMMMapController;
import com.minedata.minemap.map.MapView;

import io.flutter.Log;
import io.flutter.plugin.platform.PlatformView;

public class FlutterMapView implements PlatformView {

    private static final String TAG = "FlutterMapView";

    private MapView mapView;

    private Context mContext;

    private FMMMapController mMapController;

    public FlutterMapView(@NonNull Context context, FMMMapController fmmMapController) {
        this.mContext = context;

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

    }
}