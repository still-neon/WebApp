package webapplication;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            UserService.AuthenticationState state = UserService.authenticate(request.getParameter("login"), request.getParameter("password"));
            if(state.accessGranted) {
                getServletContext().getRequestDispatcher("/welcome_page.jsp").forward(request, response);
            } else {
                out.print(state.messageText);
                request.getRequestDispatcher("login_page.html").include(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}