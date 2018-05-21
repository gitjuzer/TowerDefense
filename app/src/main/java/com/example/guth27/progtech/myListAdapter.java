package com.example.guth27.progtech;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class myListAdapter extends ArrayAdapter<User>
{
    private LayoutInflater inflater;
    private ArrayList<User> users;
    private  int viewRedId;

    public myListAdapter(Context context, int resId, ArrayList<User> users)
    {
        super(context,resId,users);
        this.users = users;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.viewRedId = resId;
    }

    public View getView (int position , View convertView, ViewGroup parents)
    {
        convertView = this.inflater.inflate(this.viewRedId,null);
        User user = this.users.get(position);

        if(user!=null)
        {

            TextView score = (TextView) convertView.findViewById(R.id.scoreID);
            TextView date  = (TextView) convertView.findViewById(R.id.timeID);
//
            if (score!=null) score.setText(user.getScore());
            if (date!=null) date.setText(user.getDate());
        }

        return convertView;
    }
}