<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/script/jquery/jquery-3.1.0.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#secKill_btn").click(function () {
                var url = $("#sk_form").action;
                var data = $("#sk_form").serialize();
                alert(data);
                $.ajax({
                    url: url,
                    data: data,
                    type: "post",
                    success: function (data) {
                        if (data == 1) {
                            alert("11")
                        }
                    }
                })
            })

        })
    </script>
</head>
<body>
<h1>HUAWEI MATE 30 5G!!! 1元秒杀！！！
</h1>


<form id="sk_form" action="${pageContext.request.contextPath}/doseckill" method="post">
    <input type="hidden" id="prodid" name="prodid" value="1712">
    <input type="button" id="secKill_btn" name="miaosha_btn" value="秒杀">
</form>

</body>
</html>