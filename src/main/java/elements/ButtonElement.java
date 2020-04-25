package elements;

import org.openqa.selenium.WebElement;

import reporting.TestLog;
import utils.WaitUtil;

public class ButtonElement extends CommonElement {
    public ButtonElement(WebElement element,String name) {
        super(element, name);
    }

    @Override
    public void click(){
        TestLog.get().info(String.format("click on ['%s'] button",getName()));
        if(getName().contains("Next")) {
        	WaitUtil.sleep(3);
        }
        getWrappedElement().click();
        WaitUtil.waitForPageLoad();
    }
}
