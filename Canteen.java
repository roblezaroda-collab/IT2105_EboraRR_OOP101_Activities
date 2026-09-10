import java.util.Scanner;

public class Canteen {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        final double BURGER_PRICE = 80.00;
        final double PIZZA_PRICE = 120.00;
        final double PASTA_PRICE = 100.00;
        final double SANDWICH_PRICE = 70.00;
        final double MILK_TEA_PRICE = 90.00;

        int totalItems = 0;
        double totalBeforeDiscount = 0;
        double totalDiscount = 0;
        double finalAmount = 0;

        char orderAgain = 'Y';

        System.out.println("===== MENU =====");
        System.out.println("1. Burger    - $80.00");
        System.out.println("2. Pizza     - $120.00");
        System.out.println("3. Pasta     - $100.00");
        System.out.println("4. Sandwich  - $70.00");
        System.out.println("5. Milk Tea  - $90.00");

        do {
            int itemNumber;
            int quantity;

            while (true) {
                System.out.print("\nEnter item number: ");
                itemNumber = input.nextInt();

                System.out.print("Enter quantity: ");
                quantity = input.nextInt();

                if (itemNumber >= 1 && itemNumber <= 5 && quantity >= 1 && quantity <= 10) {
                    break;
                }

                System.out.println("\nInvalid order! Please enter a valid item and quantity.");
                System.out.print("Do you want to order again? (Y/N): ");
                orderAgain = input.next().toUpperCase().charAt(0);

                if (orderAgain != 'Y') {
                    System.out.println("\n===== ORDER SUMMARY =====");
                    System.out.println("Total items: " + totalItems);
                    System.out.printf("Total before discount: $%.2f%n", totalBeforeDiscount);
                    System.out.printf("Total discount: $%.2f%n", totalDiscount);
                    System.out.printf("Final amount: $%.2f%n", finalAmount);
                    System.out.println("Thank you for ordering!");
                    input.close();
                    return;
                }
            }

            double price = 0;

            switch (itemNumber) {
                case 1:
                    price = BURGER_PRICE;
                    break;
                case 2:
                    price = PIZZA_PRICE;
                    break;
                case 3:
                    price = PASTA_PRICE;
                    break;
                case 4:
                    price = SANDWICH_PRICE;
                    break;
                case 5:
                    price = MILK_TEA_PRICE;
                    break;
                default:
                    break;
            }

            char isStudent;
            while (true) {
                System.out.print("Are you a student? (Y/N): ");
                isStudent = input.next().toUpperCase().charAt(0);

                if (isStudent == 'Y' || isStudent == 'N') {
                    break;
                }

                System.out.println("Please enter Y or N.");
            }

            double subtotal = price * quantity;
            double discountRate;

            if (isStudent == 'Y' && subtotal >= 500) {
                discountRate = 0.15;
            } else if (isStudent == 'Y') {
                discountRate = 0.10;
            } else if (subtotal >= 500) {
                discountRate = 0.05;
            } else {
                discountRate = 0;
            }

            double discount = subtotal * discountRate;
            double orderTotal = subtotal - discount;

            System.out.printf("\nSubtotal: $%.2f%n", subtotal);
            System.out.printf("Discount: $%.2f%n", discount);
            System.out.printf("Order total: $%.2f%n", orderTotal);

            totalItems += quantity;
            totalBeforeDiscount += subtotal;
            totalDiscount += discount;
            finalAmount += orderTotal;

            System.out.print("\nDo you want to order again? (Y/N): ");
            orderAgain = input.next().toUpperCase().charAt(0);

        } while (orderAgain == 'Y');

        System.out.println("\n===== ORDER SUMMARY =====");
        System.out.println("Total items: " + totalItems);
        System.out.printf("Total before discount: $%.2f%n", totalBeforeDiscount);
        System.out.printf("Total discount: $%.2f%n", totalDiscount);
        System.out.printf("Final amount: $%.2f%n", finalAmount);

        System.out.println("Thank you for ordering!");

        input.close();
    }
}