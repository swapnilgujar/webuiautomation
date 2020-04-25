/*package utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.imageio.ImageIO;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import reporting.TestLog;

public class Mailer {
	static Logger logger = Logger.getLogger(Mailer.class);
	static WebDriver driver = null;
	static File dashViewScreenshot = null;

	Mailer() {
	}

	private static void takeReportScreenshot() throws IOException {
		File f = new File("test-results/extent-report.html");
		if (f.exists()) {
			System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.navigate().to(f.toURI().toURL());
			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			BufferedImage fullImg = ImageIO.read(screenshot);
			ImageIO.write(fullImg, "png", screenshot);
			dashViewScreenshot = new File("test-results/screenshots/report-dashview.png");
			FileUtils.copyFile(screenshot, dashViewScreenshot);
			logger.info("Mailer Screenshot Captured");
			driver.quit();
		}
	}

	public static String zipFile() throws IOException {
		Mailer.takeReportScreenshot();

		String zipFileName = null;
		File file = new File("test-results/extent-report.html");
		if (file.exists()) {
			zipFileName = file.getAbsoluteFile().toString().replace(".html", "").concat(".zip");
			FileOutputStream fos = new FileOutputStream(zipFileName);
			ZipOutputStream zos = new ZipOutputStream(fos);
			try {
				zos.putNextEntry(new ZipEntry(file.getName()));
				byte[] bytes = Files.readAllBytes(Paths.get(file.getPath()));
				zos.write(bytes, 0, bytes.length);
				zos.closeEntry();
			} finally {
				zos.close();
				fos.close();
			}
		} else {
			zipFileName = "null";
		}
		return zipFileName;
	}

	public static void sendEmail(String zipFileName, String userStoryName) throws IOException {
		if (!zipFileName.equals("null")) {
			String host = "smtp.mail.fedex.com";
			String sender = Constants.MAIL_SENDER;
			String recipient = Constants.MAIL_RECIEVER;
			Properties properties = System.getProperties();
			properties.setProperty("mail.smtp.host", host);
			Session session = Session.getDefaultInstance(properties);
			try {
				String cid = CommonUtil.getCurrentDateTime();
				Message message = new MimeMessage(session);
				Multipart multiPart = new MimeMultipart();

				message.setFrom(new InternetAddress(sender));
				message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));

				message.setSubject(userStoryName);

				MimeBodyPart extentReport = new MimeBodyPart();
				String zippedFilename = zipFileName;
				DataSource zippedFileSource = new FileDataSource(zippedFilename);
				extentReport.setDataHandler(new DataHandler(zippedFileSource));
				extentReport.setFileName(zipFileName);

				MimeBodyPart reportDashView = new MimeBodyPart();
				DataSource reportDashViewSource = new FileDataSource(dashViewScreenshot);
				reportDashView.setDataHandler(new DataHandler(reportDashViewSource));
				reportDashView.setFileName("report-dashview.png");

				MimeBodyPart policyGridLogger = new MimeBodyPart();
				DataSource policyGridLoggerSource = new FileDataSource("test-results/application.log");
				policyGridLogger.setDataHandler(new DataHandler(policyGridLoggerSource));
				policyGridLogger.setFileName("logger.log");

				MimeBodyPart imageInBody = new MimeBodyPart();
				imageInBody.attachFile(dashViewScreenshot);
				imageInBody.setContentID("<" + cid + ">");
				imageInBody.setDisposition(MimeBodyPart.INLINE);
				multiPart.addBodyPart(imageInBody);

				MimeBodyPart textPart = new MimeBodyPart();
				textPart.setText("<html>" + " <body>" + "  <p style='font-family:Calibri;'>Hi Team,</p>"
						+ "<p style='font-family:Calibri;'> Please find the following GPR3 Web Service execution summary</p>"
						+ "  <img src=\"cid:" + cid + "\"style='border:50 solid black'/>"

						+ "<p style='font-family:Calibri;'>For detailed execution analysis of the Web Service , please find the attached"
						+ "<b> logger.log </b>file.</p>"

						+ "<p style='font-family:Calibri;'>Thanks and Regards,<br>GTM PLEFS</p>" + "<p><br></p>"

						+ "<p style='font-family:Calibri;'><font size='1'><center><<------------------------------------------------This is an automated email triggered from GPR Automation Team-------------------------------------------->></center></font></p>"

						+ "</body>" + "</html>", "US-ASCII", "html");

				multiPart.addBodyPart(extentReport);
				multiPart.addBodyPart(policyGridLogger);
				multiPart.addBodyPart(textPart);

				message.setContent(multiPart);
				logger.info("Sending Mail for:" + userStoryName);
				Transport.send(message);

				logger.info("Mail Sent Successfully");
			} catch (MessagingException mex) {
				logger.error(Arrays.deepToString(mex.getStackTrace()));
			}
		} else {
			TestLog.get().info("No Report found for: " + userStoryName);
		}
	}

}*/