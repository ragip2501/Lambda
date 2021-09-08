package Lambda;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class LambdaFile107 {
    public static void main(String[] args) {

        //functional programming kullanarak bir dosya nasıl okunur

        try {
            Files.lines(Paths.get("C:\\Users\\user\\eclipse-workspace\\Lambda\\src\\Lambda\\LambdaFile1")).forEach(t -> System.out.println(t));
            //Java kolaydır, lambda daha kolaydır.
            //Lambda öğrenirseniz kodlama daha az zaman alacaktır.
            //Kursumuzdaki her ders ceketin cepleriyse, java iç cep, lambda da iç cebin bozuk para  kısmı

        } catch (IOException e) {
            System.out.println(e);
        }

        //Tüm karakterleri büyük harfe dönüştürün ve okuyun

        try {
            Files.lines(Paths.get("C:\\Users\\user\\eclipse-workspace\\Lambda\\src\\Lambda\\LambdaFile1")).map(String::toUpperCase).forEach(t -> System.out.println(t));
            //JAVA KOLAYDIR, LAMBDA DAHA KOLAYDIR.
            //LAMBDA ÖĞRENİRSENİZ KODLAMA DAHA AZ ZAMAN ALACAKTIR.
            //KURSUMUZDAKİ HER DERS CEKETİN CEPLERİYSE, JAVA İÇ CEP, LAMBDA DA İÇ CEBİN BOZUK PARA  KISMI

        } catch (IOException e) {
            System.out.println(e);
        }

        //metindeki farklı kelimeleri yazdır

        try {
            Files.lines(Paths.get("C:\\Users\\user\\eclipse-workspace\\Lambda\\src\\Lambda\\LambdaFile1")).map(t -> t.split(" ")).
                    flatMap(Arrays::stream).map(t -> t.replaceAll("\\W", "")).distinct().forEach(System.out::println);
        } catch (IOException e) {
            System.out.println(e);
        }

        // metinde "e" içeren tüm kelimeleri yazdırın. (sayısınıda yazdırabilirsin)

        try {
            Files.lines(Paths.get("C:\\Users\\user\\eclipse-workspace\\Lambda\\src\\Lambda\\LambdaFile1")).map(t -> t.split(" ")).
                    flatMap(Arrays::stream).filter(t -> t.contains("e")).forEach(System.out::println);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

}
