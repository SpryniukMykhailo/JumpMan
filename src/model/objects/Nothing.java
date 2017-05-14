package model.objects;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.abstracts.AbstractGameObject;
import model.enums.GameObjectType;

import javax.swing.*;

/**
 * Created by SpryniukPC on 06.04.17.
 */
public class Nothing extends AbstractGameObject {

    public Nothing() {
        super.setType(GameObjectType.NOTHING);
        image = new Image("/resources/background.png");
        label.setGraphic(new ImageView(image));
    }

}
