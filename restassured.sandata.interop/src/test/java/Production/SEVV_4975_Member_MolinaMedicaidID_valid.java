package Production;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.FileContentReader;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;

import Utills_ExtentReport_Log4j.BaseTest;

public class SEVV_4975_Member_MolinaMedicaidID_valid extends BaseTest{
	List<String> Errormessage = new ArrayList<String>();
	Map<String ,String> fileUpdateValue = new HashMap<>();
	Map<String ,String> finalMapapdataByRow = new HashMap<>();
	List<String> fileNames;
	 String fileName;
	 
	//Case1: ClientMedicateid passed with max length (valid)
	 @Test
	 public void SEVV_4975_Member_MolinaMedicaidID_validcase() throws Exception{
		 logger = extent.startTest("SEVV_4975_Member_MolinaMedicaidID_valid");  
			
			Map<String ,String> fileUpdateValue = new HashMap<>();
			Map<String ,String> finalMapapdataByRow = new HashMap<>();
			List<String> fileNames;
			 String fileName;
			 List<String> Errormessage = new ArrayList<String>();
				
			
			fileUpdateValue=GenerateUniqueParam.MemberParams_PipeDelimited();
			fileUpdateValue.put(globalVariables.MolinaMedicaid_ID, CommonMethods.generateRandomStringOfFixLength(12));
			
	   	    fileName =FileContentReader.createPipeDelimFileAndConvertToGPG(globalVariables.molinaGenericFile, fileUpdateValue);
			finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.Encryptfile+fileName);
		//	fileNames=FileContentReader.putGetFilefromServer(fileName+".gpg");
			Errormessage.add(globalVariables.memberMolinaMedicaid_IDNullError);
			
	//		Assertion_DbVerifier.assertControlFileValid(fileNames,fileName,finalMapapdataByRow);
			
	 }
	 
	 //Case2: MolinaMedicaidID_Uniqueness (Sending another request with same/existing Medicateid
	 @Test
	 public void SEVV_4975_Member_MolinaMedicaidID_Uniqueness() throws Exception{
		 logger = extent.startTest("SEVV_4975_Member_MolinaMedicaidID_Uniqueness");  
			
			Map<String ,String> fileUpdateValue = new HashMap<>();
			Map<String ,String> finalMapapdataByRow = new HashMap<>();
			List<String> fileNames;
			 String fileName;
			 List<String> Errormessage = new ArrayList<String>();
				
			
			fileUpdateValue=GenerateUniqueParam.MemberParams_PipeDelimited();
			fileUpdateValue.put(globalVariables.MolinaMedicaid_ID, CommonMethods.generateRandomStringOfFixLength(3));
			
	   	    fileName =FileContentReader.createPipeDelimFileAndConvertToGPG(globalVariables.molinaGenericFile, fileUpdateValue);
			finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.Encryptfile+fileName);
		//	fileNames=FileContentReader.putGetFilefromServer(fileName+".gpg");
		
			
	//		Assertion_DbVerifier.assertControlFileValid(fileNames,fileName,finalMapapdataByRow);
			
	 }

	}
