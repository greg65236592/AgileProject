import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Test;

public class TestUI
{

	@Test
	//Test the correctness of UI()
	//This test case is for testing the UI() process correctness
	//input: ID 966002031
	//output: Welcome ���ػ�
	//��J���O	1) G ��ܦ��Z (Grade)
	//	2) R ��ܱƦW (Rank)
	//	3) W ��s�t�� (Weight)
	//	4) E ���}��� (Exit) 
	public void testUI(){
		String expect = "��JID�� Q (�����ϥ�)�H\n"+
				"Welcome ���ػ�\n"+
				"��J���O\t1) G ��ܦ��Z (Grade)\n"+
				"\t2) R ��ܱƦW (Rank)\n"+
				"\t3) W ��s�t�� (Weight)\n"+
				"\t4) E ���}��� (Exit)\n";
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setIn(new ByteArrayInputStream("966002031".getBytes()));
		System.setOut(new PrintStream(outContent));
		UI testUI = null;
		try {
			testUI = new UI();
		} catch (Exception e) {
			//Exclude the Exception
		}
		assertEquals(expect, outContent.toString());
	}
	
	@Test
	//Test the correctness of output of showWelcomeMsg() 1
    //testGrade = 975002021 ���R�� 81 97 90 82 84
	//expected output = "Welcome ���R��\n"
	public void testShowWelcomeMsg1(){
		String expect = "Welcome ���R��\n";
		System.setIn(new ByteArrayInputStream("Q".getBytes()));
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		UI testUI = null;
		try {
			testUI = new UI();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Grades tsetGrade = new Grades("975002021", "���R��", 81, 97, 90, 82 ,84);
		System.setOut(new PrintStream(outContent));
		testUI.showWelcomeMsg(tsetGrade);
		assertEquals(outContent.toString(), expect);	
	}
	
	@Test
	//Test the correctness of output of showWelcomeMsg() 2
    //testGrade = null
	//expected output = "Welcome ���R��\n"
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
    //testInput = "A"
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
	
	@Test
	//Test the correctness of output of promptCommand() 2
    //testInput = "E"
	//expected show :
	//  "��J���O\t1) G ��ܦ��Z (Grade)\n"+
	//	"\t2) R ��ܱƦW (Rank)\n"+
	//	"\t3) W ��s�t�� (Weight)\n"+
	//	"\t4) E ���}��� (Exit) \n"
	public void testPromptCommand2(){
		String expect = "��J���O\t1) G ��ܦ��Z (Grade)\n"+
				"\t2) R ��ܱƦW (Rank)\n"+
				"\t3) W ��s�t�� (Weight)\n"+
				"\t4) E ���}��� (Exit)\n";
		System.setIn(new ByteArrayInputStream("Q".getBytes()));
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		UI testUI = null;
		try {
			testUI = new UI();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.setOut(new PrintStream(outContent));
		System.setIn(new ByteArrayInputStream("E".getBytes()));
		try {
			testUI.promptCommand();
		} catch (NoSuchCommandExceptions e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(expect, outContent.toString());	
	}
	
	//promptID
	@Test
	//Test Case 1�GinContent�G "955002056" expected output�G"955002056"
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
	//Test Case 2�GinContent�G "12345" expected output�G"12345"
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
	//Test Case 1�Ginput�G 955002056 expected output�Gtrue
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
	//Test Case 2�Ginput�G962001044 expected output�Gtrue
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
	//Test Case 1�Ginput�G null expected output�Gprint "�����F"
	public void testshowFinishMsg() throws Exception
	{
		String expected = "�����F";

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
