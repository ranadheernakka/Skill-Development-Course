package servlets;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ProductServlet extends HttpServlet {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/shoppingdb";
    private static final String USER = "root";
    private static final String PASSWORD = "prakash";

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM products");

            out.println("<h2>Product Catalog</h2>");
            out.println("<ul>");
            while (rs.next()) {
                out.println("<li>" + rs.getString("name") + " - ₹" + rs.getDouble("price") + "</li>");
            }
            out.println("</ul>");

            conn.close();

        } catch (Exception e) {
            out.println("<p>Error: " + e.getMessage() + "</p>");
        }
    }
}
