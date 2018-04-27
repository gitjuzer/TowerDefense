package Interfaces;

import android.graphics.Canvas;
import android.graphics.Point;

/**
 * Created by guth2 on 2018. 04. 22.
 * The base interface in the FrameWork
 * Every object on the screen must be a GameObject
 * Start: executes when the object is created.
 * Draw, Update: executes every frame.
 * others are called when needed
 */

public interface GameObject {
    void Draw(Canvas canvas);
    void Update();
    void OnDestroy();
    String GetLabel();
    void Start();
    Point GetPosition();
    boolean IsTrigger();
}
