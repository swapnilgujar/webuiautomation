package pages.login;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import exceptions.RunTimeException;
import pages.BasePage;
import reporting.TestLog;
import utils.CommonUtil;
import utils.WaitUtil;

public class HomePage extends BasePage{
	
	@FindBy(xpath = "//h1[contains(text(),'Tutorials Library')]")
    WebElement headerTutorialLibraray;
	
	private HomePage() {
		super();
		TestLog.get().console("window handle=" + driver.getWindowHandle());
		PageFactory.initElements(driver, this);
		try {
			headerTutorialLibraray.isDisplayed();
		}catch (RunTimeException e) {
            throw new RunTimeException(String.format("[%s] not present",CommonUtil.getClassName(getClass().getSimpleName())));
		}
	}

	public static HomePage getInstance() {
		return new HomePage();		
	}
	
	public String getPageHeader()
    {
    	WaitUtil.waitForVisibilityOfElement(headerTutorialLibraray);
    	return headerTutorialLibraray.getText();
    }
}
