package main.servlets;

import main.models.pojo.LoginEntity;
import main.models.pojo.Order;
import main.models.pojo.Product;
import main.models.pojo.Users;
import main.services.OrderService;
import main.services.PrInOrService;
import main.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 04.05.2017.
 */
@Controller
@SessionAttributes("user")
public class CreateOrder {


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


    @RequestMapping(value = "/createOrder",method = RequestMethod.GET)
    public ModelAndView CreateNewOrder( HttpServletRequest req){
        ModelAndView mav = new ModelAndView();
      List<Product> productList = new ArrayList<>();
      productList = (List<Product>) req.getSession().getAttribute("products");
        int sum = (int)req.getSession().getAttribute("resultSum");

        LoginEntity currentUser = new LoginEntity();
        User authUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        currentUser.setUsername(authUser.getUsername());
        currentUser.setPassword(authUser.getPassword());


        Order order = new Order();
        order.setResultPrice(sum);
        order.setStatus("Заказ");
        order.setTime(System.currentTimeMillis());
        order.setOrderName("New_Order_"+currentUser.getUsername()+"___"+System.currentTimeMillis());
        mav.addObject("ordername", order.getOrderName());
        mav.addObject("summa", order.getResultPrice());
        order.setUser_id(userService.SelectUserIdFromName(currentUser.getUsername()));
        Users user = new Users();
        user.setUserName(currentUser.getUsername());
        user.setPassName(currentUser.getPassword());
        order.setUserName(user);
    orderService.InsertInOrder(order);
    mav.addObject("contain",order.getOrderName().contains("user2"));
    prInOrService.InsertListInPrInOrTable(orderService.SelectOrderId(order),productList);
        return mav;
    }
}
