import static org.testng.Assert.assertThrows;
import static org.testng.Assert.assertTrue;

import java.util.stream.IntStream;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GameTest {
	Game bowling;

	@BeforeMethod
	public void beforeMethod() {
		bowling = new Game();
	}

	@Test
	public void test() {
		Assert.assertEquals(true, true);
	}

	@Test
	public void rollScoreOf4() throws Exception {
		bowling.roll(4);
		Assert.assertEquals(4, bowling.score());
	}

	@Test
	public void rollsTwentyScoresOf4() {
		int expected_score = 80;
		IntStream.range(0, 20).forEach(i -> {
			try {
				bowling.roll(4);
			} catch (Exception e) {
			}
		});
		Assert.assertEquals(expected_score, bowling.score());
	}
	
	@Test
	public void invalidScore() {
		assertThrows(RuntimeException.class, () -> bowling.roll(11));
	}
	@Test
	public void rollStrike() {
		bowling.roll(10);
		assertTrue(bowling.strike);
	}
	@Test
	public void strikeFollowedByOne() {
		bowling.roll(10);
		bowling.roll(1);
		Assert.assertEquals(bowling.score(), 12);
	}
	@Test
	public void strikeFollowedByOneFollowedByTwo() {
		bowling.roll(10);
		bowling.roll(1);
		bowling.roll(2);
		Assert.assertEquals(bowling.score(), 16);
	}
	@Test
	public void strikeFollowedByOneFollowedByTwoFollowedByOne() {
		bowling.roll(10);
		bowling.roll(1);
		bowling.roll(2);
		bowling.roll(1);
		Assert.assertEquals(bowling.score(), 17);
	}
	@Test
	public void strikeOneTwoOneStrikeOne() {
		bowling.roll(10);
		bowling.roll(1);
		bowling.roll(2);
		bowling.roll(1);
		
		bowling.roll(10);
		bowling.roll(1);
		Assert.assertEquals(bowling.score(), 29);
	}
	@Test
	public void spare() {
		bowling.roll(3);
		bowling.roll(7);
		bowling.roll(2);
		Assert.assertEquals(bowling.score(), 14);
	}
	
}
