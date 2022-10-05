package calismalar;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Ornek005 {
     /*
        1. http://zero.webappsecurity.com/ Adresine gidin
        2. Sign in butonuna basin
        3. Login kutusuna “username” yazin
        4. Password kutusuna “password.” yazin
        5. Sign in tusuna basin
        6. Pay Bills sayfasina gidin
        7. “Purchase Foreign Currency” tusuna basin
        8. “Currency” drop down menusunden Eurozone’u secin
        9. “amount” kutusuna bir sayi girin
        10. “US Dollars” in secilmedigini test edin
        11. “Selected currency” butonunu secin
        12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
        13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin.
         */

    static WebDriver driver;

    @BeforeClass

    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //http://zero.webappsecurity.com/ Adresine gidin
        driver.get("http://zero.webappsecurity.com/");

    }

    @AfterClass
    public static void tearDown() {
        //driver.close();
    }

    @Test
    public void test1() throws InterruptedException {
        //Sign in butonuna basin
        driver.findElement(By.xpath("//*[@id='signin_button']")).click();

        //Login alanine “username” yazdirin
        driver.findElement(By.xpath("//*[@id='user_login']")).sendKeys("username");
        Thread.sleep(2000);

        //4. Password alanine “password” yazdirin
        driver.findElement(By.xpath("//*[@id='user_password']")).sendKeys("password");
        Thread.sleep(2000);

        //5. Sign in buttonuna tiklayin
        driver.findElement(By.xpath("//*[@value='Sign in']")).click();
        Thread.sleep(2000);
        driver.navigate().back();

        //Pay Bills sayfasina gidin
        driver.findElement(By.id("searchTerm")).sendKeys("Pay Bills", Keys.ENTER);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[text()='Zero - Pay Bills']")).click();
        Thread.sleep(2000);

        //“Purchase Foreign Currency” tusuna basin
        driver.findElement(By.xpath("//*[text()='Purchase Foreign Currency']")).click();
        Thread.sleep(2000);

        //“Currency” drop down menusunden Eurozone’u secin
        //Bunun icin drop down menu'su icin select objesi olusturdum.
        WebElement dropdown = driver.findElement(By.xpath("//*[@id='pc_currency']"));
        Select select = new Select(dropdown);

        //select.selectByIndex(6);
        //select.selectByValue("EUR");
        select.selectByVisibleText("Eurozone (euro)");
        Thread.sleep(2000);

        //“amount” kutusuna bir sayi girin
        driver.findElement(By.xpath("//*[@id='pc_amount']")).sendKeys("50");
        Thread.sleep(2000);


        //“US Dollars” in secilmedigini test edin
        Assert.assertFalse(driver.findElement(By.id("pc_inDollars_true")).isSelected());

        //“Selected currency” butonunu secin
        driver.findElement(By.id("pc_inDollars_false")).click();
        Thread.sleep(2000);

        //“Calculate Costs” butonuna basin sonra “purchase” butonuna basin
        driver.findElement(By.id("pc_calculate_costs")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("(//*[@class='pull-right'])[2]")).click();
        Thread.sleep(2000);

        //“Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin.
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='alert_content']")).isDisplayed());
        //*[@id='alert_content']


    }
}
