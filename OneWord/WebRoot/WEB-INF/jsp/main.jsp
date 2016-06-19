<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">

    <title>主页</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!-- 自动跳转 -->
	<!-- <meta http-equiv="Refresh" content="2;URL=http://localhost:8080/OneWrod"> -->
	<meta http-equiv="windows-Target" contect="_top">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
       <h3>主页</h3> <br>
       <span>你好，${username}</span>
       <input class="ajaxButton" type="button" value="ajax测试" >
      	userId:<input class="userId" type="text" />
       <input class="deferredButton" type="button" value="deferred测试" >
       <br/>
       <br/>
       <form class="fileUpload" enctype="multipart/form-data" action="fileUpload" method="post">
    	<fieldset>
    	<legend>fileUpload</legend>
    		<input type="text" name="name" multiple="multiple" />
	    	<p>select a file<input type="file" name="images" multiple="multiple" /></p>
	    	<p><input type="submit" value="upload" /></p>
    	</fieldset>
    	</form>
    	<br/>
    	<br/>
    	<input class="download" type="button" value="download" />
  </body>
  <script type="text/javascript" src="script/jquery-1.10.2.js"></script>
  <script type="text/javascript">
  	//websocket通信开启与回调
  	/*
  	var ws = new WebSocket("ws://localhost:8080/OneWrod/websocket");
  	ws.onopen=function(){ws.send("Test!");};
  	ws.opmessage = function(evt){console.log(evt.data); ws.close();};
  	ws.onclose = function(evt){console.log("WebSocketClosed!");};
  	ws.onerror = function(evt){console.log("WebSocketError!");};
  	*/
  
  	$(document).ready(
  		function(){
  			//alert("jquery加载！");
  			$(".ajaxButton").bind(
  				"click",
  				function(){
  					$.ajax(
  					{
  						type:"post",
  						url:"getUser",
  						dataType:"json",
  						beforeSend:function(){
  							alert("开启AJAX获取数据！");
  						},
  						success:function(data){
  							alert("获取数据成功："+data);
  						},
  						error:function(){
  							alert("获取数据失败");
  						},
  						complete:function(){
  							
  						}
  					}  					
  					);
  				}
  			);
  			
  			
  			$(".deferredButton").bind(
  				"click",
  				function(){
  					var userId = $(".userId").val();
  					$.when(
  						$.ajax(
	  					{
	  						type:"post",
	  						url:"deferred",
	  						data:"userId="+userId,
	  						dataType:"json",
	  						beforeSend:function(){
	  							
	  						},
	  						success:function(data){
	  							alert("deffered获取数据成功："+data.username);
	  						},
	  						error:function(){
	  							alert("获取数据失败");
	  						},
	  						complete:function(){
	  							
	  						}
	  					}  				
  						),
  						$.ajax(
	  					{
	  						type:"post",
	  						url:"getUser",
	  						data:"userId="+userId,
	  						dataType:"json",
	  						beforeSend:function(){
	  						
	  						},
	  						success:function(data){
	  							alert("getUser获取数据成功："+data);
	  						},
	  						error:function(){
	  							alert("获取数据失败");
	  						},
	  						complete:function(){
	  							
	  						}
	  					}  				
  						)

  					)
  					.done(
  						function(){ alert("哈哈，ajax方法成功了！");} 
  					).fail(
  						function(){ alert("出错啦！"); } 
  					).done(
  						function(){ alert("第二个回调函数！");} 

  					);
  					
  					
  				}
  			);
  			
  			//文件下载练习
  			$(".download").bind(
  				"click",
  				function(){
  				/*
  					$.ajax(
  					{
  						type:"post",
  						url:"download",
  						dataType:"json",
  						beforeSend:function(){
  							alert("开启AJAX获取数据！");
  						},
  						success:function(data){
  							alert("下载文件成功："+data);
  						},
  						error:function(){
  							alert("下载文件失败");
  						},
  						complete:function(){
  							
  						}
  					}  					
  					);
  				*/
  				
  					window.location.href="download";
  				
  				}
  			);
  		}
  	);
  </script>
</html>
