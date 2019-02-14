package AltEVV_molina.restassured.sandata.Employee;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import com.globalMethods.core.GenerateUniqueParam;

/**
 * @author Kumar Rahul
 *
 */
public class R2267_TC91508_AltEVV_ProviderQualifier {
	
	@Test(groups = {"functest"})
	public void R2267_TC91508_AltEVV_ProviderQualifier_Valid_Invalid_Scenario() throws FileNotFoundException, IOException, ParseException{
	
		
		//To Validate the positive scenario for ProviderQualifier support "SandataID", "NPI", "API", "MedicaidID", "TaxID", "Taxonomy", "Legacy", "Other" these only 
	String ProviderQualifier[]={"SandataID", "NPI", "API", "MedicaidID", "TaxID", "Taxonomy", "Legacy", "Other"};
	
	
	GenerateUniqueParam.validateJsonResponseAltEVVSingleFieldEmployee(ProviderQualifier,"Valid","ProviderQualifier");
	
	//To Validate the negative scenario for ProviderQualifier doesnot  support "SandataID", "NPI", "API", "MedicaidID", "TaxID", "Taxonomy", "Legacy", "Other" these only
     String invalidProviderQualifier[]={"ASSSDDD", "!!@DDDDD", "1122233ssddd", "hdhhdhshdhdsadadsdsad"};
	
	
	GenerateUniqueParam.validateJsonResponseAltEVVSingleFieldEmployee(invalidProviderQualifier,"inValid","ProviderQualifier");
	
	}
}
