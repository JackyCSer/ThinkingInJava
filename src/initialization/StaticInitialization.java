package initialization;
//Specifying initial values in a class definition

//Output:
/*
 * 1. 查找程序入口：main(String [] args)，
 * 2. JVM发现该方法在类：StaticInitialization中，加载该类
 * 3. 发现该类含有static成员：table，cupboard
 * 		3.1 查找和加载类：Table
 * 			3.1.1 发现Table类有static成员，创建和初始化static成员：bowl1, bowl2
 * 			3.1.2 查找和加载类：Bowl
 * 			3.1.3 发现Bowl类无static成员，即直接调用构造函数Bowl(int marker)，
 * 					Bowl(1)
 * 					Bowl(2)
 * 			3.1.4 调用该类的构造器；
 * 					Table(): 
 * 					f1(1)
 * 			//table 创建完成
 *		3.2 查找和加载类：Cupboard
 *			3.2.1 创建和初始化该类static成员：bowl4, bowl5
 *					Bowl(4)
 *					Bowl(5)
 *			3.2.2 创建和初始化该类普通成员
 *					Bowl(3)
 *			3.2.3 调用该类的构造器：
 *					Cupboard()
 *					f1(2)
 *			//cupboard 创建完成
 *	4. StaticInitialization类初始化完成，调用其static方法：main()
 *
 *		 Creating new Cupboard() in main #1			
 *		4.1 创建main()方法中的Cupboard类型的局部变量：
 *			4.1.1 Cupboard类中含有成员变量：bowl3，故先创建和初始化该成员变量
 *				Bowl(3)
 *			4.1.2 调用Cupboard类的构造器
 *				Cupboard()
 *				f1(2)
 *
 *		Creating new Cupboard() in main #2
 *		4.2 再次创建main()方法中的Cupboard类型的局部变量：（过程4.1）
 * 				Bowl(3)
 * 				Cupboard()
 * 				f1(2)
 * 		4.3 调用：table.f2(1);
 * 				f2(1)
 * 		4.3 调用：cupboard.f3(1);
 * 				f3(1)
 * 	//Done
 */


public class StaticInitialization
{
	public static void main(String [] args)
	{
		System.out.println("Creating new Cupboard() in main #1");
		new Cupboard();
		System.out.println("Creating new Cupboard() in main #2");
		new Cupboard();
		table.f2(1);
		cupboard.f3(1);
	}
	static Table table = new Table();
	static Cupboard cupboard = new Cupboard();
	
	StaticInitialization()
	{
		System.out.println("StaticInitialization()");
	}
}

class Bowl
{
	Bowl(int marker)
	{
		System.out.println("Bowl(" + marker + ")");
	}
	void f1(int marker)
	{
		System.out.println("f1("+marker+")");
	}
}

class Table
{
	static Bowl bowl1 = new Bowl(1);
	Table()
	{
		System.out.println("Table(): ");
		bowl2.f1(1);
	}
	void f2(int marker)
	{
		System.out.println("f2("+marker+")");
	}
	static Bowl bowl2 = new Bowl(2);
}

class Cupboard
{
	Bowl bowl3 = new Bowl(3);
	static Bowl bowl4 = new Bowl(4);
	Cupboard()
	{
		System.out.println("Cupboard()");
		bowl4.f1(2);
	}
	
	void f3(int marker)
	{
		System.out.println("f3("+marker+")");
	}
	
	static Bowl bowl5 = new Bowl(5);
}

