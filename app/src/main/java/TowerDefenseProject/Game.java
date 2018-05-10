package TowerDefenseProject;

import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;

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
    private static int GamePoints;

    public Game()
    {
        route = new ArrayList<>();
    }

    @Override
    public void Start(){
        ////super.Holder.AddGameObjectToHolderNonDrawable(Spawner.GetInstance(super.Holder));
//
        ////super.Holder.AddGameObjectToHolderLayer0(new RectPlayer(new Rect(100,100,200,200), Color.BLUE, new Point(300,300)));
        //super.Holder.AddGameObjectToHolderLayer0(new TurretBase(new Point(100,100), 100,100, Color.GRAY, super.Holder));
        //MapGenerator generator = new MapGenerator(super.Holder);
        //generator.SplitScreen();
//
        //super.Holder.AddGameObjectToHolderLayer0(new RectPlayer(new Rect(100,100,200,200), Color.BLUE, new Point(300,300)));
        //super.Holder.AddGameObjectToHolderLayer0(new RectPlayer(new Rect(100,100,200,200), Color.CYAN, new Point(300,300)));
        //super.Holder.AddGameObjectToHolderLayer0(new RectPlayer(new Rect(100,100,200,200), Color.BLACK, new Point(300,300)));
        //super.Holder.AddGameObjectToHolderLayer0(new RectPlayer(new Rect(100,100,200,200), Color.DKGRAY, new Point(300,300)));
        //super.Holder.AddGameObjectToHolderLayer0(new RectPlayer(new Rect(100,100,200,200), Color.YELLOW, new Point(300,300)));
        //super.Holder.AddGameObjectToHolderLayer0(new RectPlayer(new Rect(100,100,200,200), Color.MAGENTA, new Point(300,300)));
       //// super.Holder.AddGameObjectToHolderLayer0(new TurretBase(new Point(100,100), 100,100, Color.GRAY, super.Holder));
        //super.Holder.AddGameObjectToHolderLayer1(new Turret(new SimpleTurretStrategy(), new Point(500,500), 100,100, super.Holder));
        //super.Holder.AddGameObjectToHolderLayer1(new Turret(new ShotgunTurretStrategy(), new Point(500,800), 100,100, super.Holder));
        ////super.Holder.AddGameObjectToHolderLayer1(new Turret(new SimpleTurretStrategy(), new Point(500,500), 100,100, Color.RED,Color.YELLOW,super.Holder));

    }

    @Override
    public void Update() {

    }

    public static void SetRoutePoints(List<GameObject> points)
    {
        route = points;
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
}
