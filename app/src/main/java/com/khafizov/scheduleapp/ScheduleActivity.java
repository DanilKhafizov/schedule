package com.khafizov.scheduleapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class ScheduleActivity extends AppCompatActivity {
    boolean isButtonClicked = false;
    private LinearLayout dateContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);
        dateContainer = findViewById(R.id.dateContainer);
//
//        List<String> scheduleList = new ArrayList<>(); // Замените это на ваш список расписания
//        ScheduleAdapter.OnDateClickListener listener = new ScheduleAdapter.OnDateClickListener() {
//            @Override
//            public void onDateClick(String date) {
//                // Обработка щелчка по дате
//            }
//        };
//
//        ScheduleAdapter adapter = new ScheduleAdapter(scheduleList, listener);
//        RecyclerView recyclerView = findViewById(R.id.dateRecyclerView);
//        recyclerView.setAdapter(adapter);
//
//        loadSchedule();
//
//

        // Добавьте кнопки с датами тренировок

        addDateButton("06-12-2023");
        addDateButton("07-12-2023");
        addDateButton("08-12-2023");
        addDateButton("09-12-2023");
        addDateButton("10-12-2023");
        addDateButton("11-12-2023");
        addDateButton("12-12-2023");
        addDateButton("13-12-2023");
        addDateButton("14-12-2023");
        addDateButton("15-12-2023");
        addDateButton("16-12-2023");
        addDateButton("17-12-2023");
        addDateButton("18-12-2023");
        addDateButton("19-12-2023");
        addDateButton("20-12-2023");
        addDateButton("21-12-2023");
        addDateButton("22-12-2023");
        addDateButton("23-12-2023");
        addDateButton("24-12-2023");
        addDateButton("25-12-2023");
        addDateButton("26-12-2023");
        addDateButton("27-12-2023");
        addDateButton("28-12-2023");
        addDateButton("29-12-2023");
        addDateButton("30-12-2023");
        addDateButton("31-12-2023");
        BottomNavigationView bottomNavigationView = findViewById(R.id.main_menu);
        bottomNavigationView.setSelectedItemId(R.id.bottom_schedule);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.bottom_home:
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    finish();
                    return true;
                case R.id.bottom_schedule:
                    return true;  }return false; });}
    private void addDateButton(String date) {
        Button button = new Button(this);
        button.setText(date);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(0, 0, 15, 0);
        button.setLayoutParams(layoutParams);
        button.setBackgroundResource(R.color.button_style);
        button.setOnClickListener(v -> showTrainingInfo(date));  dateContainer.addView(button); }



    private void showTrainingInfo(String date) {
        // Замените Fragment на ваш фрагмент для отображения информации о тренировках
        Fragment fragment = new ScheduleInfoFragment();

        // Передача даты во фрагмент
        Bundle bundle = new Bundle();
        bundle.putString("date", date);
        fragment.setArguments(bundle);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.dateFragmentContainer, fragment)
                .commit();
    }
//
//    private void loadSchedule() {
//        AsyncTask<Void, Void, List<Schedule>> loadScheduleTask = new AsyncTask<Void, Void, List<Schedule>>() {
//            private ScheduleDao scheduleDao;
//            @Override
//            protected List<Schedule> doInBackground(Void... voids) {
//                ScheduleDatabase scheduleDatabase = ScheduleDatabase.getInstance(getApplicationContext());
//                scheduleDao = scheduleDatabase.scheduleDao();
//
//                return scheduleDao.getAllSchedules();
//            }
//
//            @Override
//            protected void onPostExecute(List<Schedule> schedules) {
//                // Выполните необходимые действия с полученными расписаниями
//                // Получить все расписания
//                List<Schedule> allSchedules = schedules;
//
//                // Вставить новое расписание
//                Schedule newSchedule = new Schedule();
//                newSchedule.setDate("2022-01-01");
//                newSchedule.setSchedule("Расписание на 1 января");
//                new AsyncTask<Void, Void, Void>() {
//                    @Override
//                    protected Void doInBackground(Void... voids) {
//                        scheduleDao.insertSchedule(newSchedule);
//                        return null;
//                    }
//                }.execute();
//
//                // Обновить существующее расписание
//                new AsyncTask<Void, Void, Void>() {
//                    @Override
//                    protected Void doInBackground(Void... voids) {
//                        Schedule existingSchedule = scheduleDao.getScheduleById("1");
//                        existingSchedule.setSchedule("Новое расписание на 1 января");
//                        scheduleDao.updateSchedule(existingSchedule);
//                        return null;
//                    }
//                }.execute();
//
//                // Удалить расписание
//                // ...
//
//            }
//        };
//
//        loadScheduleTask.execute();

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(ScheduleActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
        super.onBackPressed();
    }


}
