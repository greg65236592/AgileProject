import java.util.LinkedList;
import java.util.Scanner;

public class UI
{
	private GradeSystems aGradeSystem;
	private Grades aGrads;

	public UI() throws Exception
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
		try
		{
			aGradeSystem = new GradeSystems();

			String inputLoop1 = null;
			do
			{
				inputLoop1 = promptID();

				if (inputLoop1.equals("Q"))
				{
					break;
				}
				checkID(inputLoop1);

				showWelcomeMsg();

				promptCommand();

			} while (true);

			showFinishMsg();
		}

		finally
		{
		} // do nothing
	}

	private void showWelcomeMsg()
	/*show the welcome message*/
	{
		System.out.printf("Welcome %s\n", aGrads.getName());
	}

	public void promptCommand() throws NoSuchCommandExceptions
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
		try
		{
			do
			{
				System.out.printf("輸入指令\t1) G 顯示成績 (Grade)\n");
				System.out.printf("\t2) R 顯示排名 (Rank)\n");
				System.out.printf("\t3) W 更新配分 (Weight)\n");
				System.out.printf("\t4) E 離開選單 (Exit) \n");

				Scanner input = new Scanner(System.in);
				String inputCommand = input.nextLine();

				if (!inputCommand.equals("G") && !inputCommand.equals("R") && !inputCommand.equals("W") && !inputCommand.equals("E"))
				{
					throw new NoSuchCommandExceptions(inputCommand);
				}

				else if (inputCommand.equals("E"))
				{
					break;
				}

				else if (inputCommand.equals("G"))
				{
					aGradeSystem.showGrade(aGrads.getId());
				}

				else if (inputCommand.equals("R"))
				{
					aGradeSystem.showRank(aGrads.getId());
				}

				else if (inputCommand.equals("W"))
				{
					aGradeSystem.updateWeights();
				}
			} while (true);
		}
		finally
		{
		} // do nothing

	}

	public String promptID()
	/*
	 * 1.print 輸入ID或 Q (結束使用)？
	 * 2.回傳使用者輸入String
	 */
	{
		System.out.println("輸入ID或 Q (結束使用)？");
		Scanner input = new Scanner(System.in);
		String input_string = input.nextLine();
		return input_string;
	}

	public Boolean checkID(String ID) throws NoSuchIDExceptions
	/*
	checkID (ID) throws NoSuchIDExceptions return Boolean
	parameter: ID   a user ID  ex: 123456789
	time:     O(n)  n is  aGradeSystem 內全班人數
	
	try 
		1.check if the ID is in aGradeSystem
		2.if not, throw an object of NoSuchIDExceptions
		3.return true
	end of try
	finally{} // do nothing
	 */
	{
		Boolean check = false;

		try
		{
			LinkedList<Grades> aList = aGradeSystem.getaList();
			for (int i = 0; i < aList.size(); i++)
			{
				if (aList.get(i).getId().equals(ID))
				{
					aGrads = aList.get(i);
					check = true;
				}
			}
			if (check == false)
			{
				throw new NoSuchIDExceptions(ID);
			}
			return check;
		}
		finally
		{
		} // do nothing
	}

	public void showFinishMsg()
	/*
	 * 1.print 結束了
	 */
	{
		System.out.println("結束了");
	}

}
