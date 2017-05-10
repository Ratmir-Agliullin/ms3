package main.servlets;

import main.models.pojo.LoginEntity;
import main.services.OrderService;
import main.services.PrInOrService;
import main.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by admin on 05.05.2017.
 */
@Controller
public class OrdersOfUser {


    private OrderService orderService;
    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    private PrInOrService prInOrService;
    @Autowired
    public void setPrInOrService(PrInOrService prInOrService) {
        this.prInOrService = prInOrService;
    }

    private UserService userService;
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }


    @RequestMapping(value = "/ordersOfUser",method = RequestMethod.GET)
    public ModelAndView getOrders(HttpServletRequest req){
        LoginEntity currentUser = new LoginEntity();
        User authUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        currentUser.setUsername(authUser.getUsername());
        currentUser.setPassword(authUser.getPassword());
        ModelAndView mav = new ModelAndView();
        int id = userService.SelectUserIdFromName(currentUser.getUsername());
        mav.addObject("orders", orderService.SelectOrderByUserId(id));
        return mav;
    }
}
