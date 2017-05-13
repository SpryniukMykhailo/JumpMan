package model.objects;

import javafx.scene.image.Image;
import model.abstracts.AbstractMovingObject;
import model.enums.GameObjectType;


public class MainCharacter extends AbstractMovingObject {
    public MainCharacter() {this(0,0);}
    public MainCharacter(int x, int y) {
        setPosition(x, y);
        super.setType(GameObjectType.MAINCHARACTER);
        image = new Image("/resources/mc.png");
    }
}
