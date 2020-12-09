<%--
  Created by IntelliJ IDEA.
  User: zqq
  Date: 2020/11/10
  Time: 9:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/script/jquery-1.7.2.js"></script>
    <script type="text/javascript">
        //页面加载完成后启动
        $(function () {
            function form2JsonString(formId) {
                var paramArray = $("#formPerson").serializeArray();
                /*请求参数转json对象*/
                $(paramArray).each(function(){
                    jsonObj[this.name]=this.value;
                });

                // json对象再转换成json字符串

                return JSON.stringify(jsonObj);
            }
            $("#submit").click(function () {
                var jsonObj=form2JsonString(formPerson);
                alert(jsonObj)
                $.ajax({
                    url: "${pageContext.request.contextPath}/sendPerson",
                    type: "post",
                    data: jsonObj,
                    success: function (data) {
                        if (data == "1") {
                            alert("ok");
                        }
                    },
                    dataType: "json",
                    contentType: "application/json"
                });
                return false;
            });
            $("button:eq(1)").click(function () {
                // var josnstr=JSON.stringify({"id":"1","name":"张三","gender":"男"});
                // alert(josnstr);
                $.ajax({
                    url: "${pageContext.request.contextPath}/getPerson",
                    type: "post",
                    data: '{"id":"1","name":"张三","gender":"男"}',
                    success: function (data) {
                        console.log(data);
                        console.log(data.id);
                        console.log(JSON.stringify(data));
                    },
                    dataType: "json",
                    contentType: "application/json"
                })
            })
        })
    </script>
</head>
<body>
<form action="${pageContext.request.contextPath}/upload" method="post" enctype="multipart/form-data">
    <input type="text" name="username"><br>
    <input type="file" name="photo"><br>
    <input type="submit" value="上传">
</form>
<br>
<form id="formPerson" method="post">
    id：<input type="text" name="id"><br>
    姓名：<input type="text" name="name"><br>
    性别：<input type="text" name="gender"><br>
    <button id="submit">提交</button>
</form>
<br>
<button>jsonToObject</button>
<hr>

</body>
</html>
