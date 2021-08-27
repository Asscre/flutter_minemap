package com.imfunc.flutter_minemap.views.mapHandler;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.text.TextUtils;

import com.imfunc.flutter_minemap.FMMMapController;
import com.imfunc.flutter_minemap.R;
import com.imfunc.flutter_minemap.unil.Constants;
import com.minedata.minemap.geometry.LatLng;
import com.minedata.minemap.overlay.ClusterLayer;
import com.minedata.minemap.overlay.ClusterLayerOptions;
import com.minedata.minemap.overlay.MarkerLayerOptions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

public class ClusterLayerHandler extends MMapHandler{

    ClusterLayer clusterLayer;
    
    public ClusterLayerHandler(FMMMapController mMapController) {
        super(mMapController);
    }

    @Override
    public void handlerMethodCallResult(Context context, MethodCall call, MethodChannel.Result result) {
        if (null == call) {
            return;
        }
        String methodId = call.method;
        if (TextUtils.isEmpty(methodId)) {
            return;
        }

        switch (methodId) {
            case Constants.FMMClusterLayerMethodId.sMapAddClusterLayerMethod:
                addClusterLayer(context, call, result);
                break;
            default:
                break;
        }
    }

    /**
     * 添加聚合点图层
     * @param call
     * @param result
     */
    private void addClusterLayer(Context context, MethodCall call,
                                 MethodChannel.Result result) {

        if (clusterLayer != null) {
            clusterLayer.clear();
        }

        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.minemap_mylocation_icon_default);
        String bitmapName = "cluster_icon";
        mMapController.getMineMap().addImage(bitmapName, bitmap);
        Map<Integer, String> icons = new HashMap<>();
        icons.put(0, bitmapName);

        ClusterLayerOptions options =
                new ClusterLayerOptions(true, "clusterlayer1", "clusterlayer2");
        options.setClusterRadius(200);
        options.setClusterTextColor(Color.parseColor("#ffff0000"));
        options.setClusterTextFontSize(14);
        options.setIcons(icons);
        options.setMaxZoom(11);
        options.setMinZoom(3);
        List<MarkerLayerOptions.MarkerItem> items = new ArrayList<>();
        LatLng latLng1 = new LatLng(38.913828, 116.405419);
        LatLng latLng2 = new LatLng(38.873828, 116.405419);
        MarkerLayerOptions.MarkerItem item1 = new MarkerLayerOptions.MarkerItem()
                .icon(bitmapName)
                .position(latLng1)
                .iconRotate(30.0f);
        MarkerLayerOptions.MarkerItem item2 = new MarkerLayerOptions.MarkerItem()
                .textName("你好")
                .position(latLng2)
                .textRotate(0.0f);
        items.add(item1);
        items.add(item2);
        options.addAll(items);

        clusterLayer = mMapController.getMineMap().addLayer(options);
        result.success(true);
    }

    /**
     * 添加聚合点图层集合
     * @param call
     * @param result
     */
    private void addAllClusterLayer(MethodCall call,
                                    MethodChannel.Result result) {

    }

    /**
     * 清空聚合点图层
     * @param call
     * @param result
     */
    private void clearClusterLayer(MethodCall call,
                                   MethodChannel.Result result) {

    }

    /**
     * 删除聚合点图层
     * @param call
     * @param result
     */
    private void removeClusterLayer(MethodCall call,
                                    MethodChannel.Result result) {

    }
}
