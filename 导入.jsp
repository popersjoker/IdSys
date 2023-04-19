<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>导入</title>
<style>
body{
color: antiquewhite;
}
</style>
</head>
<body>
<form action="${pageContext.request.contextPath}/daorudaochu?action=daoru" 
method="post" enctype="multipart/form-data">
<input type="file" name="file1"/>
<input type="submit" name="excel->mysql"/>
</form>
</body>
</html>