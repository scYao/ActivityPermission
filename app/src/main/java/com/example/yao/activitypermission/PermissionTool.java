package com.example.yao.activitypermission;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

public class PermissionTool {
    public static final int PHONE_PERMISSION=0;
    public static final int WRITE_PERMISSION=1;

    /**
     * 检查是否有电话权限
     * @param context
     * @return
     */
    public static boolean checkPhonePermisson(Context context) {
        //判断是否授权
        if (ContextCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            //申请权限
            return false;
        } else {
            return true;
        }
    }

    /**
     * 申请电话权限
     * @param activity
     */
    public static void requestPhonePermission(Activity activity){
        ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.CALL_PHONE}, PHONE_PERMISSION);
    }


    /**
     * 检查是否有写权限
     * @param context
     * @return
     */
    public static boolean checkWritePermission(Context context){
        if (ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
            return false;
        }else {
            return true;
        }
    }

    public static void requestWritePermission(Activity activity){
        ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE} ,WRITE_PERMISSION);
    }




}
