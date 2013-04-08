/**
 * ********************************************************************** 
 * class Grades 儲存 ID, name, lab1, lab2, lab3, midTerm, finalExam, and totalGrade
 * 
 * calculateTotalGrade(weights) Grades () { } //建構子
 ************************************************************************/

public class Grades
{

	private String id, name;
	private int lab1, lab2, lab3, midTerm, finalExam, totalGrade;

	public Grades(String id, String name, int lab1, int lab2, int lab3, int midTerm, int finalExam)
	{
		setId(id);
		setName(name);
		setLab1(lab1);
		setLab2(lab2);
		setLab3(lab3);
		setMidTerm(midTerm);
		setFinalExam(finalExam);
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public int getLab1()
	{
		return lab1;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public void setLab1(int lab1)
	{
		this.lab1 = lab1;
	}

	public int getLab2()
	{
		return lab2;
	}

	public void setLab2(int lab2)
	{
		this.lab2 = lab2;
	}

	public int getLab3()
	{
		return lab3;
	}

	public void setLab3(int lab3)
	{
		this.lab3 = lab3;
	}

	public int getMidTerm()
	{
		return midTerm;
	}

	public void setMidTerm(int midTerm)
	{
		this.midTerm = midTerm;
	}

	public int getFinalExam()
	{
		return finalExam;
	}

	public void setFinalExam(int finalExam)
	{
		this.finalExam = finalExam;
	}

	public int getTotalGrade()
	{
		return totalGrade;
	}

	public void calculateTotalGrade(float[] weights)
	/*
	 * totalGrade須四捨五入
	 */
	{
		totalGrade = 0;

		float lab1_weight = getLab1() * weights[0];
		float lab2_weight = getLab2() * weights[1];
		float lab3_weight = getLab3() * weights[2];
		float midTerm_weight = getMidTerm() * weights[3];
		float finalExam_weight = getFinalExam() * weights[4];
		float tempTotal = lab1_weight + lab2_weight + lab3_weight + midTerm_weight + finalExam_weight;

		totalGrade = (int) Math.round(tempTotal);
	}
}
