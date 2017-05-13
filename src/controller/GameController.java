package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import main.MainClass;
import model.gameplay.GamePlay;
import model.gamemap.fs.GameMap;
import model.objects.MainCharacter;
import java.net.URL;
import java.util.ResourceBundle;

public class GameController implements Initializable {
    @FXML
    private GridPane gridPaneMap;
    private GamePlay gp;
    private Stage dialogStage;

    private MainClass main;
    private MainCharacter mc;

    public void setMainClass(MainClass main) {
        this.main = main;
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        mc = new MainCharacter();
        new GameMap(gridPaneMap, mc);
        setMainClass(new MainClass());
        gp = new GamePlay(gridPaneMap, mc);
    }

    @FXML
    public void handleBackToMainMenu() {
        dialogStage.close();
    }

    @FXML
    public void handleMoveRight() { gp.moveRight(); }
    @FXML
    public void handleMoveLeft() { gp.moveLeft(); }
    @FXML
    public void handleMoveUP() {
        gp.moveUp();
     }
    @FXML
    public void handleMoveDown() {
        gp.moveDown();
    }
}
