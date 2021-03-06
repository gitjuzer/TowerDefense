package TowerDefenseProject;

import android.graphics.Canvas;
import android.graphics.Point;

import com.example.guth27.progtech.GameObjectHolder;
import com.example.guth27.progtech.Info;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Interfaces.GameObject;

/**
 * Created by guth2 on 2018. 04. 28..
 */

public class Spawner implements GameObject {
    private static Spawner uniqueInstance=null;

    private Point spawnLocation;

    /**
     * Use this to get the only instance of this class.
     * @param spawnLocation - the location where the enemies should be instantiated.
     * @return Spawner - the only instance of this class
     */
    public static Spawner GetInstance(Point spawnLocation)
    {
        if (uniqueInstance==null)
        {
            uniqueInstance = new Spawner(spawnLocation);
        }
        return uniqueInstance;
    }
    private Spawner(Point spawnLocation)
    {
        this.spawnLocation = spawnLocation;
        enemyList = new ArrayList<>();
        waveInProgress = true;
        timeBeforeStartMS = 5000;
        timeBetweenWavesMS = 10000;
        waveEndedTimeMS = 0;
        timeBetweenSpawnsMS = 350;
        alreadySpanedEnemyNum = 0;
        numOfEnemyes = 5;
        rng = new Random();
        waitforEnd = false;
    }

    private long timeBeforeStartMS;
    private long timeBetweenWavesMS;
    private long waveEndedTimeMS;
    private boolean waveInProgress;
    private long timeBetweenSpawnsMS;
    private long enemyIsSpawnedMS;

    private int numOfEnemyes;
    private int alreadySpanedEnemyNum;

    private  int wave = 1;


    private List<GameObject> enemyList;
    boolean waitforEnd;
    Random rng;

    /**
     * Use this to restart the spawning from wave one.
     */
    public void Restart(){
        wave = 1;
        numOfEnemyes = 5;
    }

    @Override
    public void Draw(Canvas canvas) {}

    @Override
    public void Update() {

        enemyList = GameObjectHolder.GetInstance().GetAllGameObjectWithLable("Enemy");
        if(!waitforEnd) {
            if (timeBetweenSpawnsMS < Info.GetTotalRunningTimeMS() && waveEndedTimeMS <= Info.GetTotalRunningTimeMS() - timeBetweenWavesMS) {
                if (alreadySpanedEnemyNum == numOfEnemyes) {
                    waveEndedTimeMS = Info.GetTotalRunningTimeMS();
                    waitforEnd = true;
                    SetUpNextWave();
                } else {
                    if (enemyIsSpawnedMS <= Info.GetTotalRunningTimeMS() - timeBetweenSpawnsMS) {
                        int random = rng.nextInt(3);
                        if(random == 0)
                            GameObjectHolder.GetInstance().AddGameObjectToHolderLayer1(new Enemy(new Point(spawnLocation.x,spawnLocation.y), 30,30, new NormalEnemy(wave)));
                        else if(random == 1)
                            GameObjectHolder.GetInstance().AddGameObjectToHolderLayer1(new Enemy(new Point(spawnLocation.x,spawnLocation.y), 30,30, new FastEnemy(wave)));
                        else
                            GameObjectHolder.GetInstance().AddGameObjectToHolderLayer1(new Enemy(new Point(spawnLocation.x,spawnLocation.y), 30,30, new StrongEnemy(wave)));
                        enemyIsSpawnedMS = Info.GetTotalRunningTimeMS();
                        alreadySpanedEnemyNum++;
                    }
                }
            }
        } else if(enemyList.size() == 0)
            waitforEnd = false;

    }

    /**
     * Scales the difficulty of the next wave.
     */
    private void SetUpNextWave() {
       alreadySpanedEnemyNum = 0;
       numOfEnemyes += 1;
       this.wave++;
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

    @Override
    public boolean BetweenBoundaries(int x, int y) {
        return false;
    }
}
