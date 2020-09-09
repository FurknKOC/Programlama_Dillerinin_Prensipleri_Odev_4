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

import java.util.ArrayList;

/**
 *
 * @author FURKAN
 */
public class Hesap implements Runnable
{
    private ArrayList<Integer> arraylist; //Gerekli ArrayList ve değişkenleri tanımlıyoruz.
    private int toplam;
    static int sayac;
    public Hesap(ArrayList arraylist) //Hesap fonksiyonuna ArrayListimizi gönderiyoruz.
    {
        sayac++;//sayacı 1 arttırıyoruz.
        toplam = 0;
        this.arraylist = arraylist; //fonksiyona aldığımız ArrayListi oluşturduğumuz arraylist'in içine atıyoruz.
    }
    
    @Override
    public void run() 
    {
        for (int i = 0; i < arraylist.size(); i++) //arraylist'in uzunluğu kadar bir for döngüsü oluşturuyoruz.
            toplam += arraylist.get(i); // arraylistimizin içindeki sayıları teker teker topluyoruz.
        
        if (sayac == 4) //eğer sayac 4 olursa toplamımızı yazdırıyoruz.
            System.out.print(toplam); //Toplam değerimizi yazdırıyoruz.
    }
}
