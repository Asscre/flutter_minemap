package com.imfunc.flutter_minemap.unil;

public class Constants {
    public static final String VIEW_METHOD_CHANNEL_PREFIX = "flutter_minemap/map_";

    /**
     * view类型
     */
    public static class ViewType {
        public static final String sMapView = "flutter_minemap/map/FMMMapView";
    }

    /**
     * 地图状态
     */
    public static class FMMMapStateMethodId {
        /// 设置地图中心点
        public static final String sMapSetCenterMethod = "flutter_minemap/map/setCenter";

        /// 获取地图中心点
        public static final String sMapGetCenterMethod = "flutter_minemap/map/getCenter";

        /// 设置地图缩放级别
        public static final String sMapSetZoomMethod = "flutter_minemap/map/setZoom";

        /// 获取地图缩放级别
        public static final String sMapGetZoomMethod = "flutter_minemap/map/getZoom";

        /// 设置地图最小缩放级别
        public static final String sMapSetMinZoomPreferenceMethod = "flutter_minemap/map/setMinZoomPreference";

        /// 获取地图最小缩放级别
        public static final String sMapGetMinZoomLevelMethod = "flutter_minemap/map/getMinZoomLevel";

        /// 设置地图最大缩放级别
        public static final String sMapSetMaxZoomPreferenceMethod = "flutter_minemap/map/setMaxZoomPreference";

        /// 获取地图最大缩放级别
        public static final String sMapGetMaxZoomLevelMethod = "flutter_minemap/map/getMaxZoomLevel";

        /// 设置地图俯仰角度
        public static final String sMapSetTiltMethod = "flutter_minemap/map/setTilt";

        /// 获取地图俯仰角度
        public static final String sMapGetTiltMethod = "flutter_minemap/map/getTilt";

        /// 设置地图旋转角度
        public static final String sMapSetBearingMethod = "flutter_minemap/map/setBearing";

        /// 获取地图旋转角度
        public static final String sMapGetBearingMethod = "flutter_minemap/map/getBearing";

        /// 设置是否开启wmts模式
        public static final String sMapSetWmtsEnabledMethod = "flutter_minemap/map/setWmtsEnabled";

        /// 获取是否开启wmts模式
        public static final String sMapGetWmtsEnabledMethod = "flutter_minemap/map/getWmtsEnabled";

        /// 设置图层跨级访问方式
        public static final String sMapSetOdevityMethod = "flutter_minemap/map/setOdevity";

        /// 设置路况跨级访问方式
        public static final String sMapSetOdevityForTrafficMethod = "flutter_minemap/map/setOdevityForTraffic";

        /// 获取图层跨级访问方式
        public static final String sMapGetOdevityMethod = "flutter_minemap/map/getOdevity";

        /// 获取路况跨级访问方式
        public static final String sMapGetOdevityForTrafficMethod = "flutter_minemap/map/getOdevityForTraffic";

        /// 设置地图样式
        public static final String sMapSetStyleMethod = "flutter_minemap/map/setStyleJson";

        /// 设置是否显示路况
        public static final String sMapSetTrafficShowMethod = "flutter_minemap/map/setTrafficShow";

        /// 设置路况刷新的时间间隔
        public static final String sMapSetTrafficRoteMethod = "flutter_minemap/map/setTrafficRote";

        /// 重新刷新路况
        public static final String sMapUpDataTrafficMethod = "flutter_minemap/map/upDataTraffic";

        /// 路况显示范围指定
        public static final String sMapSetAreaTrafficMethod = "flutter_minemap/map/setAreaTraffic";

        /// 是否开启动态持续刷新
        public static final String sMapSetRepaintMethod = "flutter_minemap/map/setRepaint";

        /// 设置是否显示地图调试信息
        public static final String sMapSetDebugActiveMethod = "flutter_minemap/map/setDebugActive";

        /// 获取当前是否显示地图调试信息
        public static final String sMapIsDebugActiveMethod = "flutter_minemap/map/isDebugActive";

        /// 将地图重置为朝北
        public static final String sMapResetNorthMethod = "flutter_minemap/map/resetNorth";

        /// 取消正在进行的动画
        public static final String sMapCancelTransitionsMethod = "flutter_minemap/map/cancelTransitions";

        /// 根据CameraUpdate参数移动相机。
        public static final String sMapMoveCameraMethod = "flutter_minemap/map/moveCamera";

        /// 以默认持续时间逐渐移动相机, 缩放将不会受到影响, 除非在CameraUpdate中指定。
        public static final String sMapEaseCameraMethod = "flutter_minemap/map/easeCamera";

        /// 可视区域动画，是指从当前可视区域转换到一个指定位置的可视区域的过程。
        public static final String sMapAnimateCameraMethod = "flutter_minemap/map/animateCamera";

        /// 获取相机的当前位置.返回的CameraPosition是当前位置的快照, 在相机移动时不会自动更新。
        public static final String sMapGetCameraPositionMethod = "flutter_minemap/map/getCameraPosition";

        /// 设置约束地图界限
        public static final String sMapSetLatLngBoundsForCameraTargetMethod = "flutter_minemap/map/setLatLngBoundsForCameraTarget";

        /// 根据地图界限和边距获取相机位置
        public static final String sMapGetCameraForLatLngBoundsMethod = "flutter_minemap/map/getCameraForLatLngBounds";

        /// 设置地图边距
        public static final String sMapSetPaddingMethod = "flutter_minemap/map/setPadding";

        /// 获取地图边距
        public static final String sMapGetPaddingMethod = "flutter_minemap/map/getPadding";

        /// 是否允许多个信息视窗
        public static final String sMapSetMultipleInfoWindowsMethod = "flutter_minemap/map/setMultipleInfoWindows";

        /// 添加当前地图样式中使用的图像
        public static final String sMapAddImageMethod = "flutter_minemap/map/addImage";

        /// 批量添加当前地图样式中使用的图像
        public static final String sMapAddImagesMethod = "flutter_minemap/map/addImages";

        /// 从当前地图的样式中删除图像
        public static final String sMapRemoveImageMethod = "flutter_minemap/map/removeImage";

        /// 从当前地图的样式中批量删除图像
        public static final String sMapRemoveImagesMethod = "flutter_minemap/map/removeImages";

        /// 从当前地图的样式中删除所有图像
        public static final String sMapRemoveImagesAllMethod = "flutter_minemap/map/removeImagesAll";

        /// 根据图像名称ID获取当前地图的样式中的图像对象
        public static final String sMapGetImageMethod = "flutter_minemap/map/getImage";

        /// 离线数据更新，离线地图包变更后必须调用此方法。
        public static final String sMapOfflineDataUpdateMethod = "flutter_minemap/map/offlineDataUpdate";

        /// 是否显示水纹
        public static final String sMapSetFillWaterEnabledMethod = "flutter_minemap/map/setFillWaterEnabled";

        /// 设置是否联网，如果为false，则使用纯离线地图。
        public static final String sMapSetConnectedMethod = "flutter_minemap/map/setConnected";

        /// 获取屏幕上1像素点对应的地图上距离长度，单位米
        public static final String sMapGetScalePerPixelMethod = "flutter_minemap/map/getScalePerPixel";

        /// 设置事件自动刷新
        public static final String sMapUpDataTrafficEventMethod = "flutter_minemap/map/upDataTrafficEvent";
    }

    /**
     * MapHandler类型
     */
    public static class MMapHandlerType {
        public static final int MAP_STATE = 0;
        public static final int CLUSTER_LAYER = 1;
    }

    /**
     * 聚合点图层方法集合
      */
    public static class FMMClusterLayerMethodId {
        /// 添加聚合点图层
        public static final String sMapAddClusterLayerMethod = "flutter_minemap/layer/addClusterLayer";

        /// 添加聚合点图层集合
        public static final String sMapAddAllClusterLayerMethod = "flutter_minemap/layer/addAllClusterLayer";

        /// 清空聚合点图层
        public static final String sMapClearClusterLayerMethod = "flutter_minemap/layer/clearClusterLayer";

        /// 删除聚合点图层
        public static final String sMapRemoveClusterLayerMethod = "flutter_minemap/layer/removeClusterLayer";
    }
}
