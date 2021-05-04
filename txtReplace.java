import java.io.*;

public class txtReplace{
	public void Replace(){
		FileReader reader = null;
		FileWriter writer = null;
		BufferedReader br = null;
		BufferedWriter bw = null;
		File file = new File("Data_revise.txt");
		
		try {
			
			reader = new FileReader(file);
			writer = new FileWriter("Data.txt",true);

			br = new BufferedReader(reader);
			bw = new BufferedWriter(writer);
			
			//System.out.println("Test");
			while(br.ready()){
				bw.write(br.readLine() + "\r\n");
				
					
				
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
				file.delete();
			} 
			catch (IOException e) {
 
			}
    
		}
		
	}
}