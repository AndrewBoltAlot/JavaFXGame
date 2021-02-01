package application;

import org.junit.Assert;
import org.junit.Test;

public class testScoreBoard {


	@Test
	public void testReadPointstoFile(){
		ScoreBoard s = new ScoreBoard();
		s.readPointsFile();
		Assert.assertEquals(true , s.closed);
	}
	@Test
	public void testSavePointstoFile(){
		ScoreBoard s = new ScoreBoard();
		s.addPoints(new Points("", 0));
		Assert.assertEquals(true , s.closed);
	}
}
