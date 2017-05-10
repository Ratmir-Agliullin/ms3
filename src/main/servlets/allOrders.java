package main.servlets;

import main.services.OrderService;
import main.services.PrInOrService;
import main.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by admin on 05.05.2017.
 */
@Controller
public class allOrders {

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

    @RequestMapping(value = "/allOrders",method = RequestMethod.GET)
    public ModelAndView CreateNewOrder(HttpServletRequest req){
        ModelAndView mav = new ModelAndView();
        mav.addObject("orders",orderService.SelectAllOrders());
        mav.setViewName("allOrders");
        return mav;

    }
}
