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
 * The base tile can be changed down for turrets
 */

public class TurretBase implements GameObject {

    private Point p;
    private Rect rectangle, outline;
    private int width, height;
    private int color;
    private String turretType;
    private List<IMovable> movables;
    private Paint paint;

    public TurretBase(Point p, int width, int height, int color) {
        this.p = p;
        this.height = height;
        this.width = width;
        this.color = color;
        movables = GameObjectHolder.GetInstance().GetIMovables();
        outline = new Rect(p.x - width/2, p.y - height/2,p.x + width/2, p.y + height/2);
        rectangle = new Rect(p.x - width/2 + 2, p.y - height/2 + 2,p.x + width/2 - 2, p.y + height/2 - 2);

        paint = new Paint();
    }

    @Override
    public void Draw(Canvas canvas) {
        paint.setColor(Color.WHITE);
        canvas.drawRect(outline, paint);
        paint.setColor(color);
        canvas.drawRect(rectangle, paint);
    }

    @Override
    public void Update() {
        if(!Info.IsSomeThingSelectedForMovement()) {
            movables = GameObjectHolder.GetInstance().GetIMovables();
            for(IMovable m : movables) {
                Point imovableP;
                if(m instanceof GameObject) {
                    imovableP = ((GameObject) m).GetPosition();
                    if(this.BetweenBoundaries(imovableP.x,imovableP.y)) {
                        turretType = ((GameObject) m).GetLabel();
                        ((RectPlayer) m).ResetPos();
                        GameObjectHolder.GetInstance().RemoveGameObjectFromHolder(this);
                    }
                }
            }
        }
    }

    @Override
    public void OnDestroy() {
        //ide majd a megfelelő torony típus kell
        GameObjectHolder.GetInstance().AddGameObjectToHolderLayer0(new RectPlayer(this.rectangle, Color.BLUE, p));
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
