
package com.globalMethods.core;


public class globalVariables {


	//################################# Client Table Config File  #######################################




	public static String ClientSuffix = "ClientSuffix";
	public static String RecipientIDCustom2 = "RecipientIDCustom2";
	public static String RecipientIDCustom1 = "RecipientIDCustom1";
	public static String PatientZip="PatientZip";

	//-------------------config properties-------------------------------
	public static String altevv_clients="altevv_clients"; 
	public static String altevv_emp="altevv_emp";
	public static String openevv_client_url="clients";
	public static String ohio_patient="ohio_patient";
	public static String ohio_worker_url="ohio_worker";
	public static String openevv_xref_url="Xref";
	public static String visit_intake="visit_intake";
	public static String member_post_url= "openevv_member";
	public static String openevv_emp_url= "create_employee";

	public static String visit="visit";
	public static String EmployeeIdentifier= "EmployeeIdentifier";
	public static String EmployeeBirthDate="EmployeeBirthDate";

	public static String ExceptionIDjson="ExceptionID";
	public static String ExpID="ExpID";



	public static String ClientMedicaidID = "ClientMedicaidID";
	public static String ClientIDQualifier= "ClientIDQualifier";





	//------------------JSON File name Reading----------
	public static String client_intake="client_intake";
	public static String client_openevv="client";
	public static String client_intake_req_blank = "client_intake_req_fields_blank";
	public static String client_intake_req_missing = "client_intake_req_fields_missing";
	public static String Staff_intake="Staff_intake";
	public static String openevv_member_json="Member";
	public static String visitjson= "visit_intake";
	public static String openevv_emp_json= "employee";
	public static String client_3p_json="client_3p";
	public static String worker_3P_json="worker";
	public static String xref_json="xref";
	public static String openevv_emp_req_json= "employee_RequiredField";


	// -------------------JSON Object name identification ----------------------------------------
	public static String clientDesigneeEmail ="ClientDesigneeEmail";
	public static String clientEmailAddress ="ClientEmailAddress";
	public static String ClientTimezone="ClientTimezone";
	public static String ProcedureCode="ProcedureCode";
	public static String AdjInDateTime="AdjInDateTime";
	public static String AdjOutDateTime="AdjOutDateTime";
	public static String ChangeDateTime="ChangeDateTime";
	public static String Action="Action";
	public static String ClientTimeZone="ClientTimeZone";
	public static String ClientPhone="ClientPhone";
	public static String ClientSecondaryDiagnosisCode="ClientSecondaryDiagnosisCode";
	public static String ClientPrimaryDiagnosisCode="ClientPrimaryDiagnosisCode";
	public static String diagnosis_code="diagnosis_code";
	public static String description="description";
	public static String ClientFirstName="ClientFirstName";
	
	public static String ClientState = "ClientState";
	public static String Client_Payer_Information1="Client_Payer_Information";
	public static String ClientEligibilityDateBegin1="ClientEligibilityDateBegin";
	public static String ClientEligibilityDateEnd="END_TIME";
	public static String ClientStatus1="ClientStatus";
	public static String ClientOtherID="ClientOtherID";
	public static String EmployeeQualifier="EmployeeQualifier";
	public static String EmployeeOtherID="EmployeeOtherID";
	public static String VisitOtherID="VisitOtherID";

	//ClientResponsibleparty subsection
	public static String ClientResponsibleParty= "ClientResponsibleParty";
	public static String ClientContactType= "ClientContactType";
	public static String ClientContactPhone="ClientContactPhone";
	public static String ClientContactPhoneType="ClientContactPhoneType";
	public static String ClientContactState = "ClientContactState";
	public static String clientContactFirstName  ="ClientContactFirstName";
	public static String clientContactLastName  ="ClientContactLastName";
	public static String ClientContactZip="ClientContactZip";
	public static String ClientIdentifier="ClientIdentifier";
	

	//Provider identification
	public static String ProviderQualifier = "ProviderQualifier";
	public static String ProviderIdentification = "ProviderIdentification";
	public static String ClientEligibilityDateBegin="ClientEligibilityDateBegin";
	public static String ClientStatus="ClientStatus";
	public static String addressArrayjson ="ClientAddress";
	public static String Addressjson="Address";
	public static String ClientAddressType="ClientAddressType";
	public static String ClientCounty="ClientCounty";
	public static String ClientAddressLongitude ="ClientLongitude";
	public static String ClientAddressLatitude ="ClientLatitude";

	public static String jsonProcedureCode1   ="ProcedureCode";
	public static String ProviderID   ="ProviderID";

	public static String ClientContactCity ="ClientContactCity";
	

	public static String Account="Account";
	public static String ClientDesigneeFirstName="ClientDesigneeFirstName";
	public static String ClientDesigneeLastName="ClientDesigneeLastName";
	public static String ClientDesigneeStartDate="ClientDesigneeStartDate";
	public static String ClientDesigneeEndDate="ClientDesigneeEndDate";
	public static String ClientID="ClientID";
	public static String XRefStartDate="XRefStartDate";
	public static String account_status="account_status";
	public static String ClientSSN="ClientSSN";
	public static String clientSSN="ClientSSN";
	public static String PayerID="PayerID";
	public static String Client_Payer_Information="ClientPayerInformation";
	public static String PayerProgram="PayerProgram";
	public static String ClientZip="ClientZip";
	public static String addressType="ClientAddressType";
	public static String PayRate="PayRate";
	public static String ClientPhoneType="ClientPhoneType";
	public static String DesigneeEmail="ClientDesigneeEmail";
	public static String dischargeDate ="DischargeDate";
	public static String jsonStatus ="Status";
	public static String ContactAddressLine1 ="ContactAddressLine1";
	public static String ContactCity="ContactCity";
	public static String ClientQualifier="ClientQualifier";

	public static String dbClientAddressType="addr_type_qlfr";
	public static String ClientAddressLine1="ClientAddressLine1";
	public static String ClientCity="ClientCity";
	public static String ClientAddressLine2 = "ClientAddressLine2";
	public static String ClientLastName="ClientLastName";
	public static String EmpFName = "EmployeeFirstName";
	public static String EmpLName = "EmployeeLastName";
	public static String EmpSSN = "EmployeeSSN";
	public static String EmployeePIN= "EmployeePIN";
	public static String EmployeeHireDate="EmployeeHireDate";
	public static String EmployeeEndDate="EmployeeEndDate";

	// -------------------JSON error message identification ----------------------------------------

	public static String ClientTimezonesizeerror="The ClientTimezone value is incorrect. The length should be between 1 and 64.";
	public static String ClientTimezonenullerror="The ClientTimezone cannot be null";
	public static String AdjInOutDateTime_Error="ERROR: The AdjInDateTime cannot be greater than AdjOutDateTime.";
	public static String EmployeePINlengtherror="The EmployeePIN value is incorrect. The length should be between 4 and 9.";
	public static String EmployeePINformaterror="The EmployeePIN format is incorrect.";
	public static String EmployeePINnullerror="The EmployeePIN cannot be null.";
	public static String EmployeeHireDateformaterror="ERROR: The EmployeeHireDate expected format is not correct.";
	public static String AdjInOutDateTime_format="The record is being rejected.";
	public static String MobileLoginFormatError = "ERROR: The MobileLogin value is incorrect. The length should be between 1 and 64. The record is being rejected.";
	public static String XRefStartDateformaterror= "ERROR: The XRefStartDate format is incorrect.";
	public static String ClientContactFirstName_error="The ClientContactFirstName length is invalid. The length should be between 0 and 30.";
	public static String ClientCity_error="The ClientCity value will be truncated to 30 characters. The length should be between 1 and 30.";
	public static String ClientCity_nullerror="The ClientCity cannot be null.";
	public static String ClientCityLengthError="";
	public static String ClientCityformatError="";
	public static String ContactZipLengthError="";
	public static String ClientDesigneeStartDateformaterror="ERROR: The ClientDesigneeStartDate format is incorrect.";
	public static String ClientZipnullError="ERROR: The ClientZip cannot be null.";
	public static String ContactZipformatError="ERROR: The ContactZip format is incorrect.";
	public static String ClientZipformatError="ERROR: The ClientZip format is incorrect.";
	public static String ClientZiplengthError="ERROR: The ClientZip length is invalid. The length should be between 1 and 10.";
	public static String ClientContactPhoneTypeformat="ERROR: The ClientContactPhoneType format is incorrect.";
	public static String ClientContactPhoneTypelength="ERROR: The ClientContactPhoneType length is invalid. The length should be between 0 and 12.";
	public static String ClientPhoneTypenullerror="";
	public static String PatientPhoneNumberformaterror="The PatientPhoneNumber format is incorrect.";
	public static String PatientPhoneNumbernullerror="The PatientPhoneNumber cannot be null.";
	public static String PatientResponsiblePartyFirstNamelengtherror="The PatientResponsiblePartyFirstName value will be truncated to 30 characters.";
	public static String PatientResponsiblePartyFirstNamenullerror="The PatientResponsiblePartyFirstName cannot be null.";
	public static String PatientResponsiblePartyLastNamelengtherror="The PatientResponsiblePartyLastName value will be truncated to 30 characters.";
	public static String PatientResponsiblePartyLastNamenullerror="The PatientResponsiblePartyLastName cannot be null.";
	public static String EmployeePINQualifiererror="The EmployeePINQualifier format is incorrect.";
	public static String ClientDesigneeEndDateformaterror="ERROR: The ClientDesigneeEndDate format is incorrect.";
	public static String ClientCity_error_message="WARNING: The ClientCity format is incorrect.";
	public static String ClientCity_error_size="WARNING: The ClientCity value will be truncated to 30 characters. The length should be between 1 and 30.";
	public static String ClientContactFirstNamelength="ERROR: The ClientContactFirstName length is invalid. The length should be between 0 and 30.";
	public static String longitudeMinError11            ="The ClientAddressLongitude value cannot be less than -180.";
	public static String longitudeMaxError11            ="The ClientAddressLongitude value cannot be greater than 180.";
	public static String longitudeMaxErrorLength       ="ERROR: The CallLongitude value cannot be greater than 180.";
	public static String longitudeMinErrorLength       ="ERROR: The CallLongitude value cannot be greater than 180.";
	public static String longitudeNull11            ="ERROR: The ClientAddressLongitude cannot be null.";
	public static String longitudeNullvisit            ="ERROR: The CallLongitude cannot be null. The record is being rejected.";
	public static String ClientSecondaryDiagnosisCode_format_error="ERROR: The ClientSecondaryDiagnosisCode format is incorrect.";
	public static String ClientSecondaryDiagnosisCode_length_error="ERROR: The ClientSecondaryDiagnosisCode length is invalid. The length should be between 1 and 10.";
	public static String ClientPrimaryDiagnosisCode_format="ERROR: The ClientPrimaryDiagnosisCode format is incorrect.";
	public static String ClientPrimaryDiagnosisCode_length="ERROR: The ClientPrimaryDiagnosisCode length is invalid. The length should be between 1 and 10.";
	public static String PayerProgramError = "ERROR: The PayerProgram value is incorrect. The length should be between 1 and 9.";
	public static String latitudeMinError11            ="The ClientAddressLatitude value cannot be less than -90.";
	public static String latitudeMaxError11            ="The ClientAddressLatitude value cannot be greater than 90.";
	public static String latitudeNull11            ="ERROR: The ClientAddressLatitude cannot be null.";
	public static String XRefEndDateformat = "ERROR: The XRefEndDate cannot be less than XRefStartDate.";
	public static String longitudeMinError            ="The ClientAddressLongitude value cannot be less than -180.";
	public static String longitudeMaxError            ="The ClientAddressLongitude value cannot be greater than 180.";
	public static String longitudeNull            ="ERROR: The ClientAddressLongitude cannot be null.";

	public static String latitudeMinError            ="The ClientAddressLatitude value cannot be less than -90.";
	public static String latitudeMaxError            ="The ClientAddressLatitude value cannot be greater than 90.";
	public static String latitudeNull            ="ERROR: The ClientAddressLatitude cannot be null.";
	public static String Payeridnullerror="The PayerID cannot be null.";
	public static String payerprogramerror="The PayerProgram can not be null or empty.";
	public static String payerserviceerror="The PayerService can not be null or empty.";
	public static String payerprogramerror_altevv="The PayerProgram cannot be null.";

	public static String clientContactFirstNameSizeerror    ="The ClientContactFirstName (Responsible Party) value will be truncated to 30 characters. The length should be between 1 and 30.";
	public static String clientContacLastNameSizeerror    ="The ClientContactLastName (Responsible Party) value will be truncated to 30 characters. The length should be between 1 and 30.";
	public static String clientContacLastNameFormaterror="The ClientContactLastName (Responsible Party) format is incorrect. The record should satisfy this regular expression";
	public static String clientContacFirstNameFormaterror="The ClientContactFirstName (Responsible Party) format is incorrect. The record should satisfy this regular expression";
	public static String clientContacFirstNameFormat= "ERROR: The ClientContactFirstName format is incorrect.";
	public static String ClientMedicaidIDformaterror= "ERROR: The ClientMedicaidID format is incorrect.";
	public static String ClientQualifierLengthError = "The ClientQualifier value is incorrect. The length should be between 1 and 20.";
	public static String ClientQualifierFormatError = "The ClientQualifier format is incorrect.";
	public static String EmployeeQualifierFormatError = "The EmployeeQualifier format is incorrect.";
	public static String ClientQualifierNullError = "The ClientQualifier cannot be null.";
	public static String ClientID_Error="ERROR: The ClientID cannot be null. The record is being rejected.";
	public static String ClientIdentifier_Error="ERROR: The ClientIdentifier cannot be null. The record is being rejected.";
	public static String PayRatelengthError="ERROR: The PayRate value exceeds the maximum length of 5 characters.  The record is being rejected. The length should be between 1 and 5.";
	public static String MissingMedicaidIDLengthError = "The MissingMedicaidID value is incorrect. The length should be between 1 and 5.";
	public static String MissingMedicaidIDFormatError = "The MissingMedicaidID format is incorrect.";

	public static String ClientStatus_error_format = "The ClientStatus format is incorrect";
	public static String XRefClientStatuslengtherror= "ERROR: The ClientStatus value is incorrect. The length should be between 2 and 2.";
	public static String clientAddressTypeFormaterror1="WARNING: The ClientAddressType format is incorrect.";
	public static String clientAddressTypeFormat="ERROR: The ClientAddressType format is incorrect.";

	public static String ClientAddress= "ClientAddress";

	public static String ClientStateNullError="The ClientState cannot be null.";
	public static String ClientStateFormatError="The ClientState format is incorrect.";
	public static String ClientStateFormatError_alt="ERROR: The ClientContactState (Responsible Party) format is incorrect. The record should satisfy this regular expression";
	public static String ClientStateLengthError="The ClientState length is invalid. The length should be between 2 and 2.";
	public static String ClientStateLengthError_alt="ERROR: The ClientContactState (Responsible Party) value is incorrect. The length should be between 2 and 2.";
	public static String ClientContactStateLengthError= "The ClientContactState length is invalid. The length should be between 2 and 2.";
	public static String provider_ID_Error_length="The ProviderID (Client) value will be truncated to 50 characters. The length should be between 1 and 50.";
	public static String provider_ID_Error_format="The ProviderID (Client) cannot be null.";
	public static String provideridvalueerror="The ProviderID value is incorrect.";
	public static String provideridformaterror="The ProviderID format is incorrect.";
	public static String provideridformatnullerror="The ProviderID cannot be null.";
	public static String ProviderIDNullerror="ERROR: The ProviderID cannot be NULL.";
	public static String ClientZipFormatError1= "The ClientZip format is incorrect. The record should satisfy this regular expression";
	public static String ClientPhoneType_Error_length="WARNING: The ClientPhoneType format is incorrect.";
	public static String ClientPhoneType_Error="ERROR: The ClientPhoneType format is incorrect.";
	public static String payerIdFormatError="ERROR: The PayerID cannot be null.";
	public static String payerIdSizeError="ERROR: The PayerID value is incorrect. The length should be between 1 and 64.";
	public static String payerProgramFormatError="ERROR: The PayerProgram format is incorrect. ";
	public static String payerProgramSizeError="ERROR: The PayerProgram value is incorrect. The length should be between 1 and 9.";
	public static String ClientQualifierError="ERROR: The ClientIDQualifier cannot be null. The record is being rejected.";
	public static String EmployeeIdentifier_Error="ERROR: The EmployeeIdentifier cannot be null. The record is being rejected.";
	public static String EmployeeQualifier_Error="ERROR: The EmployeeQualifier cannot be NULL. The record is being rejected.";
	public static String ClientIdentifierQualifier_Error="ERROR: The ClientIDQualifier cannot be null. The record is being rejected.";
	public static String ClientPhoneTypeerror="The ClientContactPhoneType format is incorrect.";
	public static String PayRateError = "ERROR: The PayRate value exceeds the maximum length of 5 characters.  The record is being rejected. The length should be between 1 and 5.";
	public static String ClientContactCityLengthError="ERROR: The ClientContactCity value is incorrect. The length should be between 1 and 30.";
	public static String ClientContactCityFormatError= "ERROR: The ClientContactCity format is incorrect.";

	public static String ClientContactCityLengthError_alt="ERROR: The ClientContactCity (Responsible Party) value is incorrect. The length should be between 1 and 30.";
	public static String ClientContactCityFormatError_alt= "ERROR: The ClientContactCity (Responsible Party) format is incorrect.";

	public static String ClientContactCityFormatError_mem= "ERROR: The ClientContactCity format is incorrect.";
	public static String ClientEligibilityDateBeginerror= "The ClientEligibilityDateBegin format is incorrect.";
	
	public static String ClientEligibilityDateBeginformaterror="The ClientEligibilityDateEnd must be after ClientEligibilityDateBegin";
	public static String ClientEligibilityDateEnderror1= "The ClientEligibilityDateEnd format is incorrect.";
	public static String ClientCountyLengthError = "The ClientCounty value will be truncated to 25 characters. The length should be between 1 and 25.";
	public static String ClientCountyFormatError = "The ClientCounty format is incorrect.";
	public static String ClientCountyLength = "ERROR: The ClientCounty length is invalid. The length should be between 1 and 25.";
	public static String ClientAddressLine2LengthError = "ERROR: The ClientAddressLine2 length is invalid. The length should be between 0 and 30.";
	public static String ClientAddressLine2FormatError = "The ClientAddressLine2 format is incorrect.";
	public static String ContactAddressLine1LengthError   ="ERROR: The ContactAddressLine1 length is invalid. The length should be between 0 and 30.";
	public static String ContactAddressLine1FormatError ="ERROR: The ContactAddressLine1 format is incorrect.";
	public static String clientAddressTypeFormaterror="ERROR: The ClientAddressType format is incorrect. The record should satisfy this regular expression";                                       
	public static String ClientZipFormatError= "The ClientZip format is incorrect. The record should satisfy this regular expression";
	public static String ClientIDFormatError =	"The ClientID format is incorrect.";
	public static String AdjOutCallInDateTime_Error="";
	public static String EmployeeDetails_Error="ERROR: The EmployeeQualifier cannot be NULL. The record is being rejected.";

	public static String MaxExceedlength_error="The record is being rejected.";
	public static String ClientIdentifierlength_Error="ERROR: The ClientIdentifier cannot be null. The record is being rejected.";
	public static String XRefEndDateformaterror="ERROR: The XRefEndDate format is incorrect.";
	public static String XRefClientStatusformaterror= "ERROR: The ClientStatus format is incorrect.";


	public static String ClientContactZipFormatError="The ClientContactZip format is incorrect.";
	public static String ClientContactZipFormatError_alt="ERROR: The ClientContactZip (Responsible Party) format is incorrect.";

	public static String ClientContactZipLengthError="The ClientContactZip length is invalid. The length should be between 1 and 9.";

	public static String ClientContactZipNullError="The ClientContactZip cannot be null.";
	public static String ClientContactZipLengthError_alt="ERROR: The ClientContactZip (Responsible Party) value is incorrect. The length should be between 1 and 9";
	public static String ClientContactZipNullError_alt="The ClientContactZip cannot be null.";


	public static String ClientIDNullError = "The ClientID cannot be null.";
	public static String ClientIdentifiernullerror= "The ClientIdentifier cannot be null.";
	public static String ClientIdentifierformat="The ClientIdentifier format is incorrect";
	public static String ClientIdentifiervalueerror= "The ClientIdentifier value is incorrect.";

	public static String ClientZipSizeError="ERROR: The ClientZip length is invalid. The length should be between 1 and 9.";
	public static String ClientZipNullError="The ClientZip cannot be null.";

	public static String ClientContactTypeFormatError= "The ClientContactType (Responsible Party) format is not correct.";
	public static String EmployeeBirthDateformaterror="";
	public static String ClientSSNFormatError = "The ClientSSN format is incorrect.";
	public static String EmployeeBirthDatefuture="ERROR: The EmployeeBirthDate expected value is not correct. The record should be in the past. The record is being rejected.";
	public static String EmpFNameLengthError="The EmployeeFirstName the length should be between 1 and 30.";
	public static String EmpLNameLengthError="The EmployeeLastName the length should be between 1 and 30.";
	public static String EmpFNameNullError="The EmployeeFirstName cannot be NULL.";
	public static String EmpFNameFormatError = "The EmployeeFirstName format is incorrect.";
	public static String ClientdesigneeLastNameerror= "The ClientDesigneeLastName format is incorrect.";
	public static String ClientdesigneeFirstNameerror= "The ClientDesigneeFirstName format is incorrect.";
	public static String Clientcustomiderror="The ClientCustomID format is incorrect.";
	public static String clientcontactZiperror="ERROR: The ClientContactZip format is incorrect.";
	public static String ClientcontactZiperror1="ERROR: The ClientContactZip length is invalid.";
	public static String ClientContactTypeerror="The ClientContactType format is incorrect.";
	public static String ClientContactStateerror="The ClientContactState format is incorrect.";
	public static String ClientContactStateerror1="The ClientContactState length is invalid.";
	public static String ClientContactPhoneTypeFormatError="ERROR: The ClientContactPhoneType (Responsible Party) format is incorrect.";
	public static String ClientContactPhoneTypeFormatError_mem="ERROR: The ClientContactPhoneType format is incorrect.";
	public static String ClientContactPhoneerror="The ClientContactPhone format is incorrect.";
	public static String ClientContactLastNameerror="The ClientContactLastName format is incorrect";
	public static String AuthorizationServiceIDerror="The AuthorizationServiceID cannot be null.";
	public static String AuthorizationServiceIDvalueeerror="The AuthorizationServiceID value is incorrect. The length should be between 1 and 5.";
	public static String ClientContactLastNamelengtherror="The ClientContactLastName length is invalid.";
	public static String AuthorizationServiceIDformateerror="The AuthorizationServiceID format is incorrect.";
	public static String Authorizationrequirederror="The AuthorizationLimit required if this Authorization Limits section is provided.";
	public static String ClientContactFirstNameerror="The ClientContactFirstName format is incorrect.";
	public static String ClientDiagnosisCodeformaterror="The ClientDiagnosisCode format is incorrect.";
	public static String Authorizationweekstarterror="The AuthorizationWeekStart format is incorrect.";
	public static String AuthorizationLimitEndTimeerror="The AuthorizationLimitEndTime format is incorrect.";
	public static String AuthorizationLimitStartTimeerror="The AuthorizationLimitStartTime format is incorrect";
	public static String AuthorizationLimitDayOfWeekerror="The AuthorizationLimitDayOfWeek format is incorrect.";
	public static String AuthorizationLimitDayOfWeekrequirederror="The AuthorizationLimitDayOfWeek is required if AuthorizationLimitType is D";
	public static String Authorizationweekstartinvaliderror="The AuthorizationWeekStart is required if AuthorizationLimitType is W.";
	public static String ClientContactFirstNamelengtherror="The ClientContactFirstName length is invalid.";
	public static String ClientContactCityerror="The ClientContactCity format is incorrect.";
	public static String ClientContactCitylengtherror="The ClientContactCity length is invalid.";
	public static String Actionerror="The Action format is incorrect."; 
	public static String AuthorizationReferenceNumbenullrerror="The AuthorizationReferenceNumber cannot be null.";
	public static String AuthorizationReferenceNumberformateerror="The AuthorizationReferenceNumber format is incorrect.";
	public static String Actionelengthrror="The Action length is invalid."; 
	public static String ClientContactPhonelengtherror="The ClientContactPhone format is incorrect.";
	public static String ClientdesigneeFirstNamelengtherror= "The ClientDesigneeFirstName length is invalid.";
	public static String ClientdesigneeLastNamelengtherror= "The ClientDesigneeLastName length is invalid.";
	public static String ClientDesigneeEmaillengtherror= "The ClientDesigneeEmail length is invalid.";
	public static String ClientDesigneeStatuslengtherror= "The ClientDesigneeStatus length is invalid.";
	public static String ClientDesigneeStartDate_futuredateerror= "The ClientDesigneeStartDate must be less than current date.";
	public static String ClientDesigneeEndDate_futuredateerror= "The ClientDesigneeEndDate must be today";
	public static String AuthorizationStatusformateerror="The AuthorizationStatus format is incorrect.";
	public static String Authorizationlimittypeerror="The AuthorizationLimitType format is incorrect.";
	public static String AuthorizationStatusnullerror="The AuthorizationStatus should set to A as per default value.";





	public static String ClientMiddleInitialLengthError = "The ClientMiddleInitial length is invalid. The length should be between 1 and 1.";


//---------------------------------------------Authorization Table-------------------------------------//
	
	;
	public static String Auth_ref_number ="AuthorizationReferenceNumber" ;
	public static String AuthorizationMaximum ="AuthorizationMaximum";
	public static String memo ="AuthorizationComments";

	public static String Clientidentifier ="ClientIdentifier";
	public static String clientid ="ClientIdentifier";		
	public static String payor_id ="PayerID";	
	public static String provider_id ="ProviderID";
	public static String provider_id_quelifier="ProviderQualifier";
	



	// ----------------------------------DB Fields -----------------------------------------------------------------//

	public static String dbLongitude ="longitude" ;
	public static String dbLatitude ="latitude" ;
	public static String dbClientFirstName ="f_name";
	public static String dbClientLastName ="l_name";

	public static String dbpayerid ="PAYOR_ID";
	public static String dbclientid ="LOC";		
	public static String dbpayerProgram ="program";	
	public static String dbClientSSN ="client_ssn";
	public static String dbClientZip="zip_code";
	public static String ClientFirstName_stxuser ="USER_F_NAME";
	public static String ClientlasTName_stxuser="USER_L_NAME";
	public static String appUser_Delete ="deleted";

	public static String dbAdressType ="addr_type_qlfr";

	public static String dbProviderid    ="provider_id";
	public static String dbClientEligibilityDateBegin    ="beg_date";
	public static String dbPayerID   ="payor_id";
	public static String dbClientStatus    ="delete_flag";
	public static String dbClientEligibilityDateEnd ="end_date";
	public static String dbClientPhoneType ="description";

	public static String dbClientPhone ="ani";
	public static String dbclientEmail ="E_MAIL";
	public static String dbMobileLogin="call_username";


	public static String dbClientID ="LOC";		
	public static String dbPayerProgram ="program";		
	public static String dbDeletestatus ="delete_flag";
	public static String dbDischargeDate ="dis_date";

	public static String dbClientContactCity = "city";
	public static String dbClientContactState = "state";
	public static String dbClientContactZip="zip_code";
	public static String dbClientContactFirstName="f_name";

	public static String dbClienttimezone ="TZNAME";	

	public static String payerProgram_db ="program";	
	public static String dbContactCity="city";
	public static String dbCityContacttype="contact_relationship";
	public static String dbClientContactPhone="phonenum_home";
	public static String dbClientContactPhone2="phonenum_Business";
	public static String dbClientContactPhone3="phonenum_Other";
	public static String dbClientContactPhone4="phonenum_Mobile";

	public static String payerid_DB ="payor_id";
	public static String jsonProcedureCode ="ProcedureCode";
	public static String dbPROVIDERIDQLFR = "PROVIDER_ID_QLFR";

	public static String dbClientAddressLine2="addr2";
	public static String dbClientAddressLine1="addr1";
	public static String dbClientCity ="city";
	public static String dbClientCounty ="county";

	// --###########################---Employee Details -########################################

	//-------------------config properties-------------------------------
	public static String create_employee_URL="create_employee";
	public static String altevv_emp_url="altevv_emp";
	public static String Emp_get_url ="Emp_get";

	//------------------JSON File name Reading----------
	public static String staff_intake_json ="Staff_intake";

	//------------------JSON File name Reading----------
	public static String emp_openevv_Json="employee";
	public static String emp_max_openevv_Json="employee_Max_Values";
	public static String emp_min_openevv_Json="employee_Min_Values";


	// -------------------JSON Object name identification ----------------------------------------
	public static String SequenceID = "SequenceID";
	public static String EmployeeAddress1 = "EmployeeAddress1";
	public static String EmployeeAddress2 = "EmployeeAddress2";
	public static String EmployeeCity = "EmployeeCity";
	public static String EmployeeSocialSecurity = "EmployeeSSN";
	public static String EmployeeID="EmployeeID";

	// -------------------JSON error message identification ----------------------------------------

	public static String EmpIDFormatError = "ERROR: The EmployeeID expected format is not correct.";
	public static String EmployeeIDerror="The EmployeeID value is incorrect.";
	public static String EmployeeIDformaterror="The EmployeeID format is incorrect.";
	public static String EmpAccountFormatError  = "The Account for input record(s) does not match with given Account 14420. Please check and try again.";
	public static String EmpAdd1FormatError = "ERROR: The EmployeeAddress1 expected format is not correct.";
	public static String EmpAdd2FormatError = "ERROR: The EmployeeAddress2 expected format is not correct.";
	public static String EmpCityFormatError = "ERROR: The EmployeeCity expected format is not correct.";
	public static String specialcharadd1_add2FormatError="ERROR: The ClientAddressLine1 format is incorrect. The record should satisfy this regular expression";
	public static String EmployeeEndDateformaterror="ERROR: The EmployeeEndDate expected format is not correct.";
	public static String EmployeeMaxEndDateerror="ERROR: The EmployeeEndDate value exceeds the maximum length of 8 characters. The record is being rejected. The length should be between 0 and 8.";
	public static String EmployeeHireMaxDateerror="The EmployeeBirthDate value exceeds the maximum length of 8 characters.";


	// -------------------DB Fields ----------------------------------------

	public static String dbEmpAddressLine1 = "addr1";
	public static String dbEmpAddressLine2 = "addr2";
	public static String dbEmpCity = "city";
	public static String dbEmpSSN ="worker_ssn";
	public static String dbEmpId ="att_id";
	public static String dbSequenceID = "worker_version_number";
	public static String dbWorkerID ="WORKER_ID";
	public static String dbAccount ="Account";



	// --###########################---Employee Details -########################################

	//-------------------config properties-------------------------------
	public static String visit_intake_json="visit_intake";

	public static String altevv_visit_get="altevv_visit_get";
	public static String visit_url="altevv_visit";
	public static String altevv_client_get="altevv_clients_get";

	//------------------Visit JSON File name Reading----------
	public static String  SequenceIDjson ="SequenceID";
	public static String  VisitOtherIDjson ="VisitOtherID";
	public static String  VisitEmployeeOtherID="EmployeeOtherID";
	public static String  ClientOtherIDjson  ="ClientOtherID";
	public static String  ReasonCodejson  ="ReasonCode";
	public static String  ResolutionCodejson  ="ResolutionCode"; 
	public static String  ChangeReasonMemojson  ="ChangeReasonMemo";
	public static String  ClientVerifiedTasksjson = "ClientVerifiedTasks";
	public static String ClientVoiceRecordingjson ="ClientVoiceRecording";
	public static String CallExternalIDjson = "CallExternalID" ;
	public static String  AdjInDateTimejson ="AdjInDateTime";
	public static String  AdjOutDateTimejson ="AdjOutDateTime";
	public static String employeequalifier= "EmployeeQualifier";

	public static String ScheduleStartTime="ScheduleStartTime";
	public static String ScheduleEndTime="ScheduleEndTime";

	public static String VisitEmployeeIdentifier = "EmployeeIdentifier";
	public static String VisitClientIdentifier = "ClientIdentifier";
	public static String VisitGroupCode = "GroupCode";

	public static String CallAssignmentjson ="CallAssignment";
	public static String CallTypejson = "CallType";
	public static String  VisitEmployeeIdentifierjson = "EmployeeIdentifier";
	public static String  VisitClientIdentifierjson = "ClientIdentifier";
	public static String  VisitGroupCodejson = "GroupCode";
	public static String  EmployeeIdentifierjson = "EmployeeIdentifier";
	public static String  ClientIdentifierjson = "ClientIdentifier";
	public static String  VisitCancelledIndicatorjson = "VisitCancelledIndicator";
	public static String  PayerIDjson = "PayerID";
	public static String  PayerProgramjson = "PayerProgram";
	public static String  ProcedureCodejson = "ProcedureCode";
	public static String  VisitTimeZonejson = "VisitTimeZone";
	public static String  CallDateTimejson = "CallDateTime";
	public static String  ClientVerifiedTimesjson="ClientVerifiedTimes";
	public static String  ExceptionAcknowledgedjson   ="ExceptionAcknowledged";
	public static String  BillVisitjson ="BillVisit";

	public static String ClientIdentifierOnCalljson= "ClientIdentifierOnCall";
	public static String MobileLoginjson= "MobileLogin";
	public static String CallLatitudejson= "CallLatitude";
	public static String CallLongitudejson= "CallLongitude";
	public static String Locationjson= "Location";
	public static String TelephonyPINjson= "TelephonyPIN";
	public static String OriginatingPhoneNumberjson= "OriginatingPhoneNumber";
	public static String ChangeMadeByjson= "ChangeMadeBy";
	public static String ChangeDateTimejson= "ChangeDateTime";
	public static String ScheduleStartTimejson = "ScheduleStartTime";
	public static String ScheduleEndTimejson = "ScheduleEndTime";
	public static String ClientSignatureAvailablejson="ClientSignatureAvailable";
	public static String ClientVerifiedServicejson="ClientVerifiedService";
	public static String HoursToBilljson;
	public static String HoursToPayjson;
	public static String visitTimeZonejson ="VisitTimeZone";
	public static String TelephonyPinjson= "TelephonyPin";

	public static String  Changemadebyemailjson= "ChangeMadeByEmail";



	// -------------------JSON error message identification ----------------------------------------

	public static String ReasonCodeLengthError= "The ReasonCode value is incorrect. The length should be between 1 and 4.";
	public static String ResolutionCodeLengthError= "The ResolutionCode value is incorrect. The length should be between 1 and 4.";
	public static String ClientVerifiedTasksError= "The ClientVerifiedTasks format is incorrect.";
	public static String ClientVerifiedTimesError= "The ClientVerifiedTimes format is incorrect.";
	public static String ClientVerifiedServiceError= "ERROR: The ClientVerifiedService format is incorrect.";
	public static String ClientSignatureAvailableError=  "ERROR: The ClientSignatureAvailable format is incorrect.";
	public static String ClientVoiceRecordingError = "ERROR: The ClientVoiceRecording format is incorrect.";
	public static String errorVisitOtherIdLength                 = "ERROR: The VisitOtherID value is greater than the 50 characters. The length should be between 1 and 50.";
	public static String errorVisitOtherIdFormat                 ="ERROR: The VisitOtherID format is incorrect."; 
	public static String errorVisitOtherIDNull                   ="ERROR: The VisitOtherID cannot be null";
	public static String errorSequenceIdNull                     ="ERROR: The SequenceID cannot be null";
	public static String errorEmployeeOtherIDlength              ="ERROR: The EmployeeOtherID value length exceeds the field size and should be between 1 and 64.";
	public static String errorEmployeeOtherIDFormat              ="ERROR: The EmployeeOtherID format is incorrect. The record should satisfy this regular expression";
	public static String ChangeReasonMemoLengthError = "The ChangeReasonMemo value is incorrect. The length should be between 1 and 256.";
	public static String ChangeReasonMemoNullError = "The ChangeReasonMemo cannot be null.";
	public static String CallExternalIDLengthError = "The CallExternalID value should be between 1 and 16.";
	public static String CallExternalIDFormatError = "The CallExternalID format is incorrect.";
	public static String CallExternalIDNullError = "The CallExternalID cannot be null.";
	public static String CallAssignmentError = "The CallAssignment format is incorrect.";
	public static String CallTypeError =  "The CallType format is incorrect.";
	public static String SequenceidError = "VersionNumber is either duplicated or older than current.";
	public static String EmployeeIDformateerror="The EmployeeID format is incorrect";
	public static String errorEmployeeIdentifierlength           ="ERROR: The EmployeeIdentifier value length exceeds the field size and should be between 1 and 9. The record is being rejected.";
	public static String errorEmployeeIdentifierNull             ="ERROR: The EmployeeIdentifier cannot be null.";
	public static String errorEmployeeIdentifierFormat           ="ERROR: The EmployeeIdentifier format is incorrect. The record should satisfy this regular expression";
	public static String ClientPhone_format= "ERROR: The ClientPhone format is incorrect.";
	public static String ClientPhone_length= "ERROR: The ClientPhone length is invalid. The length should be between 1 and 10.";
	public static String GroupCodeLengthError                    ="The GroupCode value is incorrect. The length should be between 1 and 6.";
	public static String GroupCodeFormatError                    ="ERROR: The GroupCode format is incorrect";
	public static  String errorClientOtherIdLength               ="ERROR: The ClientOtherID value exceeds 24 characters. The length should be between 1 and 24. The record is being rejected.";
	public static String  errorClientOtherIdFormat               ="ERROR: The ClientOtherID format is incorrect.";
	public static String errorClientIdentifierNull              ="ERROR: The ClientIdentifier cannot be null.";
	public static String errorClientIdentifierFormat             ="ERROR: The ClientIdentifier format is incorrect. The record should satisfy this regular expression";
	public static String errorPayorIdLength                     ="The PayerID length should be between 1 and 64.";
	public static String errorPayorIdLength1  =     "The PayerID value is incorrect. The length should be between 1 and 64.";
	public static String errorPayorIDNull                      = "The PayerID cannot be null.";
	public static String errorPayorIDFormat                     ="The PayerID format is incorrect";
	
	public static String errorPayorProgramFormat="ERROR: The PayerProgram value must be one of the valid values. The record is being rejected.";
	public static String errorPayorProgramNull="ERROR: The PayerProgram cannot be null. The record is being rejected.";
	public static String PayorProgramNullerror= "The PayerProgram cannot be null.";
	public static String errorPayorProgramSpecialcharFormat ="ERROR: The PayerProgram format is incorrect. The record should satisfy this regular expression";
	public static String VisitTimeZoneNullError="ERROR: The VisitTimeZone cannot be null. The record is being rejected.";
	public static String VisitCancelledIndicatorNullError="ERROR: The VisitCancelledIndicator cannot be null. The record is being rejected.";
	public static String VisitCancelledIndicatorformatError="ERROR: The VisitCancelledIndicator format is incorrect. The record should satisfy this regular expression";
	public static String PayerProgramNullError="The PayerProgram cannot be null";
	public static String PayerIDNullError="The PayerID cannot be null.";
	public static String ProcedureCodeNullError="ERROR: The ProcedureCode cannot be null.";
	public static String VisitOtherIDNullError="ERROR: The VisitOtherID cannot be null. The record is being rejected.";
	public static String SequenceIDNullError="The SequenceID cannot be null.";
	public static String AuthorizationAmountTypeformaterror= "The AuthorizationAmountType format is incorrect.";
	public static String StaffSequenceIDNullError="The SequenceID cannot be NULL.";
	public static String EmployeeIdentifierNullError="ERROR: The EmployeeIdentifier cannot be null. The record is being rejected.";
	public static String ChangeDateTimeNullError ="ERROR: The ChangeDateTime cannot be null. The record is being rejected.";
	public static String ChangeMadeByNullError ="ERROR: The ChangeMadeBy cannot be null. The record is being rejected.";
	public static String OriginatingPhoneNumberNullError ="ERROR: The OriginatingPhoneNumber cannot be null. The record is being rejected.";
	public static String TelephonyPINNullError ="ERROR: The TelephonyPIN cannot be null. The record is being rejected.";
	public static String LocationNullError ="ERROR: The Location cannot be null. The record is being rejected.";
	public static String CallLongitudeNullError ="ERROR: The CallLongitude cannot be null. The record is being rejected.";
	public static String CallLatitudeNullError ="ERROR: The CallLatitude cannot be null. The record is being rejected.";
	public static String CallLatitudeMaxLengthError ="ERROR: The CallLatitude value cannot be greater than 90";
	public static String CallLatitudeMinLengthError ="ERROR: The CallLatitude value cannot be less than -90.";

	public static String MobileLoginNullError ="ERROR: The MobileLogin cannot be null. The record is being rejected.";
	public static String MobileLoginNullError1 ="ERROR: The MobileLogin value is incorrect. The length should be between 1 and 64. The record is being rejected.";
	public static String ClientIdentifierOnCallNullError ="ERROR: The ClientIdentifierOnCall cannot be null. The record is being rejected.";
	public static String ClientIdentifierOnCallFormatError ="The ClientIdentifierOnCall format is incorrect.";
	public static String CallTypeNullError ="ERROR: The CallType cannot be null.";
	public static String CallAssignmentNullError ="ERROR: The CallAssignment cannot be null. The record is being rejected.";
	public static String ProcedureCodeError ="ERROR: The ProcedureCode cannot be null. The record is being rejected.";
	public static String ClientIdentifierNullError="ERROR: The ClientIdentifier cannot be null. The record is being rejected.";
	public static String VisitDateError = "Unparseable date";
	public static String ScheduleStartTimeError = "The ScheduleStartTime cannot be greater than ScheduleEndTime";
	public static String ScheduleEndTimeError = "The ScheduleEndTime cannot be less than ScheduleStartTime";
	public static String HoursToBillValueError = "The HoursToBill value cannot be greater than 1500.";
	public static String HoursToBillFormatError ="Could not read JSON: java.lang.NumberFormatException";
	public static String HoursToPayValueError = "The HoursToBill value cannot be greater than 1500.";
	public static String HoursToPayFormatError ="Could not read JSON: java.lang.NumberFormatException";
	public static String errorMemoFormat ="Could not read JSON: java.lang.NumberFormatException";
	public static String errorMemolength ="ERROR: The Memo value is incorrect. The length should be between 1 and 1024. The record is being rejected.";
	public static String ClientSSNerror="ERROR: The ClientIDQualifier format is incorrect.";
	public static String Modifier1LengthError ="ERROR: The Modifier1 length is invalid. The length should be between 1 and 2. The record is being rejected.";
	public static String Modifier2LengthError ="ERROR: The Modifier2 length is invalid. The length should be between 1 and 2. The record is being rejected.";
	public static String Modifier3LengthError ="ERROR: The Modifier3 length is invalid. The length should be between 1 and 2. The record is being rejected.";
	public static String Modifier4LengthError ="ERROR: The Modifier4 length is invalid. The length should be between 1 and 2. The record is being rejected.";
	public static String ClientIDQualifierformaterror ="ERROR: The ClientIDQualifier format is incorrect.";
	public static String errorProcedureCodelength="ERROR: The ProcedureCode value must be one of the valid values. The record is being rejected.";
	public static String ClientOtherIDformaterror="";
	public static String errorProcedureCodeFormat="ERROR: The ProcedureCode format is incorrect. It must be one of the valid values. The record is being rejected.";
	public static String errorProcedureCodeNull ="ERROR: The ProcedureCode cannot be null.  The record is being rejected.";
	public static String errorVisitTiemZoneFormat="ERROR: The VisitTimeZone value is invalid.";
	public static String errorVisitTimeZoneNull="ERROR: The VisitTimeZone cannot be null. The record is being rejected.";
	public static String errorSequenseIDminLength="ERROR: The SequenceID format is incorrect.";
	public static String SequenceIDLengthError ="The SequenceID value cannot be greater than 9999999999999999.";
	public static String ClientIdentifierOnCallnullerror="ERROR: The ClientIdentifierOnCall cannot be null.";
	public static String ClientIdentifierOnCallformaterror="ERROR: The ClientIdentifierOnCall format is incorrect.";
	public static String CallDateTimeNullError= "The CallDateTime cannot be null.";
	public static String ExceptionIDError="ERROR: The ExceptionID value should be between 1 and 2. The record is being rejected.";
	public static String ExceptionIDformaterror="ERROR: The ExceptionID format is incorrect.";


    public static String ClientContactPhone_error="The ClientContactPhone format is incorrect.";



	
	


	public static String EmployeeQualifierformaterror1="The EmployeeQualifier format is incorrect";


	public static String EmployeeBirthDateYearformat= "ERROR: The EmployeeBirthDate value exceeds the maximum length of 8 characters. The record is being rejected. The length should be between 0 and 8.";


	public static String EmployeeQualifierformaterror="The EmployeeQualifier value is incorrect";
	public static String EmployeeQualifierformat="ERROR: The EmployeeQualifier format is incorrect.";

	public static String CallInOutDateTime_Error="ABC";
	public static String AdjInCallInDateTime_Error="ABC";
	public static String AdjInCallOutDateTime_Error="The AdjInDateTime cannot be greater than the Call out. The record is being rejected.";
	public static String EmpIDFormat= "ERROR: The EmployeeID value exceeds the maximum length of 5 characters.  The record is being rejected. The length should be between 0 and 5.";
	public static String Errormesssage= "Could not read JSON: java.lang.NumberFormatException; nested exception is com.google.gson.JsonSyntaxException: java.lang.NumberFormatException";
	public static String ClientIdentifierOnCallLengthError= "The ClientIdentifierOnCall value is incorrect. The length should be between 1 and 10.";
	public static String ClientIdentifierOnCallformatError="ERROR: The ClientIdentifierOnCall format is incorrect.";
	public static String LocationLengthError= "The Location value is incorrect. The length should be between 1 and 25.";
	public static String LocationFormatError= "The Location format is incorrect.";
	public static String OriginatingPhoneNumberLengthError= "The OriginatingPhoneNumber value is incorrect. The length should be between 10 and 10.";
	public static String OriginatingPhoneNumberFormatError= "The OriginatingPhoneNumber format is incorrect.";

	public static String errorChangedMadeby="ERROR: The ChangeMadeBy value is incorrect. The length should be between 1 and 64";
	public static String errorChangeMadeByNull="ERROR: The ChangeMadeBy cannot be null. The record is being rejected.";

	public static String errorClientNotFound="Client not found";
	public static String errorWorkerNotFound="Worker not found";

	public static String TelephonyPinLengthError= "The ReasonCode value is incorrect. The length should be between 4 and 9.";
	public static String TelephonyPinNullError= "The TelephonyPIN cannot be null.";
	public static String TelephonyPinFormatError ="ERROR: The TelephonyPIN value cannot be greater than 999999999. The record is being rejected.";
	public static String TelephonyPINFormatError ="ERROR: The TelephonyPIN value cannot be greater than 999999999.";
	public static String TelephonyPINFormatError1 ="java.lang.NumberFormatException";
	public static String TelephonyPINNegativeError= "ERROR: The TelephonyPIN value cannot be less than 0.";
	public static String ClientAddressEmptyError = "The ClientAddress should not be empty.";
	public static String ClientAddressTypeNullError="The ClientAddressType cannot be null.";
	public static String TelephonyPINError="Bad Request";
	public static String Providerqualifiererror="The ProviderQualifier format is incorrect";
	public static String Providerqualifiernullerror="The ProviderQualifier cannot be null.";
	public static String ClientLanguageerror="The ClientLanguage format is incorrect.";
	public static String ClientTimeZoneerror="The ClientTimeZone value is invalid.";


	public static String ClientidQualifierFormatError1= "ERROR: The ClientIDQualifier format is incorrect.";
	public static String EmployeeidQualifierFormatError1= "ERROR: The EmployeeQualifier format is incorrect.";
	public static String DeleteStatusFormatError1="ERROR: The ClientStatus format is incorrect. The record should satisfy this regular expression";

	public static String ClientAddressLine1NullError= "The ClientAddressLine1 cannot be null.";
	public static String ClientAddressLine2NullError= "The ClientAddressLine2 cannot be null.";

	public static String ClientAddressLine1FormatError= "The ClientAddressLine1 format is incorrect.";
	public static String ClientAddressLine1LengthError= "ERROR: The ClientAddressLine1 length is invalid. The length should be between 1 and 30.";

	public static String ClientidQualifierFormatError11= "ERROR: The ClientIDQualifier format is incorrect.";
	public static String EmployeeidQualifierFormatError11= "ERROR: The EmployeeQualifier format is incorrect.";
	public static String DeleteStatusFormatError11="ERROR: The ClientStatus format is incorrect. The record should satisfy this regular expression";
	public static String EmployeeHireDateYearformat="ERROR: The EmployeeHireDate\\u0027s year is not correct. The year should not less than 1900. The record is being rejected.";
	public static String Modifier1FormatError = "The Modifier1 format is incorrect.";
	public static String Modifier2FormatError = "The Modifier2 format is incorrect.";
	public static String Modifier2FormatvalueError ="Modifier2 value is incorrect.";
	public static String Modifier3FormatvalueError ="Modifier3 value is incorrect.";
	public static String Modifier4FormatvalueError ="The Modifier4 value is incorrect.";
	public static String AuthorizationBillingTypevalueerror="The AuthorizationBillingType value is incorrect.";
	public static String AuthorizationBillingTypeerror="The AuthorizationBillingType format is incorrect.";
	public static String Modifier3FormatError = "The Modifier3 format is incorrect.";
	public static String Modifier4FormatError = "The Modifier4 format is incorrect";
	public static String ClientIDformaterror="ERROR: The ClientID format is incorrect.";
	public static String EmployeeEndDateerror="ERROR: The EmployeeEndDate cannot be less than EmployeeHireDate.";
	public static String EmpIdentifierLengthError= "ERROR: The EmployeeIdentifier value length exceeds the field size and should be between 1 and 9. The record is being rejected.";
	public static String EmpIdentifierFormatError="ERROR: The EmployeeIdentifier format is incorrect.";
	public static String EmpIdentifierNullError= "The EmployeeIdentifier cannot be NULL.";
	public static String EmployeeAPIformaterror="ERROR: The EmployeeAPI format is incorrect.";
	public static String ClientIDLengthError= "The ClientID value is incorrect. The length should be between 5 and 5.";
	public static String ClientOtherIDLengthError= "The ClientOtherID length is invalid. The length should be between 1 and 24.";
	public static String EmployeePositionlengtherror="ERROR: The EmployeePosition value is incorrect. The length should be between 2 and 3. The record is being rejected.";
	public static String EmployeePositionformaterror="ERROR: The EmployeePosition expected format is not correct";
	public static String CaseMangererror="The CaseManager format is incorrect.";

	public static String Accounterror="The Account format is incorrect.";

	public static String Accountformat="The Account for input record(s) does not match with given Account 14420. Please check and try again.";
	public static String AccountLengtherror="The Account format is incorrect.";

	public static String ClientAddressLine1error= "The ClientAddressLine1 format is incorrect.";
	public static String ClientAddressLine2error= "The ClientAddressLine2 format is incorrect.";



	// -------------------DB Fields ----------------------------------------

	public static String dbEmployeeOtherID="worker_id";
	public static String dbvisitotherid = "visit_id";
	public static String dbvisitKey = "viskey";
	public static String dbReasonCode ="REASON_CODE";
	public static String dbChangeReasonMemo = "reason_code_memo";
	public static String dbvisitSequenceId="visit_version_number";
	public static String dbResolutionCode = "RESOLUTION_CODE";
	public static String dbClientVerifiedTasks = "client_verify_tasks_ind";
	public static String dbClientVerifiedService ="client_verify_service_ind";
	public static String dbClientSignatureAvailable= "client_signature_ind" ;
	public static String dbClientVoiceRecording = "client_voice_recording_ind";
	public static String dbCallExternalID = "call_id";
	public static String dbCallAssignment = "call_assignment_qlfr";
	public static String dbEmployeeIdentifier ="worker_id_qlfr";
	public static String dbClientIdentifier ="client_id_qlfr";
	public static String dbvisitsexceptions_SequenceId = "SID";
	public static String dbPayerIDVisit   ="payor_id";
	public static String dbPayerProgramVisit="payor_program";
	public static String dbVisitCancelledIndicator="visit_cancel_ind";
	public static String dbScheduleStartTime ="b_dtime" ;
	public static String dbScheduleEndTime ="e_dtime" ;
	public static String dbCallType ="call_type_qlfr";
	public static String dbHoursToBill= "bill_hours";
	public static String dbHoursToPay= "pay_hours";
	public static String dbAdjustinDate="beg_adj_dtime_utc";
	public static String dbAdjustoutDate="end_adj_dtime_utc";
	public static String dbChangeDateTime="visit_change_dtime_utc";
	public static String dbVisitTimeZone="tzname";
	public static String dbClientVerifiedTimes= "client_verify_time_ind";
	public static String dbCallDateTime="call_dtime_utc";
	public static String dbemployeeotherid="worker_id_custom1";

	public static String dbExceptionID = "exception_id";
	public static String dbExceptionAcknowledged = "exception_ack_ind";

	public static String dbClientIdentifierOnCall = "client_id";
	public static String dbLocation="call_location";
	public static String dbOriginatingPhoneNumber ="ani";
	public static String dbChangeMadeByVisit= "ChangeMadeBy";
	public static String dbcallusername= "call_username";
	public static String dblatitude= "latitude";
	public static String dblongitude= "longitude";
	public static String dbClientStartOfCareDate="";
	public static String dbClientState="state";
	public static String dbbeg_date="beg_date";
	public static String dbend_date="end_date";
	public static String dbTelephonyPin="stx_id";


	public static String dbClientOtherid="client_id_custom2";
	public static String dbClientCustomid="client_id_custom1";
	public static String coordinator= "Coordinator";







	public static String dbTelephonyPin1="stx_id";



	public static String ClientStatusDateerror= "The ClientStatusDate format is incorrect.";
	public static String ClientBirthDateerror="The ClientBirthDate format is incorrect.";
	public static String ClientStatuserror="The ClientStatus format is incorrect";






	public static String ClientidQualifierFormatError= "ERROR: The ClientIDQualifier format is incorrect.";
	public static String EmployeeidQualifierFormatError= "ERROR: The EmployeeQualifier format is incorrect.";
	public static String DeleteStatusFormatError= "ERROR: The ClientStatus format is incorrect. The record should satisfy this regular expression";
	public static String dbEmpFName= "F_name";
	public static String dbEmpLName= "L_name";




	public static String ClientEligibilityDateEnderror="The ClientEligibilityDateEnd format is incorrect.";
	public static String ClientStartOfCareDateerror="The ClientStartOfCareDate format is incorrect.";


	public static String dbEmpFName1= "F_name";
	public static String dbEmpLName1= "L_name";

	public static String ClientEndOfCareDateerror="The ClientEndOfCareDate format is incorrect.";








	public static String dbTelephonyPin11="stx_id";




	public static String dbModifier1="Modifier1";
	public static String dbModifier2="Modifier2";
	public static String dbModifier3="Modifier3";
	public static String dbModifier4="Modifier4";
	public static String dbPayerService="Service";

	public static String dbClientAddLine1="addr1";
	public static String dbClientAddLine2="addr2";

	public static String ClientFirstNameLengthError="The ClientFirstName length is invalid.";
	public static String dbClientMiddleInitial="m_name";
	public static String ClientLastNameLengthError="The ClientLastName length is invalid. The length should be between 0 and 30.";
	public static String ClientSSNLengthError= "The ClientSSN length is invalid. The length should be between 0 and 9.";
	public static String ClientContactEmailAddresserror="The ClientContactEmailAddress format is incorrect.";

	public static String dbDeleteFlag ="delete_flag";

	public static String dbClientEligibilityDateEnd1= "ClientEligibilityDateEnd";

	public static String dbClientSuffix="name_suffix";
	public static String ClientSuffixLengthError="The ClientSuffix length is invalid. The length should be between 0 and 4.";
	public static String dbAction="delete_flag";
	public static String ActionLengthError="The Action length is invalid. The length should be between 1 and 1.";
	public static String PayerIDLengthError="The PayerID length is invalid. The length should be between 1 and 64.";
	public static String PayerProgramLengthError="The PayerProgram value is incorrect. The length should be between 1 and 9.";

	public static String ClientMedicalRecordNumber="ClientMedicalRecordNumber";
	public static String MissingMedicaidID="MissingMedicaidID";
	public static String ClientCustomID="ClientCustomID";

	public static String PayerServiceLengthError="The PayerService value is incorrect. The length should be between 1 and 5.";
	public static String PayerRegionLengthError="The PayerRegion value is incorrect. The length should be between 1 and 2.";
	public static String CaseManagerLengthError= "The CaseManager length is invalid. The length should be between 0 and 25.";
	public static String ClientCaseManagerEmailLengthError= "The ClientCaseManagerEmail length is invalid. The length should be between 0 and 64.";
	public static String ClientCoordinatorEmailLengthError= "The ClientCoordinatorEmail length is invalid. The length should be between 0 and 50.";
	public static String ClientGenderLengthError= "The ClientGender length is invalid. The length should be between 0 and 1.";
	public static String ClientMaritalStatusLengthError= "The ClientMaritalStatus length is invalid. The length should be between 0 and 1.";
	public static String ClientOtherIDFormatError="The ClientOtherID format is incorrect.";
	public static String PayerServiceFormatError="The PayerService format is incorrect.";
	public static String PayerServiceNullError="The PayerService can not be null or empty.";
	public static String ClientCaseManagerEmailFormatError ="The ClientCaseManagerEmail format is incorrect.";
	public static String ClientCoordinatorEmailFormatError ="The ClientCoordinatorEmail format is incorrect.";
	public static String ClientGenderFormatError ="The ClientGender format is incorrect.";
	public static String ClientMaritalStatusFormatError ="The ClientMaritalStatus format is incorrect.";
	public static String ClientPriorityLengthError = "The ClientPriority length is invalid. The length should be between 0 and 2.";
	public static String ClientContactAddressLine1LengthError="The ClientContactAddressLine1 length is invalid. The length should be between 0 and 30.";
	public static String ClientContactAddressLine1FormatError= "The ClientContactAddressLine1 format is incorrect.";
	public static String ClientContactAddressLine2LengthError="The ClientContactAddressLine2 length is invalid. The length should be between 0 and 30.";
	public static String ClientContactAddressLine2FormatError= "The ClientContactAddressLine2 format is incorrect.";
	public static String ClientMedicalRecordNumberLengthError ="The ClientMedicalRecordNumber length is invalid. The length should be between 0 and 12.";


	public static String ClientContactFirstName="ClientContactFirstName";
	public static String ClientContactLastName="ClientContactLastName";
	public static String ClientContactEmailAddress="ClientContactEmailAddress";
	public static String ClientContactAddressLine1="ClientContactAddressLine1";
	public static String ClientContactAddressLine2="ClientContactAddressLine2";
	public static String ClientEmaillenghtherror="The ClientEmail length is invalid.";



	public static String EmployeeLastName="EmployeeLastName";
	public static String EmployeeFirstName="EmployeeFirstName";
	public static String EmployeeMiddleInitial="EmployeeMiddleInitial";
	public static String Department="Department";
	public static String EmployeeAPI="EmployeeAPI";
	public static String EmployeeType="EmployeeType";
	public static String Discipline="Discipline";
	public static String EmployeeManagerEmail="EmployeeManagerEmail";
	public static String ClientMiddleInitial="ClientMiddleInitial";
	public static String CaseManager="CaseManager";
	public static String ClientEmail="ClientEmail";
	public static String ClientCaseManagerEmail="ClientCaseManagerEmail";
	public static String ClientGender="ClientGender";
	public static String ClientMaritalStatus="ClientMaritalStatus";
	public static String ClientPriority="ClientPriority";
	public static String PayerRegion="PayerRegion";
	public static String EmployeeSSN="EmployeeSSN";
	public static String EmployeeEmail="EmployeeEmail";
	public static String EmployeePosition="EmployeePosition";
	public static String dbProgram="PROGRAM";
	public static String dbService="SERVICE";
	public static String ClientCoordinatorEmail="ClientCoordinatorEmail";
	public static String ClientContactCitylengthError_mem="The ClientContactCity length is invalid.";



	//Variables for molina pipe deliminated files

	public static String batFileCreation=System.getProperty("user.dir")+"\\lib\\bat1.bat";
	public static String Encryptfile=System.getProperty("user.dir")+ "\\lib\\Auth_member_setup\\to_encrypt\\";
	public static String EncryptedfileResult=System.getProperty("user.dir")+ "\\lib\\Auth_member_setup\\to_encrypt_result\\";
	public static String decryptedfileResult=System.getProperty("user.dir")+ "\\lib\\Auth_member_setup\\to_decrypt\\";
	public static String decryptedfileResultTo=System.getProperty("user.dir")+ "\\lib\\Auth_member_setup\\to_decrypt_result\\";
	public static String batcommandwrite="cd /d " + System.getProperty("user.dir")+"\\lib\\Auth_member_setup" + " & java -jar pgp-generate-tool-1.0.1-SNAPSHOT.jar";
	public static String memberFtpLocation ="/QA_4_QA/Molina_Interfaces/28000";
	public static String memberFtpLocationErrorControlFile ="/QA_4_QA/Molina_Interfaces/28000/To_28000";
	public static String memberGenericFileName ="MEDHHS_EVV_Member_";
	public static String memberGenericFileNameControlFile ="MEDHHS_EVV_";
	public static String authFtpLocation ="/DEV_4_QA/Molina_Interfaces/AuthETLImport/2800";
	public static String generatedControlFile =memberGenericFileNameControlFile+"Inbound_ControlFile_"+FileContentReader.timeStamp+".csv.gpg";
	public static String generatedErrorFile =memberGenericFileNameControlFile+"Member_Error_"+FileContentReader.timeStamp+".csv.gpg";
	public static String molinaGenericFileName ="MEDHHS_EVV_Member_20181112.csv";
	public static String molinaGenericFile =globalVariables.Encryptfile+globalVariables.molinaGenericFileName;
	public static String molinaAuthFileName ="MEDHHS_EVV_Auth_20181204.csv";
	public static String molinaAuthGenericFile =globalVariables.Encryptfile+globalVariables.molinaAuthFileName;
	public static String memberAuthFileName ="MEDHHS_EVV_Auth_";
	public static String molinaProviderGenericFile =globalVariables.Encryptfile+globalVariables.molinaAuthFileName;
	public static String memberProviderFileName ="MEDHHS_EVV_Provider_";




	//ErrorMessage 
	public static String memberActionNullError ="ERROR: The Action cannot be null.";
	public static String memberClientCityNullError ="ERROR: The ClientCity cannot be null.";
	public static String memberClientEligibilityDateBeginNullError ="ERROR: The ClientEligibilityDateBegin cannot be null.";
	public static String memberClientStateNullError ="ERROR: The ClientState cannot be null.";
	public static String memberClientZipNullError ="ERROR: The ClientZip cannot be null.";
	public static String memberClientCustomIDNullError ="ERROR: The ClientCustomID cannot be null";
	public static String memberClientOtherIDNullError ="ERROR: The ClientOtherID cannot be null";
	public static String memberClientSSNNullError ="ERROR: If the ClientSSN is empty then ClientOtherID must be populated";
	public static String memberClientFirstNameNullError ="ERROR: The ClientFirstName cannot be null.";
	public static String memberMolinaMedicaid_IDNullError= "ERROR: The ClientCustomID cannot be null";
	public static String memberMolinaMedicaid_ID= "length is invalid";
	public static String memberClientLastNameNullError ="ERROR: The ClientLastName cannot be null.";
	public static String memberClientEligibilityDateBeginFormatError ="ERROR: The ClientEligibilityDateBegin format is incorrect. The record should satisfy the date format ['yyyy-MM-dd']. Invalid Value='null'.";


	/////////////////////molina globalvariables /////////////////////////////
	public static String molinaClientId="ClientID";
	public static String molinaClientSSN="ClientSSN";
	public static String molinaClientFirstName="ClientFirstName";
	public static String MolinaMedicaid_ID="ClientCustomID";
	
	public static String molinaClientLastName="ClientLastName";
	public static String molinaClientCustomID="ClientCustomID";
	public static String molinaClientOtherID="ClientOtherID";
	public static String molinaClientMedicalRecordNum="ClientMedicalRecordNum";
	public static String molinaClientEmail="ClientEmail";
	public static String molinaAction="Action";
	public static String molinaclientAddressType="clientAddressType";
	public static String molinaclientAddressLine1="clientAddressLine1";
	public static String molinaclientCity="clientCity";
	public static String molinaclientState="clientState";
	public static String molinaclientZip="clientZip";
	public static String molinaclientEligibilityDateBegin="clientEligibilityDateBegin";
	public static String molinaProviderQualifier="providerQualifier";
	public static String memberClientLastNameLengthError="The ClientLastName length is invalid. The length should be between 0 and 30.";


	public static String clientaddresssegment="ERROR: The ClientAddressLongitude cannot be null.|ERROR: The ClientCity cannot be null.|ERROR: The ClientZip cannot be null.|ERROR: The ClientAddressLine1 cannot be null.|ERROR: The ClientAddressIsPrimary cannot be null.|ERROR: The ClientAddressType cannot be null.|ERROR: The ClientState cannot be null.|ERROR: The ClientAddressLatitude cannot be null.";

	public static String Service="PayerService";
	public static String Program="PayerProgram";
	public static String Modifier1="Modifier1";
	public static String Modifier2="Modifier2";
	public static String Modifier3="Modifier3";
	public static String Modifier4="Modifier4";
	public static String Authendtime="AuthorizationEndDate";
	
	public static String EndTime="ClientEligibilityDateEnd";
	public static String providertaxonomy="ProviderTaxonomy";
	public static String molinaproviderId="providerId";
	public static String molinaprovider1FirstName="PrimaryContactFirstName";
	public static String molinaprovider1LastName="PrimaryContactLastName";
	public static String molinaproviderEmail="AgencyEmail";
	public static String ClientSuffixFormatError= "The ClientSuffix format is incorrect.";
	public static String ClientEmailAddress="ClientEmailAddress";
	public static String ClientEmailAddressLengthError="The ClientEmailAddress length is invalid.";
	public static String ClientEmailAddressFormatError="The ClientEmailAddress format is incorrect.";
	public static String ClientIDLengthError_mem= "The ClientID value is incorrect. The length should be between 1 and 10";
	public static String ThreeP_patientJson ="patient";
	public static String Auth_json ="auth";
	public static String Auth_max_json="auth_max";
	public static String AuthorizationEndDateformateerror = "The AuthorizationEndDate format is incorrect";
	public static String AuthorizationStartDateformateerror = "The AuthorizationStartDate format is incorrect";
	public static String AuthorizationSharedeformaterror="The AuthorizationShared format is incorrect.";
	
	
	public static String ThreeP_patientJson_withoutphone ="patient_without_phone";
	
	public static String ThreeP_Staff_Json="worker";
	public static String ThreeP_visit_Json="visits";
	public static String staffotherid_visit= "The StaffOtherID cannot be null.  Record is being inserted into the database with an unknown staff";
	public static String molinaClientMedicaidID;
	public static String memberClientMedicaidIDNullError;
	public static String memberClientMedicaidIDError;
	public static String StaffSSNFormatError ="The EmployeeSSN format is incorrect.";
	public static String StaffFirstNameFormatError="The EmployeeFirstName format is incorrect.";
	public static String StaffLastNameFormatError="The EmployeeLastName format is incorrect.";
	public static String StaffFirstNameNullError="The EmployeeFirstName cannot be NULL.";
	public static String StaffLastNameNullError="The EmployeeLastName cannot be NULL.";
	public static String StaffOtherIDFormatError="The EmployeeOtherID value is greater than 64 characters.";
	public static String SequenceIDFormatError="The SequenceID format is incorrect.";
	public static String StaffIDFormatError="The EmployeeIdentifier expected format is not correct.";
	public static String StaffIDNullError="The EmployeeIdentifier cannot be NULL.";

	public static String client_intake_v1 = "client_intake_v1";
	public static String clientphone_formaterror= "The ClientPhoneNumber format is incorrect. The record should satisfy this regular expression";
	public static String ClientPayerID= "ClientPayerID";
	public static  String Client_Payer_Informationemptyerror = "The ClientPayerInformation cannot not be empty.";

	
	public static CharSequence businessentityformaterror="\"Reason\": \"The BusinessEntityMedicaidID does not match with provider ID. Please check and try again.\"";
	public static CharSequence businessentitybadrequesterror="\"status\": \"BAD_REQUEST\",";
	public static CharSequence businessentitynullerror="\"Reason\": \"The account ID (BusinessEntityID) for some of input records is invalid. Please check and try again.\"";
	public static CharSequence businessmedicatednullerror="\"Reason\": \"The BusinessEntityMedicaidID does not match with provider ID. Please check and try again.\"";
	
	public static String patientotherlengtherror="The PatientOtherID format is incorrect. It should be between 1 and 64 characters.";
	public static String patientothernullerror="The PatientOtherID is null.";
	
	public static String patientmedicatiderror="\"ErrorMessage\": \"Client not found\"";
	public static String patientmedicatidlengtherror="The PatientMedicaidID format is incorrect. The record is being rejected. It should be 12 digits";
	public static String patientmedicatiderrorcode_incaseless_more_than12= "-782";
	public static String patientmedicatiderrormessage_incaseless_more_than12= "The value does not meet the validation pattern. The value is truncated if it exceeds max length, and the truncated value or the original value (less than minimum required length) is inserted into database.";
	 

	public static String patientalternateidlengtherror="The PatientAlternateID format is incorrect. It should be 7 digits only.";
	public static String PatientLastNamenullerror="The PatientLastName cannot be null";
	public static String PatientLastNameformaterror="The PatientLastName format is incorrect.";
	public static String PatientLastNamelengtherror="The PatientLastName value will be truncated to 30 characters. The length should be between 1 and 30.";

	public static String PatientFirstNamenullerror="The PatientFirstName cannot be null";
	public static String PatientFirstNameformaterror="The PatientFirstName format is incorrect.";
	public static String PatientFirstNamelengtherror="The PatientFirstName value will be truncated to 30 characters. The length should be between 1 and 30.";
	public static String PatientTimeZonenullerror;
	public static String PatientTimeZonelengtherror;
	public static String PatientTimeZoneformaterror;


}

