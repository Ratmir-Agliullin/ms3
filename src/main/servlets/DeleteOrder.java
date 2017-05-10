package main.servlets;

import main.services.OrderService;
import main.services.PrInOrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by admin on 05.05.2017.
 */
@Controller
public class DeleteOrder {

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



    @RequestMapping(value = "deleteOrder",method = RequestMethod.GET )
    public String getLoginAndPass(@RequestParam int id){
        ModelAndView mav = new ModelAndView();
       orderService.DeleteOrderById(id);
       prInOrService.DeletePrInOrderById(id);
        mav.setViewName("deleteAdmin");
        return "redirect:allOrders";
    }
}
