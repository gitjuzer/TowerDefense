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
    /**
     * Runs once every frame. Every draw on canvas should be here.
     * @param canvas
     */
    void Draw(Canvas canvas);

    /**
     * runs once every frame. Object behaviour comes here.
     */
    void Update();

    /**
     * runs down when the object is destroyed.
     */
    void OnDestroy();

    /**
     * Set the label(tag) of the gameObject.
     * @return String
     */
    String GetLabel();

    /**
     * Runs when the gameObject is instantiated.
     */
    void Start();

    /**
     * Returns the midpoint of the gameObject.
     * @return Point
     */
    Point GetPosition();

    /**
     * Returns if the gameObject is a trigger or not for ICollisionTrigger objects
     * @return boolean
     */
    boolean IsTrigger();

    /**
     * Checks if the point is between the boundaries of this gameObject.
     * @param x
     * @param y
     * @return boolean
     */
    boolean BetweenBoundaries(int x, int y);
}
