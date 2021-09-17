package com.imfunc.flutter_minemap;

import android.content.Context;

import androidx.annotation.NonNull;

import com.imfunc.flutter_minemap.views.FlutterMapView;

import java.util.Map;

import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.StandardMessageCodec;
import io.flutter.plugin.platform.PlatformView;
import io.flutter.plugin.platform.PlatformViewFactory;

public class MineViewFactory extends PlatformViewFactory {

    @NonNull
    private final BinaryMessenger messenger;

    public MineViewFactory(@NonNull BinaryMessenger messenger) {
        super(StandardMessageCodec.INSTANCE);
        this.messenger = messenger;
    }

    @NonNull
    @Override
    public PlatformView create(@NonNull Context context, int id, Object args) {
        final Map<String, Object> creationParams = (Map<String, Object>) args;
        FMMMapController fmmMapController =
                new FMMMapController(id, context, messenger,
                        creationParams);
        return new FlutterMapView(fmmMapController);
    }
}
