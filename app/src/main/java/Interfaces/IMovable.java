package Interfaces;

/**
 * Created by guth2 on 2018. 04. 22..
 */

public interface IMovable {
    /**
     * Checks if the point is between the boundaries of this gameObject.
     * @param x
     * @param y
     * @return boolean
     */
    boolean BetweenBoundaries(int x, int y);

    /**
     * Sets the midpoint of the object to the given coordinate.
     * @param x - coordiante x
     * @param y - coordinate y
     */
    void SetGameObjectPoint(int x, int y);
}
