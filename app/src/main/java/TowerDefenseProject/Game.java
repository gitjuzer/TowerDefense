package TowerDefenseProject;

import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;

import com.example.guth27.progtech.AbstractGame;
import com.example.guth27.progtech.GameObjectHolder;

/**
 * Created by guth2 on 2018. 04. 26.
 * The Core of the game comes here.
 */

public class Game extends AbstractGame {



    public Game(GameObjectHolder holder)
    {
        super(holder);
    }

    @Override
    public void Start(){
        super.Holder.AddGameObjectToHolderNonDrawable(Spawner.GetInstance(super.Holder));
    }

    @Override
    public void Update() {

    }
}
