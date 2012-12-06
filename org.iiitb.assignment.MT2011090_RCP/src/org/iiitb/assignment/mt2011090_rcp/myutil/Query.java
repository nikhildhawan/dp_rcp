package org.iiitb.assignment.mt2011090_rcp.myutil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Query
{
	private static Connection conn = null;

	private static void getConn()
	{
		conn = DB.getConnection();

	}

	public static ResultSet select(String sqlQuery)
	{
		Statement stmt;
		ResultSet rs;

		try
		{
			if (conn == null)
			{
				getConn();
			}
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlQuery);
			return rs;
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
//			try
//			{
//				conn.close();
//				conn=null;
//			}
//			catch (SQLException e)
//			{
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}
		return null;

	}

	public static int Update(String sqlQuery)
	{
		Statement stmt;
		int result = -1;

		try
		{
			if (conn == null)
			{
				getConn();
			}

			stmt = conn.createStatement();
			Logger.log("Update: " + sqlQuery);
			result = stmt.executeUpdate(sqlQuery);
			return result;
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			try
			{
				conn.close();
				conn = null;
			}
			catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return -1;
	}

	public static int UpdateAutoIncrement(String sqlQuery)
	{
		Statement stmt;
		ResultSet rs;
		int result = -1;

		try
		{

			if (conn == null)
			{
				getConn();
			}
			stmt = conn.createStatement();
			Logger.log("UpdateAutoIncrement: " + sqlQuery);
			stmt.executeUpdate(sqlQuery, Statement.RETURN_GENERATED_KEYS);
			rs = stmt.getGeneratedKeys();
			if (rs.next())
			{
				result = rs.getInt(1);
				Logger.log("New generated AI key is " + result);

			}
			else
			{
				Logger.log("no AI key generated. Possible fatal.");
			}
			return result;
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			try
			{
				conn.close();
				conn = null;
			}
			catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return -1;
	}

	public static String selectStringScalar(String sqlQuery)
	{
		Statement stmt;
		ResultSet rs;

		try
		{
			if (conn == null)
			{
				getConn();
			}
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlQuery);
			if (rs.next())
			{
				return rs.getString(1);
			}
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}

		return null;
	}

}
