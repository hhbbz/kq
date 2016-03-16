package aode.kq.dao;

import aode.kq.model.Admin;
import aode.kq.util.BaseMapper;

/**
 * Created by 黄柏樟 on 2016/3/8.
 * @Explain: 商家mapper接口
 */
public interface AdminMapper extends BaseMapper<Admin> {
    public Admin login(Admin admin) ;
}
