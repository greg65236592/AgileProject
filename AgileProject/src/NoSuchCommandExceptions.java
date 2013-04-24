public class NoSuchCommandExceptions extends Exception
{
	public NoSuchCommandExceptions(String inputCommand)
	{
		super(String.format("«ü¥O %s ¿ù¤F!",inputCommand));
	}
}