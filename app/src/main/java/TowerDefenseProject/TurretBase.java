package TowerDefenseProject;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;

import com.example.guth27.progtech.GameObjectHolder;
import com.example.guth27.progtech.Info;

import java.util.List;

import Interfaces.GameObject;
import Interfaces.IMovable;

/**
 * Created by guth2 on 2018. 04. 28..
 */

public class TurretBase implements GameObject {

    private Point p;
    private Rect rectangle;
    private int width, height;
    private int color;
    private GameObjectHolder Holder;
    private String turretType;
    private List<IMovable> movables;

    public TurretBase(Point p, int width, int height, int color, GameObjectHolder Holder) {
        this.Holder = Holder;
        this.p = p;
        this.height = height;
        this.width = width;
        this.color = color;
        movables = Holder.GetIMovables();
        rectangle = new Rect(p.x - width/2, p.y - height/2,p.x + width/2, p.y + height/2);
    }

    @Override
    public void Draw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(color);
        canvas.drawRect(rectangle, paint);
    }

    @Override
    public void Update() {
        if(!Info.IsSomeThingSelectedForMovement()) {
            movables = Holder.GetIMovables();
            for(IMovable m : movables) {
                Point imovableP;
                if(m instanceof GameObject) {
                    imovableP = ((GameObject) m).GetPosition();
                    if(this.BetweenBoundaries(imovableP.x,imovableP.y)) {
                        turretType = ((GameObject) m).GetLabel();
                        ((RectPlayer) m).ResetPos();
                        Holder.RemoveGameObjectFromHolder(this);
                    }
                }
            }
        }
    }

    @Override
    public void OnDestroy() {
        //ide majd a megfelelő torony típus kell
        Holder.AddGameObjectToHolderLayer0(new RectPlayer(this.rectangle, Color.BLUE, p));
    }

    @Override
    public String GetLabel() {
        return "TurretBase";
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
        return x >= (rectangle.left) && x <= (rectangle.right) && y >= (rectangle.top) && y <= (rectangle.bottom);
    }
}
