import 'package:flutter/material.dart';
import 'package:flutter_minemap/models/fmm_map_models.dart';

/// 点聚合参数Model
/// @param [clusterRadius] : cluster半径
/// @param [textColor] : 字体颜色
/// @param [textFontSize] : 字体大小
/// @param [maxZoom]
/// @param [minZoom]
/// @param [latLngs] : 坐标集合
class ClusterLayerModel {
  final int clusterRadius;
  final Color textColor;
  final int textFontSize;
  final int maxZoom;
  final int minZoom;
  final List<FMMCoordinate> latLngs;

  ClusterLayerModel({this.clusterRadius: 200, this.textColor: Colors.white, this.textFontSize: 14,
      this.maxZoom: 11, this.minZoom: 3, this.latLngs})
      : assert(latLngs != null);

  Map<String, Object> toMap() {
    return {
      'clusterRadius': this.clusterRadius,
      'textColor': this.textColor?.value?.toRadixString(16),
      'textFontSize': this.textFontSize,
      'maxZoom': this.maxZoom,
      'minZoom': this.minZoom,
      'latLngs': this.latLngs?.map((latLng) => latLng?.toMap())?.toList(),
    };
  }
}
