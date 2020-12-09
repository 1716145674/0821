package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class ScopeController {

    @RequestMapping(value = "/requestScope")
    public String requestScope(HttpServletRequest request){

        System.out.println("requestScope(HttpServletRequest request)");

        request.setAttribute("reqKey1","reqValue1");
        request.setAttribute("reqKey2","reqValue2");
        return "scope";
    }


    @RequestMapping(value = "/sessionScope")
    public String sessionScope(HttpSession session){
        System.out.println(" sessionScope(HttpSession session) ");

        session.setAttribute("sessionKey1","sessionValue1");
        session.setAttribute("sessionKey2","sessionValue2");
        return "scope";
    }


//    @Autowired
//    ServletContext servletContext;

    @RequestMapping(value = "/servletContextScope")
    public String servletContextScope(HttpSession session){
        System.out.println(" servletContextScope ");

        session.getServletContext().setAttribute("servletContextKey1","servletContextValue1");
        session.getServletContext().setAttribute("servletContextKey2","servletContextValue2");

        return "scope";
    }


    @RequestMapping(value = "/mapToRequest")
    public String mapToRequest(Map<String,Object> map){
        System.out.println(" mapToRequest ");

        // 保存到Map中的数据，会自动同步地保存到Request域中
        map.put("key1", "value1");
        map.put("key2", "value2");

        return "scope";
    }


    @RequestMapping(value = "/modelToRequest")
    public String modelToRequest(Model model){
        System.out.println(" modelToRequest ");

        // 保存到 Model 中的数据，会自动同步地保存到Request域中
        model.addAttribute("modelkey1", "modelvalue1");
        model.addAttribute("modelkey2", "modelvalue2");

        return "scope";
    }



    @RequestMapping(value = "/modelMapToRequest")
    public String modelMapToRequest(ModelMap modelMap){
        System.out.println(" modelMapToRequest ");

        // 保存到 ModelMap 中的数据，会自动同步地保存到Request域中
        modelMap.addAttribute("modelMapkey1", "modelMapvalue1");
        modelMap.addAttribute("modelMapkey2", "modelMapvalue2");

        return "scope";
    }

    /**
     * BindingAwareModelMap类我们管它叫 隐含模型，它的作用是用来保存视图渲染需要的数据。<br/>
     *
     * 视图                   客户端（浏览器最终看到的页面）就是html，或jsp等其他的页面<br/>
     * 渲染                   执行视图的代码 <br/>
     * 渲染需要的数据          页面需要输出的数据(保存到域中的那些需要给页面输出的数据)<br/>
     *
     * org.springframework.validation.support.BindingAwareModelMap类 <br/>
     *                                  /\
     *                                  ||
     *              BindingAwareModelMap extends ExtendedModelMap
     *                                          /\
     *                                          ||
     *               class ExtendedModelMap extends ModelMap implements Model
     *                                                 /\
     *                                                 ||
     *                            class ModelMap extends LinkedHashMap<String, Object>
     *
     */
    @RequestMapping(value = "/mapAndModelAndModelMap")
    public String mapAndModelAndModelMap(Map<String,Object> map,Model model,ModelMap modelMap){
        System.out.println( map );
        System.out.println( model );
        System.out.println( modelMap );
        System.out.println("==================================");

        map.put("key1","value1");

        System.out.println(map);
        System.out.println(model);
        System.out.println(modelMap);
        System.out.println("==================================");

        model.addAttribute("model1","modelValue1");

        System.out.println(map);
        System.out.println(model);
        System.out.println(modelMap);
        System.out.println("==================================");

        modelMap.addAttribute("modelMap1","modelMapValue1");
        System.out.println(map);
        System.out.println(model);
        System.out.println(modelMap);
        System.out.println("==================================");


        System.out.println(map.getClass());
        System.out.println(model.getClass());
        System.out.println(modelMap.getClass());

        return "scope";

    }







}
