package com.imfunc.flutter_minemap;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.minedata.minemap.MinemapAccountManager;
import com.minedata.minemap.camera.CameraPosition;
import com.minedata.minemap.geometry.LatLng;
import com.minedata.minemap.map.MapView;
import com.minedata.minemap.map.MineMap;
import com.minedata.minemap.overlay.ClusterLayer;
import com.minedata.minemap.overlay.ClusterLayerOptions;

import java.util.Map;

import io.flutter.Log;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
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