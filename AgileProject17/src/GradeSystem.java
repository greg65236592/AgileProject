import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class GradeSystem {
	public int[] weights ={10, 10, 10, 30, 40};
	public ArrayList<Grade> aList;
	
	/** ---------------------------------------------------------------------
	1. 開檔 input file 
    2. 用Java LinkedList建構an empty list of grades叫 aList
    3. read token
    4. while not endOfFile
       1.call Grade() 建構aGrade
       2.用 Java Scanner 來 scan line 把data存入aGrade
       3. aGrade.calculateTotalGrade(weights)
       4. 把 aGrade 存入 aList
       5. if endOfLine then read line end if
    end while
	-------------------------------------------------------------------------- */
	GradeSystem()
	{
		Scanner scanner = null;
		try
		{
			scanner = new Scanner(new FileReader("gradeList.txt"));
			aList = new ArrayList<Grade>();
			Grade aGrade;
			while(scanner.hasNextLine())
			{
				aGrade = new Grade(scanner.next(), 
			                       scanner.next(),
			                       scanner.nextInt(),
			                       scanner.nextInt(),
			                       scanner.nextInt(),
			                       scanner.nextInt(),
			                       scanner.nextInt());
				aGrade.calculateTotalGrade(weights);				
				aList.add(aGrade);
			}			
		}catch(IOException e)
		{
			;
		}
		finally
		{
			if(scanner != null)
				scanner.close();
		}
	}
	
    /* method  showGrade  ----------------------------------------------                                                                                                    
	* 在螢幕秀出ID的每一項分數和權重算完的總成績
	*
	* @param ID 指定的ID
	* @return
	* @throws 
	*
	* Time estimate : 
	* Example:當被呼叫時在螢幕秀出ID的每一項分數和權重算完的總成績
	-------------------------------------------------------------------------*/
	/** ---------------------------------------------------------------------
	-------------------------------------------------------------------------- */
	public void showGrade(String ID)
	{
		for(Grade aGrade : aList)
		{
			if(aGrade._ID.equals(ID))
			{
				System.out.println(aGrade._name + "成績:\r\n" +
		    		               "lab1:" + aGrade._lab1 + "\r\n" +
		    		               "lab2:" + aGrade._lab2 + "\r\n" +
		    		               "lab3:" + aGrade._lab3 + "\r\n" +
		    		               "mid-term:" + aGrade._mid + "\r\n" +
		    		               "final exam:" + aGrade._final + "\r\n" +
		    		               "total grade:" + aGrade._total);
			}
		}
	}
	
	/* method  showRank  ----------------------------------------------                                                                                                    
	* 在螢幕秀出ID的排名
	*
	* @param ID 指定的ID
	* @return
	* @throws 
	*
	* Time estimate : 
	* Example:當被呼叫時在螢幕秀出ID的排名
	-------------------------------------------------------------------------*/
	/** ---------------------------------------------------------------------
	1. 取得這 ID 的 totalGrade
    2. 令rank 為 1 
    3. loop aGrade in aList if aTotalGrade > theTotalGrade then increment rank end loop
    4. print rank
	-------------------------------------------------------------------------- */
	public void showRank(String ID)
	{
		for(Grade aGrade : aList)
		{
			if(aGrade._ID.equals(ID))
			{
				int totalGrade = aGrade._total;
				int rank = 1;
				
				for(Grade theGrade : aList)
					if(theGrade._total > totalGrade)
						rank++;
				
				System.out.println(aGrade._name + "排名第" + rank);
			}
		}		
	}
	
	/* method  showRank  ----------------------------------------------                                                                                                    
	* 
	*
	* @param 
	* @return
	* @throws
	*
	* Time estimate : 
	* Example:螢幕顯示舊配分比例，
	*         在螢幕輸入新配分比例，
	*         顯示確認新配分比例。 
	-------------------------------------------------------------------------*/
	/** ---------------------------------------------------------------------
	1. showOldWeights() 
    2. getNewWeights() 
    3. showConfirmNewWeights()
    4. setWeights(weights)
    5. loop aGrade in aList to calculateTotalGrade(weights) end loop
	-------------------------------------------------------------------------- */
	public void updateWeight()
	{
		System.out.println("舊配分\r\n" +
	                       "lab1:" + weights[0] + "%\r\n" +
				           "lab2:" + weights[1] + "%\r\n" +
	                       "lab3:" + weights[2] + "%\r\n" +
				           "mid-term:" + weights[3] + "%\r\n" +
	                       "final exam:" + weights[4] + "%");	
		System.out.println("輸入新配分");
		int[] temp;
		temp = new int[5];
		Scanner scanner = new Scanner(System.in);
		for(int i = 0; i < 3; i++)
		{
			System.out.print("lab" + (i + 1) + ":");
			temp[i] = scanner.nextInt();
			System.out.println(temp[i]);
		}
		
		System.out.print("mid-term:");
		temp[3] = scanner.nextInt();
		System.out.println(temp[3]);
		
		System.out.print("final exam:");
		temp[4] = scanner.nextInt();
		System.out.println(temp[4]);
		
		System.out.print("請確認新配分\r\n" +
		                 "lab1:" + temp[0] + "%\r\n" +
				         "lab2:" + temp[1] + "%\r\n" +
		                 "lab3:" + temp[2] + "%\r\n" +
				         "mid-term:" + temp[3] + "%\r\n" +
		                 "final exam:" + temp[4] + "%\r\n" +
		                 "以上正確嗎?Y(Yes)或 N(No)\r\n" +
		                 "使用者輸入：");
		
		String choose = scanner.next();
		System.out.println(choose);
		
		if(choose.equals("Y"))
		{
			if((temp[0] + temp[1] + temp[2] + temp[3] + temp[4]) == 100)
			{
				weights = temp;
			
				for(Grade aGrade : aList)
					aGrade.calculateTotalGrade(weights);
			}
			else
				System.out.println("總配分%數超過100，請重新檢查配分比例");
		}
		else if(choose.equals("N"))
			;
		else
			;
	}
	
		public void Modify(String ID)
	{
		showGrade(ID);
		Grade thisGrade = null;
		for (Grade aGrade : aList)
		{
			if (aGrade._ID.equals(ID))
			{
				thisGrade = aGrade;
			}
		}

		Scanner scanner = new Scanner(System.in);
		String choose;
		
		// lab1
		System.out.printf("更改%sLab1分數? (yes/no)\n", thisGrade._name);
		choose = scanner.next();
		if (choose.equals("yes"))
		{
			System.out.printf("輸入%sLab1新分數\n", thisGrade._name);
			int tmp = scanner.nextInt();
			thisGrade._lab1 = tmp;
			System.out.printf("%s新分數Lab1%d改好了\n", thisGrade._name, thisGrade._lab1);
		}
		
		// lab2
		System.out.printf("更改%sLab2分數? (yes/no)\n", thisGrade._name);
		choose = scanner.next();
		if (choose.equals("yes"))
		{
			System.out.printf("輸入%sLab2新分數\n", thisGrade._name);
			int tmp = scanner.nextInt();
			thisGrade._lab2 = tmp;
			System.out.printf("%s新分數Lab2%d改好了\n", thisGrade._name, thisGrade._lab2);
		}

		//lab3
		System.out.printf("更改%sLab3分數? (yes/no)\n", thisGrade._name);
		choose = scanner.next();
		if (choose.equals("yes"))
		{
			System.out.printf("輸入%sLab3新分數\n", thisGrade._name);
			int tmp = scanner.nextInt();
			thisGrade._lab3 = tmp;
			System.out.printf("%s新分數Lab3%d改好了\n", thisGrade._name, thisGrade._lab3);
		}
		
		//Mid-term
		System.out.printf("更改%sMid-term分數? (yes/no)\n", thisGrade._name);
		choose = scanner.next();
		if (choose.equals("y"))
		{
			System.out.printf("輸入%sMid-term新分數\n", thisGrade._name);
			int tmp = scanner.nextInt();
			thisGrade._mid = tmp;
			System.out.printf("%s新分數Mid-term%d改好了\n", thisGrade._name, thisGrade._mid);
		}
		
		//Final exam
		System.out.printf("更改%sFinal exam分數? (yes/no)\n", thisGrade._name);
		choose = scanner.next();
		if (choose.equals("y"))
		{
			System.out.printf("輸入%sFinal exam新分數\n", thisGrade._name);
			int tmp = scanner.nextInt();
			thisGrade._final = tmp;
			System.out.printf("%s新分數Final exam%d改好了\n", thisGrade._name, thisGrade._final);
		}
		
		thisGrade.calculateTotalGrade(weights);
	}
}
