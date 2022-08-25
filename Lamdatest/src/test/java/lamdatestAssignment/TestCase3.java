package lamdatestAssignment;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestCase3 {
	public String username = "sudheerbabu8521";
	public String accesskey = "NFwk81QGOgZSqsCnIJkebGDRs4IR4VZf43GExXxiglJNJW6gsV";
	public static RemoteWebDriver driver = null;
	public String gridURL = "@hub.lambdatest.com/wd/hub";
	boolean status = false;

	@BeforeClass
	public void setUp() throws Exception {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("browserName", "chrome");
		capabilities.setCapability("version", "70.0");
		capabilities.setCapability("platform", "win10"); // If this cap isn't specified, it will just get the any
															// available one
		capabilities.setCapability("build", "LambdaTestSampleApp");
		capabilities.setCapability("name", "Testcase3");
		try {
			driver = new RemoteWebDriver(new URL("https://" + username + ":" + accesskey + gridURL), capabilities);
		} catch (MalformedURLException e) {
			System.out.println("Invalid grid URL");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void testSimple() throws Exception {
		try {
			driver.get("https://www.lambdatest.com/selenium-playground");
			driver.manage().window().maximize();
			driver.findElement(By.linkText("Input Form Submit")).click();
			driver.findElement(By.xpath("//div[@class='text-right mt-20']/button")).click();
			driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Sudheer");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@id='inputEmail4']")).sendKeys("Sudheermuppana@gmail.com");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@id='inputPassword4']")).sendKeys("Sudheer@123");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@id='company']")).sendKeys("Mindtree");
			driver.findElement(By.xpath("//input[@id='websitename']")).sendKeys("www.Lamdatest.com");
			
			driver.findElement(By.xpath("//input[@id='inputCity']")).sendKeys("Hyderabad");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@id='inputAddress1']")).sendKeys("Pragatji Nagar");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@id='inputAddress2']")).sendKeys("JNTU");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@id='inputState']")).sendKeys("Telangana");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@id='inputZip']")).sendKeys("500090");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[@class='text-right mt-20']/button")).click();
			Assert.assertEquals(driver.findElement(By.xpath("//p[@class='success-msg hidden']")).getText(),
					"Thanks for contacting us, we will get back to you shortly.");
			Thread.sleep(2000);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@AfterClass
	public void tearDown() throws Exception {
		if (driver != null) {
			((JavascriptExecutor) driver).executeScript("lambda-status=" + status);
			driver.quit();
		}
	}
}
