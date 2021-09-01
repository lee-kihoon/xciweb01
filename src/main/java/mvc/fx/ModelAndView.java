package mvc.fx;

import java.util.HashMap;
import java.util.Map;

public class ModelAndView {
    // 필드
    private String viewName;
    private Map<String, Object> model = new HashMap<>();
    
    // 생성자
    public ModelAndView() { }
    public ModelAndView(String viewName) {
        setViewName(viewName);
    }
    public ModelAndView(String viewName, String key, Object obj) {
        setViewName(viewName);
        addObject(key, obj);
    }
    
    // Hashmap put 
    public void addObject(String key, Object obj) {
        model.put(key, obj);
    }
    
    // getter, setter
    public String getViewName() {
        return viewName;
    }

    public void setViewName(String viewName) {
        this.viewName = viewName;
    }

    public Map<String, Object> getModel() {
        return model;
    }
    
}
