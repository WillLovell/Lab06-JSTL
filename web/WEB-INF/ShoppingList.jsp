<%-- 
    Document   : user
    Created on : 30-Sep-2015, 9:31:54 PM
    Author     : awarsyle
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <form method="post" action="ShoppingList">
        <h1>Shopping List</h1>
        <h2>Hello, ${username_session} <a href="?logout">Logout</a></h2>
        <h1>List</h1>
        
            Add item: <input type="text" name="item" value="" /><input type="submit" value="Add" name="add"/>
        </form>
        
        <form method="post" action="ShoppingList" name="deleted">
<c:forEach var="Item" items="${ItemsList}">
<tr>    
<input type="radio" name="select" value="${Item.itemName}">
<td name="">${Item.itemName}</td><br>
<td>

</td>
</tr>
         
</c:forEach>
<input type="submit" name="delete" value="delete">        
</form>        
        
    </body>
</html>
