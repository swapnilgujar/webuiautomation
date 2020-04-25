package elements;

import org.openqa.selenium.WebElement;
import reporting.TestLog;

public class PasswordFieldElemet extends CommonElement {
	public PasswordFieldElemet(WebElement element, String name) {
		super(element, name);
	}

	@Override
	public void setValue(String input) {
		String maskPasswd = getMaskPassword(input);
		TestLog.get().info(String.format("set ['%s'] into ['%s'] password box", maskPasswd, getName()));
		getWrappedElement().clear();
		getWrappedElement().sendKeys(input);
	}

	private String getMaskPassword(String input) {
		char[] cInput = input.toCharArray();
		StringBuilder maskPasswd = new StringBuilder();
		for (int i = 0; i < cInput.length; i++) {
			maskPasswd = maskPasswd.append("*");
		}
		return maskPasswd.toString();

	}
}
