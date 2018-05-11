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
        timeBeforeStartMS = 10000;
        timeBetweenWavesMS = 20000;
        waveEndedTimeMS = 0;
        timeBetweenSpawnsMS = 500;
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
                            GameObjectHolder.GetInstance().AddGameObjectToHolderLayer1(new Enemy(new Point(500,0), 30,30, new NormalEnemy(wave)));
                        else if(random == 1)
                            GameObjectHolder.GetInstance().AddGameObjectToHolderLayer1(new Enemy(new Point(500,0), 30,30, new FastEnemy(wave)));
                        else
                            GameObjectHolder.GetInstance().AddGameObjectToHolderLayer1(new Enemy(new Point(500,0), 30,30, new StrongEnemy(wave)));
                        System.out.println(random);
                        enemyIsSpawnedMS = Info.GetTotalRunningTimeMS();
                        alreadySpanedEnemyNum++;
                    }
                }
            }
        } else if(enemyList.size() == 0)
            waitforEnd = false;

    }

    private void SetUpNextWave() {
       alreadySpanedEnemyNum = 0;
       numOfEnemyes += 2;
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
