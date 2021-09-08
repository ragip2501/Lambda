package Lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Lambda6 {
    public static void main(String[] args) {

        UniversiteLambda6 edebiyatBolum = new UniversiteLambda6("FenEdebiyat", "Edebiyat", 97, 123);
        UniversiteLambda6 iktisatBolum = new UniversiteLambda6("IIBF", "İktisat", 98, 134);
        UniversiteLambda6 matematikBolum = new UniversiteLambda6("FenEdebiyat", "Matematik", 95, 142);
        UniversiteLambda6 ingilizceBolum = new UniversiteLambda6("IngilizDili", "İngilizce", 93, 154);

        List<UniversiteLambda6> uniList = new ArrayList<>(Arrays.asList(edebiyatBolum, iktisatBolum, matematikBolum, ingilizceBolum));


        //1)Tüm ortalama puanların (91)'den büyük olup olmadığını kontrol etmek için bir yöntem oluşturun

        System.out.println(uniList.stream().allMatch(t -> t.getNotOrtalama() > 91)); //true

        //2)Ders adlarından en az birinin "Matem" kelimesini içerip içermediğini kontrol etmek için bir yöntem oluşturun

        System.out.println(uniList.stream().anyMatch(t -> t.getBolum().equals("Matem"))); //false

        //3)Ortalama puanı en yüksek olan kursu yazdırmak için bir yöntem oluşturun

        System.out.println(uniList.stream().sorted(Comparator.comparing(UniversiteLambda6::getNotOrtalama).reversed()).findFirst()); //Optional[UniversiteLambda6{fakulte='IIBF', bolum='İktisat', notOrtalama=98, ogrenciNo=134}]

        //4)Not ortalamasına göre artan sıralama yapıp ilk elemanı atla ve list olarak yazdır

        System.out.println(uniList.stream().sorted(Comparator.comparing(UniversiteLambda6::getNotOrtalama)).skip(1).collect(Collectors.toList()));
        //[UniversiteLambda6{fakulte='FenEdebiyat', bolum='Matematik', notOrtalama=95, ogrenciNo=142}, UniversiteLambda6{fakulte='FenEdebiyat', bolum='Edebiyat', notOrtalama=97, ogrenciNo=123}, UniversiteLambda6{fakulte='IIBF', bolum='İktisat', notOrtalama=98, ogrenciNo=134}]

    }


}
