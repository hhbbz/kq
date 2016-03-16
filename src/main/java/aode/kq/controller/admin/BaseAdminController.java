package aode.kq.controller.admin;


import aode.kq.been.AjaxResult;
import aode.kq.util.Reflections;

import java.io.Serializable;


public abstract class BaseAdminController<T, ID extends Serializable> {
    protected Class<T> entityClass = Reflections.getClassGenricType(getClass());//获取泛型
    protected String claseName=entityClass.getName().substring(entityClass.getName().lastIndexOf(".")+1);
    protected String TEMPLATE_NAME=claseName.substring(0,1).toLowerCase()+claseName.substring(1);  //类名

    protected String admin_dir = "/WEB-INF/admin/";                   //后台管理的jsp目录
    protected String TEMPLATE_PATH=admin_dir+TEMPLATE_NAME+"/";              //每个模块的页面地址
    protected String REDIRECT_URL="redirect:/admin/"+TEMPLATE_NAME+"/";      //重定向    //重定向

    protected final static AjaxResult errorResult = new AjaxResult(false,
            "操作失败！");
    protected static AjaxResult ajxlist = new AjaxResult();
    protected final static AjaxResult successResult = new AjaxResult(true,
			"操作成功！");

}
