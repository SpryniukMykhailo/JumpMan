package model.gameplay;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import model.abstracts.AbstractMovingObject;
import model.enums.MovingDirection;
import model.objects.MainCharacter;

import java.util.LinkedList;

public class GamePlay  {
    private LinkedList<AbstractMovingObject> characters;

    public GamePlay(LinkedList<AbstractMovingObject> characters) {
        this.characters = characters;
    }

    protected boolean checkAvailability(int x, int y) {
        return true;
    }

    protected void move(int x, int y, AbstractMovingObject movingObject) {
        if (checkAvailability(x, y)) {
            movingObject.setPosition(x, y);
            //gridPane.getChildren().remove(gridPane.getChildren().indexOf(movingObject.getLabel()));
            //gridPane.add(movingObject.getLabel(), x, y);
            //movingObject.setPosition(x, y);
        } else {
            //No movement.
        }
    }

    public void move(MovingDirection direction, AbstractMovingObject movingObject) {

        switch (direction) {
            case UP: {
                move(movingObject.getX(), movingObject.getY() - 1, movingObject);
                break;
            }
            case DOWN: {
                move(movingObject.getX(), movingObject.getY() + 1, movingObject);
                break;
            }
            case LEFT: {
                move(movingObject.getX() - 1, movingObject.getY(), movingObject);
                break;
            }
            case RIGHT: {
                move(movingObject.getX() + 1, movingObject.getY(), movingObject);
                break;
            }
        }
    }

}
