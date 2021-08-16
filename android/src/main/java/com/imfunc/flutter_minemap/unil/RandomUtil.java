package com.imfunc.flutter_minemap.unil;

import android.graphics.Color;

import com.minedata.minemap.geometry.LatLng;

import java.util.Random;

/**
 * 随机内容制造类
 * Created by lijingru on 2018/10/30.
 */
public class RandomUtil {


    //随机颜色
    public static int randomColor() {
        Random random = new Random();
        int r = random.nextInt(256);
        int g = random.nextInt(256);
        int b = random.nextInt(256);
        return Color.rgb(r, g, b);

    }


    private static double x1 = 123.4418114224643;
    private static double y1 = 41.810246132876834;
    private static double x2 = 123.42520318622724;
    private static double y2 = 41.79582892686385;
//随机点
//    private fun randomLatLon(latLng1: LatLng, latLng2: LatLng): LatLng {

    //        val x1 = latLng1.longitude
//        val y1 = latLng1.latitude
//        val x2 = latLng2.longitude
//        val y2 = latLng2.latitude
    public static LatLng randomLatLon() {

        double x = x2 + (x1 - x2) * Math.random();
        double y = y2 + (y1 - y2) * Math.random();

        return new LatLng(y, x);
    }
}
