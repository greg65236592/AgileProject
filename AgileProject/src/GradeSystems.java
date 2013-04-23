/***************************************************************************
class GradeSystems�x�s a list of student grades.
 
GradeSystems () //�غc�l
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

	GradeSystems()// �غc�l
	{
		//create LinkedList 
		aList = new LinkedList<Grades>();

		//input file
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

	public int showGrade(String ID)
	/*
	 * show �o ID �� grade
	 */
	{
		int totalGrade = 0;
		Grades aGrades = null;

		for (int i = 0; i < aList.size(); i++)
		{
			if (aList.get(i).getId().equals(ID))
			{
				aGrades = aList.get(i);
			}
		}

		totalGrade = aGrades.getTotalGrade();
		return totalGrade;
	}

	public int showRank(String ID)
	/*
	 * 1. ���o�o ID �� theTotalGrade
	 * 2. �Orank �� 1
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
			return rank;
		}
		return 0;
	}

	public void updateWeights()
	/*
	 * 1. ��ܥثeweights
	 * 2. ��J�s��weights
	 * 3. �Y�ϥΪ̽T�w,�h���]weights�P�������Z����
	 */
	{
		showOldWeights();

		int[] newweights = getNewWeights();

		System.out.printf("�H�W���T��? Y (Yes) �� N (No)\n");
		Scanner input = new Scanner(System.in);
		String answer = input.nextLine();

		if (answer.equals("Y") || answer.equals("y") || answer.equals("Yes") || answer.equals("yes") || answer.equals("YES"))
		{
			setWeights(newweights);
			updataAllTotalGrade();
		}
	}

	private void showOldWeights()
	/*
	 * 1.��ܥثe weights
	 */
	{
		System.out.printf("�°t��\n");
		System.out.printf("\tlab1\t\t%.0f%%\n", weights[0] * 100);
		System.out.printf("\tlab2\t\t%.0f%%\n", weights[1] * 100);
		System.out.printf("\tlab3\t\t%.0f%%\n", weights[2] * 100);
		System.out.printf("\tmid-term\t%.0f%%\n", weights[3] * 100);
		System.out.printf("\tfinal exam\t%.0f%%\n", weights[4] * 100);
	}

	private int[] getNewWeights()
	/*
	 * 1.�]�w�s��Weights,�Ȧs��tempweights�æ^��
	 */
	{
		int[] tempweights = new int[5];

		Scanner input = new Scanner(System.in);
		System.out.printf("��J�s�t��\n");

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

		System.out.printf("�нT�{�s�t��\n");
		System.out.printf("\tlab1\t\t%d%%\n", tempweights[0]);
		System.out.printf("\tlab2\t\t%d%%\n", tempweights[1]);
		System.out.printf("\tlab3\t\t%d%%\n", tempweights[2]);
		System.out.printf("\tmid-term\t%d%%\n", tempweights[3]);
		System.out.printf("\tfinal exam\t%d%%\n", tempweights[4]);

		return tempweights;
	}

	private void setWeights(int[] newweights)
	/*
	 * 1.�ˬd�s��weights���M�O�_����1.0
	 * 2.�Y����A�hset ��weights
	 * 3.�_�h�����ʧ@
	 */
	{
		if (newweights[0] + newweights[1] + newweights[2] + newweights[3] + newweights[4] != 100)
		{
			System.out.printf("��Jweights�L��\nweights���M������1.0\n");
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
	 * 1.���s�p������ǥ�TotalGrade
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
