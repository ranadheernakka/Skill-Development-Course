package src;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ShoppingController")
public class ShoppingController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String action = request.getParameter("action");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shoppingcart", "root", "prakash");

            if ("register".equals(action)) {
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                PreparedStatement ps = con
                        .prepareStatement("INSERT INTO users (username, password, email) VALUES (?, ?, ?)");
                ps.setString(1, username);
                ps.setString(2, password);
                ps.setString(3, request.getParameter("email"));
                ps.executeUpdate();
                out.println("Registration Successful!");
            } else if ("login".equals(action)) {
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                PreparedStatement ps = con.prepareStatement("SELECT * FROM users WHERE username=? AND password=?");
                ps.setString(1, username);
                ps.setString(2, password);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    HttpSession session = request.getSession();
                    session.setAttribute("user", username);
                    out.println("Login Successful!");
                } else {
                    out.println("Invalid Credentials");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
