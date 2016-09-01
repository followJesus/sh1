<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登记确认页面</title>
<style>
    *{
  font-family:
Microsoft Yahei UI,Georgia,Serif;
  }
        
    </style>
</head>
<body>
    状态 : ${success}
    <br/>
    <br/>
    返回 <a href="<c:url value='/list' />">员工列表</a>
     
</body>
 
</html>