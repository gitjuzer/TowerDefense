package com.example.guth27.progtech;

import android.util.DisplayMetrics;

import Interfaces.GameObject;

/**
 * Created by guth2 on 2018. 04. 22..
 */

public final class Info {
    private static int lastTapX;
    private static int lastTapY;
    private static int screen_Widht;
    private static int screen_Height;
    private static long startnanoTime;
    private static long totalRunningTime = 0;
    private static byte FPS = 30;
    private static GameObject selectedGameObject;
    private static GameObject previouslySelected;
    private static boolean anObjectIsSelectedFromMovement;


    private static boolean firstSelect = true;

    public static void SetAnObjectIsSelectedFroMovement(boolean isSelected)
    {
        anObjectIsSelectedFromMovement = isSelected;
    }
    public static boolean IsSomeThingSelectedForMovement()
    {
        return anObjectIsSelectedFromMovement;
    }

    private static void SetPreviouslySelectedGameObject(GameObject gameObject){
        previouslySelected = gameObject;
    }
    public static GameObject GetPreviouslySelectedGameObject() {
        return previouslySelected;
    }
    public static void SetSelectedGameObject(GameObject selected)
    {
        if(firstSelect)
            firstSelect = false;
        else
            SetPreviouslySelectedGameObject(selectedGameObject);
        selectedGameObject = selected;
    }
    public GameObject GetSelectedGameObject(){
        return selectedGameObject;
    }
    public static byte GetFPSrate()
    {
        return FPS;
    }
    public static void SetTotalRunningTime(long totalTime)
    {
     totalRunningTime += totalTime;
    }
    public static long GetTotalRunningTimeMS()
    {
        return totalRunningTime/1000000;
    }
    public static void SetStartTime(long starttime)
    {
        startnanoTime = starttime;
    }
    public static long GetStartTimeMS()
    {
        return startnanoTime/1000000;
    }
    public static void SetLastTap(int x, int y) {
        lastTapX = x;
        lastTapY = y;
    }
    public static int GetLastTapX(){
        return lastTapX;
    }
    public static int GetLastStepY(){
        return lastTapY;
    }

    public static int GetScreenWidth() {return screen_Widht;}
    public static int GetScreenHeight() {return screen_Height;}

    public static void SetScreenVolumes(DisplayMetrics displayMetrics) {
        screen_Widht = displayMetrics.widthPixels;
        screen_Height = displayMetrics.heightPixels;
    }

    private Info() {}
}
