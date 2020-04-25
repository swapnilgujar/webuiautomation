package utils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Set;

import reporting.TestLog;

public class CommonUtil {
    static TestLog testLog=TestLog.get();
	protected CommonUtil() {}
	public static String getClassName(String userStoryName) {
		String[] names = userStoryName.split("\\.");
		return names[names.length - 1];
	}
	public static String getCurrentDateTime() {
		return  new SimpleDateFormat("mm-dd-yyyy").format(Calendar.getInstance().getTime());
	}
	public static File getNewestFile(String directory) {
		File[] files = new File(directory).listFiles();
		assert files != null;
		if (files.length == 0)
			return null;
		Arrays.sort(files, (o1, o2) -> Long.compare(o2.lastModified(), o1.lastModified()));
		return files[0];
	}
	
	public static String getNewestFilePath(String directory)
	{
		String filepath=Constants.DOWNLOAD_PATH+"\\"+getNewestFile(directory).getName();
		return filepath;
		
	}
	public static void printFunctionality() throws InterruptedException, AWTException
	{
		String innerWindow = null;
		String parentHandel=Driver.getInstance().getCurrentDriver().getWindowHandle();
		Set<String> allHandels=Driver.getInstance().getCurrentDriver().getWindowHandles();
		for(String currentHandel:allHandels)
		{
			if(currentHandel.equals(parentHandel))
			{
				continue;
			}
			System.out.println(currentHandel);
			innerWindow=currentHandel;
		}
		Driver.getInstance().getCurrentDriver().switchTo().window(innerWindow);
		WaitUtil.sleep(5);
		Thread.sleep(2000);
		Robot robot =new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(2000);

		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_TAB);
		
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_TAB);			
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(2000);
		robot.mouseMove(600,600);
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(6000);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(6000);
		
		Driver.getInstance().getCurrentDriver().switchTo().window(parentHandel);
		
		
	}
}
