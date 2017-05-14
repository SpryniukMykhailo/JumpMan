package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import main.MainClass;
import model.abstracts.AbstractGameObject;
import model.abstracts.AbstractMovingObject;
import model.enums.GameObjectType;
import model.enums.MovingDirection;
import model.gamemap.fs.Map;
import model.gameplay.GamePlay;
import model.objects.MainCharacter;
import model.objects.Monster;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

public class GameController implements Initializable {
    @FXML
    private GridPane gridPaneMap;
    private GamePlay gp;
    private Stage dialogStage;

    private MainClass main;
    private Map map;
    private LinkedList<AbstractMovingObject> characters;

    public void setMainClass(MainClass main) {
        this.main = main;
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        map = new Map("src/resources/Map.txt", "src/resources/ObjectPosition.txt");
        loadCharacters("src/resources/MovObj.txt");

        setMainClass(new MainClass());
        drawMap();
        gp = new GamePlay(characters);
    }

    public void drawMap() {
        gridPaneMap.getChildren().clear();
        map.forEach((Integer x, Integer y, AbstractGameObject o) -> {
            gridPaneMap.add(o.getLabel(), x, y);
            return null;
        });
        for (AbstractMovingObject obj : characters)
            gridPaneMap.add(obj.getLabel(), obj.getX(), obj.getY());
    }
    protected void loadCharacters(String fileName) {
        characters = new LinkedList<AbstractMovingObject>();
        File file = new File(fileName);
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String string;
            String str;
            while ((string = bufferedReader.readLine()) != null) {
                str = string;
                String[] s = str.split(",");
                switch (GameObjectType.valueOf(s[2].toUpperCase())) {
                    case MONSTER: {
                        characters.add(new Monster());
                        break;
                    }
                    case MAINCHARACTER: {
                        characters.add(new MainCharacter());
                        break;
                    }
                    default:
                        throw new IllegalArgumentException("Cant create moving object.");
                }
                characters.getLast().setPosition(Integer.parseInt(s[0]), Integer.parseInt(s[1]));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void handleBackToMainMenu() {
        dialogStage.close();
    }

    @FXML
    public void handleMoveRight() { gp.move(MovingDirection.RIGHT, characters.getFirst()); drawMap();}
    @FXML
    public void handleMoveLeft() { gp.move(MovingDirection.LEFT, characters.getFirst()); drawMap();}
    @FXML
    public void handleMoveUP() { gp.move(MovingDirection.UP, characters.getFirst()); drawMap();}
    @FXML
    public void handleMoveDown() { gp.move(MovingDirection.DOWN, characters.getFirst()); drawMap();}
}
