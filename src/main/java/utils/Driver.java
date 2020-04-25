package utils;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Driver {
	protected String url = Constants.URL;
	private ThreadLocal<WebDriver> driverTL;
	private static Driver instance = null;

	 Driver() {
		driverTL = new ThreadLocal<>();
	}

	public static Driver getInstance() {
		if (instance == null) {
			instance = new Driver();
		}
		return instance;
	}

	public WebDriver initialize() {
		/** WebDriverManager.chromedriver().setup(); */
//		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");
		if (Constants.BROWSER_DISABLE_IMGAES) {
			ChromeOptions options = new ChromeOptions();
			disableImages(options);
			driverTL.set(new ChromeDriver(options));
		} else {
			driverTL.set(new ChromeDriver());
		}
		if (Constants.BROWSER_MINIMIZE) {
			driverTL.get().manage().window().setPosition(new Point(6000, 500));
			driverTL.get().manage().window().setSize(new Dimension(1920, 1080));
		} else {
			driverTL.get().manage().window().maximize();
		}
		driverTL.get().manage().deleteAllCookies();
		driverTL.get().manage().timeouts().implicitlyWait(Constants.DEFAULT_TIMEOUT, TimeUnit.SECONDS);
		driverTL.get().get(url);
		return driverTL.get();

	}

	public void quit() {
		setInstance();
		if (driverTL.get() != null) {
			driverTL.get().quit();
			driverTL = null;
		}
	}

	private static void setInstance() {
		instance = null;

	}

	public WebDriver getCurrentDriver() {
		return driverTL.get();
	}

	private void disableImages(ChromeOptions option) {
		HashMap<String, Object> images = new HashMap<>();
		images.put("images", 2);
		HashMap<String, Object> prefs = new HashMap<>();
		prefs.put("profile.default_content_setting_values", images);
		option.setExperimentalOption("prefs", prefs);
	}

	public void refreshPage() {
		driverTL.get().navigate().refresh();
	}

	public void backPage() {
		driverTL.get().navigate().back();
	}

	public void forwardPage() {
		driverTL.get().navigate().forward();
	}

	public String getPageSource() {
		return driverTL.get().getPageSource();
	}

	public String getPageTitle() {
		return driverTL.get().getTitle();
	}

	public String getPageInnerText() {
		return JSUtil.getPageInnerTextByJS();
	}

}
