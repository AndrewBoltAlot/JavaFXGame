package application;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
/**
 * @author Andrew Bolt
 * <p>Class to create rectangle sprites, that will be used as players or enemies</p>
 *  <p>boolean dead, used to check if sprite exists or not, in ContentCreator.</p>
 */
public class Player extends Rectangle {
	public boolean dead = false;
    protected String type;
    private Points points;
    private String name = "Player";

    Player(int x, int y, int w, int h, String type, Color color) {
        super(w, h, color);

        points = new Points(name, 0);

        this.type = type;
        setTranslateX(x);
        setTranslateY(y);
    }
/**
 * Connects this method to the setName method in Points, so that the name can be changed on the scoreboard.
 */
    public void setName (String name) {
        this.name = name;
        points.setName(name);
    }

    public Points getPoints() {
        return points;
    }
	/**
	 * method to move player sprite Left, by finding their X coordinate and minusing by 5
	 */
    protected void moveLeft() {
        setTranslateX(getTranslateX() - 5);
    }
	/**
	 * method to move player sprite Right, by finding their X coordinate and plussing by 5
	 */
    protected void moveRight() {
        setTranslateX(getTranslateX() + 5);
    }
    /**
	 * method to move player sprite Up, by finding their Y coordinate and minusing by 5
	 */
    protected void moveUp() {
        setTranslateY(getTranslateY() - 5);
    }
	/**
	 * method to move player sprite Down, by finding their Y coordinate and plussing by 5
	 */
    protected void moveDown() {
        setTranslateY(getTranslateY() + 5);
    }
}
