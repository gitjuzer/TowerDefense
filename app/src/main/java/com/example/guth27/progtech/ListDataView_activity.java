package com.example.guth27.progtech;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class ListDataView_activity extends AppCompatActivity implements View.OnClickListener {

    Button back;
    public  static  final String TAG = "ListData";

    DatabaseHelper databaseHelper;
    ArrayList<User> userlist;
    private ListView mylistView;
    User user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_data_view_activity);

        this.back = findViewById(R.id.backBT);
        this.back.setOnClickListener(this);

        this.databaseHelper = new DatabaseHelper(this);
        this.userlist = new ArrayList<User>();
        Cursor data = this.databaseHelper.getData();
        int rowNum = data.getCount();


        while (data.moveToNext())
        {
            this.user = new  User(data.getString(1),data.getString(2));
            this.userlist.add(this.user);

        }
        myListAdapter listAdapter = new myListAdapter(this, R.layout.list_adapter_view, this.userlist) {
        };
        this.mylistView=(ListView)findViewById(R.id.listView);
        this.mylistView.setAdapter(listAdapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.backBT:
                this.finish();
                break;
        }
    }
}
