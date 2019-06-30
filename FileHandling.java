//Account.java
import java.io.*;
public class Account {
	int acc_no;
	String name;
	int balance;
	
	Account(int acc_no,String name,int balance)
	{
		this.acc_no=acc_no;
		this.name=name;
		this.balance=balance;
	}
}	
	class CheckBalance extends Exception
	{
		CheckBalance(String s)
		{
		super(s);
		}
	}
	class CheckName extends Exception
	{
		CheckName(String s)
		{
			super(s);
		}
	}
	  class ExceptionDemo
	{
		public static void main(String args[])
		{
			try
			{
				BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
				String s;
				System.out.println("Enter account Balance");
				s=br.readLine();
				int balance= Integer.parseInt(s);
				System.out.println("Enter name");
				String name=br.readLine();
				
					for(int i=0;i<name.length();i++)
					{
						if(name.indexOf(i)!=-1)
						{
							throw new CheckName("Invalid name");
							
						}
				
					}
			
			if(balance>1000 && balance<5000)
			{
				throw new CheckBalance("Invalid balance");
			}
				
		}
			catch(CheckName e)
			{
				
			}
			catch(CheckBalance e2)
			{
				
			}
			catch(IOException e3)
			{
				
			}
			}
	}


//Check.java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
class InvalidClass extends Exception
{
	public String toString()
	{
		return "Invalid class Entered..";
	}
}
public class Check 
{
	public static void main(String args[])throws IOException,InvalidClass

	{
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter a class: ");
		String cls=br.readLine();
		if(cls.equals("fy")||cls.equals("sy")||cls.equals("ty"))
			System.out.println("Welcome to class" +cls);
		else
		{
		throw new InvalidClass();
	}
	}
	
}

//Demo.Exception
import java.io.*;
class Contnum extends Exception{}
class LesserString extends Exception{}
class GreaterString extends Exception{}
class DemoException 
{
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int i;
	public static void main(String args[])
	{
		try
		{
			System.out.println("Enter a string");
			String s = br.readLine();
			int n = s.length();
			
			if(n>=0 && n<=5)
			{
				throw new LesserString();
			}
			else if(n>30)
			{
				throw new GreaterString();
			}
			for(char c: s.toCharArray())
			{
				if(Character.isDigit(c))
				{
					throw new Contnum();
				}
			}
		}
	
		catch(IOException e)
		{
			System.out.println("Invalid string");
			System.exit(0);
		}
		catch(Contnum e)
		{
			System.out.println("Enter 5 numbers...");
		}
		catch(LesserString e)
		{
			System.out.println("Number is less than length 5...");
		
     	}
		catch(GreaterString e)
		{
			System.out.println("number is greater than length 30..");
		}
	}
		
}

//MaxArrayException.java
import java.io.*;
public class MaxArray {
	public static void main(String args[])
	{
		int a[]=new int[5];
		int max=0;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		try
		{
			
		
		System.out.println("Enter array");
		for(int i=0;i<5;i++)
		{
		
			a[i]=Integer.parseInt(br.readLine());
		}
		for(int i=0;i<5;i++)
		{
			if(a[i]>max)
			{
				max=a[i];
			}
		}
		
			System.out.println("Maximum number is" +max);
		}
		catch(Exception e)
		{
			System.out.println("out of array limit");
		}
}
}

//menuException.java
import java.io.*;
 class Menu 
{
	public static void main(String args[])throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int i=0,choice;
		do
		{
			System.out.println("Menus");
			System.out.println("1. Read number");
			System.out.println("2. Show number");
			System.out.println("3. Show binar");
			System.out.println("4. Show octal");
			System.out.println("5. Show Hexadecimal");
			System.out.println("Exit");
			System.out.println("Enter Your Choice");
			choice=Integer.parseInt(br.readLine());
			switch(choice)
			{
			case 1: System.out.println("Enter a number");
				 i=Integer.parseInt(br.readLine());
				 break;
			
			case 2: System.out.println("Given number is" +i);
					break;
			
			case 3: String binary=Integer.toBinaryString(i);
					System.out.println("Binary is" +binary);
					break;
			case 4: String octal=Integer.toOctalString(i);
					System.out.println("octal number" +octal);
					break;
			case 5: String Hex=Integer.toHexString(i);
					System.out.println("Hex number" +Hex);
					break;
			}
		}
		while(choice!=6);
	}
}
					
//multicatchException.java

public class MultiCatch 
{
		public static void main(String args[])
	{
		int arr[]={4,20};
		int div=20;
		try
		{
			int ans=arr[2]/div-arr[1];
		}
		catch(ArithmeticException e)
		{
			
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			
		}
		catch(ArrayStoreException e)
		{
			
		}
		finally
		{
			int out=arr[1]/arr[0];
			System.out.println("output " +out);
		}
		
	}	
}		
		
//TempratureException.java

import java.io.*;
class BelowNormal extends Exception{}
class Normal extends Exception{}
class HighNormal extends Exception{}

 class Temprature {
static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

public static void main(String args[])throws IOException
{
	float n=0f;
	try
	{
		System.out.println("Enter a string");
		n=Float.parseFloat(br.readLine());
		if(n<94.00)
		{
			throw new BelowNormal();
		}
		if(n>95.00 && n<100.00)
		{
			throw new Normal();
		}
		if(n>100.00)
		{
			throw new HighNormal();
		}
	}
	catch(BelowNormal e)
	{
		System.out.println("Given number is below normal");
	}
	catch(Normal e)
	{
		System.out.println("Given number is normal");
	}
	catch(HighNormal e)
	{
		System.out.println("Given number is high normal");
	}
}

}

