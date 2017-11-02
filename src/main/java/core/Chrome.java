package core;
 
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import java.util.concurrent.TimeUnit;
import java.util.logging.*;



import org.openqa.selenium.support.ui.*;







 
public class Chrome {
      
       static WebDriver driver;
 
       public static void main(String[] args) throws InterruptedException {
             
              Logger logger = Logger.getLogger("");
              logger.setLevel(Level.OFF);
             
              String driverPath = "";
 
 

              String url = "http://facebook.com/";
              String email_address = "***********";

              String password = "***********";


              if (System.getProperty("os.name").toUpperCase().contains("MAC"))      driverPath = "./resources/webdrivers/mac/chromedriver";
         else if (System.getProperty("os.name").toUpperCase().contains("WINDOWS"))  driverPath = "./resources/webdrivers/pc/chromedriver.exe";
         else throw new IllegalArgumentException("Unknown OS");
               
                System.setProperty("webdriver.chrome.driver", driverPath);
                System.setProperty("webdriver.chrome.silentOutput", "true");
                ChromeOptions option = new ChromeOptions();
                option.addArguments("disable-infobars");
                option.addArguments("--disable-notifications");
                if (System.getProperty("os.name").toUpperCase().contains("MAC"))
                      option.addArguments("-start-fullscreen");
                else if (System.getProperty("os.name").toUpperCase().contains("WINDOWS"))
                      option.addArguments("--start-maximized");
                else throw new IllegalArgumentException("Unknown OS");

               

                     driver = new ChromeDriver();

                   //  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

                     driver.manage().window();//maximize();

                     WebDriverWait wait = new WebDriverWait(driver, 15);

             

                     driver.get(url);

                     wait.until(ExpectedConditions.titleIs("Facebook - Log In or Sign Up"));

 String title = driver.getTitle();
                     
                     String copyright = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\'pageFooter\']/div[3]/div/span"))).getText();

                     System.out.println("Size of copyright: " + (Dimension) driver.findElement(By.xpath("//*[@id=\'pageFooter\']/div[3]/div/span")).getSize());

                     System.out.println("Location of copyright: " + (Point) driver.findElement(By.xpath("//*[@id=\'pageFooter\']/div[3]/div/span")).getLocation());
                     wait.until(ExpectedConditions.presenceOfElementLocated(By.id("email"))).clear();

                     wait.until(ExpectedConditions.presenceOfElementLocated(By.id("email"))).sendKeys(email_address);
                     
                     System.out.println("Size of Email: " + (Dimension) driver.findElement(By.id("email")).getSize());

                     System.out.println("Location of Email: " + (Point) driver.findElement(By.id("email")).getLocation());
                     
                     wait.until(ExpectedConditions.presenceOfElementLocated(By.id("pass"))).clear();

                     wait.until(ExpectedConditions.presenceOfElementLocated(By.id("pass"))).sendKeys(password);
                     
                     System.out.println("Size of Size of Password: " + (Dimension) driver.findElement(By.id("pass")).getSize());

                     System.out.println("Location of Size of Password: " + (Point) driver.findElement(By.id("pass")).getLocation());

                     wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"u_0_2\"]"))).click();
                     
                     System.out.println("Size of Size of Login: " + (Dimension) driver.findElement(By.xpath("//*[@id=\"u_0_2\"]")).getSize());

                     System.out.println("Location of Size of Login: " + (Point) driver.findElement(By.xpath("//*[@id=\"u_0_2\"]")).getLocation());

                     wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='u_0_a']/div[1]/div[1]/div/a/span"))).click();

                     System.out.println("Size of Size of Timeline: " + (Dimension) driver.findElement(By.xpath("//*[@id='u_0_a']/div[1]/div[1]/div/a/span")).getSize());

                     System.out.println("Location of Size of Timeline: " + (Point) driver.findElement(By.xpath("//*[@id='u_0_a']/div[1]/div[1]/div/a/span")).getLocation());

                   String friends = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[2]/ul/li[3]/a/span[1]"))).getText(); 
                   
                   System.out.println("Size of Size of Friends: " + (Dimension) driver.findElement(By.xpath("//div[2]/ul/li[3]/a/span[1]")).getSize());

                   System.out.println("Location of Size of Friends: " + (Point) driver.findElement(By.xpath("//div[2]/ul/li[3]/a/span[1]")).getLocation());
                   
                   wait.until(ExpectedConditions.presenceOfElementLocated(By.id("userNavigationLabel"))).click() ;
                   
                   System.out.println("Size of Size of Account Settings: " + (Dimension) driver.findElement(By.id("userNavigationLabel")).getSize());

                   System.out.println("Location of Size of Account Settings: " + (Point) driver.findElement(By.id("userNavigationLabel")).getLocation());

                   wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("Log Out"))).click();  
                   
                  System.out.println("Size of Size of Log Out: " + (Dimension) driver.findElement(By.partialLinkText("Log Out")).getSize());

                   System.out.println("Location of Size of Log Out: " + (Point) driver.findElement(By.partialLinkText("Log Out")).getLocation());

                     driver.quit();

System.out.println("Browser is: Chrome");

System.out.println("Title of the page: " + title);

System.out.println("Copyright: " + copyright);

System.out.println("You have" + friends + "friends");

       }

}