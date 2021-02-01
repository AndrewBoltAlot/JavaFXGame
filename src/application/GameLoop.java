package application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.JOptionPane;

import javafx.animation.AnimationTimer;
import javafx.scene.Parent;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
/**
 * @author Andrew Bolt
 *<p>GameLoop class hold logic for the game and animations</p>
 */
public class GameLoop {
	private final GridPane pane;
    private double t =0;
    private Player player;
    private Player player2;
    public boolean running;

    public GameLoop(final GridPane pane, Player player, Player player2) {
    	this.pane = pane;
    	this.player = player;
    	this.player2 = player2;

    	running = true;

    }
    /**
     * Method creates 5 sprite rectangles, based on given parameters
     * @param Player s, used to create Player sprites of type "enemy"
	 */
	    protected void nextLevel() {
	    			for (int i = 0; i < 5; i++) {
	    				Player s = new Player(90 + i*100, 150, 30, 30, "enemy", Color.RED);

	    				pane.getChildren().add(s);
	    			}
	    }
    	/**
    	 * @return List of Player sprites
    	 */
	    private List<Player> sprites() {
	        return pane.getChildren().stream().map(n -> (Player)n).collect(Collectors.toList());
	    }
    	/**
    	 * The primary game loop that creates the bullets logic
    	 * Such as what occurs when it intersects with another sprite
    	 * @param Integer t, represents speed of movement
    	 */
	    protected void update() {
	        t += 0.016;
	        sprites().forEach(s -> {
	            switch (s.type) {

	                case "enemybullet":
	                    s.moveDown();

	                    if (s.getBoundsInParent().intersects(player.getBoundsInParent())) {
	                        player.dead = true;
	                        s.dead = true;
	                    }
	                    if (s.getBoundsInParent().intersects(player2.getBoundsInParent())){
	                    	player2.dead = true;
	                    	s.dead = true;
	                    }
	                    break;

	                case "playerbullet":
	                    s.moveUp();

	                    sprites().stream().filter(e -> e.type.equals("enemy")).forEach(enemy -> {
	                        if (s.getBoundsInParent().intersects(enemy.getBoundsInParent())) {
	                            enemy.dead = true;
	                            s.dead = true;
	                        }
	                    });

	                    break;

	                case "player2bullet":
	                    s.moveUp();

	                    sprites().stream().filter(e -> e.type.equals("enemy")).forEach(enemy -> {
	                        if (s.getBoundsInParent().intersects(enemy.getBoundsInParent())) {
	                            enemy.dead = true;
	                            s.dead = true;
	                        }
	                    });

	                    break;
	                case "enemy":
	                    if (t > 2) {
	                        if (Math.random() < 0.3) {
	                            shoot(s);
	                        }
	                    }

	                    break;
	            }

	        });

	        pane.getChildren().removeIf(n -> {
	            Player s = (Player) n;
	            return s.dead;
	        });

	        if (t > 2) {
	            t = 0;
	        }
	        running = true;
	    }


    	/**
    	 * Creates bullet sprites, by making it an instance of Player
    	 */
	    protected void shoot(Player who) {
	        Player s = new Player((int) who.getTranslateX() + 20, (int) who.getTranslateY(), 5, 20, who.type + "bullet", Color.BLACK);

	        pane.getChildren().add(s);
	    }
}
