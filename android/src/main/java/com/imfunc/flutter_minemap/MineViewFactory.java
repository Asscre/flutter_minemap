package com.imfunc.flutter_minemap;

import android.content.Context;

import androidx.annotation.NonNull;

import com.imfunc.flutter_minemap.FMMMapBuilder;
import com.imfunc.flutter_minemap.FMMMapController;
import com.imfunc.flutter_minemap.views.FlutterMapView;
import com.imfunc.flutter_minemap.unil.Constants;
import com.imfunc.flutter_minemap.unil.conveter.FMMMapConveter;
import com.minedata.minemap.geometry.LatLng;

import java.util.Map;

import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.StandardMessageCodec;
import io.flutter.plugin.platform.PlatformView;
import io.flutter.plugin.platform.PlatformViewFactory;

public class MineViewFactory extends PlatformViewFactory {

    @NonNull private final BinaryMessenger messenger;

    public MineViewFactory(@NonNull BinaryMessenger messenger) {
        super(StandardMessageCodec.INSTANCE);
        this.messenger = messenger;
    }

    @NonNull
    @Override
    public PlatformView create(@NonNull Context context, int id, Object args) {
        final Map<String, Object> creationParams = (Map<String, Object>) args;
        FMMMapController fmmMapController = buildFMMMapController(context, id, creationParams);

        return new FlutterMapView(context, fmmMapController);
    }

    private FMMMapController buildFMMMapController(Context context, int viewId, Map<String, Object> args) {
        final FMMMapBuilder builder = new FMMMapBuilder();

        if (args.containsKey("mapType") ) {
            Integer mapType = FMMMapConveter.toInt(args.get("mapType"));
            if (mapType != null) {
                builder.mapType(mapType);
            }
        }

        if (args.containsKey("trafficEnabled") ) {
            Boolean trafficEnabled = FMMMapConveter.toBoolean(args.get("trafficEnabled"));
            if (trafficEnabled != null) {
                builder.trafficEnabled(trafficEnabled);
            }
        }

        if (args.containsKey("trafficRote") ) {
            Integer trafficRote = FMMMapConveter.toInt(args.get("trafficRote"));
            if (trafficRote != null) {
                builder.trafficRote(trafficRote);
            }
        }

        if (args.containsKey("center") ) {
            LatLng center = FMMMapConveter.mapToLatlng((Map<String, Object>) args.get("center"));
            if (center != null) {
                builder.center(center);
            }
        }

        if (args.containsKey("zoomLevel") ) {
            Integer zoomLevel = FMMMapConveter.toInt(args.get("zoomLevel"));
            if (zoomLevel != null) {
                builder.zoomLevel(zoomLevel);
            }
        }

        if (args.containsKey("maxZoomLevel") ) {
            Integer maxZoomLevel = FMMMapConveter.toInt(args.get("maxZoomLevel"));
            if (maxZoomLevel != null) {
                builder.maxZoomLevel(maxZoomLevel);
            }
        }

        if (args.containsKey("minZoomLevel") ) {
            Integer minZoomLevel = FMMMapConveter.toInt(args.get("minZoomLevel"));
            if (minZoomLevel != null) {
                builder.minZoomLevel(minZoomLevel);
            }
        }

        if (args.containsKey("tilt") ) {
            Integer tilt = FMMMapConveter.toInt(args.get("tilt"));
            if (tilt != null) {
                builder.tilt(tilt);
            }
        }

        if (args.containsKey("bearing") ) {
            Integer bearing = FMMMapConveter.toInt(args.get("bearing"));
            if (bearing != null) {
                builder.bearing(bearing);
            }
        }

        if (args.containsKey("wmtsEnabled") ) {
            Boolean wmtsEnabled = FMMMapConveter.toBoolean(args.get("wmtsEnabled"));
            if (wmtsEnabled != null) {
                builder.wmtsEnabled(wmtsEnabled);
            }
        }

        if (args.containsKey("repaint") ) {
            Boolean repaint = FMMMapConveter.toBoolean(args.get("repaint"));
            if (repaint != null) {
                builder.repaint(repaint);
            }
        }

        if (args.containsKey("showDebugActive") ) {
            Boolean showDebugActive = FMMMapConveter.toBoolean(args.get("showDebugActive"));
            if (showDebugActive != null) {
                builder.showDebugActive(showDebugActive);
            }
        }

        if (args.containsKey("fillWaterEnabled") ) {
            Boolean fillWaterEnabled = FMMMapConveter.toBoolean(args.get("fillWaterEnabled"));
            if (fillWaterEnabled != null) {
                builder.fillWaterEnabled(fillWaterEnabled);
            }
        }

        if (args.containsKey("connected") ) {
            Boolean connected = FMMMapConveter.toBoolean(args.get("connected"));
            if (connected != null) {
                builder.connected(connected);
            }
        }

        if (args.containsKey("compassEnabled") ) {
            Boolean compassEnabled = FMMMapConveter.toBoolean(args.get("compassEnabled"));
            if (compassEnabled != null) {
                builder.compassEnabled(compassEnabled);
            }
        }

        if (args.containsKey("logoEnabled") ) {
            Boolean logoEnabled = FMMMapConveter.toBoolean(args.get("logoEnabled"));
            if (logoEnabled != null) {
                builder.logoEnabled(logoEnabled);
            }
        }

        if (args.containsKey("attributionEnabled") ) {
            Boolean attributionEnabled = FMMMapConveter.toBoolean(args.get("attributionEnabled"));
            if (attributionEnabled != null) {
                builder.attributionEnabled(attributionEnabled);
            }
        }

        if (args.containsKey("scaleEnabled") ) {
            Boolean scaleEnabled = FMMMapConveter.toBoolean(args.get("scaleEnabled"));
            if (scaleEnabled != null) {
                builder.scaleEnabled(scaleEnabled);
            }
        }

        if (args.containsKey("rotateGesturesEnabled") ) {
            Boolean rotateGesturesEnabled = FMMMapConveter.toBoolean(args.get("rotateGesturesEnabled"));
            if (rotateGesturesEnabled != null) {
                builder.rotateGesturesEnabled(rotateGesturesEnabled);
            }
        }

        if (args.containsKey("tiltGesturesEnabled") ) {
            Boolean tiltGesturesEnabled = FMMMapConveter.toBoolean(args.get("tiltGesturesEnabled"));
            if (tiltGesturesEnabled != null) {
                builder.tiltGesturesEnabled(tiltGesturesEnabled);
            }
        }

        if (args.containsKey("zoomGesturesEnabled") ) {
            Boolean zoomGesturesEnabled = FMMMapConveter.toBoolean(args.get("zoomGesturesEnabled"));
            if (zoomGesturesEnabled != null) {
                builder.zoomGesturesEnabled(zoomGesturesEnabled);
            }
        }

        if (args.containsKey("zoomControlsEnabled") ) {
            Boolean zoomControlsEnabled = FMMMapConveter.toBoolean(args.get("zoomControlsEnabled"));
            if (zoomControlsEnabled != null) {
                builder.zoomControlsEnabled(zoomControlsEnabled);
            }
        }

        if (args.containsKey("doubleTapGesturesEnabled") ) {
            Boolean doubleTapGesturesEnabled = FMMMapConveter.toBoolean(args.get("doubleTapGesturesEnabled"));
            if (doubleTapGesturesEnabled != null) {
                builder.doubleTapGesturesEnable(doubleTapGesturesEnabled);
            }
        }

        if (args.containsKey("scrollGesturesEnabled") ) {
            Boolean scrollGesturesEnabled = FMMMapConveter.toBoolean(args.get("scrollGesturesEnabled"));
            if (scrollGesturesEnabled != null) {
                builder.scrollGesturesEnabled(scrollGesturesEnabled);
            }
        }

        if (args.containsKey("allGesturesEnabled") ) {
            Boolean allGesturesEnabled = FMMMapConveter.toBoolean(args.get("allGesturesEnabled"));
            if (allGesturesEnabled != null) {
                builder.allGesturesEnabled(allGesturesEnabled);
            }
        }


        return builder.build(viewId, context, messenger, args);
    }
}
