package com.joonhuiwong.imageslider.utility;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;

import androidx.core.content.ContextCompat;

import static androidx.core.app.ActivityCompat.requestPermissions;

public class PermissionUtil {

    private static final int READ_EXTERNAL_STORAGE_PERMISSION_CODE = 30;

    public static void checkForPermissions(Activity activity) {

        //check for permission
        if (ContextCompat.checkSelfPermission(activity, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED){
            requestPermissions(activity, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, PermissionUtil.READ_EXTERNAL_STORAGE_PERMISSION_CODE);
        }

    }
}
