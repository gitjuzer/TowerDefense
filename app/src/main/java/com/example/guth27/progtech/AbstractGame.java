package com.example.guth27.progtech;

import Interfaces.GameObject;

/**
 * Created by guth2 on 2018. 04. 26.
 * The abstract class the game. Makes the gameobjectHolder accessable.
 */

public abstract class AbstractGame {

    protected GameObjectHolder Holder;

    protected AbstractGame(GameObjectHolder holder)
    {
        this.Holder = holder;
    }

    public abstract  void Start();
    public abstract  void Update();
}
