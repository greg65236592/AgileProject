
public class Main {
	/** ---------------------------------------------------------------------
	try { call UI() 建構 aUI } end of try
	catch (NoSuchIDExceptions       e1) {print msg1} //ex ID 錯了!
	catch (NoSuchCommandExceptions e2) {print msg2}//ex指令錯了!
	end class Main
	-------------------------------------------------------------------------- */
	public static void main(String[] args) {
		try
		{
			new UI();
		}
		catch(NoSuchIDExceptions e1)
		{
			System.out.println("ID錯了");
		}
		catch(NoSuchCommandExceptions e2)
		{
			System.out.println("指令錯了");
		}
	}

}
