package model.abstracts;


public class AbstractMovingObject extends AbstractGameObject {
    private int x;
    private int y;

    public AbstractMovingObject() { x = 0; y = 0;}
    public AbstractMovingObject(int x, int y) {setPosition(x,y);}

    public void setPosition(int x, int y) {
        this.x = x; this.y = y;
    }

    public int getX() {return x;}
    public int getY() {return y;}
}
