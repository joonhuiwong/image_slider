package com.joonhuiwong.imageslider.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.joonhuiwong.imageslider.R;
import com.joonhuiwong.imageslider.utility.PermissionUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Have to ask for permissions before letting user do anything
        // that might trigger something related to the permissions
        PermissionUtil.checkForPermissions(this);

        Button buttonToSliderPage = findViewById(R.id.buttonToSliderPage);
        buttonToSliderPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), SliderActivity.class));
            }
        });
    }
}