package TowerDefenseProject;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;

import com.example.guth27.progtech.GameObjectHolder;

import java.util.ArrayList;
import java.util.List;

import Interfaces.GameObject;
import Interfaces.ISelectable;

/**
 * Created by guth2 on 2018. 04. 29..
 */

public class Turret implements GameObject, ISelectable {
    private TurretStrategy shootingStrategy;
    private TurretState state;
    private Rect baseRect;
    private Rect middleRect;
    private Rect outLine;

    private boolean hasOutLine;

    private Point p;
    private int shootColor;

    private List<GameObject> enemies;
    private List<GameObject> targets;
    GameObjectHolder Holder;

    private byte level;
    private String turretType;


    public Turret(TurretStrategy shootingStrategy, Point p, int width, int height, GameObjectHolder Holder)
    {
        this.shootingStrategy = shootingStrategy;
        shootingStrategy.SetPoint(p);
        this.p = p;
        baseRect = new Rect(p.x - width/2, p.y - height/2,p.x + width/2, p.y + height/2);
        middleRect = new Rect(p.x - width/4, p.y - height/4,p.x + width/4, p.y + height/4);
        outLine =  new Rect(p.x - width/2 - 4, p.y - height/2 - 4,p.x + width/2 + 4, p.y + height/2 + 4);
       //this.color1 = color1;
       //this.color2 = color2;
       //this.outLineColor = Color.LTGRAY;
        this.shootColor = shootingStrategy.LaserColor();
        hasOutLine = false;
        enemies = new ArrayList<>();
        targets = new ArrayList<>();
        this.Holder = Holder;
        level = 1;

        turretType = shootingStrategy.Type();
        state = new StateLevel1();

    }


    @Override
    public void OnSelected(GameObject previouslySelected) {
        hasOutLine = true;
    }

    @Override
    public void OnUnSelected(GameObject previouslySelected) {
        hasOutLine = false;
    }

    @Override
    public void Draw(Canvas canvas) {

        state.DrawTurret(canvas, baseRect, middleRect, outLine, hasOutLine, shootingStrategy.Type());
       //
       // if(hasOutLine){
       //     paint.setColor(outLineColor);
       //     canvas.drawRect(outLine, paint);
       // }
       // paint.setColor(color1);
       // canvas.drawRect(baseRect, paint);
       // paint.setColor(color2);
       // canvas.drawRect(middleRect, paint);

        Paint paint = new Paint();
        paint.setColor(shootColor);
        paint.setStrokeWidth(10);
        if(targets.size() > 0) {
            for (GameObject object : targets) {
                Point p2 = object.GetPosition();
                canvas.drawLine(p.x, p.y, p2.x, p2.y, paint);
            }
        }
    }


    @Override
    public void Update() {
        if(targets.size() > 0){
            for(GameObject object : targets){
                //damagetaken meghívása GetDamage-el
                //((Enemy)object).TakeDamage(GetDamage(shootingStrategy.GetDamage()));
            }
        }

        enemies = Holder.GetAllGameObjectWithLable("Enemy");
        shootingStrategy.GetOpponents(enemies);
        targets.clear();
        if(shootingStrategy.CanShoot())
        {
            targets = shootingStrategy.Targets();

        }
    }

    public void Upgrade()
    {
        if(level < 3) {
            if (level == 1) state = new StateLevel2();
            else if (level == 2) state = new StateLevel3();
            level++;
        }
    }

    private int GetDamage(int basedamage)
    {
        return state.GetDamage(turretType);
    }

    @Override
    public void OnDestroy() {

    }

    @Override
    public String GetLabel() {
        return "Turret";
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
    public boolean BetweenBoundaries(int x, int y) {
        return x >= (baseRect.left) && x <= (baseRect.right) && y >= (baseRect.top) && y <= (baseRect.bottom);
    }
}
