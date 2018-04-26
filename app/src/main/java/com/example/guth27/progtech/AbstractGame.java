package com.example.guth27.progtech;

import Interfaces.GameObject;

/**
 * Created by guth2 on 2018. 04. 26..
 */

public abstract class AbstractGame {

    private GameObjectHolder holder;

    protected AbstractGame(GameObjectHolder holder)
    {
        this.holder = holder;
    }

    protected void AddGameObjectToLayer0(GameObject object)
    {
        holder.AddGameObjectToHolderLayer0(object);
    }
    protected void AddGameObjectToLayer1(GameObject object)
    {
        holder.AddGameObjectToHolderLayer1(object);
    }
    protected void AddGameObjectToLayer2(GameObject object)
    {
        holder.AddGameObjectToHolderLayer2(object);
    }
    protected void AddGameObjectToLayer3(GameObject object)
    {
        holder.AddGameObjectToHolderLayer3(object);
    }
    protected void AddGameObjectToLayer4(GameObject object)
    {
        holder.AddGameObjectToHolderLayer4(object);
    }
    protected void AddGameObjectNonDrawable(GameObject object)
    {
        holder.AddGameObjectToHolderNonDrawable(object);
    }
    protected void RemoveGameObject(GameObject object)
    {
        object.OnDestroy();
        holder.RemoveGameObjectFromHolder(object);
    }
    public abstract  void Start();
    public abstract  void Update();
}
