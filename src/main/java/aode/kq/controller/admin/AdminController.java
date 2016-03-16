package aode.kq.controller.admin;

import aode.kq.model.Admin;
import aode.kq.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * Created by 黄柏樟 on 2016/3/8.
 * @Explain: 商家控制器
 */
@Controller
@RequestMapping(value = "admin/admin")
public class AdminController extends BaseAdminController<Admin,Long> {

    @Autowired
    private AdminService adminService;

    @RequestMapping("list")
    public String list(){
        return TEMPLATE_PATH+"list";
    }
    /**
     * 登录页
     */
    @RequestMapping("/loginUI")
    public String login() {
        return TEMPLATE_PATH+"loginUI";
    }

    /**
     * 用户登陆
     * @param admin
     * @param model
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@Valid Admin admin, Model model) {
        Admin a = this.adminService.login(admin);
        return admin_dir+"index";
    }

    /**
     * 用户登出
     * 
     * @param session
     * @return
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession session) {
        session.removeAttribute("userInfo");
        return REDIRECT_URL+"/login";
    }



}
