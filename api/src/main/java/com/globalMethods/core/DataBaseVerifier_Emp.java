package com.globalMethods.core;
import java.sql.*;

public class DataBaseVerifier_Emp {

	static ResultSet rs;
	static Statement st;
	static Connection connection;

	public static Connection CreateConnection() throws ClassNotFoundException, SQLException{

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(CommonMethods.propertyfileReader("DbConnectionurl"), CommonMethods.propertyfileReader("db_username"), CommonMethods.propertyfileReader("db_password"));

		return con;
	}

	public static String 	Account_inworker,EmployeePin_inworker,Emp_L_Name_inworker,	Emp_F_Name_inworker,Emp_M_Initial_inworker,Dept_inworker,EmpType_inworker,EmpId_inworker,ncode_inworker,EmpDisc_inworker,EmpEmail_inworker,
	EmpAddr1_inworker,EmpAddr2_inworker,EmpCity_inworker, EmpState_inworker,EmpZip_inworker,EmpPhone_inworker,EmpAltPhone1_inworker,EmpAltPhone2_inworker,	EmpIdCustom1_inworker, EmpIdCustom2_inworker,EmpSocialSec_inworker,Payrate_inworker,EmpHireDate_inworker,EmpEndDate_inworker,EmpbirthDate_inworker,Empgender_inworker,EmpPrILocation_inworker,Status_inworker,
	ProviderId_inworker,SeqID_inworker,EmpAPI_inworker,EmpMgrEmail_inworker;
	public static void DataBaseVerificationEmp(String field, String value, String field2, String value2) throws SQLException

	{
		try
		{
			connection=CreateConnection();
			String query = "select * from inbox.workers where" +" "+ field + "=" +"'" + value + "'" + " and " +  field2 + "=" +"'" + value2 + "'" + " ";
			System.out.println(query);
			
			Thread.sleep(3000);

			// create the java statement

			Statement st = connection.createStatement();
			// execute the query, and get a java resultset
			rs = st.executeQuery(query);

			// iterate through the java resultset


			while (rs.next())
			{

				Account_inworker=rs.getString("account");
				EmployeePin_inworker=rs.getString("stx_id");
				Emp_L_Name_inworker=rs.getString("l_name");
				Emp_F_Name_inworker=rs.getString("F_NAME");
				Emp_M_Initial_inworker=rs.getString("m_initial");
				Dept_inworker=rs.getString("dept");
				EmpType_inworker=rs.getString("w_type");
				EmpId_inworker=rs.getString("att_id");
				ncode_inworker=rs.getString("Error_Code");
				EmpDisc_inworker=rs.getString("discipline");
				EmpEmail_inworker=rs.getString("e_mail");
				EmpAddr1_inworker=rs.getString("addr1");
				EmpAddr2_inworker=rs.getString("addr2");
				EmpCity_inworker=rs.getString("city");
				EmpState_inworker=rs.getString("state");
				EmpZip_inworker=rs.getString("zip_code");
				EmpPhone_inworker=rs.getString("phone");
				EmpAltPhone1_inworker=rs.getString("phone_other1");
				EmpAltPhone2_inworker=rs.getString("phone_other2");
				EmpIdCustom1_inworker=rs.getString("worker_id_custom1");
				EmpIdCustom2_inworker=rs.getString("worker_id_custom2");
				EmpSocialSec_inworker=rs.getString("worker_ssn");
				Payrate_inworker=rs.getString("payrate");
				EmpHireDate_inworker=rs.getString("worker_beg_date");
				EmpEndDate_inworker=rs.getString("worker_end_date");
				EmpbirthDate_inworker=rs.getString("worker_dob");
				Empgender_inworker=rs.getString("worker_dob");
				EmpPrILocation_inworker=rs.getString("worker_primary_location");
				Status_inworker=rs.getString("delete_flag");
				ProviderId_inworker=rs.getString("provider_id");
				SeqID_inworker = rs.getString("worker_version_number");
				EmpAPI_inworker= rs.getString("worker_api");
				EmpMgrEmail_inworker = rs.getString("worker_manager_e_mail");


			}
			st.close();

		}
		// create our mysql database connection
		catch (Exception e)
		{
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}
		finally
		{
			connection.close();
		}


	}

	public static String SeqID_stxworker, ProviderId_stxworker, EmpEndDate_stxworker, EmpHireDate_stxworker, EmpPhone_stxworker, EmpType_stxworker, Dept_stxworker, Emp_M_Initial_stxworker, 
	Emp_F_Name_stxworker, Emp_L_Name_stxworker, EmployeePin_stxworker, WorkerKey_stxworker, Account_stxworker;
	public static void DataBaseVerificationEmp_stx_worker(String field, String value) throws SQLException

	{
		try
		{
			connection=CreateConnection();
			String query = "select * from stx.workers where" +" "+ field + "=" +"'" + value + "'" + " ";

			System.out.println(query);
			
			Thread.sleep(3000);

			// create the java statement

			Statement st = connection.createStatement();
			// execute the query, and get a java resultset
			rs = st.executeQuery(query);

			// iterate through the java resultset


			while (rs.next())
			{

				Account_stxworker=rs.getString("account");
				WorkerKey_stxworker=rs.getString("workerkey");
				EmployeePin_stxworker=rs.getString("stx_id");
				Emp_L_Name_stxworker=rs.getString("l_name");
				Emp_F_Name_stxworker=rs.getString("F_NAME");
				Emp_M_Initial_stxworker=rs.getString("m_initial");
				Dept_stxworker=rs.getString("dept");
				EmpType_stxworker=rs.getString("w_type");
				EmpPhone_stxworker=rs.getString("phonenum");
				EmpHireDate_stxworker=rs.getString("beg_date");
				EmpEndDate_stxworker=rs.getString("end_date");
				ProviderId_stxworker = rs.getString("provider_id");
				SeqID_stxworker = rs.getString("worker_version_number");
			}
			st.close();

		}
		// create our mysql database connection
		catch (Exception e)
		{
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}
		finally
		{
			connection.close();
		}


	}

	public static String UserTypeId_appuser, UserDesc_appuser, UserLName_appuser, UserFName_appuser, UserStatus_appuser, UserPassword_appuser, Username_appuser, UserAccount_appuser, UserID_appuser;
	public static void DataBaseVerificationEmp_app_user(String field, String value) throws SQLException

	{
		try
		{
			connection=CreateConnection();
			String query = "select * from stx.app_users where" +" "+ field + "=" +"'" + value + "'" + " ";
			System.out.println(query);
			Thread.sleep(3000);

			// create the java statement

			Statement st = connection.createStatement();
			// execute the query, and get a java resultset
			rs = st.executeQuery(query);

			// iterate through the java resultset


			while (rs.next())
			{

				UserID_appuser=rs.getString("user_id");
				UserAccount_appuser=rs.getString("account");
				Username_appuser=rs.getString("username");
				UserPassword_appuser=rs.getString("password");
				UserStatus_appuser=rs.getString("account_status");
				UserFName_appuser=rs.getString("user_f_name");
				UserLName_appuser=rs.getString("user_l_name");
				UserDesc_appuser=rs.getString("description");
				UserTypeId_appuser=rs.getString("user_type_id");

			}
			st.close();

		}
		// create our mysql database connection
		catch (Exception e)
		{
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}
		finally
		{
			connection.close();
		}


	}

	public static String id_inauth, start_date_inauth, end_date_inauth, clientidqlf_inauth, clientid_inauth, workerid_inauth,workeridqlf_inauth;
	public static void DataBaseVerificationEmp_inbox_auth(String field, String value) throws SQLException

	{
		try
		{
			connection=CreateConnection();
			String query = "select * from inbox.authorizations where" +" "+ field + "=" +"'" + value + "'" + " ";

			System.out.println(query);
			Thread.sleep(3000);

			
			// create the java statement

			Statement st = connection.createStatement();
			// execute the query, and get a java resultset
			rs = st.executeQuery(query);

			// iterate through the java resultset


			while (rs.next())
			{
				id_inauth = rs.getString("LOC");
				start_date_inauth = rs.getString("beg_date");
				end_date_inauth = rs.getString("end_date");
				workeridqlf_inauth=rs.getString("worker_id_qlfr");
				clientidqlf_inauth=rs.getString("client_id_qlfr");
				clientid_inauth=rs.getString("client_id");
				workerid_inauth=rs.getString("worker_id");

			}
			st.close();

		}
		// create our mysql database connection
		catch (Exception e)
		{
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}
		finally
		{
			connection.close();
		}
	}

	public static String callusername_call;
	public static void DataBaseVerificationcalls(String field, String value) throws SQLException

	{
		try
		{
			connection=CreateConnection();
			String query = "select * from inbox.calls where" +" "+ field + "=" +"'" + value + "'" + " ";

			System.out.println(query);
			Thread.sleep(3000);


			// create the java statement

			Statement st = connection.createStatement();
			// execute the query, and get a java resultset
			rs = st.executeQuery(query);

			// iterate through the java resultset


			while (rs.next())
			{

				callusername_call=rs.getString("Call_username");

			}
			st.close();

		}
		// create our mysql database connection
		catch (Exception e)
		{
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}
		finally
		{
			connection.close();
		}


	}

	public static String Account_stxschedule, EmployeePin_stxschedule, EmployeeID_stxschedule, EmployeePayRate_stxschedule;
	public static void DataBaseVerificationEmp_stx_schedule(String field, String value) throws SQLException

	{
		try
		{
			connection=CreateConnection();
			String query = "select * from stx.schedule where" +" "+ field + "=" +"'" + value + "'" + " ";

			System.out.println(query);
			Thread.sleep(3000);

			
			// create the java statement

			Statement st = connection.createStatement();
			// execute the query, and get a java resultset
			rs = st.executeQuery(query);

			// iterate through the java resultset


			while (rs.next())
			{

				Account_stxschedule=rs.getString("account");
				EmployeePin_stxschedule=rs.getString("stx_id");
				EmployeeID_stxschedule=rs.getString("loc");
				EmployeePayRate_stxschedule=rs.getString("payrate");
		
			}
			st.close();

		}
		// create our mysql database connection
		catch (Exception e)
		{
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}
		finally
		{
			connection.close();
		}


	}

	public static String WorkerKey_stxworker_3P,Staff_L_Name_stxworker_3P,Staff_F_Name_stxworker_3P,StaffSSN_stxworker_3p,Account_stxworker_3P,StaffEndDate_stxworker_3p,StaffHireDate_stxworker_3p,StaffSeqID_stxworker_3p,StaffType_stxworker_3P,Staff_M_Initial_stxworker_3p,Staff_Dept_stxworker_3p;
	public static void DataBaseVerificationEmp_stx_worker_3P(String field, String value) throws SQLException

	{
		try
		{
			connection=CreateConnection();
			String query = "select * from stx.workers where" +" "+ field + "=" +"'" + value + "'" + " ";
			Thread.sleep(3000);

			System.out.println(query);
			// create the java statement

			Statement st = connection.createStatement();
			// execute the query, and get a java resultset
			rs = st.executeQuery(query);

			// iterate through the java resultset


			while (rs.next())
			{

				Account_stxworker_3P=rs.getString("account");
				WorkerKey_stxworker_3P=rs.getString("workerkey");
				Staff_L_Name_stxworker_3P=rs.getString("L_NAME");
				Staff_F_Name_stxworker_3P=rs.getString("F_NAME");
				Staff_M_Initial_stxworker_3p=rs.getString("M_INITIAL");
				Staff_Dept_stxworker_3p=rs.getString("DEPT");
				StaffType_stxworker_3P=rs.getString("W_TYPE");
				StaffSeqID_stxworker_3p = rs.getString("worker_version_number");
				StaffHireDate_stxworker_3p=rs.getString("beg_date");
				StaffEndDate_stxworker_3p=rs.getString("end_date");
				
			}
			st.close();

		}
		// create our mysql database connection
		catch (Exception e)
		{
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}
		finally
		{
			connection.close();
		}


	}

	public static String WorkerKey_stxworker_supp,StaffID_stxworker_supp,EmpSSN_stxworker_supp,EmployeeEndDate_stxworker_supp,EmployeeHireDate_stxworker_supp,StaffSSN_stxworker_supp,EmployeeAdd1_stxworker_supp,EmployeeAdd2_stxworker_supp,StaffCity_stxworker_supp,Account_stxworker_supp;
	public static void DataBaseVerificationEmp_stxworker_supp(String field, String value) throws SQLException

	{
		try
		{
			connection=CreateConnection();
			String query = "select * from stx.workers_supp where" +" "+ field + "=" +"'" + value + "'" + " ";
			Thread.sleep(3000);

			System.out.println(query);
			// create the java statement

			Statement st = connection.createStatement();
			// execute the query, and get a java resultset
			rs = st.executeQuery(query);

			// iterate through the java resultset


			while (rs.next())
			{
				
			//	Account_stxworker_supp=rs.getString("ACCOUNT");
			//	WorkerKey_stxworker_supp=rs.getString("workerkey");
				EmpSSN_stxworker_supp=rs.getString("WORKER_SSN");
				StaffCity_stxworker_supp=rs.getString("CITY");
				StaffSSN_stxworker_supp=rs.getString("WORKER_SSN");
				EmployeeAdd2_stxworker_supp=rs.getString("ADDR2");
				EmployeeAdd1_stxworker_supp=rs.getString("ADDR1");
				EmployeeHireDate_stxworker_supp=rs.getString("worker_beg_date");
				EmployeeEndDate_stxworker_supp=rs.getString("worker_end_date");
				

			}
			st.close();

		}
		// create our mysql database connection
		catch (Exception e)
		{
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}
		finally
		{
			connection.close();
		}


	}
}





