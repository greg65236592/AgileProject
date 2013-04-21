import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestpromptID
{
	UI testUI;

	@Before
	public void setUp() throws Exception
	{
		testUI = new UI();
	}

	@Test
	public void testpromptID()
	{
		testUI.promptID();
		assertEquals(true,true);
	}

}
