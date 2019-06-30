//AlphabetOrder.java

public class AlphabetOrder 
{
		static String name[] ={"Java","C++","VB","PYTHON"};
		
			public static void main(String args[])
			{
				int size=name.length;
				String temp=null;
				for(int i=0;i<size;i++)
				{
					for(int j=i+1;j<size;j++)
					{
						if(name[j].compareTo(name[i])<0)
						{
							temp=name[i];
							name[i]=name[j];
							name[j]=temp;
						}
					}
				}
				for(int i=0;i<size;i++)
				{
					System.out.println(name[i]);
				}
			}
}

//BufferInputStreamDemo.java
import java.io.*;
public class BufferedInputStreamDemo 
{
	public static void main(String args[])throws IOException
	{
		String s="This is my first application of Buffered Input";
		byte buff[]=s.getBytes();
		System.out.println(buff.length);
		boolean marked = false;
		ByteArrayInputStream ba = new ByteArrayInputStream(buff);
		BufferedInputStream bi= new BufferedInputStream(ba);
		int c;
		while((c=bi.read())!=-1)
		{
			switch(c)
			{
			case 'm':
				if(!marked)
				{
					marked=true;
					bi.mark(32);
					System.out.print("M");
					
				}
				else
					System.out.print((char)c);
				break;
			case ';':
				bi.reset();
				break;
				default:
					System.out.print((char)c);
			}
		}
	}

}

//BufferReaderDemo.java
import java.io.*;
public class BufferedInputStreamDemo 
{
	public static void main(String args[])throws IOException
	{
		String s="This is my first application of Buffered Input";
		byte buff[]=s.getBytes();
		System.out.println(buff.length);
		boolean marked = false;
		ByteArrayInputStream ba = new ByteArrayInputStream(buff);
		BufferedInputStream bi= new BufferedInputStream(ba);
		int c;
		while((c=bi.read())!=-1)
		{
			switch(c)
			{
			case 'm':
				if(!marked)
				{
					marked=true;
					bi.mark(32);
					System.out.print("M");
					
				}
				else
					System.out.print((char)c);
				break;
			case ';':
				bi.reset();
				break;
				default:
					System.out.print((char)c);
			}
		}
	}

}

//CheckEven.java
import java.io.*;
public class CheckEven 
{
	public static void main(String args[])throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("\nHow many numbers");
		int n = Integer.parseInt(br.readLine());
		PrintWriter pw = new PrintWriter(new FileWriter("even1.txt"));
		for(int i=1 ; i<=n ; i++)
		{
			System.out.println("Enter number: ");
			int no = Integer.parseInt(br.readLine());
			if(no % 2 == 0)
			{
				pw.print(no);
				pw.println();
			}
		}
		System.out.println("Number succesfully copied");
		pw.close();
	}

}

//CopyFile.java
import java.io.*;
import java.util.*;
public class CopyFile 
{
	private static void CopyFile(String Source,String Destination)
	{
		try
		{
			BufferedReader br = new BufferedReader(new FileReader("f1"));
			BufferedWriter bw = new BufferedWriter(new FileWriter("f2",true));
			String line = "";
			while((line = br.readLine())!=null)
			{
				bw.write(line.toUpperCase());
				
			}
			bw.close();
			System.out.println("File copied");
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
		}
	}
	public static void main(String args[])
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Enter source file along with path");
		String src = input.next();
		System.out.println("Enter destination file along with path: ");
		String dest = input.next();
		CopyFile(src,dest);
	}

}
//Diary.java
import java.io.*;
public class Diaryy 
{
	
		String name, phone;
		Diaryy(){}
		Diaryy(String name , String phone)
		{
			this.name = name;
			this.phone = phone;
		}
		long save(RandomAccessFile f)throws IOException
		{
			long position = f.getFilePointer();
			f.writeUTF(name);
			f.writeUTF(phone);
			return position;
		}
		
		void print(RandomAccessFile raf)throws IOException
		{
			name = raf.readUTF();
			phone = raf.readUTF();
			System.out.println("Name: " +name+ "\tphone: "+phone+ "\n" );
		}
		public static void main(String args[])throws IOException
		{
			RandomAccessFile raf = new RandomAccessFile("diary.dat","rw");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			Diaryy d;
			System.out.println("Enter how many customers");
			int n = Integer.parseInt(br.readLine());
			String names[] = new String[n];
			long phones[] = new long[n];
			for(int i=0; i<n ; i++)
			{
				System.out.println("Enter a customer name");
				String name = br.readLine();
				System.out.println("Enter a phone number");
				String phone = br.readLine();
				d = new Diaryy(name,phone);
				names[i] = name;
				phones[i]= d.save(raf);
			}
			raf.close();
			boolean done = false;
			RandomAccessFile raf1 = new RandomAccessFile("diary.dat","r");
			Diaryy d1 = new Diaryy();
			while(!done)
			{
				System.out.println("Enter name of customer to search");
				String name = br.readLine();
				boolean found = false;
				for(int i=0;i<n;i++)
				if(names[i].equals(name))
				{
					raf1.seek (phones[i]);
					d1.print(raf1);
					found = true;
					
				}
				if(!found)
				{
					System.out.println("Record not available");
					System.out.println("Y/N");
					String go = br.readLine();
					if(go.equals("N"))
					{
						done = true;
					}
					raf1.close();
				}
 			}
		}
}

//FileNameCommand.java
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class FileNameCommand 
{
	public static void main(String args[])
	{
		FileInputStream fin;
		try
		{
			fin = new FileInputStream(args[0]);
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println("Insufficient argument!");
		}
		catch(FileNotFoundException fnf)
		{
			System.out.println("File not found");
		}
	

	String str=new String(args[0]);
	int len = str.length();
	for(int i=0;i<len;i++)
	{
		System.out.println(str.charAt(i));
	}
}
}


//FileRead.java
import java.io.File;
import java.io.FileInputStream;
class FileRead 
{
	public static void main(String args[]) 
	{
		File file = new File("a.txt");
		int ch, n;
		n = Integer.parseInt(args[0]); 
		StringBuffer strContent = new StringBuffer("");
		FileInputStream fin = null;
		try
		{
			fin = new FileInputStream(file);
					
				for(int i = 0;(ch = fin.read()) != -1;i++)
				{
					if(i == n)
					 
						strContent.append((char)ch);
					
					}
					fin.close();
					}
				catch(Exception e)
				{
					System.out.println(e);
				}
				System.out.println(strContent.toString());
		}
		
	}


//MaxMinArray.java
import java.io.*;
public class MaxMinArray 
{
	public static void main(String args[])throws IOException
	{
		int a[] = new int[5];
		int max = 0;
		int min = 0;
		
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	try
	{
		System.out.println("Enter number of array");
		for(int i=0;i<5;i++)
		{
		a[i] = Integer.parseInt(br.readLine());
		}
		for(int i=0;i<5;i++)
		{
			if(a[i]>=max)
			{
				a[i] = max;
			}
			else
			{
				a[i] = min;
			}
			System.out.println("Maximum number is" +max);
			System.out.println("minimum nuber is" +min);
		}
		
	}catch(Exception e)
	{
		System.out.println("Out of Bound");
	}
	}

}
//RandomAccessFileDemo.java
import java.io.IOException;
import java.io.RandomAccessFile;
public class RandomAccessFileDemo 
{
	public static void main(String args[])
	{
		try
		{
			RandomAccessFile RAF = new RandomAccessFile("ALOKRAFile.txt","rw");
			RAF.writeInt(100);
			RAF.writeInt(75);
			RAF.writeInt(50);
			RAF.writeInt(25);
			RAF.writeInt(10);
			
			RAF.seek((3-1)*4);
			RAF.writeInt(65);
			RAF.seek(0);
			int i = RAF.readInt();
			while(i != -1)
			{
				System.out.println(i);
				i = RAF.readInt();
			}
			RAF.close();
		}
		catch(IOException e){}
	}

}

//StringFormat.java
import java.util.Date;
public class StringFormatt 
{
	public static void main(String args[])
	{
		String Empinfo=String.format("Employee id is %d Employee name is %s",101,"Shree");
		System.out.println(Empinfo);
		
		Date today=new Date();
		
		String str=String.format("Today is %td", today);
		System.out.println(str);
		
		str=String.format("Two digits in year: %ty", today);
		System.out.println(str);
		
		str=String.format("Four digits in year: %tY", today);
		System.out.println(str);
		
		str=String.format("Today is %td/%tm/%tY",today,today,today);
		System.out.println(str);
	}

}

//StringStartsWithExample.java
import java.io.BufferedReader;
import java.io.File;

import java.io.IOException;
import java.io.InputStreamReader;
public class StringStartsWithExample 
{
	private static String strOrig;

	public static void main(String args[])throws IOException
	{
		File file = new File(".txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter how many strings");
		String n = br.readLine();
		String str[] = new String[100];
		for(int i = 0;i<str.length;i++)
		{
			str[i] = br.readLine();
			
		}
		for(int i=0;i<str.length;i++)
		{
			if((strOrig.startsWith("A")) &&(strOrig.endsWith("OBJ")))
			{
				FileUtils.writeStringToFile(file,str[i]);
			}
		}
		
	}

}
//StringTest.java


public class StringTest {
	
	String s1 = "I Love";
	String s2 = "India";
	String names[]={"Ashu","Kishu","Sonu"};
	
	

	void add()
	{
		System.out.println("The concatenation of string: " +(s1+s2));
	}
	void showName()
	{
		System.out.println("The names are ");
		for(int i=0;i<=5;i++)
		{
			System.out.println(names[i]);
		}
	}
	public static void main(String args[])
	{
		StringTest obj=new StringTest();
		obj.add();
		obj.showName();
	}

}


