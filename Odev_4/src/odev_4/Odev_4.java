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

import java.util.concurrent.ExecutorService; //Gerekli kütüphaneleri ekliyoruz.
import java.util.concurrent.Executors;



/**
 *
 * @author FURKAN
 */
public class Odev_4 {
  
    public static void main(String[] args) 
    {
        Okuma Oku = new Okuma("Sayilar.txt"); //Dosyadan okuma yapmak için txt dosyamızın adını göndererek okuma yapıyoruz.

        System.out.print("Sonuç ");
        ExecutorService havuz = Executors.newFixedThreadPool(1); //Seri programlama için 1 threadli havuz oluşturuyoruz.
        long baslangic = System.nanoTime(); //Süremizi hesaplamak için bir başlangıç nanotime'ı alıyoruz.
        havuz.execute(new Hesap(Oku.binlerBasamagi)); //her basamaktaki sayıları hesaplamak için ayrı ayrı havuzda çalıştırıyoruz.
        havuz.execute(new Hesap(Oku.yuzlerBasamagi));
        havuz.execute(new Hesap(Oku.onlarBasamagi));
        havuz.execute(new Hesap(Oku.birlerBasamagi));
        havuz.shutdown(); //Havuzu kapatıyoruz.
        
        while(!havuz.isTerminated()){ } //Havuzun hala çalışmadığına emin oluyoruz.
        long bitis = System.nanoTime(); //Süremizi hesaplamak için bir bitiş nanotime'ı alıyoruz.
        double sure = (bitis-baslangic)/1000000.0; //Hesaplama süremizi hesaplıyoruz.
        System.out.println("\nSeri Hesaplama Süresi: " + sure); //Hesaplama süremizi yazdırıyoruz.
        
        ExecutorService havuz2 = Executors.newFixedThreadPool(3); //Yukarıdaki işlemlerin aynısını bu sefer paralel programlama için 3 threadli havuz oluşturarak yapıyoruz.
        long baslangic2 = System.nanoTime();
        
        havuz2.execute(new Hesap(Oku.binlerBasamagi));
        havuz2.execute(new Hesap(Oku.yuzlerBasamagi));
        havuz2.execute(new Hesap(Oku.onlarBasamagi));
        havuz2.execute(new Hesap(Oku.birlerBasamagi));
        havuz2.shutdown();
        
        while(!havuz2.isTerminated()){ }
        long bitis2 = System.nanoTime();
        double sure2 = (bitis2-baslangic2)/1000000.0;
        System.out.println("Paralel Hesaplama Süresi: " + sure2);
    }
}
