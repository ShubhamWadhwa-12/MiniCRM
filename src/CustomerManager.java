import java.io.*;
import java.util.*;

public class CustomerManager {
    private static final String FILE_NAME = "customers.txt";

    public void addCustomer(Customer customer) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(customer.toString());
            writer.newLine();
        }
    }

    public List<Customer> getAllCustomers() throws IOException {
        List<Customer> customers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                customers.add(Customer.fromString(line));
            }
        }
        return customers;
    }

    public Customer getCustomerById(int id) throws IOException {
        for (Customer c : getAllCustomers()) {
            if (c.getId() == id) return c;
        }
        return null;
    }

    public void updateCustomer(Customer updatedCustomer) throws IOException {
        List<Customer> customers = getAllCustomers();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Customer c : customers) {
                if (c.getId() == updatedCustomer.getId()) {
                    writer.write(updatedCustomer.toString());
                } else {
                    writer.write(c.toString());
                }
                writer.newLine();
            }
        }
    }

    public void deleteCustomer(int id) throws IOException {
        List<Customer> customers = getAllCustomers();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Customer c : customers) {
                if (c.getId() != id) {
                    writer.write(c.toString());
                    writer.newLine();
                }
            }
        }
    }
}

