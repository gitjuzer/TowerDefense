package TowerDefenseProject;

import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;

import com.example.guth27.progtech.AbstractGame;
import com.example.guth27.progtech.GameObjectHolder;
import com.example.guth27.progtech.Info;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Interfaces.GameObject;

/**
 * Created by guth2 on 2018. 04. 26.
 * The Core of the game comes here.
 */

public class Game extends AbstractGame {

    private static List<Point> route;
    private static Point lastPoint;
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
        HP = 30;
        GamePoints = 600;

        Random rng = new Random();
        int n = rng.nextInt(3);
        if(n == 0) {
            MapGenerator generator = new MapGenerator();
            generator.CreateMap();
        } else if(n == 1){
            MapGenerator2 generator = new MapGenerator2();
            generator.CreateMap();
        } else{
            MapGenerator3 generator = new MapGenerator3();
            generator.CreateMap();
        }

        super.Holder.AddGameObjectToHolderNonDrawable(Spawner.GetInstance(route.get(0)));
    }

    @Override
    public void Update() {
        if (HP > 0) {
            if (current == DayNight.Day) {
                if (Info.GetTotalRunningTimeMS() - currentStartTime > dayTime) {
                    current = DayNight.Night;
                    notifier.NotifyObservers(current);
                    currentStartTime = Info.GetTotalRunningTimeMS();
                }
            } else {
                if (Info.GetTotalRunningTimeMS() - currentStartTime > nightTime) {
                    current = DayNight.Day;
                    notifier.NotifyObservers(current);
                    currentStartTime = Info.GetTotalRunningTimeMS();
                }
            }
        } else
        {
            GameObjectHolder.GetInstance().RemoveAll();
            Spawner.GetInstance(route.get(0)).Restart();
            this.Start();
        }
    }


    public static void SetRoutePoints(List<Point> points)
    {
        route = points;
        lastPoint = points.get(points.size() - 1);
    }
    public static Point GetNextRoutePoint(int i)
    {
        if(i >= route.size()) {
            return new Point(route.get(route.size() - 1).x, Info.GetScreenHeight());
        }
        return route.get(i);
    }
    public static void AddGamePoint(int i) {
        GamePoints += i;
    }
    public static boolean Buy(int cost)
    {
        if(GamePoints >= cost){
            GamePoints -= cost;
            return true;
        }
        return false;
    }
    public static int GetPointVolume(){
        return GamePoints;
    }
    public static void MinusHP(int hp)
    {
        HP -= hp;
    }
    public static int GetHpVolume(){
        return HP;
    }

    public static void RegisterToNotifier(IObserver observer){
        notifier.RegisterObserver(observer);
    }

}
