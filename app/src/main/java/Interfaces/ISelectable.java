package Interfaces;

import Interfaces.GameObject;

/**
 * Created by guth2 on 2018. 04. 22.
 * An Iselectable object's OnSelected method will execute when tapped on and the UnSelected method will execute when the user taps anywhere else after the object was selected.
 */

public interface ISelectable {
    /**
     * Checks if the point is between the boundaries of this gameObject.
     * @param x
     * @param y
     * @return boolean
     */
    boolean BetweenBoundaries(int x, int y);

    /**
     * Runs when the object is selected.
     * @param previouslySelected - the previously selected gameObject
     */
    void OnSelected(GameObject previouslySelected);

    /**
     * Runs when the object is unselected.
     * @param previouslySelected - the previously selected gameObject
     */
    void OnUnSelected(GameObject previouslySelected);
}
