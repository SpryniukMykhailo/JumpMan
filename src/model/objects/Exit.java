package model.objects;

import javafx.scene.image.Image;
import model.abstracts.AbstractGameObject;
import model.enums.GameObjectType;



/**
 * Created by SpryniukPC on 06.04.17.
 */
public class Exit extends AbstractGameObject {
    private Image image = new Image("/resources/exit.png");

    public Exit() {super.setType(GameObjectType.EXIT);}



    @Override
    public Image getImage() {
        return image;
    }
}
