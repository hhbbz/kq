package aode.kq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 黄柏樟 on 2016/3/8.
 * @Explain: 视图控制器,返回jsp视图给前端(应封装此处)
 */
@Controller
@RequestMapping("/page")
public class PageController{


    /**
     * 默认页
     */
    @RequestMapping("admin/index")
    public String login() {
        return "WEB-";
    }

    /**
     * dashboard页
     */
    @RequestMapping("/dashboard")
    public String dashboard() {
        return "dashboard";
    }

    /**
     * 404页
     */
    @RequestMapping("/404")
    public String error404() {
        return "404";
    }

    /**
     * 401页
     */
    @RequestMapping("/401")
    public String error401() {
        return "401";
    }

    /**
     * 500页
     */
    @RequestMapping("/500")
    public String error500() {
        return "500";
    }

}