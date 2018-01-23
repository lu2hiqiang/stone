<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>石头详情录入</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<link rel="stylesheet" href="<%=path%>/xheditor/common.css"
    type="text/css" media="screen" />
<script type="text/javascript"
    src="<%=path%>/xheditor/jquery/jquery-1.4.4.min.js"></script>
<script type="text/javascript"
    src="<%=path%>/xheditor/xheditor-1.1.14-zh-cn.min.js"></script>
<script type="text/javascript">
    $(document)
            .ready(
                    function() {
                        //初始化xhEditor编辑器插件  
                        $('#xh_editor').xheditor({
                            tools : 'mfull',
                            skin : 'o2007blue',
                            upMultiple : true,
                            upImgUrl : "servlet/UploadFileServlet",
                            upImgExt : "jpg,jpeg,gif,bmp,png",
                            upFlashUrl : "servlet/UploadSwfServlet",
                            upFlashExt : "swf",
                            upMediaUrl : "servlet/UploadMediaServlet",
                            upMediaExt : "wmv,avi,wma,mp3,mid",
                            onUpload : insertUpload,
                            html5Upload : false
                        });
                        //xbhEditor编辑器图片上传回调函数  
                        function insertUpload(msg) {
                            var _msg = msg.toString();
                            console.log("_msg ======> " + _msg);
                            var _picture_name = _msg.substring(_msg
                                    .lastIndexOf("/") + 1);
                            ///20150522/67c5f73e-5617-4fa0-a404-b3c2bdb1b01c.jpg
                            var _picture_path = Substring(_msg);
                            var _str = "<input type='checkbox' name='_pictures' value='"+_picture_path+"' checked='checked' onclick='return false'/><label>"
                                    + _picture_name + "</label><br/>";
                            $("#xh_editor").append(_msg);
                            $("#uploadList").append(_str);
                        }
                        //处理服务器返回到回调函数的字符串内容,格式是JSON的数据格式.  
                        function Substring(s) {
                            return s.substring(s.substring(0,
                                    s.lastIndexOf("/")).lastIndexOf("/"),
                                    s.length);
                        }
                    });
</script>
</head>

<body>
    <form action="<%=path%>/XhEditorController/xhEditorSubmit" method="post">
        <div>
           材料名称：<input type="text" name="name" />
           
            <textarea id="xh_editor" name="contents" rows="25"
                style="width: 100%; border: 1px"></textarea>
        </div>
        <div id="uploadList"></div>
        <br /> <input type="submit" value="提交" name="submit" /> <input
            type="reset" value="重置" name="reset" />
    </form>
</body>
</html>
