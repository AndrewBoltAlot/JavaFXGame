package application;

import javafx.animation.AnimationTimer;
import javafx.animation.ParallelTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.List;
import java.util.stream.Collectors;
//https://www.youtube.com/watch?v=FVo1fm52hz0

/**
 *
 * @author Andrew Bolt
 *<p>Main class is what holds the application framework, that is filled with content from the ContentCreator class.</p>
 */
public class Main extends Application {
	private ContentCreator cc = new ContentCreator();

    @Override
    public void start(Stage stage) throws Exception {
        Scene scene = new Scene(cc.createInitial());
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}