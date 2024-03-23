import java.util.Scanner;

public class App1 {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
 
        while (true) {
            System.out.println("-------------------------------------------------");
            System.out.println("|            Welcome to BookMyShow              |");
            System.out.println("-------------------------------------------------");
 
            System.out.println("Please select an option:");
            System.out.println("| 1. Vendor                                     |");
            System.out.println("| 2. Customer                                   |");
            System.out.println("| 3. Exit                                       |");
            System.out.println("-------------------------------------------------");
 
            int choice = scanner.nextInt();
 
            switch (choice) {
                case 1:
                    handleVendor();
                    break;
                case 2:
                    handleCustomer();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
 
    private static void handleVendor() {
        Scanner scanner = new Scanner(System.in);
 
        while (true) {
            System.out.println("-------------------------------------------------");
            System.out.println("|                Vendor Menu                    |");
            System.out.println("-------------------------------------------------");
 
            System.out.println("Please select an option:");
            System.out.println("| 1. Allocate movies and timings                |");
            System.out.println("| 2. Exit                                       |");
            System.out.println("-------------------------------------------------");
 
            int choice = scanner.nextInt();
 
            switch (choice) {
                case 1:
                    System.out.println("Allocating movies and timings...");
                    VendorMain.addSchedules(); 
                    break;
                case 2:
                    System.out.println("Exiting Vendor Menu...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
 
    private static void handleCustomer() {
        Scanner scanner = new Scanner(System.in);
 
        while (true) {
            System.out.println("-------------------------------------------------");
            System.out.println("|              Customer Menu                    |");
            System.out.println("-------------------------------------------------");
 
            System.out.println("Please select an option:");
            System.out.println("| 1. Book tickets                               |");
            System.out.println("| 2. Exit                                       |");
            System.out.println("-------------------------------------------------");
 
            int choice = scanner.nextInt();
 
            switch (choice) {
                case 1:
                    System.out.println("Booking tickets...");
                    MainApplication.bookTicket(); 
                    break;
                case 2:
                    System.out.println("Exiting Customer Menu...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
