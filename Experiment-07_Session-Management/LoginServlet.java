package Program-7;

public class LoginServlet {

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        HttpSession session = request.getSession(); // Start Session
        session.setAttribute("username", username); // Store Username in Session
        // Create Cookie to store username
        Cookie userCookie = new Cookie("user", username);
        userCookie.setMaxAge(60 * 60); // Cookie expires in 1 hour
        response.addCookie(userCookie);
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        out.println("<h3>Welcome, " + username + "</h3>");
        out.println("<a href='TransactionServlet'>View Transaction History</a>");
    }
}

}
