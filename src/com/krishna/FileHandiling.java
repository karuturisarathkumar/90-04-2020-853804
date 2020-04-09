package com.krishna;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class FileHandiling
{
     public static List<Customer> cusAll()
     {
    	 SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
    	 List<Customer> cl=new ArrayList<Customer>();
    	 File f=new File("G:\\revision\\rivisionhandson\\customer.txt");
    	
    	 try {
			BufferedReader br=new BufferedReader(new FileReader(f));
			String line=br.readLine();
			while(line!=null)
			{
				 Customer c=new Customer();
					Address add=new Address();
				
				String [] str=line.split(",");
				c.setCustid(Integer.parseInt(str[0]));
				c.setCustname(str[1]);
				c.setEmail(str[2]);
				c.setMobile(str[3]);
				c.setDob(sdf.parse(str[4]));
				add.setCity(str[5]);
				add.setState(str[6]);
				add.setCountry(str[7]);
				c.setAddress(add);
				cl.add(c);
				line=br.readLine();
				
			}
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    
    	 return cl;
     }
	 public static void dispalyByAge(int agedd)
	 {
		 List<Customer> cus=cusAll();
		 ArrayList al=new ArrayList();
		 for(Customer c:cus)
		 {
		 Date d=new Date();
		 int date=d.getYear()+1900;
		 int date1=c.getDob().getYear()+1900;
		 int age=date-date1;
		 if(age<=agedd)
		 {
		 Map m=new HashMap<Integer,String>();
		 m.put(age,c.getCustname());
		 System.out.println( m.get(agedd));
		 }
		 else
		 {
			 System.out.println("not matched");
		 }
		 }
		
	 }
	 public static void displayByCountry(String state)
	 {
		 List<Customer> cus=cusAll();
		for(Customer c:cus)
		{
		if(c.getAddress().getState().equals(state))	
		{
			System.out.println(c);
		}
		}
		 
	 }
 public static void main(String[] args) 
 {
	while(true)
	{
		System.out.println("select \n 1.Display All Customers \n 2.Display By Age \n 3.Display By Country \n 4.Exit");
		Scanner in=new Scanner(System.in);
		int i=in.nextInt();
		
		
		switch(i)
		{
		case 1:
			List<Customer> cl=cusAll();
			System.out.println(cl);
			break;
		case 2:
			System.out.println("enter the age");
			int age=in.nextInt();
			dispalyByAge(age);
		//	System.out.println(cl1);
			break;
		case 3:
			System.out.println("enter the state");
			String state=in.next();
			displayByCountry(state);
			break;
		case 4:
			System.out.println("Byee");
			System.exit(0);
		}
	}
}
}
