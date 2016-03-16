<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>
      奥德 后台管理- 首页
    </title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" name="viewport">
    <%@ include file="se7en_css.jsp" %>
    <%@ include file="se7en_js.jsp" %>
</head>
<body>
<div class="modal-shiftfix">
    <!-- Navigation -->
    <%@ include file="navigation.jsp" %>
    <!-- End Navigation -->
    <div class="container-fluid main-content">
        <!-- Statistics -->
        <div class="row">
            <div class="col-lg-12">
                <div class="widget-container stats-container">
                    <div class="col-md-3">
                        <a href="${pageContext.request.contextPath}/admin/product/list">
                            <div class="number">
                                <span class="icon-star"></span>
                               ${productCount}
                            </div>
                            <div class="text">
                                产品
                            </div>
                        </a>
                    </div>
                    <div class="col-md-3">
                        <a href="${pageContext.request.contextPath}/admin/member/list">
                            <div class="number">
                                <div class="icon-group"></div>
                               ${memberCount}
                            </div>
                            <div class="text">
                                用户
                            </div>
                        </a>
                    </div>
                    <div class="col-md-3">
                        <a href="${pageContext.request.contextPath}/admin/orders/list">
                        <div class="number">
                            <div class="icon-cloud-download "></div>
                           ${ordersCount}
                        </div>
                        <div class="text">
                            订单
                        </div>
                        </a>
                    </div>
                    <div class="col-md-3">
                        <a href="${pageContext.request.contextPath}/admin/productType/list">
                            <div class="number">
                                <div class="icon-comments"></div>
                               ${productTypeCount}
                            </div>
                            <div class="text">
                                产品类型
                            </div>
                        </a>
                    </div>
                </div>
            </div>
        </div>
        <!-- End Statistics -->
        <div class="row">
            <!-- Weather -->
        </div>
        <div class="row">
        </div>
    </div>
</div>
</body>
</html>