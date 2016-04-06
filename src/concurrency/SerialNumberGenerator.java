package concurrency;

public class SerialNumberGenerator
{
	private static volatile int serialNumber = 0;
	
	public  static int nextSerialNumber()
	{
		serialNumber++;
		return serialNumber;		// NOT thread-safe
	}
	
}
