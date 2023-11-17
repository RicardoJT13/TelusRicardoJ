package Telus;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    public  WebDriver driver;


    @BeforeTest
    public  void beforeTestRun() {

        Base.openBrowser();
        driver.manage().window().maximize();
    }

}
