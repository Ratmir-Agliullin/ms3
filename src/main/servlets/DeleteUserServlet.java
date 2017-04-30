package main.servlets;

import main.servlets.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by admin on 22.04.2017.
 */
@Controller
public class DeleteUserServlet {
    private UserService userService;
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }



    @RequestMapping(value = "deleteUser",method = RequestMethod.GET )
    public String getLoginAndPass(@RequestParam int id){
        ModelAndView mav = new ModelAndView();


        userService.DeleteUsers(id);
        mav.setViewName("deleteUser");
        return "redirect:allUsers";
    }


//    @Override
//    public void init(ServletConfig config) throws ServletException {
//        super.init(config);
//        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this,
//                config.getServletContext());
//    }
//    @Override
///**
// *
// * Delete users
// */
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//     String[] id =    req.getParameterValues("value");
//        req.setAttribute("id",id[0]);
//
//        int delete_id = Integer.parseInt(id[0]);

//        userService.DeleteUsers(delete_id);
//        getServletContext().getRequestDispatcher("/allUsers.jsp").forward(req,resp);
//    }
//
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//    }
}
