import java.util.*;
import java.io.*;
public class Manager{
	public int txtDataNumber(){
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
		while(inputStream.hasNextLine() )     
       	{
			String nextLine = inputStream.nextLine();    
			//System.out.println(nextLine);
			//System.out.println();
       	    count++;
			
       	}
		//System.out.println(count);
		
       	inputStream.close();
		return count;
	}

}