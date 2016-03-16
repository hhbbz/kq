package aode.kq.service;

import aode.kq.model.Admin;

/**
 * Created by 黄柏樟 on 2016/3/8.
 * @Explain: 商家业务接口
 */
public interface AdminService extends BaseService<Admin> {
    public Admin login(Admin admin) ;
}
