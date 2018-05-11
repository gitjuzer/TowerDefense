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

public class MapGenerator extends MapGeneratorTemplate {


    @Override
    protected int SetWidth() {
        return 9;
    }

    @Override
    protected int SetHeight() {
        return 15;
    }

    @Override
    protected TileType[][] CreateLayout() {
        return new TileType[][]{
                {TileType.TurretBase,TileType.TurretBase,TileType.Path,TileType.TurretBase,TileType.TurretBase,TileType.TurretBase,TileType.TurretBase,TileType.TurretBase,TileType.TurretBase},
                {TileType.TurretBase,TileType.TurretBase,TileType.Path,TileType.TurretBase,TileType.TurretBase,TileType.TurretBase,TileType.TurretBase,TileType.TurretBase,TileType.TurretBase},
                {TileType.TurretBase,TileType.TurretBase,TileType.Path,TileType.TurretBase,TileType.TurretBase,TileType.TurretBase,TileType.TurretBase,TileType.TurretBase,TileType.TurretBase},
                {TileType.TurretBase,TileType.TurretBase,TileType.Path,TileType.Path,TileType.Path,TileType.Path,TileType.Path,TileType.TurretBase,TileType.TurretBase},
                {TileType.TurretBase,TileType.TurretBase,TileType.TurretBase,TileType.TurretBase,TileType.TurretBase,TileType.TurretBase,TileType.Path,TileType.TurretBase,TileType.TurretBase},
                {TileType.TurretBase,TileType.TurretBase,TileType.TurretBase,TileType.TurretBase,TileType.TurretBase,TileType.TurretBase,TileType.Path,TileType.TurretBase,TileType.TurretBase},
                {TileType.TurretBase,TileType.TurretBase,TileType.TurretBase,TileType.TurretBase,TileType.TurretBase,TileType.Path,TileType.Path,TileType.TurretBase,TileType.TurretBase},
                {TileType.TurretBase,TileType.Path,TileType.Path,TileType.Path,TileType.Path,TileType.Path,TileType.TurretBase,TileType.TurretBase,TileType.TurretBase},
                {TileType.TurretBase,TileType.Path,TileType.TurretBase,TileType.TurretBase,TileType.TurretBase,TileType.TurretBase,TileType.TurretBase,TileType.TurretBase,TileType.TurretBase},
                {TileType.TurretBase,TileType.Path,TileType.TurretBase,TileType.TurretBase,TileType.Path,TileType.Path,TileType.Path,TileType.TurretBase,TileType.TurretBase},
                {TileType.TurretBase,TileType.Path,TileType.Path,TileType.Path,TileType.Path,TileType.TurretBase,TileType.Path,TileType.TurretBase,TileType.TurretBase},
                {TileType.TurretBase,TileType.TurretBase,TileType.TurretBase,TileType.TurretBase,TileType.TurretBase,TileType.TurretBase,TileType.Path,TileType.TurretBase,TileType.TurretBase},
                {TileType.Empty,TileType.Empty,TileType.Empty,TileType.Empty,TileType.Empty,TileType.Empty,TileType.Empty,TileType.Empty,TileType.Empty},
                {TileType.Empty,TileType.Empty,TileType.Empty,TileType.Empty,TileType.Empty,TileType.Empty,TileType.Empty,TileType.Empty,TileType.Empty},
                {TileType.Empty,TileType.Empty,TileType.Empty,TileType.Empty,TileType.Empty,TileType.Empty,TileType.Empty,TileType.Empty,TileType.Empty}
        };
    }
}
