package com.imfunc.flutter_minemap;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.imfunc.flutter_minemap.interfaces.MineMapInterface;
import com.imfunc.flutter_minemap.unil.Config;
import com.imfunc.flutter_minemap.unil.Constants;
import com.imfunc.flutter_minemap.unil.conveter.FMMMapConveter;
import com.minedata.minemap.MinemapAccountManager;
import com.minedata.minemap.camera.CameraPosition;
import com.minedata.minemap.geometry.LatLng;
import com.minedata.minemap.map.MapView;
import com.minedata.minemap.map.MineMap;
import com.minedata.minemap.map.UiSettings;
import com.minemap.minemapsdk.maps.ImplMineMapOptions;

import java.util.Map;

import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

public class FMMMapController implements MethodChannel.MethodCallHandler, Application.ActivityLifecycleCallbacks, MineMapInterface {

    private static MineMap mineMap;

    private Context mContext;

    private MapView mapView;

    private UiSettings uiSettings;

    private final Application application;

    private final MethodChannel mMethodChannel;

    public FMMMapController(int id, Context context, BinaryMessenger binaryMessenger, Map<String, Object> creationParams) {

        mContext = context;

        this.application = ((Application) (context.getApplicationContext()));
        this.application.registerActivityLifecycleCallbacks(this);

        mMethodChannel = new MethodChannel(binaryMessenger,
                Constants.VIEW_METHOD_CHANNEL_PREFIX + id);
        mMethodChannel.setMethodCallHandler(this);

        initMap(creationParams);
    }

    ///  初始化地图组件
    private void initMap(Map<String, Object> creationParams) {
        String accessToken = creationParams.get("accessToken").toString();
        String offlineAccessToken = creationParams.get("offlineAccessToken").toString();
        String solution = creationParams.get("solution").toString();

        MinemapAccountManager.getInstance(application, accessToken,
                offlineAccessToken,
                solution);

        mapView = new MapView(mContext);

        mapView.addMapRenderCallback(new MapView.OnMapReadyListener() {
            @Override
            public void onMapReady(final MineMap oMineMap) {
                mineMap = oMineMap;

                mineMap.setStyleUrl(Config.mBase);
                mineMap.setCameraPosition(
                        new CameraPosition.Builder()
                                // 设置相机指向的位置
                                .target(new LatLng(38.913828, 116.405419))
                                // 设置相机缩放等级
                                .zoom(13)
                                // 设置相机的俯视角度
                                .tilt(0)
                                // 摄像机指向的方向,从北部顺时针方向设置
                                .bearing(0)
                                .build());
            }
        });

        mapView.onStart();

        if (mineMap != null) {
            uiSettings = mineMap.getUiSettings();
        }
    }

    public MapView getMapView() {
        return mapView;
    }

    public MethodChannel getMethodChannel() {
        return mMethodChannel;
    }

    @Override
    public void onMethodCall(@NonNull MethodCall call, @NonNull MethodChannel.Result result) {

    }

    @Override
    public void setMapType(Integer mapType) {
        if (mineMap != null && mapType != null) {
            String url;
            if (mapType == 0) {
                url = Config.mBase;
            } else if (mapType == 1) {
                url = Config.mBlack;
            } else {
                url = Config.mGPS;
            }
            mineMap.setStyleUrl(url);
        }
    }

    @Override
    public void setTrafficEnabled(Boolean enabled) {
        if (mineMap != null && enabled != null) {
            mineMap.setTrafficShow(enabled);
        }
    }

    @Override
    public void setTrafficRote(int trafficRote) {
        if (mineMap != null) {
            mineMap.setTrafficRote(trafficRote);
        }
    }

    @Override
    public void setCenter(LatLng latLng) {
        if (mineMap != null && latLng != null) {
            mineMap.setLatLng(latLng);
        }
    }

    @Override
    public void setZoomLevel(int zoomLevel) {
        if (mineMap != null) {
            mineMap.setZoom(zoomLevel);
        }
    }

    @Override
    public void setMinZoomLevel(int minZoomLevel) {
        if (mineMap != null) {
            mineMap.setMinZoomPreference(minZoomLevel);
        }
    }

    @Override
    public void setMaxZoomLevel(int maxZoomLevel) {
        if (mineMap != null) {
            mineMap.setMaxZoomPreference(maxZoomLevel);
        }
    }

    @Override
    public void setTilt(int tilt) {
        if (mineMap != null) {
            mineMap.setTilt(tilt);
        }
    }

    @Override
    public void setBearing(int bearing) {
        if (mineMap != null) {
            mineMap.setBearing(bearing);
        }
    }

    @Override
    public void setWmtsEnabled(Boolean enabled) {
        if (mineMap != null && enabled != null) {
            mineMap.setWmtsEnabled(enabled);
        }
    }

    @Override
    public void setRepaint(Boolean repaint) {
        if (mineMap != null && repaint != null) {
            mineMap.setRepaint(repaint);
        }
    }

    @Override
    public void setShowDebugActive(Boolean showDebugActive) {
        if (mineMap != null && showDebugActive != null) {
            mineMap.setDebugActive(showDebugActive);
        }
    }

    @Override
    public void setFillWaterEnabled(Boolean enabled) {
        if (mineMap != null && enabled != null) {
            mineMap.setFillWaterEnabled(enabled);
        }
    }

    @Override
    public void setConnected(Boolean connected) {
        if (mineMap != null && connected != null) {
            MinemapAccountManager.setConnected(connected);
        }
    }

    @Override
    public void setCompassEnabled(Boolean enabled) {
        if (mineMap != null && enabled != null) {
            uiSettings.setCompassEnabled(enabled);
        }
    }

    @Override
    public void setLogoEnabled(Boolean enabled) {
        if (mineMap != null && enabled != null) {
            mineMap.getUiSettings().setLogoEnabled(enabled);
        }
    }

    @Override
    public void setAttributionEnabled(Boolean enabled) {
        if (mineMap != null && enabled != null) {
            uiSettings.setAttributionEnabled(enabled);
        }
    }

    @Override
    public void setScaleEnabled(Boolean enabled) {
        if (mineMap != null && enabled != null) {
            uiSettings.setScaleEnabled(enabled);
        }
    }

    @Override
    public void setRotateGesturesEnabled(Boolean enabled) {
        if (mineMap != null && enabled != null) {
            uiSettings.setRotateGesturesEnabled(enabled);
        }
    }

    @Override
    public void setTiltGesturesEnabled(Boolean enabled) {
        if (mineMap != null && enabled != null) {
            uiSettings.setTiltGesturesEnabled(enabled);
        }
    }

    @Override
    public void setZoomGesturesEnabled(Boolean enabled) {
        if (mineMap != null && enabled != null) {
            uiSettings.setZoomGesturesEnabled(enabled);
        }
    }

    @Override
    public void setZoomControlsEnabled(Boolean enabled) {
        if (mineMap != null && enabled != null) {
            uiSettings.setZoomControlsEnabled(enabled);
        }
    }

    @Override
    public void setDoubleTapGesturesEnabled(Boolean enabled) {
        if (mineMap != null && enabled != null) {
            uiSettings.setDoubleTapGesturesEnabled(enabled);
        }
    }

    @Override
    public void setScrollGesturesEnabled(Boolean enabled) {
        if (mineMap != null && enabled != null) {
            uiSettings.setScrollGesturesEnabled(enabled);
        }
    }

    @Override
    public void setAllGesturesEnabled(Boolean enabled) {
        if (mineMap != null && enabled != null) {
            uiSettings.setAllGesturesEnabled(enabled);
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
}
