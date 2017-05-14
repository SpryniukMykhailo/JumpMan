package model.objects;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.abstracts.AbstractGameObject;
import model.enums.GameObjectType;

/**
 * Class for wall object.
 */
public class Wall extends AbstractGameObject {

    public Wall(){
        super.setType(GameObjectType.WALL);
        image = new Image("/resources/wall.png");
        label.setGraphic(new ImageView(image));
    }
}
