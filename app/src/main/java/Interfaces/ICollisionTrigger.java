package Interfaces;

/**
 * Created by guth2 on 2018. 04. 27.
 * If a trigger GameObject's midPoint enters the boundaries of the ICollisionTrigger, theOnTriggerEnter method will execute.
 * Note: The method will execute every frame, this needs to be fixed.
 */

public interface ICollisionTrigger {
    void OnTriggerEnter(GameObject other);
    boolean BetweenBoundaries(int x, int y);
}
