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
        grid = new Point[9][15];
        piecesWidth = SetWidth();
        piecesHeight = SetHeight();
        width = (Info.GetScreenWidth() / piecesWidth) - min;
        height = (Info.GetScreenHeight() / piecesHeight) - min;

        SplitScreen();
        layout = new TileType[piecesWidth][piecesHeight];
        layout = CreateLayout();
        GenerateLayout();
    }

    void SplitScreen() {

        a = 0;
        b = 0;
        for (int i = this.width/2+this.min; i < Info.GetScreenWidth(); i+=this.width+this.min) {
            System.out.println("Index: width" + a);
            for (int j = this.height/2+this.min; j<Info.GetScreenHeight()-3*this.height;j+=this.height+this.min) {
                    grid[a][b] = new Point(i,j);
                    b++;
            }
            a++;
            b = 0;
        }
    }
    protected abstract int SetWidth();
    protected abstract int SetHeight();

    protected abstract TileType[][] CreateLayout();

    void GenerateLayout(){
        for(int i = 0; i < piecesWidth; i++){
            for(int j = 0; j < piecesHeight; j++) {
                if(layout[j][i] == TileType.TurretBase)
                    GameObjectHolder.GetInstance().AddGameObjectToHolderLayer0(new TurretBase(new Point(grid[i][j].x, grid[i][j].y),width,height,Color.RED));


            }
        }
    }
    void GeneratePath()
    {
        
    }
}
