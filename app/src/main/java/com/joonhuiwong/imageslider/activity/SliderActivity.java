package com.joonhuiwong.imageslider.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import com.joonhuiwong.imageslider.R;
import com.joonhuiwong.imageslider.model.SliderData;
import com.joonhuiwong.imageslider.adapter.SliderAdapter;
import com.joonhuiwong.imageslider.utility.FileUtils;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.io.File;
import java.util.ArrayList;

public class SliderActivity extends AppCompatActivity {

    private SliderAdapter adapter;
    private ArrayList<SliderData> sliderDataArrayList;
    private SliderView sliderView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider);

        sliderDataArrayList = new ArrayList<>();

        sliderView = findViewById(R.id.slider);

        loadImages();
    }

    @SuppressLint("ClickableViewAccessibility")
    private void loadImages() {

        // Populate the ArrayList with the images in form of SliderData. This can be from API or files or database.
        File[] files = FileUtils.getFilesFromDirectory();
        for (File f : files) {
            SliderData model = new SliderData(f.getPath());

            sliderDataArrayList.add(model);
        }

        // Setup the SliderAdapter
        adapter = new SliderAdapter(this, sliderDataArrayList);
        sliderView.setSliderAdapter(adapter);

        // SliderView can have only ONE animation set to it.
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);

        // Back and Forth makes the slider "start from beginning" when it reaches the end.
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);

        // Scroll timer in seconds
        sliderView.setScrollTimeInSec(3);

        // Set auto cycling
        sliderView.setAutoCycle(true);

        // Override swipe function (default is being able to swipe left and right manually as well)
        sliderView.getSliderPager().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });

        // Starts the auto cycling
        sliderView.startAutoCycle();
    }
}