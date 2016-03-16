<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>  
<head>
    <meta charset="utf-8">
    <title>
        管理员编辑
    </title>
    <%@ include file="../se7en_css.jsp" %>

    <meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" name="viewport">
</head>
<body>
<div class="modal-shiftfix">
    <!-- Navigation -->
    <%@ include file="../navigation.jsp" %>
      <div class="container-fluid main-content"><div class="page-title">
      </div>
          <div class="row">
              <div class="col-lg-12">
                  <ul class="breadcrumb">
                      <li>
                          <a href="${pageContext.request.contextPath}/admin/index"></a><i class="icon-home"></i>
                      </li>
                      <li>
                          <a href="${pageContext.request.contextPath}/admin/user/list">管理员管理</a>
                      </li>
                      <li class="active">
                          管理员保存
                      </li>
                  </ul>
              </div>
              <div class="col-md-12">
                  <div class="widget-container">
                      <div class="heading">
                          <i class="icon-shield"></i>管理员保存
                      </div>
                      <div class="widget-content padded">
                          <form >
                              <fieldset>
                                  <div class="row">
                                      <div class="col-md-6 col-md-offset-3">
                                          <div class="form-group">
                                              <label for="loginName">登录账号</label>
                                              <input class="form-control" readonly id="loginName" name="loginName" type="text" value="${user.loginName}">
                                          </div>
                                          <div class="form-group">
                                              <label for="name">姓名</label>
                                              <input class="form-control" readonly id="name" name="name" type="text" value="${user.name}">
                                          </div>
                                              <div class="form-group">
                                                  <label for="phoneNumber">手机号码</label>
                                                  <input class="form-control" readonly id="phoneNumber" name="phoneNumber" type="text" value="${user.phoneNumber}">
                                              </div>
                                              <div class="form-group">
                                                  <label for="email">邮件</label>
                                                  <input class="form-control" readonly id="email" name="email" type="email" value="${user.email}">
                                              </div>
                                      </div>
                                  </div>
                                  <div class="col-md-offset-5 col-md-2">
                                      <a class="btn btn-default-outline" href="${pageContext.request.contextPath}/admin/user/list">返回</a>
                                  </div>

                              </fieldset>
                          </form>
                      </div>
                  </div>
              </div>
          </div>
      </div>
  </div>
<%@ include file="../se7en_js.jsp" %>
  </body>
</html>