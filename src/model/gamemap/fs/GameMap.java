package model.gamemap.fs;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import model.abstracts.AbstractGameObject;
import model.enums.GameObjectType;
import model.objects.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class GameMap {
    private MainCharacter mc;
    private GridPane gPane;

    public GameMap(GridPane gridPane, MainCharacter character) {
        mc = character;
        this.gPane = gridPane;
        drawMap("src/resources/Map.txt");
        loadObjects("src/resources/ObjectPosition.txt");
    }

    private void drawMap(String fileName) {
        File file = new File(fileName);
        if (!file.exists()) {throw new IllegalArgumentException("filename must not be empty");}
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String str;

            int y = 0;
            while ((str = bufferedReader.readLine()) != null) {
                int x = 0;
                for (String s : str.split(",")) {
                    drawObj(x, y, createObj(s));
                    x++;
                }
                y++;
            }
        } catch (Exception e) {e.printStackTrace();}

    }

    private void drawObj(int x, int y, AbstractGameObject gameObject) {
        Label label  = new Label();
        label.setGraphic(new ImageView(gameObject.getImage()));
        gPane.add(label, x, y);

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
                if (s[2].toUpperCase().equals("MAINCHARACTER")) {
                    mc.setPosition(Integer.parseInt(s[0]),Integer.parseInt(s[1]));
                } else {
                    drawObj(Integer.parseInt(s[0]),Integer.parseInt(s[1]), createObj(s[2]));
                }
            }
        } catch (Exception e) {e.printStackTrace();}
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
        return  obj;
    }
    }

