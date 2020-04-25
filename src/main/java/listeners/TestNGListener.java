package listeners;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import reporting.TestLog;
import utils.Driver;

import org.apache.log4j.Logger;

public class TestNGListener implements ITestListener {
    private static Logger logger = Logger.getLogger(TestNGListener.class);
    @Override
    public void onTestStart(ITestResult iTestResult) {
        logger.info("TestNGListener :: onTestStart :: "+iTestResult.getName());
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        logger.info("TestNGListener :: onTestSuccess :: "+iTestResult.getName());
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        logger.info("TestNGListener :: onTestFailure :: "+iTestResult.getName());

    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        logger.info("TestNGListener :: onTestSkipped :: "+iTestResult.getName());

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        logger.info("TestNGListener :: onTestFailedButWithinSuccessPercentage :: "+iTestResult.getName());

    }

    @Override
    public void onStart(ITestContext iTestContext) {
        logger.info("TestNGListener :: onStart :: "+iTestContext.getName());

    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        logger.info("TestNGListener :: onFinish :: "+iTestContext.getName());
        try {
        	Driver.getInstance().getCurrentDriver().quit();
        }catch (Exception e) {
        	TestLog.get().info("unable to close browser...");
		}
    }
}
