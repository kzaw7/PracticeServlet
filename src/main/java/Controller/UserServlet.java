package Controller;

import Model.User;
import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Services.UserService;
import java.io.IOException;
import java.io.PrintWriter;

public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    static UserService userService = new UserService();

    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getParameter("action");

        if ("update".equalsIgnoreCase(action)) {

            updateUser(request, response);
            response.sendRedirect("user-profile.html");
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }
    public static void updateUser(HttpServletRequest request, HttpServletResponse response) {
        String username = (String) request.getParameter("uname");
        String password = (String) request.getParameter("psw");

        User user = (User) request.getSession().getAttribute("user");
        user.setUserName(username);
        user.setPassword(password);

        userService.updateUser(user);

    }
}