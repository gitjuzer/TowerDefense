package TowerDefenseProject;

import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;

import com.example.guth27.progtech.GameObjectHolder;

import Interfaces.GameObject;

/**
 * Created by guth2 on 2018. 05. 10..
 */

enum Direction{
    Up,Down,Left,Right
}

public class Enemy implements GameObject, IObserver {

    private Point p;
    private Rect rect;
    private Point currentDestination;
    private int destinationIndex;
    private EnemyStrategy enemyStrategy;
    private Direction movingDirection;
    private boolean destroyedByTurret;


    public Enemy(Point spawnPosition, int width, int height, EnemyStrategy enemyStrategy)
    {
        Game.RegisterToNotifier(this);
        p = spawnPosition;
        this.rect = new Rect(p.x - width/2, p.y - height/2,p.x + width/2, p.y + height/2);
        destinationIndex = 1;
        this.enemyStrategy = enemyStrategy;
        currentDestination = Game.GetNextRoutePoint(destinationIndex);
        destroyedByTurret = false;
    }

    @Override
    public void Draw(Canvas canvas) {
        enemyStrategy.Draw(canvas,  new RectF(rect));
    }

    @Override
    public void Update() {
           if (ReachedDestionation()) {
               destinationIndex++;
               currentDestination = Game.GetNextRoutePoint(destinationIndex);
           }
           if (p.x == currentDestination.x && p.y > currentDestination.y)
               movingDirection = Direction.Up;
           else if (p.x == currentDestination.x && p.y < currentDestination.y)
               movingDirection = Direction.Down;
           else if (p.x > currentDestination.x && p.y == currentDestination.y)
               movingDirection = Direction.Left;
           else movingDirection = Direction.Right;

           if (movingDirection == Direction.Up) {
               p.y -= enemyStrategy.GetSpeed();
           } else if (movingDirection == Direction.Down) {this.p.y += this.enemyStrategy.GetSpeed();
           } else if (movingDirection == Direction.Left) {
               p.x -= enemyStrategy.GetSpeed();
           } else {
               p.x += enemyStrategy.GetSpeed();
           }


        rect.set(p.x - rect.width()/2, p.y - rect.height()/2,p.x + rect.width()/2, p.y + rect.height()/2);

    }

    private boolean ReachedDestionation() {
        boolean reached = false;


        if(movingDirection == Direction.Up){
            if(p.y <= currentDestination.y) {
                reached = true;
                p.y = currentDestination.y;

            }
        }
        else if(movingDirection == Direction.Down){
            if(p.y >= currentDestination.y) {
                reached = true;
                p.y = currentDestination.y;
            }
        }
        else if(movingDirection == Direction.Left){
            if(p.x <= currentDestination.x) {
                reached = true;
                p.x = currentDestination.x;
            }
        }
        else{
            if(p.x >= currentDestination.x) {
                reached = true;
                p.x = currentDestination.x;
            }
        }
        return reached;
    }

    @Override
    public void OnDestroy() {
        if(destroyedByTurret)
            Game.AddGamePoint(enemyStrategy.GetReward());
        Game.RemoveFromNotifier(this);
    }

    @Override
    public String GetLabel() {
        return "Enemy";
    }

    @Override
    public void Start() {

    }

    @Override
    public Point GetPosition() {
        return p;
    }

    @Override
    public boolean IsTrigger() {
        return true;
    }

    @Override
    public boolean BetweenBoundaries(int x, int y) {
        return false;
    }

    public void DamageTaken(int damage)
    {
        enemyStrategy.SetHealth(enemyStrategy.GetHealth() - damage);
        if(enemyStrategy.GetHealth() <= 0) {
            destroyedByTurret = true;
            GameObjectHolder.GetInstance().RemoveGameObjectFromHolder(this);
        }
    }

    @Override
    public void ReceiveNotification(DayNight state) {
        if(state == DayNight.Night) this.enemyStrategy.SetSpeed(enemyStrategy.GetSpeed() + 2);
    }
}
