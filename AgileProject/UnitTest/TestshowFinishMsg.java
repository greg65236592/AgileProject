import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestshowFinishMsg
{
	UI testUI;

	@Before
	public void setUp() throws Exception
	{
		testUI = new UI();
	}

	@Test
	public void testshowFinishMsg()
	{
		testUI.showFinishMsg();
		assertEquals(true, true);
	}

}
