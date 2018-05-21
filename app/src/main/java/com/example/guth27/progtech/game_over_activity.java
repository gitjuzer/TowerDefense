package com.example.guth27.progtech;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class game_over_activity extends AppCompatActivity implements View.OnClickListener{

    Button backtostart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over_activity);

        this.backtostart = findViewById(R.id.backStartBT);
        this.backtostart.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.backStartBT:
               // Intent intent = new Intent(this, View.start_activity.class);
                break;
        }

    }

    public Context getContext()
    {
        Context context = new game_over_activity();
        return context;
    }
}
