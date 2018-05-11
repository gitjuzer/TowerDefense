package TowerDefenseProject;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;

import com.example.guth27.progtech.GameObjectHolder;

import Interfaces.GameObject;
import Interfaces.ICollisionTrigger;

/**
 * Created by guth2 on 2018. 05. 10..
 */

public class EnemyGoal implements GameObject, ICollisionTrigger {

    private Rect rect;
    private Point p;
    Paint paint;

    public EnemyGoal(int width, int height, Point p){
        this.p = p;
        rect = new Rect(p.x - width/2, p.y - height/2,p.x + width/2, p.y + height/2);
        paint = new Paint();
        paint.setColor(Color.DKGRAY);
    }

    @Override
    public void Draw(Canvas canvas) {
        canvas.drawRect(rect,paint);
    }

    @Override
    public void Update() {

    }

    @Override
    public void OnDestroy() {

    }

    @Override
    public String GetLabel() {
        return "EnemyGoal";
    }

    @Override
    public void Start() {

    }

    @Override
    public Point GetPosition() {
        return p;
    }

    @Override
    public boolean IsTrigger() {
        return false;
    }

    @Override
    public void OnTriggerEnter(GameObject other) {
        //if other.label==type...
        Game.MinusHP(1);
        GameObjectHolder.GetInstance().RemoveGameObjectFromHolder(other);
    }

    @Override
    public boolean BetweenBoundaries(int x, int y) {
        return x >= (rect.left) && x <= (rect.right) && y >= (rect.top) && y <= (rect.bottom);
    }
}
