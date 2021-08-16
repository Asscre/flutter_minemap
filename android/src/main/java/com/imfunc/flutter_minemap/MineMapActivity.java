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

import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.platform.PlatformView;

public class MineMapActivity implements PlatformView, Application.ActivityLifecycleCallbacks, MethodChannel.MethodCallHandler {

    MapView mapView;
    private static MineMap mineMap;
    Application application;
    MethodChannel methodChannel;
    Context mContext;
    ClusterLayer clusterLayer;
    private ClusterLayerOptions options;
    private Boolean isCanShowMap = false;
    private TextView textView;


    public MineMapActivity(@NonNull Context context, int viewId, BinaryMessenger messenger, @Nullable Map<String, Object> creationParams) {
        this.mContext = context;
        this.application = ((Application) (context.getApplicationContext()));
        this.application.registerActivityLifecycleCallbacks(this);

        methodChannel = new MethodChannel(messenger, "flutter_minemap_view_" + viewId);
        methodChannel.setMethodCallHandler(this);
        initMap(creationParams);
    }

    private void initMap(Map<String, Object> creationParams) {
        String accessToken = creationParams.get("accessToken").toString();
        String offlineAccessToken = creationParams.get("offlineAccessToken").toString();
        String solution = creationParams.get("solution").toString();

        if (accessToken.isEmpty() || offlineAccessToken.isEmpty() || solution.isEmpty()) {
            textView = new TextView(mContext);
            textView.setText("请正确传入accessToken、offlineAccessToken、solution");
            textView.setTextColor(0x000000);
        } else {
            isCanShowMap = true;
            MinemapAccountManager.getInstance(application, accessToken,
                    offlineAccessToken,
                    solution);

            mapView = new MapView(mContext);
            mapView.addMapRenderCallback(new MapView.OnMapReadyListener() {
                @Override
                public void onMapReady(final MineMap mineMap) {
                    MineMapActivity.mineMap = mineMap;
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

    }

    @Override
    public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
    }

    @Override
    public void onActivityStarted(@NonNull Activity activity) {

    }

    @Override
    public void onActivityResumed(@NonNull Activity activity) {

    }

    @Override
    public void onActivityPaused(@NonNull Activity activity) {

    }

    @Override
    public void onActivityStopped(@NonNull Activity activity) {

    }

    @Override
    public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {

    }

    @Override
    public void onActivityDestroyed(@NonNull Activity activity) {

    }

    @Override
    public void onMethodCall(@NonNull MethodCall call, @NonNull MethodChannel.Result result) {

    }

    @Override
    public View getView() {
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                requestLocationPermission();
//            }
//        }, 1000);
        if (isCanShowMap) {
            return mapView;
        } else {
            return textView;
        }

    }

    @Override
    public void dispose() {

    }
}