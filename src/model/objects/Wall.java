package model.objects;

import javafx.scene.image.Image;
import model.abstracts.AbstractGameObject;
import model.enums.GameObjectType;

/**
 * Class for wall object.
 */
public class Wall extends AbstractGameObject {
    private Image image = new Image("/resources/wall.png");

    public Wall(){
        super.setType(GameObjectType.WALL);
    }

    @Override
    public Image getImage() {
        return image;
    }
}
