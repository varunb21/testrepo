package com.globalMethods.core;

import java.sql.*;

//Done by ravi ranjan
public class DataBaseVerifier_xref {

	public static Connection con;
	public static String id, service, start_date, employee_pin,end_date,ncode,workeridqlf,clientidqlf,clientid,workerid, service1, start_date1, employee_pin1,end_date1;

	public static Connection CreateConnection() throws ClassNotFoundException, SQLException{

			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(CommonMethods.propertyfileReader("DbConnectionurl"), 
					CommonMethods.propertyfileReader("db_username"), CommonMethods.propertyfileReader("db_password"));
		
		return con;
	}

	public static void DataBaseVerificationxref(String field, String value) throws SQLException

	{
		try
		{
			con=CreateConnection();

			String query = "Select * from stx.xref_services where" +" "+ field + "=" +"'" + value + "'" + " ";
			System.out.println(query);
			// create the java statement
			Thread.sleep(3000);

			Statement st = con.createStatement();
			// execute the query, and get a java resultset
			ResultSet rs = st.executeQuery(query);

			// iterate through the java resultset
			while (rs.next())
			{
				id = rs.getString("LOC");
				employee_pin=rs.getString("stx_id");
				start_date = rs.getString("beg_date");
				end_date = rs.getString("end_date");
				service = rs.getString("service");


				// print the results

			}
			st.close();
		}
		catch (Exception e)
		{
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}

		finally
		{
			con.close();
		}


	}

	public static void DataBaseVerificationxref_inbox(String field, String value) throws SQLException

	{
		try
		{
			con=CreateConnection();

			String query = "Select * from inbox.xref_services where" +" "+ field + "=" +"'" + value + "'" + " ";

			// create the java statement
			Thread.sleep(3000);

			
			Statement st = con.createStatement();
			// execute the query, and get a java resultset
			ResultSet rs = st.executeQuery(query);

			// iterate through the java resultset
			while (rs.next())
			{
				id = rs.getString("LOC");
				employee_pin1=rs.getString("stx_id");
				start_date1 = rs.getString("beg_date");
				end_date1 = rs.getString("end_date");
				service1 = rs.getString("service");
				workeridqlf=rs.getString("worker_id_qlfr");
				clientidqlf=rs.getString("client_id_qlfr");
				clientid=rs.getString("client_id");
				workerid=rs.getString("worker_id");

				// print the results

			}
			st.close();
		}
		catch (Exception e)
		{
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}

		finally
		{
			con.close();
		}


	}
}








