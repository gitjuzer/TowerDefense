package com.example.guth27.progtech;

public class User
{

    private  String score;
    private String date;

    public User( String score, String date)
    {
        this.score = score;
        this.date = date;
    }

    public String getScore() {
        return score;
    }

    public String getDate() {
        return date;
    }
}