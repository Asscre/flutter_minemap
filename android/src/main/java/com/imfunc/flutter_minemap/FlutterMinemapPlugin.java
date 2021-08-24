package com.imfunc.flutter_minemap;

import androidx.annotation.NonNull;

import com.imfunc.flutter_minemap.factory.MineViewFactory;
import com.imfunc.flutter_minemap.unil.Constants;

import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.plugins.FlutterPlugin;

/**
 * FlutterMinemapPlugin
 */
public class FlutterMinemapPlugin implements FlutterPlugin {


    @Override
    public void onAttachedToEngine(@NonNull FlutterPluginBinding binding) {
        binding
                .getPlatformViewRegistry()
                .registerViewFactory(Constants.ViewType.sMapView, new MineViewFactory(binding.getBinaryMessenger()));
    }

    @Override
    public void onDetachedFromEngine(@NonNull FlutterPluginBinding binding) {
    }

}
