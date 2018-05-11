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

        super.Holder.AddGameObjectToHolderNonDrawable(Spawner.GetInstance(new Point(500,0)));

        //super.Holder.AddGameObjectToHolderLayer0(new RectPlayer(new Rect(100,100,200,200), Color.BLUE, new Point(300,300)));
        super.Holder.AddGameObjectToHolderLayer0(new TurretBase(new Point(100,100), 100,100, Color.GRAY));
        super.Holder.AddGameObjectToHolderLayer0(new TurretBase(new Point(200,200), 100,100, Color.GRAY));
        super.Holder.AddGameObjectToHolderLayer0(new TurretBase(new Point(300,300), 100,100, Color.GRAY));
        super.Holder.AddGameObjectToHolderLayer0(new TurretBase(new Point(400,300), 100,100, Color.GRAY));
        super.Holder.AddGameObjectToHolderLayer0(new TurretBase(new Point(400,400), 100,100, Color.GRAY));
        super.Holder.AddGameObjectToHolderLayer0(new TurretBase(new Point(400,500), 100,100, Color.GRAY));
        super.Holder.AddGameObjectToHolderLayer0(new TurretBase(new Point(400,600), 100,100, Color.GRAY));
        super.Holder.AddGameObjectToHolderLayer0(new TurretBase(new Point(400,700), 100,100, Color.GRAY));
        super.Holder.AddGameObjectToHolderLayer0(new TurretBase(new Point(400,800), 100,100, Color.GRAY));
        super.Holder.AddGameObjectToHolderLayer0(new TurretBase(new Point(400,900), 100,100, Color.GRAY));

        //MapGenerator generator = new MapGenerator(super.Holder);
        //generator.SplitScreen();

        //super.Holder.AddGameObjectToHolderLayer0(new RectPlayer(new Rect(100,100,200,200), Color.BLUE, new Point(400,300)));
        //super.Holder.AddGameObjectToHolderLayer0(new RectPlayer(new Rect(100,100,200,200), Color.CYAN, new Point(400,300)));
        //super.Holder.AddGameObjectToHolderLayer0(new RectPlayer(new Rect(100,100,200,200), Color.BLACK, new Point(400,300)));
        //super.Holder.AddGameObjectToHolderLayer0(new RectPlayer(new Rect(100,100,200,200), Color.DKGRAY, new Point(400,300)));
        //super.Holder.AddGameObjectToHolderLayer0(new RectPlayer(new Rect(100,100,200,200), Color.YELLOW, new Point(400,300)));
        //super.Holder.AddGameObjectToHolderLayer0(new RectPlayer(new Rect(100,100,200,200), Color.MAGENTA, new Point(300,300)));
       //// super.Holder.AddGameObjectToHolderLayer0(new TurretBase(new Point(100,100), 100,100, Color.GRAY, super.Holder));
        //GameObjectHolder.GetInstance().AddGameObjectToHolderLayer0(new Turret(new ShotgunTurretStrategy(), new Point(500,500), 100,100, super.Holder));
        //GameObjectHolder.GetInstance().AddGameObjectToHolderLayer0(new Turret(new StrongTurretStrategy(), new Point(700,500), 100,100, super.Holder));
        //super.Holder.AddGameObjectToHolderLayer1(new Turret(new ShotgunTurretStrategy(), new Point(500,800), 100,100, super.Holder));
        ////super.Holder.AddGameObjectToHolderLayer1(new Turret(new SimpleTurretStrategy(), new Point(500,500), 100,100, Color.RED,Color.YELLOW,super.Holder));
        GameObjectHolder.GetInstance().AddGameObjectToHolderLayer1(new Upgrade(300,100, new Point(200,1000)));

        GameObjectHolder.GetInstance().AddGameObjectToHolderLayer1(new Buyable(new Point(900,400),"Simple",100,100));
        GameObjectHolder.GetInstance().AddGameObjectToHolderLayer1(new Buyable(new Point(700,700),"Strong",100,100));
        GameObjectHolder.GetInstance().AddGameObjectToHolderLayer1(new Buyable(new Point(800,300),"Shotgun",100,100));

       // GameObjectHolder.GetInstance().AddGameObjectToHolderLayer1(new Enemy(new Point(500,0), 30,30, new NormalEnemy(1)));
       // GameObjectHolder.GetInstance().AddGameObjectToHolderLayer1(new Enemy(new Point(520,0), 30,30, new FastEnemy(1)));
       // GameObjectHolder.GetInstance().AddGameObjectToHolderLayer1(new Enemy(new Point(480,0), 30,30, new StrongEnemy(1)));

        //GameObjectHolder.GetInstance().AddGameObjectToHolderLayer0(new Turret(new SimpleTurretStrategy(),new Point(1000,1000),100,100));

        GameObjectHolder.GetInstance().AddGameObjectToHolderLayer1(new EnemyGoal(1000,200,new Point(500,1000)));

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
