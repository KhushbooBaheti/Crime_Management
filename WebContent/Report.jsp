<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>REGISTER REPORT</title>
</head>
<body>
<h2 align="center"> REGISTER YOUR COMPLAINT </h2>
<form action="Report" method="post">
CRIME TYPE:<input type="text" name="crimetype"><br><br>
CRIME LOCATION:<input type="text" name="crimelocation"><br><br>
CRIME DATE:<input type="date" name="crimedate"  data-date-inline-picker="true"><br><br>
CRIME TIME:<input type="time" name="crimetime"><br><br>
CRIME DESCRIPTION:<textarea align="left" rows="5" cols="100" name="crimedescription"> ENTER CRIME DETAILS HERE ...</textarea><br><br><br>
EVIDENCE:<br><br>
Evidence Type:<input type="text" name="evidencetype"><br><br>
<br>Evidence Description:<textarea rows="5" cols="50" name="description"> ENTER EVIDENCE DETAILS HERE ...</textarea><br><br>

<%-- 
Attachments:<br>
You can attach any image here <br>
<input type="file" accept="image/*" name="pic"><br><br>
You can attach a word file<br>
<input type="file" accept=".doc" name="textdoc"><br><br>
--%>
<input type="submit" value="submit">

</form>
</body>
</html>