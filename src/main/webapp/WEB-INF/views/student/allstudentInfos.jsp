<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>学生列表</title>
 
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
    <h2>学生列表</h2>  
    <table>
        <tr>
            <td>姓名</td><td>入职日期</td><td>性别</td><td>年龄</td><td>学号</td><td>操作</td>
        </tr>
        <c:forEach items="${studentInfos}" var="studentInfo">
            <tr>
            <td>${studentInfo.name}</td>
            <td>${studentInfo.joiningDate}</td>
            <td>${studentInfo.sex}</td>
            <td>${studentInfo.age}</td>
            <td><a href="<c:url value='/stc/edit-${studentInfo.id}-studentInfo' />">${studentInfo.id}</a></td>
            <td><a href="<c:url value='/stc/delete-${studentInfo.id}-studentInfo' />">删除</a></td>
            </tr>
        </c:forEach>
    </table>
    <br/>
    <a href="<c:url value='/stc/new' />">登记</a>
</body>
</html>