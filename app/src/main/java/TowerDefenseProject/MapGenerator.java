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
    List<Point> points = new ArrayList<>();

    public void SplitScreen() {
        int width = Info.GetScreenWidth() / 10;
        int height = Info.GetScreenHeight() / 16;

        for (int i = width/2; i < Info.GetScreenWidth()-width; i+=width+5) {
            for (int j = height/2; j<Info.GetScreenHeight()-3*height;j+=height+5) {
                points.add(new Point(i, j));
                this.holder.AddGameObjectToHolderLayer0(new TurretBase(new Point(i, j), width, height, Color.RED, this.holder));

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
