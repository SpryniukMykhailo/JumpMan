package model.abstracts;

import javafx.scene.image.Image;
import model.enums.GameObjectType;

public abstract class AbstractGameObject {
    private GameObjectType type;
    protected Image image = new Image("/resources/noicon.png");

    protected AbstractGameObject() {
    }

    public GameObjectType getType() {
        return type;
    }

    protected void setType(GameObjectType type) {this.type = type;}

    public Image getImage() {
        return image;
    }
}
