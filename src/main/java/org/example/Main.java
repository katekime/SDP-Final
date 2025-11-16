package org.example;
import org.example.facade.RestaurantFacade;
import org.example.factory.Order;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static RestaurantFacade restaurant = new RestaurantFacade();

    public static void main(String[] args) {
        System.out.println("RESTAURANT ORDERING SYSTEM");
        System.out.println("Welcome to Our Restaurant");
        boolean continueOrdering = true;
        while (continueOrdering) {
            try {
                Order order = createOrderInteractive();
                addItemsInteractive(order);
                restaurant.displayOrderSummary(order);
                boolean includeServiceFee = askForServiceFee();
                processPaymentInteractive(order, includeServiceFee);
                restaurant.updateOrderStatus(order, "Preparing");
                restaurant.updateOrderStatus(order, "Ready");
                restaurant.updateOrderStatus(order, "Served");
                System.out.println("Order #" + order.getOrderId() + " completed successfully!");
                System.out.print("\nWould you like to make another order? (yes/no): ");
                String response = scanner.nextLine().trim().toLowerCase();
                continueOrdering = response.equals("yes") || response.equals("y");

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                System.out.println("Let's try again...");
            }
        }
        System.out.println("Thank you for visiting our restaurant");
        System.out.println("Have a great day");
        scanner.close();
    }
    private static Order createOrderInteractive() {
        System.out.println("NEW ORDER");
        System.out.println("1. Dine-in (Inside restaurant)");
        System.out.println("2. Take-away");
        System.out.print("Select order type 1-2: ");
        int choice = getIntInput(1, 2);
        String orderType = (choice == 1) ? "inside" : "takeaway";
        return restaurant.createOrder(orderType);
    }
    private static void addItemsInteractive(Order order) {
        boolean addingItems = true;
        while (addingItems) {
            System.out.println("ADD ITEMS");
            System.out.println("1. Add full cuisine set (Appetizer + Main + Drink + Dessert)");
            System.out.println("2. Add individual item");
            System.out.println("3. Finish adding items");
            System.out.print("Select option 1-3: ");
            int choice = getIntInput(1, 3);
            switch (choice) {
                case 1:
                    addCuisineSetInteractive(order);
                    break;
                case 2:
                    addIndividualItemInteractive(order);
                    break;
                case 3:
                    addingItems = false;
                    break;
            }
        }
    }
    private static void addCuisineSetInteractive(Order order) {
        System.out.println("Select Cuisine");
        System.out.println("1. Japanese Cuisine");
        System.out.println("2. Kazakh Cuisine");
        System.out.print("Select cuisine 1-2: ");
        int choice = getIntInput(1, 2);
        String cuisineType = (choice == 1) ? "japanese" : "kazakh";
        restaurant.addCuisineSet(order, cuisineType);
        System.out.println("Full " + cuisineType + " set added!");
    }
    private static void addIndividualItemInteractive(Order order) {
        System.out.println("Select Cuisine");
        System.out.println("1. Japanese");
        System.out.println("2. Kazakh");
        System.out.print("Select cuisine 1-2: ");
        int cuisineChoice = getIntInput(1, 2);
        String cuisineType = (cuisineChoice == 1) ? "japanese" : "kazakh";
        System.out.println("Select Item Type");
        System.out.println("1. Appetizer");
        System.out.println("2. Main Course");
        System.out.println("3. Drink");
        System.out.println("4. Dessert");
        System.out.print("Select item type 1-4: ");
        int itemChoice = getIntInput(1, 4);
        String itemType = "";
        switch (itemChoice) {
            case 1:
                itemType = "appetizer";
                break;
            case 2:
                itemType = "maincourse";
                break;
            case 3:
                itemType = "drink";
                break;
            case 4:
                itemType = "dessert";
                break;
        }
        System.out.print("Would you like to add extra topping/decoration? yes/no: ");
        String addDecorator = scanner.nextLine().trim().toLowerCase();
        String decorator = null;
        if (addDecorator.equals("yes") || addDecorator.equals("y")) {
            decorator = selectDecoratorInteractive(cuisineType);
        }
        restaurant.addCustomItem(order, cuisineType, itemType, decorator);
        System.out.println("✓ Item added to order!");
    }
    private static String selectDecoratorInteractive(String cuisineType) {
        System.out.println("Select Decoration");
        if (cuisineType.equals("japanese")) {
            System.out.println("1. Wasabi (spicy)");
            System.out.println("2. Lemon");
            System.out.println("3. Custom decoration (enter your own)");
            System.out.print("Select decoration (1-3): ");
            int choice = getIntInput(1, 3);
            switch (choice) {
                case 1:
                    return "wasabi";
                case 2:
                    return "lemon";
                case 3:
                    System.out.print("Enter your custom decoration: ");
                    String customDeco = scanner.nextLine().trim();
                    return customDeco.isEmpty() ? null : customDeco;
            }
        } else {
            System.out.println("1. Sorpa");
            System.out.println("2. Lemon");
            System.out.println("3. Custom decoration");
            System.out.print("Select decoration 1-3: ");
            int choice = getIntInput(1, 3);
            switch (choice) {
                case 1:
                    System.out.print("Enter type of sorpa (e.g., beef, lamb): ");
                    String sorpaType = scanner.nextLine().trim();
                    return "sorpa";
                case 2:
                    return "lemon";
                case 3:
                    System.out.print("Enter your custom decoration: ");
                    String customDeco = scanner.nextLine().trim();
                    return customDeco.isEmpty() ? null : customDeco;
            }
        }
        return null;
    }
    private static boolean askForServiceFee() {
        System.out.print("Include 10% service fee? yes/no: ");
        String response = scanner.nextLine().trim().toLowerCase();
        return response.equals("yes") || response.equals("y");
    }
    private static void processPaymentInteractive(Order order, boolean includeServiceFee) {
        System.out.println("PAYMENT");
        System.out.println("1. Credit Card ");
        System.out.println("2. Cash ");
        System.out.println("3. Kaspi Alaqan ️");
        System.out.print("Select payment method 1-3: ");
        int paymentChoice = getIntInput(1, 3);
        String paymentMethod = "";
        switch (paymentChoice) {
            case 1:
                paymentMethod = "card";
                break;
            case 2:
                paymentMethod = "cash";
                break;
            case 3:
                paymentMethod = "kaspi";
                break;
        }
        System.out.println("Select Currency");
        System.out.println("1. USD");
        System.out.println("2. KZT");
        System.out.println("3. JPY");
        System.out.println("4. RUB");
        System.out.print("Select currency 1-4: ");
        int currencyChoice = getIntInput(1, 4);
        String currency = "";
        switch (currencyChoice) {
            case 1:
                currency = "USD";
                break;
            case 2:
                currency = "KZT";
                break;
            case 3:
                currency = "JPY";
                break;
            case 4:
                currency = "RUB";
                break;
        }
        restaurant.processPayment(order, paymentMethod, currency, includeServiceFee);
    }
    private static int getIntInput(int min, int max) {
        while (true) {
            try {
                String input = scanner.nextLine().trim();
                int choice = Integer.parseInt(input);

                if (choice >= min && choice <= max) {
                    return choice;
                } else {
                    System.out.print("Invalid input. Please enter a number between " + min + " and " + max + ": ");
                }
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a number: ");
            }
        }
    }
}
