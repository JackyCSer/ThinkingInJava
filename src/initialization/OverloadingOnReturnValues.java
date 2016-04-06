package initialization;
/*
 * English Version: p166
 * This may work fine as long as the compiler could 
 * unequivocally determine the meaning from the context.
 * But the compiler don't allow this.
 */
public class OverloadingOnReturnValues
{
	int f()
	{
		return 1;
	}
	
	//! void f() {}

}
