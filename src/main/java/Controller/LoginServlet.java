package Controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {

    private String EmpId;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("submit_request.html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("EmpId");
        String password = request.getParameter("pass");
        out.println("Welcome " + EmpId);



    }
}
