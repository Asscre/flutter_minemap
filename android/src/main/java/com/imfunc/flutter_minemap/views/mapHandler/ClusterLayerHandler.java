package com.imfunc.flutter_minemap.views.mapHandler;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.text.TextUtils;

import com.imfunc.flutter_minemap.FMMMapController;
import com.imfunc.flutter_minemap.R;
import com.imfunc.flutter_minemap.unil.Constants;
import com.imfunc.flutter_minemap.unil.conveter.FMMMapConveter;
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
    private ClusterLayer clusterLayer;
    private ClusterLayerOptions options;


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
                addAllClusterLayer(context, call, result);
                break;
            case Constants.FMMClusterLayerMethodId.sMapClearClusterLayerMethod:
                clearClusterLayer(result);
                break;
            default:
                break;
        }
    }

    /**
     * 添加聚合点图层集合
     * @param context
     * @param call
     * @param result
     */
    private void addAllClusterLayer(Context context, MethodCall call,
                                    MethodChannel.Result result) {
        Map params = FMMMapConveter.toMap(call.arguments);
        Integer clusterRadius = FMMMapConveter.toInt(params.get("clusterRadius"));
        String textColor = (String) params.get("textColor");
        Integer textFontSize = FMMMapConveter.toInt(params.get("textFontSize"));
        Integer maxZoom = FMMMapConveter.toInt(params.get("maxZoom"));
        Integer minZoom = FMMMapConveter.toInt(params.get("minZoom"));
        List<LatLng>  latLngs = FMMMapConveter.mapToLatlngs((List<Map<String, Double>>) params.get("latLngs"));

        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(),
                R.drawable.minemap_mylocation_icon_default);

        String bitmapName = "cluster_icon";
        mMapController.getMineMap().addImage(bitmapName, bitmap);
        Map<Integer, String> icons = new HashMap<>();
        icons.put(0, bitmapName);

        Long startTs = System.currentTimeMillis();

        options =
                new ClusterLayerOptions(true, "clusterlayer1" + startTs, "clusterlayer2" + startTs);
        options.setClusterRadius(clusterRadius);
        options.setClusterTextColor(Color.parseColor("#" + textColor));
        options.setClusterTextFontSize(textFontSize);
        options.setIcons(icons);
        options.setMaxZoom(maxZoom);
        options.setMinZoom(minZoom);
        clusterLayer = mMapController.getMineMap().addLayer(options);

        List<MarkerLayerOptions.MarkerItem> items = new ArrayList<>();
        for (int i = 0; i < latLngs.size(); i ++) {
            MarkerLayerOptions.MarkerItem item = new MarkerLayerOptions.MarkerItem()
                    .icon(bitmapName)
                    .position(latLngs.get(i))
                    .iconRotate(0f);
            items.add(item);
        }

        options.addAll(items);
        clusterLayer.update();
        result.success(true);
    }

    /**
     * 清空聚合点图层
     * @param result
     */
    private void clearClusterLayer(
                                   MethodChannel.Result result) {
        if (null != clusterLayer && clusterLayer.isLayerExist()) {
            clusterLayer.clear();
            clusterLayer.update();
        }
        result.success(true);
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
