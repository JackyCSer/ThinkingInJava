package concurrency;

public abstract class IntegerGenerator
{
	private volatile boolean canceled = false;
	public abstract int next();
	
	// Allow this to be canceled:
	public void cancel()
	{
		canceled = true;
	}
	
	public boolean isCanceled()
	{
		return canceled;
	}
	
}
