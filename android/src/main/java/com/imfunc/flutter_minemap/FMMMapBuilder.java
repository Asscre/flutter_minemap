package com.imfunc.flutter_minemap;

import android.content.Context;

import com.minemap.minemapsdk.maps.ImplMineMapOptions;

import io.flutter.plugin.common.BinaryMessenger;

public class FMMMapBuilder {

    public FMMMapController build(int id, Context context, BinaryMessenger binaryMessenger,
                                  String viewType, ImplMineMapOptions options) {

        FMMMapController fmmMapController = new FMMMapController(id, context, binaryMessenger,
                viewType, options);

        return  fmmMapController;
    }
}
