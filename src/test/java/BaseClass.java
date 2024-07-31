import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import java.time.Duration;


    public class BaseClass {

        protected WebDriver driver;
        protected WebDriverWait wait;

        Duration timeout = Duration.ofSeconds(50);

        @BeforeMethod
        public void setup() {

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

            wait = new WebDriverWait(driver, timeout);

            driver.get("http://localhost/Work%20management%20system/");
            System.out.println("Driver and wait initialized.");
        }

        @AfterMethod
        public void tearDown() {
            if (driver != null) {
                driver.quit();
            }
        }


    }


