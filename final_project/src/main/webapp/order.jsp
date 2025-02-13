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
<table class="order_table">
  <thead>
    <tr>
      <th scope="col">ID</th>
      <th scope="col">Booking number</th>
      <th scope="col">Customer name</th>
       <th scope="col">Address</th>
        <th scope="col">Telephone</th>
         <th scope="col">Destination</th>
          <th scope="col">Vehicle</th>
           <th scope="col">Amount</th>
    </tr>
  </thead>
  <tbody>
  
  <c:forEach var="cus" items="${cust}">
  <tr>
  <td>${cus.id}</td>
  <td>${cus.bookingNumber}</td>
  <td>${cus.customerName}</td>
  <td>${cus.address}</td>
  <td>${cus.telephone}</td>
  <td>${cus.destinationAddress}</td>
  <td>${cus.distance}</td>
  <td>${cus.vehicle}</td>
  <td>${cus.amount}</td>
 
    <td><form action=""method="post">
    <input type="hidden" name="name" value="${cus.id}">
    <button type="submit">add</button>
    </form></td>
    <td>
    <form action ="" method="post">
    <input type="hidden" name="name" value="${cus.id}">
    <button type="submit">delete</button>
    </form>
    </td>
  </tr>
  </c:forEach>
   
  </tbody>
</table>
</body>
</html>