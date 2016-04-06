package initialization;
//Using finalize() to detect an object that 
//	hasn't been properly cleaned up. 
/*
 * 总结：当在Java程序中创建一个对象，但是并不创建一个引用去使用它：例如：
 * 	那么，finalize()方法将会被垃圾回收器调用，已处理相关回收工作。
 */
public class TerminationCondition
{
	public static void main(String [] args)
	{
		Book novel = new Book(true);
		//proper cleanup:
		novel.checkIn();
		//novel.finalize();
		//Drop the reference, forget to clean up:
		new Book(true);
			System.out.println("Message: ");
		
		//Force garbage collection & finalization:
		System.gc();
	}
}


class Book 
{
	boolean checkedOut = false;
	
	Book(boolean checkedOut)
	{
		this.checkedOut = checkedOut;
	}

	void checkIn()
	{
		checkedOut = false;
	}
	
	//Method inherited from class java.lang.Object
	@Override
	protected void finalize()
	{
		if (checkedOut)
		{
			System.out.println("finalize(): Error: checked out");
			//Normally, you will also do this:
			//super.finalize();		//Call the base-version 
		}
	}

}