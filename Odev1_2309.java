package calismalar;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

import java.util.List;

public class Odev1_2309 extends TestBaseBeforeAfter {
    @Test
    public void test1() {
        //login( ) metodun oluşturun ve oturum açın.
        //https://qa-environment.concorthotel.com/admin/HotelRoomAdmin adresine gidin
        //Username : manager  ○ Password : Manager2!
        //table( ) metodu oluşturun
        //Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody
        //Table’daki tum body’i ve başlıkları(headers) konsolda yazdırın.
        //printRows( ) metodu oluşturun //tr
        //table body’sinde bulunan toplam satir(row) sayısını bulun.
        //Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
        //4.satirdaki(row) elementleri konsolda yazdırın.
        //printCells( ) metodu oluşturun //td
        //table body’sinde bulunan toplam hücre(cell) sayısını bulun.
        //Table body’sinde bulunan hücreleri(cells) konsolda yazdırın.
        //printColumns( ) metodu oluşturun
        //table body’sinde bulunan toplam sutun(column) sayısını bulun.
        //Table body’sinde bulunan sutunlari(column) konsolda yazdırın.
        //5.column daki elementleri konsolda yazdırın.

        login();
        table();
        printRows();
        printCells();
        printColumns();

    }

    private void printColumns() {
        //table body’sinde bulunan toplam sutun(column) sayısını bulun.
        List<WebElement> sutunListSay = driver.findElements(By.xpath("//thead//tr//th"));
        System.out.println("sutunList = " + sutunListSay.size());
        //Table body’sinde bulunan sutunlari(column) konsolda yazdırın.
        sutunListSay.forEach(t-> System.out.println(t.getText()));
        //5.column daki elementleri konsolda yazdırın.
        List<WebElement> besinciColumn = driver.findElements(By.xpath("//tbody//td[5][1]"));
        besinciColumn.forEach(t-> System.out.println(t.getText()));
    }

    private void printCells() {
        //table body’sinde bulunan toplam hücre(cell) sayısını bulun.
        List<WebElement> hucreler = driver.findElements(By.xpath("//tbody//td"));
        System.out.println("hucreler = " + hucreler.size());
        //Table body’sinde bulunan hücreleri(cells) konsolda yazdırın.
        hucreler.forEach(t-> System.out.println(t.getText()));
    }

    private void printRows() {
        //table body’sinde bulunan toplam satir(row) sayısını bulun.
        List<WebElement> satirSayisi = driver.findElements(By.xpath("//tbody//tr"));
        System.out.println("Satir sayisi : " + satirSayisi.size());

        //Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
        satirSayisi.forEach(t-> System.out.println(t.getText()));

        //4.satirdaki(row) elementleri konsolda yazdırın.
        WebElement dorduncuSatir = driver.findElement(By.xpath("//tbody//tr[4]"));
        System.out.println("4. satir : " + dorduncuSatir.getText());



    }

    private void table() {
        //Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody
        List<WebElement> sutunSayisi = driver.findElements(By.xpath("//thead//tr//th"));
        System.out.println("tablodaki sutun sayisi : " + sutunSayisi.size());

        //Table’daki tum body’i ve başlıkları(headers) konsolda yazdırın.
        WebElement basliklar = driver.findElement(By.xpath("//thead//tr"));
        System.out.println("Tablonun basliklari : " + basliklar.getText());
        WebElement tbody = driver.findElement(By.xpath("//tbody"));
        System.out.println("tbody : " + "\n" + tbody.getText());

    }

    private void login() {
        //https://qa-environment.concorthotel.com/admin/HotelRoomAdmin adresine gidin
        //Username : manager  ○ Password : Manager2!
        driver.get("https://concorthotel.com/admin/HotelRoomAdmin");
        Actions actions = new Actions(driver);
       WebElement username = driver.findElement(By.xpath("//*[@id='UserName']"));
       actions.click(username).sendKeys("manager").sendKeys(Keys.TAB).
       sendKeys("Manager1!").sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();

        //Actions actions = new Actions(driver);
       //WebElement userName = driver.findElement("")
    }

}
