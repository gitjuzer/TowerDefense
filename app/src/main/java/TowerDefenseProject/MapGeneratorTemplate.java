package TowerDefenseProject;

import android.graphics.Color;
import android.graphics.Point;

import com.example.guth27.progtech.GameObjectHolder;
import com.example.guth27.progtech.Info;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by guth2 on 2018. 05. 11..
 */

public abstract class MapGeneratorTemplate {
    private int min = 5;
    int width;
    int height;
    Point[][] grid;
    TileType[][] layout;

    int a,b;

    int piecesWidth, piecesHeight;

    public void CreateMap(){
        piecesWidth = SetWidth();
        piecesHeight = SetHeight();
        width = (Info.GetScreenWidth() / 9) - min;
        height = (Info.GetScreenHeight() / 15) - min;

        SplitScreen();
        layout = new TileType[piecesWidth][piecesHeight];
        layout = CreateLayout();
        GenerateLayout();
    }

    void SplitScreen() {
        grid = new Point[100][100];
        a = 0;
        b = 0;
        for (int i = this.width/2+this.min; i < Info.GetScreenWidth(); i+=this.width+this.min)
        {
            for (int j = this.height/2+this.min; j<Info.GetScreenHeight()-3*this.height;j+=this.height+this.min)
            {
                System.out.println("Height index:" + b);
                System.out.println("Height" + j);
                //grid[a][b] = new Point(i, j);
                GameObjectHolder.GetInstance().AddGameObjectToHolderLayer0(new TurretBase(new Point(i, j), this.width, this.height, Color.RED));
                b++;
            }
            a++;
        }
        //for (int i = 0; i<points.size();i++)
        //    System.out.printf("X: %f, Y: %f\n",points.get(i).x,points.get(i).y);
    }
    protected abstract int SetWidth();
    protected abstract int SetHeight();

    protected abstract TileType[][] CreateLayout();

    void GenerateLayout(){
        for(int i = 0; i < piecesWidth; i++){
            for(int j = 0; i < piecesHeight - 3; j++) {
                if(layout[i][j] == TileType.TurretBase)
                    GameObjectHolder.GetInstance().AddGameObjectToHolderLayer0(new TurretBase(new Point(grid[i][j].x, grid[i][j].y),width,height,Color.RED));
                System.out.println("created");
            }
        }
    }
}
