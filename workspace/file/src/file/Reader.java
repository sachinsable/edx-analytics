package file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;

public class Reader {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Reader reader = new Reader();
		reader.readfile();

	}
	
	public void readfile()
	{
		String path="/home/sachin/workspace/file/src/file/foo.txt";
		File flen = new File(path);
		long l = flen.length();
		System.out.println("current size"+l);
		FileReader fr;
		try {
			Database db = new Database();
			
			fr = new FileReader(path);
			BufferedReader textReader = new BufferedReader(fr);
			
			String line;
			int linenum=db.getlinenum();
			long ol=db.getsize();
			
			if(l>ol)
			{
				db.setsize(l);
	
				try
				{
					int i=1;
					while((line=textReader.readLine())!=null)
					{
						if(i>linenum)
						{
							System.out.println(line);
							linenum++;
						}
						i++;
					}
					System.out.println(db.insertlinenum(linenum)+" "+linenum+" "+db.getsize());
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
				finally
				{
					try
					{
						textReader.close();
					}
					catch (IOException e)
					{
						e.printStackTrace();
					}
				}
			}
			else if(l==ol)
			{
				System.out.println("File is not changed");
			}
			else
			{
				System.out.println("file might have been archived");
			}
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
	}

}
