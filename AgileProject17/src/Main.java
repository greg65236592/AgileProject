
public class Main {
	/** ---------------------------------------------------------------------
	try { call UI() �غc aUI } end of try
	catch (NoSuchIDExceptions       e1) {print msg1} //ex ID ���F!
	catch (NoSuchCommandExceptions e2) {print msg2}//ex���O���F!
	end class Main
	-------------------------------------------------------------------------- */
	public static void main(String[] args) {
		try
		{
			new UI();
		}
		catch(NoSuchIDExceptions e1)
		{
			System.out.println("ID���F");
		}
		catch(NoSuchCommandExceptions e2)
		{
			System.out.println("���O���F");
		}
	}

}
