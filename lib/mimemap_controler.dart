import 'package:flutter/services.dart';
import 'package:flutter_minemap/models/fmm_types.dart';
import 'package:flutter_minemap/models/overlays/cluster_layer_model.dart';
import 'package:flutter_minemap/private/fmm_method_channel_handler.dart';
import 'package:flutter_minemap/private/fmm_method_id.dart';

import 'models/fmm_map_models.dart';

class MineMapController {
  MethodChannel _mapChannel;

  FMMMethodChannelHandler _methodChannelHandler;

  MineMapController.withId(int id) {
    _init(id);
  }

  void _init(int id) {
    _mapChannel = MethodChannel('flutter_minemap/map_$id');
    _methodChannelHandler = FMMMethodChannelHandler();
    _mapChannel.setMethodCallHandler(_handlerMethod);
  }

  /// flutter -> native
  ///
  /// 设置地图样式
  Future<bool> setMapStyle(FMMMapType fmmMapType) async {
    if (_mapChannel == null) {
      return false;
    }
    bool result = false;
    try {
      result = (await _mapChannel.invokeMethod(
          FMMMapStateMethodId.kMapSetStyleMethod, fmmMapType.index)) as bool;
    } on PlatformException catch (e) {
      print(e.toString());
    }
    return result;
  }

  /// 设置中心点
  Future<bool> setMapCenter(FMMCoordinate coordinate) async {
    if (_mapChannel == null) {
      return false;
    }
    bool result = false;
    try {
      result = (await _mapChannel.invokeMethod(
          FMMMapStateMethodId.kMapSetCenterMethod, coordinate.toMap())) as bool;
    } on PlatformException catch (e) {
      print(e.toString());
    }
    return result;
  }

  /// setMaxZoom
  Future<bool> setMaxZoom(int zoom) async {
    if (_mapChannel == null) {
      return false;
    }
    bool result = false;
    try {
      result = (await _mapChannel.invokeMethod(
          FMMMapStateMethodId.kMapSetMaxZoomPreferenceMethod, zoom)) as bool;
    } on PlatformException catch (e) {
      print(e.toString());
    }
    return result;
  }

  /// setMinZoom
  Future<bool> setMinZoom(int zoom) async {
    if (_mapChannel == null) {
      return false;
    }
    bool result = false;
    try {
      result = (await _mapChannel.invokeMethod(
          FMMMapStateMethodId.kMapSetMinZoomPreferenceMethod, zoom)) as bool;
    } on PlatformException catch (e) {
      print(e.toString());
    }
    return result;
  }

  /// setZoom
  Future<bool> setZoom(int zoom) async {
    if (_mapChannel == null) {
      return false;
    }
    bool result = false;
    try {
      result = (await _mapChannel.invokeMethod(
          FMMMapStateMethodId.kMapSetZoomMethod, zoom)) as bool;
    } on PlatformException catch (e) {
      print(e.toString());
    }
    return result;
  }

  /// 添加聚合点图层
  Future<bool> addClusterLayer(ClusterLayerModel params) async {
    print(params);
    if (_mapChannel == null) {
      return false;
    }
    bool result = false;
    try {
      result = (await _mapChannel.invokeMethod(
        FMMClusterLayerMethodId.kMapAddClusterLayerMethod,
        params.toMap(),
      )) as bool;
    } on PlatformException catch (e) {
      print(e.toString());
    }
    return result;
  }

  /// 添加聚合点图层
  Future<bool> clearClusterLayer() async {
    if (_mapChannel == null) {
      return false;
    }
    bool result = false;
    try {
      result = (await _mapChannel.invokeMethod(
        FMMClusterLayerMethodId.kMapClearClusterLayerMethod,
      )) as bool;
    } on PlatformException catch (e) {
      print(e.toString());
    }
    return result;
  }

  /// 地图代理回调
  ///
  /// native -> flutter
  Future<dynamic> _handlerMethod(MethodCall call) async {
    // BMFLog.d("_handlerMethod", tag: _tag);
    if (_methodChannelHandler != null) {
      return await _methodChannelHandler.handlerMethod(call);
    }
  }
}
