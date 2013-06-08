public class Grade {
	String _ID;
	String _name;
	int _lab1;
	int _lab2;
	int _lab3;
	int _mid;
	int _final;
	int _total;
	
	public Grade(String ID, String name, int lab1, int lab2, int lab3, int mid, int fin)
	{
		_ID = ID;
		_name = name;
		_lab1 = lab1;
		_lab2 = lab2;
		_lab3 = lab3;
		_mid = mid;
		_final = fin;
	}
	
	/* method  calculateTotalGrade  ----------------------------------------------                                                                                                    
	* �N�s���`���O���_��
	*
	* @param weight �s���t�����
	* @return
	* @throws 
	*
	* Time estimate : �t��k�]�p��A�~�򦹸�T�A�p O (n)
	* Example:���禡�Q�I�s�A�N�s���`���O���_��
	-------------------------------------------------------------------------*/
	/** ---------------------------------------------------------------------
	totalGrade���|�ˤ��J
	-------------------------------------------------------------------------- */
	public void calculateTotalGrade(int[] weight)
	{
		float grade = 0 ;
		grade = _lab1*weight[0] + _lab2*weight[1] + _lab3*weight[2] + _mid*weight[3] + _final*weight[4];
		_total = Math.round(grade/100);
	}

}