package com.globalMethods.core;

import java.sql.*;

public class DataBaseVerifier_Visit {

	static ResultSet rs;
	static Statement st;
	static Connection connection;


	public static Connection CreateConnection() throws ClassNotFoundException, SQLException{

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(CommonMethods.propertyfileReader("DbConnectionurl"), CommonMethods.propertyfileReader("db_username"), CommonMethods.propertyfileReader("db_password"));

		return con;
	}

	public static String Visit_TimeZone_visit,pay_hours_visit,bill_hours_visit, visit_cancel_ind_visit,visit_bill_ind_visit,client_voice_recording_ind_visit,
	client_signature_ind_visit,client_verify_service_ind_visit, client_verify_tasks_ind_visit, client_verify_time_ind_visit, AdjOutDateTime_visit,
	AdjInDateTime_visit, service_visit, clientIDQlfr_visit, ClientOtherID_visit, workerIdQlfr_visit, workerID_visit, visitSeqID_visit, visitID_visit, visitKey_visit,
	ncode_visit,Account_visit;
	public static void DataBaseVerification_Visit(String field1, String value1, String field2, String value2) throws SQLException

	{
		try
		{
			connection=CreateConnection();
			String query = "select * from inbox.visits where" +" "+ field1 + "=" +"'" + value1 + "'" + " "+ "and" + " " + field2 + "=" +"'" + value2 + "'";
			Thread.sleep(3000);

			System.out.println(query);
			// create the java statement

			Statement st = connection.createStatement();
			// execute the query, and get a java resultset
			rs = st.executeQuery(query);

			// iterate through the java resultset


			while (rs.next())
			{

				ncode_visit=rs.getString("error_code");
				
				Account_visit=rs.getString("account");
				visitKey_visit=rs.getString("viskey");
				visitID_visit=rs.getString("visit_id");
				visitSeqID_visit=rs.getString("visit_version_number");
				workerID_visit=rs.getString("worker_id");
				workerIdQlfr_visit=rs.getString("WORKER_ID_QLFR");
				ClientOtherID_visit=rs.getString("client_id");
				clientIDQlfr_visit=rs.getString("CLIENT_ID_QLFR");
				service_visit=rs.getString("service");
				AdjInDateTime_visit=rs.getString("beg_adj_dtime_utc");
				AdjOutDateTime_visit=rs.getString("end_adj_dtime_utc");
				client_verify_time_ind_visit =rs.getString("client_verify_time_ind");
				client_verify_tasks_ind_visit =rs.getString("client_verify_tasks_ind");
				client_verify_service_ind_visit=rs.getString("client_verify_service_ind");
				client_signature_ind_visit=rs.getString("client_signature_ind");
				client_voice_recording_ind_visit=rs.getString("client_voice_recording_ind");
				visit_bill_ind_visit=rs.getString("visit_bill_ind");
				visit_cancel_ind_visit =rs.getString("visit_cancel_ind");
				bill_hours_visit=rs.getString("bill_hours");
				pay_hours_visit =rs.getString("pay_hours");
				Visit_TimeZone_visit=rs.getString("tzname");

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


	public static String ChangeMadeBy_visitChange, ChangeDateTime_visitChange, reasonCodeMemo_visitChange, resolutionCode_visitChange, reasonCode_visitChange, 
	visitSeqID_visitChange, visitKey_visitChange, ncode_visitChange, visitID_visitChange;
	public static void DataBaseVerification_VisitChanges(String field1, String value1,String field2,String value2) throws SQLException

	{
		try
		{
			connection=CreateConnection();
			String query = "select * from inbox.visits_changes where"  +" "+ field1 + "=" +"'" + value1 + "'" + " "+ "and" + " " + field2 + "=" +"'" + value2 + "'";
			Thread.sleep(3000);

			System.out.println(query);
			// create the java statement

			Statement st = connection.createStatement();
			// execute the query, and get a java resultset
			rs = st.executeQuery(query);

			// iterate through the java resultset


			while (rs.next())
			{
				visitID_visitChange=rs.getString("visit_id");
				ncode_visitChange=rs.getString("error_code");
				visitKey_visitChange=rs.getString("viskey");
				visitSeqID_visitChange=rs.getString("visit_version_number");
				reasonCode_visitChange = rs.getString("reason_code");
				resolutionCode_visitChange=rs.getString("resolution_code");
				reasonCodeMemo_visitChange=rs.getString("REASON_CODE_MEMO");
				ChangeDateTime_visitChange=rs.getString("visit_change_dtime_utc");
	//			ChangeMadeBy_visitChange=rs.getString("SID");
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


	public static String longitude_visitCall, latitude_visitCall, callusername_visitCall, CallDateTime_visitCall, service_visitCall, callID_visitCall,
	visitID_visitCall, visitKey_visitCall, ncode_visitCall;
	public static void DataBaseVerification_VisitCalls(String field1, String value1,String field2,String value2) throws SQLException

	{
		try
		{
			connection=CreateConnection();
			String query = "select * from inbox.calls where"  +" "+ field1 + "=" +"'" + value1 + "'" + " "+ "and" + " " + field2 + "=" +"'" + value2 + "'";

			Thread.sleep(3000);


			System.out.println(query);
			// create the java statement

			Statement st = connection.createStatement();
			// execute the query, and get a java resultset
			rs = st.executeQuery(query);

			// iterate through the java resultset


			while (rs.next())
			{

				ncode_visitCall=rs.getString("error_code");
				visitKey_visitCall=rs.getString("viskey");
				visitID_visitCall=rs.getString("visit_id");
				callID_visitCall = rs.getString("call_id");
				service_visitCall = rs.getString("Service");
				CallDateTime_visitCall = rs.getString("call_dtime_utc");
				callusername_visitCall=rs.getString("call_username");
				latitude_visitCall=rs.getString("latitude");
				longitude_visitCall=rs.getString("longitude");

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
	
	public static String exception_id_visitexc, exception_ack_ind_visitexc, SequenceID_visitexc,ncode_visitexc;
	public static void DataBaseVerification_visits_exceptions(String field1, String value1) throws SQLException

	{
		try
		{
			connection=CreateConnection();
			String query = "select * from inbox.visits_exceptions where" +" "+ field1 + "=" +"'" + value1 + "'" + " ";

			System.out.println(query);
			// create the java statement
			Thread.sleep(3000);

			Statement st = connection.createStatement();
			// execute the query, and get a java resultset
			rs = st.executeQuery(query);

			// iterate through the java resultset


			while (rs.next())
			{
				ncode_visitexc=rs.getString("error_code");
				exception_id_visitexc=rs.getString("exception_id");
				exception_ack_ind_visitexc=rs.getString("exception_ack_ind");
				SequenceID_visitexc=rs.getString("SID");
				
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


	public static String ScheduleEndTime_visitSch, ScheduleStartTime_visitSch,endTime_visitSch, startTime_visitSch, clientIDQlfr_visitSch, clientID_visitSch, 
	workerIdQlfr_visitSch, workerID_visitSch, Account_visitSch,service_visitSch, ncode_visitSch;
	public static void DataBaseVerification_VisitSchedule(String field1, String value1, String field2, String value2) throws SQLException

	{
		try
		{
			connection=CreateConnection();
			String query = "select * from inbox.schedule where" +" "+ field1 + "=" +"'" + value1 + "'" + " "+ "and" + " " + field2 + "=" +"'" + value2 + "'";

			System.out.println(query);
			// create the java statement
			Thread.sleep(3000);

			Statement st = connection.createStatement();
			// execute the query, and get a java resultset
			ResultSet rs = st.executeQuery(query);

			// iterate through the java resultset


			while (rs.next())
			{

				ncode_visitSch=rs.getString("error_code");
				Account_visitSch=rs.getString("account");
				workerID_visitSch=rs.getString("worker_id");
				workerIdQlfr_visitSch=rs.getString("WORKER_ID_QLFR");
				clientID_visitSch=rs.getString("client_id");
				clientIDQlfr_visitSch=rs.getString("CLIENT_ID_QLFR");
				service_visitSch=rs.getString("service");
				startTime_visitSch =rs.getString("B_DTIME");
				endTime_visitSch =rs.getString("E_DTIME"); 
				ScheduleStartTime_visitSch =rs.getString("b_dtime");
				ScheduleEndTime_visitSch =rs.getString("e_dtime");
				
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

	public static String ExceptionAcknowledged_visitException,ExceptionID_visitException,ScheduleEndTime_visitException,ScheduleStartTime_visitException,endTime_visitException,
	startTime_visitException,service_visitException, clientIDQlfr_visitException, clientID_visitException,workerIdQlfr_visitException, workerID_visitException, 
	Account_visitException,ncode_visitException;
	public static void DataBaseVerification_Visits_exceptions(String field, String value) throws SQLException

	{
		try
		{
			connection=CreateConnection();
			String query = "select * from inbox.visits_exceptions where" +" "+ field + "=" +"'" + value + "'" + " ";
			System.out.println(query);
			// create the java statement
			Thread.sleep(3000);

			Statement st = connection.createStatement();
			// execute the query, and get a java resultset
			ResultSet rs = st.executeQuery(query);

			// iterate through the java resultset


			while (rs.next())
			{

				ncode_visitException=rs.getString("error_code");
				Account_visitException=rs.getString("account");
				workerID_visitException=rs.getString("worker_id");
				workerIdQlfr_visitException=rs.getString("WORKER_ID_QLFR");
				clientID_visitException=rs.getString("client_id");
				clientIDQlfr_visitException=rs.getString("CLIENT_ID_QLFR");
				service_visitException=rs.getString("service");
				startTime_visitException =rs.getString("B_DTIME");
				endTime_visitException =rs.getString("E_DTIME"); 
				ScheduleStartTime_visitException =rs.getString("b_dtime");
				ScheduleEndTime_visitException =rs.getString("e_dtime");
				ExceptionID_visitException =rs.getString("exception_id");
				ExceptionAcknowledged_visitException =rs.getString("exception_ack_ind");


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

	public static String vistStatus;
	public static void DataBaseVerification_Visits_Status(String Visit_Key) throws SQLException

	{
		try
		{
			connection=CreateConnection();
			String query = "select lib.getvisitstatus_custom("+Visit_Key+") from dual";
			System.out.println(query);
			// create the java statement
			Thread.sleep(3000);

			Statement st = connection.createStatement();
			// execute the query, and get a java resultset
			ResultSet rs = st.executeQuery(query);

			// iterate through the java resultset


			while (rs.next())
			{

				vistStatus=rs.getString("lib.getvisitstatus_custom("+Visit_Key+")");


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




