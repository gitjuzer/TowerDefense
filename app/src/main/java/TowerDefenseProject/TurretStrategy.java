package TowerDefenseProject;

import android.graphics.Point;

import java.util.List;

import Interfaces.GameObject;

/**
 * Created by guth2 on 2018. 04. 29..
 */

public abstract class TurretStrategy {
    public abstract List<GameObject> Targets();
    public abstract void SetPoint(Point p);
    public abstract int GetFireRange();
    public abstract void SetFireRange(int firerange);
    public abstract boolean CanShoot();
    public abstract void GetOpponents(List<GameObject> enemies);
    public abstract String Type();
    public abstract int LaserColor();
   // public abstract int GetDamage();
   // public abstract void SetDamage(int damage);
}
