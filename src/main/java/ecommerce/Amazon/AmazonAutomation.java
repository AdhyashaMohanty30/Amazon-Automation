package ecommerce.Amazon;

import java.time.Duration;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonAutomation {
    public static void main(String[] args) {
        // Setup ChromeDriver with bot-avoidance options
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", List.of("enable-automation"));
        options.setExperimentalOption("useAutomationExtension", false);
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64)");

        WebDriver driver = new ChromeDriver(options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        try {
            // 1. Open Amazon
            driver.get("https://www.amazon.in");
            driver.manage().window().maximize();

            // 2. Search before login
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox")));
            WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
            searchBox.sendKeys("boat headphones");
            driver.findElement(By.id("nav-search-submit-button")).click();

            // 3. Go to login page
            driver.get("https://www.amazon.in/ap/signin");

            // 4. Enter email and password
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ap_email"))).sendKeys("r68693520@gmail.com");
            driver.findElement(By.id("continue")).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ap_password"))).sendKeys("Snapchat@123");
            driver.findElement(By.id("signInSubmit")).click();

            // 5. Search again after login
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox")));
            WebElement searchBoxAfterLogin = driver.findElement(By.id("twotabsearchtextbox"));
            searchBoxAfterLogin.clear();
            searchBoxAfterLogin.sendKeys("boat headphones");
            driver.findElement(By.id("nav-search-submit-button")).click();

            // 6. Click first product
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".s-result-item h2 a")));
            List<WebElement> products = driver.findElements(By.cssSelector(".s-result-item h2 a"));
            if (!products.isEmpty()) {
                products.get(0).click();
            } else {
                System.out.println("No products found.");
                return;
            }

            // 7. Switch to new product tab
            Set<String> handles = driver.getWindowHandles();
            for (String handle : handles) {
                driver.switchTo().window(handle);
            }

            // 8. Add to cart
            wait.until(ExpectedConditions.elementToBeClickable(By.id("add-to-cart-button")));
            driver.findElement(By.id("add-to-cart-button")).click();

            // 9. Logout
            driver.get("https://www.amazon.in");
            WebElement accountMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nav-link-accountList")));
            org.openqa.selenium.interactions.Actions actions = new org.openqa.selenium.interactions.Actions(driver);
            actions.moveToElement(accountMenu).perform();

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Sign Out"))).click();

            System.out.println("✅ Logged in, searched, added to cart, and logged out successfully.");

            Thread.sleep(3000); // Pause for demo

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
