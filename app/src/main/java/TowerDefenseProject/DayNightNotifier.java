package TowerDefenseProject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by guth2 on 2018. 05. 11..
 * Observer -  Sends notifications to the turrets and enemies about the day-night cycle
 */

public class DayNightNotifier implements ISubject{

    private  List<IObserver> observers;

    public DayNightNotifier(){
        observers = new ArrayList<IObserver>();
    }

    @Override
    public void RegisterObserver(IObserver observer) {
        try {
            observers.add(observer);
        }catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    @Override
    public void RemoveObserver(IObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void NotifyObservers(DayNight state) {
        for(IObserver o: observers)
            o.ReceiveNotification(state);
    }
}
