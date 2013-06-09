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
	    assertEquals("�\���ɦ��Z:\r\n" +
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
	    assertEquals("�\���ɱƦW��9\r\n", outContent.toString());
	    outContent.reset();
	}
	
	/** ---------------------------------------------------------------------
	testupdateWeightSuccess
	aGradeSystem:

	case 1:���T�t�� 

	-------------------------------------------------------------------------- */
	@Test
	public void testupdateWeightSuccess() {
		System.setIn(new ByteArrayInputStream("20 20 20 20 20 Y".getBytes()));
		aGradeSystem.updateWeight();
	    assertEquals("�°t��\r\n" +
	    		     "lab1:10%\r\n" +
	    		     "lab2:10%\r\n" +
	    		     "lab3:10%\r\n" +
	    		     "mid-term:30%\r\n" +
	    		     "final exam:40%\r\n" +
	    		     "��J�s�t��\r\n" +
	    		     "lab1:20\r\n" +
	    		     "lab2:20\r\n" +
	    		     "lab3:20\r\n" +
	    		     "mid-term:20\r\n" +
	    		     "final exam:20\r\n" +
	    		     "�нT�{�s�t��\r\n" +
   		             "lab1:20%\r\n" +
   		             "lab2:20%\r\n" +
   		             "lab3:20%\r\n" +
   		             "mid-term:20%\r\n" +
   		             "final exam:20%\r\n" +
   		             "�H�W���T��?Y(Yes)�� N(No)\r\n" +
   		             "�ϥΪ̿�J�GY\r\n", outContent.toString());
	    outContent.reset();
	}
	
	/** ---------------------------------------------------------------------
	testupdateWeightError
	aGradeSystem:

	case 1:�����T�t�� 

	-------------------------------------------------------------------------- */
	@Test
	public void testupdateWeightError() {
		System.setIn(new ByteArrayInputStream("200 20 20 20 20 Y".getBytes()));
		aGradeSystem.updateWeight();
		assertEquals("�°t��\r\n" +
   		             "lab1:10%\r\n" +
				     "lab2:10%\r\n" +
   		             "lab3:10%\r\n" +
				     "mid-term:30%\r\n" +
   		             "final exam:40%\r\n" +
				     "��J�s�t��\r\n" +
   		             "lab1:200\r\n" +
				     "lab2:20\r\n" +
   		             "lab3:20\r\n" +
				     "mid-term:20\r\n" +
   		             "final exam:20\r\n" +
				     "�нT�{�s�t��\r\n" +
   		             "lab1:200%\r\n" +
				     "lab2:20%\r\n" +
   		             "lab3:20%\r\n" +
				     "mid-term:20%\r\n" +
   		             "final exam:20%\r\n" +
				     "�H�W���T��?Y(Yes)�� N(No)\r\n" +
   		             "�ϥΪ̿�J�GY\r\n" +
				     "�`�t��%�ƶW�L100�A�Э��s�ˬd�t�����\r\n", outContent.toString());
		outContent.reset();
	}
	
	/** ---------------------------------------------------------------------
	testmodify
	aGradeSystem:

	case 1:�����T�t�� 

	-------------------------------------------------------------------------- */
	@Test
	public void testModify() {
		System.setIn(new ByteArrayInputStream("no yes 90 no no no".getBytes()));
		aGradeSystem.modify("962001044");
		assertEquals("��v�ʦ��Z:\r\n" +
				"lab1:87\r\n" +
				"lab2:86\r\n" +
				"lab3:98\r\n" +
				"mid-term:88\r\n" +
				"final exam:87\r\n" +
				"total grade:88\r\n" +
				"����v��Lab1����? (yes/no)\n" +
				"����v��Lab2����? (yes/no)\n" +
				"��J��v��Lab2�s����\n" +
				"��v�ʷs����Lab2 90��n�F\n" +
				"����v��Lab3����? (yes/no)\n" +
				"����v��Mid-term����? (yes/no)\n" +
				"����v��Final exam����? (yes/no)\n", outContent.toString());
		outContent.reset();
	}
	
}
