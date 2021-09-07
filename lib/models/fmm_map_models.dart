// 此文件定义flutter与native间的基础数据交互中间层model

import 'package:flutter/material.dart';

/// flutter_minemap 抽象类
abstract class FMMModel {
  /// model -> map
  @required
  Map<String, Object> toMap();

  /// map -> dynamic
  @required
  dynamic fromMap(Map map);
}

/// 代表经纬度
class FMMCoordinate implements FMMModel {
  /// 纬度
  double latitude;

  /// 经度
  double longitude;

  /// FMMCoordinate构造方法
  FMMCoordinate(this.latitude, this.longitude);

  /// map => BMFCoordinate
  FMMCoordinate.fromMap(Map map)
      : assert(map != null,
  'Construct a BMFCoordinate，The parameter map cannot be null'),
        assert(map.containsKey('latitude'),
        'Construct a BMFCoordinate，The parameter latitude cannot be null'),
        assert(map.containsKey('longitude'),
        'Construct a BMFCoordinate，The parameter longitude cannot be null') {
    latitude = map['latitude'] as double;
    longitude = map['longitude'] as double;
  }

  @override
  Map<String, Object> toMap() {
    return {'latitude': this.latitude, 'longitude': this.longitude};
  }

  @override
  fromMap(Map map) {
    return FMMCoordinate.fromMap(map);
  }
}