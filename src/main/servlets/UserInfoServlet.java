package main.servlets;

import main.models.DAO.ProductsTable;
import main.services.UserService;
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


}
