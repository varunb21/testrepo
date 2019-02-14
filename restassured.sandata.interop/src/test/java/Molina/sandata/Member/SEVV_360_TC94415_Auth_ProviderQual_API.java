package Molina.sandata.Member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.testng.annotations.Test;
import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.FileContentReader;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import Utills_ExtentReport_Log4j.BaseTest;

public class SEVV_360_TC94415_Auth_ProviderQual_API extends BaseTest{

	@Test
	public void SEVV_360_TC94415_Auth_ProviderQual_API_valid() throws Exception{
		
		logger = extent.startTest("SEVV_360_TC94415_Auth_ProviderQual_API_valid");  

		Map<String ,String> fileUpdateValue = new HashMap<>();
		Map<String ,String> finalMapapdataByRow = new HashMap<>();
		List<String> fileNames;
		String fileName;
	
		fileUpdateValue=GenerateUniqueParam.AuthParams_PipeDelimited();
		fileUpdateValue.put(globalVariables.molinaProviderQualifier, "API");
		
		fileName =FileContentReader.createPipeDelimFileAndConvertToGPG_Auth(globalVariables.molinaAuthGenericFile, fileUpdateValue);
		finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.Encryptfile+fileName);
		
	}


}
