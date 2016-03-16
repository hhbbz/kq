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
                          <form action="${pageContext.request.contextPath}/admin/user/${ user.id == null ? 'add' : 'update' }" id="user-form" method="post">
                              <fieldset>
                                  <div class="row">
                                      <div class="col-md-6 col-md-offset-3">
                                          <div class="hidden">
                                              <input name="id" type="hidden" value="${user.id}"/>
                                          </div>
                                          <div class="form-group">
                                              <label for="loginName">登录账号</label>
                                              <input class="form-control"  ${ user.id == null ? 'add' : 'readonly' } id="loginName" name="loginName" type="text" value="${user.loginName}">
                                          </div>
                                          <div class="form-group">
                                              <label for="name">姓名</label>
                                              <input class="form-control" id="name" name="name" type="text" value="${user.name}">
                                          </div>
                                          <div class="form-group">
                                              <label for="password">密码</label>
                                              <input class="form-control" id="password" name="password" type="password" >
                                          </div>
                                          <div class="form-group">
                                              <label for="confirm_password">确认密码</label>
                                              <input class="form-control" id="confirm_password" name="confirm_password" type="password">
                                          </div>
                                              <div class="form-group">
                                                  <label for="phoneNumber">手机号码</label>
                                                  <input class="form-control" id="phoneNumber" name="phoneNumber" type="text" value="${user.phoneNumber}">
                                              </div>
                                              <div class="form-group">
                                                  <label for="email">邮件</label>
                                                  <input class="form-control" id="email" name="email" type="email" value="${user.email}">
                                              </div>
                                      </div>
                                  </div>
                                  <div class="col-md-offset-5 col-md-2">
                                      <input class="btn btn-primary " type="submit" value="保存">
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
    <script type="text/javascript">
        $(document).ready(function() {
            $("#user_page").addClass("current");
            $("#user-form").validate({
                rules: {
                    name: "required",
                    loginName: {
                        required: true,
                        minlength: 5
                    },
                    phoneNumber: {
                        minlength: 11,
                        maxlength: 11,
                        number: true
                    },
                    password: {
                        required: true,
                        minlength: 6
                    },
                    confirm_password: {
                        required: true,
                        minlength: 6,
                        equalTo: "#password"
                    },
                    email: {
                        email: true
                    }
                },
                messages: {
                    name: "请填写您的姓名",
                    loginName: {
                        required: "请填写您的管理员名",
                        minlength: "管理员名长度不能小于5位"
                    },
                    password: {
                        required: "请填写密码",
                        minlength: "密码长度不能小于6位"
                    },
                    confirm_password: {
                        required: "请重复填写密码",
                        minlength: "密码长度不能小于6位",
                        equalTo: "两次密码不一致"
                    },
                    phoneNumber: '请输入正确的手机号码',
                    email: "请填写正确的邮箱地址"
                }
            });
        });
    </script>
  </body>
</html>