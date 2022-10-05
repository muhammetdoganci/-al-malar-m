package calismalar;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class Ornek003 {
    /*
    ●https://the-internet.herokuapp.com/dropdown adresine gidin.
    1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
    3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin veyazdırın
    4.Tüm dropdown değerleri(value)yazdırın
    5.Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse
    False yazdırın.
     */
    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/dropdown");
    }
    @After
    public void tearDown(){
        driver.close();
    }
    @Test
    public void test1(){
        //1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        WebElement dropDown = driver.findElement(By.xpath("//*[@id='dropdown']"));
        dropDown.click();
        Select option1 = new Select(dropDown);
        option1.selectByIndex(1);
        WebElement option1Yazisi = driver.findElement(By.xpath("//*[text()='Option 1']"));
        System.out.println(option1Yazisi.getText());

        // 2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        WebElement dropDown2 = driver.findElement(By.xpath("//*[@id='dropdown']"));
        dropDown2.click();
        Select option2 = new Select(dropDown2);
        option2.selectByValue("2");
        WebElement option2Yazisi = driver.findElement(By.xpath("//*[text()='Option 2']"));
        System.out.println(option2Yazisi.getText());

        //3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        WebElement dropDownWe = driver.findElement(By.xpath("//*[@id='dropdown']"));
        dropDownWe.click();
        Select option1Vsb = new Select(dropDown);
        option1Vsb.selectByVisibleText("Option 1");
        WebElement option1YazisiVsb = driver.findElement(By.xpath("//*[text()='Option 1']"));
        System.out.println(option1YazisiVsb.getText());

        //4.Tüm dropdown değerleri(value)yazdırın
        List<WebElement>dropDownTumu = driver.findElements(By.xpath("//*[@id='dropdown']"));
        System.out.println(dropDownTumu.size());
        for (WebElement We:dropDownTumu) {
            System.out.println(We.getText());
        }

        //5.Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse
        //False yazdırın.
        List<WebElement>dropDownlist = driver.findElements(By.xpath("//*[@id='dropdown']"));
        System.out.println(dropDownlist.size());
        for (WebElement drList:dropDownlist) {
            System.out.println(drList.getText());

        }
        int dropDownSayisi = dropDownlist.size();
        int expectedSayi = 4;
        if (dropDownSayisi==expectedSayi){
            System.out.println("True");
        }else System.out.println("False");





    }
}
