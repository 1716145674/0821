<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<head>
    <title>尚硅谷会员登录页面</title>

    <%--    静态引入jsp页面的 base css jQuery框架--%>
    <%@include file="/pages/common/head.jsp" %>

    <script type="text/javascript">
        $(function () {
            //获得用户名的值
            var usernameText = $(":text[name='username']").val();
            //若首次进入用户名为空则不显示提示信息
            if ($("span.errorMsg").text() == "") {
                $("div.msg_cont").css("opacity", "0");

            }
            $("#sub_btn").click(function () {
                //验证用户名是否合法
                var usernameText = $(":text[name='username']").val();
                var usernameReg = /^[a-z0-9_-]{3,16}$/;
                if (!usernameReg.test(usernameText)) {
                    $("span.errorMsg").text("用户名不合法！");
                    $("div.msg_cont").css("opacity", "1");
                    return false;
                }
                //验证密码是否合法
                var passwordText = $(":password[name='password']").val();
                var passwordReg = /^[a-z0-9_-]{5,18}$/;
                if (!passwordReg.test(passwordText)) {
                    $("span.errorMsg").text("密码不合法！");
                    $("div.msg_cont").css("opacity", "1");
                    return false;
                }
                $("span.errorMsg").text("");
            })

        })
    </script>
</head>
<body>
<div id="login_header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
</div>

<div class="login_banner">

    <div id="l_content">
        <span class="login_word">欢迎登录</span>
    </div>

    <div id="content">
        <div class="login_form">
            <div class="login_box">
                <div class="tit">
                    <h1>尚硅谷会员</h1>
                    <a href="pages/user/regist.jsp">立即注册</a>
                </div>
                <div class="msg_cont">
                    <b></b>
                    <span class="errorMsg">${errorMessage}</span>
                </div>
                <div class="form">
                    <form action="userServlet" method="post">
                        <input type="hidden" name="actionMethod" value="login">
                        <label>用户名称：</label>
                        <input class="itxt" type="text" placeholder="请输入用户名" autocomplete="off" tabindex="1"
                               name="name" value="${param.name}"/>
                        <br/>
                        <br/>
                        <label>用户密码：</label>
                        <input class="itxt" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1"
                               name="password"/>
                        <br/>
                        <br/>
                        <input type="submit" value="登录" id="sub_btn"/>
                    </form>
                </div>

            </div>
        </div>
    </div>
</div>

<%--    静态引入jsp页面的页脚--%>
<%@include file="/pages/common/footer.jsp" %>

</body>
</html>