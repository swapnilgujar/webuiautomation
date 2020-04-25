package elements;

import org.openqa.selenium.WebElement;
import reporting.TestLog;

public class TextAreaElement extends CommonElement 
{
    public TextAreaElement(WebElement element, String name) 
    {
        super(element, name);
   }
    @Override
    public void setValue(String input){
        TestLog.get().info(String.format("set ['%s'] into ['%s'] Text_Area",input,getName()));
        clear();
        super.setValue(input);
    }
    public void appendValue(String input){
        TestLog.get().info(String.format("set ['%s'] into [%s ] TextArea ",input,getName()));
        getWrappedElement().sendKeys(input);
    }
    public String getValue(){
        String value=getAttribute("value");
        TestLog.get().info(String.format("Text_Area ['%s'] has value as ['%s']",getName(),value));
        return value;
    }

}
