package application;
import org.junit.Assert;
import org.junit.Test;

import javafx.scene.layout.GridPane;

public class testGameLoop {
	GridPane pane;
	Player player;
	Player player2;
	@Test
	public void testUpdate(){
		GameLoop l = new GameLoop(pane,player,player2);
		Assert.assertEquals(true , l.running);
	}

}
