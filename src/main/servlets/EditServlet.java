package main.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by admin on 21.04.2017.
 */

public class EditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        req.setAttribute("list", "wdvvevev");
       // req.getRequestDispatcher("/edit.jsp").forward(req,resp);
      //  req.getRequestDispatcher("/edit.jsp").forward(req,resp);
      resp.sendRedirect("/edit.jsp");


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // resp.sendRedirect("/edit.jsp");
        req.setAttribute("list", "wdvsdvavevvevev");
     //   req.getRequestDispatcher("/edit.jsp").forward(req,resp);
        //req.getRequestDispatcher("/edit.jsp").forward(req,resp);
        resp.sendRedirect("/edit.jsp");

    }
}
