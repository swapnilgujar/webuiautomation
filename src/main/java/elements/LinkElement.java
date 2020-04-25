package elements;

import org.openqa.selenium.WebElement;
import reporting.TestLog;
import utils.WaitUtil;

public class LinkElement extends CommonElement {
    public LinkElement(WebElement element, String name) {
        super(element, name);
    }
    @Override
    public void click(){
        TestLog.get().info(String.format("click on ['%s'] link",getName()));
        getWrappedElement().click();
        WaitUtil.waitForPageLoad();
    }
}
