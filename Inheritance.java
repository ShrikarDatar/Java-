//Continent.java
import java.io.*;
public class Continent {
	protected String cont;
	void getContinent()
	{
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter the continent");
			cont = br.readLine();
		}
		catch(Exception e){}
		}
	}
 class Country extends Continent
{
	protected String cou;
	void getCountry()
	{
		try
		{
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter the Country");
			cou=br.readLine();
		}
		catch(Exception e){}
	}
	
}
class State extends Country
{
	protected String sta;
	void getState()
	{
		try
		{
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter the state");
			sta=br.readLine();
		}
		catch(Exception e){}
	}
		
	
}
class Place extends State
{
	protected String place;
	void getPlace()
	{
		try
		{
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter the place");
			place=br.readLine();
		}
		catch(Exception e) {}
	
}
	
void display()
{
	System.out.println("continent is " +cont);
	System.out.println("country is " +cou);
	System.out.println("state is " +sta);
	System.out.println("place is" +place);
}
	public static void main(String args[])
	{
		Place p=new Place();
		p.getContinent();
		p.getCountry();
		p.getState();
		p.getPlace();
		p.display();
	}
}


//Find.java

public interface Find {
		
	public void findArea();
}
class Rectangle implements Find
{
	int len,bre;
	Rectangle()
	{
		len = 5;
		bre = 4;
	}
	public void findArea()
	{
		
	System.out.println("Area of Rectangle is: " +(len*bre));

	}
}
class Square extends Rectangle
{
	int side;
	 Square()
	{
		side=8;
	}
	public void findArea()
	{
		System.out.println("Area of Square: " +(side*side));
	}
}
class Circle implements Find
{
	int radius;
	Circle()
	{
		radius=9;
	}
	public void findArea()
	{
		System.out.println("Area of circle: "+(3.14*radius*radius));
	}
}
class End
{
	public static void main(String args[])
	{
		Square s=new Square();
		s.findArea();
		Circle c=new Circle();
		c.findArea();
		Rectangle r=new Rectangle();
		r.findArea();
	}
}

//order.java

 abstract class Order 
{
	 int radius;
	 final float pi = 3.14f;
	 abstract void findarea(int rad); 
	 abstract void findvolume(int rad); 
}
	 class Sphere extends Order
	  {	 
	    @Override
		void findarea(int rad)
		{
			this.radius = rad;
			System.out.println("area of sphere:" +(4*pi*radius*radius));
		}
	    @Override
		void findvolume(int rad)
		{
			this.radius = rad;
			System.out.println("Volume of sphere:" +((4/3)*pi*radius*radius));
		}
	 }	
 class AbstractSample
{
	public static void main(String args[])
	{
		int rad = 5;
		Sphere s = new Sphere();
		s.findarea(rad);
		s.findvolume(rad);
	}	
}	

	

//person.java

abstract class Person {
	public abstract void displayDetails();
}
class Employee extends Person
{
	int Emp_no;
	String name;
	String address;
	Employee(int Emp_no,String name,String address)
	{
		this.Emp_no=Emp_no;
		this.name=name;
		this.address=address;
	}
	public void displayDetails()
	{
		System.out.println("Employee details\n");
		System.out.println("Employee number is:- "+Emp_no);
		System.out.println("Employee name is:- "+name);
		System.out.println("Employee address is:- "+address);
	}
}
class Worker extends Person
{
	int hours;
	String name;
	
	Worker(int hours,String name)
	{
		this.hours=hours;
		this.name=name;
	}
	public void displayDetails()
	{
		System.out.println("Worker Details\n");
		System.out.println("Working hours:- "+hours);
		System.out.println("Worker name:- "+name);
	}	
}
class Test
{
	public static void main(String args[])
	{
		Employee e=new Employee(1,"Shreekar","Hadpsar");
		e.displayDetails();
		Worker w=new Worker(2,"Siri");
		w.displayDetails();
	}
}

