package TowerDefenseProject;

/**
 * Created by guth2 on 2018. 05. 11..
 */

public interface IObserver {
    /**
     * Receive the notification about the current state of gameTime
     * @param state
     */
    void ReceiveNotification(DayNight state);
}
