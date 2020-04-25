package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class ScrollUtil {
	private ScrollUtil() {}
    public static void scrollPageByPixels(int pixels){
        JSUtil.executeScript(String.format("scroll(0,%s)",pixels));
    }
    public static void scrollPageToBottom(){
        JSUtil.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }
    public static void scrollIntoViewElement(WebElement element){
    	JSUtil.executeScript("arguments[0].scrollIntoView(true);",element);
    }
    
  //Scroll Page Up
    public static void scrollPageUP(){
    	JSUtil.executeScript("window.scrollTo(document.body.scrollHeight,0)");
    }
    public static void scrollUp(WebElement element)//Created by Loveen
    {
    	JavascriptExecutor js = (JavascriptExecutor)Driver.getInstance().getCurrentDriver();
		js.executeScript("arguments[0].scrollIntoView();", element);
		utils.WaitUtil.sleep(2);
    }
}
