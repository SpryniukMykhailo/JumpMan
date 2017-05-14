package model.objects;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.abstracts.AbstractGameObject;
import model.enums.GameObjectType;



/**
 * Created by SpryniukPC on 06.04.17.
 */
public class Exit extends AbstractGameObject {

    public Exit() {
        super.setType(GameObjectType.EXIT);
        image = new Image("/resources/exit.png");
        label.setGraphic(new ImageView(image));
    }
}