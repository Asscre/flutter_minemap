package com.imfunc.flutter_minemap;

import androidx.annotation.NonNull;

import com.imfunc.flutter_minemap.factory.MineViewFactory;

import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.plugins.FlutterPlugin;

/**
 * FlutterMinemapPlugin
 */
public class FlutterMinemapPlugin implements FlutterPlugin {

    private static String NATIVE_VIEW_TYPE_ID = "flutter_minemap";
    private static boolean isLibraryLoaded = false;


    @Override
    public void onAttachedToEngine(@NonNull FlutterPluginBinding binding) {
        loadLibrary();
        binding
                .getPlatformViewRegistry()
                .registerViewFactory(NATIVE_VIEW_TYPE_ID, new MineViewFactory(binding.getBinaryMessenger()));
    }

    @Override
    public void onDetachedFromEngine(@NonNull FlutterPluginBinding binding) {
    }

    private static void loadLibrary() {
        if (isLibraryLoaded) {
            return;
        }

        System.loadLibrary("libminemap-gl.so");
        isLibraryLoaded = true;
    }
}
