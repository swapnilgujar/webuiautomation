package utils;

import com.google.common.base.Function;
import reporting.TestLog;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtil {
    private static Logger logger = Logger.getLogger(WaitUtil.class);


	private WaitUtil(){}
    public static boolean waitForPageLoad()
    {
        boolean status;
        Wait<WebDriver> wait = new WebDriverWait(Driver.getInstance().getCurrentDriver(), Constants.PAGE_LOAD_TIMEOUT);
        status =wait.until((Function<WebDriver, Boolean>) driver -> {
            String state=String.valueOf(JSUtil.executeScript("return document.readyState;"));
            logger.info("Page Loading Status : "+ state);
            return state.equals("complete");
        });
        return status;
    }

    @SuppressWarnings({"rawtypes","unchecked"})
	public static boolean fluentWaitForElementPresent(WebElement element){

		Wait<WebDriver> wait = new FluentWait(Driver.getInstance().getCurrentDriver())
                .withTimeout(java.time.Duration.ofSeconds(Constants.MAX_TIMEOUT))
                .pollingEvery(java.time.Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);

        WebElement foo = (WebElement) wait.until((Function) driver -> element);
        return foo.isDisplayed();
    }
    public static boolean waitForElementClickable(WebElement element){
        WebDriverWait wait = new WebDriverWait(Driver.getInstance().getCurrentDriver(), Constants.DEFAULT_TIMEOUT*2);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        return true;
    }
    public static boolean waitForVisibilityOfElement(WebElement element){
        WebDriverWait wait = new WebDriverWait(Driver.getInstance().getCurrentDriver(), Constants.DEFAULT_TIMEOUT);
        WebElement element1=wait.until(ExpectedConditions.visibilityOf(element));
        return element1.isDisplayed();
    }
    public static boolean waitForInvisibilityOfElement(WebElement element){
        WebDriverWait wait = new WebDriverWait(Driver.getInstance().getCurrentDriver(), Constants.DEFAULT_TIMEOUT);
        return wait.until(ExpectedConditions.invisibilityOf(element));
    }
    public static void waitForSpinnerDisappears(){
        waitForInvisibilityOfElement(Driver.getInstance().getCurrentDriver().findElement(By.cssSelector("i.fa.fa-spinner.fa-spin")));
    }
	public static void sleep(int seconds) {
		try {
			Thread.sleep(seconds * 1000L);
		} catch (Exception e) {
			TestLog.get().info(e.getMessage());
		}		
	}
	public static boolean checkSpinner()
    {
    	return waitForVisibilityOfElement(Driver.getInstance().getCurrentDriver().findElement(By.xpath("//*//div[contains(normalize-space(),'Please wait...')]")));
    }
}
