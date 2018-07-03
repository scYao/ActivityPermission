package com.example.yao.activitypermission;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /**
     * 权限检查
     * @param permissions
     * @return
     */
    public boolean checkPermission(String... permissions) {
        for (String permission:
              permissions) {
            if (ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED){
                return false;
            }
        }


        return true;
    }

    /**
     * 权限请求
     * @param code
     * @param permissions
     */
    public void requestPermission(int code, String... permissions){
        ActivityCompat.requestPermissions(this,permissions, code);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode){

            case Constant.WRITE_EXTERNAL_STORAGE:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    doSDCardPermission();
                }

                break;
        }
    }

    private void doSDCardPermission() {
    }
}
