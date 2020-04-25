package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class JSUtil {
	private JSUtil(){}
    public static Object executeScript(String scriptText) {
        return ((JavascriptExecutor) Driver.getInstance().getCurrentDriver()).executeScript(scriptText);
    }
    public static Object executeScript(String scriptText,WebElement element) {
        return ((JavascriptExecutor) Driver.getInstance().getCurrentDriver()).executeScript(scriptText,element);
    }
    public static void highlightElement(WebElement element){executeScript("arguments[0].setAttribute('style', 'background:yellow; border: 2px solid red;');",element);
        WaitUtil.sleep(1);
        executeScript("arguments[0].setAttribute('style', 'border: solid 2px white');",element);
    }
    public static void clickByJS(WebElement element){
        executeScript("arguments[0].click();",element);
    }
    public static void drawBorder(WebElement element){
        executeScript("arguments[0].style.border='3px solid red'",element);
    }
    public void refreshBrowserByJS(){
        executeScript("history.go(0)");
    }

    public static String getPageInnerTextByJS(){
        return executeScript("return document.documentElement.innerText").toString();
    }
}
