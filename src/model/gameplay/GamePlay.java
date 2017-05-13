package model.gameplay;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import model.objects.MainCharacter;

public class GamePlay  {
    private GridPane gridPane;
    private MainCharacter mc;
    private Label label;

    public GamePlay(GridPane gridPane, MainCharacter character) {
        this.gridPane = gridPane;
        mc = character;
        label = new Label();
        label.setGraphic(new ImageView(mc.getImage()));
        gridPane.add(label, mc.getX(), mc.getY());
    }
    
    public void moveUp() {
        gridPane.getChildren().remove(gridPane.getChildren().indexOf(label));
        gridPane.add(label, mc.getX(), mc.getY() - 1);
        mc.setPosition(mc.getX(), mc.getY() - 1);
    }
    public void moveDown() {
        gridPane.getChildren().remove(gridPane.getChildren().indexOf(label));
        gridPane.add(label, mc.getX(), mc.getY() + 1);
        mc.setPosition(mc.getX(), mc.getY() + 1);
    }
    public void moveLeft() {
        gridPane.getChildren().remove(gridPane.getChildren().indexOf(label));
        gridPane.add(label, mc.getX() - 1, mc.getY());
        mc.setPosition(mc.getX() - 1, mc.getY());
    }
    public void moveRight() {
        gridPane.getChildren().remove(gridPane.getChildren().indexOf(label));
        gridPane.add(label, mc.getX() + 1, mc.getY());
        mc.setPosition(mc.getX() + 1, mc.getY());
    }

}
