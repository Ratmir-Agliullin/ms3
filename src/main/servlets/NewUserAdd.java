package main.servlets;

import main.models.pojo.LoginEntity;
import main.models.pojo.Users;
import main.servlets.services.UserService;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by admin on 23.04.2017.
 */
//@Component
@Controller
public class NewUserAdd extends HttpServlet{
    private UserService userService;
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }



    @RequestMapping(value = "/newUserAdd",method = RequestMethod.GET)
    public ModelAndView getLoginAndPass(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("user", new LoginEntity());
        mav.setViewName("newUserAdd");
        return mav;
    }


    @RequestMapping(value = "/newUserAdd",method = RequestMethod.POST)
    public String checkLAP(@ModelAttribute("user") LoginEntity loginEntity, HttpServletRequest req){
        ModelAndView mav = new ModelAndView();
        String pass = BCrypt.hashpw(loginEntity.getPassword(), BCrypt.gensalt());
        Users users = new Users();
      users.setUserName(loginEntity.getUsername());
      users.setPassName(pass);
      String nextPath = null;
        if(userService.UserLoginRepeatCheck(loginEntity.getUsername())==false) {
            userService.InsertInTable(users);
            req.getSession().setAttribute("newuser", "Новый пользователь: " + loginEntity.getUsername() + " успешно добавлен");
            nextPath = "redirect:newUserAdded";
        }
        else {
            req.getSession().setAttribute("check", "Ваш логин уже есть в списке пользователей. Выберете другой логин");

            nextPath = "repeatLoginUser";
        }

return nextPath;

    }


//    @Override
//    public void init(ServletConfig config) throws ServletException {
//        super.init(config);
//        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this,
//                config.getServletContext());
//    }
//
//    /**
//     * Create new user
//     * @param req
//     * @param resp
//     * @throws ServletException
//     * @throws IOException
//     */
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.getRequestDispatcher("/newUserAdd.jsp").forward(req,resp);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        UsersDAO usersDAO = new UsersDAO();
//        String pass1 = req.getParameter("password");
//        String pass = BCrypt.hashpw(pass1, BCrypt.gensalt());
//        String login = req.getParameter("username");
//        Users users = new Users();
//        users.setUserName(login);
//        users.setPassName(pass);
//       // UserService userService = new UserService();
//        if(userService.UserLoginRepeatCheck(login)==false) {
//        userService.InsertInTable(users);
//        req.getSession().setAttribute("newuser", "Новый пользователь: "+ login+" успешно добавлен");
//        resp.sendRedirect(req.getContextPath() + "/newUserAdded");}
//        else {
//            req.getSession().setAttribute("check", "Ваш логин уже есть в списке пользователей. Выберете другой логин");
//            resp.sendRedirect(req.getContextPath() + "/repeatLoginUser");
//        }
//    }
}
