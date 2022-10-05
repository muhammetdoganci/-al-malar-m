package calismalar;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Ornek002 {

    //Bir class oluşturun :RadioButtonTest
    //2.Gerekli yapiyi olusturun ve aşağıdaki görevitamamlayın.
            //-https://www.facebook.com adresinegidin
            //-Cookies’i kabuledin
            //-“Create an Account” button’una basin
            //-“radio buttons” elementlerini locateedin
            //-Secili degilse cinsiyet butonundan size uygun olanisecin

    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @After
    public void teardown(){
        //driver.close();
    }
    @Test
    public void test1() throws InterruptedException {
        //-https://www.facebook.com adresinegidin
        driver.get("https://www.facebook.com");

        //-Cookies’i kabuledin
        //-“Create an Account” button’una basin
        driver.findElement(By.xpath("(//*[@role='button'])[2]")).click();

        //-“radio buttons” elementlerini locateedin

        WebElement femaleButton = driver.findElement(By.xpath("//input[@value='1']"));
        WebElement maleButton = driver.findElement(By.xpath("//input[@value='2']"));
        WebElement customButton = driver.findElement(By.xpath("//input[@value='-1']"));
        //-Secili degilse cinsiyet butonundan size uygun olanisecin

        if (!maleButton.isSelected()){
            maleButton.click();
        }

        Thread.sleep(2000);
        femaleButton.click();
        Thread.sleep(2000);
        customButton.click();

    }

}
