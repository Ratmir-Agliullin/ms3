package main.Filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by admin on 22.04.2017. Filter for users
 */

public class CurrentFilter implements Filter {

    /**
     *
     * Filter for users
     * @param filterConfig
     * @throws ServletException
     */
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String userRole ="Незарегистрированный пользователь";
        userRole =(String) ((HttpServletRequest) servletRequest).getSession().getAttribute("check");
        if (userRole.equals("Пользователь")) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            ((HttpServletResponse) servletResponse)
                    .sendRedirect(((HttpServletRequest) servletRequest).getContextPath() + "/newUserAdd");
        }
    }

    public void destroy() {

    }
}
