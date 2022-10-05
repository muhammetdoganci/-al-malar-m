package calismalar;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class Ornek006 extends TestBaseBeforeAfter {
    @Test
    public void test1(){
        //1. "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");

        //2. "Hover over Me First" kutusunun ustune gelin
        WebElement hoveOverMeFirst = driver.findElement(By.xpath("//*[text()='Hover Over Me First!']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(hoveOverMeFirst).perform();

        //3. "Link 1" e tiklayin
        driver.findElement(By.xpath("//*[text()='Link 1']")).click();

        //4. Popup mesajini yazdirin
        String actualYazi = driver.switchTo().alert().getText();
        System.out.println(actualYazi);

        //5. Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();

        //6. "Click and hold" kutusuna basili tutun
        WebElement clinkAndHold = driver.findElement(By.xpath("//*[text()='Click and Hold!']"));
        Actions actions1 = new Actions(driver);
        actions1.moveToElement(clinkAndHold).click().clickAndHold().perform();


        //7. "Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println(driver.findElement(By.xpath("//*[@id='click-box']")));

        //8. "Double click me" butonunu cift tiklayin
        WebElement doubleClickMe = driver.findElement(By.xpath("//*[text()='Double Click Me!']"));
        actions.moveToElement(doubleClickMe).doubleClick();
    }
}
