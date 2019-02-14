package com.globalMethods.core;

import java.sql.*;

public class DataBaseVerifier_Client{

	//Variables to store DB values in inbox.clients table
	public static Connection con;

	public static Connection CreateConnection() throws ClassNotFoundException, SQLException{


		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(CommonMethods.propertyfileReader("DbConnectionurl"), CommonMethods.propertyfileReader("db_username"), CommonMethods.propertyfileReader("db_password"));

		return con;
	}

	public static String id_inClient,ckey_inClient,clientssn_inClient,firstname_inClient ,middleinitial_inClient ,lastname_inClient ,sid_inClient ,DeleteFlag_inClient,
	RecipientIDCustom2_inClient ,RecipientIDCustom1_inClient ,ncode_inClient, Account_inClient, State_inClient,
	City_inClient,ZipCode_inClient,Sex_inClient,MedicaidID_inClient,Email_inClient,County_inClient,MaritalStatus_inClient,	
	Latitude_inClient,Longitude_inClient,DOB_inClient,Addr1_inClient,	Addr2_inClient,	ClientSuffix_inClient,DischargeDate_inClient,	
	PayerID_inClient,caseManager_inClient,	Coordinator_inClient, CoordinatorEmail_inClient,sequenceid_inClient,service_inClient,
	ClientAddressType_inClient,caseManagerEmail_inClient,clientPriority_inClient,clientotherID,	ClientCustomID,	region;

	public static void DataBaseVerification_InboxClient(String field, String value, String field1, String value1) throws SQLException

	{

		try
		{
			con=CreateConnection();
			String query = "select * from inbox.clients where" +" "+ field + "=" +"'" + value + "'" + "and" + " " + field1 + "=" +"'" + value1  +"'" + " ";
			System.out.println(query);
			Thread.sleep(3000);

			Statement st = con.createStatement();
			// execute the query, and get a java resultset
			ResultSet rs = st.executeQuery(query);

			// iterate through the java resultset
			while (rs.next())
			{

				id_inClient= rs.getString("LOC");
				ckey_inClient=rs.getString("CKEY");
				clientssn_inClient=rs.getString("client_ssn");
				firstname_inClient = rs.getString("F_NAME");
				middleinitial_inClient =rs.getString("m_name");
				lastname_inClient = rs.getString("L_name");
				sid_inClient = rs.getString("SID");
				DeleteFlag_inClient =rs.getString("delete_flag");
				RecipientIDCustom2_inClient = rs.getString("client_id_custom2");
				RecipientIDCustom1_inClient = rs.getString("client_id_custom1");
				ncode_inClient = rs.getString("error_code");
				Account_inClient=rs.getString("account");
				State_inClient = rs.getString("state");
				City_inClient = rs.getString("city");
				ZipCode_inClient = rs.getString("zip_code");
				Sex_inClient = rs.getString("sex");
				MedicaidID_inClient = rs.getString("medicaid_id");
				Email_inClient = rs.getString("e_mail");
				County_inClient = rs.getString("county");
				MaritalStatus_inClient = rs.getString("marital_status_code");
				Latitude_inClient = rs.getString("latitude");
				Longitude_inClient = rs.getString("longitude");
				DOB_inClient = rs.getString("DOB");
				Addr1_inClient = rs.getString("addr1");
				Addr2_inClient = rs.getString("addr2");
				ClientSuffix_inClient=rs.getString("name_suffix");
				DischargeDate_inClient = rs.getString("dis_date");
				PayerID_inClient=rs.getString("contract");
				caseManager_inClient=rs.getString("CASE_MANAGER");
				Coordinator_inClient=rs.getString("spv");
				CoordinatorEmail_inClient=rs.getString("spv_e_mail");
				sequenceid_inClient=rs.getString("client_version_number");
				service_inClient=rs.getString("SERVICE");	
				ClientAddressType_inClient=rs.getString("addr_type_qlfr");
				caseManagerEmail_inClient=rs.getString("CASE_MANAGER_E_MAIL");
				clientPriority_inClient = rs.getString("client_priority");
				clientotherID=rs.getString("client_id_custom2");
				ClientCustomID =rs.getString("client_id_custom1");
				region =rs.getString("REGION");

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

	public static String ref_id_iodata, req_id_iodata;

	public static void DataBaseVerification_iodata_ohio(String field, String value) throws SQLException


	{

		try
		{
			con=CreateConnection();
			String query = "select * from iodata.intf_req where intf_req_id =" +"'" + value + "'" ;
			System.out.println(query);
			Thread.sleep(3000);

			// create the java statement

			Statement st = con.createStatement();
			// execute the query, and get a java resultset
			ResultSet rs = st.executeQuery(query);

			// iterate through the java resultset
			while (rs.next())
			{

				ref_id_iodata= rs.getString("intf_req_sk");
				req_id_iodata=rs.getString("intf_req_id");


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

	public static String id_ca,Addr1_CA, Addr2_CA,State_CA, City_CA, ZipCode_CA, County_CA,sequenceid_CA,Latitude_CA, Longitude_CA, ClientAddressType_CA;
	public static void DataBaseVerificationClient_inboxclientsaddress(String field, String value, String field1, String value1) throws SQLException

	{
		try
		{
			con=CreateConnection();
			String query = "select * from inbox.clients_address where" +" "+ field + "=" +"'" + value + "'" + "and" + " " + field1 + "=" +"'" + value1  +"'" + " ";
			System.out.println(query);
			Thread.sleep(3000);


			// create the java statement

			Statement st = con.createStatement();
			// execute the query, and get a java resultset
			ResultSet rs = st.executeQuery(query);

			// iterate through the java resultset
			while (rs.next())
			{
				id_ca= rs.getString("LOC");
				Addr1_CA = rs.getString("addr1");
				Addr2_CA = rs.getString("addr2");
				State_CA = rs.getString("state");
				City_CA = rs.getString("city");
				ZipCode_CA = rs.getString("zip_code");
				County_CA = rs.getString("county");
				Latitude_CA = rs.getString("latitude");
				Longitude_CA = rs.getString("longitude");
				ClientAddressType_CA=rs.getString("addr_type_qlfr");
				sequenceid_CA=rs.getString("client_version_number");

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

	public static String ncode_ClientContact,Email_ClientContact, lastname_ClientContact,Firstname_ClientContact,Addr1_ClientContact,Addr2_ClientContact,
	City_ClientContact,State_ClientContact,ZipCode_ClientContact,PhoneHome_ClientContact,PhoneMobile_ClientContact,
	PhoneOther_ClientContact,phoneBusiness_ClientContact,id_ClientContact,contactTypeCode_ClientContact;
	public static void DataBaseVerification_InboxClientContact(String field1, String value1, String field2, String value2) throws SQLException

	{
		try
		{
			con=CreateConnection();
			String query = "select * from inbox.clients_contact where" +" "+ field1 + "=" +"'" + value1 + "'" + "and" + " " + field2 + "=" +"'" + value2  +"'" + " ";
			Thread.sleep(3000);

			System.out.println(query);

			// create the java statement

			Statement st = con.createStatement();
			// execute the query, and get a java resultset
			ResultSet rs = st.executeQuery(query);

			// iterate through the java resultset
			while (rs.next())
			{

				id_ClientContact = rs.getString("LOC");
				ncode_ClientContact=rs.getString("ERROR_CODE");
				contactTypeCode_ClientContact=rs.getString("CONTACT_TYPE_CODE");
				lastname_ClientContact=rs.getString("L_NAME");
				Firstname_ClientContact=rs.getString("F_NAME");
				Email_ClientContact=rs.getString("E_MAIL");
				Addr1_ClientContact=rs.getString("ADDR1");
				Addr2_ClientContact=rs.getString("ADDR2");
				City_ClientContact=rs.getString("CITY");
				State_ClientContact=rs.getString("STATE");
				ZipCode_ClientContact=rs.getString("ZIP_CODE");
				PhoneHome_ClientContact=rs.getString("PHONENUM_HOME");
				PhoneMobile_ClientContact=rs.getString("PHONENUM_MOBILE");
				PhoneOther_ClientContact=rs.getString("PHONENUM_OTHER");
				phoneBusiness_ClientContact=rs.getString("PHONENUM_BUSINESS");


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

	public static String id_ClientContact_stx,ncode_ClientContact_stx, contactTypeCode_ClientContact_stx, lastname_ClientContact_stx,
	Firstname_ClientContact_stx;
	public static void DataBaseVerification_STXClientContact(String loc, String fname) throws SQLException

	{
		try
		{
			con=CreateConnection();
			String query = "select * from stx.clients_contact where CLIENTKEY in (select CLIENTKEY from stx.clients where LOC =" + "'" +loc + "'" + "and F_NAME =" + "'" +fname + "'" +")";

			System.out.println(query);
			Thread.sleep(3000);

			// create the java statement

			Statement st = con.createStatement();
			// execute the query, and get a java resultset
			ResultSet rs = st.executeQuery(query);

			// iterate through the java resultset
			while (rs.next())
			{

				id_ClientContact_stx = rs.getString("LOC");
				ncode_ClientContact_stx=rs.getString("ERROR_CODE");
				contactTypeCode_ClientContact_stx=rs.getString("CONTACT_TYPE_CODE");
				lastname_ClientContact_stx=rs.getString("L_NAME");
				Firstname_ClientContact_stx=rs.getString("F_NAME");
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
	
	public static String id_providers,sid_providers,ncode_providers,Account_providers,PROVIDERID_providers,PROVIDERIDQLFR_providers,COMPNAME_providers,
	FEDERALID_providers,Addr1_providers,Addr2_providers,City_providers,	State_providers,ZipCode_providers,phonenumber_providers,Email_providers,firstname_providers,
	lastname_providers,payorID_providers,Clienteligiblitydatebegin,Clienteligiblitydateend, providerDBAname_providers,County_providers;

	public static void DataBaseVerificationClient_inbox_clientProviders(String field1, String value1, String field2, String value2) throws SQLException

	{
		try
		{
			con=CreateConnection();
			String query = "select * from inbox.providers where" +" "+ field1 + "=" +"'" + value1 + "'" + " "+ "and" + " " + field2 + "=" +"'" + value2 + "'";
			System.out.println(query);
			Thread.sleep(3000);

			// create the java statement

			Statement st = con.createStatement();
			// execute the query, and get a java resultset
			ResultSet rs = st.executeQuery(query);

			// iterate through the java resultset
			while (rs.next())
			{
				id_providers = rs.getString("LOC");
				sid_providers = rs.getString("SID");
				ncode_providers = rs.getString("error_code");
				Account_providers=rs.getString("account");
				PROVIDERID_providers = rs.getString("PROVIDER_ID");
				PROVIDERIDQLFR_providers = rs.getString("PROVIDER_ID_QLFR");
				COMPNAME_providers = rs.getString("COMPNAME");
				FEDERALID_providers = rs.getString("FEDERAL_ID");
				Addr1_providers = rs.getString("addr1");
				Addr2_providers = rs.getString("addr2");
				City_providers = rs.getString("CITY");
				State_providers = rs.getString("STATE");
				ZipCode_providers = rs.getString("ZIP_CODE");
				phonenumber_providers = rs.getString("PHONE");
				Email_providers = rs.getString("E_MAIL");
				firstname_providers = rs.getString("CONTACT_F_NAME");
				lastname_providers = rs.getString("CONTACT_L_NAME");
				payorID_providers = rs.getString("PAYOR_ID");
				providerDBAname_providers = rs.getString("PROVIDER_DBA_NAME");
				County_providers = rs.getString("county");
				Clienteligiblitydatebegin=rs.getString("BEG_TIME");
				Clienteligiblitydateend=rs.getString("END_TIME");

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

	public static String Account_stxClient,ClientKey_stxClient,clientid_stxClient,sequenceid_stxClient, firstname_stxClient,lastname_stxClient,middlename_stxClient,spv_stxClient,namesuffix_stxClient,begdate_stxClient,enddate_stxClient;

	public static void DataBaseVerification_STXClient(String field1, String value1,String field2, String value2) throws SQLException


	{
		try
		{
			con=CreateConnection();

			String query = "select * from stx.clients where" +" "+ field1 + "=" +"'" + value1 + "'" + "and" + " " + field2 + "=" +"'" + value2  +"'" + " ";

			System.out.println(query);
			Thread.sleep(3000);

			// create the java statement

			Statement st = con.createStatement();
			// execute the query, and get a java resultset
			ResultSet rs = st.executeQuery(query);

			// iterate through the java resultset
			while (rs.next())
			{

				Account_stxClient=rs.getString("ACCOUNT");
				ClientKey_stxClient=rs.getString("CLIENTKEY");
				clientid_stxClient = rs.getString("LOC");
				firstname_stxClient = rs.getString("F_NAME");
				lastname_stxClient = rs.getString("L_Name");
				middlename_stxClient = rs.getString("M_name");
				spv_stxClient = rs.getString("spv");
				namesuffix_stxClient = rs.getString("name_suffix");
				begdate_stxClient= rs.getString("beg_date");
				enddate_stxClient= rs.getString("end_date");
				sequenceid_stxClient=rs.getString("client_version_number");

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

	public static String sid_inboxAni,Account_inboxAni,id_inboxAni,	ClientPhone_inboxAni,Phonetype_inboxAni,DeleteFlag_inboxAni;

	public static void DataBaseVerificationClient_inboxAni(String field1, String value1) throws SQLException

	{
		try
		{
			con=CreateConnection();
			String query = "select * from inbox.ani where" +" "+ field1 + "=" +"'" + value1 + "'";
			System.out.println(query);
			Thread.sleep(3000);

			// create the java statement

			Statement st = con.createStatement();
			// execute the query, and get a java resultset
			ResultSet rs = st.executeQuery(query);

			// iterate through the java resultset
			while (rs.next())
			{
				while (rs.next())
				{
					sid_inboxAni = rs.getString("SID");
					Account_inboxAni=rs.getString("account");
					id_inboxAni = rs.getString("LOC");
					ClientPhone_inboxAni=rs.getString("ani");
					Phonetype_inboxAni=rs.getString("description");
					DeleteFlag_inboxAni =rs.getString("delete_flag");
				}	// print the results

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

	public static String id_auth,clientssn_auth,firstname_auth,lastname_auth ,sid_auth, DeleteFlag_auth,	
	RecipientIDCustom2_auth,RecipientIDCustom1_auth,ncode_auth,Account_auth,State_auth,City_auth,ZipCode_auth,Sex_auth,
	MedicaidID_auth,Email_auth, County_auth,MaritalStatus_auth,Latitude_auth,Longitude_auth, DOB_auth,				
	Addr1_auth,Addr2_auth,ClientSuffix_auth,DischargeDate_auth,PayerID_auth,Coordinator_auth,sequenceid_auth,Phonetype_auth,
	ClientEligibilityDateBegin_auth,ClientEligibilityDateEnd_auth,client_id_auth,client_id_QLFR_auth,worker_id_auth,worker_id_qlfr_auth;

	public static void DataBaseVerificationClient_inbox_authorizations(String field, String value) throws SQLException

	{
		try
		{
			con=CreateConnection();

			String query = "select * from INBOX.authorizations where" +" "+ field + "=" +"'" + value + "'" ;
			System.out.println(query);
			Thread.sleep(3000);

			// create the java statement

			Statement st = con.createStatement();
			// execute the query, and get a java resultset
			ResultSet rs = st.executeQuery(query);

			// iterate through the java resultset
			while (rs.next())
			{
				id_auth = rs.getString("LOC");
				clientssn_auth =rs.getString("client_ssn");
				firstname_auth  = rs.getString("F_NAME");
				lastname_auth  = rs.getString("L_name");
				sid_auth  = rs.getString("SID");
				DeleteFlag_auth  =rs.getString("delete_flag");
				RecipientIDCustom2_auth  = rs.getString("client_id_custom2");
				RecipientIDCustom1_auth  = rs.getString("client_id_custom1");
				ncode_auth  = rs.getString("error_code");
				Account_auth =rs.getString("account");
				State_auth  = rs.getString("state");
				City_auth  = rs.getString("city");
				ZipCode_auth  = rs.getString("zip_code");
				Sex_auth  = rs.getString("sex");
				MedicaidID_auth  = rs.getString("medicaid_id");
				Email_auth  = rs.getString("e_mail");
				County_auth  = rs.getString("county");
				MaritalStatus_auth  = rs.getString("marital_status_code");
				Latitude_auth  = rs.getString("latitude");
				Longitude_auth  = rs.getString("longitude");
				DOB_auth  = rs.getString("DOB");
				Addr1_auth  = rs.getString("addr1");
				Addr2_auth  = rs.getString("addr2");
				ClientSuffix_auth =rs.getString("name_suffix");
				DischargeDate_auth  = rs.getString("dis_date");
				PayerID_auth =rs.getString("payor_id");
				Coordinator_auth =rs.getString("spv");
				sequenceid_auth =rs.getString("client_version_number");
				Phonetype_auth =rs.getString("description");
				ClientEligibilityDateBegin_auth =rs.getString("beg_date");
				ClientEligibilityDateEnd_auth =rs.getString("end_date");
				client_id_auth =rs.getString("client_id");
				client_id_QLFR_auth =rs.getString("client_id_QLFR");
				worker_id_auth     =rs.getString("worker_id");
				worker_id_qlfr_auth           =rs.getString("worker_id_qlfr");


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

	public static String auth_id_authLimit,service_authLimit,program_authLimit, modifier1_authLimit, modifier2_authLimit, 
	modifier3_authLimit,procedurecode_authlimit, modifier4_authLimit, delete_flag_authLimit,auth_limits,day_number,error_code_authLimit,end_time_authLimit;

	public static void DataBaseVerificationClient_inbox_auth_limits(String loc, String payerid) throws SQLException

	{
		try
		{
			con=CreateConnection();

			String query = "select * from inbox.auth_limits where authkey in (select authkey from inbox.authorizations where LOC =" + "'" +loc + "'" + "and payor_id =" + "'" +payerid + "'" +")";
			System.out.println(query);
			Thread.sleep(3000);

			// create the java statement

			Statement st = con.createStatement();
			// execute the query, and get a java resultset
			ResultSet rs = st.executeQuery(query);

			// iterate through the java resultset
			while (rs.next())
			{
				service_authLimit = rs.getString("SERVICE");
				program_authLimit= rs.getString("PROGRAM");
				modifier1_authLimit = rs.getString("MODIFIER1");
				modifier2_authLimit = rs.getString("MODIFIER2");
				modifier3_authLimit = rs.getString("MODIFIER3");
				modifier4_authLimit = rs.getString("MODIFIER4");
				delete_flag_authLimit=rs.getString("DELETE_FLAG");
				error_code_authLimit = rs.getString("ERROR_CODE");
				end_time_authLimit = rs.getString("END_TIME");
				auth_limits=rs.getString("AUTH_LIMIT");
			   day_number=rs.getString("DAY_NUM");
						


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
	
	
	
	public static String authkey,Auth_ref_number,AuthorizationMaximum,auth_start_date,Clientidentifier,provider,auth_limit_maximum,client_id,memo,payor_id,provider_id,provider_id_quelifier;
		public static void DataBaseVerificationClient_inbox_authorization(String loc, String payerid) throws SQLException

		{
			try
			{
				con=CreateConnection();

				String query = "select * from inbox.authorizations where LOC =" + "'" +loc + "'" + "and payor_id =" + "'" +payerid + "'" ;
				System.out.println(query);
				Thread.sleep(3000);

				// create the java statement

				Statement st = con.createStatement();
				// execute the query, and get a java resultset
				ResultSet rs = st.executeQuery(query);

				// iterate through the java resultset
				while (rs.next())
				{
					authkey = rs.getString("AUTHKEY");
					Auth_ref_number= rs.getString("AUTH_REF_NUMBER");
					AuthorizationMaximum = rs.getString("AUTH_LIMIT_MAX");
					Clientidentifier = rs.getString("LOC");
					provider = rs.getString("PROVIDER");
					client_id = rs.getString("CLIENT_ID");
					memo=rs.getString("MEMO");
					payor_id = rs.getString("PAYOR_ID");
					provider_id = rs.getString("PROVIDER_ID");
					provider_id_quelifier=rs.getString("PROVIDER_ID_QLFR");
					auth_limit_maximum=rs.getString("auth_limit_max");
					auth_start_date=rs.getString("BEG_DATE");
							
					


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

	public static String id_inboxXref,sid_inboxXref,ncode_inboxXref,Account_inboxXref,clientIdQualifier_inboxXref,
	workerIdQualifier_inboxXref,workerID_inboxXref,	service_inboxXref,xrefstartdate_inboxXref,xrefEnddate_inboxXref,DeleteFlag_inboxXref;

	public static void DataBaseVerificationClient_inbox_XrefService(String field1, String value1, String field2, String value2) throws SQLException

	{
		try
		{
			con=CreateConnection();
			String query = "select * from inbox.xref_services where" +" "+ field1 + "=" +"'" + value1 + "'" + "and " + field2 + "=" +"'" + value2 + "'";
			System.out.println(query);

			// create the java statement

			Thread.sleep(4000);
			Statement st = con.createStatement();
			// execute the query, and get a java resultset
			ResultSet rs = st.executeQuery(query);

			// iterate through the java resultset
			while (rs.next())
			{
				id_inboxXref = rs.getString("LOC");
				sid_inboxXref = rs.getString("SID");
				ncode_inboxXref = rs.getString("error_code");
				Account_inboxXref=rs.getString("account");
				clientIdQualifier_inboxXref=rs.getString("CLIENT_ID_QLFR");	
				workerIdQualifier_inboxXref=rs.getString("WORKER_ID_QLFR");	
				workerID_inboxXref=rs.getString("WORKER_ID");	
				service_inboxXref=rs.getString("SERVICE");	
				xrefstartdate_inboxXref=rs.getString("BEG_DATE");
				xrefEnddate_inboxXref=rs.getString("END_DATE");
				DeleteFlag_inboxXref=rs.getString("DELETE_FLAG");



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

	public static String id_StxXref,ncode_StxXref,Account_StxXref,service_StxXref,xrefstartdate_StxXref,xrefEnddate_StxXref;

	public static void DataBaseVerificationClient_stx_XrefService(String field1, String value1) throws SQLException

	{

		try
		{
			con=CreateConnection();
			String query = "select * from stx.xref_services where" +" "+ field1 + "=" +"'" + value1 + "'" ;
			System.out.println(query);
			Thread.sleep(3000);

			// create the java statement

			Statement st = con.createStatement();
			// execute the query, and get a java resultset
			ResultSet rs = st.executeQuery(query);

			// iterate through the java resultset
			while (rs.next())
			{

				id_StxXref = rs.getString("LOC");

				Account_StxXref =rs.getString("account");
				service_StxXref =rs.getString("SERVICE");	
				xrefstartdate_StxXref =rs.getString("BEG_DATE");
				xrefEnddate_StxXref =rs.getString("END_DATE");


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

	public static String UserFName_appuser,UserLName_appuser,UserDesc_appuser,UserTypeId_appuser,Deleted_appuser, DesigneeEmail_appuser,
	DesigneeStartDate_appuser,DesigneeEndDate_appuser,UserStatus_appuser ;
	public static void DataBaseVerificationClient_STX_App_User(String field1, String value1, String field2, String value2) throws SQLException

	{
		try
		{
			con=CreateConnection();

			String query = "select * from stx.app_users where" +" "+ field1 + "=" +"'" + value1 + "'" + "and" + " " + field2 + "=" +"'" + value2 +"'" + " ";

			System.out.println(query);
			Thread.sleep(3000);

			//create the java statement

			Statement st = con.createStatement();
			//execute the query, and get a java resultset
			ResultSet rs = st.executeQuery(query);

			//iterate through the java resultset
			while (rs.next())
			{

				UserStatus_appuser=rs.getString("Account_status");
				UserFName_appuser=rs.getString("user_f_name");
				UserLName_appuser=rs.getString("user_l_name");
				UserDesc_appuser=rs.getString("description");
				DesigneeStartDate_appuser = rs.getString("insert_tmstp");
				DesigneeEndDate_appuser = rs.getString("expire_date");
				UserTypeId_appuser=rs.getString("user_type_id");	
				Deleted_appuser = rs.getString("deleted");
				DesigneeEmail_appuser = rs.getString("username");

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

	public static String Latitude_stxClientSupp, Longitude_stxClientSupp,PatientState_stxClientSupp,PatientZip_stxClientSupp,clientkey_stxClientSupp,PatientCity_stxClientSupp,PatientAddLine1_stxClientSupp,PatientAddLine2_stxClientSupp;
	public static void DataBaseVerification_STXClient_Supp(String field, String value) throws SQLException


	{
		try
		{
			con=CreateConnection();

			String query = "select * from stx.clients c, stx.clients_supp p where c.clientkey=p.clientkey and c."  + field + "="  + value ; 

			System.out.println(query);
			Thread.sleep(3000);

			// create the java statement

			Statement st = con.createStatement();
			// execute the query, and get a java resultset
			ResultSet rs = st.executeQuery(query);

			// iterate through the java resultset
			while (rs.next())
			{

				Latitude_stxClientSupp = rs.getString("LATITUDE");
				if (rs.wasNull()) {
					Latitude_stxClientSupp = "";
				}
				Longitude_stxClientSupp = rs.getString("LONGITUDE");
				if (rs.wasNull()) {
					Longitude_stxClientSupp = ""; 
				}
				clientkey_stxClientSupp = rs.getString("CLIENTKEY");
				PatientAddLine1_stxClientSupp=rs.getString("ADDR1");
				PatientAddLine2_stxClientSupp=rs.getString("ADDR2");
				PatientCity_stxClientSupp=rs.getString("CITY");
				PatientState_stxClientSupp=rs.getString("STATE");
				PatientZip_stxClientSupp=rs.getString("ZIP_CODE");

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

	public static String UserFName_inappuser,UserLName_inappuser,UserDesc_inappuser,UserTypeId_inappuser,Deleted_inappuser, DesigneeEmail_inappuser,
	DesigneeStartDate_inappuser,DesigneeEndDate_inappuser,UserStatus_inappuser,ncode_inappuser ;
	public static void DataBaseVerificationClient_Inbox_App_User(String field1, String value1, String field2, String value2) throws SQLException

	{
		try
		{
			con=CreateConnection();

			String query = "select * from inbox.app_users where" +" "+ field1 + "=" +"'" + value1 + "'" + "and" + " " + field2 + "=" +"'" + value2 +"'" + " ";

			System.out.println(query);
			Thread.sleep(3000);

			//create the java statement

			Statement st = con.createStatement();
			//execute the query, and get a java resultset
			ResultSet rs = st.executeQuery(query);

			//iterate through the java resultset
			while (rs.next())
			{

				
				UserStatus_inappuser=rs.getString("Account");


				UserStatus_inappuser=rs.getString("account_status");
				UserFName_inappuser=rs.getString("user_f_name");
				UserLName_inappuser=rs.getString("user_l_name");
				UserDesc_inappuser=rs.getString("description");
				DesigneeEmail_inappuser = rs.getString("username");
				DesigneeStartDate_inappuser = rs.getString("insert_tmstp");
				DesigneeEndDate_inappuser = rs.getString("expire_date");
				ncode_inappuser = rs.getString("error_code");
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




