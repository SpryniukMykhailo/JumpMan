package model.gamemap.fs;

import model.abstracts.AbstractGameObject;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.function.BiConsumer;

/**
 * Created by SpryniukPC on 14.05.17.
 */
public class MapContainer extends ArrayList<ArrayList<LinkedList<AbstractGameObject>>> {
    protected final int SIZE = 20;
    public MapContainer() {
        for (int i = 0; i < SIZE; i++) {
            ArrayList<LinkedList<AbstractGameObject>> temp = new ArrayList<LinkedList<AbstractGameObject>>();
            for (int j = 0; j < SIZE; j++)
                temp.add(new LinkedList<AbstractGameObject>());
            add(temp);
        }
    }

    public void add(int x, int y, AbstractGameObject go) {
        get(x).get(y).add(go);
    }
    public void remove(int x, int y, AbstractGameObject go) {
        get(x).get(y).remove(go);
    }

    public LinkedList<AbstractGameObject> get(int x, int y) {
        return get(x).get(y);
    }
    public void forEach(TriFunction<Integer, Integer, AbstractGameObject, Void> lambda) {
        for(int x = 0; x < this.size(); x++)
            for(int y = 0; y < this.get(x).size(); y++)
                for (AbstractGameObject o : get(x,y)) {
                    lambda.apply(x,y,o);
                }
    }
}
