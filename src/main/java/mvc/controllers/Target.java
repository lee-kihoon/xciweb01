package mvc.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.fx.AbstractController;
import mvc.fx.ModelAndView;

public class Target extends AbstractController {

    @Override
    public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String iam = "그래, 난 " + name + ".";
        
        return new ModelAndView("/WEB-INF/views/target.jsp", "iam", iam);
    }

}
