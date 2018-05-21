package com.example.guth27.progtech;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Window;
import android.view.WindowManager;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends Activity {

    private int score;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        Info.SetScreenVolumes(displayMetrics);

        databaseHelper = new DatabaseHelper(this);
        Info.SetStartTime(System.nanoTime());
        GamePanel g = new GamePanel(this, this);
        setContentView(g);


    }


    public Context getContext()
    {
        Context context = new MainActivity();
        return context;
    }
    public void setScore(int sc){
        score = sc;
    }

    @Override
    public void finish() {
        Calendar calendar;
        SimpleDateFormat simpleDateFormat;
        String date;


        calendar = Calendar.getInstance();
        simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        date = simpleDateFormat.format(calendar.getTime());


        databaseHelper.addData(String.valueOf(score),date);

        super.finish();
    }
}
