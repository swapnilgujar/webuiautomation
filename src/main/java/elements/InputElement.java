package elements;

import org.openqa.selenium.WebElement;
import reporting.TestLog;

public class InputElement extends CommonElement implements WebElement {
    public InputElement(WebElement element,String name) {
        super(element, name);
   }
    @Override
    public void setValue(String input){
        TestLog.get().info(String.format("set ['%s'] into ['%s'] text box",input,getName()));
        getWrappedElement().clear();
        getWrappedElement().sendKeys(input);
    }
    public void appendValue(String input){
        TestLog.get().info(String.format("set ['%s'] in to [%s] textbox",input,getName()));
        getWrappedElement().sendKeys(input);
    }
    public String getValue(){
        String value=getWrappedElement().getAttribute("value");
        TestLog.get().info(String.format("textbox ['%s'] has value as ['%s']",getName(),value));
        return value;
    }

}
