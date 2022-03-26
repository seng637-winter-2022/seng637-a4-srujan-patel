// Generated by Selenium IDE
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
public class TestLoginfailureTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
    driver = new FirefoxDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void testLoginfailure() {
    driver.get("https://www.staples.ca/");
    driver.manage().window().setSize(new Dimension(1248, 777));
    driver.findElement(By.cssSelector(".header__link-account > .header__icon--desktop")).click();
    driver.findElement(By.id("customer_email")).click();
    driver.findElement(By.id("customer_email")).sendKeys("mapatel");
    driver.findElement(By.id("customer_email")).sendKeys(Keys.ENTER);
    driver.findElement(By.id("customer_email")).sendKeys("mapatel5169@gmail.com");
    driver.findElement(By.id("customer_password")).click();
    driver.findElement(By.id("customer_password")).sendKeys("segsgsgfgf");
    driver.findElement(By.cssSelector(".button--button")).click();
    driver.findElement(By.id("customer_login")).click();
    assertThat(driver.findElement(By.cssSelector(".error--single")).getText(), is("Re-enter your login details or select Forgot your password to reset. If you do not have an account, create one now."));
  }
}
