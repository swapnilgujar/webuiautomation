package reporting;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import utils.Driver;

public class TestLog {
	private static Logger logger = Logger.getLogger(TestLog.class);
	private static ExtentReports extentReports;

	private ExtentTest extentTest;
	protected static TestLog testLog;
	
	protected static String currentDateTime = null;

	private TestLog() {	}

	public static TestLog init() {
		ExtentHtmlReporter htmlReporter;
		PropertyConfigurator.configure("src/main/resources/log4j.properties");
		 currentDateTime = new SimpleDateFormat("dd-MMMM-yyyy_HH.mm.ss").format(Calendar.getInstance().getTime());
		get();
		htmlReporter = new ExtentHtmlReporter("test-results\\extent-report_"+currentDateTime+".html");
		htmlReporter.config().setTheme(Theme.DARK);
		extentReports = new ExtentReports();
		extentReports.attachReporter(htmlReporter);
		return get();
	}

	public void createExtentRptTest(String testMethodName) {
		extentTest = extentReports.createTest(testMethodName);
		testMethodName(String.format("Test Method Name -> [%s]", testMethodName));
	}

	public void createExtentRptTest(String testName, String testDescription) {
		extentTest = extentReports.createTest(testName, testDescription);
		testClassName(String.format("Test Class -> [%s]", testName));
		info("TestClassDescription=" + testDescription);
	}

	public void createExtentRptNode(String nodeName) {
		extentTest.createNode(nodeName);
		info("NodeName=" + nodeName);
	}

	public void createExtentRptNode(String nodeName, String nodeDescription) {
		extentTest.createNode(nodeName, nodeDescription);
		info("NodeName=" + nodeName);
		info("NodeDescription=" + nodeDescription);
	}

	public void info(String logText) {
		logger.info(logText);
		extentTest.info("<font>" + logText + "</font>");
	}

	private void testClassName(String testClassName) {
		logger.info(testClassName);
		extentTest.info(markupText(testClassName, ExtentColor.CYAN));
	}
	
	//25-04-20:created to print test Method name
	private void testMethodName(String testMethodName) {
		logger.info(testMethodName);
		extentTest.info(markupText(testMethodName, ExtentColor.CYAN));
	}
	

	public void error(String logText) {
		logger.error(logText);
		extentTest.error(logText);
	}

	public void error(Throwable throwable) {
		logger.error(throwable.getMessage());
		extentTest.error(throwable);
	}

	public void error(String errorMsg, Throwable throwable) {
		logger.error(errorMsg);
		logger.error(throwable.getMessage());
		error(errorMsg);
		error(throwable);
	}

	public void error(ITestResult result, MediaEntityModelProvider mediaFile) {
		String errorMsg = String.format("Test Case [%s] failed, due to error:: %s", result.getName(),
				result.getThrowable().getMessage());
		logger.error(errorMsg);
		logger.error(result.getThrowable());
		extentTest.error("<font color=\"#ff0048\">" + errorMsg + "</font>", mediaFile);
		extentTest.error(result.getThrowable());
	}

	public void pass(String logText) {
		logger.info(String.format("TEST PASSED::%s", logText));
		extentTest.pass(String.format("<font color=\"#00dd6a\">TEST PASSED::%s</font>", logText));
	}

	public void fail(String logText) {
		logger.fatal("TEST FAILED::" + logText);
		extentTest.fail(String.format("<font color=\"#ff0048\">TEST FAILED::%s</font>", logText));
	}

	public void skip(String logText) {
		logger.warn("TEST SKIPPED::" + logText);
		extentTest.skip(String.format("<font color=\"orange\">TEST SKIPPED::%s</font>", logText));
	}

	public void testResult(ITestResult result) {

		if (result.getStatus() == ITestResult.FAILURE) {
			if (result.getThrowable().getMessage() == null) {
				logger.error("NullPointerException");
			}
			String testName = String.format("%s_%s_", result.getTestClass().getName(), result.getName());
			String path = testLog.takeScreenshot(testName);
			try {
				testLog.error(result, MediaEntityBuilder.createScreenCaptureFromPath(path).build());
			} catch (IOException e1) {
				testLog.info("------DO NOTHING, IF NOT SCREENSHOT CAPTURED--------------");
			}

		} else if (result.getStatus() == ITestResult.SKIP) {
			skip(String.format("Test Name [%s] Skipped", result.getName()));
			error(result.getThrowable());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			pass(String.format("Test Name [%s] Passed", result.getName()));
		}
	}

	public void generateExtentReport() {
		extentReports.flush();
	}

	public static TestLog get() {
		if (null == testLog) {
			testLog = new TestLog();
		}
		return testLog;
	}

	public void setTestName(String testName) {

		//extentTest.info(String.format("<font color=\"#039be5\">TestName:: [%s] started</font>",testName));

		extentTest.info(String.format("<font color=\"#039be5\">TestName:: [%s] started</font>", testName));
		logger.info(String.format("*TestName:: [%s] started...", testName));

	}

	public void preCondition(String preCondition) {
		info(String.format("Pre-Condition= [%s]", preCondition));
	}

	public void expectedCondition(String expectedCondition) {
		info(String.format("Expected Condition= [%s]", expectedCondition));
	}

	public String takeScreenshot(String testName) {
		testName = testName.replaceAll(" ", "_");
		TakesScreenshot takesScreenshot = (TakesScreenshot) Driver.getInstance().getCurrentDriver();
		File src = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String projectPath = System.getProperty("user.dir");
		long milli = System.currentTimeMillis();
		String filePath = projectPath + "\\test-results\\screenshots\\" + testName + milli + ".png";
		File dest = new File(filePath);
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			TestLog.get().error("*** screenshot capture failed! ***\n" + Arrays.toString(e.getStackTrace()));
		}
		return filePath;
	}

	private Markup markupText(String text, ExtentColor color) {
		return MarkupHelper.createLabel(text, color);
	}

	public void console(String message) {
		logger.info(message);

	}

	public void console(Object message) {
		logger.info(message);
	}

	public void description(String string) {
		
		preCondition(string);
		
	}


}