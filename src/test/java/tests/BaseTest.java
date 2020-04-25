package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import exceptions.RunTimeException;
import reporting.TestLog;
import utils.Driver;

public abstract class BaseTest {
	protected WebDriver driver;
	protected static TestLog testLog;

	@BeforeSuite
	public void setSuiteConfig() throws IOException {
		//Runtime.getRuntime().exec("cmd /c start \"\" delete-old-results.BAT");
		testLog = TestLog.init();
	}

	@BeforeClass
	public void aaaSetupClassConfig() {
		testLog.createExtentRptTest(getClass().getSimpleName());
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