package pages;

import org.openqa.selenium.WebDriver;
import utils.Driver;

public abstract class BasePage {
    protected WebDriver driver;


    protected BasePage(){
        driver= Driver.getInstance().getCurrentDriver();
    }
    
    protected BasePage(WebDriver driver){
        this.driver= driver;
    }
    
}
