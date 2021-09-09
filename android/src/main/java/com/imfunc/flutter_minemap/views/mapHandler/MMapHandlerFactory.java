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
            case Constants.FMMMapStateMethodId.sMapGetCenterMethod:
            case Constants.FMMMapStateMethodId.sMapSetZoomMethod:
            case Constants.FMMMapStateMethodId.sMapGetZoomMethod:
            case Constants.FMMMapStateMethodId.sMapSetMinZoomPreferenceMethod:
            case Constants.FMMMapStateMethodId.sMapGetMinZoomLevelMethod:
            case Constants.FMMMapStateMethodId.sMapSetMaxZoomPreferenceMethod:
            case Constants.FMMMapStateMethodId.sMapGetMaxZoomLevelMethod:
            case Constants.FMMMapStateMethodId.sMapSetTiltMethod:
            case Constants.FMMMapStateMethodId.sMapGetTiltMethod:
            case Constants.FMMMapStateMethodId.sMapSetBearingMethod:
            case Constants.FMMMapStateMethodId.sMapGetBearingMethod:
            case Constants.FMMMapStateMethodId.sMapSetWmtsEnabledMethod:
            case Constants.FMMMapStateMethodId.sMapGetWmtsEnabledMethod:
            case Constants.FMMMapStateMethodId.sMapSetOdevityMethod:
            case Constants.FMMMapStateMethodId.sMapSetOdevityForTrafficMethod:
            case Constants.FMMMapStateMethodId.sMapGetOdevityMethod:
            case Constants.FMMMapStateMethodId.sMapGetOdevityForTrafficMethod:
            case Constants.FMMMapStateMethodId.sMapSetTrafficShowMethod:
            case Constants.FMMMapStateMethodId.sMapSetTrafficRoteMethod:
            case Constants.FMMMapStateMethodId.sMapUpDataTrafficMethod:
            case Constants.FMMMapStateMethodId.sMapSetAreaTrafficMethod:
            case Constants.FMMMapStateMethodId.sMapSetRepaintMethod:
            case Constants.FMMMapStateMethodId.sMapSetDebugActiveMethod:
            case Constants.FMMMapStateMethodId.sMapIsDebugActiveMethod:
            case Constants.FMMMapStateMethodId.sMapResetNorthMethod:
            case Constants.FMMMapStateMethodId.sMapCancelTransitionsMethod:
            case Constants.FMMMapStateMethodId.sMapMoveCameraMethod:
            case Constants.FMMMapStateMethodId.sMapEaseCameraMethod:
            case Constants.FMMMapStateMethodId.sMapAnimateCameraMethod:
            case Constants.FMMMapStateMethodId.sMapGetCameraPositionMethod:
            case Constants.FMMMapStateMethodId.sMapSetLatLngBoundsForCameraTargetMethod:
            case Constants.FMMMapStateMethodId.sMapGetCameraForLatLngBoundsMethod:
            case Constants.FMMMapStateMethodId.sMapSetPaddingMethod:
            case Constants.FMMMapStateMethodId.sMapGetPaddingMethod:
            case Constants.FMMMapStateMethodId.sMapSetMultipleInfoWindowsMethod:
            case Constants.FMMMapStateMethodId.sMapAddImageMethod:
            case Constants.FMMMapStateMethodId.sMapAddImagesMethod:
            case Constants.FMMMapStateMethodId.sMapRemoveImageMethod:
            case Constants.FMMMapStateMethodId.sMapRemoveImagesMethod:
            case Constants.FMMMapStateMethodId.sMapRemoveImagesAllMethod:
            case Constants.FMMMapStateMethodId.sMapGetImageMethod:
            case Constants.FMMMapStateMethodId.sMapOfflineDataUpdateMethod:
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
