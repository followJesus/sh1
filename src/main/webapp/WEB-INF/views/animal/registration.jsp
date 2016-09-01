<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<html>
 
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>添加动物</title>
 
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
 
    <h2>添加动物</h2>
  
    <form:form method="POST" modelAttribute="animal">
        <form:input type="hidden" path="id" id="id"/>
        <table>
            <tr>
                <td><label for="kind">种类: </label> </td>
                <td><form:input path="kind" id="kind"/></td>
                <td><form:errors path="kind" cssClass="error"/></td>
            </tr>
         
     
            <tr>
                <td colspan="3">
                    <c:choose>
                        <c:when test="${edit}">
                            <input type="submit" value="修改动物信息"/>
                        </c:when>
                        <c:otherwise>
                            <input type="submit" value="添加动物信息"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
        </table>
    </form:form>
    <br/>
    <br/>
    返回 <a href="<c:url value='/AnimalController/listAnimals' />">动物列表</a>
</body>
</html>