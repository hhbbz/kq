package dao;

import aode.kq.dao.AdminMapper;
import aode.kq.model.Admin;
import aode.kq.service.AdminService;
import aode.kq.test.TestSupport;
import aode.kq.util.Encrypt;
import com.github.pagehelper.Page;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by 黄柏樟 on 2016/3/8.
 * @Explain: 测试类
 */
public class adminTest extends TestSupport {
    @Autowired
    private AdminMapper adminMapper ;
    @Autowired
    private AdminService adminService ;
    /*
        测试登陆
     */
    @Test
    public void testLogin(){
        Admin a = new Admin() ;
        a.setName("hhbbz");
        a.setPassword(Encrypt.e("123456"));
        Admin admin = this.adminMapper.login(a) ;
        System.out.println(admin.toString());
    }
    /*
        测试插入
     */
    @Test
    public void testInsert(){
        Admin a = new Admin() ;
        a.setName("hhbbz");
        a.setPassword(Encrypt.e("123456"));
        for (int i = 0; i < 6; i++) {
            this.adminMapper.insert(a) ;
        }

    }
    /*
        测试搜索
     */
    @Test
    public void testSelect(){
        Admin a = new Admin() ;
        a.setName("hhbbz");
        a.setPassword(Encrypt.e("123456"));
        Admin c = this.adminMapper.selectOne(a) ;
        System.out.println(c.toString());
    }

    /*
        测试分页
     */
    @Test
    public void testPageHelper(){
        Page<Admin> page = new Page<Admin>(1 , 3);
        List<Admin> adminList = this.adminService.pageList(page);
        for (Admin admin : adminList){
            System.out.println(admin.toString());
        }
    }
}
