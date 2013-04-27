import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

public class TestUI
{

	
	@Test
	//Test the correctness of output of showWelcomeMsg() 1
    //testGrade = 975002021 法窻藉 81 97 90 82 84
	//expected output = "Welcome 法窻藉\n"
	public void testShowWelcomeMsg1(){
		String expect = "Welcome 法窻藉\n";
		System.setIn(new ByteArrayInputStream("Q".getBytes()));
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		UI testUI = null;
		try {
			testUI = new UI();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Grades tsetGrade = new Grades("975002021", "法窻藉", 81, 97, 90, 82 ,84);
		System.setOut(new PrintStream(outContent));
		testUI.showWelcomeMsg(tsetGrade);
		assertEquals(outContent.toString(), expect);	
	}
	
	@Test
	//Test the correctness of output of showWelcomeMsg() 2
    //testGrade = null
	//expected output = "Welcome 法窻藉\n"
	public void testShowWelcomeMsg2(){
		String expect = "Grades is null!\r\n";
		System.setIn(new ByteArrayInputStream("Q".getBytes()));
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		UI testUI = null;
		try {
			testUI = new UI();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Grades tsetGrade = null;
		System.setOut(new PrintStream(outContent));
		testUI.showWelcomeMsg(tsetGrade);
		assertEquals(outContent.toString(), expect);	
	}
	
	@Test
	//Test the correctness of output of testPromptCommand1() 1
    //testInput = ""
	//expected throw an NoSuchCommandExceptions
	public void testPromptCommand1(){
		boolean isExceptionOccur = false;
		System.setIn(new ByteArrayInputStream("Q".getBytes()));
		UI testUI = null;
		try {
			testUI = new UI();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.setIn(new ByteArrayInputStream("A".getBytes()));
		try {
			testUI.promptCommand();
		} catch (NoSuchCommandExceptions e) {
			isExceptionOccur = true;
		}
		assertTrue(isExceptionOccur);	
	}
	
	//promptID
	@Test
	//Test Case 1inContent "955002056" expected output"955002056"
	public void testpromptID1() throws Exception
	{
		String inContent = "955002056";
		String expected = "955002056";
		String result;

		String initContent = "Q";
		System.setIn(new ByteArrayInputStream(initContent.getBytes()));
		UI testUI = new UI();
		
		System.setIn(new ByteArrayInputStream(inContent.getBytes()));

		result = testUI.promptID();

		assertEquals(expected, result);
	}

	@Test
	//Test Case 2inContent "12345" expected output"12345"
	public void testpromptID2() throws Exception
	{
		String inContent = "12345";
		String expected = "12345";
		String result;
		
		String initContent = "Q";
		System.setIn(new ByteArrayInputStream(initContent.getBytes()));
		UI testUI = new UI();

		System.setIn(new ByteArrayInputStream(inContent.getBytes()));

		result = testUI.promptID();

		assertEquals(expected, result);
	}
	
	
	//checkID
	@Test
	//Test Case 1input 955002056 expected outputtrue
	public void testcheckID1() throws Exception
	{
		String input = "955002056";
		Boolean expected = true;
		Boolean result;
		
		String initContent = "Q";
		System.setIn(new ByteArrayInputStream(initContent.getBytes()));
		UI testUI = new UI();
		
		result = testUI.checkID(input);

		assertEquals(expected, result);
	}

	@Test
	//Test Case 2input962001044 expected outputtrue
	public void testcheckID2() throws Exception
	{
		String input = "962001044";
		Boolean expected = true;
		Boolean result;

		String initContent = "Q";
		System.setIn(new ByteArrayInputStream(initContent.getBytes()));
		UI testUI = new UI();
		
		result = testUI.checkID(input);

		assertEquals(expected, result);
	}
	
	//showFinishMsg
	@Test
	//Test Case 1input null expected outputprint "挡"
	public void testshowFinishMsg() throws Exception
	{
		String expected = "挡";

		String initContent = "Q";
		System.setIn(new ByteArrayInputStream(initContent.getBytes()));
		UI testUI = new UI();
		
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));

		testUI.showFinishMsg();

		String[] result = outContent.toString().split("\r");
		assertEquals(expected, result[0]);
	}

}
