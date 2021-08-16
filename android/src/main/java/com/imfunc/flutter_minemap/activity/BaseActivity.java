package com.imfunc.flutter_minemap.activity;

import android.app.ActivityManager;
import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class BaseActivity extends AppCompatActivity {
    public static boolean isActive = true; //全局变量

    /**
     * 当前activity
     */
    public static BaseActivity gCurrentActivity;

    /**
     * Activity堆栈
     */
    public static List<BaseActivity> activityList = new ArrayList<BaseActivity>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        BaseActivty.closeDialog();
        BaseActivity.activityList.add(this);
        BaseActivity.gCurrentActivity = this;
    }

    /**
     * onStart
     */
    protected void onStart() {
        super.onStart();
        BaseActivity.gCurrentActivity = this;
    }

    @Override
    protected void onPause() {
        super.onPause();
    }


    @Override
    protected void onResume() {
        super.onResume();
        BaseActivity.gCurrentActivity = this;
    }

    @Override
    protected void onStop() {
        isActive = true;
        if (!isAppOnForeground()) {
            //app 进入后台
            isActive = false;//记录当前已经进入后台
        }
        super.onStop();
        Boolean val = false;
        for (int i = BaseActivity.activityList.size() - 1; i >= 0; i--) {
            if (BaseActivity.activityList.get(i).hasWindowFocus()) {
                val = true;
                break;
            }
        }
        if (!val) {
            // 在来电 等时机调用 用作切出程序接口
            this.ExitWithHalf();
        }
    }

    /**
     * // Deal with call and sms 来电 发送短信 打电话 时被调用
     */
    protected void ExitWithHalf() {
        // 来电时认为程序进入后台
    }

    @Override
    protected void onDestroy() {
        BaseActivity.activityList.remove(this);
        this.finish();
        super.onDestroy();
    }

    /**
     * // 判断参数换页是否打开
     *
     * @param class1 Class
     * @return boolean
     */
    public static Boolean IsActivityOpened(Class<?> class1) {
        Boolean val = false;
        if (activityList == null) {
            return val;
        }
        for (int i = BaseActivity.activityList.size() - 1; i >= 0; i--) {
            if (BaseActivity.activityList.get(i) == null) {
                continue;
            }
            if (class1.equals(BaseActivity.activityList.get(i).getClass())) {
                val = true;
                break;
            }
        }
        return val;
    }

    /**
     * // 判断参数页是否是当前页
     *
     * @param class1 Class
     * @return boolean
     */
    public static Boolean isCurrentActivity(Class<?> class1) {
        Boolean val = false;
        if (activityList == null || activityList.size() == 0) {
            return val;
        }
        int i = BaseActivity.activityList.size() - 1;

        if (class1.equals(BaseActivity.activityList.get(i).getClass())) {
            val = true;

        }

        return val;
    }

    /**
     * // 退回到参数画页(画页以存在)
     *
     * @param class1 Class
     */
    public static boolean ExitToActivity(Class<?> class1) {
        boolean flag = false;
        if (flag = BaseActivity.IsActivityOpened(class1)) {
            for (int i = BaseActivity.activityList.size() - 1; i > 0; i--) {
                if (null != BaseActivity.activityList.get(i)) {
                    if (class1.equals(BaseActivity.activityList.get(i).getClass())) {
                        break;
                    } else {
                        BaseActivity baseActivity = BaseActivity.activityList.get(i);
                        baseActivity.onActivityFinished();
                    }
                }
            }
        }
        return flag;
    }

    /**
     * 关闭已存在的画页
     *
     * @param class1 Class
     */
    public static boolean CloseActivity(Class<?> class1) {
        boolean flag = false;
        if (flag = BaseActivity.IsActivityOpened(class1)) {
            for (int i = BaseActivity.activityList.size() - 1; i > 0; i--) {
                if (null != BaseActivity.activityList.get(i)) {
                    if (class1.equals(BaseActivity.activityList.get(i).getClass())) {
                        BaseActivity baseActivity = BaseActivity.activityList.get(i);
                        baseActivity.onActivityFinished();
                    }
                }
            }
        }
        return flag;
    }

    /**
     * // 退回到参数画页(画页以存在并且包括此画页)
     *
     * @param class1 Class
     */
    public static boolean ExitToActivityIncludeCurrent(Class<?> class1) {
        boolean flag = false;
        if (flag = BaseActivity.IsActivityOpened(class1)) {
            for (int i = BaseActivity.activityList.size() - 1; i > 0; i--) {
                if (null != BaseActivity.activityList.get(i)) {
                    if (class1.equals(BaseActivity.activityList.get(i).getClass())) {
                        BaseActivity baseActivity = BaseActivity.activityList.get(i);
                        baseActivity.onActivityFinished();
                        break;
                    } else {
                        BaseActivity baseActivity = BaseActivity.activityList.get(i);
                        baseActivity.onActivityFinished();
                    }
                }
            }
        }
        return flag;
    }


    /**
     * // 删除参数与MX以外的画页
     *
     * @param class1 Class
     */
    public static void ClearActivityExceptClass(Class<?> class1) {
        for (int i = BaseActivity.activityList.size() - 1; i > 1; i--) {
            if (null != BaseActivity.activityList.get(i)) {
                if (!class1.equals(BaseActivity.activityList.get(i).getClass())) {
                    BaseActivity baseActivity = BaseActivity.activityList.get(i);
                    baseActivity.onActivityFinished();
                }
            }
        }
    }

    /**
     * 主进程是否已经启动
     *
     * @return
     */
    public static boolean isMainProcessStart() {
        return activityList != null && activityList.size() != 0;
    }

    /**
     * @param class1 Class
     *               // 退回到参数画页前一画页(画页以存在)
     */
    public static void ExitToActivityBefore(Class<?> class1) {
        if (BaseActivity.IsActivityOpened(class1)) {
            for (int i = BaseActivity.activityList.size() - 1; i > 0; i--) {
                if (null != BaseActivity.activityList.get(i)) {
                    if (class1.equals(BaseActivity.activityList.get(i).getClass())) {
                        BaseActivity baseActivity = BaseActivity.activityList.get(i);
                        baseActivity.onActivityFinished();
                        break;
                    } else {
                        BaseActivity baseActivity = BaseActivity.activityList.get(i);
                        baseActivity.onActivityFinished();
                    }
                }
            }
        }
    }

    /**
     * 专门处理activity消亡之前的操作。因为ondestory的操作执行的时间不固定。
     */
    protected void onActivityFinished() {
        activityList.remove(this);
        this.finish();
    }

    /**
     * 退出所有界面
     */
    public static void ExitAllActivity() {
        for (int i = BaseActivity.activityList.size() - 1; i >= 0; i--) {
            if (null != BaseActivity.activityList.get(i)) {
                BaseActivity baseActivity = BaseActivity.activityList.get(i);
                baseActivity.onActivityFinished();
            }
        }

    }

    /**
     * 退出程序
     */
    public static void ExitProgram() {
        if (null != BaseActivity.gCurrentActivity) {
            try {
                //TODO 程序退出时，清除通知
                BaseActivity.gCurrentActivity.clearNotification();
            } catch (Throwable e) {
                e.printStackTrace();
            }
            try {
            } catch (Throwable e) {
                e.printStackTrace();
            }
        }
        try {
            //TODO 暂停全部任务
        } catch (Throwable e) {
            e.printStackTrace();
        }

        try {
            ExitAllActivity();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        //TODO 关闭引擎
//		ProviderFactory.getInstance().shutdown();
        //系统通知栏消去,不消去通知栏
//		NotifyManager.instance.clearAll();
//		if (BaseActivity.gCurrentActivity != null) {
////			延迟3秒执行
//			IMService.startService();
//		}

        System.exit(0);
    }

    public void clearNotification() {

    }

    private boolean dispatchTouchEventAb = true;

    public void setDispatchTouchEventAb(boolean dispatchTouchEventAb) {
        this.dispatchTouchEventAb = dispatchTouchEventAb;
    }

    /**
     * 点击edit之外的地方 键盘隐去
     *
     * @param ev
     * @return
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            if (dispatchTouchEventAb) {

                View v = getCurrentFocus();
                if (isShouldHideInput(v, ev)) {

                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    if (imm != null) {
                        imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                    }
                }
            }
            return super.dispatchTouchEvent(ev);
        }
        // 必不可少，否则所有的组件都不会有TouchEvent了
        if (getWindow().superDispatchTouchEvent(ev)) {
            return true;
        }
        return onTouchEvent(ev);
    }

    private boolean isShouldHideInput(View v, MotionEvent event) {
        if (v != null && (v instanceof EditText)) {
            int[] leftTop = {0, 0};
            //获取输入框当前的location位置
            v.getLocationInWindow(leftTop);
            int left = leftTop[0];
            int top = leftTop[1];
            int bottom = top + v.getHeight();
            int right = left + v.getWidth();
            if (event.getX() > left && event.getX() < right
                    && event.getY() > top && event.getY() < bottom) {
                // 点击的是输入框区域，保留点击EditText的事件
                return false;
            } else {
                return true;
            }
        }
        return false;
    }


    private static long mLastTime = 0l;
    private static String mLastStr = "";


    public static void snackbar(View view, String str) {
        snackbar(
                view, str, Snackbar.LENGTH_SHORT);
    }

    public static void snackbar(View view, String snackStr, int duration) {
        if (null == snackStr || "".equals(snackStr)) {
            return;
        }
        if (System.currentTimeMillis() - mLastTime < 3000) {
            if (snackStr.equals(mLastStr)) {
                return;
            }
        }
        mLastStr = snackStr;
        mLastTime = System.currentTimeMillis();
        try {
            Snackbar.make(
                    view, snackStr, duration).show();
        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }

    public static void showToast(int sToastId) {
        String sToast = BaseActivity.gCurrentActivity.getString(sToastId);
        showToast(sToast);
    }


    public static void showToast(String sToast) {
        if (null == sToast || "".equals(sToast)) {
            return;
        }
        if (System.currentTimeMillis() - mLastTime < 3000) {
            if (sToast.equals(mLastStr)) {
                return;
            }
        }
        mLastStr = sToast;
        mLastTime = System.currentTimeMillis();
        try {
            Toast toast = Toast.makeText(gCurrentActivity, sToast, Toast.LENGTH_SHORT);
            toast.show();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public static void showToast(String sToast, int duration) {
        if (null == sToast || "".equals(sToast)) {
            return;
        }
        if (System.currentTimeMillis() - mLastTime < 3000) {
            if (sToast.equals(mLastStr)) {
                return;
            }
        }
        mLastStr = sToast;
        mLastTime = System.currentTimeMillis();
        try {
            Toast toast = Toast.makeText(gCurrentActivity, sToast, duration);
            toast.show();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

//    public static void showMiddleToast(String str){
//        Toast toast = new Toast(gCurrentActivity);
//        toast.setGravity(Gravity.CENTER, 0, 0);
//        View v = gCurrentActivity.getLayoutInflater().inflate(R.layout.toast_layout, null);
//        TextView textView = (TextView) v.findViewById(R.id.toast_text);
//        textView.setText(str);
//        toast.setView(v);
//        toast.setDuration(Toast.LENGTH_SHORT);
//        toast.show();
//    }

//    /**
//     * 提示对话框
//     */
//    public static OperationStateDialog dialog;
//    public static OperationTransparentDialog transparentDialog;
//    public static HintDialog reloginDialog;
//
//    /**
//     * 显示Dialog
//     * @param context 上下文对象
//     * @param message 内容
//     * @param cancelable 是否可取消
//     * @param cancelListener 取消的处理
//     */
//    public static void showDialog(Context context, CharSequence message,
//                                  boolean cancelable, DialogInterface.OnCancelListener cancelListener){
//        try{
//            if (dialog != null && dialog.isShowing()){
//                dialog.dismiss();
//            }
//            dialog = new OperationStateDialog(context, R.style.ImageloadingDialogStyle, message.toString());
//            dialog.setCancelable(cancelable);
//            dialog.setOnCancelListener(cancelListener);
//            dialog.setCanceledOnTouchOutside(false);
//            dialog.show();
//        }catch(Exception ex){}
//    }
//
//    /**
//     * 显示transparentDialog
//     * @param context 上下文对象
//     * @param message 内容
//     * @param cancelable 是否可取消
//     * @param cancelListener 取消的处理
//     */
//    public static void showTransparentDialog(Context context, CharSequence message,
//                                             boolean cancelable, DialogInterface.OnCancelListener cancelListener){
//        try{
//            if (transparentDialog != null && transparentDialog.isShowing()){
//                transparentDialog.dismiss();
//            }
//            transparentDialog = new OperationTransparentDialog(context, R.style.ImageloadingDialogStyle, message.toString());
//            transparentDialog.setCancelable(cancelable);
//            transparentDialog.setOnCancelListener(cancelListener);
//            transparentDialog.setCanceledOnTouchOutside(false);
//            transparentDialog.show();
//        }catch(Exception ex){}
//    }
//
//
//
//    public static void showDialog(Context context){
//        try{
//            if (dialog != null && dialog.isShowing()){
//                dialog.dismiss();
//            }
//            dialog = new OperationStateDialog(context, R.style.ImageloadingDialogStyle, "加载中...".toString());
//            dialog.setCancelable(false);
//            dialog.setOnCancelListener(null);
//            dialog.setCanceledOnTouchOutside(false);
//            dialog.show();
//        }catch(Exception ex){}
//    }
//
//
//    /**
//     * 关闭Dialog
//     */
//    public static void closeDialog(){
//        try{
//            if (null != dialog) {
//                if(dialog.isShowing()){
//                    dialog.dismiss();
//                }
//                dialog = null;
//            }
//            if (null != transparentDialog) {
//                if(transparentDialog.isShowing()){
//                    transparentDialog.dismiss();
//                }
//                transparentDialog = null;
//            }
//        }catch(Exception ex){}
//    }

    /**
     * 需要对GPS响应的 只需继承此回调即可
     *
     * @param location
     */
    public void locationChanged(Location location) {

    }

    /**
     * 需要对GPS 状态响应的 只需继承此回调即可
     */
    public void gpsStatus(int count) {

    }

//	@Override
//	public void onChangeDayAndNight(){
//
//	}

    /**
     * APP是否处于前台唤醒状态
     *
     * @return
     */
    public boolean isAppOnForeground() {
        ActivityManager activityManager = (ActivityManager) getApplicationContext().getSystemService(Context.ACTIVITY_SERVICE);
        String packageName = getApplicationContext().getPackageName();
        List<ActivityManager.RunningAppProcessInfo> appProcesses = activityManager
                .getRunningAppProcesses();
        if (appProcesses == null)
            return false;

        for (ActivityManager.RunningAppProcessInfo appProcess : appProcesses) {
            // The name of the process that this object is associated with.
            if (appProcess.processName.equals(packageName)
                    && appProcess.importance == ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND) {
                return true;
            }
        }

        return false;
    }
}
