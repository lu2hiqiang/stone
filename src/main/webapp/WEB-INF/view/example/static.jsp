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
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>孔雀石</title>
	<script type="text/javascript"
    src="<%=path%>/xheditor/jquery/jquery-1.4.4.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			initData();
		});
		
		function initData(){
			$.ajax({
				url : '<%=path%>/GoodsDescription/getDescription?goodsName=孔雀石',
				type : 'get',
				success : function(msg) {
					var data = msg.data.data;
					console.log("goodsDescription ===== " + data.goodsDescription);
					$('#content').html(data.goodsDescription);
				},
				error : function() {
				}
			});
		}
	</script>
  </head>
  
  <body>
    <div id="content" >
    </div>
  </body>
</html>
