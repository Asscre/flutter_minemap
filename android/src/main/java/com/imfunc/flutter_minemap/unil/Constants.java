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
        public static final String sMapSetStyleMethod = "flutter_minemap/map/setStyleJson";
        public static final String sMapSetCenterMethod = "flutter_minemap/map/setCenter";
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
