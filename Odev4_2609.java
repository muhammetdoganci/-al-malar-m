package calismalar;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;
import utilities.TestBaseBeforeAfter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Odev4_2609 extends TestBaseBeforeAfter {
    @Test
    public void test1() throws IOException {
        String dosyayolu = "src/main/resources/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyayolu);
        Workbook workbook = WorkbookFactory.create(fis);


        // 1.satirdaki 2.hucreye gidelim ve yazdiralim
        // 1.satirdaki 2.hucreyi bir string degiskene atayalim ve yazdiralim
        String row1Cell2 = workbook.getSheet("Sayfa1").getRow(1).getCell(1).toString();
        System.out.println(row1Cell2);
        // 2.satir 4.cell’in afganistan’in baskenti oldugunu test edelim
        String actualCell4 = workbook.getSheet("Sayfa1").getRow(1).getCell(3).toString();
        String expectedCell4 = "Kabil";
        Assert.assertEquals(actualCell4,expectedCell4);
        // Satir sayisini bulalim
        // Fiziki olarak kullanilan satir sayisini bulun
        int satirSayisi = workbook.getSheet("Sayfa1").getLastRowNum();
        int kullanilanSatir = workbook.getSheet("Sayfa1").getPhysicalNumberOfRows();
        System.out.println("Satir sayisi : "  + (satirSayisi+1));
        System.out.println("Kullanilan satir sayisi : " + kullanilanSatir);
        // Ingilizce Ulke isimleri ve baskentleri bir map olarak kaydedelim
    }
}
