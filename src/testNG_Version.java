import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class testNG_Version {

    private WebDriverWait wait;
    private WebDriver driver;

    @Parameters({"username", "password"})
    @BeforeClass
    public void setUpPart(String username, String password) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\manuchar.markoidze.PCSST\\Desktop\\MySelenium\\Chrom driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://test-basqar.mersys.io/");
        driver.manage().window().maximize();


        wait = new WebDriverWait(driver, 5);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.findElement(By.cssSelector("[formcontrolname=\"username\"]")).sendKeys(username);
        driver.findElement(By.cssSelector("[formcontrolname=\"password\"]")).sendKeys(password);
        driver.findElement(By.cssSelector("button[aria-label=\"LOGIN\"]")).click();
    }

    @Test
    public void main() {
        // to select "Budget", the first child of group items
        driver.findElement(By.cssSelector(".group-items > :nth-child(6)")).click();
        // to select "Setup", the first child of  the first child of group items
        driver.findElement(By.cssSelector(".group-items > :nth-child(6) > .children > :nth-child(1)")).click();
        // to select "budget groups ", the forth child of the first child of  the first child of group items
        driver.findElement(By.cssSelector(".group-items > :nth-child(6) > .children > :nth-child(1) > .children > :nth-child(1)")).click();
        driver.findElement(By.cssSelector("[data-icon='plus']")).click();
        // driver.findElement(By.xpath("//*[@class='mat-mini-fab mat-button-base mat-accent']")).click();

        driver.findElement(By.xpath("//*[@id=\"mat-input-5\"]")).sendKeys("Marks group");
        // driver.findElement(By.xpath("mat-option-10")).click();
        driver.findElement(By.cssSelector("#mat-select-2")).click();
        driver.findElement(By.xpath("//*[@id=\"mat-option-11\"]/span")).click();
        driver.findElement(By.xpath("//*[@id=\"mat-input-7\"]")).sendKeys("01/21/2020");
        driver.findElement(By.xpath("//*[@id=\"mat-input-8\"]")).sendKeys("03/06/2020");
        driver.findElement(By.xpath("//*[@id=\"mat-input-6\"]")).sendKeys("comment");
        WebElement saveIcon = driver.findElement(By.cssSelector("mat-dialog-container [data-icon=\"save\"]"));
        saveIcon.click();
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[aria-label='Budget Group successfully created']")));

        } catch (Exception e) {
            Assert.fail("Delete failure", e);
        }

    }

//    @AfterClass
//    public void quit () {
//        driver.quit();
//
//    }
}


