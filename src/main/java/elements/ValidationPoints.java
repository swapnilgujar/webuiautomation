/*package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pages.create.serviceoption.CreateServiceOptionPage7;
import reporting.TestLog;
import utils.ScrollUtil;

public class ValidationPoints 
{
	public void LanguageMaxLengthValidation(int count,String value)
	{
		if(count==8)
		{
			TestLog.get().info(String.format("count ['%s'] validates for ['%s'] Text_Area",count,value));
			utils.SoftAssert.assertTrue(true);
		}
		else
		{
			TestLog.get().info(String.format("count ['%s'] doesn't validates for ['%s'] Text_Area",count,value));
			utils.SoftAssert.assertTrue(false);
		}
	}

	public void CountryMaxLengthValidation(int count, String value) 
	{
		if(count==2)
		{
			TestLog.get().info(String.format("count ['%s'] validates for ['%s'] Text_Area",count,value));
			utils.SoftAssert.assertTrue(true);
		}
		else
		{
			TestLog.get().info(String.format("count ['%s'] doesn't validates for ['%s'] Text_Area",count,value));
			utils.SoftAssert.assertTrue(false);
		}
	}

	public void DialectMaxLengthValidation(int count, String value) 
	{
		if(count==8)
		{
			TestLog.get().info(String.format("count ['%s'] validates for ['%s'] Text_Area",count,value));
			utils.SoftAssert.assertTrue(true);
		}
		else
		{
			TestLog.get().info(String.format("count ['%s'] doesn't validates for ['%s'] Text_Area",count,value));
			utils.SoftAssert.assertTrue(false);
		}
	}
	
	public static void LangMaxLOnReviewPage(String toVerify)
	{
		String value=CreateServiceOptionPage7.getInstance().getAttributeValueOnReviewScreen("Locale Code");
		String arr[]=value.split("-");
		int languageSize=arr[0].length();
		int dialectSize=arr[1].length();
		int countrySize=arr[2].length();
		
		switch (toVerify) 
		{
		case "Language": 
		if(languageSize==8)
		{
			TestLog.get().info(String.format("count ['%s'] validates for ['%s'] Text_Area",languageSize,"Language"));
			utils.SoftAssert.assertTrue(true);
		}
		else
		{
			TestLog.get().info(String.format("count ['%s'] doesn't validates for ['%s'] Text_Area",languageSize,"Language"));
			utils.SoftAssert.assertTrue(false);
		}
		break;
		
		case "Country":
		if(countrySize==2)
		{
			TestLog.get().info(String.format("count ['%s'] validates for ['%s'] Text_Area",countrySize,"Country"));
			utils.SoftAssert.assertTrue(true);
		}
		else
		{
			TestLog.get().info(String.format("count ['%s'] doesn't validates for ['%s'] Text_Area",countrySize,"Country"));
			utils.SoftAssert.assertTrue(false);
		}
		break;
		
		case "Dialect":
		if(dialectSize==8)
		{
			TestLog.get().info(String.format("count ['%s'] validates for ['%s'] Text_Area",dialectSize,"Dialect"));
			utils.SoftAssert.assertTrue(true);
		}
		else
		{
			TestLog.get().info(String.format("count ['%s'] doesn't validates for ['%s'] Text_Area",dialectSize,"Dialect"));
			utils.SoftAssert.assertTrue(false);
		}
		break;
			
		}
	}
	public int OpCoCountSecondPage(int value2,String name)//Created by Loveen
	{
		
		int count =value2+1;
		TestLog.get().info(String.format("get count from ['%s'] Watermark into second page is ['%s']",name,count));
		return count;
	}
	
	public int OpCoCountReviewPage(String attributeKey)//Created bt Loveen
	{
		WebDriver driver = utils.Driver.getInstance().getCurrentDriver();
		String attributeValueXpaths = "//td[text()='OpCo*']";
		WebElement element = driver.findElement(By.xpath(String.format(attributeValueXpaths, attributeKey)));
		ScrollUtil.scrollIntoViewElement(element);
 		int selectedCountries=driver.findElements(By.xpath("//td[text()='OpCo*']/..//div[@class='mat-list-item-content']")).size();
		return selectedCountries;
	}
	
	public static void CodeMaxLOnReviewPage(String toVerify,String attribute)//Created by Loveen
	{
		String value=CreateServiceOptionPage7.getInstance().getAttributeValueOnReviewScreen(attribute);
		String arr[]=value.split("-");
		int languageSize=arr[0].length();
		int dialectSize=arr[1].length();
		int countrySize=arr[2].length();
		
		switch (toVerify) 
		{
		case "Language": 
		if(languageSize<=8)
		{
			TestLog.get().info(String.format("count ['%s'] validates for ['%s'] Text_Area",languageSize,"Language"));
			utils.SoftAssert.assertTrue(true);
		}
		else
		{
			TestLog.get().info(String.format("count ['%s'] doesn't validates for ['%s'] Text_Area",languageSize,"Language"));
			utils.SoftAssert.assertTrue(false);
		}
		break;
		
		case "Country":
		if(countrySize==2)
		{
			TestLog.get().info(String.format("count ['%s'] validates for ['%s'] Text_Area",countrySize,"Country"));
			utils.SoftAssert.assertTrue(true);
		}
		else
		{
			TestLog.get().info(String.format("count ['%s'] doesn't validates for ['%s'] Text_Area",countrySize,"Country"));
			utils.SoftAssert.assertTrue(false);
		}
		break;
		
		case "Dialect":
		if(dialectSize<=8)
		{
			TestLog.get().info(String.format("count ['%s'] validates for ['%s'] Text_Area",dialectSize,"Dialect"));
			utils.SoftAssert.assertTrue(true);
		}
		else
		{
			TestLog.get().info(String.format("count ['%s'] doesn't validates for ['%s'] Text_Area",dialectSize,"Dialect"));
			utils.SoftAssert.assertTrue(false);
		}
		break;
			
		}
	}
}
*/