package Lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Lambda01 {
    public static void main(String[] args) {


        List<Integer> l = new ArrayList<>(Arrays.asList(14, 9, 13, 4, 9, 2, 4, 14, 15));
        yazdirJava(l);
        System.out.println();
        yazdirLambda(l);
        System.out.println();
        ciftSayiJava(l);
        System.out.println();
        ciftSayiLambda(l);
        System.out.println();
        tekSayiKare(l);
        System.out.println();
        farkliTekKup(l);
        System.out.println();
        ciftSayiKareToplam(l);
        System.out.println();
        ciftSayiKupCarpim(l);
        System.out.println();
        tersDuzSira(l);
    }


    //1) list in elemanlarını yanyana yazdır (java- structured)
    public static void yazdirJava(List<Integer> list) {
        for (Integer w : list) {
            System.out.print(w + " "); //14 9 13 4 9 2 4 14 15

        }
    }

    //lambda (functional)
    public static void yazdirLambda(List<Integer> l) {
        l.stream().forEach(t -> System.out.print(t + " ")); //14 9 13 4 9 2 4 14 15
    }

    //2)List in elemanlarından ÇİFT olanları aralarında boşluk bırakarak yazdıran metod oluştur(Structured)
    //Java ile
    private static void ciftSayiJava(List<Integer> l) {
        for (Integer w : l) {
            if (w % 2 == 0) {
                System.out.print(w + " "); //14 4 2 4 14
            }
        }
    }

    //Lambda ile
    public static void ciftSayiLambda(List<Integer> l) {
        //lambda expression (-> arrow function)
        l.stream().filter(t -> t % 2 == 0).forEach(t -> System.out.print(t + " ")); //14 4 2 4 14

    }

// 3-List teki tek sayıların karelerini yazdıran method oluşturun

    public static void tekSayiKare(List<Integer> l) {
        l.stream().filter(t -> t % 2 == 1).map(t -> t * t).forEach(t -> System.out.print(t + " ")); //81 169 81 225
    }

    // 4-listedeki tekrarlı elemanları silip tek sayı olanların küplerini yazdıran method oluştur.
    private static void farkliTekKup(List<Integer> l) {
        l.stream().distinct().filter(t -> t % 2 == 1).map(t -> t * t * t).forEach(t -> System.out.print(t + " ")); //729 2197 3375

// 5- Listedeki tekrarlı elamanları silip çift sayı olanların karelerinin toplamını yazdıran method oluştur.

        //java ile çözümü:

        List<Integer> yeni = new ArrayList<>();
        for (Integer w : l) {
            if (!yeni.contains(w) && w % 2 == 0)
                yeni.add(w);  //*************
        }
        int toplam = 0;
        for (Integer w : yeni) {
            toplam = toplam + w * w;
        }
        System.out.println("uzun yol" + toplam);


    }   //Lambda ile çözümü:

    public static void ciftSayiKareToplam(List<Integer> l) {
        System.out.print(l.stream().distinct().filter(t -> t % 2 == 0).map(t -> t * t).reduce(0, (x, y) -> x + y)); //216

//veya bu şekilde yazdırılabilir

        int sayi = l.stream().distinct().filter(t -> t % 2 == 0).map(t -> t * t).reduce(0, (x, y) -> x + y); //216
        System.out.println(sayi);
    }
//6)Listedeki tekrarlı elemanları silip çift sayı olanların küplerinin çarpımını yazdıran metod oluştur

    public static void ciftSayiKupCarpim(List<Integer> l) {

        System.out.println(l.stream().distinct().filter(t -> t % 2 == 0).map(t -> t * t * t).reduce(1, (x, y) -> x * y)); //1404928

        // veya

        int kup = l.stream().distinct().filter(t -> t % 2 == 0).map(t -> t * t * t).reduce(1, (x, y) -> x * y);
    }

//7)Listedeki elemanları sıralayarak ve ters sıralayarak yazdır

    public static void tersDuzSira(List<Integer> l) {
        l.stream().sorted().forEach(t -> System.out.print(t + " ")); //2 4 4 9 9 13 14 14 15
        System.out.println();
        l.stream().sorted(Comparator.reverseOrder()).forEach(t -> System.out.print(t + " ")); //15 14 14 13 9 9 4 4 2


    }


}
