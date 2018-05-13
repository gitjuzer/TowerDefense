package TowerDefenseProject;

import android.graphics.Color;
import android.graphics.Path;
import android.graphics.Point;
import android.service.quicksettings.Tile;
import android.text.Layout;

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

    int pathlenght;

    int a,b;

    public static int piecesWidth, piecesHeight;

    public void CreateMap(){

        piecesWidth = SetWidth();
        piecesHeight = SetHeight();
        width = (Info.GetScreenWidth() / piecesWidth) - min;
        height = (Info.GetScreenHeight() / piecesHeight) - min;
        grid = new Point[piecesWidth][piecesHeight];
        SplitScreen();
        layout = new TileType[piecesWidth][piecesHeight];
        layout = CreateLayout();
        pathlenght = SetPathLenght();
        GenerateLayout();
        GeneratePath();

        EnemyGoalGenerate();
        BuyablesGenerate();
        UpgradeButtonGenerate();
        StringDrawerGenerate();
    }

    protected abstract int SetPathLenght();

    void StringDrawerGenerate() {
        GameObjectHolder.GetInstance().AddGameObjectToHolderLayer2(new ScreenStrings());
    }

    void UpgradeButtonGenerate(){
        GameObjectHolder.GetInstance().AddGameObjectToHolderLayer1(new Upgrade(3*this.width,this.height, new Point((int)(Info.GetScreenWidth() - 2*this.width),(int)(Info.GetScreenHeight() - (1.6*this.height)))));
    }

    void BuyablesGenerate(){
        GameObjectHolder.GetInstance().AddGameObjectToHolderLayer1(new Buyable(new Point(this.width + min,(int)(Info.GetScreenHeight() - (1.6*this.height))),"Simple", this.width, this.height));
        GameObjectHolder.GetInstance().AddGameObjectToHolderLayer1(new Buyable(new Point(3*this.width + min,(int)(Info.GetScreenHeight() - (1.6*this.height))),"Shotgun", this.width, this.height));
        GameObjectHolder.GetInstance().AddGameObjectToHolderLayer1(new Buyable(new Point(5*this.width + min,(int)(Info.GetScreenHeight() - (1.6*this.height))),"Strong", this.width, this.height));
    }

    void EnemyGoalGenerate(){
        GameObjectHolder.GetInstance().AddGameObjectToHolderLayer0(new EnemyGoal(9*this.width, 3*this.height, new Point((int)(Info.GetScreenWidth()/2), (int)(Info.GetScreenHeight() - (1.5*this.height)))));
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
                if(layout[j][i] == TileType.TurretBase) {
                        GameObjectHolder.GetInstance().AddGameObjectToHolderLayer0(new TurretBase(new Point(grid[i][j].x, grid[i][j].y), width, height, Color.GREEN));
                }
            }
        }
    }
    void GeneratePath() {
        int x = 0; int y = 0;
        List<Point> path = new ArrayList<>();
        for(int i = 0; i < piecesWidth; i++) {
            if(layout[0][i] == TileType.Path) {
                path.add(grid[i][0]);
                System.out.println(path.get(0));
                y = 0;
                x = i;
            }
        }
        for (int i = 0; i < pathlenght; i++) {
            //bal felső sarok
            if(y == 0 && x == 0){
                if(layout[y][x+1] == TileType.Path && !Contains(grid[x+1][y], path)){
                    path.add(grid[x+1][y]);
                    x += 1;
                    continue;
                } else if(layout[y + 1][x] == TileType.Path && !Contains(grid[x][y+1], path)){
                    path.add(grid[x][y+1]);
                    y += 1;
                    continue;
                }
                //jobb felso
            }else if(y == 0 && x == piecesWidth - 1){
                if(layout[y + 1][x] == TileType.Path &&!Contains(grid[x][y + 1], path)) {
                    path.add(grid[x][y + 1]);
                    y += 1;
                    continue;
                } else if(layout[y - 1][x] == TileType.Path && !Contains(grid[x][y - 1], path)) {
                    path.add(grid[x][y - 1]);
                    y -= 1;
                    continue;
                }
                //bal also
            } else if(x == 0 && y == piecesHeight - 1){
                if(layout[y][x+1] == TileType.Path && !Contains(grid[x+1][y], path)) {
                    path.add(grid[x + 1][y]);
                    x += 1;
                    continue;
                }
                else if(layout[y - 1][x] == TileType.Path && !Contains(grid[x][y - 1], path)) {
                    path.add(grid[x][y - 1]);
                    y -= 1;
                    continue;
                }
                //jobb also
            } else if(x == piecesWidth - 1 && y == piecesHeight - 1){
                if(layout[y][x+1] == TileType.Path && !Contains(grid[x - 1][y], path)) {
                    path.add(grid[x - 1][y]);
                    x -= 1;
                    continue;
                }
                else if(layout[y - 1][x] == TileType.Path && !Contains(grid[x][y - 1], path)) {
                    path.add(grid[x][y - 1]);
                    y -= 1;
                    continue;
                }
                //felül
            } else if(y == 0) {
                if(layout[y][x+1] == TileType.Path && !Contains(grid[x+1][y], path)){
                    path.add(grid[x+1][y]);
                    x += 1;
                    continue;
                } else if(layout[y + 1][x] == TileType.Path && !Contains(grid[x][y+1], path)){
                    path.add(grid[x][y+1]);
                    y += 1;
                    continue;
                } else if(layout[y][x - 1] == TileType.Path && !Contains(grid[x - 1][y], path)) {
                    path.add(grid[x - 1][y]);
                    x -= 1;
                    continue;
                }
                //jobb oldal
            }else if(x == 0) {
                if(layout[y][x+1] == TileType.Path && !Contains(grid[x+1][y], path)){
                    path.add(grid[x+1][y]);
                    x += 1;
                    continue;
                } else if(layout[y + 1][x] == TileType.Path && !Contains(grid[x][y+1], path)){
                    path.add(grid[x][y+1]);
                    y += 1;
                    continue;
                } else if(layout[y - 1][x] == TileType.Path && !Contains(grid[x][y - 1], path)) {
                    path.add(grid[x][y - 1]);
                    y -= 1;
                    continue;
                }
                //bal oldal
            } else if(x == piecesWidth - 1) {
                if(layout[y][x-1] == TileType.Path && !Contains(grid[x-1][y], path)){
                    path.add(grid[x-1][y]);
                    x -= 1;
                    continue;
                } else if(layout[y + 1][x] == TileType.Path && !Contains(grid[x][y+1], path)){
                    path.add(grid[x][y+1]);
                    y += 1;
                    continue;
                } else if(layout[y - 1][x] == TileType.Path && !Contains(grid[x][y - 1], path)) {
                    path.add(grid[x][y - 1]);
                    y -= 1;
                    continue;
                }
            } else{
                if(layout[y][x-1] == TileType.Path && !Contains(grid[x-1][y], path)){
                    path.add(grid[x-1][y]);
                    x -= 1;
                    continue;
                } else if(layout[y + 1][x] == TileType.Path && !Contains(grid[x][y+1], path)){
                    path.add(grid[x][y+1]);
                    y += 1;
                    continue;
                } else if(layout[y - 1][x] == TileType.Path && !Contains(grid[x][y - 1], path)) {
                    System.out.println("origin:" + path.get(path.size() - 1));

                    System.out.println("end:" + grid[x][y - 1]);
                    path.add(grid[x][y - 1]);
                    y -= 1;
                    continue;
                } else if(layout[y][x + 1] == TileType.Path && !Contains(grid[x + 1][y], path)) {
                    path.add(grid[x + 1][y]);
                    x += 1;
                    continue;
                }
            }
        }

        Game.SetRoutePoints(path);
    }

    boolean Contains(Point p, List<Point> list)
    {
        for(Point p2: list) {
            if(p2 == p)
                return true;
        }
        return  false;
    }
}
