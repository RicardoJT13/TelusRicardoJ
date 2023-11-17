package Telus;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.List;


public class Base {



    private static Base instanceOfSingletonClass = null;
    private static FirefoxDriver driver;


    public static void openBrowser() {
        //Use Of Singleton Concept and Initilize webDriver
        if (driver == null) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--incognito");
            DesiredCapabilities capabilities = new DesiredCapabilities();
            //capabilities.(ChromeOptions.CAPABILITY, options);
            capabilities.setCapability(ChromeOptions.CAPABILITY, options);
            options.merge(capabilities);

            driver = new FirefoxDriver(options);
            driver.manage().window().maximize();
            driver.get("https://telustvplus.com/#/");
            System.out.println("Browser Opened");
        }
    }


    // to get Instance
    public static Base getInstanceOfWebDriverManager() {
        if (instanceOfSingletonClass == null) {
            instanceOfSingletonClass = new Base();
        }
        return instanceOfSingletonClass;
    }

    public boolean isDisplayed(By locator) {
        try {
            return getInstanceOfWebDriverManager().getDriver().findElement(locator).isDisplayed();
        }
        catch (NoSuchElementException e) {
            return false;
        }
    }


    //to get Driver
    public WebDriver getDriver()
    {
        if (driver == null)
        {
            driver = new FirefoxDriver();
        }
        return driver;
    }

    public void CloseDriver() {
        if (!(driver == null)) {
            driver.quit();
            driver = null;

        }

    }

    public WebElement findElement(By locator)
    {
        //return driver.findElement(locator);
        return getInstanceOfWebDriverManager().getDriver().findElement(locator);
    }


    private WebElement getSearchBox(){
        return getInstanceOfWebDriverManager().getDriver().findElement(By.id("searchbox"));
    }




    public List<WebElement> findElements(By locator)
    {
        return driver.findElements(locator);
    }

    public static String getText(By locator)
    {
        return getInstanceOfWebDriverManager().getDriver().findElement(locator).getText();
    }

    public String getAttribute (By locator, String attribute)
    {
        return getInstanceOfWebDriverManager().getDriver().findElement(locator).getAttribute(attribute);
    }

    public void type( String inputText, By locator)
    {
         driver.findElement(locator).sendKeys(inputText);
    }

    public void click(By locator)
    {
        //driver.findElement(locator).click();

        getInstanceOfWebDriverManager().getDriver().findElement(locator).click();
    }



    public void scroll()
    {
        JavascriptExecutor js = (JavascriptExecutor) getInstanceOfWebDriverManager().getDriver();
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }


   public void scrollIntoView(WebElement element)
   {

       JavascriptExecutor js = (JavascriptExecutor) getInstanceOfWebDriverManager().getDriver();
       js.executeScript("arguments[0].scrollIntoView()", element);


   }



    public void visit(String url){
        driver.get(url);
    }




}


