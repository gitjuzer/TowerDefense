package TowerDefenseProject;

import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;

import com.example.guth27.progtech.GameObjectHolder;

import Interfaces.GameObject;

/**
 * Created by guth2 on 2018. 05. 10..
 */

enum Direction{
    Up,Down,Left,Right
}

public class Enemy implements GameObject {

    private Point p;
    private Rect rect;
    private GameObject currentDestination;
    private int destinationIndex;
    EnemyStrategy enemyStrategy;
    Direction movingDirection;

    public Enemy(Point spawnPosition, int width, int height, EnemyStrategy enemyStrategy)
    {
        p = spawnPosition;
        this.rect = new Rect(p.x - width/2, p.y - height/2,p.x + width/2, p.y + height/2);
        destinationIndex = 1;
        this.enemyStrategy = enemyStrategy;
    }

    @Override
    public void Draw(Canvas canvas) {
        enemyStrategy.Draw(canvas, rect);
    }

    @Override
    public void Update() {
        if(ReachedDestionation()) {
            destinationIndex++;
            currentDestination = Game.GetNextRoutePoint(destinationIndex);
        }
        if(p.x == currentDestination.GetPosition().x && p.y > currentDestination.GetPosition().y) movingDirection = Direction.Up;
        else if(p.x == currentDestination.GetPosition().x && p.y < currentDestination.GetPosition().y) movingDirection = Direction.Down;
        else if(p.x > currentDestination.GetPosition().x && p.y == currentDestination.GetPosition().y) movingDirection = Direction.Left;
        else movingDirection = Direction.Right;

        if(movingDirection == Direction.Up){
            p.y -= enemyStrategy.GetSpeed();
        }
        else if(movingDirection == Direction.Down){
            p.y += enemyStrategy.GetSpeed();
        }
        else if(movingDirection == Direction.Left){
            p.x -= enemyStrategy.GetSpeed();
        }
        else{
            p.x += enemyStrategy.GetSpeed();
        }

        rect.set(p.x - rect.width()/2, p.y - rect.height()/2,p.x + rect.width()/2, p.y + rect.height()/2);

    }

    private boolean ReachedDestionation() {
        boolean reached = false;

        if(currentDestination.GetLabel() == "EnemyTarget"){
            GameObjectHolder.GetInstance().RemoveGameObjectFromHolder(this);
        }

        if(movingDirection == Direction.Up){
            if(p.y <= currentDestination.GetPosition().y) {
                reached = true;
                p.y = currentDestination.GetPosition().y;
            }
        }
        else if(movingDirection == Direction.Down){
            if(p.y >= currentDestination.GetPosition().y) {
                reached = true;
                p.y = currentDestination.GetPosition().y;
            }
        }
        else if(movingDirection == Direction.Left){
            if(p.x <= currentDestination.GetPosition().x) {
                reached = true;
                p.x = currentDestination.GetPosition().x;
            }
        }
        else{
            if(p.x >= currentDestination.GetPosition().x) {
                reached = true;
                p.x = currentDestination.GetPosition().x;
            }
        }
        return reached;
    }

    @Override
    public void OnDestroy() {
        //hp--
        Game.AddGamePoint(enemyStrategy.GetReward());
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
        return false;
    }

    @Override
    public boolean BetweenBoundaries(int x, int y) {
        return false;
    }

    public void DamageTaken(int damage)
    {
        enemyStrategy.SetHealth(enemyStrategy.GetHealth() - damage);
        if(enemyStrategy.GetHealth() <= 0)
            GameObjectHolder.GetInstance().RemoveGameObjectFromHolder(this);
    }
}
