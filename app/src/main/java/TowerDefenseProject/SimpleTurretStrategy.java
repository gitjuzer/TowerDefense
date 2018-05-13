package TowerDefenseProject;

import android.graphics.Color;
import android.graphics.Point;

import java.util.ArrayList;
import java.util.List;

import Interfaces.GameObject;

/**
 * Created by guth2 on 2018. 04. 29..
 */

public class SimpleTurretStrategy extends TurretStrategy {

    private List<GameObject> enemies;
    private List<GameObject> validTargets;
    private byte framesUntilNextShot;
    private byte framesBetweenShots;

    private Point p;
    private byte maxTargets;
    private byte alreadyTargeting;

    private int fireRange, damage;

    public SimpleTurretStrategy()
    {
        enemies = new ArrayList<>();
        validTargets = new ArrayList<>();
        framesBetweenShots = 30;
        framesUntilNextShot = 0;
        maxTargets = 1;
        alreadyTargeting = 0;

        fireRange = 500;
        //damage = 5;
    }

    @Override
    public List<GameObject> Targets() {
        alreadyTargeting = 0;
        if(enemies.size() > 0) {
            for (GameObject object : enemies) {
                if(alreadyTargeting < maxTargets && Distance(object.GetPosition(), p) <= this.GetFireRange()){
                    validTargets.add(object);
                    alreadyTargeting++;
                }
            }
        }
        return validTargets;
    }

    @Override
    public void SetPoint(Point p) {
        this.p = p;
    }

    private double Distance(Point p1,Point p2)
    {
        return Math.sqrt((p2.x - p1.x)*(p2.x - p1.x) + (p2.y - p1.y)*(p2.y - p1.y));
    }

    @Override
    public int GetFireRange() {
        return fireRange;
    }

    @Override
    public void SetFireRange(int fireRange) {
        this.fireRange = fireRange;
    }

    @Override
    public boolean CanShoot() {
        if(framesUntilNextShot == 0) {
            framesUntilNextShot = framesBetweenShots;
            return true;
        }
        framesUntilNextShot--;
        return false;
    }

    @Override
    public void GetOpponents(List<GameObject> enemies) {
        this.enemies = enemies;
    }

    @Override
    public String Type() {
        return "Simple";
    }
    @Override
    public int LaserColor() {
        return Color.argb(255,112, 255, 17);
    }
   // @Override
   // public int GetDamage() {
   //     return damage;
   // }
//
   // @Override
   // public void SetDamage(int damage) {
   //     this.damage = damage;
   // }
}
