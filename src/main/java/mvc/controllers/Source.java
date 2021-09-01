package mvc.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.fx.AbstractController;
import mvc.fx.ModelAndView;

public class Source extends AbstractController {

    @Override
    public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) {
        return new ModelAndView("/WEB-INF/views/source.jsp");
    }
    
}
