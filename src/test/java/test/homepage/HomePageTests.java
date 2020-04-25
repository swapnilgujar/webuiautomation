package test.homepage;

import org.testng.annotations.Test;

import pages.login.HomePage;
import tests.BaseTest;
import utils.SoftAssert;

public class HomePageTests extends BaseTest {
	
	@Test
	public void launchandVerifyHomePageHeader() {
		
		String actualPageHeader = HomePage.getInstance().getPageHeader();
		SoftAssert.assertEquals(actualPageHeader, "Tutorials Library");
	}
	
	@Test
	public void launchandVerifyHomePageHeader1() {
		
		String actualPageHeader = HomePage.getInstance().getPageHeader();
		SoftAssert.assertEquals(actualPageHeader, "Tutorials Library");
	}
	
	@Test
	public void launchandVerifyHomePageHeader2() {
		
		String actualPageHeader = HomePage.getInstance().getPageHeader();
		SoftAssert.assertEquals(actualPageHeader, "Tutorial Library");
	}

	
	
}
