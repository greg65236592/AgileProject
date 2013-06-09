import java.util.Scanner;

public class UI {
	public GradeSystem aGradeSystem;
	public String ID;
	public String name;
	
	/** ---------------------------------------------------------------------
	try 
    1.call GradeSystem() to建構 aGradeSystem
    
    2.loop1 until Q (Quit)
      1.promptID() to get user ID  輸入ID或 Q (結束使用)？ 
      2.checkID() to see if the ID is in aGradeSystem
      3.showWelcomeMsg()      ex. Welcome李威廷
      4.loop2 until E (Exit)
        promptCommand() to prompt for inputCommand 
      end loop2
    end loop1

    3.showFinishMsg()結束了
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
	* 不斷檢查輸入字串是否是Q，若不是則當成ＩＤ，若Ｑ則離開
	*
	* @param 
	* @return ID 用於判別是否Q
	* @throws 
	*
	* Time estimate : 演算法設計後，才獲此資訊，如 O (n)
	* Example: 1.若螢幕輸入Ｑ則程式結束
	*          2.若螢幕輸入錯誤ID，則丟出　NoSuchIDExceptions
	*          3.若螢幕輸入正確ID，則進入本系統操作頁面
	-------------------------------------------------------------------------*/
	/** ---------------------------------------------------------------------
	-------------------------------------------------------------------------- */
	public String promptID()
	{
		System.out.print("螢幕顯示：輸入ID或 Q(結束使用)？");
		
		Scanner scanner = new Scanner(System.in);
		String IDorQ = scanner.next();
		System.out.println(IDorQ);
		
		return IDorQ;
	}

	/* method  promptCommand  ----------------------------------------------                                                                                                    
	* 不斷檢查輸入字串是否是G、R、W、E其中之一，若不是則丟出例外狀況，若是其中之一則依字母做相對應動作
	*           G 顯示成績 (Grade) 
    *           R 顯示排名 (Rank) 
    *           W更新配分  (Weight) 
    *           E 離開選單 (Exit) 
	*
	* @param 
	* @return command 用於判別是否E
	* @throws NoSuchCommandExceptions – 
	*			if  不是是G、R、W、E其中之一 則丟出例外狀況
	*
	* Time estimate : 演算法設計後，才獲此資訊，如 O (n)
	* Example:1.螢幕輸入不是G、R、W、E其中之一則丟出例外狀況
	*         2.螢幕輸入是G、R、W、E其中之一則看到效果
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
		System.out.print("輸入指令\r\n" +
	                     "1)G顯示成績(Grade)\r\n" +
				         "2)R顯示排名(Rank)\r\n" + 
	                     "3)W更新配分(Weight)\r\n" +
				         "4)E離開選單 (Exit)\r\n" +
	                     "輸入指令如上\r\n" +
				         "使用者輸入：");
		
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
	* 檢查ID是否出現在ID列表中
	*
	* @param ID 要被檢查的ID
	* @return result 若此ID存在則回傳true，若不存在則false。
	* @throws NoSuchIDExceptions
	*         若不存在此ID則丟出此例外狀況
	*
	* Time estimate : 演算法設計後，才獲此資訊，如 O (n)
	* Example:1.ID不存在則丟出例外狀況
	*         2.ID存在則繼續執行程式
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
	* 根據ID螢幕顯示"Welcome 某某某"
	*
	* @param 
	* @return 
	* @throws 
	*
	* Time estimate : 演算法設計後，才獲此資訊，如 O (n)
	* Example:當此函式被呼叫你將會在螢幕看到"Welcome 某某某"
	-------------------------------------------------------------------------*/
	public void showWelcomeMsg()
	{
		System.out.println("Welcome " + name);
	}
	
	/* method  showFinishMsg  ----------------------------------------------                                                                                                    
	* 螢幕顯示"結束了"
	*
	* @param 
	* @return 
	* @throws 
	*
	* Time estimate : 演算法設計後，才獲此資訊，如 O (n)
	* Example:當此函式被呼叫你將會在螢幕看到"結束了"
	-------------------------------------------------------------------------*/
	public void showFinishMsg()
	{
		System.out.println("結束了");
	}
}
