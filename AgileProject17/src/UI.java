import java.util.Scanner;

public class UI {
	public GradeSystem aGradeSystem;
	public String ID;
	public String name;
	
	/** ---------------------------------------------------------------------
	try 
    1.call GradeSystem() to�غc aGradeSystem
    
    2.loop1 until Q (Quit)
      1.promptID() to get user ID  ��JID�� Q (�����ϥ�)�H 
      2.checkID() to see if the ID is in aGradeSystem
      3.showWelcomeMsg()      ex. Welcome���§�
      4.loop2 until E (Exit)
        promptCommand() to prompt for inputCommand 
      end loop2
    end loop1

    3.showFinishMsg()�����F
    end try
	-------------------------------------------------------------------------- */
	public UI() throws NoSuchIDExceptions, NoSuchCommandExceptions
	{
		aGradeSystem = new GradeSystem();
		
		String IDorQ = "";
		while(!IDorQ.equals("Q"))
		{
			IDorQ = promptID();
			if(IDorQ.equals("Q"))
				break;
			
			if(checkID(IDorQ))
			{
				ID = IDorQ;
				
				showWelcomeMsg();
				
				while(!promptCommand().equals("E"))
					;
			}
		}
		
		showFinishMsg();
	}
	
	/* method  promptID  ----------------------------------------------                                                                                                    
	* ���_�ˬd��J�r��O�_�OQ�A�Y���O�h���עҡA�Y�߫h���}
	*
	* @param 
	* @return ID �Ω�P�O�O�_Q
	* @throws 
	*
	* Time estimate : �t��k�]�p��A�~�򦹸�T�A�p O (n)
	* Example: 1.�Y�ù���J�߫h�{������
	*          2.�Y�ù���J���~ID�A�h��X�@NoSuchIDExceptions
	*          3.�Y�ù���J���TID�A�h�i�J���t�ξާ@����
	-------------------------------------------------------------------------*/
	/** ---------------------------------------------------------------------
	-------------------------------------------------------------------------- */
	public String promptID()
	{
		System.out.print("�ù���ܡG��JID�� Q(�����ϥ�)�H");
		
		Scanner scanner = new Scanner(System.in);
		String IDorQ = scanner.next();
		System.out.println(IDorQ);
		
		return IDorQ;
	}

	/* method  promptCommand  ----------------------------------------------                                                                                                    
	* ���_�ˬd��J�r��O�_�OG�BR�BW�BE�䤤���@�A�Y���O�h��X�ҥ~���p�A�Y�O�䤤���@�h�̦r�����۹����ʧ@
	*           G ��ܦ��Z (Grade) 
    *           R ��ܱƦW (Rank) 
    *           W��s�t��  (Weight) 
    *           E ���}��� (Exit) 
	*
	* @param 
	* @return command �Ω�P�O�O�_E
	* @throws NoSuchCommandExceptions �V 
	*			if  ���O�OG�BR�BW�BE�䤤���@ �h��X�ҥ~���p
	*
	* Time estimate : �t��k�]�p��A�~�򦹸�T�A�p O (n)
	* Example:1.�ù���J���OG�BR�BW�BE�䤤���@�h��X�ҥ~���p
	*         2.�ù���J�OG�BR�BW�BE�䤤���@�h�ݨ�ĪG
	-------------------------------------------------------------------------*/
	/** ---------------------------------------------------------------------
	try
	1. prompt user for inputCommand
	2. if inputCommand is not G (Grade),R (Rank), W (Weights), or E (Exit),
       throws NoSuchCommandException
    3. if inputCommand is E (Exit) then do nothing
       else: G aGradeSystem.showGrade(), R showRank(), W updateWeights() end if
    end of try
	-------------------------------------------------------------------------- */
	public String promptCommand() throws NoSuchCommandExceptions
	{
		System.out.print("��J���O\r\n" +
	                     "1)G��ܦ��Z(Grade)\r\n" +
				         "2)R��ܱƦW(Rank)\r\n" + 
	                     "3)W��s�t��(Weight)\r\n" +
				         "4)E���}��� (Exit)\r\n" +
	                     "��J���O�p�W\r\n" +
				         "�ϥΪ̿�J�G");
		
		Scanner scanner = new Scanner(System.in);
		String command = scanner.next();
		System.out.println(command);	
		
		if(!(command.equals("G") ||
			 command.equals("R") ||
			 command.equals("W") ||
			 command.equals("E")))
					 throw new NoSuchCommandExceptions();
		else if(command.equals("G"))
			aGradeSystem.showGrade(ID);
		else if(command.equals("R"))
			aGradeSystem.showRank(ID);
		else if(command.equals("W"))
			aGradeSystem.updateWeight();
		else if(command.equals("E"))
			;
		
		return command;
	}
	
	/* method  checkID  ----------------------------------------------                                                                                                    
	* �ˬdID�O�_�X�{�bID�C��
	*
	* @param ID �n�Q�ˬd��ID
	* @return result �Y��ID�s�b�h�^��true�A�Y���s�b�hfalse�C
	* @throws NoSuchIDExceptions
	*         �Y���s�b��ID�h��X���ҥ~���p
	*
	* Time estimate : �t��k�]�p��A�~�򦹸�T�A�p O (n)
	* Example:1.ID���s�b�h��X�ҥ~���p
	*         2.ID�s�b�h�~�����{��
	-------------------------------------------------------------------------*/
	/** ---------------------------------------------------------------------
	 try 
     1.	check if the ID is in aGradeSystem
     2.	if not, throw an object of NoSuchIDExceptions
     3.	return true
     end of try
	-------------------------------------------------------------------------- */
	public boolean checkID(String ID) throws NoSuchIDExceptions 
	{
		boolean isInList = false;
		for(Grade aGrade : aGradeSystem.aList)
		{
			if(aGrade._ID.equals(ID))
			{
				isInList = true;
				name = aGrade._name;
			}
		}
		
		if(!isInList)
			throw new NoSuchIDExceptions();
		
		return true;
	}
	
	/* method  showWelcomeMsg  ----------------------------------------------                                                                                                    
	* �ھ�ID�ù����"Welcome �Y�Y�Y"
	*
	* @param 
	* @return 
	* @throws 
	*
	* Time estimate : �t��k�]�p��A�~�򦹸�T�A�p O (n)
	* Example:���禡�Q�I�s�A�N�|�b�ù��ݨ�"Welcome �Y�Y�Y"
	-------------------------------------------------------------------------*/
	public void showWelcomeMsg()
	{
		System.out.println("Welcome " + name);
	}
	
	/* method  showFinishMsg  ----------------------------------------------                                                                                                    
	* �ù����"�����F"
	*
	* @param 
	* @return 
	* @throws 
	*
	* Time estimate : �t��k�]�p��A�~�򦹸�T�A�p O (n)
	* Example:���禡�Q�I�s�A�N�|�b�ù��ݨ�"�����F"
	-------------------------------------------------------------------------*/
	public void showFinishMsg()
	{
		System.out.println("�����F");
	}
}
