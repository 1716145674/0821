<%@ page language="java" contentType="text/html;charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Resist</title>

    <%--    静态引入jsp页面的 base css jQuery框架--%>
    <%@include file="/pages/common/head.jsp" %>

    <script type="text/javascript">

        $(function () {
            // 给验证码图片添加单击事件
            $("#codeImg").click(function () {
                this.src="${requestScope.basePath}kaptcha.jpg?d="+Math.random();
            })
            //给所有的input添加事件使得在鼠标离开输入框后提示消息消失
            $(":input").focusout(function () {
                $("span.errorMsg").text("");
            })

            //密码强度判断的执行事件
            $("#password").keyup(function () {
                var password = $(this).val();
                var levl = getLvl(password);
                if (levl == 1) {
                    $("span.errorMsg").text("密码强度：弱").css("color", "red");
                } else if (levl == 2) {
                    $("span.errorMsg").text("密码强度：中").css("color", "blue");
                } else {
                    $("span.errorMsg").text("密码强度：强").css("color", "green");
                }
            })

            // 给注册按钮绑定单击事件
            $("#sub_btn").click(function () {
                // 验证用户名：必须由字母，数字下划线组成，并且长度为5到12位
                //1 获取用户名输入框里的内容
                var usernameText = $("#username").val();
                //2 创建正则表达式对象==>>必须由字母，数字下划线组成，并且长度为5到12位
                var usernamePatt = /^\w{5,12}$/;
                //3 调用test()验证是否匹配
                if (!usernamePatt.test(usernameText)) {
                    //4 提示用户验证结果
                    $("span.errorMsg").text("用户名不合法!");
                    return false;
                }

                // 验证密码：必须由字母，数字下划线组成，并且长度为5到12位
                //1 获取密码输入框里的内容
                var passwordText = $("#password").val();
                //2 创建正则表达式对象==>>必须由字母，数字下划线组成，并且长度为5到12位
                var passwordPatt = /^\w{5,12}$/;
                //3 调用test()验证是否匹配
                if (!passwordPatt.test(passwordText)) {
                    //4 提示用户验证结果
                    $("span.errorMsg").text("密码不合法!");
                    return false;
                }

                // 验证确认密码：和密码相同
                // 1 获取确认密码的内容
                var repwdText = $("#repwd").val();
                // 2 跟密码比较
                if (passwordText != repwdText) {
                    // 3 如果不一致就提示用户
                    $("span.errorMsg").text("确认密码和密码不一致!");
                    return false;
                }

                // 邮箱验证：xxxxx@xxx.com
                //1 获取邮箱的内容
                var emailText = $("#email").val();
                //2 创建邮箱的正则表达式对象
                var emailPatt = /^[a-z\d]+(\.[a-z\d]+)*@([\da-z](-[\da-z])?)+(\.{1,2}[a-z]+)+$/;
                //3 使用test方法验证
                if (!emailPatt.test(emailText)) {
                    //4 提示用户结果
                    $("span.errorMsg").text("邮箱格式不合法!");
                    return false;
                }

                // 验证码：现在只需要验证用户已输入。因为还没讲到服务器。验证码生成
                var codeText = $("#code").val();
                var s = codeText.trim();
                if (s == "") {
                    $("span.errorMsg").text("验证码不能为空!");
                    return false;
                }
            });
            //判断密码强度的函数
            function getLvl(pwd) {
                var lvl = 0;//默认是0级
                //密码中是否有数字
                if (/[0-9]/.test(pwd)) {
                    lvl++;
                }
                //判断密码中有没有字母
                if (/[a-zA-Z]/.test(pwd)) {
                    lvl++;
                }
                //判断密码中有没有特殊符号
                if (/[^0-9a-zA-Z_]/.test(pwd)) {
                    lvl++;
                }
                return lvl;//最小的值是1,最大值是3
            }
        });
    </script>
    <style type="text/css">
        .login_form {
            height: 420px;
            margin-top: 25px;
        }

    </style>
</head>
<body>
<div id="login_header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
</div>

<div class="login_banner">

    <div id="l_content">
        <span class="login_word">欢迎注册</span>
    </div>

    <div id="content">
        <div class="login_form">
            <div class="login_box">
                <div class="tit">
                    <h1>注册尚硅谷会员</h1>
                    <span class="errorMsg">${errorMessage}</span>
                </div>
                <div class="form">
                    <form action="userServlet" method="post">
                        <input type="hidden" name="actionMethod" value="regist">
                        <label>用户名称：</label>
                        <input class="itxt" type="text" placeholder="请输入用户名" autocomplete="off" tabindex="1"
                               name="name" id="username" value="${param.username}"/>
                        <br/>
                        <br/>
                        <label>用户密码：</label>
                        <input class="itxt" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1"
                               name="password" id="password" value=""/>
                        <br/>
                        <br/>
                        <label>确认密码：</label>
                        <input class="itxt" type="password" placeholder="确认密码" autocomplete="off" tabindex="1"
                               name="repwd" id="repwd" value=""/>
                        <br/>
                        <br/>
                        <label>电子邮件：</label>
                        <input class="itxt" type="text" placeholder="请输入邮箱地址" autocomplete="off" tabindex="1"
                               name="email" id="email" value="${param.email}"/>
                        <br/>
                        <br/>
                        <label>验证码：</label>
                        <input class="itxt" type="text" style="width: 100px;margin-left: 15px;" id="code" name="code"/>
                        <img alt="" id="codeImg" src="kaptcha.jpg" style="float: right;  width: 100px; height:35px; margin-right: 50px;">
                        <br/>
                        <br/>
                        <input type="submit" value="注册" id="sub_btn"/>
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
