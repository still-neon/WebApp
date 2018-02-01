package webapplication.filters;


import javax.servlet.*;
import java.io.IOException;

/**
 * Created by EugenKrasotkin on 1/29/2018.
 */
public class JSPFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //filterChain.doFilter(servletRequest, servletResponse);проверять что юзер залогинен, пользовательская сессия активная
    }

    @Override
    public void destroy() {

    }
}
