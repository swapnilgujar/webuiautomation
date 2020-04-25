package elements;

import org.openqa.selenium.WebElement;
import reporting.TestLog;

public class RadioButtonElement extends CommonElement {
    public RadioButtonElement(WebElement element, String name) {
        super(element, name);
   }
    public void check(){
        TestLog.get().info(String.format("select radio ['%s'] button",getWrappedElement().getText()));
        getWrappedElement().click();

    }
}
