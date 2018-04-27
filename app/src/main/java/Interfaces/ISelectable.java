package Interfaces;

import Interfaces.GameObject;

/**
 * Created by guth2 on 2018. 04. 22.
 * An Iselectable object's OnSelected method will execute when tapped on and the UnSelected method will execute when the user taps anywhere else after the object was selected.
 */

public interface ISelectable {
    boolean BetweenBoundaries(int x, int y);
    void OnSelected();
    void OnUnSelected(GameObject previouslySelected);
}
