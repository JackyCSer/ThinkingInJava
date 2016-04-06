package initialization;
/*
 * 1. ����f()��������ֶ�̬����
 * 2.  ���ǣ��򲻾��ж�̬��
 * 3. this�ؼ��ֵ��ڹ����������÷���
 * 	�ڹ��쳬��Ĺ����У�ִ�л���Ĺ��캯��ʱ������ڻ���Ĺ��캯����
 * 	����this����ô��ָ���ǳ����������ã���ʹ�������÷������������
 * 	��̬���ã��ڱ����е�f()����������ʹ����������ʱ����������ֶ�̬��
 * 	�����ǲ����ж�̬�Եģ�����ô�����ʻ����е��򣬺ͳ����޹أ���Ȼ��
 * 	��ʱ��thisָ���ࡣ
 * 
 */
public class ThisKeywordTest
{
	public static void main(String [] args)
	{
		Litchi litchi = new Litchi("big litchi");
		System.out.println("------------------------------------------------");
		Fruit f = new Fruit();
	}

}

class Fruit
{
	private int i = 100;
	String name;
	public void f() { System.out.println("Fruit.f()"); }
	Fruit()
	{
		System.out.println("Fruit()");
		this.f();
		System.out.println("this.name = " + this.getClass().getSimpleName());
		System.out.println("this.i = " + this.i);
	}
	
	public String toString()
	{
		return name;
	}
}

class Litchi extends Fruit
{
	private int i = 200;
	Litchi(String name)
	{
		this.name = name;
		System.out.println("Litchi()");
	}
	@Override
	public void f() { System.out.println("Litchi.f()"); }

}


