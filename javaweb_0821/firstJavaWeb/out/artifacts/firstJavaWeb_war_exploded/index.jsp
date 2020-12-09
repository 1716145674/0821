<%--
  Created by IntelliJ IDEA.
  User: zqq
  Date: 2020/8/30
  Time: 10:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <script type="text/javascript">
        window.onload = function () {

            //1.获取a 节点，并为其添加onclick 相应函数
            document.getElementsByTagName("a")[0].onclick = function () {


                //3.创建一个XMLHttpRequest对象
                var request = new XMLHttpRequest();

                //4.准备发送请求的数据 ：url
                // var url = "helloAjax.txt";（出错了）
                var url = this.href;
                // var method = "get";(出错了,应该为大写）
                var method = "GET";
                //5.调用此对象的open（method ，url） 方法
                request.open(method, url);
                //6.调用此对象的send（content）方法
                request.send(null);
                //7.为此对象添加onreadystatechange 相应函数
                request.onreadystatechange = function () {
                    //8.判断相应是否完成 ：此对象的readystate属性值为4的时候
                    alert(request.readyState);
                    if (request.readyState == 4) {
                        //9.判断相应是否可用： 此对象的status 属性值为200
                        //注意分清status 和readyState的区别
                        if (request.status == 200 || request.status == 304) {
                            //10.打印相应结果 resposeText
                           alert( request.responseText);
                        }
                    }

                }


                //2.取消a 节点的默认行为
                return false;
            }
        }
    </script>
</head>
<body>
<a href="helloAjax.txt"> HelloAjax</a>

</body>
</html>
