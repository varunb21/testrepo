package Utills_ExtentReport_Log4j;

import com.config.Configuration;
import com.config.*;
import com.core.Wrapper;
import com.globalMethods.core.GenerateDataEntities;
import com.globalMethods.core.GenerateUniqueParam;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.utilities.DateTimeUtil;
import com.ws.DWHServices;
import com.ws.WebServicesBase;

import org.junit.AfterClass;
import org.testng.ITestResult;
import org.testng.annotations.*;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class BaseTest
{
	public static ExtentReports extent;
	public static ExtentTest logger ;

	private String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());

	protected DateTimeUtil dateTimeUtil;
	protected DWHServices dWHServices;

	protected WebServicesBase webServicesBase;
	protected GenerateUniqueParam generateUniqueParam;
	protected GenerateDataEntities generateDataEntities;
	protected Environment environment;
	protected TestData testData;

	private boolean headlessMode = false;
	public String envType;
	public String startClassTime;
	private Wrapper baseObj = new Wrapper();
	public String testcaseID;
	public String projectName;

	private Configuration configuration;
	private ObjectRepository objectRepository;



	public BaseTest(){
		dateTimeUtil = new DateTimeUtil();
		dWHServices = new DWHServices();
		webServicesBase = new WebServicesBase();
		configuration = new Configuration();
		objectRepository = new ObjectRepository();
		environment = new Environment();
		testData = new TestData();
		generateUniqueParam = new GenerateUniqueParam();
		generateDataEntities = new GenerateDataEntities();
	}

	public TestData getTestData(){
		return testData;
	}

	/**
	 * Log the info before the test case is run
	 */
	@BeforeTest
	public void startReport(){
		extent = new ExtentReports (System.getProperty("user.dir") +"/test-output/Report_Api_automation"+ timeStamp +".html", true);
		extent.addSystemInfo("Host Name", "NST")
				.addSystemInfo("Environment", "Automation Testing Report")
				.addSystemInfo("User Name", "Rahul Rohit");
		extent.loadConfig(new File(System.getProperty("user.dir")+ File.separator+ "extent-config.xml"));
	}

	/**
	 * Log the result after the method is run
	 */
	@AfterMethod
	public void getResult(ITestResult result){
		if(result.getStatus() == ITestResult.FAILURE){
			logger.log(LogStatus.FAIL, "Test Case Failed is "+ result.getName());
			logger.log(LogStatus.FAIL, "Test Case Failed is "+ result.getThrowable());
		}else if(result.getStatus() == ITestResult.SKIP){
			logger.log(LogStatus.SKIP, "Test Case Skipped is "+ result.getName());
		}
		else {
			logger.log(LogStatus.PASS, "Test Case Passed  " + result.getName());
		}
		System.gc();
		extent.endTest(logger);
	}

	/**
	 * End the report object before end test
	 */
	@AfterTest
	public void endReport(){
		
		extent.flush();

		extent.close();
	}
	

	@BeforeClass(
			alwaysRun = true
	)
	
	
	@Parameters({"environment", "headless"})
	public void beforeClass(@Optional("Environment") String environment, @Optional("false") boolean headless) {

		this.headlessMode = headless;
		this.envType = environment;
		System.out.println("------------------ @BeforeClass fired------------------------");
		String testCaseName = this.getClass().getSimpleName();
		this.startClassTime = baseObj.getCurrentTime();
		Pattern p = Pattern.compile("TC\\d{1,6}");
		Matcher m = p.matcher(testCaseName);
		if (m.find()) {
			testcaseID = m.group(0);
		}
		projectName = testCaseName.split("_")[1];

		logger = new ExtentTest(testcaseID, "");

		initTestConfiguration();
	}


	private void initTestConfiguration() {
		TestConfiguration testConfig = new TestConfiguration();
		testConfig.setTestCaseID(testcaseID);
		testConfig.loadTestCaseData();
		if(!testConfig.testDataIsNotFound()){
			testConfig.loadEnvironment(this.envType);
			configuration = testConfig.getConfiguration();
			objectRepository = testConfig.getObjectRepository();
			environment = testConfig.getEnvironment();
			testData = testConfig.getTestData();
			configuration.setHeadless(this.headlessMode);
		}
	}
}