package Molina.sandata.Provider;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.FileContentReader;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;

import Utills_ExtentReport_Log4j.BaseTest;

public class R2138_TC96241_Verify_for_created_providers_in_inbox extends BaseTest {
	 @Test
	 public void R2138_TC96241_Verify_for_created_providers_in_inbox_provider() throws Exception{
		 logger = extent.startTest("R2138_TC96241_Verify_for_created_providers_in_inbox_provide");  
		 //////////////Variable declaration ///////////////////
			Map<String ,String> mapUpdateFileData = new HashMap<>();
			Map<String ,String> finalMapapdataByRow = new HashMap<>();
			String FileName;
			
			/////////////////////Creating map for required Field map/////////////
			mapUpdateFileData=GenerateUniqueParam.MemberParams_PipeDelimited();
			
			
		     FileName =FileContentReader.createPipeDelimFileAndConvertToGPG(globalVariables.molinaGenericFile, mapUpdateFileData);
			
			finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.Encryptfile+FileName);
			
	 }


}
