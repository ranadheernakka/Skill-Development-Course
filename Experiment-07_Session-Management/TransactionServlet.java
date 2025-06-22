package Program7; // ✅ Fixed package name (no hyphens)

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class TransactionServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        String username = (String) session.getAttribute("username");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        if (username == null) {
            out.println("<h3>No active session. Please <a href='index.html'>login</a> again.</h3>");
            return;
        }

        try {
            // Change DB name, user, password as per your setup
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "root", "password");

            String query = "SELECT * FROM transactions WHERE username=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();

            out.println("<h2>Transaction History for " + username + "</h2>");
            while (rs.next()) {
                out.println("<p>Transaction: " + rs.getString("details") + "</p>");
            }

            con.close();
        } catch (Exception e) {
            out.println("<h3>Error: " + e.getMessage() + "</h3>");
        }
    }
}
