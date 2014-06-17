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
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class Database
{
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	//constructor for this class to get connection

	
	//to get the all the data
	public int getlinenum()
	{
		int lines=-1;
		try
		{
			connect = Connect.GetConnection();
			statement = connect.createStatement();
			resultSet = statement.executeQuery("select line from status");
			resultSet.next();
			System.out.println("id "+resultSet.getInt("line"));
			lines=resultSet.getInt("line");
		}
		catch(Exception ex)
		{
			System.out.println(ex);
			System.out.println("Error in getlinenum function");
		}
		finally
		{
			try {
				connect.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return lines;
	}
	public long getsize()
	{
		long size=-1;
		try
		{
			connect = Connect.GetConnection();
			statement = connect.createStatement();
			resultSet = statement.executeQuery("select size from status");
			resultSet.next();
			System.out.println("size "+resultSet.getInt("size"));
			size=resultSet.getLong("size");
		}
		catch(Exception ex)
		{
			System.out.println(ex);
			System.out.println("Error in getsize function");
		}
		finally
		{
			try {
				connect.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return size;
	}
	public int insertlinenum(int linenum)
	{
		int success = 0; 
		try
		{
			connect = Connect.GetConnection();
			statement = connect.createStatement();
			preparedStatement = connect.prepareStatement("update status set line="+linenum+"  ");
			success = preparedStatement.executeUpdate();
		}
		catch(Exception ex)
		{
			System.out.println(ex);
			System.out.println("Error in insertlinenum function");
		}
		finally
		{
			try
			{
				connect.close();
			} 
			catch (SQLException e)
			{
				e.printStackTrace();
				System.out.println("got the second error");
			}
		}
		return success;
	}
	public int setsize(long size)
	{
		int success = 0; 
		try
		{
			connect = Connect.GetConnection();
			statement = connect.createStatement();
			preparedStatement = connect.prepareStatement("update status set size="+size+"  ");
			success = preparedStatement.executeUpdate();
		}
		catch(Exception ex)
		{
			System.out.println(ex);
			System.out.println("Error in setsize function");
		}
		finally
		{
			try
			{
				connect.close();
			} 
			catch (SQLException e)
			{
				e.printStackTrace();
				System.out.println("got the second error");
			}
		}
		return success;
	}
}