package webapplication;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("start");
        String username = (String) request.getParameter("username");
        String password = (String) request.getParameter("password");



        try {
            if(new LoginDAOImpl().checkCredentials(username).equals(password)) {
                System.out.println("login");
                getServletContext().getRequestDispatcher("/welcome_page.jsp").forward(request, response);
            } else {
                getServletContext().getRequestDispatcher("/login_page.html");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}