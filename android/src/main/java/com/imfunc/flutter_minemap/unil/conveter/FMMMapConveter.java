package com.imfunc.flutter_minemap.unil.conveter;

import com.minedata.minemap.geometry.LatLng;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class FMMMapConveter {
    public static List<?> toList(Object o) {
        return (List<?>) o;
    }

    public static Map<?, ?> toMap(Object o) {
        return o != null ? (Map<?, ?>) o : null;
    }

    public static Boolean toBoolean(Object o) {
        return o != null ? (Boolean) o : null;
    }

    public static Integer toInt(Object o) {
        return o != null ? ((Number) o).intValue() : null;
    }

    public static Double toDouble(Object o) {
        return o != null ? ((Number) o).doubleValue() : null;
    }

    public static Float toFloat(Object o) {
        return o != null ? ((Number) o).floatValue() : null;
    }

    /**
     * 将map形式的经纬度信息转换为结构化的经纬度数据
     *
     * @param latlngMap
     * @return
     */
    public static LatLng mapToLatlng(Map<String, Object> latlngMap) {
        if (null == latlngMap) {
            return null;
        }

        if (!latlngMap.containsKey("latitude")
                || !latlngMap.containsKey("longitude")) {
            return null;
        }

        Object latitudeObj = latlngMap.get("latitude");
        Object longitudeObj = latlngMap.get("longitude");
        if (null == latitudeObj || null == longitudeObj) {
            return null;
        }
        return new LatLng((double) latitudeObj, (double) longitudeObj);
    }

    /**
     * 将多个map形式的经纬度信息转换为结构化的经纬度数据
     *
     * @param latlngList
     * @return
     */
    public static List<LatLng> mapToLatlngs(List<Map<String, Double>> latlngList) {
        if (null == latlngList) {
            return null;
        }

        Iterator itr = latlngList.iterator();
        ArrayList<LatLng> latLngs = new ArrayList<>();
        while (itr.hasNext()) {
            Map<String, Object> latlngMap = (Map<String, Object>) itr.next();
            LatLng latLng = mapToLatlng(latlngMap);
            if (null == latLng) {
                break;
            }

            latLngs.add(latLng);
        }

        if (latLngs.size() != latlngList.size()) {
            return null;
        }

        return latLngs;
    }

}
