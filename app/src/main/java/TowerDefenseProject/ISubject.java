package TowerDefenseProject;

/**
 * Created by guth2 on 2018. 05. 11..
 */

public interface ISubject {
    void RegisterObserver(IObserver observer);
    void RemoveObserver(IObserver observer);
    void NotifyObservers(DayNight state);
}
