import 'package:flutter/services.dart';
import 'package:flutter_minemap/models/fmm_types.dart';
import 'package:flutter_minemap/private/fmm_method_channel_handler.dart';
import 'package:flutter_minemap/private/fmm_method_id.dart';

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
      result = (await _mapChannel.invokeMethod(FMMMapStateMethodId.kMapSetStyleMethod, fmmMapType.index)) as bool;
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