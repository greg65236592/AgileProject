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
	* 將新的總分記錄起來
	*
	* @param weight 新的配分比例
	* @return
	* @throws 
	*
	* Time estimate : 演算法設計後，才獲此資訊，如 O (n)
	* Example:當此函式被呼叫，將新的總分記錄起來
	-------------------------------------------------------------------------*/
	/** ---------------------------------------------------------------------
	totalGrade須四捨五入
	-------------------------------------------------------------------------- */
	public void calculateTotalGrade(int[] weight)
	{
		float grade = 0 ;
		grade = _lab1*weight[0] + _lab2*weight[1] + _lab3*weight[2] + _mid*weight[3] + _final*weight[4];
		_total = Math.round(grade/100);
	}

}