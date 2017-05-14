package model.objects;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.abstracts.AbstractGameObject;
import model.enums.GameObjectType;

/**
 * Created by SpryniukPC on 06.04.17.
 */

public class Treasure extends AbstractGameObject {

    public Treasure() {
        super.setType(GameObjectType.TREASURE);
        image = new Image("/resources/treasure.png");
        label.setGraphic(new ImageView(image));
    }
}
