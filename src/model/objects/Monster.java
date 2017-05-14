package model.objects;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.abstracts.AbstractMovingObject;
import model.enums.GameObjectType;

public class Monster extends AbstractMovingObject {
    public Monster(int x, int y) {
        super.setType(GameObjectType.MONSTER);
        setPosition(x, y);
        image = new Image("/resources/monster.png");
        label.setGraphic(new ImageView(image));
    }
    public Monster() {this(0, 0);}

}
