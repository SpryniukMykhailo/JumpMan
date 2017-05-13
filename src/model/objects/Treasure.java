package model.objects;

import javafx.scene.image.Image;
import model.abstracts.AbstractGameObject;
import model.enums.GameObjectType;

/**
 * Created by SpryniukPC on 06.04.17.
 */

public class Treasure extends AbstractGameObject {
    private Image image = new Image("/resources/treasure.png");

    public Treasure() {super.setType(GameObjectType.TREASURE);}


    @Override
    public Image getImage() {
        return image;
    }
}
