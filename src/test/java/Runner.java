
import java.io.IOException;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.test.pages.LoginPage;
import com.test.pages.RegisterPage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import org.junit.Assert;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

public class Runner {
    String validEmail="kent@gmail.com";
    String password="automation123";
    String invalidEmailFormat="qatest";
    String incorrectEmail="QaForLife@gmail.com";
    
    ExtentSparkReporter spark;
    ExtentReports extent;
    ExtentTest test;
    AndroidDriver driver;
    RegisterPage reg = new RegisterPage();
    LoginPage log = new LoginPage();

    @BeforeClass
    public void setup() {
        spark = new ExtentSparkReporter("Report Mobile/Report-Mobile-Bukalapak.html");
        extent = new ExtentReports();
        extent.attachReporter(spark);
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "emulator-5554");
        caps.setCapability("platformName", "Android");
        caps.setCapability("appPackage", "com.loginmodule.learning");
        caps.setCapability("appActivity", "com.loginmodule.learning.activities.LoginActivity");
        caps.setCapability("noReset", "true");

        try {
            driver = new AndroidDriver<MobileElement>(
                    new URL("http://127.0.0.1:4723/wd/hub"), caps);

        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        }

    }
    
    public void testLoginWithValidData() {
        test = extent.createTest("Login With Valid Data");
        log.sendEmailToLogin(driver,validEmail);
        log.sendPasswordToLogin(driver,password);
        log.buttonLogin(driver);
        Assert.assertEquals(true, log.verifyAccountAfterLogin(driver));
    }

    @Test
    public void testLoginWithInvalidData() {
        test = extent.createTest("Login With Invalid Data");
        log.sendEmailToLogin(driver, incorrectEmail);
        log.sendPasswordToLogin(driver, password);
        log.buttonLogin(driver);
        Assert.assertEquals(true, log.getErrorMessageLogin(driver));
    }

   // @Test
    public void Register() {
        reg.clickRegister(driver);
        reg.inputEmail(driver,validEmail);
        reg.inputName(driver);
        reg.inputPassword(driver);
        reg.reinputPassword(driver);
        reg.clickButtonRegister(driver);
        Assert.assertEquals(true, reg.validateLoginAfterRegister(driver));
    }

    //@Test(priority=0)
    public void RegisterWithInvalidData() {
        reg.clickRegister(driver);
        reg.inputEmail(driver,invalidEmailFormat);
        reg.inputName(driver);
        reg.inputPassword(driver);
        reg.reinputPassword(driver);
        reg.clickButtonRegister(driver);
        Assert.assertEquals(true, reg.validateErrorInvalidEmail(driver));
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {
        extent.flush();
        driver.quit();
    }

}
