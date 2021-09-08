package Lambda;

import java.util.*;

public class Lambda04 {
    public static void main(String[] args) {

        List<String> l = new ArrayList<>(Arrays.asList("Ali", "Ali", "Aysima", "Abdurrahman", "Mehmet", "Mustafa", "Bedirhan", "Yüksel", "Süleyman"));

        yazdirBuyuk(l);

        System.out.println();

        uzunlukSirala(l);

        System.out.println();

        farkliSonHarfSirala(l);

        System.out.println();

        uzunlukSiralaIlkEleman(l);

        System.out.println();

        yazdirAİleBaslayan(l);

        System.out.println();

        AbaslaVeyaİBit(l);

        System.out.println();

        siralaBuyut(l);

        System.out.println();

        isimUzunlukSirala(l);

        System.out.println();

        karesiniAlSiralaSil(l);

        System.out.println();

        ebikGabik(l);

        System.out.println();

        sondanİkinciSiralaİlk(l);

        System.out.println();

        terstenSiralaİlkYazdir(l);

    }


    //1)Listin elemanlarını büyük harfle yazdır.

    public static void yazdirBuyuk(List<String> l) {

        l.stream().map(t -> t.toUpperCase()).forEach(metodLambda2::boslukYazdir); //ALİ ALİ AYSİMA ABDURRAHMAN MEHMET MUSTAFA BEDİRHAN YÜKSEL SÜLEYMAN

        l.stream().map(String::toUpperCase).forEach(metodLambda2::boslukYazdir); //ALİ ALİ AYSİMA ABDURRAHMAN MEHMET MUSTAFA BEDİRHAN YÜKSEL SÜLEYMAN
    }

    //2) elemanları uzunluklarına göre sırala ve yazdır

    public static void uzunlukSirala(List<String> l) {

        l.stream().sorted(Comparator.comparing(String::length)).forEach(metodLambda2::boslukYazdir); //Ali Ali Aysima Mehmet Yüksel Mustafa Bedirhan Süleyman Abdurrahman

        l.stream().sorted(Comparator.comparing(String::length).reversed()).forEach(metodLambda2::boslukYazdir); //Abdurrahman Bedirhan Süleyman Mustafa Aysima Mehmet Yüksel Ali Ali
    }

    //3) farklı elemanlarını son harflerine göre sıralayıp yazdır

    public static void farkliSonHarfSirala(List<String> l) {

        l.stream().distinct().sorted(Comparator.comparing(t -> t.substring(t.length() - 1))).forEach(metodLambda2::boslukYazdir); //Aysima Mustafa Ali Yüksel Abdurrahman Bedirhan Süleyman Mehmet

    }
    //4) Elemanları uzunluklarına ve ardından (aynı uzunlukta olanları) ilk karakterlerine göre sıralamak için bir yöntem oluşturun

    public static void uzunlukSiralaIlkEleman(List<String> l) {

        l.add("Ata");

        l.stream().distinct().sorted(Comparator.comparing(String::length).thenComparing(t -> t.substring(0, 1))).forEach(metodLambda2::boslukYazdir); //Ali Ata Aysima Mehmet Yüksel Mustafa Bedirhan Süleyman Abdurrahman


    }

    //5) //6)Büyük harflerle, "A" ile başlayan liste öğelerini yazdırmak için bir yöntem oluşturun

    public static void yazdirAİleBaslayan(List<String> l) {

        l.stream().filter(t -> t.startsWith("A")).map(String::toUpperCase).forEach(metodLambda2::boslukYazdir); //ALİ ALİ AYSİMA ABDURRAHMAN ATA


    }

    //6)  Küçük harflerle, "A" ile başlayan veya "i" ile biten liste öğelerini yazdırmak için bir yöntem oluşturun

    public static void AbaslaVeyaİBit(List<String> l) {

        l.stream().filter(t -> t.startsWith("A") || t.endsWith("İ")).map(String::toLowerCase).forEach(metodLambda2::boslukYazdir); //ali ali aysima abdurrahman ata

        //method reference ile yaparsak komutların içine sadece bir işlem alabiliriz. arrow (->) function da && || larla istediğimiz kadar işlem alabiliriz.
    }

    //7) Öğeleri uzunluklarına göre sıraladıktan sonra büyük harflerle yazdırmak için bir yöntem oluşturun

    public static void siralaBuyut(List<String> l) {

        l.stream().map(String::toUpperCase).sorted(Comparator.comparing(String::length)).forEach(metodLambda2::boslukYazdir); //ALİ ALİ ATA AYSİMA MEHMET YÜKSEL MUSTAFA BEDİRHAN SÜLEYMAN ABDURRAHMAN

    }

    //8) Elemanları uzunluklarına göre sıralayın önce elemanı sonra uzunluğunu yazdırın

    public static void isimUzunlukSirala(List<String> l) {

        l.stream().sorted(Comparator.comparing(String::length)).map(t -> t + ":" + t.length()).forEach(metodLambda2::boslukYazdir); //Ali:3 Ali:3 Ata:3 Aysima:6 Mehmet:6 Yüksel:6 Mustafa:7 Bedirhan:8 Süleyman:8 Abdurrahman:11
    }

    //9) Her elemanın uzunluğunun karesini alıp tekrarlıları sil, bunların 20'den büyük olanlarını ters sırada  yazdırın

    public static void karesiniAlSiralaSil(List<String> l) {

        l.stream().map(t -> t.length() * t.length()).distinct().filter(t -> t > 20).sorted(Comparator.reverseOrder()).forEach(metodLambda2::boslukYazdir); //121 64 49 36
    }

    //10) Tüm elemanların uzunluklarının 12'den az olup olmadığını kontrol etmek için bir metod oluşturun
    //bütün elemanların "x" ile başlamadığını kontrol etmek için bir yöntem oluşturun
    //en az 1 tane "R" ile biten eleman olup olmadığını kontrol etmek için bir metod oluşturun.

    public static void ebikGabik(List<String> l) {

        boolean result1 = l.stream().allMatch(t -> t.length() < 12);

        System.out.println("elemanları uzunlıkları 12 den küçükmü?" + result1); //true

        System.out.println();

        boolean result2 = l.stream().noneMatch(t -> t.startsWith("X"));

        System.out.println("x ile baslayan öğe yok" + result2); //true

        System.out.println();

        boolean result3 = l.stream().anyMatch(t -> t.endsWith("R"));

        System.out.println("elemanlardan herhangi biri r ile bitiyormu?" + result3); //false
    }

    //11) elemanları sondan 2. elemanlarına göre sıralayıp ilk elemanı yazdır

    public static void sondanİkinciSiralaİlk(List<String> l) {

        System.out.println(l.stream().sorted(Comparator.comparing(t -> t.charAt(t.length() - 2))).findFirst()); //Optional[Abdurrahman]
    }

    //12)elemanlari uzunluklarina gore tersten siralayip ilk elemani yazdir

    public static void terstenSiralaİlkYazdir(List<String> l) {

        System.out.println(l.stream().sorted(Comparator.comparing(String::length).reversed()).findFirst()); //Optional[Abdurrahman]

        //Eleman 'A', 'a' ile başlıyor veya 'N', 'n' ile bitiyorsa o elemanı silin

        l.removeIf(t -> t.toUpperCase().startsWith("A") || t.toUpperCase().endsWith("N"));

        System.out.println(l); //[Mehmet, Mustafa, Yüksel]


    }


}
