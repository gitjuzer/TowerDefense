package TowerDefenseProject;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;

import com.example.guth27.progtech.GameObjectHolder;

import java.util.ArrayList;
import java.util.List;

import Interfaces.GameObject;
import Interfaces.ISelectable;

/**
 * Created by guth2 on 2018. 04. 29..
 */

public class Turret implements GameObject, ISelectable, IObserver {
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

    private byte level;
    private String turretType;


    public Turret(TurretStrategy shootingStrategy, Point p, int width, int height)
    {

        this.shootingStrategy = shootingStrategy;
        shootingStrategy.SetPoint(p);
        this.p = p;
        baseRect = new Rect(p.x - width/2, p.y - height/2,p.x + width/2, p.y + height/2);
        middleRect = new Rect(p.x - width/4, p.y - height/4,p.x + width/4, p.y + height/4);
        outLine =  new Rect(p.x - width/2 - 4, p.y - height/2 - 4,p.x + width/2 + 4, p.y + height/2 + 4);
        this.shootColor = shootingStrategy.LaserColor();
        hasOutLine = false;
        enemies = new ArrayList<>();
        targets = new ArrayList<>();
        level = 1;

        turretType = shootingStrategy.Type();
        state = new StateLevel1();

        this.shootingStrategy.SetFireRange((int)(this.state.GetRange(this.GetLabel()) * 1.2));

        Game.RegisterToNotifier(this);
    }


    @Override
    public void OnSelected(GameObject previouslySelected)
    {
        hasOutLine = true;
    }

    @Override
    public void OnUnSelected(GameObject previouslySelected)
    {
        hasOutLine = false;
    }

    @Override
    public void Draw(Canvas canvas) {

        state.DrawTurret(canvas, baseRect, middleRect, outLine, hasOutLine, shootingStrategy.Type());


        Paint paint = new Paint();
        paint.setColor(shootColor);
        paint.setStrokeWidth(10);
        if(targets.size() > 0) {
            for (GameObject object : targets) {
                Point p2 = object.GetPosition();
                canvas.drawLine(p.x, p.y, p2.x, p2.y, paint);

            }

        }
        //System.out.println("draw");

     //  canvas.drawOval(CircleOutLine,test1);
      //  canvas.drawOval(middleCircle,test);

    }


    @Override
    public void Update() {
        if(targets.size() > 0){
            for(GameObject object : targets){
                ((Enemy)object).DamageTaken(GetDamage());
            }
        }

        enemies = GameObjectHolder.GetInstance().GetAllGameObjectWithLable("Enemy");
        shootingStrategy.GetOpponents(enemies);
        targets.clear();
        if(shootingStrategy.CanShoot())
        {
            targets = shootingStrategy.Targets();

        }
    }

    public void Upgrade()
    {
        if(this.shootingStrategy.Type() == "Simple") {
            if (level < 3 && Game.Buy(150)) {
                if (level == 1) state = new StateLevel2();
                else if (level == 2) state = new StateLevel3();
                level++;
                this.shootingStrategy.SetFireRange((int) (this.state.GetRange(this.GetLabel()) * 1.2));
            }
        } else if(this.shootingStrategy.Type() == "Shotgun") {
            if (level < 3 && Game.Buy(200)) {
                if (level == 1) state = new StateLevel2();
                else if (level == 2) state = new StateLevel3();
                level++;
                this.shootingStrategy.SetFireRange((int) (this.state.GetRange(this.GetLabel()) * 1.2));
            }
        } else{
                if (level < 3 && Game.Buy(250)) {
                    if (level == 1) state = new StateLevel2();
                    else if (level == 2) state = new StateLevel3();
                    level++;
                    this.shootingStrategy.SetFireRange((int) (this.state.GetRange(this.GetLabel()) * 1.2));
                }
            }
    }

    private int GetDamage()
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

    @Override
    public void ReceiveNotification(DayNight state) {
       if(state == DayNight.Day) this.shootingStrategy.SetFireRange(this.state.GetRange(this.GetLabel()));
       else this.shootingStrategy.SetFireRange((int)(this.state.GetRange(this.GetLabel()) * 0.8));
    }
}
