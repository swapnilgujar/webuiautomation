package test.homepage;

import org.testng.annotations.Test;

import pages.login.HomePage;
import tests.BaseTest;

public class HomePageTests extends BaseTest {
	
	@Test
	public void launchandVerifyHomePageHeader() {
		
		String actualPageHeader = HomePage.getInstance().getPageHeader();
		utils.SoftAssert.assertEquals(actualPageHeader, "Tutorials Library");
	}

}
