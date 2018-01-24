<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
response.setHeader("Pragma","No-cache");
response.setHeader("Cache-Control","no-cache");
response.setHeader("Cache-Control","no-store");
response.setDateHeader("Expires",0);
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
  <head>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>小石头网</title>
	<script type="text/javascript"
    src="<%=path%>/xheditor/jquery/jquery-1.4.4.min.js"></script>
	
	<%-- <link href="${path }/static/bootstrap-3.3.7-dist/css/bootstrap.min.css"
	rel="stylesheet">
	<script src="${path }/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script> --%>
	<script type="text/javascript">
	function conmitInfo(){
		console.log("conmitInfo======");
		$.ajax({
			url : '<%=path%>/GoodsDescription/getDescription?goodsName=孔雀石',
			type : 'get',
			success : function(msg) {
				console.log("msg =111== " + msg.data.date.goodsDescription);
				$('#content').html(msg.data.date.goodsDescription);
			},
			error : function() {
			}
		});
	}
	</script>
  </head>
  
  <body>
    path =  <%=path%><br>
    basePath = <%=basePath%><br>
     <br><br>
    <a class="btn btn-primary" target="" href="<%=path%>/example/static">直接传值跳转</a>
    <br><br>
    <a class="btn btn-primary" target="" href="<%=path%>/example/dynamic">动态传值跳转</a>
    <br><br>
    <input id="bnt_inp" type="button" onclick="conmitInfo()" value="孔雀石">
    <br><br><br><br>
    <div id="content" >
    </div>
  </body>
</html>
