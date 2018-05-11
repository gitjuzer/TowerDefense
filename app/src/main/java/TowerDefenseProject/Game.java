package TowerDefenseProject;

import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;

import com.example.guth27.progtech.AbstractGame;
import com.example.guth27.progtech.GameObjectHolder;
import com.example.guth27.progtech.Info;

import java.util.ArrayList;
import java.util.List;

import Interfaces.GameObject;

/**
 * Created by guth2 on 2018. 04. 26.
 * The Core of the game comes here.
 */

public class Game extends AbstractGame {

    private static List<GameObject> route;
    private static GameObject lastPoint;
    private static int GamePoints;
    private static int HP;

    private long startTime;
    private long currentStartTime;
    private int dayTime;
    private int nightTime;

    DayNight current;
    private static DayNightNotifier notifier;

    public Game()
    {
        route = new ArrayList<>();
        HP = 30;
        startTime = Info.GetStartTimeMS();
        currentStartTime = Info.GetTotalRunningTimeMS();
        current = DayNight.Day;
        dayTime = 25000;
        nightTime = 10000;
        notifier = new DayNightNotifier();
    }

    @Override
    public void Start(){
        notifier.NotifyObservers(current);
        //super.SetBackGroundColor(Color.LTGRAY);

        //super.Holder.AddGameObjectToHolderNonDrawable(Spawner.GetInstance(new Point(500,0)));



        MapGenerator generator = new MapGenerator();
        generator.CreateMap();



    }

    @Override
    public void Update() {
        //if hp == 0 end
        if(current == DayNight.Day){
            if(Info.GetTotalRunningTimeMS() - currentStartTime > dayTime){

                current = DayNight.Night;
                notifier.NotifyObservers(current);
                currentStartTime = Info.GetTotalRunningTimeMS();
            }
        }else{
            if(Info.GetTotalRunningTimeMS() - currentStartTime > nightTime){
                current = DayNight.Day;
                notifier.NotifyObservers(current);
                currentStartTime = Info.GetTotalRunningTimeMS();
            }
        }
    }


    public static void SetRoutePoints(List<GameObject> points)
    {
        route = points;
        lastPoint = points.get(points.size() - 1);
    }
    public static Point GetLastPoint(){
        return lastPoint.GetPosition();
    }
    public static GameObject GetNextRoutePoint(int i)
    {
        return route.get(i);
    }
    public static void AddGamePoint(int i) {
        GamePoints += i;
    }
    public boolean Buy(int cost)
    {
        if(GamePoints >= cost){
            GamePoints -= cost;
            return true;
        }
        return false;
    }
    public static void MinusHP(int hp)
    {
        HP -= hp;
    }

    public static void RegisterToNotifier(IObserver observer){
        notifier.RegisterObserver(observer);
    }

}
