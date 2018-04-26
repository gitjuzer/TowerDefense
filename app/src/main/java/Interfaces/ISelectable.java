package Interfaces;

import Interfaces.GameObject;

/**
 * Created by guth2 on 2018. 04. 22..
 */

public interface ISelectable {
    boolean BetweenBoundaries(int x, int y);
    void OnSelected();
    void OnUnSelected(GameObject previouslySelected);
   // boolean CanChangePosition();
   // void newPosition(int x, int y);
    //void OnTapafterSelected();
}
