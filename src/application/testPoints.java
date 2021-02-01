package application;

import org.junit.Assert;
import org.junit.Test;

public class testPoints {
	Points points = new Points("Player", 1);

	@Test
	public void testGetPoints(){
		Assert.assertEquals(1, points.getPoints());
	}
	@Test
	public void testAddPoint(){
		int expected = 3;
		int value = 2;
		points.addPoints(value);
		Assert.assertEquals(expected, points.getPoints());
	}

	@Test
	public void testResetPoints(){
		points.resetPoints();
		Assert.assertEquals(0, points.getPoints());
	}


}
