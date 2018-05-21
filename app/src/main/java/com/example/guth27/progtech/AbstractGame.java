package com.example.guth27.progtech;

import Interfaces.GameObject;

/**
 * Created by guth2 on 2018. 04. 26.
 * The abstract class the game. Makes the gameobjectHolder accessable.
 */

public abstract class AbstractGame {

    protected GameObjectHolder Holder;
    protected MainActivity mainActivity;

    protected AbstractGame(MainActivity mainActivity)
    {
        this.Holder =GameObjectHolder.GetInstance();
        this.mainActivity = mainActivity;
    }

    public abstract  void Start();
    public abstract  void Update();

    public void SetBackGroundColor(int color)
    {
        Info.SetColor(color);
    }
}
