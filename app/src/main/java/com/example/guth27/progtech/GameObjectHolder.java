package com.example.guth27.progtech;

import android.graphics.Canvas;
import android.graphics.Point;
import android.telephony.IccOpenLogicalChannelResponse;

import java.util.ArrayList;
import java.util.List;

import Interfaces.GameObject;
import Interfaces.ICollisionTrigger;
import Interfaces.IMovable;
import Interfaces.ISelectable;

/**
 * Created by guth2 on 2018. 04. 22.
 * Container class. Holds all GameObject and makes there basic funcions accessable.
 */

public class GameObjectHolder {

    private static GameObjectHolder uniqueInstance=null;
    private int totalObjects;

    private List<GameObject> layer0;
    private List<GameObject> layer1;
    private List<GameObject> layer2;
    private List<GameObject> layer3;
    private List<GameObject> layer4;
    private List<GameObject> nonDrawable;
    private List<IMovable> movables;
    private List<ISelectable> selectables;
    private List<GameObject> triggers;
    private List<ICollisionTrigger> collisionTriggers;

    public static GameObjectHolder GetInstance()
    {
        if (uniqueInstance==null)
        {
            uniqueInstance = new GameObjectHolder();
        }
        return uniqueInstance;
    }

    private GameObjectHolder(){
        layer0 = new ArrayList<>();
        layer1 = new ArrayList<>();
        layer2 = new ArrayList<>();
        layer3 = new ArrayList<>();
        layer4 = new ArrayList<>();
        nonDrawable = new ArrayList<>();
        movables = new ArrayList<>();
        selectables = new ArrayList<>();
        triggers = new ArrayList<>();
        collisionTriggers = new ArrayList<>();
    }

    public int NumOfGameObjects(){ return totalObjects; }
    public int NumOfIMovables() { return  movables.size(); }
    public int NumOfISelectables() { return selectables.size(); }

    public List<GameObject> GetAllGameObjectWithLable(String label)
    {
        List<GameObject> objects = new ArrayList<>();
        for(GameObject o : layer0) {
            if (o.GetLabel() == label)
                objects.add(o);
        }
        for(GameObject o : layer1) {
            if (o.GetLabel() == label)
                objects.add(o);
        }
        for(GameObject o : layer2) {
            if (o.GetLabel() == label)
                objects.add(o);
        }
        for(GameObject o : layer3) {
            if (o.GetLabel() == label)
                objects.add(o);
        }
        for(GameObject o : layer4) {
            if (o.GetLabel() == label)
                objects.add(o);
        }
        for(GameObject o : nonDrawable) {
            if (o.GetLabel() == label)
                objects.add(o);
        }
        return objects;
    }

    public void AddGameObjectToHolderLayer0(GameObject object) {
        layer0.add(object);
        totalObjects++;
        if(object instanceof IMovable) AddIMovable((IMovable) object);
        if(object instanceof ISelectable) AddISelectable((ISelectable) object);
        if(object instanceof ICollisionTrigger) AddICollisionTrigger((ICollisionTrigger) object);
        if(object.IsTrigger()) AddTrigger(object);
        object.Start();
    }
    public void AddGameObjectToHolderLayer1(GameObject object) {
        layer1.add(object);
        totalObjects++;
        if(object instanceof IMovable) AddIMovable((IMovable) object);
        if(object instanceof ISelectable) AddISelectable((ISelectable) object);
        if(object instanceof ICollisionTrigger) AddICollisionTrigger((ICollisionTrigger) object);
        if(object.IsTrigger()) AddTrigger(object);
        object.Start();
    }
    public void AddGameObjectToHolderLayer2(GameObject object) {
        layer2.add(object);
        totalObjects++;
        if(object instanceof IMovable) AddIMovable((IMovable) object);
        if(object instanceof ISelectable) AddISelectable((ISelectable) object);
        if(object instanceof ICollisionTrigger) AddICollisionTrigger((ICollisionTrigger) object);
        if(object.IsTrigger()) AddTrigger(object);
        object.Start();
    }
    public void AddGameObjectToHolderLayer3(GameObject object) {
        layer3.add(object);
        totalObjects++;
        if(object instanceof IMovable) AddIMovable((IMovable) object);
        if(object instanceof ISelectable) AddISelectable((ISelectable) object);
        if(object instanceof ICollisionTrigger) AddICollisionTrigger((ICollisionTrigger) object);
        if(object.IsTrigger()) AddTrigger(object);
        object.Start();
    }
    public void AddGameObjectToHolderLayer4(GameObject object) {
        layer4.add(object);
        totalObjects++;
        if(object instanceof IMovable) AddIMovable((IMovable) object);
        if(object instanceof ISelectable) AddISelectable((ISelectable) object);
        if(object instanceof ICollisionTrigger) AddICollisionTrigger((ICollisionTrigger) object);
        if(object.IsTrigger()) AddTrigger(object);
        object.Start();
    }
    public void AddGameObjectToHolderNonDrawable(GameObject object) {
        nonDrawable.add(object);
        totalObjects++;
        object.Start();
    }
    private void AddIMovable(IMovable movable) {movables.add(movable);}
    private void AddISelectable(ISelectable selectable) {selectables.add(selectable);}
    private void AddICollisionTrigger(ICollisionTrigger collisionTrigger) {collisionTriggers.add(collisionTrigger);}
    private void AddTrigger(GameObject object){triggers.add(object);}
    public void RemoveGameObjectFromHolder(GameObject object) {
        if(object != null){
            object.OnDestroy();
        }
        boolean found = Remover(layer0, object);
        if(!found) found = Remover(layer1, object);
        if(!found) found = Remover(layer2, object);
        if(!found) found = Remover(layer3, object);
        if(!found) found = Remover(layer4, object);

        if(!found) System.out.println("NonExistent GameObject at RemoveGameObjectFromHolder");
    }
    public void RemoveNonDrawableFromHolder(GameObject object)
    {
        nonDrawable.remove(object);
    }
    private boolean Remover(List<GameObject> layer, GameObject object)
    {
        for(int i = 0; i < layer.size();i++) {
            if(object == layer.get(i)){
                if(object instanceof  IMovable) movables.remove((IMovable) object);
                if(object instanceof  ISelectable) selectables.remove((ISelectable) object);
                if(object instanceof  ICollisionTrigger) collisionTriggers.remove((ICollisionTrigger) object);
                if(object.IsTrigger()) triggers.remove(object);
                layer.remove(i);
                return true;
            }
        }
        return false;
    }

    public void CheckTriggers()
    {
        for(ICollisionTrigger col : collisionTriggers)
        {
            for(GameObject trigger : triggers)
            {
                Point p = trigger.GetPosition();
                if(col.BetweenBoundaries(p.x,p.y))
                    col.OnTriggerEnter(trigger);
            }
        }
    }
    public void UpdateAll() {
        for(GameObject o : layer0) o.Update();
        for(GameObject o : layer1) o.Update();
        for(GameObject o : layer2) o.Update();
        for(GameObject o : layer3) o.Update();
        for(GameObject o : layer4) o.Update();
        for(GameObject o : nonDrawable) o.Update();
    }
    public void DrawAll(Canvas canvas){

        for(int i = layer0.size() - 1; i >= 0; i--) {
            layer0.get(i).Draw(canvas);
        }
        for(int i = layer1.size() - 1; i >= 0; i--) {
            layer1.get(i).Draw(canvas);
        }
        for(int i = layer2.size() - 1; i >= 0; i--) {
            layer2.get(i).Draw(canvas);
        }
        for(int i = layer3.size() - 1; i >= 0; i--) {
            layer3.get(i).Draw(canvas);
        }
        for(int i = layer4.size() - 1; i >= 0; i--) {
            layer4.get(i).Draw(canvas);
        }
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
    public List<IMovable> GetIMovables()
    {
        return movables;
    }
    private void PutOnTop(List<GameObject> layer, GameObject object)
    {
        layer.add(0,object);
    }

    public void RemoveAll(){
        layer0.clear();
        layer1.clear();
        layer2.clear();
        layer3.clear();
        layer4.clear();
        nonDrawable.clear();
        movables.clear();
        selectables.clear();
        triggers.clear();
        collisionTriggers.clear();

        totalObjects = 0;
    }
}
