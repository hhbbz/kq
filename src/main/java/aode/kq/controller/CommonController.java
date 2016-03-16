package aode.kq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 黄柏樟 on 2016/3/8.
 * @Explain: 公共视图控制器
 */
@Controller
public class CommonController {
    /**
     * 首页
     * 
     * @return
     */
    @RequestMapping("/")
    public String index() {
        System.out.println("......!!!!!!");
        return "index";
    }

}