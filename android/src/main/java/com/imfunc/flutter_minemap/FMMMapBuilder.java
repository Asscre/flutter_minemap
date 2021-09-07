package com.imfunc.flutter_minemap;

import android.content.Context;

import androidx.annotation.Nullable;

import com.minedata.minemap.geometry.LatLng;
import com.minemap.minemapsdk.maps.ImplMineMapOptions;

import java.util.Map;

import io.flutter.plugin.common.BinaryMessenger;

public class FMMMapBuilder {

    private int trafficRote;
    private int zoomLevel;
    private int minZoomLevel;
    private int maxZoomLevel;
    private int tilt;
    private int bearing;
    private Integer mapType;
    private Boolean trafficEnabled;
    private Boolean wmtsEnabled;
    private Boolean repaint;
    private Boolean showDebugActive;
    private Boolean fillWaterEnabled;
    private Boolean connected;
    private Boolean compassEnabled;
    private Boolean logoEnabled;
    private Boolean attributionEnabled;
    private Boolean scaleEnabled;
    private Boolean rotateGesturesEnabled;
    private Boolean tiltGesturesEnabled;
    private Boolean zoomGesturesEnabled;
    private Boolean zoomControlsEnabled;
    private Boolean doubleTapGesturesEnable;
    private Boolean scrollGesturesEnabled;
    private Boolean allGesturesEnabled;
    private LatLng center;


    public FMMMapController build(int id, Context context, BinaryMessenger binaryMessenger, @Nullable Map<String, Object> creationParams) {

        FMMMapController fmmMapController = new FMMMapController(id, context, binaryMessenger,
                creationParams);

        fmmMapController.setMapType(mapType);
        fmmMapController.setTrafficEnabled(trafficEnabled);
        fmmMapController.setTrafficRote(trafficRote);
        fmmMapController.setCenter(center);
        fmmMapController.setZoomLevel(zoomLevel);
        fmmMapController.setMinZoomLevel(minZoomLevel);
        fmmMapController.setMaxZoomLevel(maxZoomLevel);
        fmmMapController.setTilt(tilt);
        fmmMapController.setBearing(bearing);
        fmmMapController.setWmtsEnabled(wmtsEnabled);
        fmmMapController.setRepaint(repaint);
        fmmMapController.setShowDebugActive(showDebugActive);
        fmmMapController.setFillWaterEnabled(fillWaterEnabled);
        fmmMapController.setConnected(connected);
        fmmMapController.setCompassEnabled(compassEnabled);
        fmmMapController.setLogoEnabled(logoEnabled);
        fmmMapController.setAttributionEnabled(attributionEnabled);
        fmmMapController.setScaleEnabled(scaleEnabled);
        fmmMapController.setRotateGesturesEnabled(rotateGesturesEnabled);
        fmmMapController.setTiltGesturesEnabled(tiltGesturesEnabled);
        fmmMapController.setZoomGesturesEnabled(zoomGesturesEnabled);
        fmmMapController.setZoomControlsEnabled(zoomControlsEnabled);
        fmmMapController.setDoubleTapGesturesEnabled(doubleTapGesturesEnable);
        fmmMapController.setScrollGesturesEnabled(scrollGesturesEnabled);
        fmmMapController.setAllGesturesEnabled(allGesturesEnabled);

        return fmmMapController;
    }

    public FMMMapBuilder center(LatLng center) {
        this.center = center;
        return this;
    }

    public FMMMapBuilder zoomLevel(int zoomLevel) {
        this.zoomLevel = zoomLevel;
        return this;
    }

    public FMMMapBuilder minZoomLevel(int minZoomLevel) {
        this.minZoomLevel = minZoomLevel;
        return this;
    }

    public FMMMapBuilder maxZoomLevel(int maxZoomLevel) {
        this.maxZoomLevel = maxZoomLevel;
        return this;
    }

    public FMMMapBuilder trafficRote(int trafficRote) {
        this.trafficRote = trafficRote;
        return this;
    }

    public FMMMapBuilder tilt(int tilt) {
        this.tilt = tilt;
        return this;
    }

    public FMMMapBuilder bearing(int bearing) {
        this.bearing = bearing;
        return this;
    }

    public FMMMapBuilder mapType(Integer mapType) {
        this.mapType = mapType;
        return this;
    }

    public FMMMapBuilder trafficEnabled(Boolean trafficEnabled) {
        this.trafficEnabled = trafficEnabled;
        return this;
    }

    public FMMMapBuilder wmtsEnabled(Boolean wmtsEnabled) {
        this.wmtsEnabled = wmtsEnabled;
        return this;
    }


    public FMMMapBuilder repaint(Boolean repaint) {
        this.repaint = repaint;
        return this;
    }

    public FMMMapBuilder showDebugActive(Boolean showDebugActive) {
        this.showDebugActive = showDebugActive;
        return this;
    }

    public FMMMapBuilder fillWaterEnabled(Boolean fillWaterEnabled) {
        this.fillWaterEnabled = fillWaterEnabled;
        return this;
    }

    public FMMMapBuilder connected(Boolean connected) {
        this.connected = connected;
        return this;
    }

    public FMMMapBuilder compassEnabled(Boolean compassEnabled) {
        this.compassEnabled = compassEnabled;
        return this;
    }

    public FMMMapBuilder logoEnabled(Boolean logoEnabled) {
        this.logoEnabled = logoEnabled;
        return this;
    }

    public FMMMapBuilder attributionEnabled(Boolean attributionEnabled) {
        this.attributionEnabled = attributionEnabled;
        return this;
    }

    public FMMMapBuilder scaleEnabled(Boolean scaleEnabled) {
        this.scaleEnabled = scaleEnabled;
        return this;
    }


    public FMMMapBuilder rotateGesturesEnabled(Boolean rotateGesturesEnabled) {
        this.rotateGesturesEnabled = rotateGesturesEnabled;
        return this;
    }

    public FMMMapBuilder tiltGesturesEnabled(Boolean tiltGesturesEnabled) {
        this.tiltGesturesEnabled = tiltGesturesEnabled;
        return this;
    }

    public FMMMapBuilder zoomGesturesEnabled(Boolean zoomGesturesEnabled) {
        this.zoomGesturesEnabled = zoomGesturesEnabled;
        return this;
    }

    public FMMMapBuilder zoomControlsEnabled(Boolean zoomControlsEnabled) {
        this.zoomControlsEnabled = zoomControlsEnabled;
        return this;
    }

    public FMMMapBuilder doubleTapGesturesEnable(Boolean doubleTapGesturesEnable) {
        this.doubleTapGesturesEnable = doubleTapGesturesEnable;
        return this;
    }

    public FMMMapBuilder scrollGesturesEnabled(Boolean scrollGesturesEnabled) {
        this.scrollGesturesEnabled = scrollGesturesEnabled;
        return this;
    }

    public FMMMapBuilder allGesturesEnabled(Boolean allGesturesEnabled) {
        this.allGesturesEnabled = allGesturesEnabled;
        return this;
    }
}
