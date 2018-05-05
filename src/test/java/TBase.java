

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import util.PropertyLoader;
import webdriver.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class TBase {
    protected WebDriver driver;
    protected String browser;
    protected String baseUrl;
    protected String remoteUrl;

    @BeforeClass
    public void init(){
        browser = PropertyLoader.loadProperty("browser.name");
        baseUrl = PropertyLoader.loadProperty("base.url");
        remoteUrl = PropertyLoader.loadProperty("remote.url");

        driver = WebDriverFactory.getInstance(remoteUrl,browser);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @AfterClass
    public void tearDown(){
        if(driver != null){
            driver.quit();
        }
    }


}
