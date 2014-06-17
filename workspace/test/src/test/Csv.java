package test;
 
import java.io.*;
 
public class Csv {
 
  public static void main(String[] args) {
 
	Csv obj = new Csv();
	obj.run();
 
  }
 
  public void run() {
 
	String csvFile = "/home/sachin/workspace/test/src/test/test_data.csv";
	BufferedReader br = null;
	String line = "";
	String cvsSplitBy = ",";
 
	try {
 
		br = new BufferedReader(new FileReader(csvFile));
		while ((line = br.readLine()) != null) {
 
		        // use comma as separator
			String[] country = line.split(cvsSplitBy);
			for(int k=0;k<country.length;k++)
			{
				System.out.print(country[k]+" ");
			}
			System.out.print("\n");
		}
 
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	} finally {
		if (br != null) {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	System.out.println("Done");
  }
}