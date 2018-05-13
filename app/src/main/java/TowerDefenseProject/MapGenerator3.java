package TowerDefenseProject;

/**
 * Created by guth2 on 2018. 05. 13..
 */

public class MapGenerator3 extends MapGeneratorTemplate {
    @Override
    protected int SetPathLenght() {
        return 34;
    }

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
                {TileType.TurretBase,TileType.TurretBase,TileType.Path,TileType.TurretBase,TileType.Path,TileType.Path,TileType.Path,TileType.TurretBase,TileType.TurretBase},
                {TileType.TurretBase,TileType.TurretBase,TileType.Path,TileType.TurretBase,TileType.Path,TileType.TurretBase,TileType.Path,TileType.TurretBase,TileType.TurretBase},
                {TileType.TurretBase,TileType.TurretBase,TileType.Path,TileType.TurretBase,TileType.Path,TileType.TurretBase,TileType.Path,TileType.TurretBase,TileType.TurretBase},
                {TileType.TurretBase,TileType.TurretBase,TileType.Path,TileType.TurretBase,TileType.Path,TileType.TurretBase,TileType.Path,TileType.TurretBase,TileType.TurretBase},
                {TileType.TurretBase,TileType.TurretBase,TileType.Path,TileType.TurretBase,TileType.Path,TileType.TurretBase,TileType.Path,TileType.TurretBase,TileType.TurretBase},
                {TileType.TurretBase,TileType.TurretBase,TileType.Path,TileType.TurretBase,TileType.Path,TileType.TurretBase,TileType.Path,TileType.TurretBase,TileType.TurretBase},
                {TileType.TurretBase,TileType.TurretBase,TileType.Path,TileType.TurretBase,TileType.Path,TileType.TurretBase,TileType.Path,TileType.TurretBase,TileType.TurretBase},
                {TileType.TurretBase,TileType.TurretBase,TileType.Path,TileType.TurretBase,TileType.Path,TileType.TurretBase,TileType.Path,TileType.TurretBase,TileType.TurretBase},
                {TileType.TurretBase,TileType.TurretBase,TileType.Path,TileType.TurretBase,TileType.Path,TileType.TurretBase,TileType.Path,TileType.TurretBase,TileType.TurretBase},
                {TileType.TurretBase,TileType.TurretBase,TileType.Path,TileType.Path,TileType.Path,TileType.TurretBase,TileType.Path,TileType.TurretBase,TileType.TurretBase},
                {TileType.TurretBase,TileType.TurretBase,TileType.TurretBase,TileType.TurretBase,TileType.TurretBase,TileType.TurretBase,TileType.Path,TileType.TurretBase,TileType.TurretBase},
                {TileType.Empty,TileType.Empty,TileType.Empty,TileType.Empty,TileType.Empty,TileType.Empty,TileType.Empty,TileType.Empty,TileType.Empty},
                {TileType.Empty,TileType.Empty,TileType.Empty,TileType.Empty,TileType.Empty,TileType.Empty,TileType.Empty,TileType.Empty,TileType.Empty},
                {TileType.Empty,TileType.Empty,TileType.Empty,TileType.Empty,TileType.Empty,TileType.Empty,TileType.Empty,TileType.Empty,TileType.Empty}
        };
    }
}
