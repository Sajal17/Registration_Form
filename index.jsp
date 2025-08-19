<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>    
<html>
<head>
<title>Insert title</title>
</head>
<body>
<h2><%= "Welcome to Servlet"  %></h2>
<form action="register" method="post">
    Enter Id :<input type="text" name= "id"><br>
    Enter Name :<input type="text" name="sname"> <br>
    Enter Age :<input type="text" name="age"><br>
    <input type="Submit" value="Register">

</form>
<hr>
<h2>Update User</h2>
<form action="update" method="post">
        ID: <input type="text" name="id"><br>
        New Name: <input type="text" name="sname"><br>
        New Age: <input type="text" name="age"><br>
        <input type="submit" value="Update">
    </form>
    <hr>
    <h2>Delete User</h2>
    <form action="delete" method="post">
        ID: <input type="text" name="id"><br>
        <input type="submit" value="Delete">
    </form>
</body>
</html>
