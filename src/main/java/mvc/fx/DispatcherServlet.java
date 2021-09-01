package mvc.fx;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.controllers.Source;
import mvc.controllers.Target;

@WebServlet(urlPatterns = {"/slamdunk/*"}, loadOnStartup = 10)
public class DispatcherServlet extends HttpServlet{
    
    private Map<String, AbstractController> controllerMap = new HashMap<>();
    
    @Override
    public void init() throws ServletException {
        Properties prop = new Properties();
        
        try {
        prop.load(new FileInputStream(
                this.getClass().getResource("dispatcher-servlet.properties").getPath()));
        for (Object key : prop.keySet() ) {
            String skey = (String) key;
            Class<?> className = Class.forName(prop.getProperty(skey) );
            controllerMap.put(skey,(AbstractController)className.getConstructor().newInstance() );
        }
        
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        String contextPath = request.getContextPath();
        System.out.println(requestURI);
        System.out.println(contextPath);
        String action = requestURI.substring(contextPath.length());
        System.out.println(action);
        
        AbstractController controller = controllerMap.get(action);;
        ModelAndView mav = controller.handleRequestInternal(request,response);
      /*if (action.equals("/slamdunk/source") ) {
            controller = new Source();
            mav = controller.handleRequestInternal(request, response);
        } else if (action.equals("/slamdunk/target") ) {
            controller = new Target();
        }*/
        
        if (mav != null) {
            String viewName = mav.getViewName();
            Map<String, Object> model = mav.getModel();
            for(String key : model.keySet()) {
                request.setAttribute(key, model.get(key));
            }
            
            RequestDispatcher dispatcher = request.getRequestDispatcher(viewName);
            dispatcher.forward(request, response);
            return;
            
        } else {
            System.out.println("DispatcherServlet 에서 길을 잃었다네~!");
        }
    }

}
