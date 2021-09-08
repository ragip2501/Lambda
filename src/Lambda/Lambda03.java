package Lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lambda03 {
    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>(Arrays.asList(7, 12, 14, 4, 9, 2, 4, 12, 16));
        ilkDörtEleman(l);
        System.out.println();
        ilkDortElemanGec(l);
        System.out.println();
        ucElemanYazdir(l);
    }


    //1) kücükten büyüge sırala sonra ilk 4 elemanı yazdır
    public static void ilkDörtEleman(List<Integer> l) {
        l.stream().sorted().limit(4).forEach(metodLambda2::boslukYazdir); //2 4 4 7
    }

    //2) kücükten büyüğe sırala ilk 4 elamanı atla
    public static void ilkDortElemanGec(List<Integer> l) {
        l.stream().sorted().skip(4).forEach(metodLambda2::boslukYazdir); //9 12 12 14 16

    }

    //3) kücükten büyüğe sıralı 4. 5. 6. elemanı yazdır
    public static void ucElemanYazdir(List<Integer> l) {
        l.stream().sorted().skip(3).limit(3).forEach(metodLambda2::boslukYazdir); //7 9 12
    }

}
