package TowerDefenseProject;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;

import com.example.guth27.progtech.AbstractGame;
import com.example.guth27.progtech.GameObjectHolder;

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

    public Game()
    {
        route = new ArrayList<>();
        HP = 30;
    }

    @Override
    public void Start(){
        //super.SetBackGroundColor(Color.LTGRAY);

        ////super.Holder.AddGameObjectToHolderNonDrawable(Spawner.GetInstance(super.Holder));

        ////super.Holder.AddGameObjectToHolderLayer0(new RectPlayer(new Rect(100,100,200,200), Color.BLUE, new Point(300,300)));
       //super.Holder.AddGameObjectToHolderLayer0(new TurretBase(new Point(100,100), 100,100, Color.GRAY));
       //super.Holder.AddGameObjectToHolderLayer0(new TurretBase(new Point(200,200), 100,100, Color.GRAY));
       //super.Holder.AddGameObjectToHolderLayer0(new TurretBase(new Point(300,300), 100,100, Color.GRAY));
        //MapGenerator generator = new MapGenerator(super.Holder);
        //generator.SplitScreen();

        //super.Holder.AddGameObjectToHolderLayer0(new RectPlayer(new Rect(100,100,200,200), Color.BLUE, new Point(300,300)));
        //super.Holder.AddGameObjectToHolderLayer0(new RectPlayer(new Rect(100,100,200,200), Color.CYAN, new Point(300,300)));
        //super.Holder.AddGameObjectToHolderLayer0(new RectPlayer(new Rect(100,100,200,200), Color.BLACK, new Point(300,300)));
        //super.Holder.AddGameObjectToHolderLayer0(new RectPlayer(new Rect(100,100,200,200), Color.DKGRAY, new Point(300,300)));
        //super.Holder.AddGameObjectToHolderLayer0(new RectPlayer(new Rect(100,100,200,200), Color.YELLOW, new Point(300,300)));
        //super.Holder.AddGameObjectToHolderLayer0(new RectPlayer(new Rect(100,100,200,200), Color.MAGENTA, new Point(300,300)));
       //// super.Holder.AddGameObjectToHolderLayer0(new TurretBase(new Point(100,100), 100,100, Color.GRAY, super.Holder));
        //GameObjectHolder.GetInstance().AddGameObjectToHolderLayer0(new Turret(new ShotgunTurretStrategy(), new Point(500,500), 100,100, super.Holder));
        //GameObjectHolder.GetInstance().AddGameObjectToHolderLayer0(new Turret(new StrongTurretStrategy(), new Point(700,500), 100,100, super.Holder));
        super.Holder.AddGameObjectToHolderLayer1(new Turret(new ShotgunTurretStrategy(), new Point(500,580), 100,100));
        super.Holder.AddGameObjectToHolderLayer1(new Turret(new SimpleTurretStrategy(), new Point(500,500), 100,100));
       //GameObjectHolder.GetInstance().AddGameObjectToHolderLayer1(new Upgrade(300,100, new Point(200,1000)));

       //GameObjectHolder.GetInstance().AddGameObjectToHolderLayer0(new Buyable(new Point(400,400),"Simple",100,100));
       //GameObjectHolder.GetInstance().AddGameObjectToHolderLayer0(new Buyable(new Point(700,700),"Strong",100,100));
       //GameObjectHolder.GetInstance().AddGameObjectToHolderLayer0(new Buyable(new Point(800,300),"Shotgun",100,100));



    }

    @Override
    public void Update() {
        //if hp == 0 end
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

}
