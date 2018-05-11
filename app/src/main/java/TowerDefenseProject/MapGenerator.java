package TowerDefenseProject;

import android.graphics.Color;
import android.graphics.Point;
import android.widget.LinearLayout;

import com.example.guth27.progtech.GameObjectHolder;
import com.example.guth27.progtech.Info;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Balázs on 2018. 04. 29..
 */

public class MapGenerator {

    GameObjectHolder holder;
    private int grid = 5;
    int width = Info.GetScreenWidth() / 9-this.grid;
    int height = Info.GetScreenHeight() / 15-this.grid;
    List<Point> points = new ArrayList<>();

    public void SplitScreen() {

        for (int i = this.width/2+this.grid; i < Info.GetScreenWidth(); i+=this.width+this.grid)
        {
            for (int j = this.height/2+this.grid; j<Info.GetScreenHeight()-3*this.height;j+=this.height+this.grid)
            {
                points.add(new Point(i, j));
                this.holder.AddGameObjectToHolderLayer0(new TurretBase(new Point(i, j), this.width, this.height, Color.RED));
            }
       }
       //for (int i = 0; i<points.size();i++)
       //    System.out.printf("X: %f, Y: %f\n",points.get(i).x,points.get(i).y);
    }

    public  MapGenerator(GameObjectHolder holder)
    {

        this.holder = holder;
    }
}
