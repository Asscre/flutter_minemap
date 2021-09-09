package com.imfunc.flutter_minemap.views.mapHandler;

import android.content.Context;
import android.util.Log;

import com.imfunc.flutter_minemap.FMMMapController;
import com.imfunc.flutter_minemap.unil.Constants;
import com.imfunc.flutter_minemap.unil.Env;

import java.util.HashMap;
import java.util.Iterator;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

public class MMapHandlerFactory {
    private HashMap<Integer, MMapHandler> mMapHandlerHashMap;

    public MMapHandlerFactory(FMMMapController fmmMapController) {
        init(fmmMapController);
    }

    private void init(FMMMapController fmmMapController) {
        if (mMapHandlerHashMap == null) {
            mMapHandlerHashMap = new HashMap<>();
        }
        mMapHandlerHashMap
                .put(Constants.MMapHandlerType.MAP_STATE, new MapStateHandler(fmmMapController));
        mMapHandlerHashMap
                .put(Constants.MMapHandlerType.CLUSTER_LAYER, new ClusterLayerHandler(fmmMapController));
    }

    public void dispatchMethodHandler(Context context, MethodCall call,
                                      MethodChannel.Result result) {
        if (null == call) {
            return;
        }

        String methodId = call.method;
        if (Env.DEBUG) {
            Log.d("MMapHandlerFactory", "dispatchMethodHandler: " + methodId);
        }
        MMapHandler mMapHandler = null;

        /// 对不同类型的操作进行分治管理
        switch (methodId) {
            case Constants.FMMMapStateMethodId.sMapSetStyleMethod:
            case Constants.FMMMapStateMethodId.sMapSetCenterMethod:
                mMapHandler = mMapHandlerHashMap.get(Constants.MMapHandlerType.MAP_STATE);
                break;
            case Constants.FMMClusterLayerMethodId.sMapAddClusterLayerMethod:
            case Constants.FMMClusterLayerMethodId.sMapClearClusterLayerMethod:
                mMapHandler = mMapHandlerHashMap.get(Constants.MMapHandlerType.CLUSTER_LAYER);
                break;
        }

        if (null == mMapHandler) {
            return;
        }

        mMapHandler.handlerMethodCallResult(context, call, result);
    }

    public void release() {
        if (null == mMapHandlerHashMap || mMapHandlerHashMap.size() == 0) {
            return;
        }

        MMapHandler mMapHandler = null;
        Iterator iterator = mMapHandlerHashMap.values().iterator();
        while (iterator.hasNext()) {
            mMapHandler = (MMapHandler) iterator.next();
            if (null == mMapHandler) {
                continue;
            }

            mMapHandler.clean();
        }
    }
}
