package servlets;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ProductServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // DB connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/shopping_cart", "root", "yourpassword");

            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM products");

            out.println("<html><body><h2>Product Catalog</h2><ul>");
            while (rs.next()) {
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                out.println("<li>" + escapeHtml(name) + " - $" + price + "</li>");
            }
            out.println("</ul></body></html>");

        } catch (Exception e) {
            out.println(
                    "<html><body><h2>Error</h2><p>Unable to retrieve product information. Please try again later.</p></body></html>");
            e.printStackTrace(); // Log the error for debugging
        } finally {
            // Close resources
            try {
                if (rs != null)
                    rs.close();
                if (stmt != null)
                    stmt.close();
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace(); // Log the error for debugging
            }
        }
    }

    private String escapeHtml(String str) {
        if (str == null)
            return null;
        return str.replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("\"", "&quot;")
                .replace("'", "&#39;");
    }
}
