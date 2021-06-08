
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

//import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class day1 {

    WebDriver driver;
    @BeforeMethod
    public void setup() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setBrowserName("chrome");
        caps.setPlatform(Platform.LINUX);
        driver = new RemoteWebDriver(new
                URL("http://seleniumhub:4444/wd/hub"), caps);
        driver.get("http://172.81.181.47:8090/webapp");
    }
    @Test
    public void searchString() {
        // find search box and enter search string
        String pagecontent = driver.getPageSource();
        String search="TEAM";
        if (pagecontent.toLowerCase().indexOf(search.toLowerCase()) != -1) {
            System.out.println("OK");
        }else {
            System.out.println("Error Webpage content");
        }
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
