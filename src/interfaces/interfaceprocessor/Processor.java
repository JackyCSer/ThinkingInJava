package interfaces.interfaceprocessor;

public abstract interface Processor
{
	public static final int i = 100;
	public abstract String name();
	public abstract Object process(Object input);
}
