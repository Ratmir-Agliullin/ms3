package main.servlets;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;

/**
 * Created by admin on 01.05.2017.
 */
@Controller
public class AddedAdminServlet extends HttpServlet {


    @RequestMapping(value = "/newAdminAdded",method = RequestMethod.GET)
    public ModelAndView getLoginAndPass(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("newAdminAdded");
        return mav;
    }
}
