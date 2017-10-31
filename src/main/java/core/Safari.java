package core;
 
import org.openqa.selenium.*;
import org.openqa.selenium.safari.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;
import java.util.logging.*;
 
public class Safari {
      
       static WebDriver driver;
      
       public static void main(String[] args) throws InterruptedException {
             
              Logger logger = Logger.getLogger("");
              logger.setLevel(Level.OFF);
             
              String url = "http://facebook.com/";
              String email_address = "***************";
              String password = "**************";
 
              if (!System.getProperty("os.name").contains("Mac")) {throw new IllegalArgumentException("Safari is available only on Mac");}
                    
              driver = new SafariDriver();
              //driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
              driver.manage().window();//.maximize();
              
              WebDriverWait wait = new WebDriverWait(driver, 15);
 
              System.out.println("Browser is: Safari");
              driver.get(url);
             // Thread.sleep(1000); // Pause in milleseconds (1000 – 1 sec)
             
              wait.until(ExpectedConditions.titleIs("Facebook - Log In or Sign Up"));
              
              String title = driver.getTitle();
              
              String copyright = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\'pageFooter\']/div[3]/div/span"))).getText();

              wait.until(ExpectedConditions.presenceOfElementLocated(By.id("email"))).clear();

              wait.until(ExpectedConditions.presenceOfElementLocated(By.id("email"))).sendKeys(email_address);

              wait.until(ExpectedConditions.presenceOfElementLocated(By.id("pass"))).clear();

              wait.until(ExpectedConditions.presenceOfElementLocated(By.id("pass"))).sendKeys(password);

              wait.until(ExpectedConditions.elementToBeClickable(By.id("u_0_2"))).click();

              wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='u_0_a']/div[1]/div[1]/div/a/span"))).click();

              String friends = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[2]/ul/li[3]/a/span[1]"))).getText();      
        System.out.println("You have " + friends + " friends");
       
//////////////////////////////////////////////////////////////////////////////////////////////////////
      
      //  WebElement settings = driver.findElement(By.id("userNavigationLabel"));
       //((JavascriptExecutor) driver).executeScript("arguments[0].click();", settings);
 
        //WebElement logout = driver.findElement(By.xpath("//div/div/ul/li[22]/a/span/span"));
        //((JavascriptExecutor) driver).executeScript("arguments[0].click();", logout);
 
              driver.quit();
     
       }
}