package Production;

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

import Utills_ExtentReport_Log4j.BaseTest;

public class Bug_5747_TC98020_Provider_creation_with_blank_ProviderTaxonomy extends BaseTest {
	Map<String ,String> fileUpdateValue = new HashMap<>();
	Map<String ,String> finalMapapdataByRow = new HashMap<>();
	List<String> fileNames;
	 String fileName;
	 List<String> Errormessage =new ArrayList<String>();
	@Test
	 public void TC98020_Verify_Provider_creation_ProviderTaxonomy_blank() throws Exception{
		 logger = extent.startTest("TC98020_Verify_Provider_creation_ProviderTaxonomy_blank");  
			fileUpdateValue=GenerateUniqueParam.providerParams_PipeDelimited();
			fileUpdateValue.put(globalVariables.providertaxonomy, "");
	   	    fileName =FileContentReader.createPipeDelimFileProviderAndConvertToGPG(globalVariables.molinaProviderGenericFile, fileUpdateValue);
			finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.Encryptfile+fileName);
		//	fileNames=FileContentReader.putGetFilefromServer(fileName+".gpg");
			Assertion_DbVerifier.verify_ImportFile_Provider_STx_Account(finalMapapdataByRow);
			
			
			
	 }

}
