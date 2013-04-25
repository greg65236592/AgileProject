import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

public class TestGradeSystems
{

	@Test
	public void testGradeSystems()
	{
		GradeSystems testGradeSystem = new GradeSystems();
		//		assertsEquals();
	}

	//showRank
	@Test
	//Test Case 1�Ginput�G 955002056 expected output�G9
	public void testshowRank1()
	{
		String input = "955002056";
		int expected = 9;
		int result;

		GradeSystems testGradeSystems = new GradeSystems();
		result = testGradeSystems.showRank(input);

		assertEquals(expected, result);
	}

	@Test
	//Test Case 2�Ginput�G 986002026 expected output�G32
	public void testshowRank2()
	{
		String input = "986002026";
		int expected = 32;
		int result;

		GradeSystems testGradeSystems = new GradeSystems();
		result = testGradeSystems.showRank(input);

		assertEquals(expected, result);
	}

	@Test
	//Test Case 3�Ginput�G 975002070 expected output�G1
	public void testshowRank3()
	{
		String input = "975002070";
		int expected = 1;
		int result;

		GradeSystems testGradeSystems = new GradeSystems();
		result = testGradeSystems.showRank(input);

		assertEquals(expected, result);
	}

	//updateWeights
	@Test
	//Test Case �Ginput�G null  expected output�Gnull
	public void testupdateWeights()
	{

		String inContent = "20\r\n20\r\n20\r\n20\r\n20\r\nY\r\n";
		String expected = String.format("�°t��\n\tlab1\t\t10%%\n\tlab2\t\t10%%\n\tlab3\t\t10%%\n\tmid-term\t30%%\n\tfinal exam\t40%%\n��J�s�t��\n\tlab1\t\t\tlab2\t\t\tlab3\t\t\tmid-term\t\tfinal exam\t�нT�{�s�t��\n\tlab1\t\t%d%%\n\tlab2\t\t%d%%\n\tlab3\t\t%d%%\n\tmid-term\t%d%%\n\tfinal exam\t%d%%\n", 20, 20, 20, 20, 20);
		String result;

		System.setIn(new ByteArrayInputStream(inContent.getBytes()));
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		GradeSystems testGradeSystems = new GradeSystems();
		testGradeSystems.updateWeights();

		System.setOut(new PrintStream(outContent));
		result = outContent.toString();
		assertEquals(expected, result);
	}
}
