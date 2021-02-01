package application;

import java.util.ArrayList;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
/**
 *
 * @author Andrew Bolt
 *Used to host framework for the ScoreBoard stage, so that a scoreboard is generated when btnScoreBoard is clicked.
 */
public class ScoreBoardScene {
	private ContentCreator cc= new ContentCreator();
	public ScoreBoardScene(Stage stage){
		Scene scene = new Scene(cc.createScoreBoard());

		stage.setScene(scene);
		stage.show();
	}
}
