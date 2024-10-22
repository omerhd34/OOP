package LAB.LAB1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Faktöriyel hesaplama işlemi için kullanacağımız değişkenleri tanımlıyoruz.
        int n, Fact = 1;

        System.out.print("Faktöriyel hesaplanacak olan sayıyı giriniz: ");
        Scanner in = new Scanner(System.in);
        n = in.nextInt();    // Ekrandan okuduğumuzu n değişkenine atıyoruz.

        if (n < 0) {
            System.out.println("Negatif sayıların faktöriyel alınamaz.");
        } else {
            for (int i = 1; i <= n; i++) {
                Fact = Fact * i;
            }
            System.out.println(n + "! faktöriyel = " + Fact);
        }
    }
}
/*
Faktöriyel hesaplanacak olan sayıyı giriniz:5
5! faktöriyel = 120


 */