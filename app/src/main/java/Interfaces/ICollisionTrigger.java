package Interfaces;

/**
 * Created by guth2 on 2018. 04. 27.
 * If a trigger GameObject's midPoint enters the boundaries of the ICollisionTrigger, theOnTriggerEnter method will execute.
 * Note: The method will execute every frame, this needs to be fixed.
 */

public interface ICollisionTrigger {
    /**
     * Runs when collides with a trigger object
     * @param other-The other gameObject that this object is collided
     */
    void OnTriggerEnter(GameObject other);
    /**
     * Checks if the point is between the boundaries of this gameObject.
     * @param x
     * @param y
     * @return boolean
     */
    boolean BetweenBoundaries(int x, int y);
}
