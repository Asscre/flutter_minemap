import 'package:flutter/services.dart';
import 'package:flutter_minemap/private/fmm_method_id.dart';

class FMMMethodChannelHandler {

  /// native -> flutter
  /// 处理原生消息
  dynamic handlerMethod(MethodCall call) async {
    switch (call.method) {
      case FMMMarkerCallbackMethodId.kMapClickedMarkerCallback:
        
    }
  }
}