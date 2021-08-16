package com.imfunc.flutter_minemap.interfaces;

import com.minedata.minemap.geometry.LatLng;

public interface MineMapInterface {

    void setMapType(String mapType);

    void setTrafficEnabled(Boolean enabled);

    void setTrafficRote(int trafficRote);

    void setCenter(LatLng latLng);

    void setZoomLevel(int zoomLevel);

    void setMinZoomLevel(int minZoomLevel);

    void setMaxZoomLevel(int maxZoomLevel);

    void setTilt(int tilt);

    void setBearing(int bearing);

    void setWmtsEnabled(Boolean enabled);

    void setRepaint(Boolean repaint);

    void setShowDebugActive(Boolean showDebugActive);

    void setFillWaterEnabled(Boolean enabled);

    void setConnected(Boolean connected);

    void setCompassEnabled(Boolean enabled);

    void setLogoEnabled(Boolean enabled);

    void setAttributionEnabled(Boolean enabled);

    void setScaleEnabled(Boolean enabled);

    void setRotateGesturesEnabled(Boolean enabled);

    void setTiltGesturesEnabled(Boolean enabled);

    void setZoomGesturesEnabled(Boolean enabled);

    void setZoomControlsEnabled(Boolean enabled);

    void setDoubleTapGesturesEnabled(Boolean enabled);

    void setScrollGesturesEnabled(Boolean enabled);

    void setAllGesturesEnabled(Boolean enabled);

}
