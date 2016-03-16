package aode.kq.service.impl;

import aode.kq.dao.AdminMapper;
import aode.kq.model.Admin;
import aode.kq.service.AdminService;
import aode.kq.util.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 黄柏樟 on 2016/3/8.
 * @Explain: 商家业务实现类
 */
@Service
public class AdminServiceImpl extends BaseServiceImpl<Admin> implements AdminService {

    @Autowired
    private AdminMapper adminMapper ;

    @Override
    protected BaseMapper<Admin> getBaseMapper() {
        return adminMapper;
    }

    @Override
    public Admin login(Admin admin) {

        return this.adminMapper.login(admin);
    }


}
