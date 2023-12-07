package com.khafizov.scheduleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RelativeLayout scheduleBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scheduleBtn = findViewById(R.id.schedule_btn);
        scheduleBtn.setOnClickListener(v -> showScheduleActivity() );
        ImageSlider imageSlider = findViewById(R.id.imageSlider);
        ArrayList<SlideModel> slideModels = new ArrayList<>();
        BottomNavigationView bottomNavigationView = findViewById(R.id.main_menu);
        bottomNavigationView.setSelectedItemId(R.id.bottom_home);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.bottom_home:
                    return true;
                case R.id.bottom_schedule:
                    startActivity(new Intent(getApplicationContext(), ScheduleActivity.class));
                    finish();
                    return true; }return false;  });
        slideModels.add(new SlideModel(R.drawable.pavel, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.jason, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.sarah, ScaleTypes.FIT));
        imageSlider.setImageList(slideModels, ScaleTypes.FIT);}
    public void showScheduleActivity()
    {
        Intent intent = new Intent(MainActivity.this, ScheduleActivity.class);
        startActivity(intent);
        finish();
    }

}