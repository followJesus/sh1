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
    <h2>员工列表 <c:out value="${pageContext.request.contextPath}"/> <%=request.getContextPath() %></h2>  
    
    <table>
        <tr>
            <td>姓名</td><td>入职日期</td><td>薪金</td><td>身份证号码</td><td>操作</td>
        </tr>
        <c:forEach items="${employees}" var="employee">
            <tr>
            <td>${employee.name}</td>
            <td>${employee.joiningDate}</td>
            <td>${employee.salary}</td>
            <td><a href="<c:url value='/edit-${employee.ssn}-employee' />">${employee.ssn}</a></td>
            <td><a href="<c:url value='/delete-${employee.ssn}-employee' />">删除</a></td>
            </tr>
        </c:forEach>
    </table>
    <br/>
    <a href="<c:url value='/new' />">登记</a>
     <br/>
      <br/>图片在这里
      <br/>
      <br/>
    <img src="<%=request.getContextPath() %>/img/p1.png" width="150px" height="150px"/>
    
</body>
</html>