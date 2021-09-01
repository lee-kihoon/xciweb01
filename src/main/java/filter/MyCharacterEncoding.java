package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter(urlPatterns = {"/*"})
public class MyCharacterEncoding implements Filter {

    public MyCharacterEncoding() {
        System.out.println("MyCharacterEncoding()");
    }

    public void destroy() {
        System.out.println("destroy()");
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("doFilter()");
        HttpServletRequest hrequest = (HttpServletRequest) request;
        request.setCharacterEncoding("UTF-8");
        chain.doFilter(request, response);
    }

    public void init(FilterConfig fConfig) throws ServletException {
        System.out.println("init()");
    }

}
