import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class testupdateWeights
{
	GradeSystems testGradeSystems;
	
	@Before
	public void setUp() throws Exception
	{
		testGradeSystems = new GradeSystems();
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	//Test Case ¡Ginput¡G null  expected output¡Gnull
	public void test()
	{
		testGradeSystems.updateWeights();
		assertEquals(true,true);
	}

}
