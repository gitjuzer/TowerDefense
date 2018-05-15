package TowerDefenseProject;

import android.graphics.Point;

import java.util.List;

import Interfaces.GameObject;

/**
 * Created by guth2 on 2018. 04. 29..
 */

public abstract class TurretStrategy {
    /**
     * Gets the valid targets for the turret this is attached to
     * @return List - The targets of the turret
     */
    public abstract List<GameObject> Targets();

    /**
     * Sets the point where the distance should be calculated from
     * @param p - The midpoint of the turret this is attached to
     */
    public abstract void SetPoint(Point p);

    /**
     * Gets the maximum fireRange this turret has
     * @return int - The maximum fireRange of the turret
     */
    public abstract int GetFireRange();

    /**
     * Sets the maximum fireRange this turret will have
     * @param firerange - The maximum fireRange of the turret
     */
    public abstract void SetFireRange(int firerange);

    /**
     * Checks if the turret can fire in the moment this is called
     * @return boolean - Can the turret fire at given moment.
     */
    public abstract boolean CanShoot();

    /**
     * Set the current list of enemies.
     * @param enemies - The list of currently alive enemies
     */
    public abstract void SetOpponents(List<GameObject> enemies);

    /**
     * Get the type of the turret
     * @return String - The type of the turret
     */
    public abstract String Type();

    /**
     * Get the color of the laser
     * @return int - The color of the laser
     */
    public abstract int LaserColor();
}
