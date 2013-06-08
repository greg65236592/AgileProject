import static org.junit.Assert.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class GradeSystemTest {
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	GradeSystem aGradeSystem = null;

	@Before
	public void setUp() throws Exception {
		System.setOut(new PrintStream(outContent));
		aGradeSystem = new GradeSystem();
	}

	@After
	public void tearDown() throws Exception {
		System.setOut(null);
		aGradeSystem = null;
	}

	/** ---------------------------------------------------------------------
	testshowGrade 
	aGradeSystem:

	case 1: ID 955002056

	-------------------------------------------------------------------------- */
	@Test
	public void testshowGrade() {
		aGradeSystem.showGrade("955002056");
	    assertEquals("許文馨成績:\r\n" +
	    		     "lab1:88\r\n" +
	    		     "lab2:92\r\n" +
	    		     "lab3:88\r\n" +
	    		     "mid-term:98\r\n" +
	    		     "final exam:91\r\n" +
	    		     "total grade:93\r\n", outContent.toString());
	    outContent.reset();
	}
	
	/** ---------------------------------------------------------------------
	testshowRank 
	aGradeSystem:

	case 1: ID 955002056

	-------------------------------------------------------------------------- */
	@Test
	public void testshowRank() {
		aGradeSystem.showRank("955002056");
	    assertEquals("許文馨排名第9\r\n", outContent.toString());
	    outContent.reset();
	}
	
	/** ---------------------------------------------------------------------
	testupdateWeightSuccess
	aGradeSystem:

	case 1:正確配分 

	-------------------------------------------------------------------------- */
	@Test
	public void testupdateWeightSuccess() {
		System.setIn(new ByteArrayInputStream("20 20 20 20 20 Y".getBytes()));
		aGradeSystem.updateWeight();
	    assertEquals("舊配分\r\n" +
	    		     "lab1:10%\r\n" +
	    		     "lab2:10%\r\n" +
	    		     "lab3:10%\r\n" +
	    		     "mid-term:30%\r\n" +
	    		     "final exam:40%\r\n" +
	    		     "輸入新配分\r\n" +
	    		     "lab1:20\r\n" +
	    		     "lab2:20\r\n" +
	    		     "lab3:20\r\n" +
	    		     "mid-term:20\r\n" +
	    		     "final exam:20\r\n" +
	    		     "請確認新配分\r\n" +
   		             "lab1:20%\r\n" +
   		             "lab2:20%\r\n" +
   		             "lab3:20%\r\n" +
   		             "mid-term:20%\r\n" +
   		             "final exam:20%\r\n" +
   		             "以上正確嗎?Y(Yes)或 N(No)\r\n" +
   		             "使用者輸入：Y\r\n", outContent.toString());
	    outContent.reset();
	}
	
	/** ---------------------------------------------------------------------
	testupdateWeightError
	aGradeSystem:

	case 1:不正確配分 

	-------------------------------------------------------------------------- */
	@Test
	public void testupdateWeightError() {
		System.setIn(new ByteArrayInputStream("200 20 20 20 20 Y".getBytes()));
		aGradeSystem.updateWeight();
		assertEquals("舊配分\r\n" +
   		             "lab1:10%\r\n" +
				     "lab2:10%\r\n" +
   		             "lab3:10%\r\n" +
				     "mid-term:30%\r\n" +
   		             "final exam:40%\r\n" +
				     "輸入新配分\r\n" +
   		             "lab1:200\r\n" +
				     "lab2:20\r\n" +
   		             "lab3:20\r\n" +
				     "mid-term:20\r\n" +
   		             "final exam:20\r\n" +
				     "請確認新配分\r\n" +
   		             "lab1:200%\r\n" +
				     "lab2:20%\r\n" +
   		             "lab3:20%\r\n" +
				     "mid-term:20%\r\n" +
   		             "final exam:20%\r\n" +
				     "以上正確嗎?Y(Yes)或 N(No)\r\n" +
   		             "使用者輸入：Y\r\n" +
				     "總配分%數超過100，請重新檢查配分比例\r\n", outContent.toString());
		outContent.reset();
	}
}
