package com.globalMethods.core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseVerfier_Provider {
	
	public static Connection con;

	public static Connection CreateConnection() throws ClassNotFoundException, SQLException{


		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(CommonMethods.propertyfileReader("DbConnectionurl"), CommonMethods.propertyfileReader("db_username"), CommonMethods.propertyfileReader("db_password"));

		return con;
	}
	
	public static String accounts,user_name,companyname,provider_name,provider_id,address1,address2,city,contact_first_name,
	zipcode,state,contact_last_name,email;
	
	public static void DataBaseVerification_provider( String value) throws SQLException

	{

		try
		{
			con=CreateConnection();
			String query = "select * from stx.accounts where provider_id=" +"'"+ value + "'";
			System.out.println(query);
			Thread.sleep(3000);
			// create the java statement

			Statement st = con.createStatement();
			// execute the query, and get a java resultset
			ResultSet rs = st.executeQuery(query);

			// iterate through the java resultset
			while (rs.next())
			{

				accounts= rs.getString("ACCOUNT");
				user_name=rs.getString("USERNAME");
				companyname=rs.getString("COMPNAME");
				provider_name = rs.getString("PROVIDER_NAME");
				provider_id =rs.getString("PROVIDER_ID");
				address1 = rs.getString("ADDR1");
				address2 = rs.getString("ADDR2");
				city =rs.getString("CITY");
				zipcode= rs.getString("ZIP_CODE");
				state = rs.getString("STATE");
				contact_first_name= rs.getString("CONTACT_F_NAME");
				contact_last_name=rs.getString("CONTACT_L_NAME");
				email= rs.getString("E_MAIL");
				

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
