package com.joonhuiwong.imageslider.utility;

import android.os.Environment;
import android.util.Log;

import java.io.File;

public class FileUtils {

    public static final String APP_FOLDER = "ImageSlider";

    public static void createAppDirectory() {
        File appDirectory = new File(FileUtils.getAppDirectory());

        if (!appDirectory.exists()) {
            appDirectory.mkdirs();
        }
    }

    public static File[] getFilesFromDirectory() {
        // Ensure that directort exists
        FileUtils.createAppDirectory();

        // Get all files in directory
        File appDirectory = new File(FileUtils.getAppDirectory());
        File[] filesList = appDirectory.listFiles();

        // Any processing?
        for (File file : filesList) {
            Log.d("TAG", file.getAbsolutePath());
        }

        return filesList;
    }

    public static String getAppDirectory() {
        return Environment.getExternalStorageDirectory().getAbsolutePath()+ File.separator+ APP_FOLDER + File.separator;
    }

}
