package elements;

import org.openqa.selenium.WebElement;
import reporting.TestLog;

public class FileUploadElement extends CommonElement{

    public FileUploadElement(WebElement element, String name) {
        super(element, name);
    }
    public void uploadFile(String filePath){
        TestLog.get().info(String.format("uploading file ['%s']",filePath));
        getWrappedElement().sendKeys(filePath);
    }
}
