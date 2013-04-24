import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestGrades
{
	//weights[] = {0.1,0.1,0.1,0.3,0.4 };
	//Test Case 1：input： ("955002056","許文馨",88,92,88,98,91) expected output：93
	//Test Case 2：input： ("975002501","張廷瑄",80,86,98,94,87) expected output：89
	Grades testGrades1, testGrades2;
	float weights[] = { (float) 0.1, (float) 0.1, (float) 0.1, (float) 0.3, (float) 0.4 };

	@Before
	public void setUp() throws Exception
	{
		testGrades1 = new Grades("955002056", "許文馨", 88, 92, 88, 98, 91);
		testGrades2 = new Grades("975002501", "張廷瑄", 80, 86, 98, 94, 87);
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void testCalculateTotal1()
	{
		int expected = 93;
		int result;

		testGrades1.calculateTotalGrade(weights);
		result = testGrades1.getTotalGrade();
		assertEquals(expected, result);
	}

	@Test
	public void testCalculateTotal2()
	{
		int expected = 89;
		int result;

		testGrades2.calculateTotalGrade(weights);
		result = testGrades2.getTotalGrade();
		assertEquals(expected, result);
	}

}
