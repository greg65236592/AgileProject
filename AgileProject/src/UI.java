import java.util.Scanner;


public class UI {
	
	public UI()
		/*
		 * try 
		 * 1.call GradeSystems() to建構 aGradeSystem
		 * 
		 * 2.loop1 until Q (Quit)
		 * 1.	promptID() to get user ID  輸入ID或 Q (結束使用)？ 
		 * 2.	checkID() to see if the ID is in aGradeSystem
		 * 3.	showWelcomeMsg()      ex. Welcome李威廷
		 * 4.	loop2 until E (Exit)
		 * promptCommand() to prompt for input command 
		 *    end loop2
		 * end loop1
		 * 
		 * 3.showFinishMsg()           結束了
		 * end try
		 * finally { } // do nothing
		 * 
		 */
	{
		try{
			GradeSystems aGradeSystem = new GradeSystems();
			
			String inputLoop1 = null;
			do{
				inputLoop1 = promptID();
				checkID();
				showWelcomeMsg();

				inputLoop2 = promptCommand();
				
				showFinishMsg();
				
			}while(inputLoop1 != "Q");
		}
		finally { } // do nothing
		
		
	}
	
	public void promptCommand () throws NoSuchCommandExceptions
	/*
	 * try
	 * 1. prompt user for inputCommand
	 * 2. if inputCommand is not G (Grade),R (Rank), W (Weights), or E (Exit),
	 *  throws NoSuchCommandException
	 * 3. if inputCommand is E (Exit) then break
	 *  else: G aGradeSystem.showGrade(), R showRank(), W updateWeights() end if
	 * end of try
	 * finally {} // do nothing
	 */
	{


		
	}

}
