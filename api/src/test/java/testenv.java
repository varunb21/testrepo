

import java.io.File;

import org.testng.annotations.Test;


public class testenv {

	@Test
	public void TC_1488() {
		System.out.println("Running tests on "+ System.getProperty("test.env"));
		if (System.getProperty("test.env").equalsIgnoreCase("THISISDEV")){
			System.out.println("On DEV");
			File file = new File(System.getProperty("user.dir") + File.separator+ "configDEV.properties");
		}
		
		else if (System.getProperty("test.env").equalsIgnoreCase("THISISQA")){
			System.out.println("On QA");
			File file = new File(System.getProperty("user.dir") + File.separator+ "configQA.properties");
		}
		
		else {
			System.out.println("Incorrect environment provided");
			
		}
		}
}