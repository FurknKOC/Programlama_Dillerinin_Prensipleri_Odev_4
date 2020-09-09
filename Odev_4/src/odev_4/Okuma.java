/**
*
* @author Furkan KOÇ - furkan.koc8@ogr.sakarya.edu.tr
* @author Muzaffer Haşim GEZGİN - muzaffer.gezgin@ogr.sakarya.edu.tr
* @since 29/04/2019
* <p>
* Programlama Dillerinin Prensipleri Dersi 4. Ödevi
* </p>
*/
package odev_4;

/**
 *
 * @author FURKAN
 */
import java.io.BufferedReader; // Okuma yapmak için gerekli olan kütüphaneleri projemize ekliyoruz.
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Okuma 
{
    private String str;
    public int satirSayisi;
    public ArrayList<Integer> birlerBasamagi = new ArrayList<Integer>(); //Gerekli olan ArrayListlerimizi ve değişkenlerimizi oluşturuyoruz.
    public ArrayList<Integer> onlarBasamagi = new ArrayList<Integer>();
    public ArrayList<Integer> yuzlerBasamagi = new ArrayList<Integer>();
    public ArrayList<Integer> binlerBasamagi = new ArrayList<Integer>();  


    public Okuma(String dosyaAdi) 
    {
        
        try 
        {
            FileInputStream fStream = new FileInputStream(dosyaAdi); // Gelen dosya adına göre okuma işlemlerimizi yapıyoruz.
            DataInputStream dStream = new DataInputStream(fStream);
            BufferedReader bReader = new BufferedReader(new InputStreamReader(dStream));

            while ((str = bReader.readLine()) != null) // Tüm satırlar okunana kadar bir while döngüsü oluşturuyoruz.
            {
                birlerBasamagi.add(Integer.valueOf(str.substring(3, 4)));//Birler basamağını birlerBasamagi ArrayListimizin içine atıyoruz. Onlar, yüzler ve binler basamakları içinde aynı işlemi yapıyoruz.
                onlarBasamagi.add(Integer.valueOf(str.substring(2, 3)));
                yuzlerBasamagi.add(Integer.valueOf(str.substring(1, 2)));
                binlerBasamagi.add(Integer.valueOf(str.substring(0, 1)));
            }
            dStream.close();
        } 
        catch (Exception e) 
        {
            System.err.println("Hata : " + e.getMessage()); //Eğer hata oluşursa hatayı yazdırıyoruz.
        }
    }

}
