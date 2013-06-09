import static org.junit.Assert.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class UITest {
	UI aUI = null;
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	@Before
	public void setUp() throws Exception{
		System.setIn(new ByteArrayInputStream("Q".getBytes()));
		
		System.setOut(new PrintStream(outContent));
		
		aUI = new UI();	
		
		outContent.reset();
	}

	@After
	public void tearDown() throws Exception {
		aUI = null;
		System.setOut(null);
	}

	/** ---------------------------------------------------------------------
	testpromptID 
	aUI:

	case 1: 正確ID 955002056
	case 2: Q Q

	-------------------------------------------------------------------------- */
	@Test
	public void testpromptID()
	{
		//case 1
		System.setIn(new ByteArrayInputStream("955002056".getBytes()));
		String result = aUI.promptID();
		assertEquals("螢幕顯示：輸入ID或 Q(結束使用)？955002056\r\n", outContent.toString());
		outContent.reset();
		assertEquals("955002056", result);
		
		//case 2
		System.setIn(new ByteArrayInputStream("Q".getBytes()));
		result = aUI.promptID();
		assertEquals("螢幕顯示：輸入ID或 Q(結束使用)？Q\r\n", outContent.toString());
		outContent.reset();
		assertEquals("Q", result);
	}
	
	/** ---------------------------------------------------------------------
	testNoSuchCommand 
	aUI:

	case 1: 指令 H

	-------------------------------------------------------------------------- */
	@Test(expected = NoSuchCommandExceptions.class)
	public void testNoSuchCommand() throws NoSuchCommandExceptions
	{
		System.setIn(new ByteArrayInputStream("H".getBytes()));
		aUI.promptCommand();
		assertEquals("輸入指令\r\n" +
				     "1)G顯示成績(Grade)\r\n" +
				     "2)R顯示排名(Rank)\r\n" +
				     "3)W更新配分(Weight)\r\n" +
				     "4)E離開選單 (Exit)\r\n" +
				     "輸入指令如上\r\n" +
				     "使用者輸入：H\r\n" +
				     "指令H錯了!", outContent.toString());
		outContent.reset();
	}
	
	/** ---------------------------------------------------------------------
	testCorrectCommand 
	aUI:

	case 1: 指令 G, ID 955002056

	-------------------------------------------------------------------------- */
	@Test
	public void testCorrectCommand() throws NoSuchCommandExceptions
	{
		aUI.ID = "955002056";
		aUI.aGradeSystem = new GradeSystem();
		
		System.setIn(new ByteArrayInputStream("G".getBytes()));
		String result = aUI.promptCommand();
		assertEquals("G", result);
		outContent.reset();
	}
	
	/** ---------------------------------------------------------------------
	testCheckInvalidID 
	aUI:

	case 1: ID -100

	-------------------------------------------------------------------------- */
	@Test(expected = NoSuchIDExceptions.class)
	public void testCheckInvalidID() throws NoSuchIDExceptions
	{
		aUI.aGradeSystem = new GradeSystem();		
		
		aUI.checkID("-100");
	}
	
	/** ---------------------------------------------------------------------
	testCheckInvalidID 
	aUI:

	case 1: ID 955002056

	-------------------------------------------------------------------------- */
	@Test
	public void testCheckValidID() throws NoSuchIDExceptions
	{
		aUI.aGradeSystem = new GradeSystem();
		
		boolean validResult = aUI.checkID("955002056");
		assertSame(true, validResult);		
	}
	
	/** ---------------------------------------------------------------------
	testshowWelcomeMsg 
	aUI:

	case 1: name yaya

	-------------------------------------------------------------------------- */
	@Test
	public void testshowWelcomeMsg()
	{
		aUI.name = "yaya";
		aUI.showWelcomeMsg();
		assertEquals("Welcome yaya\r\n", outContent.toString());
		outContent.reset();
	}
	
	/** ---------------------------------------------------------------------
	testshowFinishMsg 
	aUI:

	case 1:

	-------------------------------------------------------------------------- */
	@Test
	public void testshowFinishMsg()
	{
		aUI.showFinishMsg();
		assertEquals("結束了\r\n", outContent.toString());
		outContent.reset();
	}
}
