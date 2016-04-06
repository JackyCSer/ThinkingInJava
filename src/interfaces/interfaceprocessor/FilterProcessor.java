package interfaces.interfaceprocessor;
/*
 * Using Adapter Design Pattern
 * and delegation in the class FilterAdapter
 */

import interfaces.filters.BandPass;
import interfaces.filters.Filter;
import interfaces.filters.HighPass;
import interfaces.filters.LowPass;
import interfaces.filters.Waveform;

public class FilterProcessor
{
	public static void main(String [] args)
	{
		Waveform w = new Waveform();
		/*
		 * 1. Upcasting from LowPass to Filter
		 * 2. Polymorphically invoking LowPass's method: process
		 */
		Apply.process(new FilterAdapter(new LowPass(1.0)), w);		
		Apply.process(new FilterAdapter(new HighPass(2.0)), w);			
		Apply.process(new FilterAdapter(new BandPass(3.0, 4.0)), w);
	}
}

/*
 * ���������ģʽ����FilterAdapter�Ĺ���������ʵ����Filter�ӿڵ���Ķ���
 * 	Ȼ�󣬲���ʵ����Processor�ӿڵĶ��󣬼������ʵ�ֲ�ͬ�ӿڵĶ����ת����
 * 	ʵ�����������Ĺ��ܡ�
 */
class FilterAdapter implements Processor
{
	private Filter filter;
	
	public FilterAdapter(Filter filter)
	{
		this.filter = filter;
	}
	
	@Override
	public String name()
	{
		return filter.name();
	}

	@Override
	public Waveform process(Object input)
	{
		System.out.println("Using FilterAdapter.process()");
		// Covariant return: 
		// Delegation method: 
		return filter.process((Waveform) input);
	}
	
}