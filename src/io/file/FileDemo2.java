package io.file;

import java.io.File;
import java.io.FilenameFilter;

public class FileDemo2
{

	public static void main(String[] args)
	{
		File dir = new File("C:\\test");
		showDir(dir);
	}

	public static void listDemo()
	{
		for (File f : File.listRoots())
		{
			System.out.println(f);
		}
		System.out.println("------------------------------------");
		File file = new File("C:\\");
		String[] names = file.list(new FilenameFilter()
		{

			@Override
			public boolean accept(File dir, String name)
			{
				System.out.println("dir = " + dir + " " + "name = " + name);

				return name.endsWith(".java");

			}
		});

		System.out.println("names.length = " + names.length);

		System.out.println("------------------------------------");
		for (String s : names)
		{
			System.out.println(s);
		}
	}

	public static void showDir(File dir)
	{
		System.out.println(dir);
		File[] files = dir.listFiles();
		if (files == null)
			return;
		
		for (File f : files)
		{
			if (f.isDirectory())
			{
				showDir(f);
			} else
			{
				System.out.println("file name: " + f.getName() + " size: "
						+ f.length());
			}
		}
		System.out.println();

	}
}
