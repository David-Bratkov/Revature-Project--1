import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Main {
    public static void main(String[] args) throws InterruptedException {


        System.setProperty("webdriver.chrome.driver","C:\\Tools\\Selenium\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe");

        WebDriver driver = new ChromeDriver(options);

        driver.get("http://localhost:9000");
        Thread.sleep(500);

        WebElement WebElem = driver.findElement(By.id("add1-input")); //changing focus to the addition input 1

        //sending keystrokes to that input element
        WebElem.sendKeys("50");
        Thread.sleep(500);

        WebElem = driver.findElement(By.id("add2-input")); //changing focus to the addition input 2

        //sending keystrokes to that input element
        WebElem.sendKeys("5");
        Thread.sleep(500);

        WebElement btn = driver.findElement(By.id("add-btn")); //changing focus to the add button

        btn.click(); //pressing the button

        Thread.sleep(500);

        WebElem = driver.findElement(By.id("sub1-input")); //changing focus to the subtract input 1

        //sending keystrokes to that input element
        WebElem.sendKeys("50");
        Thread.sleep(500);

        WebElem = driver.findElement(By.id("sub2-input")); //changing focus to the subtract input 2

        WebElem.sendKeys("5"); //inputting 5
        Thread.sleep(500);

        btn = driver.findElement(By.id("sub-btn")); //changing focus to the subtract button

        btn.click(); // clicking the button

        Thread.sleep(500);

        WebElem = driver.findElement(By.id("mult1-input")); //changing focus to the multiplication input 1

        //sending keystrokes to that input element
        WebElem.sendKeys("50");
        Thread.sleep(500);

        WebElem = driver.findElement(By.id("mult2-input")); //changing focus to the multiplication input 2

        WebElem.sendKeys("5"); //inputting 5
        Thread.sleep(500);

        btn = driver.findElement(By.id("mult-btn"));

        btn.click();

        Thread.sleep(500);

        WebElem = driver.findElement(By.id("div1-input")); //changing focus to the division input 1

        //sending keystrokes to that input element
        WebElem.sendKeys("50");
        Thread.sleep(500);

        WebElem = driver.findElement(By.id("div2-input")); //changing focus to the division input 2

        WebElem.sendKeys("5"); //inputting 5
        Thread.sleep(500);

        btn = driver.findElement(By.id("div-btn"));

        btn.click();

        Thread.sleep(5000); //wait 5 sec after the whole program finished





        driver.quit(); //closes the driver



    }
}
