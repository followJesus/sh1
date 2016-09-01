<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<html>
 
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>员工登记表</title>
 
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
 
    <h2>登记新员工</h2>
  
    <form:form method="POST" modelAttribute="employee">
        <form:input type="hidden" path="id" id="id"/>
        <table>
            <tr>
                <td><label for="name">姓名: </label> </td>
                <td><form:input path="name" id="name"/></td>
                <td><form:errors path="name" cssClass="error"/></td>
            </tr>
         
            <tr>
                <td><label for="joiningDate">入职日期: </label> </td>
                <td><form:input path="joiningDate" id="joiningDate"/></td>
                <td><form:errors path="joiningDate" cssClass="error"/></td>
            </tr>
     
            <tr>
                <td><label for="salary">薪金: </label> </td>
                <td><form:input path="salary" id="salary"/></td>
                <td><form:errors path="salary" cssClass="error"/></td>
            </tr>
     
            <tr>
                <td><label for="ssn">身份证号码: </label> </td>
                <td><form:input path="ssn" id="ssn"/></td>
                <td><form:errors path="ssn" cssClass="error"/></td>
            </tr>
     
            <tr>
                <td colspan="3">
                    <c:choose>
                        <c:when test="${edit}">
                            <input type="submit" value="修改员工信息"/>
                        </c:when>
                        <c:otherwise>
                            <input type="submit" value="登记员工信息"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
        </table>
    </form:form>
    <br/>
    <br/>
    返回 <a href="<c:url value='/list' />">员工列表</a>
</body>
</html>