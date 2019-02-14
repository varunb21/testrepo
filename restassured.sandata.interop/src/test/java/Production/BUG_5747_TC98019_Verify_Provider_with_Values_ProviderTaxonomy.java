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

public class BUG_5747_TC98019_Verify_Provider_with_Values_ProviderTaxonomy extends BaseTest{
	Map<String ,String> fileUpdateValue = new HashMap<>();
	Map<String ,String> finalMapapdataByRow = new HashMap<>();
	List<String> fileNames;
	 String fileName;
	 @Test
	 public void TC98019_Verify_Provider_creation_ProviderTaxonomy_specialcharacter() throws Exception{
		 logger = extent.startTest("TC98019_Verify_Provider_creation_ProviderTaxonomy_specialcharacter");  
			
		
				
			
			fileUpdateValue=GenerateUniqueParam.providerParams_PipeDelimited();
			fileUpdateValue.put(globalVariables.providertaxonomy,CommonMethods.generateSpecialChar(9));
			 fileName =FileContentReader.createPipeDelimFileProviderAndConvertToGPG(globalVariables.molinaProviderGenericFile, fileUpdateValue);
				finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.Encryptfile+fileName);
			//	fileNames=FileContentReader.putGetFilefromServer(fileName+".gpg");
				Assertion_DbVerifier.verify_ImportFile_Provider_STx_Account(finalMapapdataByRow);
			
			
			
	 }

	 
	 @Test
	 public void TC98019_Verify_Provider_creation_ProviderTaxonomy_alphabet() throws Exception{
		 logger = extent.startTest("TC98019_Verify_Provider_creation_ProviderTaxonomy_alphabet");  
	
			fileUpdateValue=GenerateUniqueParam.providerParams_PipeDelimited();
			fileUpdateValue.put(globalVariables.providertaxonomy, CommonMethods.generateRandomStringOfFixLength(9));
			 fileName =FileContentReader.createPipeDelimFileProviderAndConvertToGPG(globalVariables.molinaProviderGenericFile, fileUpdateValue);
				finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.Encryptfile+fileName);
			//	fileNames=FileContentReader.putGetFilefromServer(fileName+".gpg");
				Assertion_DbVerifier.verify_ImportFile_Provider_STx_Account(finalMapapdataByRow);
			
			
	 }
	 
	 @Test
	 public void TC98019_Verify_Provider_creation_ProviderTaxonomy_alphanumeric() throws Exception{
		 logger = extent.startTest("TC98019_Verify_Provider_creation_ProviderTaxonomy_alphanumeric");  
		
			
			fileUpdateValue=GenerateUniqueParam.providerParams_PipeDelimited();
			fileUpdateValue.put(globalVariables.providertaxonomy, CommonMethods.generateRandomAlphaNumeric(9));
			 fileName =FileContentReader.createPipeDelimFileProviderAndConvertToGPG(globalVariables.molinaProviderGenericFile, fileUpdateValue);
				finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.Encryptfile+fileName);
			//	fileNames=FileContentReader.putGetFilefromServer(fileName+".gpg");
				Assertion_DbVerifier.verify_ImportFile_Provider_STx_Account(finalMapapdataByRow);
			
			
	 }
	 @Test
	 public void TC98019_Verify_Provider_creation_ProviderTaxonomy_numeric() throws Exception{
		 logger = extent.startTest("TC98019_Verify_Provider_creation_ProviderTaxonomy_numeric");  
	
			fileUpdateValue=GenerateUniqueParam.providerParams_PipeDelimited();
			fileUpdateValue.put(globalVariables.providertaxonomy, CommonMethods.generateRandomNumberOfFixLength(9));
			 fileName =FileContentReader.createPipeDelimFileProviderAndConvertToGPG(globalVariables.molinaProviderGenericFile, fileUpdateValue);
				finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.Encryptfile+fileName);
				//fileNames=FileContentReader.putGetFilefromServer(fileName+".gpg");
				Assertion_DbVerifier.verify_ImportFile_Provider_STx_Account(finalMapapdataByRow);
			
			
	 }
	 
	 @Test
	 public void TC98019_Verify_Provider_creation_ProviderTaxonomy_allspace() throws Exception{
		 logger = extent.startTest("TC98019_Verify_Provider_creation_ProviderTaxonomy_allspace");  

			fileUpdateValue=GenerateUniqueParam.providerParams_PipeDelimited();
			fileUpdateValue.put(globalVariables.providertaxonomy, "         ");
			 fileName =FileContentReader.createPipeDelimFileProviderAndConvertToGPG(globalVariables.molinaProviderGenericFile, fileUpdateValue);
				finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.Encryptfile+fileName);
				//fileNames=FileContentReader.putGetFilefromServer(fileName+".gpg");
				Assertion_DbVerifier.verify_ImportFile_Provider_STx_Account(finalMapapdataByRow);
			
			
			
	 }
	 
	 @Test
	 public void TC98019_Verify_Provider_creation_ProviderTaxonomy_leadingspace() throws Exception{
		 logger = extent.startTest("TC98019_Verify_Provider_creation_ProviderTaxonomy_leadingspace");  

			fileUpdateValue=GenerateUniqueParam.providerParams_PipeDelimited();
			fileUpdateValue.put(globalVariables.providertaxonomy,  CommonMethods.generateRandomNumberOfFixLength(8));
			 fileName =FileContentReader.createPipeDelimFileProviderAndConvertToGPG(globalVariables.molinaProviderGenericFile, fileUpdateValue);
				finalMapapdataByRow=FileContentReader.getFileDataOnMap(globalVariables.Encryptfile+fileName);
			//	fileNames=FileContentReader.putGetFilefromServer(fileName+".gpg");
				Assertion_DbVerifier.verify_ImportFile_Provider_STx_Account(finalMapapdataByRow);
			
			
			
	 }

}
