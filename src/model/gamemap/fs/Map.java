package model.gamemap.fs;

import model.abstracts.AbstractGameObject;
import model.enums.GameObjectType;
import model.objects.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.LinkedList;

public class Map {
    private MapContainer map;

    public Map(String mapFilename, String objectsFilename) {
        map = new MapContainer();
        loadMap(mapFilename);
        loadObjects(objectsFilename);
    }

    LinkedList<AbstractGameObject> get(int x, int y) {
        return map.get(x, y);
    }

    private void loadMap(String fileName) {
        File file = new File(fileName);
        if (!file.exists()) {
            throw new IllegalArgumentException("filename must not be empty");
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String str;

            int y = 0;
            while ((str = bufferedReader.readLine()) != null) {
                int x = 0;
                for (String s : str.split(",")) {
                    map.add(x, y, createObj(s));
                    x++;
                }
                y++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadObjects(String fileName) {
        File file = new File(fileName);
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String string;
            String str;
            while ((string = bufferedReader.readLine()) != null) {
                str = string;
                String[] s = str.split(",");
                map.add(Integer.parseInt(s[0]), Integer.parseInt(s[1]), createObj(s[2]));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private AbstractGameObject createObj(String str) {
        GameObjectType type = GameObjectType.valueOf(str.toUpperCase());

        AbstractGameObject obj;

        switch (type) {
            case NOTHING: {
                obj = new Nothing();
                break;
            }
            case MONSTER: {
                obj = new Monster();
                break;
            }
            case MAINCHARACTER: {
                obj = new MainCharacter();
                break;
            }
            case WALL: {
                obj = new Wall();
                break;
            }
            case TREASURE: {
                obj = new Treasure();
                break;
            }
            case EXIT: {
                obj = new Exit();
                break;
            }
            default:
                throw new IllegalArgumentException("Cant create object type: " + type);
        }
        return obj;
    }

      public void forEach(TriFunction<Integer, Integer, AbstractGameObject, Void> lambda) {
          map.forEach(lambda);
      }
}
