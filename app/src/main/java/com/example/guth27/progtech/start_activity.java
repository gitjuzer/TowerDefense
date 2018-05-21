package com.example.guth27.progtech;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class start_activity extends AppCompatActivity implements View.OnClickListener{

    Button start;
    Button loadData;
    Button exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_activity);

        this.start = findViewById(R.id.startBT);
        this.loadData = findViewById(R.id.dataBT);
        this.exit = findViewById(R.id.exitBT);

        this.start.setOnClickListener(this);
        this.loadData.setOnClickListener(this);
        this.exit.setOnClickListener(this);

    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.startBT:
                Intent homeIntent = new Intent(this,MainActivity.class);
                this.startActivity(homeIntent);
                break;
            case R.id.dataBT:
                Intent loadDatas = new Intent(this, ListDataView_activity.class);
                this.startActivity(loadDatas);
                break;
            case R.id.exitBT:
                this.finish();
                break;
        }

    }
}
