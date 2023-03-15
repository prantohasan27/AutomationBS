package base;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import java.net.URL;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class baseTest {


    public static WebDriver driver;
    public static Properties prop = new Properties();
    public static FileReader fr;
    public static final String USERNAME = "browserstackadmi18";
    public static final String AUTOMATE_KEY = "7KqxjTiW2QhdPwtPpcrB";
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    @BeforeTest
    public void setup() throws IOException {

        if(driver == null)
        {
            FileReader fr = new FileReader("E:\\upwork_projects\\BrowserStackProject\\BrowserStackAutomation\\src\\test\\resources\\configfiles\\config.properties");
            prop.load(fr);
        }
        if(prop.getProperty("browser").equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");

//            MutableCapabilities capabilities = new MutableCapabilities();
//            HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
//            browserstackOptions.put("osVersion", "16");
//            browserstackOptions.put("deviceName", "iPhone 14 Pro Max");
//            browserstackOptions.put("local", "false");
//            capabilities.setCapability("bstack:options", browserstackOptions);



            driver = new ChromeDriver(options);
           // driver = new RemoteWebDriver(new URL(URL),capabilities);

            driver.get(prop.getProperty("testurl"));

        }
        else if(prop.getProperty("browser").equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            EdgeOptions options = new EdgeOptions();
            options.addArguments("--remote-allow-origins=*");

            MutableCapabilities capabilities = new MutableCapabilities();
            HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
            browserstackOptions.put("osVersion", "14");
            browserstackOptions.put("deviceName", "iPad Air 4");
            browserstackOptions.put("local", "false");
            capabilities.setCapability("bstack:options", browserstackOptions);





            driver = new EdgeDriver(options);
            driver = new RemoteWebDriver(new URL(URL),capabilities);
            driver.get(prop.getProperty("testurl"));
        }

    }

//	@AfterTest
//	public void terdown() {
//		driver.close();
//		System.out.println("Browser close successfully");
//	}
}
