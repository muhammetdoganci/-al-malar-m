package calismalar;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class Odev2_2309 extends TestBaseBeforeAfter {
    //Bir metod oluşturun : printData(int row, int column);
    //Satır(row) ve sütun(column) numarasını girdiğinizde, printData metodu bu
    //hücredeki(cell) veriyi yazdırmalıdır.
    //Baska bir Test metodu oluşturun: printDataTest( );
    //Ve bu metodu printData( ) methodunu cagirmak icin kullanin.
    //Örnek: printData (3,5); => 3. satır, 5. Sütundaki veriyi yazdırmalıdır
    //yazdirilan datanin olmasi gereken dataya esit oldugunu test edin

    @Test
    public void test1(){
        driver.get("https://concorthotel.com/admin/HotelRoomAdmin");
        Actions actions = new Actions(driver);
        WebElement username = driver.findElement(By.xpath("//*[@id='UserName']"));
        actions.click(username).sendKeys("manager").sendKeys(Keys.TAB).
        sendKeys("Manager1!").sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();

        printData();
        printDataTest();
    }

    public static void printData() {
        //Satır(row) ve sütun(column) numarasını girdiğinizde, printData metodu bu
        //hücredeki(cell) veriyi yazdırmalıdır.
        WebElement satirVeSutun = driver.findElement(By.xpath("//tr[6]//td[5]"));
        System.out.println("satirVeSutun = " + satirVeSutun.getText());
        Assert.assertEquals("ITALY",satirVeSutun.getText());

    }
    public static void printDataTest() {
        //Ve bu metodu printData( ) methodunu cagirmak icin kullanin.
        //Örnek: printData (3,5); => 3. satır, 5. Sütundaki veriyi yazdırmalıdır
        //yazdirilan datanin olmasi gereken dataya esit oldugunu test edin

    }

}
