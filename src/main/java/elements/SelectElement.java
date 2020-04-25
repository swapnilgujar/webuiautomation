package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import reporting.TestLog;
import utils.WaitUtil;
import utils.Driver;

public class SelectElement extends CommonElement {
    public SelectElement(WebElement element, String name) {
        super(element, name);
   }
    public void select(String input){
        TestLog.get().info(String.format("Select visible text['%s'] in ['%s'] select element",input,getName()));
    	WaitUtil.sleep(3);
    	WaitUtil.waitForElementClickable(getWrappedElement());
    	getWrappedElement().findElement(By.cssSelector("div[class='mat-select-arrow']")).click();
        String eleXpath=String.format("//span[starts-with(@class,'mat-option-text') and normalize-space(.)='%s']", input);
        WaitUtil.waitForElementClickable(Driver.getInstance().getCurrentDriver().findElement(By.xpath(eleXpath)));
        Driver.getInstance().getCurrentDriver().findElement(By.xpath(eleXpath)).click();
    	WaitUtil.sleep(1);
        
    }
    
    public void selectMultiple(String input)
    {
        TestLog.get().info(String.format("Select visible text['%s'] in ['%s'] select element",input,getName()));
        WaitUtil.sleep(3);
         String eleXpath=String.format("//span[starts-with(@class,'mat-option-text') and normalize-space(.)='%s']", input);
         WaitUtil.waitForElementClickable(Driver.getInstance().getCurrentDriver().findElement(By.xpath(eleXpath)));
         Driver.getInstance().getCurrentDriver().findElement(By.xpath(eleXpath)).click();
        WaitUtil.sleep(3);
     }
    public String getValue(){
    	String value=getWrappedElement().findElement(By.cssSelector("span:not([class^='mat-select-value-text'])")).getText();
        TestLog.get().info(String.format("select element ['%s'] has value as ['%s']",getName(),value));
        return value;
    }

}
