package main.servlets;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;

/**
 * Created by admin on 23.04.2017.
 */
@Controller
public class AddedUserServlet extends HttpServlet {




    @RequestMapping(value = "/newUserAdded",method = RequestMethod.GET)
    public ModelAndView getLoginAndPass(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("newUserAdded");
        return mav;
    }

}
