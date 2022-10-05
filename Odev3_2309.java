package calismalar;

import org.bouncycastle.asn1.cmc.PublishTrustAnchors;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

import java.util.List;

public class Odev3_2309 extends TestBaseBeforeAfter {
    @Test
    public void test1() {
        //Bir Class olusturun D19_WebtablesHomework
        //“https://demoqa.com/webtables” sayfasina gidin
        driver.get("https://demoqa.com/webtables");
        //Headers da bulunan department isimlerini yazdirin
        List<WebElement> departmanİsimleri = driver.findElements(By.xpath("//*[@class='rt-thead -header']"));
        departmanİsimleri.forEach(t-> System.out.println(t.getText()));
        //sutunun basligini yazdirin
        WebElement baslik = driver.findElement(By.xpath("//*[text()='Web Tables']"));
        System.out.println("baslik = " + baslik.getText());
        //Tablodaki tum datalari yazdirin
        List<WebElement> tumDatalar = driver.findElements(By.xpath("//*[@class='rt-table']"));
        tumDatalar.forEach(t-> System.out.println(t.getText()));
        //Tabloda kac cell (data) oldugunu yazdirin
        WebElement dataSayisi = driver.findElement(By.xpath("//*[@class='rt-tr-group']"));
        System.out.println(dataSayisi.getSize());
        //Tablodaki satir sayisini yazdirin
        WebElement satirSayisi = driver.findElement(By.xpath("//*[@class='rt-tbody']"));
        System.out.println("satirSayisi = " + satirSayisi.getSize());
        //Tablodaki sutun sayisini yazdirin
        WebElement sutunSayisi = driver.findElement(By.xpath("//*[@class='rt-tr']"));
        System.out.println("sutunSayisi = " + sutunSayisi.getSize());
        //Tablodaki 3.kolonu yazdirin
        //Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin
        //Page sayfasinda bir method olusturun, Test sayfasindan satir ve sutun sayisini  girdigimde bana datayi yazdirsin
    }
}
