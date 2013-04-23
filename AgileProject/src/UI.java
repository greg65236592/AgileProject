import java.util.Scanner;

public class UI
{
	GradeSystems aGradeSystem;

	//	public UI()
	/*
	 * try 
	 * 1.call GradeSystems() to�غc aGradeSystem
	 * 
	 * 2.loop1 until Q (Quit)
	 * 1.	promptID() to get user ID  ��JID�� Q (�����ϥ�)�H 
	 * 2.	checkID() to see if the ID is in aGradeSystem
	 * 3.	showWelcomeMsg()      ex. Welcome���§�
	 * 4.	loop2 until E (Exit)
	 * promptCommand() to prompt for input command 
	 *    end loop2
	 * end loop1
	 * 
	 * 3.showFinishMsg()           �����F
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
				checkID(inputLoop1);
				showWelcomeMsg();

				inputLoop2 = promptCommand();

				showFinishMsg();

			} while (inputLoop1 != "Q");
		}
		finally
		{
		} // do nothing
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

	}

	public String promptID()
	/*
	 * 1.print ��JID�� Q (�����ϥ�)�H
	 * 2.�^�ǨϥΪ̿�JString
	 */
	{
		System.out.println("��JID�� Q (�����ϥ�)�H");
		Scanner input = new Scanner(System.in);
		String input_string = input.nextLine();
		return input_string;
	}

	public Boolean checkID(String ID) throws NoSuchIDExceptions
	/*
	checkID (ID) throws NoSuchIDExceptions return Boolean
	parameter: ID   a user ID  ex: 123456789
	time:     O(n)  n is  aGradeSystem �����Z�H��
	
	try 
		1.check if the ID is in aGradeSystem
		2.if not, throw an object of NoSuchIDExceptions
		3.return true
	end of try
	finally{} // do nothing
	 */
	{
		Boolean check = false;
		if (aGradeSystem.getGrades(ID) != null)
		{
			check = true;
		}
		return check;
	}

	public void showFinishMsg()
	/*
	 * 1.print �����F
	 */
	{
		System.out.println("�����F");
	}

}
