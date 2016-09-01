<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>动物园</title>

	<link rel="stylesheet" type="text/css" href="/index.css"></link>


    <style>
    *{
  font-family:
Microsoft Yahei UI,Georgia,Serif;
  }
        tr:first-child{
           /*  font-weight: bold; */
            background-color: #C6C9C4;
            text-align:center;
            
        }
         td{
    padding-left:0.5rem;
    padding-right:0.5rem;
    }
    </style>
 
</head>
 
 
<body>
    <h2>动物列表 </h2>  
    <table>
        <tr>
            <td>编号</td><td>种类</td><td>操作</td>
        </tr>
        <c:forEach items="${animals}" var="animal">
            <tr>
            <td>${animal.id}</td>
            <td><a href="<c:url value='/AnimalController/edit-${animal.id}-animal' />">${animal.kind}</a></td>
            <td><a href="<c:url value='/AnimalController/delete-${animal.id}-animal' />">删除</a></td>
            </tr>
        </c:forEach>
    </table>
    <br/>
    <a href="<c:url value='/AnimalController/new' />">登记</a>
</body>
</html>