package io.file;

import java.io.File;
import java.io.IOException;

public class FileDemo
{

	public static void main(String[] args) throws IOException
	{
		File f1 = new File("E:\\f1.txt");
		File f2 = new File("C:\\abc\\f2.txt");
		File dir = new File("E:\\bcd\\e\\d\\f\\g\\");
		File f3 = new File(dir, "f3.txt");

		//
		// System.out.println("f1 = " + f1);
		// System.out.println("f2 = " + f2);
		// System.out.println("f3 = " + f3);
		// System.out.println("-------------------DONE----------------");
		//
		// System.out.println(f1.createNewFile());
		//
		//
		// f1.deleteOnExit();
		// System.out.println("dir.mkdirs() = " + dir.mkdirs());
		//
		// System.out.println("dir.delete() = " + dir.delete());
		// f3.createNewFile();
		// System.out.println("f3.exists() = " + f3.exists());

		// f1.createNewFile();
		// f1.mkdirs();
		//
		//
		// System.out.println("f1.isFile() = " + f1.isFile());
		// System.out.println("f1.isDirectory() = " + f1.isDirectory());
		//
		// f1.delete();

		System.out.println("f1.createNewFile() = " + f1.createNewFile());
		System.out.println("f1.exists() = " + f1.exists());
		System.out.println("f1.getName() = " + f1.getName());
		System.out.println("f1.getPath() = " + f1.getPath());
		System.out.println("f1.getAbsolutePath() = " + f1.getAbsolutePath());
		System.out.println("f1.lastModified() = " + f1.lastModified());
		System.out.println("f1.getParent() = " + f1.getParent());
		System.out.println("-----------------------------------------");

		System.out.println("f1.renameTo(f2) = " + f1.renameTo(f2));
		System.out.println("f2.exists() = " + f2.exists());
		System.out.println("f1.getName() = " + f1.getName());
		System.out.println("f1.getPath() = " + f1.getPath());
		System.out.println("f1.getAbsolutePath() = " + f1.getAbsolutePath());
	}

}
