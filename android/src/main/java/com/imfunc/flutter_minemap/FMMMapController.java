package com.imfunc.flutter_minemap;

import android.content.Context;

import androidx.annotation.NonNull;

import com.imfunc.flutter_minemap.interfaces.MineMapInterface;
import com.minedata.minemap.camera.CameraPosition;
import com.minedata.minemap.geometry.LatLng;
import com.minedata.minemap.map.MapView;
import com.minedata.minemap.map.MineMap;
import com.minemap.minemapsdk.maps.ImplMineMapOptions;

import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

public class FMMMapController implements MethodChannel.MethodCallHandler, MineMapInterface {

    private static MineMap mineMap;
    private final Context mContext;
    private final MapView mapView;

    public FMMMapController(int id, Context context, BinaryMessenger binaryMessenger,
                            String viewType, ImplMineMapOptions options) {

        mContext = context;
        mapView = new MapView(mContext);

        mapView.addMapRenderCallback(new MapView.OnMapReadyListener() {
            @Override
            public void onMapReady(final MineMap mineMap) {
                FMMMapController.mineMap = mineMap;
                mineMap.setStyleUrl("http://minedata.cn/service/solu/style/id/15741", new MineMap.OnStyleLoadedListener() {

                    @Override
                    public void onStyleLoaded(String style) {
                        // 默认显示路况
                        mineMap.setTrafficShow(true);
                        // 60秒刷新一次
                        mineMap.setTrafficRote(60);
                    }
                });
                mineMap.setRepaint(false);
                mineMap.getUiSettings().setCompassEnabled(true);
                mineMap.setCameraPosition(
                        //39.897424, 116.356508  北京
                        new CameraPosition.Builder()
                                // 设置相机指向的位置
                                .target(new LatLng(39.897424, 116.356508))
                                // 设置相机缩放等级
                                .zoom(13)
                                // 设置相机的俯视角度
                                .tilt(0)
                                // 摄像机指向的方向,从北部顺时针方向设置
                                .bearing(0)
                                .build());
                mineMap.setDebugActive(false);
            }
        });

        mapView.onStart();
    }

    @Override
    public void onMethodCall(@NonNull MethodCall call, @NonNull MethodChannel.Result result) {

    }

    @Override
    public void setMapType(String mapType) {

    }

    @Override
    public void setTrafficEnabled(Boolean enabled) {

    }

    @Override
    public void setTrafficRote(int trafficRote) {

    }

    @Override
    public void setCenter(LatLng latLng) {

    }

    @Override
    public void setZoomLevel(int zoomLevel) {

    }

    @Override
    public void setMinZoomLevel(int minZoomLevel) {

    }

    @Override
    public void setMaxZoomLevel(int maxZoomLevel) {

    }

    @Override
    public void setTilt(int tilt) {

    }

    @Override
    public void setBearing(int bearing) {

    }

    @Override
    public void setWmtsEnabled(Boolean enabled) {

    }

    @Override
    public void setRepaint(Boolean repaint) {

    }

    @Override
    public void setShowDebugActive(Boolean showDebugActive) {

    }

    @Override
    public void setFillWaterEnabled(Boolean enabled) {

    }

    @Override
    public void setConnected(Boolean connected) {

    }

    @Override
    public void setCompassEnabled(Boolean enabled) {

    }

    @Override
    public void setLogoEnabled(Boolean enabled) {

    }

    @Override
    public void setAttributionEnabled(Boolean enabled) {

    }

    @Override
    public void setScaleEnabled(Boolean enabled) {

    }

    @Override
    public void setRotateGesturesEnabled(Boolean enabled) {

    }

    @Override
    public void setTiltGesturesEnabled(Boolean enabled) {

    }

    @Override
    public void setZoomGesturesEnabled(Boolean enabled) {

    }

    @Override
    public void setZoomControlsEnabled(Boolean enabled) {

    }

    @Override
    public void setDoubleTapGesturesEnabled(Boolean enabled) {

    }

    @Override
    public void setScrollGesturesEnabled(Boolean enabled) {

    }

    @Override
    public void setAllGesturesEnabled(Boolean enabled) {

    }
}
