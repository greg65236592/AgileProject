import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class GradeSystem {
	public int[] weights ={10, 10, 10, 30, 40};
	public ArrayList<Grade> aList;
	
	/** ---------------------------------------------------------------------
	1. �}�� input file 
    2. ��Java LinkedList�غcan empty list of grades�s aList
    3. read token
    4. while not endOfFile
       1.call Grade() �غcaGrade
       2.�� Java Scanner �� scan line ��data�s�JaGrade
       3. aGrade.calculateTotalGrade(weights)
       4. �� aGrade �s�J aList
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
	* �b�ù��q�XID���C�@�����ƩM�v���⧹���`���Z
	*
	* @param ID ���w��ID
	* @return
	* @throws 
	*
	* Time estimate : 
	* Example:��Q�I�s�ɦb�ù��q�XID���C�@�����ƩM�v���⧹���`���Z
	-------------------------------------------------------------------------*/
	/** ---------------------------------------------------------------------
	-------------------------------------------------------------------------- */
	public void showGrade(String ID)
	{
		for(Grade aGrade : aList)
		{
			if(aGrade._ID.equals(ID))
			{
				System.out.println(aGrade._name + "���Z:\r\n" +
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
	* �b�ù��q�XID���ƦW
	*
	* @param ID ���w��ID
	* @return
	* @throws 
	*
	* Time estimate : 
	* Example:��Q�I�s�ɦb�ù��q�XID���ƦW
	-------------------------------------------------------------------------*/
	/** ---------------------------------------------------------------------
	1. ���o�o ID �� totalGrade
    2. �Orank �� 1 
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
				
				System.out.println(aGrade._name + "�ƦW��" + rank);
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
	* Example:�ù�����°t����ҡA
	*         �b�ù���J�s�t����ҡA
	*         ��ܽT�{�s�t����ҡC 
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
		System.out.println("�°t��\r\n" +
	                       "lab1:" + weights[0] + "%\r\n" +
				           "lab2:" + weights[1] + "%\r\n" +
	                       "lab3:" + weights[2] + "%\r\n" +
				           "mid-term:" + weights[3] + "%\r\n" +
	                       "final exam:" + weights[4] + "%");	
		System.out.println("��J�s�t��");
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
		
		System.out.print("�нT�{�s�t��\r\n" +
		                 "lab1:" + temp[0] + "%\r\n" +
				         "lab2:" + temp[1] + "%\r\n" +
		                 "lab3:" + temp[2] + "%\r\n" +
				         "mid-term:" + temp[3] + "%\r\n" +
		                 "final exam:" + temp[4] + "%\r\n" +
		                 "�H�W���T��?Y(Yes)�� N(No)\r\n" +
		                 "�ϥΪ̿�J�G");
		
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
				System.out.println("�`�t��%�ƶW�L100�A�Э��s�ˬd�t�����");
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
		System.out.printf("���%sLab1����? (yes/no)\n", thisGrade._name);
		choose = scanner.next();
		if (choose.equals("yes"))
		{
			System.out.printf("��J%sLab1�s����\n", thisGrade._name);
			int tmp = scanner.nextInt();
			thisGrade._lab1 = tmp;
			System.out.printf("%s�s����Lab1%d��n�F\n", thisGrade._name, thisGrade._lab1);
		}
		
		// lab2
		System.out.printf("���%sLab2����? (yes/no)\n", thisGrade._name);
		choose = scanner.next();
		if (choose.equals("yes"))
		{
			System.out.printf("��J%sLab2�s����\n", thisGrade._name);
			int tmp = scanner.nextInt();
			thisGrade._lab2 = tmp;
			System.out.printf("%s�s����Lab2%d��n�F\n", thisGrade._name, thisGrade._lab2);
		}

		//lab3
		System.out.printf("���%sLab3����? (yes/no)\n", thisGrade._name);
		choose = scanner.next();
		if (choose.equals("yes"))
		{
			System.out.printf("��J%sLab3�s����\n", thisGrade._name);
			int tmp = scanner.nextInt();
			thisGrade._lab3 = tmp;
			System.out.printf("%s�s����Lab3%d��n�F\n", thisGrade._name, thisGrade._lab3);
		}
		
		//Mid-term
		System.out.printf("���%sMid-term����? (yes/no)\n", thisGrade._name);
		choose = scanner.next();
		if (choose.equals("y"))
		{
			System.out.printf("��J%sMid-term�s����\n", thisGrade._name);
			int tmp = scanner.nextInt();
			thisGrade._mid = tmp;
			System.out.printf("%s�s����Mid-term%d��n�F\n", thisGrade._name, thisGrade._mid);
		}
		
		//Final exam
		System.out.printf("���%sFinal exam����? (yes/no)\n", thisGrade._name);
		choose = scanner.next();
		if (choose.equals("y"))
		{
			System.out.printf("��J%sFinal exam�s����\n", thisGrade._name);
			int tmp = scanner.nextInt();
			thisGrade._final = tmp;
			System.out.printf("%s�s����Final exam%d��n�F\n", thisGrade._name, thisGrade._final);
		}
		
		thisGrade.calculateTotalGrade(weights);
	}
}
