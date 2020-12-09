<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--   设置所有的a标签都没有下划线--%>
<style type="text/css">
    a {
        text-decoration: none;
    }

</style>
<br/>
<div id="page_nav">
    <%--   首页功能 --%>
    <a href="${requestScope.page.url}/1">首页</a>
    <%--    上一页，先判断是不是第一页，第一页，就没有上一页 --%>
    <c:if test="${ requestScope.page.pageNo > 1 }">
        <a href="${requestScope.page.url}/${ requestScope.page.pageNo - 1 }">上一页</a>
    </c:if>
    <c:choose>
        <%--        当当前页面数小于等于5时，显示所有的页面数--%>
        <c:when test="${requestScope.page.pageCount<=5}">
            <%--            设置页面的开始和结束为1和总的页面数--%>
            <c:set var="begin" value="1"></c:set>
            <c:set var="end" value="${requestScope.page.pageCount}"></c:set>
        </c:when>
        <%--        当当前页面数大于5时，显示所有页面其中的五（个数可以修改）个 分三种情况--%>
        <c:otherwise>
            <c:choose>
                <%--                当当前页面在前三个时--%>
                <c:when test="${requestScope.page.pageNo<=3}">
                    <c:set var="begin" value="1"></c:set>
                    <c:set var="end" value="5"></c:set>
                </c:when>
                <%--                当当前页面在后三个时--%>
                <c:when test="${requestScope.page.pageNo>=requestScope.page.pageCount-2}">
                    <c:set var="begin" value="${requestScope.page.pageCount-4}"></c:set>
                    <c:set var="end" value="${requestScope.page.pageCount}"></c:set>
                </c:when>
                <%--                当当前页面在中间时--%>
                <c:otherwise>
                    <c:set var="begin" value="${page.pageNo-2}"></c:set>
                    <c:set var="end" value="${page.pageNo+2}"></c:set>
                </c:otherwise>
            </c:choose>
        </c:otherwise>
    </c:choose>
    <%--    遍历显示页码数--%>
    <c:forEach begin="${begin}" end="${end}" var="i">
        <%--        如果页码数等于当前页码时不添加链接--%>
        <c:if test="${i==requestScope.page.pageNo}">
            <span style="color: #f50">【${i}】</span>
        </c:if>
        <%--        如果页码数不等于当前页码时添加链接--%>
        <c:if test="${i!=requestScope.page.pageNo}">
            <a href="${requestScope.page.url}/${i}">【${i}】</a>
        </c:if>
    </c:forEach>
    <%--     下一页，先判断是不是最后一页，最后一页，就没有下一页 --%>
    <c:if test="${ requestScope.page.pageNo < requestScope.page.pageCount }">
        <a href="${requestScope.page.url}/${ requestScope.page.pageNo + 1 }">下一页</a>
    </c:if>
    <%--     最后一页 --%>
    <a href="${requestScope.page.url}/${ requestScope.page.pageCount }">末页</a>
    共${ requestScope.page.pageCount }页，${ requestScope.page.pageTotal }条记录
        到第<input value="${requestScope.page.pageNo}" name="pn" id="pn_input" />页
    <input id="goToPage" type="button" value="确定">
</div>
<br/>
<%--引入jQuery 代码实现可以自定义跳转页面--%>
<script type="text/javascript">
    $(function () {
        $("#goToPage").click(function () {
            // 获得想要跳转的输入框的内用
            var inputContent = $("#pn_input").val();
            //进行正则匹配
            var inputContentReg = /^[0-9]*$/;
            if (!inputContentReg.test(inputContent)) {
                alert("输入的跳转格式不正确。请输入数字");
                return false;
            }
            //判断输入内容是否合法
            if (inputContent < 1) {
                inputContent = 1;
            } else if (inputContent >${requestScope.page.pageCount}) {
                inputContent =${requestScope.page.pageCount};
            }
            //设置浏览器的url地址
            location.href = "${requestScope.basePath}${requestScope.page.url}/" + inputContent;
        });

    })
</script>
