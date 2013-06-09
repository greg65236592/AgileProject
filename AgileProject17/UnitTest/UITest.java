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

	case 1: ���TID 955002056
	case 2: Q Q

	-------------------------------------------------------------------------- */
	@Test
	public void testpromptID()
	{
		//case 1
		System.setIn(new ByteArrayInputStream("955002056".getBytes()));
		String result = aUI.promptID();
		assertEquals("�ù���ܡG��JID�� Q(�����ϥ�)�H955002056\r\n", outContent.toString());
		outContent.reset();
		assertEquals("955002056", result);
		
		//case 2
		System.setIn(new ByteArrayInputStream("Q".getBytes()));
		result = aUI.promptID();
		assertEquals("�ù���ܡG��JID�� Q(�����ϥ�)�HQ\r\n", outContent.toString());
		outContent.reset();
		assertEquals("Q", result);
	}
	
	/** ---------------------------------------------------------------------
	testNoSuchCommand 
	aUI:

	case 1: ���O H

	-------------------------------------------------------------------------- */
	@Test(expected = NoSuchCommandExceptions.class)
	public void testNoSuchCommand() throws NoSuchCommandExceptions
	{
		System.setIn(new ByteArrayInputStream("H".getBytes()));
		aUI.promptCommand();
		assertEquals("��J���O\r\n" +
				     "1)G��ܦ��Z(Grade)\r\n" +
				     "2)R��ܱƦW(Rank)\r\n" +
				     "3)W��s�t��(Weight)\r\n" +
				     "4)E���}��� (Exit)\r\n" +
				     "��J���O�p�W\r\n" +
				     "�ϥΪ̿�J�GH\r\n" +
				     "���OH���F!", outContent.toString());
		outContent.reset();
	}
	
	/** ---------------------------------------------------------------------
	testCorrectCommand 
	aUI:

	case 1: ���O G, ID 955002056

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
		assertEquals("�����F\r\n", outContent.toString());
		outContent.reset();
	}
}
