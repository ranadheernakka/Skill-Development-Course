import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import org.json.*;

public class StudentAPI extends HttpServlet {
    private Connection connectDB() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb", "root", "password");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        JSONArray studentsArray = new JSONArray();

        try (Connection con = connectDB()) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM students");

            while (rs.next()) {
                JSONObject student = new JSONObject();
                student.put("id", rs.getInt("id"));
                student.put("name", rs.getString("name"));
                student.put("email", rs.getString("email"));
                studentsArray.put(student);
            }
            out.print(studentsArray);
        } catch (Exception e) {
            out.print("{\"error\":\"" + e.getMessage() + "\"}");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        StringBuilder jb = new StringBuilder();
        String line;
        BufferedReader reader = request.getReader();
        while ((line = reader.readLine()) != null)
            jb.append(line);

        JSONObject json = new JSONObject(jb.toString());
        String name = json.getString("name");
        String email = json.getString("email");

        try (Connection con = connectDB()) {
            PreparedStatement ps = con.prepareStatement("INSERT INTO students (name, email) VALUES (?, ?)");
            ps.setString(1, name);
            ps.setString(2, email);
            ps.executeUpdate();
            response.getWriter().print("{\"message\":\"Student added successfully\"}");
        } catch (Exception e) {
            response.getWriter().print("{\"error\":\"" + e.getMessage() + "\"}");
        }
    }

    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        StringBuilder jb = new StringBuilder();
        String line;
        BufferedReader reader = request.getReader();
        while ((line = reader.readLine()) != null)
            jb.append(line);

        JSONObject json = new JSONObject(jb.toString());
        String name = json.getString("name");
        String email = json.getString("email");

        try (Connection con = connectDB()) {
            PreparedStatement ps = con.prepareStatement("UPDATE students SET name=?, email=? WHERE id=?");
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setInt(3, id);
            ps.executeUpdate();
            response.getWriter().print("{\"message\":\"Student updated successfully\"}");
        } catch (Exception e) {
            response.getWriter().print("{\"error\":\"" + e.getMessage() + "\"}");
        }
    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        try (Connection con = connectDB()) {
            PreparedStatement ps = con.prepareStatement("DELETE FROM students WHERE id=?");
            ps.setInt(1, id);
            ps.executeUpdate();
            response.getWriter().print("{\"message\":\"Student deleted successfully\"}");
        } catch (Exception e) {
            response.getWriter().print("{\"error\":\"" + e.getMessage() + "\"}");
        }
    }
}
