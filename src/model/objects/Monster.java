package model.objects;

import javafx.scene.image.Image;
import model.abstracts.AbstractMovingObject;
import model.enums.GameObjectType;

public class Monster extends AbstractMovingObject {
    private Image image = new Image("/resources/monster.png");

    public Monster() {super.setType(GameObjectType.MONSTER);
    }

    @Override
    public Image getImage() {
        return image;
    }
}
