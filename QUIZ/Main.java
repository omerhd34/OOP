/* Trendyol benzeri e-ticaret senaryosu : E-ticaret platformu için basit bir ürün yönetim sistemi
Bir e-ticaret platformu için basit bir ürün yönetim sistemi oluşturun. Aşağıdaki görevleri tamamlayın:
Şirketin yalnızca akıllı saat olan bir teknolojik ürün sattığını varsayalım. Bir müşteri teknolojik ürünlerden 10 akıllı saat alır.
Her akıllı saat fiyatı 87,55 dolardır. Kullanıcıdan ürün adı ve miktarı gibi ürün bilgileri için girdiler alın.
Müşterinin ödemesi gereken toplam tutarı hesaplayın ve bir yöntem oluşturarak ekrana yazdırın. Müşteri bu son fiyatı onaylarsa,
kullanıcıdan IBAN numarasını, adresi isteyin ve bir yöntem oluşturarak ürünü gönderin.

Product Sınıfı: Kullanıcıdan ürün adını ve ürün miktarını girdi olarak alan bir Product sınıfı oluşturun. Bu nedenle, ürün bilgilerini depolar ve ürünle ilgili işlemleri yönetir.
Ve ürün bilgilerini görüntülemelidir….vb. gerekirse diğer yöntemleri burada oluşturabilirsiniz.
displayProductInfo():   Ürün bilgilerini görüntüler.

ShoppingBasket Sınıfı: E-Ticaret Alışveriş Sepeti sınıfı, kullanıcının alacağı ürünleri yönetir, örneğin ödeme sürecini tamamlar, ürünü stoktan çıkarır ve ekranda tutarını görüntüler.
Ayrıca stok azaltma işlemlerini de gerçekleştirir. ….vb. gerekirse diğer yöntemler, burada oluşturabilirsiniz.
reduceStock(int amount):    Stok miktarını azaltır ve yeterli stok yoksa bir mesaj döndürür.

Main Class: Kullanıcıdan veri alır, ilişkili nesneleri oluşturur ve alışverişi gerçekleştirir. …vb. gerekirse başka metodları da burada oluşturabilirsiniz.

Notlar: IBAN'ın 16 haneli sayılardan oluştuğunu ve ödeme işleminin herhangi bir hata olmadan başarıyla tamamlandığını varsayalım. Diğer her şeyi dilediğiniz gibi kabul edebilirsiniz.
 */

package QUIZ;

import java.util.Scanner;

// Product class to store product information and handle display
class Product {
    private String productName;
    private int quantity;
    private static final double PRICE_PER_WATCH = 87.55;

    public Product(String productName, int quantity) {
        this.productName = productName;
        this.quantity = quantity;
    }

    public void displayProductInfo() {
        System.out.println("Product: " + productName);
        System.out.println("Quantity: " + quantity);
        System.out.println("Price per item: $" + PRICE_PER_WATCH);
        System.out.println("Total Price: $" + calculateTotalPrice());
    }

    public double calculateTotalPrice() {
        return quantity * PRICE_PER_WATCH;
    }

    public int getQuantity() {
        return quantity;
    }
}

// ShoppingBasket class to handle stock and transactions
class ShoppingBasket {
    private int stock;

    public ShoppingBasket(int stock) {
        this.stock = stock;
    }

    public void reduceStock(int quantity) {
        if (quantity > stock) {
            System.out.println("Insufficient stock available!");
        } else {
            stock -= quantity;
            System.out.println("Stock reduced by " + quantity + ". Remaining stock: " + stock);
        }
    }

    public boolean processPayment(String iban) {
        if (iban.length() == 16 && iban.matches("\\d+")) {
            System.out.println("Payment completed successfully. IBAN: " + iban);
            return true;
        } else {
            System.out.println("Invalid IBAN. Transaction failed.");
            return false;
        }
    }

    public int getStock() {
        return stock;
    }
}

// Main class to handle the shopping process
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create an instance of ShoppingBasket with a stock of 10 smartwatches
        ShoppingBasket basket = new ShoppingBasket(10);

        // Input product information
        System.out.print("Enter product name: ");
        String productName = scanner.nextLine();

        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        // Create product instance
        Product product = new Product(productName, quantity);

        // Display product information
        product.displayProductInfo();

        // Ensure stock is available
        if (quantity > basket.getStock()) {
            System.out.println("Not enough stock to fulfill this order.");
        } else {
            // Process IBAN and address
            System.out.print("Enter your IBAN (16 digits): ");
            String iban = scanner.nextLine();

            System.out.print("Enter your shipping address: ");
            String address = scanner.nextLine();

            // Process payment
            if (basket.processPayment(iban)) {
                System.out.println("Order confirmed! Shipping to: " + address);
                basket.reduceStock(quantity);
            }
        }

        scanner.close();
    }
}
/*
Enter product name: Trendyol
Enter quantity: 5
Product: Trendyol
Quantity: 5
Price per item: $87.55
Total Price: $437.75
Enter your IBAN (16 digits): 1234567891234567
Enter your shipping address: Bostancı
Payment completed successfully. IBAN: 1234567891234567
Order confirmed! Shipping to: Bostancı
Stock reduced by 5. Remaining stock: 5


UML :

--------------------------------------------
|               Product                    |
--------------------------------------------
| - productName: String                    |
| - quantity: int                          |
| + PRICE_PER_WATCH: double                |
--------------------------------------------
| + Product(productName: String, quantity: int) |
| + displayProductInfo(): void             |
| + calculateTotalPrice(): double          |
| + getQuantity(): int                     |
--------------------------------------------

                   |
                   |
                 contains
                   |
                   v
--------------------------------------------
|             ShoppingBasket               |
--------------------------------------------
| - stock: int                             |
--------------------------------------------
| + ShoppingBasket(stock: int)             |
| + reduceStock(quantity: int): void       |
| + processPayment(iban: String): boolean  |
| + getStock(): int                        |
--------------------------------------------

                   |
                   |
                manages
                   |
                   v
--------------------------------------------
|                  Main                    |
--------------------------------------------
| + main(String[] args): void              |
--------------------------------------------
 */