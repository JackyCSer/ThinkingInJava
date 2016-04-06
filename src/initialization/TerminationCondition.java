package initialization;
//Using finalize() to detect an object that 
//	hasn't been properly cleaned up. 
/*
 * �ܽ᣺����Java�����д���һ�����󣬵��ǲ�������һ������ȥʹ���������磺
 * 	��ô��finalize()�������ᱻ�������������ã��Ѵ�����ػ��չ�����
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