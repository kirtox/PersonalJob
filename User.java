import java.util.*;
import java.io.*;
import java.text.*;

public class User{
	public void AddData(){
		PersonalJob pj = new PersonalJob();
		PrintWriter outputStream = null;
        
		try
        {
            outputStream = 
                 new PrintWriter(new FileOutputStream("Data.txt",true));
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Error opening the file Data.txt.");
            System.exit(0);
        }
		outputStream.printf("Name of the job: " + getJobName() + "  |  ");
		outputStream.printf("Finished time: " + getFinishTime() + "  |  ");
		outputStream.printf("Started time: " + getStartTime() + "  |  ");
		outputStream.printf("Percentage: " + getPercentage() + "  |  ");
		outputStream.printf("Status: " + getStatus() + "  |  ");
		outputStream.printf("Number: " + getNumber() + "  |  ");
		outputStream.printf("Classification: " + getClassification() + "  |  ");
		outputStream.printf("Content: " + getContent() + "  |  ");
		outputStream.printf("\r\n");
		outputStream.close();
		pj.Menu();
	}
	
	public String getJobName(){
		Scanner sc = new Scanner(System.in);
		System.out.printf("Input name of the job in 15 words: ");
		String JobName = "Null";
		String space = "";
		try{				
			JobName = sc.next();
		}
		catch(Exception e){
			System.out.println("Error!");
			JobName = sc.next();
		}
		if(JobName.length()<=15){
			for(int i=0 ; i<=(15-JobName.length()) ; i++){
				space = space + " ";
			}
			return (JobName + space);
		}
		else{
			System.out.println("Must input in 15 words!");
			
			return getJobName();
		}
		//System.out.println("Writing to file.");
		//return JobName;
		
		
	}
		
	
	public String getFinishTime(){
		Scanner sc = new Scanner(System.in);
		PrintWriter outputStream = null;
		System.out.printf("Input the finished time(MM DD YYYY): ");
		int YY = 1000;
		int MM = 1;
		int DD = 1;
		try{				
			MM = sc.nextInt();
			DD = sc.nextInt();
			YY = sc.nextInt();
		}
		catch(InputMismatchException e){
			System.out.println("Error type!");
		}
		Date ft = new Date();
		String FinishTime = ft.Date(MM,DD,YY);
		//System.out.println(FinishTime);
		return FinishTime;

        
	}
	
	public String getStartTime(){
		Scanner sc = new Scanner(System.in);
		System.out.printf("Input the started time(MM DD YYYY): ");
		int YY = 1000;
		int MM = 1;
		int DD = 1;
		try{				
			MM = sc.nextInt();
			DD = sc.nextInt();
			YY = sc.nextInt();
		}
		catch(InputMismatchException e){
			System.out.println("Error type!");
			MM = sc.nextInt();
			DD = sc.nextInt();
			YY = sc.nextInt();
		}
		Date ft = new Date();
		String StartTime = ft.Date(MM,DD,YY);
		//System.out.println(StartTime);
		return StartTime;

        
	}
	
	public String getPercentage(){
		Scanner sc = new Scanner(System.in);
		System.out.printf("Input the percentage of the job(0-100): ");
		String percentage = "Null";
		int temp = 0;
		try{				
			temp = sc.nextInt();
		}
		catch(InputMismatchException e){
			System.out.println("Error type!");
			percentage = getPercentage();
			return percentage;
		}
		if(temp>=0 && temp<=100){
			percentage = Integer.toString(temp);
			//System.out.println("SuccessPercentage");
		}
		else{
			System.out.println("Must input 0-100!");
			percentage = getPercentage();
			
		}
		
		//System.out.println("Writing to file.");
		//System.out.println();
		//System.out.println("=====================================================");
		//System.out.println();
		return percentage; 

        
	}
	
	public String getStatus(){
		Scanner sc = new Scanner(System.in);
		System.out.printf("Input the status of the job(1:Complete  2:Executing  3:Undone: ");
		int StatusNum = 0;
		try{
			StatusNum = sc.nextInt();
		}
		catch(InputMismatchException e){
			System.out.println("Error type!");
			return getStatus();
		}
		if(StatusNum==1){
			return "Complete";
		}
		else if(StatusNum==2){
			return "Executing";
		}
		else if(StatusNum==3){
			return "Undone";
		}
		else{
			System.out.println("Must input 1-3 !");
			return getStatus();
		}
			
	}
	
	public String getNumber(){
		Scanner sc = new Scanner(System.in);
		String Number = getRandomAlphabet() + getRandomNum();
		System.out.println("The number of the data is : " + Number);
		//System.out.println("Writing to file.");
		//System.out.println();
		//System.out.println("=====================================================");
		//System.out.println();
		
		return Number;
	}
	
	public String getRandomNum(){													//get 5 numbers
		int number = (int) System.currentTimeMillis();
		String str = Integer.toString(number);
		return (str.substring(str.length()-5));
	}
	
	public char getRandomAlphabet(){												//get title Alphabet
		char title = (char)(Math.random()*26 + 'A');
 		return title;
	}
	
	public String getClassification(){
		Scanner sc = new Scanner(System.in);
		System.out.printf("Input the classification of the job: ");
		String Class = sc.next();
		return Class;
	}
	
	public String getContent(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Input the content of the job(Enter # to end): ");
		String ReadContent = "";
		String FinalContent = "";

		while(sc.hasNext()){
			ReadContent = sc.next();
			if(ReadContent.equals("#")){
				break;
			}
			FinalContent = FinalContent + ReadContent + " ";	
		}
		
		return FinalContent;
	}
	
	public void DisplayAllData(){
		PersonalJob pj = new PersonalJob();
		Scanner inputStream = null;		
		try
		{
        	inputStream =  new Scanner(new FileInputStream("Data.txt"));     
        }
      	catch(FileNotFoundException e)
      	{
           	System.out.println("File Data.txt was not found");
           	System.out.println("or could not be opened.");
       	}
		int count = 0;
		int page = 1;
		int tabOption = 0;
		tabOption = pj.TabDisplay();
		/*int option = pj.DisplayAllOption();
		if(option == 1){
			System.out.println("SortData");
			//SortData();
		}*/
		while(inputStream.hasNextLine() )     
       	{
			String nextLine = inputStream.nextLine();
			//StringTokenizer line = new StringTokenizer(nextLine);      
			System.out.println(nextLine);
			System.out.println();
       	    count++;
			if(count%10==0){
				page++;
			}
			if(tabOption==1 && (count%10)==0){
				System.out.println();
				System.out.println("===========================   "+ page +"   ===========================");
				System.out.println();
			}
			
       	}
		//System.out.println(count);
		//System.out.println(page);
       	inputStream.close();
		System.out.println();
		System.out.println("=====================================================");
		System.out.println();
		pj.Menu();
		
	}
	
	public void DisplayOneData(){
		//String[][] DataDetail= new String[128][8];
		PersonalJob pj = new PersonalJob();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Input 0-7 to display data: ");
		System.out.println("0: Name of job");
		System.out.println("1: Finished time");
		System.out.println("2: Started time");
		System.out.println("3: Percentage");
		System.out.println("4: Status");
		System.out.println("5: Number");
		System.out.println("6: Classification");
		System.out.println("7: Content");
		System.out.println("8: Menu");
		System.out.println("");
		
		int OptionNumber=0;
		int n=0;
		try{
			OptionNumber = sc.nextInt();
		}
		catch(InputMismatchException e){
			System.out.println("Error type!");
			OptionNumber = sc.nextInt();
		}
		switch(OptionNumber){
			case 0: n=0;break;
			case 1: n=1;break;
			case 2: n=2;break;
			case 3: n=3;break;
			case 4: n=4;break;
			case 5: n=5;break;
			case 6: n=6;break;
			case 7: n=7;break;
			case 8: pj.Menu();break;
			default: System.out.println("Error input!");break;
		}
		System.out.println();
		
		//System.out.println("Sort by data?(Y/N): ");
		//char SortAns = sc.next();
		int count = 0;
		int page = 1;
		int tabOption = 0;
		tabOption = pj.TabDisplay();
		try{
		FileReader fr = new FileReader("Data.txt");
		BufferedReader br = new BufferedReader(fr);
		switch(n){
			case 0: System.out.println("Name of the job:");break;
			case 1: System.out.println("Finished time:");break;
			case 2: System.out.println("Started time:");break;
			case 3: System.out.println("Percentage:");break;
			case 4: System.out.println("Status:");break;
			case 5: System.out.println("Number:");break;
			case 6: System.out.println("Classification:");break;
			case 7: System.out.println("Content:");break;
		}
		
		while(br.ready()){
			StringTokenizer st = new StringTokenizer(br.readLine(),"|");
			for(;st.hasMoreTokens();){
				if(n == 0){
					
					System.out.println(st.nextToken().substring(17).trim());
					count++;
					if(count%10==0){
						page++;
					}
					if(tabOption==1 && (count%10)==0){
						System.out.println();
						System.out.println("===========================   "+ page +"   ===========================");
						System.out.println();
					}
					break;
				}
				else if(n == 1){
					String nothing = st.nextToken();
					System.out.println(st.nextToken().substring(17).trim());
					count++;
					if(count%10==0){
						page++;
					}
					if(tabOption==1 && (count%10)==0){
						System.out.println();
						System.out.println("===========================   "+ page +"   ===========================");
						System.out.println();
					}
					break;
				}
				else if(n == 2){
					String nothing = st.nextToken();
					nothing = st.nextToken();
					System.out.println(st.nextToken().substring(16).trim());
					count++;
					if(count%10==0){
						page++;
					}
					if(tabOption==1 && (count%10)==0){
						System.out.println();
						System.out.println("===========================   "+ page +"   ===========================");
						System.out.println();
					}
					break;
				}
				else if(n == 3){
					String nothing = st.nextToken();
					nothing = st.nextToken();
					nothing = st.nextToken();
					System.out.println(st.nextToken().substring(14).trim());
					count++;
					if(count%10==0){
						page++;
					}
					if(tabOption==1 && (count%10)==0){
						System.out.println();
						System.out.println("===========================   "+ page +"   ===========================");
						System.out.println();
					}
					break;
				}
				else if(n == 4){
					String nothing = st.nextToken();
					nothing = st.nextToken();
					nothing = st.nextToken();
					nothing = st.nextToken();
					System.out.println(st.nextToken().substring(10).trim());
					count++;
					if(count%10==0){
						page++;
					}
					if(tabOption==1 && (count%10)==0){
						System.out.println();
						System.out.println("===========================   "+ page +"   ===========================");
						System.out.println();
					}
					break;
				}
				else if(n == 5){
					String nothing = st.nextToken();
					nothing = st.nextToken();
					nothing = st.nextToken();
					nothing = st.nextToken();
					nothing = st.nextToken();
					System.out.println(st.nextToken().substring(10).trim());
					count++;
					if(count%10==0){
						page++;
					}
					if(tabOption==1 && (count%10)==0){
						System.out.println();
						System.out.println("===========================   "+ page +"   ===========================");
						System.out.println();
					}
					break;
				}
				else if(n == 6){
					String nothing = st.nextToken();
					nothing = st.nextToken();
					nothing = st.nextToken();
					nothing = st.nextToken();
					nothing = st.nextToken();
					nothing = st.nextToken();
					System.out.println(st.nextToken().substring(18).trim());
					count++;
					if(count%10==0){
						page++;
					}
					if(tabOption==1 && (count%10)==0){
						System.out.println();
						System.out.println("===========================   "+ page +"   ===========================");
						System.out.println();
					}
					break;
				}
				else if(n == 7){
					String nothing = st.nextToken();
					nothing = st.nextToken();
					nothing = st.nextToken();
					nothing = st.nextToken();
					nothing = st.nextToken();
					nothing = st.nextToken();
					nothing = st.nextToken();
					System.out.println(st.nextToken().substring(11).trim());
					count++;
					if(count%10==0){
						page++;
					}
					if(tabOption==1 && (count%10)==0){
						System.out.println();
						System.out.println("===========================   "+ page +"   ===========================");
						System.out.println();
					}
					break;
				}
				
			}
				
			
		}
		fr.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Problem opening files.");
		}
		catch(IOException e){
			System.out.println("IOException happen!");
		}
		
		System.out.println();
		System.out.println("=====================================================");
		System.out.println();
		pj.Menu();
		
	}
	
	public void SearchData(){
		PersonalJob pj = new PersonalJob();
		Scanner sc = new Scanner(System.in);
		String SearchName = null;
		int successfind = 0;
		System.out.println("Data name: ");
		SearchName = sc.nextLine();
		
		try{
			FileReader fr = new FileReader("Data.txt");
			BufferedReader br = new BufferedReader(fr);
		
			while(br.ready()){
			String readin = br.readLine();
				if(readin.indexOf(SearchName)!=-1){
					successfind = 1;
					System.out.println(readin);
					System.out.println();
				}	
			}
			if(successfind==0){
				System.out.println("There is not a data named " + SearchName + ".");
			}
			try{
				fr.close();
			}
			catch(IOException e){}
		}
		
		
		catch(FileNotFoundException e)
		{
			System.out.println("Problem opening files.");
		}
		catch(IOException e){
			System.out.println("IOException happen!");
		}
		
		System.out.println();
		System.out.println("=====================================================");
		System.out.println();
		pj.Menu();											
	}
	
	public void ReviseData(){
		PersonalJob pj = new PersonalJob();
		txtReplace tr = new txtReplace();
		Scanner sc = new Scanner(System.in);
		String SearchName = null;
		
		System.out.printf("Name of the job: ");
		SearchName = sc.next();
		String SpaceMake = "";
		for(int i=0 ; i<=(15-SearchName.length()) ; i++){
			SpaceMake = SpaceMake + " ";
		}
		FileReader reader = null;
		FileWriter writer = null;
		BufferedReader br = null;
		BufferedWriter bw = null;
		File original = new File("Data.txt");
		
		try {
			
			reader = new FileReader(original);
			writer = new FileWriter("Data_revise.txt",true);

			br = new BufferedReader(reader);
			bw = new BufferedWriter(writer);
			
			//System.out.println("Test");
			while(br.ready()){
				
				String bfread = br.readLine();
				StringTokenizer st = new StringTokenizer(bfread,"|");
				for(;st.hasMoreTokens();){
					String readin = st.nextToken();
					
					if(readin.substring(17).trim().equals(SearchName)){
						
						bw.write("Name of the job: " + SearchName + SpaceMake + "  |  ");
						bw.write("Finished time: " + getFinishTime() + "  |  ");
						bw.write("Started time: " + getStartTime() + "  |  ");
						bw.write("Percentage: " + getPercentage() + "  |  ");
						bw.write("Status: " + getStatus() + "  |  ");
						bw.write("Number: " + getNumber() + "  |  ");
						bw.write("Classification: " + getClassification() + "  |  ");
						bw.write("Content: " + getContent() + "  |  ");
						bw.write("\r\n");
						
						
						break;
					}
					else{
						bw.write(bfread + "\r\n");
						break;
					}
				}
			}
			//System.out.println("Pass while");  
 
		} 
		catch(FileNotFoundException e){
			System.out.print("Problem opening files.");
    
		} 
		catch (IOException e) {
			System.out.println("IOException happen!");
		} 
		finally{
   
			try {
				
				br.close();
				bw.close();
				original.delete();
			} 
			catch (IOException e) {
 
			}
    
		}
		tr.Replace();
		
		System.out.println();
		System.out.println("=====================================================");
		System.out.println();
		pj.Menu();
	}
	
	public void DeleteData(){
		PersonalJob pj = new PersonalJob();
		txtReplace tr = new txtReplace();
		Scanner sc = new Scanner(System.in);
		String SearchName = null;
		
		System.out.printf("Name of the job: ");
		SearchName = sc.next();
		/*String SpaceMake = "";
		for(int i=0 ; i<=(15-SearchName.length()) ; i++){
			SpaceMake = SpaceMake + " ";
		}*/
		FileReader reader = null;
		FileWriter writer = null;
		BufferedReader br = null;
		BufferedWriter bw = null;
		File original = new File("Data.txt");
		
		try {
			
			reader = new FileReader(original);
			writer = new FileWriter("Data_revise.txt",true);

			br = new BufferedReader(reader);
			bw = new BufferedWriter(writer);
			
			//System.out.println("Test");
			while(br.ready()){
				
				String bfread = br.readLine();
				StringTokenizer st = new StringTokenizer(bfread,"|");
				for(;st.hasMoreTokens();){
					String readin = st.nextToken();
					
					if(readin.substring(17).trim().equals(SearchName)){
						bw.write("");
						System.out.println("Delete the data.");
						break;
					}
					else{
						bw.write(bfread + "\r\n");
						break;
					}
				}
			}
			//System.out.println("Pass while");  
 
		} 
		catch(FileNotFoundException e){
			System.out.print("Problem opening files.");
    
		} 
		catch (IOException e) {
			System.out.println("IOException happen!");
		} 
		finally{
   
			try {
				
				br.close();
				bw.close();
				original.delete();
			} 
			catch (IOException e) {
 
			}
    
		}
		tr.Replace();
		
		System.out.println();
		System.out.println("=====================================================");
		System.out.println();
		pj.Menu();
	}
	
	/*	PersonalJob pj = new PersonalJob();
		txtReplace tr = new txtReplace();
		
		Scanner sc = new Scanner(System.in); 
		
		System.out.println("Input 0-7 to sort data: ");
		System.out.println("0: Name of job");
		System.out.println("1: Finished time");
		System.out.println("2: Started time");
		System.out.println("3: Percentage");
		System.out.println("4: Status");
		System.out.println("5: Number");
		System.out.println("6: Classification");
		System.out.println("7: Content");
		System.out.println("8: Return Menu");
		System.out.println();
		
		int OptionNumber=0;
		int n=0;
		String nothing = "";
		String nothing2 = "";
		
		try{
			OptionNumber = sc.nextInt();
		}
		catch(InputMismatchException e){
			System.out.println("Error type!");
			OptionNumber = sc.nextInt();
		}
		switch(OptionNumber){
			case 0: n=0;break;
			case 1: n=1;break;
			case 2: n=2;break;
			case 3: n=3;break;
			case 4: n=4;break;
			case 5: n=5;break;
			case 6: n=6;break;
			case 7: n=7;break;
			case 8: pj.Menu();break;
			default: System.out.println("Error input!");break;
		}
		System.out.println();
		
		FileReader reader = null;
		//FileWriter writer = null;
		BufferedReader br = null;
		//BufferedWriter bw = null;
		File original = new File("Data.txt");
		
		int count = 0;
		int page = 1;
		int tabOption = 0;
		tabOption = pj.TabDisplay();
		String brReadSmall = "";
		String brReadLarge = "";
		try{
			reader = new FileReader(original);
			//writer = new FileWriter("Data_revise.txt",true);

			br = new BufferedReader(reader);
			//bw = new BufferedWriter(writer);
		
			System.out.println("While");
			while(br.ready()){
				
				brReadLarge = br.readLine();
				
				if(n==0){
					if(brReadSmall==""){
						System.out.printf("");
						brReadSmall = brReadLarge;
						
					}
					else if((brReadSmall.substring(17,36).compareTo(brReadLarge.substring(17,36)))<0){
						System.out.println(brReadSmall);
						brReadSmall = brReadLarge;
					}
					else if((brReadSmall.substring(17,36).compareTo(brReadLarge.substring(17,36)))==0){
						System.out.println(brReadSmall);
						brReadSmall = brReadLarge;
					}
					else if((brReadSmall.substring(17,36).compareTo(brReadLarge.substring(17,36)))>0){
						System.out.println(brReadLarge);
					}
					
				}
				
				
				

				
			}
			System.out.println("Pass While");
		}
		catch(FileNotFoundException e){
			System.out.print("Problem opening files.");
    
		} 
		catch (IOException e) {
			System.out.println("IOException happen!");
		}
		finally{
   
			try {
				
				br.close(); 
				
			} 
			catch (IOException e) {
 
			}
    
		}
		System.out.println();
		System.out.println("=====================================================");
		System.out.println();
		pj.Menu();
		
	}*/

}
