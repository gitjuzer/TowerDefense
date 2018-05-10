package TowerDefenseProject;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;

import com.example.guth27.progtech.Info;

import Interfaces.GameObject;
import Interfaces.ISelectable;

/**
 * Created by guth2 on 2018. 05. 10..
 */

public class Upgrade implements GameObject, ISelectable {

    private Rect baseRect;
    private Point p;

    public Upgrade(int width, int height, Point p) {
        baseRect = new Rect(p.x - width/2, p.y - height/2,p.x + width/2, p.y + height/2);
        this.p = p;
    }

    @Override
    public void OnSelected(GameObject previouslySelected) {
        GameObject previous = Info.GetPreviouslySelectedGameObject();
        //ha van elég pont
        if(previous instanceof Turret){
            ((Turret)previous).Upgrade();
        }
    }

    @Override
    public void OnUnSelected(GameObject previouslySelected) {

    }

    @Override
    public void Draw(Canvas canvas) {
        canvas.drawRect(baseRect, new Paint(Color.YELLOW));
    }

    @Override
    public void Update() {

    }

    @Override
    public void OnDestroy() {

    }

    @Override
    public String GetLabel() {
        return "UpgradeButton";
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
