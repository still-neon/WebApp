package webapplication;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        try {
            if (UserService.checkCredentials(request.getParameter("login"), request.getParameter("password"))) {
                getServletContext().getRequestDispatcher("/welcome_page.jsp").forward(request, response);
            }
            else {
                request.getRequestDispatcher("login_page.html");
                //rd.include(request,response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}