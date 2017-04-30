package main.servlets;

import main.models.DAO.ProductsTable;
import main.servlets.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by admin on 23.04.2017.
 */
//@Component
@Controller
public class UserInfoServlet {



    private UserService userService;
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }



    @RequestMapping(value = "userInfo",method = RequestMethod.GET)
    public ModelAndView getLoginAndPass(){
        ModelAndView mav = new ModelAndView();

        ProductsTable productsTable = new ProductsTable();
        mav.addObject("products", productsTable.SelectProductsTable());
        mav.setViewName("userInfo");
        return mav;
    }

//
//    @RequestMapping(value = "/login",method = RequestMethod.POST)
//    public ModelAndView checkLAP(@ModelAttribute("user") LoginEntity loginEntity){
//        ModelAndView mav = new ModelAndView();
//        String checkUserAdmin = "Не авторизованный пользователь. Авторизуйтесь!";
//        String afterAuthURL = "/newUserAdd";
//        if (userService.UserAuthCheck(loginEntity.getUsername(),loginEntity.getPassword())){
//            checkUserAdmin = "Пользователь";
//            afterAuthURL = "userInfo";
//            mav.addObject("check", loginEntity);
//            mav.setViewName(afterAuthURL);
//        };
//        return mav;
//
//    }

//
//    @Override
//    public void init(ServletConfig config) throws ServletException {
//        super.init(config);
//        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this,
//                config.getServletContext());
//    }
//    /**
//     *
//     * See information about user
//     * @param req
//     * @param resp
//     * @throws ServletException
//     * @throws IOException
//     */
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        ProductsTable productsTable = new ProductsTable();
//
//        req.setAttribute("products",productsTable.SelectProductsTable());
//        getServletContext().getRequestDispatcher("/userInfo.jsp").forward(req,resp);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//    }
}
