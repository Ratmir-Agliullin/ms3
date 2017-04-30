package main.servlets;

import main.servlets.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by admin on 22.04.2017.
 */
//@Component
@Controller
public class allUsersServlet{
    private UserService userService;
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }


    @RequestMapping(value = "allUsers",method = RequestMethod.GET)
    public ModelAndView getLoginAndPass(){
        ModelAndView mav = new ModelAndView();


        mav.addObject("users",userService.SelectUsersFromTable());
        mav.setViewName("allUsers");
        return mav;
    }

//    @Override
//    public void init(ServletConfig config) throws ServletException {
//        super.init(config);
//        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this,
//                config.getServletContext());
//    }
//
//    @Override
//    /**
//     * See all users list
//     */
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//    //    UsersDAO usersDAO = new UsersDAO();
//      //  UserService userService = new UserService();
//        req.setAttribute("users",userService.SelectUsersFromTable());
//        getServletContext().getRequestDispatcher("/allUsers.jsp").forward(req,resp);
//    }
//
//    @Override
//    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//    }
}
