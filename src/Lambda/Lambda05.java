package Lambda;

import java.util.stream.IntStream;

public class Lambda05 {
    public static void main(String[] args) {

        //1) 1 den 20 ye kadar olan sayıları yazdır

        IntStream.rangeClosed(1, 20).forEach(metodLambda2::boslukYazdir); //1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20

        System.out.println();

        //2) functional programlamayı kullanarak 3 den 98 kadar olan çift sayıların toplamını bulun

        System.out.println(IntStream.rangeClosed(3, 98).filter(metodLambda2::ciftMi).sum()); //2448

        System.out.println();

        //3) functional programlamayı kullanarak 9! i bul (9!=1*2*3...*9)

        System.out.println(IntStream.rangeClosed(1, 9).reduce(1, Math::multiplyExact)); //362880

        System.out.println();

        // 4) İlk 7 çift sayma sayısının çarpımını bulun (2,4,6,8,10,12,14)

        System.out.println(IntStream.rangeClosed(2, 14).filter(t -> t % 2 == 0).reduce(1, Math::multiplyExact)); //645120

        System.out.println();

        //5)  6'dan büyük ilk 15 tek sayma sayısının toplamını bulun ==> 7, 9, 11, 13, 15, 17, 19

        System.out.println(IntStream.iterate(7, t -> t + 2).limit(150).sum()); //23400

        System.out.println();

        //6) İlk 23 cift sayma sayısının toplamını bulun

        System.out.println(IntStream.iterate(2, t -> +2).limit(23).sum()); //46

        System.out.println();

        //7)  11 den 33 arasındaki her tam sayının rakamlarının toplamını hesaplamak için bir metod oluşturun

        IntStream.rangeClosed(11,33).map(metodLambda2::rakamlarToplami).forEach(metodLambda2::boslukYazdir); //2 3 4 5 6 7 8 9 10 2 3 4 5 6 7 8 9 10 11 3 4 5 6




    }
}
