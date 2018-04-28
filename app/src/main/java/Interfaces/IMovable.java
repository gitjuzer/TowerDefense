package Interfaces;

/**
 * Created by guth2 on 2018. 04. 22..
 */

public interface IMovable {
    //void UpdateMovemenet();
    boolean BetweenBoundaries(int x, int y);
    void SetGameObjectPoint(int x, int y);
}
