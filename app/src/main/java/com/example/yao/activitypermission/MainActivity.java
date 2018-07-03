package com.example.yao.activitypermission;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        callPhone();
    }

    private void callPhone() {

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case PermissionTool.PHONE_PERMISSION:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    //打电话
                }else {
                    //提示未被授予权限
                }
                break;

            case PermissionTool.WRITE_PERMISSION:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    //
                }else {
                    //
                }
                break;
        }
    }
}
