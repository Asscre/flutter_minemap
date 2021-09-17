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
import com.imfunc.flutter_minemap.views.mapHandler.MMapHandlerFactory;
import com.minedata.minemap.MinemapAccountManager;
import com.minedata.minemap.camera.CameraPosition;
import com.minedata.minemap.geometry.LatLng;
import com.minedata.minemap.map.MapView;
import com.minedata.minemap.map.MineMap;
import com.minedata.minemap.map.UiSettings;

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

    private MMapHandlerFactory mMapHandlerFactory;

    public FMMMapController(int id, Context context, BinaryMessenger binaryMessenger, Map<String, Object> creationParams) {

        this.mContext = context;

        this.application = ((Application) (context.getApplicationContext()));
        this.application.registerActivityLifecycleCallbacks(this);

        initMap(creationParams);

        mMethodChannel = new MethodChannel(binaryMessenger,
                Constants.VIEW_METHOD_CHANNEL_PREFIX + id);
        mMethodChannel.setMethodCallHandler(this);

        mMapHandlerFactory = new MMapHandlerFactory(this);
    }

    public void release() {
        mMethodChannel.setMethodCallHandler(null);
        mMapHandlerFactory.release();
    }

    ///  初始化地图组件
    private void initMap(final Map<String, Object> creationParams) {
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

//                mineMap.setStyleUrl(Config.mBase);
//                mineMap.setCameraPosition(
//                        new CameraPosition.Builder()
//                                // 设置相机指向的位置
//                                // 116.404844,39.912057
//                                .target(new LatLng(39.912057, 116.404269))
//                                // 设置相机缩放等级
//                                .zoom(8)
//                                // 设置相机的俯视角度
//                                .tilt(0)
//                                // 摄像机指向的方向,从北部顺时针方向设置
//                                .bearing(0)
//                                .build()
//                );
                uiSettings = mineMap.getUiSettings();
                setBaseMap(creationParams);
            }
        });

        mapView.onStart();
    }

    public MapView getMapView() {
        return mapView;
    }

    public MethodChannel getMethodChannel() {
        return mMethodChannel;
    }

    @Override
    public void onMethodCall(@NonNull MethodCall call, @NonNull MethodChannel.Result result) {
        if (null == mineMap) {
            return;
        }

        mMapHandlerFactory.dispatchMethodHandler(mContext, call, result);
    }

    public MineMap getMineMap() {
        return  mineMap;
    }
    
    private void setBaseMap(Map<String, Object> args) {
        if (args.containsKey("mapType") ) {
            String mapType = args.get("mapType").toString();
            if (mapType !=  null) {
                setMapType(mapType);
            } else {
                setMapType(Config.mBase);
            }
        }

        if (args.containsKey("trafficEnabled") ) {
            Boolean trafficEnabled = FMMMapConveter.toBoolean(args.get("trafficEnabled"));
            if (trafficEnabled != null) {
                setTrafficEnabled(trafficEnabled);
            }
        }

        if (args.containsKey("trafficRote") ) {
            Integer trafficRote = FMMMapConveter.toInt(args.get("trafficRote"));
            if (trafficRote != null) {
                setTrafficRote(trafficRote);
            }
        }

        if (args.containsKey("center") ) {
            LatLng center = FMMMapConveter.mapToLatlng((Map<String, Object>) args.get("center"));
            if (center != null) {
                setCenter(center);
            }
        }

        if (args.containsKey("zoomLevel") ) {
            Integer zoomLevel = FMMMapConveter.toInt(args.get("zoomLevel"));
            if (zoomLevel != null) {
                setZoomLevel(zoomLevel);
            }
        }

        if (args.containsKey("maxZoomLevel") ) {
            Integer maxZoomLevel = FMMMapConveter.toInt(args.get("maxZoomLevel"));
            if (maxZoomLevel != null) {
                setMaxZoomLevel(maxZoomLevel);
            }
        }

        if (args.containsKey("minZoomLevel") ) {
            Integer minZoomLevel = FMMMapConveter.toInt(args.get("minZoomLevel"));
            if (minZoomLevel != null) {
                setMinZoomLevel(minZoomLevel);
            }
        }

        if (args.containsKey("tilt") ) {
            Integer tilt = FMMMapConveter.toInt(args.get("tilt"));
            if (tilt != null) {
                setTilt(tilt);
            }
        }

        if (args.containsKey("bearing") ) {
            Integer bearing = FMMMapConveter.toInt(args.get("bearing"));
            if (bearing != null) {
                setBearing(bearing);
            }
        }

        if (args.containsKey("wmtsEnabled") ) {
            Boolean wmtsEnabled = FMMMapConveter.toBoolean(args.get("wmtsEnabled"));
            if (wmtsEnabled != null) {
                setWmtsEnabled(wmtsEnabled);
            }
        }

        if (args.containsKey("repaint") ) {
            Boolean repaint = FMMMapConveter.toBoolean(args.get("repaint"));
            if (repaint != null) {
                setRepaint(repaint);
            }
        }

        if (args.containsKey("showDebugActive") ) {
            Boolean showDebugActive = FMMMapConveter.toBoolean(args.get("showDebugActive"));
            if (showDebugActive != null) {
                setShowDebugActive(showDebugActive);
            }
        }

        if (args.containsKey("fillWaterEnabled") ) {
            Boolean fillWaterEnabled = FMMMapConveter.toBoolean(args.get("fillWaterEnabled"));
            if (fillWaterEnabled != null) {
                setFillWaterEnabled(fillWaterEnabled);
            }
        }

        if (args.containsKey("connected") ) {
            Boolean connected = FMMMapConveter.toBoolean(args.get("connected"));
            if (connected != null) {
                setConnected(connected);
            }
        }

        if (args.containsKey("compassEnabled") ) {
            Boolean compassEnabled = FMMMapConveter.toBoolean(args.get("compassEnabled"));
            if (compassEnabled != null) {
                setCompassEnabled(compassEnabled);
            }
        }

        if (args.containsKey("logoEnabled") ) {
            Boolean logoEnabled = FMMMapConveter.toBoolean(args.get("logoEnabled"));
            if (logoEnabled != null) {
                setLogoEnabled(logoEnabled);
            }
        }

        if (args.containsKey("attributionEnabled") ) {
            Boolean attributionEnabled = FMMMapConveter.toBoolean(args.get("attributionEnabled"));
            if (attributionEnabled != null) {
                setAttributionEnabled(attributionEnabled);
            }
        }

        if (args.containsKey("scaleEnabled") ) {
            Boolean scaleEnabled = FMMMapConveter.toBoolean(args.get("scaleEnabled"));
            if (scaleEnabled != null) {
                setScaleEnabled(scaleEnabled);
            }
        }

        if (args.containsKey("rotateGesturesEnabled") ) {
            Boolean rotateGesturesEnabled = FMMMapConveter.toBoolean(args.get("rotateGesturesEnabled"));
            if (rotateGesturesEnabled != null) {
                setRotateGesturesEnabled(rotateGesturesEnabled);
            }
        }

        if (args.containsKey("tiltGesturesEnabled") ) {
            Boolean tiltGesturesEnabled = FMMMapConveter.toBoolean(args.get("tiltGesturesEnabled"));
            if (tiltGesturesEnabled != null) {
                setTiltGesturesEnabled(tiltGesturesEnabled);
            }
        }

        if (args.containsKey("zoomGesturesEnabled") ) {
            Boolean zoomGesturesEnabled = FMMMapConveter.toBoolean(args.get("zoomGesturesEnabled"));
            if (zoomGesturesEnabled != null) {
                setZoomGesturesEnabled(zoomGesturesEnabled);
            }
        }

        if (args.containsKey("zoomControlsEnabled") ) {
            Boolean zoomControlsEnabled = FMMMapConveter.toBoolean(args.get("zoomControlsEnabled"));
            if (zoomControlsEnabled != null) {
                setZoomControlsEnabled(zoomControlsEnabled);
            }
        }

        if (args.containsKey("doubleTapGesturesEnabled") ) {
            Boolean doubleTapGesturesEnabled = FMMMapConveter.toBoolean(args.get("doubleTapGesturesEnabled"));
            if (doubleTapGesturesEnabled != null) {
                setDoubleTapGesturesEnabled(doubleTapGesturesEnabled);
            }
        }

        if (args.containsKey("scrollGesturesEnabled") ) {
            Boolean scrollGesturesEnabled = FMMMapConveter.toBoolean(args.get("scrollGesturesEnabled"));
            if (scrollGesturesEnabled != null) {
                setScrollGesturesEnabled(scrollGesturesEnabled);
            }
        }

        if (args.containsKey("allGesturesEnabled") ) {
            Boolean allGesturesEnabled = FMMMapConveter.toBoolean(args.get("allGesturesEnabled"));
            if (allGesturesEnabled != null) {
                setAllGesturesEnabled(allGesturesEnabled);
            }
        }
    }

    @Override
    public void setMapType(String mapType) {
        if (mineMap != null && mapType != null) {
            String url;

            mineMap.setStyleUrl(mapType);
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
