package io;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Properties;

public class SystemInfo
{

	public static void main(String[] args) throws FileNotFoundException
	{
		Properties p = System.getProperties();
		p.list(new PrintStream("E:\\system_info.txt"));
	}

}
