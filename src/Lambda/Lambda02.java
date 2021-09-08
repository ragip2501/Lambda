package Lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Lambda02 {
    public static void main(String[] args) {
        // Method Reference'da bizim oluşturduğumuz metodları  veya Java metodlarını kullanırız.
        //Method Reference Syntax ı ==> ClassName::MethodName  System.out.println();  ==  System.out::println;
        List<Integer> l = new ArrayList<>(Arrays.asList(15, 14, 9, 13, 4, 9, 2, 4, 14, 6));

        elemanYazdir(l);
        System.out.println();
        ciftSayiYazdir(l);
        System.out.println();
        tekSayiKare(l);
        System.out.println();
        tekSayiKüpTekrarsiz(l);
        System.out.println();
        farkliCiftSayiKareToplam(l);
        System.out.println();
        farkliCiftSayiKupCarpim(l);
        System.out.println();
        System.out.println(farkliTersSirala(l));
        System.out.println();
        maxDeger(l);


    }


    //1)List in elemanlarını aralarında boşluk bırakarak yanyana yazdır.(Method Reference- kendi metodumuz)
    public static void elemanYazdir(List<Integer> l) {
        l.stream().forEach(metodLambda2::boslukYazdir); //15 14 9 13 4 9 2 4 14


    }

    //2)List in elemanlarından çift olanları aralarında boşluk bırakarak yanyana yazdır..(Method Reference)

    public static void ciftSayiYazdir(List<Integer> l) {
        l.stream().filter(metodLambda2::ciftMi).forEach(metodLambda2::boslukYazdir); //14 4 2 4 14


    }

    //3)List teki tek sayıların karelerini alıp aralarında boşluk bırakarak yanyana yazdır
    public static void tekSayiKare(List<Integer> l) {
        l.stream().filter(metodLambda2::tekMi).map(metodLambda2::kareAl).forEach(System.out::print); //2258116981
    }

    //4)List teki tekrarlı olanları silip tek sayıların küplerini alıp aralarında boşluk bırakarak yanyana yazdır.
    public static void tekSayiKüpTekrarsiz(List<Integer> l) {
        l.stream().distinct().filter(metodLambda2::tekMi).map(metodLambda2::kupAl).forEach(metodLambda2::boslukYazdir); //3375 729 2197

    }

    //5)Farklı çift sayıların karelerinin toplamını yazdır (Use Method Reference)
    public static void farkliCiftSayiKareToplam(List<Integer> l) {
        System.out.println(l.stream().distinct().filter(metodLambda2::ciftMi).map(metodLambda2::kareAl).reduce(0, Math::addExact)); //216
    }

    //6)Farklı çift sayıların küplerinin çarpımını yazdır .(Use Method Reference)

    public static void farkliCiftSayiKupCarpim(List<Integer> l) {
        System.out.println(l.stream().distinct().filter(metodLambda2::ciftMi).map(metodLambda2::kupAl).reduce(1, Math::multiplyExact)); //1404928
    }

    //7)List teki farklı ve 5 ten büyük çift elemanlarının yarısını alıp ters sıralayarak list olarak yazdır.
    public static List farkliTersSirala(List<Integer> l) {
        return l.stream().distinct().filter(t -> t > 5 && t % 2 == 0).map(t -> t / 2).sorted(Comparator.reverseOrder()).collect(Collectors.toList()); //[7, 3]

    }

    //8)List teki en büyük elemanı ve en küçük elemanı bul.(Use Method Reference) 15 14 9 13 4 9 2 4 14
    public static void maxDeger(List<Integer> l) {
        System.out.println(l.stream().reduce(Integer.MAX_VALUE, Math::min)); //2
        System.out.println(l.stream().reduce(0, Math::max)); //15
        // Diğer yol kısa olan
        l.stream().sorted(Comparator.reverseOrder()).limit(1).forEach(metodLambda2::boslukYazdir); //15
        l.stream().sorted().limit(1).forEach(metodLambda2::boslukYazdir); //2

    }
}
