<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table class="vehicle_tb">
  <thead>
    <tr>
      <th scope="col">plate</th>
      <th scope="col">brand</th>
      <th scope="col">model</th>
      <th scope="col">color</th>
       <th scope="col">engine</th>
       <th scope="col">chasi</th>
       <th scope="col">name</th>
       <th scope="col">email</th>
       <th scope="col">phone</th>
       <th scope="col">idnum</th>
       <th scope="col">provider</th>
       <th scope="col">policy</th>
       <th scope="col">expire</th>
    </tr>
  </thead>
  <tbody>
  
  <c:forEach var="cus" items="${cust}">
  <tr>
  <td>${cus.plate}</td>
  <td>${cus.brand}</td>
  <td>${cus.model}</td>
  <td>${cus.color}</td>
  <td>${cus.angine}</td>
  <td>${cus.chasi}</td>
  <td>${cus.name}</td>
  <td>${cus.email}</td>
  <td>${cus.phone}</td>
  <td>${cus.idnum}</td>
  <td>${cus.provider}</td>
  <td>${cus.policy}</td>
  <td>${cus.expire}</td>
  
 
    <td><form action=""method="post">
    <input type="hidden" name="name" value="${cus.plate}">
    <button type="submit">add</button>
    </form></td>
    <td>
    <form action ="" method="post">
    <input type="hidden" name="name" value="${cus.plate}">
    <button type="submit">delete</button>
    </form>
    </td>
  </tr>
  </c:forEach>
   
  </tbody>
</table>
</body>
</html>