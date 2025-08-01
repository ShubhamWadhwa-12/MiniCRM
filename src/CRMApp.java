import java.io.IOException;
import java.util.*;

public class CRMApp {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        CustomerManager manager = new CustomerManager();

        while (true) {
            System.out.println("\n--- CRM MENU ---");
            System.out.println("1. Add Customer");
            System.out.println("2. View All Customers");
            System.out.println("3. Search Customer by ID");
            System.out.println("4. Update Customer");
            System.out.println("5. Delete Customer");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {
                case 1:
                    System.out.print("ID: ");
                    int id = sc.nextInt(); sc.nextLine();
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();
                    System.out.print("Phone: ");
                    String phone = sc.nextLine();
                    manager.addCustomer(new Customer(id, name, email, phone));
                    System.out.println("Customer added.");
                    break;

                case 2:
                    for (Customer c : manager.getAllCustomers()) {
                        System.out.println(c.getId() + " | " + c.getName() + " | " + c.getEmail() + " | " + c.getPhone());
                    }
                    break;

                case 3:
                    System.out.print("Enter ID: ");
                    Customer c = manager.getCustomerById(sc.nextInt());
                    if (c != null)
                        System.out.println(c.getId() + " | " + c.getName() + " | " + c.getEmail() + " | " + c.getPhone());
                    else
                        System.out.println("Customer not found.");
                    break;

                case 4:
                    System.out.print("Enter ID to update: ");
                    int updateId = sc.nextInt(); sc.nextLine();
                    Customer existing = manager.getCustomerById(updateId);
                    if (existing != null) {
                        System.out.print("New Name: ");
                        existing.setName(sc.nextLine());
                        System.out.print("New Email: ");
                        existing.setEmail(sc.nextLine());
                        System.out.print("New Phone: ");
                        existing.setPhone(sc.nextLine());
                        manager.updateCustomer(existing);
                        System.out.println("Customer updated.");
                    } else {
                        System.out.println("Customer not found.");
                    }
                    break;

                case 5:
                    System.out.print("Enter ID to delete: ");
                    manager.deleteCustomer(sc.nextInt());
                    System.out.println("Customer deleted.");
                    break;

                case 0:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}