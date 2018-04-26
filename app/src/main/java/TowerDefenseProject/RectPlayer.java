package TowerDefenseProject;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;

import Interfaces.GameObject;
import Interfaces.IMovable;
import Interfaces.ISelectable;

/**
 * Created by guth2 on 2018. 04. 22..
 */

public class RectPlayer implements GameObject, IMovable, ISelectable {


    //!!!testing gameObject!!!
    private Rect rectangle;
    private int color;
    private Point p;

    public RectPlayer(Rect rectangle, int color, Point p)
    {
        this.rectangle = rectangle;
        this.color = color;
        this.p = p;
    }

    @Override
    public void Draw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(color);
        canvas.drawRect(rectangle, paint);
    }
    @Override
    public void Start() {

    }

    @Override
    public void Update() {
    }

    @Override
    public void OnDestroy() {

    }

    @Override
    public String GetLabel() {
        return "Cube";
    }


    @Override
    public void UpdateMovemenet() {
        rectangle.set(p.x - rectangle.width()/2, p.y - rectangle.height()/2,p.x + rectangle.width()/2, p.y + rectangle.height()/2);
    }

    @Override
    public boolean BetweenBoundaries(int x, int y) {

        return x >= (rectangle.left) && x <= (rectangle.right) && y >= (rectangle.top) && y <= (rectangle.bottom);
    }

    @Override
    public void OnSelected() {
        System.out.println("Selected");
    }

    @Override
    public void OnUnSelected(GameObject previouslySelected) {
        System.out.println("unSelected");
    }

   //@Override
   //public boolean CanChangePosition() {
   //    return true;
   //}

   //@Override
   //public void newPosition(int x, int y) {
   //    p.set(x,y);
   //}

   //@Override
   //public void OnTapafterSelected(GameObject previouslySelected) {

   // }

    @Override
    public void SetGameObjectPoint(int x, int y) {
        p.set(x,y);
    }
}
