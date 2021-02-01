package application;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
/**
 *
 * @author Andrew
 *<p> Class is used to create the stage that holds the game and it's logic (so that instance of game is created on a button click).
 *Does this by inputting createContent() from Content Creator into the scene and by making a Key event handler which allows both players to move and shoot consecutively.
 */
public class NewScene {
	private ContentCreator cc = new ContentCreator();

	public NewScene(Stage stage){
		Scene scene = new Scene(cc.createContent());
		 EventHandler<KeyEvent> eventHandler = new EventHandler<KeyEvent>(){

	    		@Override
	    		public void handle(KeyEvent event) {
	    			switch(event.getCode()){
	    			 	case A:
	                        cc.player.moveLeft();
	                        break;
	                    case D:
	                        cc.player.moveRight();
	                        break;
	                    case W:
	                        cc.loop.shoot(cc.player);
	                        break;
	                    case LEFT:
	                    	cc.player2.moveLeft();
	                    	break;
	                    case RIGHT:
	                    	cc.player2.moveRight();
	                    	break;
	                    case UP:
	                    	cc.loop.shoot(cc.player2);
	    			}
	    		}
	        };
	    stage.addEventHandler(KeyEvent.KEY_PRESSED, eventHandler);
		stage.setScene(scene);
		stage.show();
	}
}
