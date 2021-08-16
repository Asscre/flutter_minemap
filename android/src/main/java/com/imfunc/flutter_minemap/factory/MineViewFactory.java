package com.imfunc.flutter_minemap.factory;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.imfunc.flutter_minemap.MineMapActivity;

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
    public PlatformView create(@NonNull Context context, int id, @Nullable Object args) {
        final Map<String, Object> creationParams = (Map<String, Object>) args;
        return new MineMapActivity(context, id, messenger, creationParams);
    }
}
