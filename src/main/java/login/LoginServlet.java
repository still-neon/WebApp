package login;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
    private Map<String,String> creds = new HashMap<String,String>();


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        creds.put("login","password");
        String username = (String) request.getParameter("username");
        String password = (String) request.getParameter("password");
        creds.get(username);


        if(creds.get(username).equals(password)) {
            getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
        } else {
            getServletContext().getRequestDispatcher("/index.html");
        }


    }
}