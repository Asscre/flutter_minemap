import 'package:flutter/services.dart';
import 'package:flutter_minemap/private/fmm_method_channel_handler.dart';

class MineMapController {

  MethodChannel _mapChannel;

  FMMMethodChannelHandler _methodChannelHandler;

  MineMapController.withId(int id) {
    _init(id);
  }

  void _init(int id) {
    _mapChannel = MethodChannel('flutter_minemap_view_$id');
    _methodChannelHandler = FMMMethodChannelHandler();
    _mapChannel.setMethodCallHandler(_handlerMethod);
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