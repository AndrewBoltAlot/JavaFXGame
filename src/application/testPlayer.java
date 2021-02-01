package application;

import org.junit.Assert;
import org.junit.Test;

import javafx.scene.paint.Color;

public class testPlayer {

	@Test
	public void testPlayertype(){
		Player p = new Player(150, 750, 40, 40, "player", Color.BLUE);
		Assert.assertEquals(p.type = "player", p.type);
	}
	@Test
	public void testMoveLeft() {
		Player p = new Player(150, 750, 40, 40, "player", Color.BLUE);
		p.moveLeft();
		Assert.assertEquals(145, p.getTranslateX(), 140);
	}
	@Test
	public void testMoveRight() {
		Player p = new Player(150, 750, 40, 40, "player", Color.BLUE);
		p.moveRight();
		Assert.assertEquals(155, p.getX(), 160);
	}
	@Test
	public void testMoveDown() {
		Player p = new Player(150, 750, 40, 40, "player", Color.BLUE);
		p.moveDown();
		Assert.assertEquals(745, p.getTranslateY(), 740);
	}
	@Test
	public void testMoveUP() {
		Player p = new Player(150, 750, 40, 40, "player", Color.BLUE);
		p.moveUp();
		Assert.assertEquals(755, p.getY(), 760);
	}

}
