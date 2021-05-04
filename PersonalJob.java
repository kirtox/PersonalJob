import java.util.*;
import java.io.*;
import java.text.*;
public class PersonalJob{
	private static int DataNumber = 0;
	
	public static void main(String[] args){
		User user = new User();
		
		int identity = 2;
		
		
		if(enter()){
			System.out.println("Welcome!");
			System.out.println();
			System.out.println("=====================================================");
			System.out.println();
			while(true){
				identity = changemode();
				System.out.println();
				System.out.println("=====================================================");
				System.out.println();
				if(identity == 1){
					System.out.println("Manager");
				}
				
				else if(identity == 2){
					Menu();
				}
				System.out.println();
				System.out.println("=====================================================");
				System.out.println();
				
				
				break;
			}
		}
		else{
			System.out.println("Wrong ID or wrong password!");
			System.exit(0);
		}
	}
	public static boolean enter(){
		Scanner sc = null;
		sc = new Scanner(System.in);
		System.out.printf("Login ID: ");
		String ID = sc.next();
		System.out.printf("Password: ");
		String passwd = sc.next();
		
		if(ID.equals("cis")){
			if(passwd.equals("1234")){
				return true;
			}
			else 
				return false;
		}
		else 
			return false;
	}
	public static void Menu(){
		System.out.println();
		System.out.println("=====================================================");
		System.out.println();
		
		nowDate nd = new nowDate();
		nd.getDateTime();
		
		System.out.println();
		System.out.println("Please enter 0 to 7.");
		System.out.println("Add a data: 0");
		System.out.println("Display all the data: 1");
		System.out.println("Display one of the data: 2");
		System.out.println("Search the data: 3");
		System.out.println("Modify a data: 4");
		System.out.println("Delete a data: 5");	
		System.out.println("Choose identity: 6");
		System.out.println("Exit: 7");
		System.out.println();
		System.out.println("=====================================================");
		System.out.println();
		LoadOption();
		
	}
	public static void LoadOption(){
		Scanner sc = null;
		sc = new Scanner(System.in);
		int OptionNumber = -1;
		System.out.printf("Enter the option: ");
		try{
			OptionNumber = sc.nextInt();
		}
		catch(Exception e){
			System.out.println();
			System.out.println("Error Option!");
		}
		System.out.println();
		System.out.println("=====================================================");
		System.out.println();
		SwitchOption(OptionNumber);
	}	
	
	public static void SwitchOption(int OptionNumber){
		User user = new User();
		Manager mg = new Manager();
		switch(OptionNumber){
			case 0: DataNumber = mg.txtDataNumber();
					if(DataNumber<=128){
						user.AddData();
						//DataNumber++;
					} 
					System.out.println("There are " + DataNumber + " over 128 data in Data.txt.");
					System.out.println("Please delete data.");
					Menu();
					//user.AddData();
			case 1: 
					int option = DisplayAllOption();
					if(option == 1){
						System.out.println("Sort");
						System.out.println();
						Menu();
						//user.SortData();
					}
					else if(option == 2){
						user.DisplayAllData();
					}
					break;
			case 2: user.DisplayOneData(); break;
			case 3: user.SearchData(); break;
			case 4: user.ReviseData(); break;
			case 5: user.DeleteData(); break;
			case 6: int identity = changemode();
					System.out.println();
					System.out.println("=====================================================");
					System.out.println();
					if(identity == 1){
						System.out.println("Manager");
					}
				
					else if(identity == 2){
						Menu();
					}
					System.out.println();
					System.out.println("=====================================================");
					System.out.println(); break;
			case 7: System.exit(0); 
			default: System.out.println("Must input 0-8!"); LoadOption(); break;
		}
		
	}
	
	public static int changemode(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Choose identity(1 or 2) :");
		System.out.println("1. Manager");
		System.out.println("2. User");
		int modeNumber = 2;
		try{
			modeNumber = sc.nextInt();
		}
		catch(InputMismatchException e){
			System.out.println("Must input integer");
			changemode();
		}
		return modeNumber;
		
	}
	
	public static int DisplayAllOption(){
		Scanner sc = new Scanner(System.in);
		System.out.println("1. Sort one of the column to display");
		System.out.println("or 2. display all the data.");
		int option = 2;
		int finaloption = 2;
		try{
			option = sc.nextInt();
			switch(option){
				case 1: finaloption = 1; break;
				case 2: finaloption = 2; break;
				default: System.out.println("Must input 1 or 2!"); 
						 finaloption = DisplayAllOption();
						 break;
			}
		}
		catch(InputMismatchException e){
			System.out.println("Must input integer");
			DisplayAllOption();
		}
		System.out.println();
		return finaloption;
	}
	
	public static int TabDisplay(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Tab or not(Y/N)");
		String taboption = "N";
		System.out.println();
		int finTab = 0;
		try{
			taboption = sc.next();
			if(taboption.equalsIgnoreCase("Y")){
				finTab = 1;
			}
			else if(taboption.equalsIgnoreCase("N")){
				finTab = 0;
			}
			else{
				System.out.println("Must input Y/N!");
				finTab = TabDisplay();
			}
		}
		catch(InputMismatchException e){
			System.out.println("Must input integer");
			taboption = sc.next();
		}
		return finTab;
	}
		
}