package interfaces;

public class InterfaceCollision
{

}

interface i1{ void f(); }
interface i2 { int f(int i); }
interface i3 { int f(); }

class C 
{ 
	public int f() { return 1; } 
}

class C2 implements i1, i2
{
	@Override
	public void f() {}
	@Override
	public int f(int i) { return 1; }
}

class C3 extends C implements i2
{

	@Override
	public int f(int i)
	{
		// TODO Auto-generated method stub
		return 0;
	}
	
}

class C4 extends C implements i3 
{
	
}

// Methods differ only by return type:
/*
class C5 extends C implements i1
{
	
}

interface i4 extends i1, i3
{
	
}
*/
