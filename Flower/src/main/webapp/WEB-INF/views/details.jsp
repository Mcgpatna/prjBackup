<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Flower Maintenance Page</title>
    <style type="text/css">
        .tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
        .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
        .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
        .tg .tg-4eph{background-color:#f9f9f9}
    </style>
</head>
<body>


<h1>
    Details of a    Product 
</h1>
 
 


    
<table border="2">
<tr >
 <td rowspan=6>
   Picture
 </td>
 <th> Product Id</th>
  <td> <c:out value="${products.id}"/></td>
</tr>
<tr>
 <th>Product Name</th>
 <td><c:out value="${products.name}"/></td>
</tr>
<tr>
 <th>Description</th>
 <td><c:out value="${products.description}"/></td>
</tr>
<tr>
 <th>Category</th>
 <td><c:out value="${products.category}"/></td>
</tr>
<tr>
 <th>Price</th>
 <td><c:out value="${products.price}"/></td>
</tr>
<tr>
 <th>Statuc</th>
 <td><c:out value="${products.statuc}"/></td>
</tr>

    
    
   
</table>  
