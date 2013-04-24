public class Main extends Object
{
	public static void main(String[] args) throws Exception
	{
		try
		{
			UI aUI = new UI();
		}
		catch (NoSuchIDExceptions e1)
		{
			e1.printStackTrace();
		}
		catch (NoSuchCommandExceptions e2)
		{
			e2.printStackTrace();
		}
	}
}
