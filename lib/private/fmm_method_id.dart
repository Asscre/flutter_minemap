/**
 * Author: Asscre
 * Date: 8/13/2021
 */

/// 用于methodChannel合native的方法id约定
///
/// 地图UI设置
class FMMMapUIMethodId {
  ///  设置显示和隐藏指南针
  static const kMapSetCompassEnabledMethod = 'flutter_minemap/map/setCompassEnabled';

  /// 获取是否显示指南针
  static const kMapIsCompassEnabledMethod = 'flutter_minemap/map/isCompassEnabled';

  /// 设置指南针图像
  static const kMapSetCompassImageMethod = 'flutter_minemap/map/setCompassImage';

  /// 获取指南针图像
  static const kMapGetCompassImageMethod = 'flutter_minemap/map/getCompassImage';

  /// 设置指南针边距或设置LOGO边距
  static const kMapSetCompassMarginsMethod = 'flutter_minemap/map/setCompassMargins';

  /// 设置指南针停泊位置\设置LOGO停泊位置\设置比例尺停泊位置
  static const kMapSetCompassGravityMethod = 'flutter_minemap/map/setCompassGravity';

  /// 设置显示和隐藏LOGO
  static const kMapSetLogoEnabledMethod = 'flutter_minemap/map/setLogoEnabled';

  /// 获取是否显示LOGO
  static const kMapIsLogoEnabledMethod = 'flutter_minemap/map/isLogoEnabled';

  /// 设置显示和隐藏地图属性控件
  static const kMapSetAttributionEnabledMethod = 'flutter_minemap/map/setAttributionEnabled';

  /// 获取是否显示地图属性控件
  static const kMapIsAttributionEnabledMethod = 'flutter_minemap/map/isAttributionEnabled';

  /// 设置显示和隐藏比例尺控件
  static const kMapSetScaleEnabledMethod = 'flutter_minemap/map/setScaleEnabled';

  /// 获取是否显示比例尺控件
  static const kMapIsScaleEnabledMethod = 'flutter_minemap/map/isScaleEnabled';

  /// 设置比例尺边距
  static const kMapSetScaleMarginsMethod = 'flutter_minemap/map/setScaleMargins';

  /// 设置地图是否可以旋转
  static const kMapSetRotateGesturesEnabledMethod = 'flutter_minemap/map/setRotateGesturesEnabled';

  /// 获取地图是否可以旋转
  static const kMapIsRotateGesturesEnabledMethod = 'flutter_minemap/map/isRotateGesturesEnabled';

  /// 设置地图是否可以倾斜
  static const kMapSetTiltGesturesEnabledMethod = 'flutter_minemap/map/setTiltGesturesEnabled';

  /// 获取地图是否可以倾斜
  static const kMapIsTiltGesturesEnabledMethod = 'flutter_minemap/map/isTiltGesturesEnabled';

  /// 设置地图是否可以缩放
  static const kMapMethod = 'flutter_minemap/map/setZoomGesturesEnabled';

  /// 获取地图是否可以缩放
  static const kMapIsZoomGesturesEnabledMethod = 'flutter_minemap/map/isZoomGesturesEnabled';

  /// 设置是否启用缩放控件
  static const kMapSetZoomControlsEnabledMethod = 'flutter_minemap/map/setZoomControlsEnabled';

  /// 获取是否启用缩放控件
  static const kMapIsZoomControlsEnabledMethod = 'flutter_minemap/map/isZoomControlsEnabled';

  /// 设置地图是否可以双指放大
  static const kMapSetDoubleTapGesturesEnabledMethod = 'flutter_minemap/map/setDoubleTapGesturesEnabled';

  /// 获取地图是否可以双指放大
  static const kMapIsDoubleTapGesturesEnabledMethod = 'flutter_minemap/map/isDoubleTapGesturesEnabled';

  /// 设置地图是否可以滚动
  static const kMapSetScrollGesturesEnabledMethod = 'flutter_minemap/map/setScrollGesturesEnabled';

  /// 获取地图是否可以滚动
  static const kMapIsScrollGesturesEnabledMethod = 'flutter_minemap/map/isScrollGesturesEnabled';

  /// 设置启用或禁用所有手势
  static const kMapSetAllGesturesEnabledMethod = 'flutter_minemap/map/setAllGesturesEnabled';

  /// 获取地图视图的宽度
  static const kMapGetWidthMethod = 'flutter_minemap/map/getWidth';

  /// 获取地图视图的高度
  static const kMapGetHeightMethod = 'flutter_minemap/map/getHeight';
}

/// 地图状态
class FMMMapStateMethodId {
  /// 设置地图中心点
  static const kMapSetCenterMethod = 'flutter_minemap/map/setCenter';

  /// 获取地图中心点
  static const kMapGetCenterMethod = 'flutter_minemap/map/getCenter';

  /// 设置地图缩放级别
  static const kMapSetZoomMethod = 'flutter_minemap/map/setZoom';

  /// 获取地图缩放级别
  static const kMapGetZoomMethod = 'flutter_minemap/map/getZoom';

  /// 设置地图最小缩放级别
  static const kMapSetMinZoomPreferenceMethod = 'flutter_minemap/map/setMinZoomPreference';

  /// 获取地图最小缩放级别
  static const kMapGetMinZoomLevelMethod = 'flutter_minemap/map/getMinZoomLevel';

  /// 设置地图最大缩放级别
  static const kMapSetMaxZoomPreferenceMethod = 'flutter_minemap/map/setMaxZoomPreference';

  /// 获取地图最大缩放级别
  static const kMapGetMaxZoomLevelMethod = 'flutter_minemap/map/getMaxZoomLevel';

  /// 设置地图俯仰角度
  static const kMapSetTiltMethod = 'flutter_minemap/map/setTilt';

  /// 获取地图俯仰角度
  static const kMapGetTiltMethod = 'flutter_minemap/map/getTilt';

  /// 设置地图旋转角度
  static const kMapSetBearingMethod = 'flutter_minemap/map/setBearing';

  /// 获取地图旋转角度
  static const kMapGetBearingMethod = 'flutter_minemap/map/getBearing';

  /// 设置是否开启wmts模式
  static const kMapSetWmtsEnabledMethod = 'flutter_minemap/map/setWmtsEnabled';

  /// 获取是否开启wmts模式
  static const kMapGetWmtsEnabledMethod = 'flutter_minemap/map/getWmtsEnabled';

  /// 设置图层跨级访问方式
  static const kMapSetOdevityMethod = 'flutter_minemap/map/setOdevity';

  /// 设置路况跨级访问方式
  static const kMapSetOdevityForTrafficMethod = 'flutter_minemap/map/setOdevityForTraffic';

  /// 获取图层跨级访问方式
  static const kMapGetOdevityMethod = 'flutter_minemap/map/getOdevity';

  /// 获取路况跨级访问方式
  static const kMapGetOdevityForTrafficMethod = 'flutter_minemap/map/getOdevityForTraffic';

  /// 设置地图样式
  static const kMapSetStyleMethod = 'flutter_minemap/map/setStyleJson';

  /// 设置是否显示路况
  static const kMapSetTrafficShowMethod = 'flutter_minemap/map/setTrafficShow';

  /// 设置路况刷新的时间间隔
  static const kMapSetTrafficRoteMethod = 'flutter_minemap/map/setTrafficRote';

  /// 重新刷新路况
  static const kMapUpDataTrafficMethod = 'flutter_minemap/map/upDataTraffic';

  /// 路况显示范围指定
  static const kMapSetAreaTrafficMethod = 'flutter_minemap/map/setAreaTraffic';

  /// 是否开启动态持续刷新
  static const kMapSetRepaintMethod = 'flutter_minemap/map/setRepaint';

  /// 设置是否显示地图调试信息
  static const kMapSetDebugActiveMethod = 'flutter_minemap/map/setDebugActive';

  /// 获取当前是否显示地图调试信息
  static const kMapIsDebugActiveMethod = 'flutter_minemap/map/isDebugActive';

  /// 将地图重置为朝北
  static const kMapResetNorthMethod = 'flutter_minemap/map/resetNorth';

  /// 取消正在进行的动画
  static const kMapCancelTransitionsMethod = 'flutter_minemap/map/cancelTransitions';

  /// 根据CameraUpdate参数移动相机。
  static const kMapMoveCameraMethod = 'flutter_minemap/map/moveCamera';

  /// 以默认持续时间逐渐移动相机, 缩放将不会受到影响, 除非在CameraUpdate中指定。
  static const kMapEaseCameraMethod = 'flutter_minemap/map/easeCamera';

  /// 可视区域动画，是指从当前可视区域转换到一个指定位置的可视区域的过程。
  static const kMapAnimateCameraMethod = 'flutter_minemap/map/animateCamera';

  /// 获取相机的当前位置.返回的CameraPosition是当前位置的快照, 在相机移动时不会自动更新。
  static const kMapGetCameraPositionMethod = 'flutter_minemap/map/getCameraPosition';

  /// 设置约束地图界限
  static const kMapSetLatLngBoundsForCameraTargetMethod = 'flutter_minemap/map/setLatLngBoundsForCameraTarget';

  /// 根据地图界限和边距获取相机位置
  static const kMapGetCameraForLatLngBoundsMethod = 'flutter_minemap/map/getCameraForLatLngBounds';

  /// 设置地图边距
  static const kMapSetPaddingMethod = 'flutter_minemap/map/setPadding';

  /// 获取地图边距
  static const kMapGetPaddingMethod = 'flutter_minemap/map/getPadding';

  /// 是否允许多个信息视窗
  static const kMapSetMultipleInfoWindowsMethod = 'flutter_minemap/map/setMultipleInfoWindows';

  /// 添加当前地图样式中使用的图像
  static const kMapAddImageMethod = 'flutter_minemap/map/addImage';

  /// 批量添加当前地图样式中使用的图像
  static const kMapAddImagesMethod = 'flutter_minemap/map/addImages';

  /// 从当前地图的样式中删除图像
  static const kMapRemoveImageMethod = 'flutter_minemap/map/removeImage';

  /// 从当前地图的样式中批量删除图像
  static const kMapRemoveImagesMethod = 'flutter_minemap/map/removeImages';

  /// 从当前地图的样式中删除所有图像
  static const kMapRemoveImagesAllMethod = 'flutter_minemap/map/removeImagesAll';

  /// 根据图像名称ID获取当前地图的样式中的图像对象
  static const kMapGetImageMethod = 'flutter_minemap/map/getImage';

  /// 离线数据更新，离线地图包变更后必须调用此方法。
  static const kMapOfflineDataUpdateMethod = 'flutter_minemap/map/offlineDataUpdate';

  /// 是否显示水纹
  static const kMapSetFillWaterEnabledMethod = 'flutter_minemap/map/setFillWaterEnabled';

  /// 设置是否联网，如果为false，则使用纯离线地图。
  static const kMapSetConnectedMethod = 'flutter_minemap/map/setConnected';

  /// 获取屏幕上1像素点对应的地图上距离长度，单位米
  static const kMapGetScalePerPixelMethod = 'flutter_minemap/map/getScalePerPixel';

  /// 设置事件自动刷新
  static const kMapUpDataTrafficEventMethod = 'flutter_minemap/map/upDataTrafficEvent';
}

/// 地图交互
class FMMMapInteractMethodId {
  /// 捕获地图上的点击操作
  static const kMapMapClickMethod = 'flutter_minemap/interact/mapClick';

  /// 捕获地图上的长按操作
  static const kMapMapLongClickMethod = 'flutter_minemap/interact/mapLongClick';

  /// 捕获标记被点击时的操作
  static const kMapMarkerClickMethod = 'flutter_minemap/interact/markerClick';

  /// 捕获多边形被点击时的操作
  static const kMapPolygonClickMethod = 'flutter_minemap/interact/polygonClick';

  /// 捕获折线被点击时的操作
  static const kMapPolylineClickMethod = 'flutter_minemap/interact/polylineClick';

  /// 捕获信息窗口被点击时的操作
  static const kMapInfoWindowClickMethod = 'flutter_minemap/interact/infoWindowClick';

  /// 捕获信息窗口被长按时的操作
  static const kMapInfoWindowLongClickMethod = 'flutter_minemap/interact/infoWindowLongClick';

  /// 捕获信息窗口被关闭时的操作
  static const kMapInfoWindowCloseMethod = 'flutter_minemap/interact/infoWindowClose';

  /// 捕获拍摄快照时的操作
  static const kMapSnapshotMethod = 'flutter_minemap/interact/snapshot';

  /// 捕获地图比例尺发生变化时的操作
  static const kMapScaleChangedMethod = 'flutter_minemap/interact/scaleChanged';

  /// 捕获相机开始移动时的操作
  static const kMapOnCameraMoveStartedMethod = 'flutter_minemap/interact/onCameraMoveStarted';

  /// 捕获相机移动结束时的操作
  static const kMapOnCameraIdleMethod = 'flutter_minemap/interact/onCameraIdle';

  /// 捕获通过手势移动相机结束时的操作
  static const kMapOnCameraMoveEndedMethod = 'flutter_minemap/interact/onCameraMoveEnded';

  /// 捕获相机移动时的操作
  static const kMapOnCameraMoveMethod = 'flutter_minemap/interact/onCameraMove';

  /// 捕获相机移动取消时的操作
  static const kMapOnCameraMoveCanceledMethod = 'flutter_minemap/interact/onCameraMoveCanceled';
}

/// 数据转换方法Id集合
class FMMProjectionMethodId {
  /// 屏幕坐标转地理坐标
  static const kFromScreenLocationMethod =
      'flutter_minemap/projection/fromScreenLocation';

  /// 将地理坐标转换成屏幕坐标
  static const kToScreenLocationMethod =
      'flutter_minemap/projection/toScreenLocation';

  /// 测距，计算起点与终点之间的距离，单位为米
  static const kDistanceWithStartPointMethod =
      'flutter_minemap/projection/distanceWithStartPoint';
}

/// Marker方法集合
class FMMMarkerMethodId {
  /// 添加marker
  static const kMapAddMarkerMethod = 'flutter_minemap/marker/addMarker';

  /// 添加markers
  static const kMapAddMarkersMethod = 'flutter_minemap/marker/addMarkers';

  /// 删除marker
  static const kMapRemoveMarkerMethod = 'flutter_minemap/marker/removeMarker';

  /// 删除markers
  static const kMapRemoveMarkersMethod = 'flutter_minemap/marker/removeMarkers';

  /// 清除所有的markers
  static const kMapCleanAllMarkersMethod =
      'flutter_minemap/marker/cleanAllMarkers';

  /// 选中marker
  static const kMapSelectMarkerMethod = 'flutter_minemap/marker/selectMarker';

  /// 取消选中marker
  static const kMapDeselectMarkerMethod =
      'flutter_minemap/marker/deselectMarker';

  /// 更新marker属性
  static const kMapUpdateMarkerMember =
      'flutter_minemap/marker/updateMarkerMember';
}

/// marker事件回调方法ID集合
class FMMMarkerCallbackMethodId {
  /// marker点击回调
  static const kMapClickedMarkerCallback =
      'flutter_minemap/marker/clickedMarker';

  /// marker选中回调
  static const kMapDidSelectMarkerCallback =
      'flutter_minemap/marker/didSelectedMarker';

  /// marker点击回调
  static const kMapDidDeselectMarkerCallback =
      'flutter_minemap/marker/didDeselectMarker';

  /// marker拖拽回调
  static const kMapDragMarkerCallback = 'flutter_minemap/marker/dragMarker';
}

/// CircleMarker方法集合
class FMMCircleMethodId {
  /// 添加圆形marker
  static const kMapAddCircleMethod = 'flutter_minemap/marker/addCircle';
  /// 删除圆形marker
  static const kMapRemoveCircleMethod = 'flutter_minemap/marker/removeCircle';
}

/// 聚合点图层方法集合
class FMMClusterLayerMethodId {
  /// 添加聚合点图层
  static const kMapAddClusterLayerMethod = 'flutter_minemap/layer/addClusterLayer';

  /// 添加聚合点图层集合
  static const kMapAddAllClusterLayerMethod = 'flutter_minemap/layer/addAllClusterLayer';

  /// 清空聚合点图层
  static const kMapClearClusterLayerMethod = 'flutter_minemap/layer/clearClusterLayer';

  /// 删除聚合点图层
  static const kMapRemoveClusterLayerMethod = 'flutter_minemap/layer/removeClusterLayer';
}
