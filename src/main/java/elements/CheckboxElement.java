package elements;

import org.openqa.selenium.WebElement;
import reporting.TestLog;
import utils.JSUtil;

public class CheckboxElement extends CommonElement {
    public CheckboxElement(WebElement element, String name) {
        super(element, name);
    }
    public void check(){
        TestLog.get().info(String.format("check on ['%s'] checkbox",getName()));
        boolean isChecked= Boolean.parseBoolean(getWrappedElement().getAttribute("aria-checked"));
        if(!isChecked){
            JSUtil.clickByJS(getWrappedElement());
        }
    }
    public void click(){
        TestLog.get().info(String.format("click on ['%s'] checkbox",getName()));
        getWrappedElement().click();
}
    public void uncheck(){
        TestLog.get().info(String.format("uncheck on ['%s'] checkbox",getName()));
        boolean isChecked= Boolean.parseBoolean(getWrappedElement().getAttribute("aria-checked"));
        if(isChecked){
            getWrappedElement().click();
        }
    }
}
