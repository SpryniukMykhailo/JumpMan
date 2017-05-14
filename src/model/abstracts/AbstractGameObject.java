package model.abstracts;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.enums.GameObjectType;

public abstract class AbstractGameObject {
    private GameObjectType type;
    protected Image image = new Image("/resources/noicon.png");
    protected Label label;

    protected AbstractGameObject() {
        label = new Label();
        label.setGraphic(new ImageView(image));
    }

    public GameObjectType getType() {
        return type;
    }

    protected void setType(GameObjectType type) {this.type = type;}

    public Image getImage() {
        return image;
    }

    public Label getLabel() {
        return label;
    }
}
