<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!-- Navigation -->
<div class="navbar navbar-fixed-top scroll-hide">
    <div class="container-fluid top-bar">
        <div class="pull-right">
            <ul class="nav navbar-nav pull-right">

                <li class="dropdown settings hidden-xs">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#"><span aria-hidden="true" class="se7en-gear"></span>
                        <div class="sr-only">
                            设置
                        </div>
                    </a>
                    <ul class="dropdown-menu">
                        <li>
                            <a class="settings-link blue" href="javascript:chooseStyle('none', 30)"><span></span>蓝色</a>
                        </li>
                        <li>
                            <a class="settings-link green" href="javascript:chooseStyle('green-theme', 30)"><span></span>绿色</a>
                        </li>
                        <li>
                            <a class="settings-link orange" href="javascript:chooseStyle('orange-theme', 30)"><span></span>橘黄色</a>
                        </li>
                        <li>
                            <a class="settings-link magenta" href="javascript:chooseStyle('magenta-theme', 30)"><span></span>品红</a>
                        </li>
                        <li>
                            <a class="settings-link gray" href="javascript:chooseStyle('gray-theme', 30)"><span></span>灰色</a>
                        </li>
                    </ul>
                </li>
                <li class="dropdown user hidden-xs"><a data-toggle="dropdown" class="dropdown-toggle" href="#">
                    <img width="34" height="34" src="${pageContext.request.contextPath}/resources/admin/images/avatar-male.jpg" />${loginUser.name}<b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a href="${pageContext.request.contextPath}/admin/user/show/${loginUser.id}">
                            <i class="icon-user"></i>我的账户</a>
                        </li>
                        <li><a href="${pageContext.request.contextPath}/admin/user/updateUI/${loginUser.id}">
                            <i class="icon-gear"></i>账户设置</a>
                        </li>
                        <li><a href="${pageContext.request.contextPath}/rest/admin/user/logout">
                            <i class="icon-signout"></i>退出</a>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
    <div class="container-fluid main-nav clearfix">
        <div class="nav-collapse">
            <ul class="nav">
                <li>
                    <a  href="${pageContext.request.contextPath}/admin/index" id="index_page"><span aria-hidden="true" class="icon-home"></span>控制台</a>
                </li>
                <li ><a href="${pageContext.request.contextPath}/rest/admin/user/list" id="user_page">
                    <span aria-hidden="true" class="icon-user "  ></span>管理员</a>
                </li>
                <li ><a href="${pageContext.request.contextPath}/admin/member/list" id="member_page">
                    <span aria-hidden="true" class="icon-group "></span>用户</a>
                </li>
                <li class="dropdown"><a data-toggle="dropdown" href="#" id="product_page">
                    <span aria-hidden="true" class="icon-cog "></span>产品<b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a href="${pageContext.request.contextPath}/admin/productType/list">
                                产品类型</a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/admin/product/list">产品管理</a>
                        </li>

                    </ul>
                </li>
                <li><a href="${pageContext.request.contextPath}/admin/orders/list" id="orders_page">
                    <span aria-hidden="true" class="icon-truck"></span>订单</a>
                </li>
            </ul>
        </div>
    </div>
</div>
<!-- End Navigation -->