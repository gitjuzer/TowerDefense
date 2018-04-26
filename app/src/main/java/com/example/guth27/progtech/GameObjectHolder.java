package com.example.guth27.progtech;

import android.graphics.Canvas;

import java.util.ArrayList;
import java.util.List;

import Interfaces.GameObject;
import Interfaces.IMovable;
import Interfaces.ISelectable;

/**
 * Created by guth2 on 2018. 04. 22..
 */

public class GameObjectHolder {

    int totalObjects;

    List<GameObject> layer0;
    List<GameObject> layer1;
    List<GameObject> layer2;
    List<GameObject> layer3;
    List<GameObject> layer4;
    List<GameObject> nonDrawable;
    List<IMovable> movables;
    List<ISelectable> selectables;

    public GameObjectHolder(){
        layer0 = new ArrayList<>();
        layer1 = new ArrayList<>();
        layer2 = new ArrayList<>();
        layer3 = new ArrayList<>();
        layer4 = new ArrayList<>();
        nonDrawable = new ArrayList<>();
        movables = new ArrayList<>();
        selectables = new ArrayList<>();
    }

    public int NumOfGameObjects(){ return totalObjects; }
    public int NumOfIMovables() { return  movables.size(); }
    public int NumOfISelectables() { return selectables.size(); }


    public void AddGameObjectToHolderLayer0(GameObject object) {
        layer0.add(object);
        totalObjects++;
        if(object instanceof IMovable) AddIMovable((IMovable) object);
        if(object instanceof ISelectable) AddISelectable((ISelectable) object);
        object.Start();
    }
    public void AddGameObjectToHolderLayer1(GameObject object) {
        layer1.add(object);
        totalObjects++;
        if(object instanceof IMovable) AddIMovable((IMovable) object);
        if(object instanceof ISelectable) AddISelectable((ISelectable) object);
        object.Start();
    }
    public void AddGameObjectToHolderLayer2(GameObject object) {
        layer2.add(object);
        totalObjects++;
        if(object instanceof IMovable) AddIMovable((IMovable) object);
        if(object instanceof ISelectable) AddISelectable((ISelectable) object);
        object.Start();
    }
    public void AddGameObjectToHolderLayer3(GameObject object) {
        layer3.add(object);
        totalObjects++;
        if(object instanceof IMovable) AddIMovable((IMovable) object);
        if(object instanceof ISelectable) AddISelectable((ISelectable) object);
        object.Start();
    }
    public void AddGameObjectToHolderLayer4(GameObject object) {
        layer4.add(object);
        totalObjects++;
        if(object instanceof IMovable) AddIMovable((IMovable) object);
        if(object instanceof ISelectable) AddISelectable((ISelectable) object);
        object.Start();
    }
    public void AddGameObjectToHolderNonDrawable(GameObject object) {
        nonDrawable.add(object);
        totalObjects++;
        object.Start();
    }
    private void AddIMovable(IMovable movable) {movables.add(movable);}
    private void AddISelectable(ISelectable selectable) {selectables.add(selectable);}
    public void RemoveGameObjectFromHolder(GameObject object) {
        boolean found = Remover(layer0, object);
        if(found == false) found = Remover(layer1, object);
        if(found == false) found = Remover(layer2, object);
        if(found == false) found = Remover(layer3, object);
        if(found == false) found = Remover(layer4, object);

        if(found == false) System.out.println("NonExistent GameObject at RemoveGameObjectFromHolder");
    }
    private boolean Remover(List<GameObject> layer, GameObject object)
    {
        for(int i = 0; i < layer.size();i++) {
            if(object == layer.get(i)){
                layer.remove(i);
                return true;
            }
        }
        return false;
    }

    public void UpdateAll() {
        for(GameObject o : layer0) o.Update();
        for(GameObject o : layer1) o.Update();
        for(GameObject o : layer2) o.Update();
        for(GameObject o : layer3) o.Update();
        for(GameObject o : layer4) o.Update();
        for(GameObject o : nonDrawable) o.Update();
    }
    public void UpdateMovables() {
        for(IMovable m: movables) m.UpdateMovemenet();
    }
    public void DrawAll(Canvas canvas){
        for(GameObject o : layer0) o.Draw(canvas);
        for(GameObject o : layer1) o.Draw(canvas);
        for(GameObject o : layer2) o.Draw(canvas);
        for(GameObject o : layer3) o.Draw(canvas);
        for(GameObject o : layer4) o.Draw(canvas);
    }
    public IMovable GetSelectedMovable(int x, int y)
    {
        for(GameObject o : layer4) {
            if(o instanceof IMovable) {
                if(((IMovable) o).BetweenBoundaries(x,y)) {PutOnTop(layer4, o); return (IMovable) o;}
            }
        }
        for(GameObject o : layer3) {
            if(o instanceof IMovable) {
                if(((IMovable) o).BetweenBoundaries(x,y)) {PutOnTop(layer3, o); return (IMovable) o;}
            }
        }
        for(GameObject o : layer2) {
            if(o instanceof IMovable) {
                if(((IMovable) o).BetweenBoundaries(x,y)) {PutOnTop(layer2, o); return (IMovable) o;}
            }
        }
        for(GameObject o : layer1) {
            if(o instanceof IMovable) {
                if(((IMovable) o).BetweenBoundaries(x,y)) {PutOnTop(layer1, o); return (IMovable) o;}
            }
        }
        for(GameObject o : layer0) {
            if(o instanceof IMovable) {
                if(((IMovable) o).BetweenBoundaries(x,y)) {PutOnTop(layer0, o); return (IMovable) o;}
            }
        }

        return null;
    }
    public ISelectable GetSelectedSelectable(int x, int y)
    {
        for(GameObject o : layer4) {
            if(o instanceof ISelectable) {
                if(((ISelectable) o).BetweenBoundaries(x,y)) {PutOnTop(layer4, o); return (ISelectable) o;}
            }
        }
        for(GameObject o : layer3) {
            if(o instanceof ISelectable) {
                if(((IMovable) o).BetweenBoundaries(x,y)) {PutOnTop(layer3, o); return (ISelectable) o;}
            }
        }
        for(GameObject o : layer2) {
            if(o instanceof ISelectable) {
                if(((ISelectable) o).BetweenBoundaries(x,y)) {PutOnTop(layer2, o); return (ISelectable) o;}
            }
        }
        for(GameObject o : layer1) {
            if(o instanceof ISelectable) {
                if(((ISelectable) o).BetweenBoundaries(x,y)) {PutOnTop(layer1, o); return (ISelectable) o;}
            }
        }
        for(GameObject o : layer0) {
            if(o instanceof ISelectable) {
                if(((ISelectable) o).BetweenBoundaries(x,y)) {PutOnTop(layer0, o); return (ISelectable) o;}
            }
        }

        return null;
    }
    private void PutOnTop(List<GameObject> layer, GameObject object)
    {
        layer.remove(object);
        layer.add(object);
    }
}
