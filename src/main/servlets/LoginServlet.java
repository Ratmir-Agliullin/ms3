package main.servlets;

import main.models.pojo.LoginEntity;
import main.servlets.services.AdminService;
import main.servlets.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by admin on 20.04.2017.
 */
//@Component
@Controller
public class LoginServlet extends HttpServlet {


    private UserService userService;
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }


    private AdminService adminService;

    @Autowired
    public void setAdminService(AdminService adminService) {
        this.adminService = adminService;
    }


    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public ModelAndView getLoginAndPass(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("user", new LoginEntity());
        mav.setViewName("login");
        return mav;
    }


    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String checkLAP(@ModelAttribute("user") LoginEntity loginEntity,HttpServletRequest req){
        ModelAndView mav = new ModelAndView();
        String checkUserAdmin = "Не авторизованный пользователь. Авторизуйтесь!";
        String afterAuthURL = "redirect:newUserAdd";
        if (userService.UserAuthCheck(loginEntity.getUsername(),loginEntity.getPassword())){
            checkUserAdmin = "Пользователь";
            afterAuthURL = "redirect:userInfo";
          //  mav.addObject("check", loginEntity);
            mav.setViewName("userInfo");
        req.getSession().setAttribute("check1", loginEntity);
            req.getSession().setAttribute("check", checkUserAdmin);
        } else

        if (adminService.AdminAuthCheck(loginEntity.getUsername(),loginEntity.getPassword())) {
            checkUserAdmin = "Администратор";
            afterAuthURL = "redirect:allUsers";
            mav.setViewName("allUsers");
            req.getSession().setAttribute("check", checkUserAdmin);
        } else

        if(userService.UserLoginRepeatCheck(loginEntity.getUsername())==true) {
            afterAuthURL = "redirect:repeatLoginUser";
            checkUserAdmin = "неверный";
            mav.setViewName("repeatLoginUser");
            req.getSession().setAttribute("check", checkUserAdmin);
        }
        return afterAuthURL;
        }

//
//
//    @Override
//    public void init(ServletConfig config) throws ServletException {
//        super.init(config);
//        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this,
//                config.getServletContext());
//    }
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.getSession().invalidate();
//       req.getRequestDispatcher("/login.jsp").forward(req,resp);
//
//
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String pass = req.getParameter("password");
//        String login = req.getParameter("username");
//
//      //  UserService userService = new UserService();
//     //   AdminService adminService = new AdminService(adminDAO);
//        String checkUserAdmin = "Не авторизованный пользователь. Авторизуйтесь!";
//        String afterAuthURL = "/newUserAdd";
//        if (userService.UserAuthCheck(login,pass)){
//            checkUserAdmin = "Пользователь";
//            afterAuthURL = "/userInfo";
//            req.getSession().setAttribute("check", checkUserAdmin);
//            resp.sendRedirect(req.getContextPath() + afterAuthURL);
//        };
//        if (adminService.AdminAuthCheck(login,pass)) {
//            checkUserAdmin = "Администратор";
//            afterAuthURL = "/allUsers";
//            req.getSession().setAttribute("check", checkUserAdmin);
//            resp.sendRedirect(req.getContextPath() + afterAuthURL);
//        } ;
//        if(userService.UserLoginRepeatCheck(login)==true) {
//            //req.getSession().setAttribute("check", "Ваш логин уже есть в списке пользователей. Выберете другой логин");
//            afterAuthURL = "/repeatLoginUser";
//            checkUserAdmin = "неверный";
//
//
//            req.getSession().setAttribute("check", checkUserAdmin);
//            resp.sendRedirect(req.getContextPath() + afterAuthURL);
//        }
//    }
}
