package file;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Connect 
{
  public Connect()
  {
  }
  static public Connection GetConnection(){
	  try
	  {
		 Class.forName("org.apache.hadoop.hive.jdbc.HiveDriver");
		 Connection connect = DriverManager.getConnection("jdbc:hive://master:10000/default", "", "");
		 System.out.println("plz");
		 return (connect);
		  /*
		 Class.forName("com.mysql.jdbc.Driver");
		 Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/expt","root","svsj");
		 return(connect);
		 */
		   
	  }catch(Exception e)
	  {
		  return null;
	  }

  }
}