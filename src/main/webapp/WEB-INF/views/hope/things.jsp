<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>大学扩招</title>

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
    <h2>我最想做的事：</h2>  
    
    <table>
        <tr>
            <td>事情</td><td>级别</td><td>日期</td>
        </tr>
        <c:forEach items="${hopes}" var="hope">
            <tr>
            <td>${hope.thing}</td>
            <td>${hope.level}</td>
            <td>${hope.date}</td>
            </tr>
        </c:forEach>
    </table>
    <br/>
</body>
</html>