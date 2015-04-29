import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;


public class FileFixer {
	public static void main(String[] args){
		try{
			for(int i = 0; i <= 1; i++){
				BufferedReader br = new BufferedReader(new FileReader(args[i]));
				StringBuilder sb = new StringBuilder();
				String line = br.readLine();
				String newString;
				String[] sArr;
				while(line != null){
					sArr = line.split("#");
					
					if(sArr != null && sArr.length != 0){
						newString = sArr[0];
						newString = newString.replaceAll("\\s+", " ");
						sb.append(newString);
					}
					else{
						sb.append(line);
					}
					sb.append(System.lineSeparator());
					line = br.readLine();
				}
				String everything = sb.toString();
				PrintWriter out = new PrintWriter("results" + i + ".asm");
				out.println(everything);
				
				out.close();
				br.close();
			}
			
		}
		catch(FileNotFoundException e){
			System.err.println(e);
		}
		catch(IOException e){
			System.err.println(e);
		}
		
		System.out.println("FINISHED.");
	}
}
