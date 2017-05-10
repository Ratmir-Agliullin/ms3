package main.servlets;

import main.models.pojo.Product;
import main.services.OrderService;
import main.services.PrInOrService;
import main.services.ProductService;
import main.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 02.05.2017.
 */
@Controller
public class NewOrder {
    private PrInOrService prInOrService;
    @Autowired
    public void setPrInOrService(PrInOrService prInOrService) {
        this.prInOrService = prInOrService;
    }

private OrderService orderService;
    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }



    private UserService userService;
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    private ProductService productService;
    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }



    public List<Product> productList=new ArrayList<>();

    @RequestMapping(value = "/newOrder",method = RequestMethod.GET)
    public ModelAndView CreateOrder(@RequestParam int id, HttpServletRequest req){
        ModelAndView mav = new ModelAndView();
        productList.add(productService.getProductById(id));
        mav.addObject("products",productList);

       int sum = prInOrService.getSumPrice(productList);

       mav.addObject("resultSum", sum);

        req.getSession().setAttribute("resultSum",sum);
        req.getSession().setAttribute("products",productList);
        mav.setViewName("newOrder");
        //Посмотреть когда создается новый заказ+запись в PrInOrders
        return mav;
    }
}
