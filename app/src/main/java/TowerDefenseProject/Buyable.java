package TowerDefenseProject;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;

import com.example.guth27.progtech.Info;

import Interfaces.GameObject;
import Interfaces.IMovable;

/**
 * Created by guth2 on 2018. 05. 11..
 * The player will be able to purchase and place new turrets with this Object
 */

public class Buyable implements GameObject, IMovable {

    private Point p;
    private final Point originalP;
    private String label;
    private Rect base, middle;
    private Paint paint;

    private long moveEndedTime;
    private int timeBeforeRePostion;

    public Buyable(Point p, String label, int width, int height) {

        this.p = p;
        originalP = new Point(p);
        this.label = label;

        paint = new Paint();

        base = new Rect(p.x - width/2, p.y - height/2,p.x + width/2, p.y + height/2);
        middle = new Rect(p.x - width/4, p.y - height/4,p.x + width/4, p.y + height/4);

        timeBeforeRePostion = 250;
    }

    @Override
    public void SetGameObjectPoint(int x, int y) {
        p.x = x;
        p.y = y;
        base.set(p.x - base.width()/2, p.y - base.height()/2,p.x + base.width()/2, p.y + base.height()/2);
        middle.set(p.x - middle.width()/2, p.y - middle.height()/2,p.x + middle.width()/2, p.y + middle.height()/2);

        moveEndedTime = Info.GetTotalRunningTimeMS();
    }

    @Override
    public void Draw(Canvas canvas) {
        if(label == "Simple") {
            paint.setARGB(255, 88, 153, 101);
            canvas.drawRect(base, paint);
            paint.setColor(Color.BLACK);
            canvas.drawRect(middle, paint);
        }else if(label == "Shotgun"){
            paint.setARGB(255,99, 165, 160);
            canvas.drawRect(base, paint);
            paint.setColor(Color.BLACK);
            canvas.drawRect(middle, paint);
        }else{
            paint.setARGB(255,183, 144, 113);
            canvas.drawRect(base, paint);
            paint.setColor(Color.BLACK);
            canvas.drawRect(middle, paint);
        }
    }

    @Override
    public void Update() {
        if(p != originalP){
            if(Info.GetTotalRunningTimeMS() - moveEndedTime > timeBeforeRePostion)
                this.ResetPos();
        }
    }

    @Override
    public void OnDestroy() {

    }

    @Override
    public String GetLabel() {
        return label;
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
        return x >= (base.left) && x <= (base.right) && y >= (base.top) && y <= (base.bottom);
    }
    public void ResetPos() {
        SetGameObjectPoint(originalP.x, originalP.y);
    }
}
