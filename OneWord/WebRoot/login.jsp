<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   	<base href="<%=basePath%>">
    <title>登录</title>
	
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    
    <link rel="stylesheet" type="text/css" href="css/login.css">

  </head>
  
  <body>
    <form class="loginPage" action="login" method="post">
    	<fieldset>
    		<legend>LoginSystem</legend>
    		<p>
    			<label>username：</label><input type="text" name="username"></input>
    		</p>
    		<p>
    			<label>password：</label><input type="password" name="password"></input>
    		</p>
    		<p>
    			<input type="reset" value="reset"></input>
    			<input type="submit" value="submit" value="login">
    		</p>
    	</fieldset>
    </form>
  </body>
</html>
