package model.objects;

import javafx.scene.image.Image;
import model.abstracts.AbstractGameObject;
import model.enums.GameObjectType;

import javax.swing.*;

/**
 * Created by SpryniukPC on 06.04.17.
 */
public class Nothing extends AbstractGameObject {
    private Image image = new Image("/resources/background.png");

    public Nothing() {super.setType(GameObjectType.NOTHING);}

    @Override
    public Image getImage() {
        return image;
    }
}
