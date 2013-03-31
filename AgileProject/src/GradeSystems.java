/** *************************************************************************
class GradeSystems�x�s a list of student grades.
 
GradeSystems () //�غc�l
showGrade(ID)
showRank(ID)
updateWeights ()
*************************************************************************** */

import java.util.ArrayList;
import java.util.Scanner;


public class GradeSystems
{
	float[] weights = new float[5];
	private ArrayList<Grades> aList = new ArrayList<Grades>();

	GradeSystems()// �غc�l
	{
	}

	private Grades getGrades(String ID)
	/*
	 * ���o�o ID �� Grades
	 */
	{
		Grades aGrades = null;

		for (int i = 0; i < aList.size(); i++)
		{
			if (aList.get(i).getId().equals(ID))
			{
				aGrades = aList.get(i);
			}
		}

		return aGrades;
	}

	public void showGrade(String ID)
	{
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
		Grades aGrades = getGrades(ID);

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
	 * 2. ��J����weights
	 * 3. �Y�ϥΪ̽T�w,�h���]weights�P�������Z����
	 */
	{
		showOldWeights();

		int[] newweights = getNewWeights();

		System.out.printf("�H�W���T��? Y (Yes) �� N (No)\n");
		Scanner input = new Scanner(System.in);
		String answer = input.nextLine();

		if (answer.equals("Y"))
		{
			setWeights(newweights);

			for (int i = 0; i < aList.size(); i++)
			{
				aList.get(i).calculateTotalGrade(weights);
			}
		}
	}

	private void showOldWeights()
	/*
	 * ��ܥثe weights
	 */
	{
		System.out.printf("�°t��\n");
		System.out.printf("\tlab1\t\t%.0f%%\n, weights[0] * 100");
		System.out.printf("\tlab2\t\t%.0f%%\n, weights[1] * 100");
		System.out.printf("\tlab3\t\t%.0f%%\n, weights[2] * 100");
		System.out.printf("\tmid-term\t\t%.0f%%\n, weights[3] * 100");
		System.out.printf("\tfinal exam\t\t%.0f%%\n, weights[4] * 100");
	}

	private int[] getNewWeights()
	/*
	 * �]�w�s��Weights,�Ȧs��tempweights
	 */
	{
		int[] tempweights = new int[5];

		Scanner input = new Scanner(System.in);
		System.out.printf("��J�t��\n");

		System.out.printf("\tlab1\t\t\n");
		tempweights[0] = input.nextInt();

		System.out.printf("\tlab2\t\t\n");
		tempweights[1] = input.nextInt();

		System.out.printf("\tlab3\t\t\n");
		tempweights[2] = input.nextInt();

		System.out.printf("\tmid-term\t\t\n");
		tempweights[3] = input.nextInt();

		System.out.printf("\tfinal exam\t\t\n");
		tempweights[4] = input.nextInt();

		System.out.printf("\tlab1\t\t%d%%\n, tempweights[0]");
		System.out.printf("\tlab2\t\t%d%%\n, tempweights[1]");
		System.out.printf("\tlab3\t\t%d%%\n, tempweights[2]");
		System.out.printf("\tmid-term\t\t%d%%\n, tempweights[3]");
		System.out.printf("\tfinal exam\t\t%d%%\n, tempweights[4]");

		return tempweights;
	}

	private void setWeights(int[] newweights)
	/*
	 * 1.�ˬd�s��weights���M�O�_����1.0
	 * 2.�Y����A�hset ��weights
	 * 3.�_�h�����ʧ@
	 * */
	{
		if (newweights[0] + newweights[1] + newweights[2] + newweights[3] + newweights[4] != 100)
		{
			System.out.printf("weights ���M������1.0");
		}
		else
		{
			for (int i = 0; i < weights.length; i++)
			{
				weights[i] = (float) (((float) newweights[i]) / 100.0);
			}
		}

	}
}

