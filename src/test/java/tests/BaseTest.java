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
		try {
			driver = Driver.getInstance().initialize();
		} catch (Exception e) {
			testLog.error(e);
			throw new RunTimeException(e);
		}
	}
	
	@BeforeMethod
	public void setup(Method method) {
	    String testMethodName = method.getName(); 
	    testLog.createExtentRptTest(testMethodName);
	}

	@AfterMethod
	public void checkTestResult(ITestResult result) {
		try {
			testLog.testResult(result);
		} catch (Exception e) {
			testLog.error(e);
			throw new RunTimeException(e);
		}
	}

	@AfterTest
	public void zzz_afterClassConfig() {
			driver.quit();
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