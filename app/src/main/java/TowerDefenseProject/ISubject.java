package TowerDefenseProject;

/**
 * Created by guth2 on 2018. 05. 11..
 */

public interface ISubject {
    /**
     * Register an observer to the Subject.
     * @param observer
     */
    void RegisterObserver(IObserver observer);

    /**
     * Removes and observer from the Subject
     * @param observer
     */
    void RemoveObserver(IObserver observer);

    /**
     * Send notification about the current state of gameTime
     * @param state
     */
    void NotifyObservers(DayNight state);
}
