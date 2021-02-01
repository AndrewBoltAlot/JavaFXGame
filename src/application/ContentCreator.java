package application;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
/**
 * @author Andrew
 * <p>This class holds the instances of the Player and Points classes and an instance of a GridPane
 * So as to hold the content and to create the initial, score board and create content scenes for the game.</p>
 */
public class ContentCreator {

	private GridPane root = new GridPane();
    private Button btnSubmit = new Button("Play Game");
    private Button btnScoreBoard = new Button("ScoreBoard");
    private Stage stage = new Stage();
    private TextField txtp1;
    private TextField txtp2;
    private Label lblP2 = new Label();
    private Label lblP1 = new Label();
    private String winner;
	private boolean pointsGiven = false;
	protected Player player = new Player(150, 750, 40, 40, "player", Color.BLUE);
	protected Player player2 = new Player(300, 750, 40, 40, "player", Color.GREEN);
	public GameLoop loop = new GameLoop(root, player, player2);

	/**
	 *This method is what holds the scene for the game.
	 *Creates an Animation timer that in puts the game logic, via the instance of the class GameLoop loop.
	 *Also fills the scene with enemy sprites, with the loop.nextLevel();
	 *@return root, with updates
	 */
	protected Parent createContent() {
    	root.setPrefSize(600, 800);
    	root.getChildren().add(player);
        root.getChildren().add(player2);

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
            	if((player.dead == true || player2.dead == true) && !pointsGiven){
            		  if(player.dead == true){
            		    winner = "Player 1";
            		    player2.getPoints().addPoints(100);
            		  } else {
            		    winner = "Player 2";
            		    player.getPoints().addPoints(100);
            		  }

            		  pointsGiven = true;
            		}

                if(player.dead == false || player2.dead == false){
            	loop.update();
                } else{
                	if (!ScoreBoard.getScores().contains(player.getPoints())) {
						ScoreBoard.addPoints(player.getPoints());
					}

					if (!ScoreBoard.getScores().contains(player2.getPoints())) {
						ScoreBoard.addPoints(player2.getPoints());
					}

					pointsGiven = false;
                	gameOverText();
                }
            }
        };
        timer.start();
        loop.nextLevel();
        return root;
    }
	/**
	 * <p>Creates the initial scene used to take user inputs and allow user to start game </p>
	 * @param HBox paneplayer1, holds player input text and prompt
	 * @param HBox paneplayer2, holds player input text and prompt
	 * @param Button btnSubmit, creates a new instance of the class NewScene using the GridPane root.
	 * @param Button btnAddName, generates a file called points.txt and adds user text inputs to the file
	 * @param Button btnScoreBoard, generate scoreboard display for user.
	 * @return root, with updates
	 */
	protected Parent createInitial(){
		ScoreBoard.readPointsFile();
		root.setPrefSize(600, 800);
		 // Create the Player 1 label
        Label lblPlayer1 = new Label("Player One's Name:");
        lblPlayer1.setMinWidth(100);
        lblPlayer1.setLayoutY(300);
        lblPlayer1.setAlignment(Pos.BOTTOM_RIGHT);
        // Create the PLayer 1 text field
        txtp1 = new TextField();
        txtp1.setMinWidth(200);
        txtp1.setMaxWidth(200);
        txtp1.setPromptText("Enter your name here.");
        // Create Player 2 label
        Label lblPlayer2 = new Label("Player Two's Name:");
        lblPlayer2.setMinWidth(100);
        lblPlayer2.setAlignment(Pos.TOP_RIGHT);
        // Create Player 2 text field
        txtp2 = new TextField();
        txtp2.setMinWidth(200);
        txtp2.setMaxWidth(200);
        txtp2.setPromptText("Enter your name here.");
     // Create the Player 1 pane
        HBox panePlayer1 = new HBox(20, lblPlayer1, txtp1);
        panePlayer1.setPadding(new Insets(10));
        // Create Player 2 pane
        HBox panePlayer2 = new HBox(20, lblPlayer2, txtp2);
        panePlayer2.setPadding(new Insets(10));

        Button btnAddName = new Button("Add Name");
        btnAddName.setOnAction(e-> {
        	player.setName(txtp1.getText());
        	player2.setName(txtp2.getText());
        	lblP1.setText("Player 1 is blue and called " + txtp1.getText());
        	lblP2.setText("Player 2 is green and called " + txtp2.getText());
        });

        btnSubmit.setOnAction(e-> {
        	NewScene newScene = new NewScene(stage);
        });

        HBox paneScoreBoard = new HBox(200);

        btnScoreBoard.setOnAction(e -> {
			ScoreBoardScene scoreBoard = new ScoreBoardScene(stage);
        });


        VBox pane = new VBox(10, panePlayer1, panePlayer2, btnAddName, btnSubmit, btnScoreBoard, lblP1, lblP2);
        root.getChildren().add(pane);

		return root;
	}
/**
 * Displays player scores and allwos user to play a new game
 * @param Text text, a Text which is used to display the players scores
 * @param Button btnPlayAgain, starts a new game
 *@return root, with updates
 */
	public Parent createScoreBoard(){
		Text text = new Text();
		text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 30));
		text.setFill(Color.BLUE);
		text.setStrokeWidth(3);
		text.setStroke(Color.TEAL);

		ArrayList<Points> scores = ScoreBoard.getScores();
		String scoreboard = "";

		for (int i = 0; i < scores.size(); i ++){
			scoreboard += scores.get(i).getName() + " " + scores.get(i).getPoints() + "\n";
		}

		text.setText(scoreboard);
		HBox score = new HBox(20, text);
		Button btnPlayAgain = new Button("Play Again");
		btnPlayAgain.setOnAction(e->{
			NewScene newScene = new NewScene(stage);
		});
		VBox paneScore = new VBox(10, score, btnPlayAgain);
		root.getChildren().add(paneScore);
		return root;
	}
	 /**
	  * Generates the game over text to be displayed and adds it to the GridPane root
	  */
	 private void gameOverText(){
	    	 Text text = new Text();
		      text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 50));
		      text.setX(180);
		      text.setY(300);
		      text.setFill(Color.RED);
		      text.setStrokeWidth(3);
		      text.setStroke(Color.CRIMSON);
		      text.setText(winner + " LOST");
		      root.getChildren().addAll(text);
	}



}
