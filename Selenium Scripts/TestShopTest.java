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
public class TestShopTest {
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
  public void testShop() {
    driver.get("https://www.staples.ca/");
    driver.manage().window().setSize(new Dimension(1550, 838));
    {
      WebElement element = driver.findElement(By.cssSelector(".cart-counter__icon--desktop"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    driver.findElement(By.id("accessible-megamenu-nav-item-Shop")).click();
    js.executeScript("window.scrollTo(0,212)");
    js.executeScript("window.scrollTo(0,26.399999618530273)");
    assertThat(driver.findElement(By.cssSelector(".accessible-megamenu-panel-group--shop-content__column:nth-child(2) .megamenu-category-item-row:nth-child(1) li:nth-child(1) .megamenu-category-item__label div")).getText(), is("Brother Ink + Toner"));
    {
      List<WebElement> elements = driver.findElements(By.cssSelector(".accessible-megamenu-panel-group--shop-content__column:nth-child(2) .megamenu-category-item-row:nth-child(1) li:nth-child(1) .megamenu-category-item__label div"));
      assert(elements.size() > 0);
    }
    driver.findElement(By.cssSelector(".megamenu-category-item-row:nth-child(2) li:nth-child(1) .megamenu-category-item__label div")).click();
    js.executeScript("window.scrollTo(0,384.79998779296875)");
    js.executeScript("window.scrollTo(0,703.9000244140625)");
    js.executeScript("window.scrollTo(0,738.5)");
    js.executeScript("window.scrollTo(0,738.5)");
    {
      WebElement element = driver.findElement(By.cssSelector(".ais-facet:nth-child(6) .ais-refinement-list--list"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).clickAndHold().perform();
    }
    {
      WebElement element = driver.findElement(By.cssSelector(".ais-facet:nth-child(6) .ais-refinement-list--list"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    {
      WebElement element = driver.findElement(By.cssSelector(".ais-facet:nth-child(6) .ais-refinement-list--list"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).release().perform();
    }
    {
      List<WebElement> elements = driver.findElements(By.cssSelector(".add"));
      assert(elements.size() > 0);
    }
    assertThat(driver.findElement(By.cssSelector(".add")).getText(), is("ADD TO CART"));
    {
      List<WebElement> elements = driver.findElements(By.cssSelector(".add"));
      assert(elements.size() > 0);
    }
    driver.findElement(By.cssSelector(".add")).click();
    driver.findElement(By.cssSelector(".modal-cart__content")).click();
    {
      List<WebElement> elements = driver.findElements(By.cssSelector(".modal-cart-item__price"));
      assert(elements.size() > 0);
    }
    driver.findElement(By.cssSelector(".modal-cart-item__title")).click();
    assertThat(driver.findElement(By.cssSelector(".modal-cart-item__title")).getText(), is("HP 774 Chromatic Red Ink Cartridge - 3 Pack"));
    driver.findElement(By.linkText("Continue Shopping")).click();
    driver.findElement(By.cssSelector(".bv-recommended-product:nth-child(2) .bv-product-image")).click();
    driver.findElement(By.cssSelector(".bv-selected-product .bv-product-image")).click();
    driver.findElement(By.id("accessible-megamenu-nav-item-Shop")).click();
    {
      WebElement element = driver.findElement(By.linkText("Brother Ink + Toner"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    {
      WebElement element = driver.findElement(By.tagName("body"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element, 0, 0).perform();
    }
    {
      WebElement element = driver.findElement(By.linkText("Brother Ink + Toner"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    {
      WebElement element = driver.findElement(By.tagName("body"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element, 0, 0).perform();
    }
    driver.findElement(By.cssSelector(".shop-tab__link:nth-child(6) div")).click();
    driver.findElement(By.cssSelector(".accessible-megamenu-panel-group--shop-content__column:nth-child(2) li:nth-child(4) .megamenu-category-item__image")).click();
    driver.findElement(By.cssSelector(".ais-hits--item:nth-child(1) .button")).click();
    driver.findElement(By.cssSelector(".icon--close:nth-child(2)")).click();
    driver.findElement(By.cssSelector(".ais-hits--item:nth-child(3) .button")).click();
    driver.findElement(By.cssSelector(".modal-cart-ctas__view-cart")).click();
    driver.findElement(By.linkText("MSI Katana GF66 11UC-235CA 15.6\" FHD Gaming Laptop, Core i7-11800H, 512GB SSD, 8GB DDR4, NVIDIA GeForce RTX3050, Windows 10")).click();
    driver.findElement(By.cssSelector(".d-none .product-title")).click();
    assertThat(driver.findElement(By.cssSelector(".d-none #\\36 542135263361")).getText(), is("MSI Katana GF66 11UC-235CA 15.6\\\" FHD Gaming Laptop, Core i7-11800H, 512GB SSD, 8GB DDR4, NVIDIA GeForce RTX3050, Windows 10"));
    driver.findElement(By.cssSelector(".product-warranties__warranty:nth-child(1) .checkbox__label")).click();
    driver.findElement(By.cssSelector(".product-warranties__warranty:nth-child(2) .checkbox__label")).click();
    driver.findElement(By.cssSelector(".product-warranties__warranty:nth-child(3) .checkbox__label")).click();
    driver.findElement(By.cssSelector(".product-warranties__warranty:nth-child(4) .checkbox__label")).click();
    driver.findElement(By.cssSelector(".product-warranties__warranty:nth-child(1) .checkbox__label")).click();
    driver.findElement(By.cssSelector(".product-warranties__warranty:nth-child(4) .checkbox__label")).click();
    {
      WebElement element = driver.findElement(By.linkText("Important Warranty Information"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    {
      WebElement element = driver.findElement(By.cssSelector(".slick-next"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
  }
}
