package utils;


import lombok.Getter;
import java.util.HashMap;



@Getter

public class Localization {

    final HashMap<String,String> turkish=new HashMap<String,String>();

   final HashMap<String,String> english=new HashMap<String,String>();
    public Localization(){
        //fill hashmap corrospending values

        turkish.put("username","kullanici adi");
        turkish.put("password","sifre");
        turkish.put("login screen","giris ekrani");
        turkish.put("login","giris");
        turkish.put("Show benefits cost sharing data","Fayda maliyet paylaşımı verilerini göster");
        turkish.put("Show rate data","Oran verilerini göster");
        turkish.put("Show business rules data","İş kuralları verilerini göster");
        turkish.put("Show plan attributes data","Plan özellikleri verilerini göster");
        turkish.put("Welcome Admin","Hoşgeldin Admin");
        turkish.put("lang","tr");

        turkish.put("UsersbyExpirationDate","Çizgi Grafiği Çiz(Son Kullanma Tarihine Göre Kullanıcılar)");

        turkish.put("NumberOfCustomersByState","Pasta Grafiği Çiz (Eyalete Göre Müşteri Sayısı)");
        turkish.put("NewPlansSelledByDate","Zaman Serileri Grafiği Çiz (Tarihe Göre Satılan Yeni Planlar)");
        turkish.put("NumberofCustomersByMarketCoverage","Pasta Grafiği Çiz (Piyasa Kapsamına Göre Müşteri Sayısı)");

        //default values of english map dictionary


        english.put("username","username");
        english.put("password","password");
        english.put("login screen","login screen");
        english.put("login","login");
        english.put("Welcome Admin","Welcome Admin");

        english.put("lang","en");




    }

}
