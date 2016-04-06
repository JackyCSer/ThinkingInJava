package initialization;
//Specifying initial values in a class definition

//Output:
/*
 * 1. ���ҳ�����ڣ�main(String [] args)��
 * 2. JVM���ָ÷������ࣺStaticInitialization�У����ظ���
 * 3. ���ָ��ຬ��static��Ա��table��cupboard
 * 		3.1 ���Һͼ����ࣺTable
 * 			3.1.1 ����Table����static��Ա�������ͳ�ʼ��static��Ա��bowl1, bowl2
 * 			3.1.2 ���Һͼ����ࣺBowl
 * 			3.1.3 ����Bowl����static��Ա����ֱ�ӵ��ù��캯��Bowl(int marker)��
 * 					Bowl(1)
 * 					Bowl(2)
 * 			3.1.4 ���ø���Ĺ�������
 * 					Table(): 
 * 					f1(1)
 * 			//table �������
 *		3.2 ���Һͼ����ࣺCupboard
 *			3.2.1 �����ͳ�ʼ������static��Ա��bowl4, bowl5
 *					Bowl(4)
 *					Bowl(5)
 *			3.2.2 �����ͳ�ʼ��������ͨ��Ա
 *					Bowl(3)
 *			3.2.3 ���ø���Ĺ�������
 *					Cupboard()
 *					f1(2)
 *			//cupboard �������
 *	4. StaticInitialization���ʼ����ɣ�������static������main()
 *
 *		 Creating new Cupboard() in main #1			
 *		4.1 ����main()�����е�Cupboard���͵ľֲ�������
 *			4.1.1 Cupboard���к��г�Ա������bowl3�����ȴ����ͳ�ʼ���ó�Ա����
 *				Bowl(3)
 *			4.1.2 ����Cupboard��Ĺ�����
 *				Cupboard()
 *				f1(2)
 *
 *		Creating new Cupboard() in main #2
 *		4.2 �ٴδ���main()�����е�Cupboard���͵ľֲ�������������4.1��
 * 				Bowl(3)
 * 				Cupboard()
 * 				f1(2)
 * 		4.3 ���ã�table.f2(1);
 * 				f2(1)
 * 		4.3 ���ã�cupboard.f3(1);
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

