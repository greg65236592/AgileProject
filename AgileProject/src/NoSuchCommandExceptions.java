public class NoSuchCommandExceptions extends Exception
{
	public NoSuchCommandExceptions(String inputCommand)
	{
		super(String.format("���O %s ���F!",inputCommand));
	}
}