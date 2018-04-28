package TowerDefenseProject;

import android.graphics.Canvas;
import android.graphics.Point;

import com.example.guth27.progtech.GameObjectHolder;
import com.example.guth27.progtech.Info;

import java.util.ArrayList;
import java.util.List;

import Interfaces.GameObject;

/**
 * Created by guth2 on 2018. 04. 28..
 */

public class Spawner implements GameObject {
    private static Spawner uniqueInstance=null;
    private GameObjectHolder Holder;
    private Point spawnLocation;

    public static Spawner GetInstance(GameObjectHolder holder, Point spawnLocation)
    {
        if (uniqueInstance==null)
        {
            uniqueInstance = new Spawner(holder, spawnLocation);
        }
        return uniqueInstance;
    }
    private Spawner(GameObjectHolder Holder, Point spawnLocation)
    {
        this.spawnLocation = spawnLocation;
        this.Holder = Holder;
        enemyList = new ArrayList<>();
        waveInProgress = true;
        timeBeforeStartMS = 5000;
        timeBetweenWavesMS = 10000;
        waveEndedTimeMS = 0;
        timeBetweenSpawnsMS = 500;
        alreadySpanedEnemyNum = 0;
        numOfEnemyes = 5;
    }

    private long timeBeforeStartMS;
    private long timeBetweenWavesMS;
    private long waveEndedTimeMS;
    private boolean waveInProgress;
    private long timeBetweenSpawnsMS;
    private long enemyIsSpawnedMS;

    private int numOfEnemyes;
    private int alreadySpanedEnemyNum;


    private List<GameObject> enemyList;

    @Override
    public void Draw(Canvas canvas) {}

    @Override
    public void Update() {

        enemyList = Holder.GetAllGameObjectWithLable("Enemy");

        if(timeBeforeStartMS <= Info.GetTotalRunningTimeMS() && waveInProgress && waveEndedTimeMS <= Info.GetTotalRunningTimeMS() - timeBetweenWavesMS)
        {
            System.out.println("start");
            if(alreadySpanedEnemyNum == numOfEnemyes) {
                waveEndedTimeMS = Info.GetTotalRunningTimeMS();
                SetUpNextWave();
            } else
            {
                if(enemyIsSpawnedMS <= Info.GetTotalRunningTimeMS() - timeBetweenSpawnsMS){
                    //spawn here at spawnLocation
                    System.out.println("spawn");
                    enemyIsSpawnedMS = Info.GetTotalRunningTimeMS();
                    alreadySpanedEnemyNum++;
                }
            }
        }
    }

    private void SetUpNextWave() {
        alreadySpanedEnemyNum = 0;
    }

    @Override
    public void OnDestroy() {}

    @Override
    public String GetLabel() {
        return "Spawner";
    }

    @Override
    public void Start() {
    }

    @Override
    public Point GetPosition() {
        return null;
    }

    @Override
    public boolean IsTrigger() {
        return false;
    }
}
