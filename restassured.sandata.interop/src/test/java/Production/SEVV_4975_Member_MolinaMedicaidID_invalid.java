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

public class SEVV_4975_Member_MolinaMedicaidID_invalid extends BaseTest{
	List<String> Errormessage = new ArrayList<String>();
	Map<String ,String> fileUpdateValue = new HashMap<>();
	Map<String ,String> finalMapapdataByRow = new HashMap<>();
	List<String> fileNames;
	 String fileName;
	 String MedIdVar;
	 @Test
	 public void SEVV_4975_Member_MolinaMedicaidID_Blank() throws Exception{
		 logger = extent.startTest("SEVV_4975_Member_MolinaMedicaidID_Blank");  
							
			fileUpdateValue=GenerateUniqueParam.MemberParams_PipeDelimited();
			fileUpdateValue.put(globalVariables.MolinaMedicaid_ID, "");
	   	    fileName =FileContentReader.createPipeDelimFileAndConvertToGPG(globalVariables.molinaGenericFile, fileUpdateValue);
			finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.Encryptfile+fileName);
			//fileNames=FileContentReader.putGetFilefromServer(fileName+".gpg");
			Errormessage.add(globalVariables.memberMolinaMedicaid_IDNullError);
			
			Assertion_DbVerifier.assertControlFileInValid(fileNames,fileName,Errormessage);
			
	 }
	 @Test
	 public void SEVV_4975_Member_MolinaMedicaidID_GreaterThanMax() throws Exception{
		 logger = extent.startTest("SEVV_4975_Member_MolinaMedicaidID_GreaterThanMax");  
			
			Map<String ,String> fileUpdateValue = new HashMap<>();
			Map<String ,String> finalMapapdataByRow = new HashMap<>();
			List<String> fileNames;
			 String fileName;
			 List<String> Errormessage = new ArrayList<String>();
				
			
			fileUpdateValue=GenerateUniqueParam.MemberParams_PipeDelimited();
			fileUpdateValue.put(globalVariables.MolinaMedicaid_ID, CommonMethods.generateRandomStringOfFixLength(25));
	   	    fileName =FileContentReader.createPipeDelimFileAndConvertToGPG(globalVariables.molinaGenericFile, fileUpdateValue);
			finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.Encryptfile+fileName);
			//fileNames=FileContentReader.putGetFilefromServer(fileName+".gpg");
			Errormessage.add(globalVariables.memberMolinaMedicaid_ID);
			
		//	Assertion_DbVerifier.assertControlFileInValid(fileNames,fileName,Errormessage);
			
	 }
	 
	 @Test
	 public void SEVV_4975_Member_MolinaMedicaidID_exceedmax_length() throws Exception{
		 logger = extent.startTest("SEVV_4975_Member_MolinaMedicaidID_exceedmax_length");  
			
			Map<String ,String> fileUpdateValue = new HashMap<>();
			Map<String ,String> finalMapapdataByRow = new HashMap<>();
			List<String> fileNames;
			 String fileName;
			 List<String> Errormessage = new ArrayList<String>();
				
			
			fileUpdateValue=GenerateUniqueParam.MemberParams_PipeDelimited();
			fileUpdateValue.put(globalVariables.MolinaMedicaid_ID, CommonMethods.generateRandomStringOfFixLength(13));
			String MedIdVar=fileUpdateValue.get(globalVariables.MolinaMedicaid_ID);
	   	    fileName =FileContentReader.createPipeDelimFileAndConvertToGPG(globalVariables.molinaGenericFile, fileUpdateValue);
			finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.Encryptfile+fileName);
		//	fileNames=FileContentReader.putGetFilefromServer(fileName+".gpg");
			Errormessage.add(globalVariables.memberMolinaMedicaid_ID);
			
		//	Assertion_DbVerifier.assertControlFileInValid(fileNames,fileName,Errormessage);
			
	 }

	 
	 @Test
	 public void SEVV_4975_Member_MolinaMedicaidID_withexisting_values() throws Exception{
		 logger = extent.startTest("SEVV_4975_Member_MolinaMedicaidID_withexisting_values");  
			
			Map<String ,String> fileUpdateValue = new HashMap<>();
			Map<String ,String> finalMapapdataByRow = new HashMap<>();
			List<String> fileNames;
			 String fileName;
			 List<String> Errormessage = new ArrayList<String>();
				
			
			fileUpdateValue=GenerateUniqueParam.MemberParams_PipeDelimited();
			fileUpdateValue.put(globalVariables.MolinaMedicaid_ID, MedIdVar);
			
	   	    fileName =FileContentReader.createPipeDelimFileAndConvertToGPG(globalVariables.molinaGenericFile, fileUpdateValue);
			finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.Encryptfile+fileName);
		//	fileNames=FileContentReader.putGetFilefromServer(fileName+".gpg");
			Errormessage.add(globalVariables.memberMolinaMedicaid_ID);
			
	//		Assertion_DbVerifier.assertControlFileInValid(fileNames,fileName,Errormessage);
			
	 }

	}
