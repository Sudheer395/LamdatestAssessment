package lamdatestAssignment;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
public class TestCase1{
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
        capabilities.setCapability("platform", "win10"); // If this cap isn't specified, it will just get the any available one
        capabilities.setCapability("build", "LambdaTestSampleApp");
        capabilities.setCapability("name", "Testcase1");
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
		Thread.sleep(2000);
		driver.findElement(By.linkText("Simple Form Demo")).click();
		Thread.sleep(2000);
		System.out.println(driver.getCurrentUrl().contains("simple-form-demo"));
		driver.findElement(By.xpath("//input[@id='user-message']")).sendKeys("Welcome to LamdaTest");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='showInput']")).click();
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.xpath("//p[@id='message']")).getText(), "Welcome to LamdaTest");
		//driver.quit();
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
