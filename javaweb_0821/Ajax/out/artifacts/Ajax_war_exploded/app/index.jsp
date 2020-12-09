<%--
  Created by IntelliJ IDEA.
  User: zqq
  Date: 2020/9/3
  Time: 22:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
  <script type="text/javascript" src="${pageContext.request.contextPath}/scripts/jquery-1.7.2.js"></script>
  <script type="text/javascript">
    $(function () {
        $(":input[name='username']").change(function () {
          var val=$(this).val();
          val=$.trim(val);
          if (val!=""){
            var url="${pageContext.request.contextPath}/valiateUserName";
            var args={"username":val,"time": new Date()};
            $.post(url,args,function (data) {
                $("#message").html(data);
            });
          }

        })
    })
  </script>
</head>
<body>
<form action="" method="post">
    userName:<input type="text" name="username"/>
    <br>
    <%--        <div id="message"> <font color="red"> 该用户已经存在！</font></div>--%>
    <div id="message"></div>
    <br>

    <input type="submit" value="submit"/>
</form>

</body>
</html>
