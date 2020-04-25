package tests;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import exceptions.RunTimeException;
import reporting.TestLog;
import utils.Driver;

public abstract class BaseTest {
	protected WebDriver driver;
	protected static TestLog testLog;

	@BeforeSuite
	public void setSuiteConfig() throws IOException {
		testLog = TestLog.init();
	}

	@BeforeClass
	public void aaaSetupClassConfig() {
		//added same code in @BeforeMethod 
		//testLog.createExtentRptTest(getClass().getSimpleName());
		//moved below code to @BeforeMethod to relaunch browser 
		//for each test execution
		/*try {
			driver = Driver.getInstance().initialize();
		} catch (Exception e) {
			testLog.error(e);
			throw new RunTimeException(e);
		}*/
	}

	@BeforeMethod
	public void setup(Method method) {
		String testMethodName = method.getName(); 
		testLog.createExtentRptTest(testMethodName);
		try {
			driver = Driver.getInstance().initialize();
		} catch (Exception e) {
			testLog.error(e);
			throw new RunTimeException(e);
		}
	}

	@AfterMethod
	public void checkTestResult(ITestResult result) {
		try {
			testLog.testResult(result);
		} catch (Exception e) {
			testLog.error(e);
			throw new RunTimeException(e);
		}
		driver.quit();
	}

	@AfterTest
	public void zzz_afterClassConfig() {
		//moved same code to @AfterMethod so that browser instance
		//is closed after every test execution
		//driver.quit();
	}


	@AfterSuite
	public void endSuiteConfig() {
		try {
			testLog.generateExtentReport();

		} catch (Exception e) {
			testLog.error(e);
			throw new RunTimeException(e);
		}

	}

}