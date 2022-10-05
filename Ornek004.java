package calismalar;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class Ornek004 {
    /*
    1.http://zero.webappsecurity.com/ Adresine gidin
    2.Sign in butonunabasin
    3.Login kutusuna “username”yazin
    4.Password kutusuna “password.”yazin
    5.Sign in tusuna basin
    6.Pay Bills sayfasina gidin
    7.“Purchase Foreign Currency” tusuna basin
    8.“Currency” drop down menusunden Eurozone’usecin
    9.“amount” kutusuna bir sayigirin
    10.“US Dollars” in secilmedigini testedin
    11.“Selected currency” butonunu secin
    12.“Calculate Costs” butonuna basin sonra “purchase” butonuna basin
    13.“Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin.
     */
    WebDriver driver;
    Select select;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://zero.webappsecurity.com/");
    }
    @After
    public void tearDown(){
        //driver.close();
    }
    @Test
    public void test1() throws InterruptedException {
        //2.Sign in butonuna basin
        driver.findElement(By.xpath("//*[@id='signin_button']")).click();
        Thread.sleep(1000);
        //3.Login kutusuna “username”yazin
        driver.findElement(By.xpath("//input[@name='user_login']")).sendKeys("username");
        Thread.sleep(1000);
        //4.Password kutusuna “password.”yazin
        driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("password");
        Thread.sleep(1000);
        //5.Sign in tusuna basin
        driver.findElement(By.xpath("//input[@value='Sign in']")).click();
        Thread.sleep(2000);
        driver.navigate().back();
        //6.Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//*[text()='Online Banking']")).click();
        driver.findElement(By.xpath("//*[@id='pay_bills_link']")).click();
        //7.“Purchase Foreign Currency” tusuna basin
        driver.findElement(By.xpath("//*[text()='Purchase Foreign Currency']")).click();
        //8.“Currency” drop down menusunden Eurozone’usecin
        WebElement ddm = driver.findElement(By.xpath("//*[@id='pc_currency']"));
        Select select = new Select(ddm);
        select.selectByValue("EUR");
        //9.“amount” kutusuna bir sayigirin
        driver.findElement(By.xpath("//*[@id='pc_amount']")).sendKeys("50");
        //10.“US Dollars” in secilmedigini testedin
        Assert.assertFalse(driver.findElement(By.xpath("//*[@id='pc_inDollars_true']")).isSelected());
        //11.“Selected currency” butonunu secin
        driver.findElement(By.xpath("//*[@id='pc_inDollars_false']")).click();
        //12.“Calculate Costs” butonuna basin sonra “purchase” butonuna basin
        driver.findElement(By.id("pc_calculate_costs")).click();
        driver.findElement(By.id("purchase_cash")).click();
        //13.“Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin.
        driver.findElement(By.id("alert_content")).isDisplayed();
        WebElement yazi = driver.findElement(By.xpath("//*[text()='Foreign currency cash was successfully purchased.']"));
        System.out.println(yazi.getText());

        driver.findElement(By.xpath("//*[text()='Purchase Foreign Currency']")).click();
        WebElement selectOne = driver.findElement(By.xpath("//*[@name='currency']"));
       Select options = new Select(selectOne);
        //System.out.println(selectOne.getText());
        List<WebElement> tumOptions = options.getOptions();
        System.out.println(tumOptions.size());
        tumOptions.forEach(t-> System.out.println(t.getText()));



    }
}
