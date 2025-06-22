import java.sql.*;
import java.util.Scanner;

public class Main {

    // JDBC URL, username and password of MySQL server
    static final String JDBC_URL = "jdbc:mysql://localhost:3306/shoppingdb";
    static final String USER = "root"; // your MySQL username
    static final String PASSWORD = "prakash"; // your MySQL password

    // Connection object
    static Connection conn = null;

    public static void main(String[] args) {
        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
            conn = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);

            Scanner scanner = new Scanner(System.in);
            int choice;

            do {
                System.out.println("\n--- Product Management ---");
                System.out.println("1. Add Product");
                System.out.println("2. View All Products");
                System.out.println("3. Update Product");
                System.out.println("4. Delete Product");
                System.out.println("5. Exit");
                System.out.print("Enter choice: ");
                choice = scanner.nextInt();
                scanner.nextLine(); // consume newline

                switch (choice) {
                    case 1:
                        addProduct(scanner);
                        break;
                    case 2:
                        viewProducts();
                        break;
                    case 3:
                        updateProduct(scanner);
                        break;
                    case 4:
                        deleteProduct(scanner);
                        break;
                    case 5:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice!");
                }
            } while (choice != 5);

            scanner.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void addProduct(Scanner scanner) throws SQLException {
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();

        System.out.print("Enter price: ");
        double price = scanner.nextDouble();

        System.out.print("Enter quantity: ");
        int qty = scanner.nextInt();
        scanner.nextLine(); // consume newline

        String sql = "INSERT INTO products (name, price, quantity) VALUES (?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, name);
        pstmt.setDouble(2, price);
        pstmt.setInt(3, qty);

        int rows = pstmt.executeUpdate();
        if (rows > 0) {
            System.out.println("Product added successfully!");
        }
    }

    static void viewProducts() throws SQLException {
        String sql = "SELECT * FROM products";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        System.out.println("\nID | Name | Price | Quantity");
        while (rs.next()) {
            System.out.printf("%d | %s | %.2f | %d\n",
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getDouble("price"),
                    rs.getInt("quantity"));
        }
    }

    static void updateProduct(Scanner scanner) throws SQLException {
        System.out.print("Enter product ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter new name: ");
        String name = scanner.nextLine();

        System.out.print("Enter new price: ");
        double price = scanner.nextDouble();

        System.out.print("Enter new quantity: ");
        int qty = scanner.nextInt();
        scanner.nextLine();

        String sql = "UPDATE products SET name = ?, price = ?, quantity = ? WHERE id = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, name);
        pstmt.setDouble(2, price);
        pstmt.setInt(3, qty);
        pstmt.setInt(4, id);

        int rows = pstmt.executeUpdate();
        if (rows > 0) {
            System.out.println("Product updated successfully!");
        } else {
            System.out.println("Product not found.");
        }
    }

    static void deleteProduct(Scanner scanner) throws SQLException {
        System.out.print("Enter product ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        String sql = "DELETE FROM products WHERE id = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, id);

        int rows = pstmt.executeUpdate();
        if (rows > 0) {
            System.out.println("Product deleted successfully!");
        } else {
            System.out.println("Product not found.");
        }
    }
}
