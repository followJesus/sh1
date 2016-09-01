<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<html>
 
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>学生登记表</title>
 
<style>

*{
  font-family:
Microsoft Yahei UI,Georgia,Serif;
  }
    .error {
        color: #ff0000;
    }
  label {display:block;  text-align:right;}
   
</style>
 
</head>
 
<body>
 
    <h2>登记新学生</h2>
  
    <form:form method="POST" modelAttribute="studentInfo">
        <form:input type="hidden" path="id" id="id"/>
        <table>
            <tr>
                <td><label for="name">姓名: </label> </td>
                <td><form:input path="name" id="name"/></td>
                <td><form:errors path="name" cssClass="error"/></td>
            </tr>
         
            <tr>
                <td><label for="joiningDate">录入日期: </label> </td>
                <td><form:input path="joiningDate" id="joiningDate"/></td>
                <td><form:errors path="joiningDate" cssClass="error"/></td>
            </tr>
     
            <tr>
                <td><label for="sex">性别: </label> </td>
                <td><form:input path="sex" id="sex"/></td>
                <td><form:errors path="sex" cssClass="error"/></td>
            </tr>
     
            <tr>
                <td><label for="age">年龄: </label> </td>
                <td><form:input path="age" id="age"/></td>
                <td><form:errors path="age" cssClass="error"/></td>
            </tr>
     
            <tr>
                <td colspan="3">
                    <c:choose>
                        <c:when test="${edit}">
                            <input type="submit" value="修改学生信息"/>
                        </c:when>
                        <c:otherwise>
                            <input type="submit" value="登记学生信息"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
        </table>
    </form:form>
    <br/>
    <br/>
    返回 <a href="<c:url value='/stc/list' />">学生列表</a>
</body>
</html>