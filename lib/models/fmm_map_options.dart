import 'package:flutter/foundation.dart';
import 'package:flutter_minemap/models/fmm_map_models.dart';
import 'package:flutter_minemap/models/fmm_types.dart';

/// 地图参数集合
class FMMMapOptions {
  /// 当前地图类型，默认标准地图
  ///
  /// MapTypeBase = MapTypeBase
  ///
  /// 标准地图 = MapTypeNight
  ///
  /// 卫星地图 = MapTypeSatellite
  FMMMapType mapType;

  /// 设定地图是否打开路况图层
  bool trafficEnabled;

  /// 设定路况刷新时间，单位为秒
  int trafficRote;

  /// 当前地图的中心点，改变该值时，地图的比例尺级别不会发生变化
  FMMCoordinate center;

  /// 地图比例尺级别，值为整数或小数，值域范围为[0.0,25.5]
  int zoomLevel;

  /// 地图的自定义最小比例尺级别，值为整数或小数，值域范围为[0.0,25.5]
  int minZoomLevel;

  /// 地图的自定义最大比例尺级别，值为整数或小数，值域范围为[0.0,25.5]
  int maxZoomLevel;

  /// 地图俯仰角度，值为整数或小数，值域范围为[0,60]
  int tilt;

  /// 设置地图旋转角度,从北部顺时针方向设置，值为整数或小数，值域范围为[0,360]
  int bearing;

  /// 设置地图是否开启wmts模式
  bool wmtsEnabled;

  /// 设置地图是否开启动态持续刷新
  bool repaint;

  /// 设置是否显示地图调试信息
  bool showDebugActive;

  /// 设置地图是否显示水纹
  bool fillWaterEnabled;

  /// 设置是否联网，如果为false，则使用纯离线地图
  bool connected;

  /// 设置显示和隐藏指南针
  bool compassEnabled;

  /// 设置显示和隐藏LOGO
  bool logoEnabled;

  /// 设置显示和隐藏地图属性控件
  bool attributionEnabled;

  /// 设置显示和隐藏比例尺控件
  bool scaleEnabled;

  /// 设置地图是否可以旋转
  bool rotateGesturesEnabled;

  /// 设置地图是否可以倾斜
  bool tiltGesturesEnabled;

  /// 设置地图是否可以缩放
  bool zoomGesturesEnabled;

  /// 设置是否启用缩放控件
  bool zoomControlsEnabled;

  /// 设置地图是否可以双指放大
  bool doubleTapGesturesEnabled;

  /// 设置地图是否可以滚动
  bool scrollGesturesEnabled;

  /// 设置启用或禁用所有手势
  bool allGesturesEnabled;

  /// accessToken
  String accessToken;

  /// offlineAccessToken
  String offlineAccessToken;

  /// solution
  String solution;

  FMMMapOptions({
    this.mapType: FMMMapType.Base,
    this.trafficEnabled: false,
    this.trafficRote: 60,
    this.center,
    this.zoomLevel: 17,
    this.maxZoomLevel: 17,
    this.minZoomLevel: 3,
    this.tilt,
    this.bearing,
    this.wmtsEnabled,
    this.repaint,
    this.showDebugActive: true,
    this.fillWaterEnabled,
    this.connected,
    this.compassEnabled: true,
    this.logoEnabled: true,
    this.attributionEnabled: false,
    this.scaleEnabled: true,
    this.rotateGesturesEnabled: true,
    this.tiltGesturesEnabled: true,
    this.zoomGesturesEnabled: true,
    this.zoomControlsEnabled: true,
    this.doubleTapGesturesEnabled: true,
    this.scrollGesturesEnabled: true,
    this.allGesturesEnabled: false,
    @required this.accessToken,
    @required this.offlineAccessToken,
    @required this.solution,
  });

  /// FMMMapOptions -> map
  Map<String, Object> toMap() {
    return {
      'mapType': this.mapType?.index,
      'trafficEnabled': this.trafficEnabled,
      'trafficRote': this.trafficRote,
      'center': this.center?.toMap(),
      'zoomLevel': this.zoomLevel,
      'maxZoomLevel': this.maxZoomLevel,
      'minZoomLevel': this.minZoomLevel,
      'tilt': this.tilt,
      'bearing': this.bearing,
      'wmtsEnabled': this.wmtsEnabled,
      'repaint': this.repaint,
      'showDebugActive': this.showDebugActive,
      'fillWaterEnabled': this.fillWaterEnabled,
      'connected': this.connected,
      'compassEnabled': this.compassEnabled,
      'logoEnabled': this.logoEnabled,
      'attributionEnabled': this.attributionEnabled,
      'scaleEnabled': this.scaleEnabled,
      'rotateGesturesEnabled': this.rotateGesturesEnabled,
      'tiltGesturesEnabled': this.tiltGesturesEnabled,
      'zoomControlsEnabled': this.zoomControlsEnabled,
      'zoomGesturesEnabled': this.zoomGesturesEnabled,
      'doubleTapGesturesEnabled': this.doubleTapGesturesEnabled,
      'scrollGesturesEnabled': this.scrollGesturesEnabled,
      'allGesturesEnabled': this.allGesturesEnabled,
      'accessToken': this.accessToken ?? '',
      'offlineAccessToken': this.offlineAccessToken ?? '',
      'solution': this.solution ?? '',
    };
  }
}
