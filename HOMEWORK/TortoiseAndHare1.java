/*
THE TORTOISE AND THE HARE(KAPLUMBAĞA VE TAVŞAN):
Yarışmacılarımız yarışa 70 karenin 1. karesinden başlar.
Her kare yarış parkuru boyunca bir pozisyonu temsil eder.
Bitiş çizgisi 70. karededir.
70. kareye ulaşan veya geçen ilk yarışmacı bir kova taze havuç ve marulla ödüllendirilir.
Parkur kaygan bir dağın yamacından yukarı doğru kıvrılır, bu yüzden yarışmacılar ara sıra zemin kaybederler.
Bir saat saniyede bir kez tıklar.
Saatin her tıkında, uygulamanız hayvanların pozisyonunu aşağıdaki tabloda yer alan kurallara göre ayarlamalıdır.
Hayvanların pozisyonlarını takip etmek için değişkenler kullanın (yani, pozisyon numaraları 1-70'tir).
Her hayvanı 1. pozisyondan ("başlangıç kapısı") başlatın.
Bir hayvan 1. kareden önce sola kayarsa, onu 1. kareye geri taşıyın.

Animal	                          Move Type	             Percentage 	     Actual move
Tortoise(Kaplumbağa)  --->   Fast plod(Hızlı ilerleme)	    50%	   3 squares to the right(Sağa doğru 3 kare)
Tortoise(Kaplumbağa)  --->   Slip(Kayma)	                20%	   6 squares to the left(Sola doğru 6 kare)
Tortoise(Kaplumbağa)  --->   Slow plod(Yavaş ilerleme)	    30%	   1 squares to the right(Sağa doğru 1 kare)

Hare(tavşan)          --->   Sleep(Uyuma)	                20%	   No move at all(Hiçbir hareket yok)
Hare(tavşan)          --->   Big hop(Büyük sıçrama)	        20%	   9 squares to the right(Sağa doğru 9 kare)
Hare(tavşan)          --->   Big slip(Büyük kayma)	        10%	   12 squares to the left(Sola doğru 12 kare)
Hare(tavşan)          --->   Small hop(Küçük atlama)        30%	   1 squares to the right(Sağa doğru 1 kare)
Hare(tavşan)          --->   Small slip(Küçük kayma)        20%	   2 squares to the left(Sola doğru 2 kare)
 */


package HOMEWORK;

import java.util.Random;

public class TortoiseAndHare1 {
    public static void main(String[] args) {
        Random random = new Random();
        int tortoisePosition = 1;
        int harePosition = 1;
        int finishLine = 70;

        // Race start message
        System.out.println("The race has started!");

        while (tortoisePosition < finishLine && harePosition < finishLine) {
            // Tortoise movement
            int tortoiseMove = random.nextInt(100) + 1; // Random number between 1 and 100
            if (tortoiseMove <= 50) {
                tortoisePosition += 3; // Fast plod
            } else if (tortoiseMove <= 70) {
                tortoisePosition -= 6; // Slip
            } else {
                tortoisePosition += 1; // Slow plod
            }

            // Hare movement
            int hareMove = random.nextInt(100) + 1; // Random number between 1 and 100
            if (hareMove <= 20) {
                // Sleep, no movement
            } else if (hareMove <= 40) {
                harePosition += 9; // Big hop
            } else if (hareMove <= 50) {
                harePosition -= 12; // Big slip
            } else if (hareMove <= 80) {
                harePosition += 1; // Small hop
            } else {
                harePosition -= 2; // Small slip
            }

            // Ensure positions do not fall below 1
            if (tortoisePosition < 1) {
                tortoisePosition = 1;
            }
            if (harePosition < 1) {
                harePosition = 1;
            }

            // Print current positions
            System.out.println("Tortoise position: " + tortoisePosition + ", Hare position: " + harePosition);

            // Check if either has reached the finish line
            if (tortoisePosition >= finishLine || harePosition >= finishLine) {
                if (tortoisePosition >= finishLine && harePosition < finishLine) {
                    int difference = tortoisePosition - harePosition;
                    System.out.printf("The race is over and the tortoise won by %d squares ahead of the hare.\n", difference);
                    System.out.println("The tortoise is rewarded with a bucket of fresh carrots and lettuce!");
                } else if (harePosition >= finishLine && tortoisePosition < finishLine) {
                    int difference = harePosition - tortoisePosition;
                    System.out.printf("The race is over and the hare won by %d squares ahead of the tortoise.\n", difference);
                    System.out.println("The hare is rewarded with a bucket of fresh carrots and lettuce!");
                } else {
                    System.out.println("!The race is over and both animals reached the finish line at the same time");
                    System.out.println("Both the tortoise and the hare are rewarded with a bucket of fresh carrots and lettuce!");
                }
                break;
            }
            // Wait for 1 seconds
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
/*
The race has started!
Tortoise position: 4, Hare position: 1
Tortoise position: 5, Hare position: 10
Tortoise position: 8, Hare position: 10
Tortoise position: 11, Hare position: 10
Tortoise position: 14, Hare position: 19
Tortoise position: 17, Hare position: 17
.
.
.
Tortoise position: 42, Hare position: 63
Tortoise position: 43, Hare position: 61
Tortoise position: 44, Hare position: 62
Tortoise position: 38, Hare position: 62
Tortoise position: 39, Hare position: 63
Tortoise position: 42, Hare position: 72
The race is over and the hare won by 30 squares ahead of the tortoise.
The hare is rewarded with a bucket of fresh carrots and lettuce!

+--------------------+
|     Homework       |
+--------------------+
| - tortoisePosition: int |
| - harePosition: int     |
| - finishLine: int       |
+--------------------+
| + main(args: String[]): void |
+--------------------+
| - moveTortoise(): void |
| - moveHare(): void |
| - printRaceStatus(): void |
| - checkWinner(): void |
+--------------------+
 */