package polymorphism;
// Downcasting & RunTime Type Information (RTTI)
// {Throws Exception}
public class RTTI
{
	public static void main(String [] args)
	{
		Useful [] x = {
				new Useful(), 
				new MoreUseful()	//Upcasting to Useful
		};
		
		x[0].f();
		x[1].g();
		// Throws Exception:
		//! ((MoreUseful) x[0]).u(); //Downcast/RTTI
		//! x[1].u();
		((MoreUseful) x[1]).u();
	}
}

class Useful
{
	public void f(){}
	public void g(){}
}

class MoreUseful extends Useful
{
	@Override
	public void f(){}
	@Override
	public void g(){}
	
	public void u(){ System.out.println("MoreUseful.u()"); }
	public void v(){}
	public void w(){}
}
