<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SignIn</title>
</head>
<body>
<form action="SignUp" method="post">
Name:<input type="text" name="name"/><br><br>

Contact Number:<input type="number" name="contactno"/><br><br>
Age:<input type="number" name="age"/><br><br>
Email:<input type="email" name="email"/><br><br>
Gender:
<input type="radio" name="gender" value="male" > Male<br>
  <input type="radio" name="gender" value="female"> Female<br>
    <br>
Category:<input type="text" name="category"/><br><br>
Address:<br>
plot:<input type="text" name="plot"/><br>
Landmark:<input type="text" name="landmark"/><br>
City:<input type="text" name="city"/><br>
State:<input type="text" name="state"/><br>
<input type="submit" value="submit"/>

</form>

</body>
</html>