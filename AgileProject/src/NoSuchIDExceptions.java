public class NoSuchIDExceptions extends Exception
{
	public NoSuchIDExceptions(String ID)
	{
		super(String.format("ID %s ���F!",ID));
	}
}