
package Molina.sandata.Member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.testng.annotations.Test;
import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.FileContentReader;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;

import Utills_ExtentReport_Log4j.BaseTest;

public class SEVV_323_TC94635_TC94638_Member_Invalid_ClientLastName extends BaseTest{
//////////////Variable declaration ///////////////////
Map<String ,String> mapUpdateFileData = new HashMap<>();
Map<String ,String> finalMapapdataByRow = new HashMap<>();
Map<String ,String> mapOutboundData = new HashMap<>();
String FileName;
List<String> fileNames;

List<String> Errormessage = new ArrayList<String>();
	 @Test
	 
	 public void SEVV_323_TC94635_Member_Invalid_ClientLastName_greater_Max() throws Exception{
		 logger = extent.startTest("SEVV_323_TC94635_Member_Invalid_ClientLastName_greater_Max");  
		 
	        logger.log(LogStatus.INFO,"Creating map for removing the required  Field map");
             mapUpdateFileData=GenerateUniqueParam.MemberParams_PipeDelimited();
             mapUpdateFileData.put(globalVariables.molinaClientLastName,  CommonMethods.generateRandomStringOfFixLength(31));
     		logger.log(LogStatus.INFO,"create the PipeDeliminated File and Encrypt to GPG");
     		FileName =FileContentReader.createPipeDelimFileAndConvertToGPG(globalVariables.molinaGenericFile, mapUpdateFileData);


     		logger.log(LogStatus.INFO,"No of file processed and data in the file and create the Outbound file ");
     		mapOutboundData.put(FileName, "1");
     		String outboundFileName= FileContentReader.createOutboundFileAndEncrypt(mapOutboundData);

     		logger.log(LogStatus.INFO,"process the Files and get the control file ");
     		finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.Encryptfile+FileName);
     		fileNames=FileContentReader.putGetFilefromServer(FileName,outboundFileName,"Error");

     		logger.log(LogStatus.INFO,"Veirfying the ErrorFile generated ");
     		  Errormessage.add(globalVariables.memberClientLastNameLengthError);
     		Assertion_DbVerifier.assertControlFileInValid(fileNames,FileName,Errormessage);
	 }
 @Test
	 
	 public void SEVV_323_TC94638_Member_ClientLastName_blank () throws Exception{
		 logger = extent.startTest("SEVV_323_TC94638_Member_ClientLastName_blank ");  
		  logger.log(LogStatus.INFO,"Creating map for removing the required  Field map");
              mapUpdateFileData=GenerateUniqueParam.MemberParams_PipeDelimited();
              mapUpdateFileData.put(globalVariables.molinaClientLastName,  " ");
      		logger.log(LogStatus.INFO,"create the PipeDeliminated File and Encrypt to GPG");
      		FileName =FileContentReader.createPipeDelimFileAndConvertToGPG(globalVariables.molinaGenericFile, mapUpdateFileData);


      		logger.log(LogStatus.INFO,"No of file processed and data in the file and create the Outbound file ");
      		mapOutboundData.put(FileName, "1");
      		String outboundFileName= FileContentReader.createOutboundFileAndEncrypt(mapOutboundData);

      		logger.log(LogStatus.INFO,"process the Files and get the control file ");
      		finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.Encryptfile+FileName);
      		fileNames=FileContentReader.putGetFilefromServer(FileName,outboundFileName,"Error");

      		logger.log(LogStatus.INFO,"Veirfying the ErrorFile generated ");
      		 Errormessage.add(globalVariables.memberClientLastNameLengthError);
      		Assertion_DbVerifier.assertControlFileInValid(fileNames,FileName,Errormessage);
	 }
	
	}

