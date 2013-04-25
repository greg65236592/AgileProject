/***************************************************************************
class GradeSystems儲存 a list of student grades.
 
GradeSystems () //建構子
showGrade(ID)
showRank(ID)
updateWeights ()
 *************************************************************************** */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class GradeSystems
{
	private float weights[] = { (float) 0.1, (float) 0.1, (float) 0.1, (float) 0.3, (float) 0.4 };
	private LinkedList<Grades> aList;

	GradeSystems() throws FileNotFoundException// 建構子
	/*
	 * public GradeSystems () //建構子
	 *
	 * 1. 開檔 input file 
	 * 2. 建構an empty list of grade using Java LinkedList 叫 aList
	 * 3. read a line
	 * 4. while not endOfFile
	 *   1.call Grades() 建構aGrade
	 *   2.use Java Scanner to scan the line and put the data into aGrade
	 *   3. aGrade.calculateTotalGrade(weights) and put aTotalGrade into aGrade
	 *   4. 把 aGrade 存入 list
	 *   5. if endOfLine then read next line end if
     * end while
     *
	 */
	{
		//create LinkedList 
		aList = new LinkedList<Grades>();

		//new File object
		File inputFile = new File("InputFile.txt");

		//Scan the file in
		Scanner fileScanner = null;
		try
		{
			fileScanner = new Scanner(inputFile);
		}
		catch (FileNotFoundException e)
		{
			System.out.println("No such file for scanning.");
			e.printStackTrace();
			throw e;
		}

		//create Grades and save them to aList
		do
		{
			String studentID = fileScanner.next();
			String studentName = fileScanner.next();
			if (studentName.length() == 1)
			{ //single name error handling
				String studentNameAppend = fileScanner.next();
				studentName += studentNameAppend;
			}
			int lab1 = Integer.valueOf(fileScanner.next());
			int lab2 = Integer.valueOf(fileScanner.next());
			int lab3 = Integer.valueOf(fileScanner.next());
			int midTerm = Integer.valueOf(fileScanner.next());
			int finalExam = Integer.valueOf(fileScanner.next());

			Grades grades = new Grades(studentID, studentName, lab1, lab2, lab3, midTerm, finalExam);

			fileScanner.nextLine();
			aList.add(grades);

		} while (fileScanner.hasNextLine());

		//Calculate totalGrade
		updataAllTotalGrade();
	}

	public void showGrade(String ID)
	/*
	 * show 這 ID 的 grade
	 */
	{
		if(ID == null){
			System.out.printf("找不到此ID");
		}
		else{
			//for each Grades in aList
			//	if aGrades.getId() == ID
			//		output grades
			for (Grades aGrades : aList)
			{
				if(aGrades.getId().equals(ID)){
					System.out.printf("\tlab1\t\t%d\n", aGrades.getLab1());
					System.out.printf("\tlab2\t\t%d\n", aGrades.getLab2());
					System.out.printf("\tlab3\t\t%d\n", aGrades.getLab3());
					System.out.printf("\tmid-term\t%d\n", aGrades.getMidTerm());
					System.out.printf("\tfinal exam\t%d\n", aGrades.getFinalExam());
					System.out.printf("\ttotal grade\t%d\n", aGrades.getTotalGrade());
				}
			}
		}
	}

	public int showRank(String ID)
	/*
	 * 1. 取得這 ID 的 theTotalGrade
	 * 2. 令rank 為 1
	 * 3. loop through the list, if aTotalGrade > theTotalGrade then increment rank end loop
	 * 4. return rank
	 */
	{
		int rank = 1;
		Grades aGrades = null;

		for (int i = 0; i < aList.size(); i++)
		{
			if (aList.get(i).getId().equals(ID))
			{
				aGrades = aList.get(i);
			}
		}

		if (aGrades != null)
		{
			int thisTotalGrade = aGrades.getTotalGrade();

			for (int i = 0; i < aList.size(); i++)
			{
				if (aList.get(i).getTotalGrade() > thisTotalGrade)
				{
					rank++;
				}
			}
			System.out.printf("%s排名第%d名\n", aGrades.getName(), rank);
			return rank;
		}
		System.out.println("找不到此ID");
		return 0;
	}

	public void updateWeights()
	/*
	 * 1. 顯示目前weights
	 * 2. 輸入新的weights
	 * 3. 若使用者確定,則重設weights與全部成績重算
	 */
	{
		showOldWeights();
		Scanner input = new Scanner(System.in);
		int[] newweights = getNewWeights(input);

		System.out.printf("以上正確嗎? Y (Yes) 或 N (No)\n");
		String answer = input.next();

		if (answer.equals("Y") || answer.equals("y") || answer.equals("Yes") || answer.equals("yes") || answer.equals("YES"))
		{
			setWeights(newweights);
			updataAllTotalGrade();
		}
		else {
			System.out.println("指令錯誤");
		}
	}

	private void showOldWeights()
	/*
	 * 1.顯示目前 weights
	 */
	{
		System.out.printf("舊配分\n");
		System.out.printf("\tlab1\t\t%.0f%%\n", weights[0] * 100);
		System.out.printf("\tlab2\t\t%.0f%%\n", weights[1] * 100);
		System.out.printf("\tlab3\t\t%.0f%%\n", weights[2] * 100);
		System.out.printf("\tmid-term\t%.0f%%\n", weights[3] * 100);
		System.out.printf("\tfinal exam\t%.0f%%\n", weights[4] * 100);
	}

	private int[] getNewWeights(Scanner input)
	/*
	 * 1.設定新的Weights,暫存至tempweights並回傳
	 */
	{
		int[] tempweights = new int[5];
		
		System.out.printf("輸入新配分\n");

		System.out.printf("\tlab1\t\t");
		tempweights[0] = input.nextInt();

		System.out.printf("\tlab2\t\t");
		tempweights[1] = input.nextInt();

		System.out.printf("\tlab3\t\t");
		tempweights[2] = input.nextInt();

		System.out.printf("\tmid-term\t");
		tempweights[3] = input.nextInt();

		System.out.printf("\tfinal exam\t");
		tempweights[4] = input.nextInt();

		System.out.printf("請確認新配分\n");
		System.out.printf("\tlab1\t\t%d%%\n", tempweights[0]);
		System.out.printf("\tlab2\t\t%d%%\n", tempweights[1]);
		System.out.printf("\tlab3\t\t%d%%\n", tempweights[2]);
		System.out.printf("\tmid-term\t%d%%\n", tempweights[3]);
		System.out.printf("\tfinal exam\t%d%%\n", tempweights[4]);

		return tempweights;
	}

	private void setWeights(int[] newweights)
	/*
	 * 1.檢查新的weights之和是否等於1.0
	 * 2.若等於，則set 成weights
	 * 3.否則不做動作
	 */
	{
		if (newweights[0] + newweights[1] + newweights[2] + newweights[3] + newweights[4] != 100)
		{
			System.out.printf("輸入weights無效\nweights之和須等於1.0\n");
		}
		else
		{
			for (int i = 0; i < weights.length; i++)
			{
				weights[i] = (float) (((float) newweights[i]) / 100.0);
			}
		}

	}

	private void updataAllTotalGrade()
	/*
	 * 1.重新計算全部學生TotalGrade
	 */
	{
		for (int i = 0; i < aList.size(); i++)
		{
			aList.get(i).calculateTotalGrade(weights);
		}
	}

	public LinkedList<Grades> getaList()
	{
		return aList;
	}
}
