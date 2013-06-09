import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class GradeTest {
	Grade aCorrectGrade = null;

	@Before
	public void setUp() throws Exception {
		aCorrectGrade = new Grade("955002056", "許文馨", 88, 92, 88, 98, 91);
	}

	@After
	public void tearDown() throws Exception {
		aCorrectGrade = null;
	}
	
	/** ---------------------------------------------------------------------
	testCalculateTotalGrade 
	aGrade: ID 955002056 name 許文馨 lab1 88  lab2 92  lab3 88  midTerm 98 finalExam 91

	case 1: lab1 0.1  lab2 0.1  lab3 0.1  midTerm 0.3  finalExam 0.4

	-------------------------------------------------------------------------- */
	@Test
	public void testcalculateTotalGrade() {
		int[] weight = {10,10,10,30,40};
		aCorrectGrade.calculateTotalGrade(weight);
		assertSame(93, aCorrectGrade._total);	
	}

}
