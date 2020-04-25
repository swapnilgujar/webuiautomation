package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.WrapsElement;
import org.openqa.selenium.remote.RemoteWebElement;

import exceptions.RunTimeException;
import reporting.TestLog;
import utils.Driver;
import utils.ScrollUtil;

public abstract class CommonElement extends RemoteWebElement implements WrapsElement, INamed, WebElement {
	private WebElement wrappedElement;
	private String name;

	protected CommonElement(WebElement element, String name) {
		this.wrappedElement = element;
		this.name = name;
		try {
			ScrollUtil.scrollIntoViewElement(getWrappedElement());
		} catch (Exception ignore) {
			TestLog.get().console("Scroller not working!!!, error as:" + ignore.getMessage());
		}
	}

	@Override
	public void submit() {
		TestLog.get().info(String.format("click on ['%s'] submit button", getName()));
		wrappedElement.submit();
	}

	@Override
	public void clear() {
		wrappedElement.clear();
	}

	@Override
	public boolean isSelected() {
		return wrappedElement.isSelected();
	}

	@Override
	public boolean isEnabled() {
		return wrappedElement.isEnabled();
	}

	@Override
	public boolean isDisplayed() {
		return wrappedElement.isDisplayed();
	}

	@Override
	public String getText() {
		TestLog.get().info(
				String.format("Element [%s] has the textValue= ['%s']", wrappedElement, wrappedElement.getText()));
		return wrappedElement.getText();
	}

	@Override
	public String getAttribute(String attributeKey) {
		return wrappedElement.getAttribute(attributeKey);
	}

	@Override
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setValue(String input) {
		wrappedElement.sendKeys(input);
	}

	public void setWrappedElement(WebElement element) {
		wrappedElement = element;
	}

	@Override
	public final WebElement getWrappedElement() {
		return wrappedElement;
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}
	public String getHelpText() {
        String helpText="";
        String att=getWrappedElement().findElement(By.xpath("../preceding-sibling::mat-icon")).getAttribute("aria-describedby");
        helpText= Driver.getInstance().getCurrentDriver().findElement(By.cssSelector("div#"+att)).getAttribute("innerText");
        return helpText;
   }
}
