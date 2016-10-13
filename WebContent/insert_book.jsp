<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增图书</title>
</head>
<body>
<h1>新增图书</h1>
<form action="addbook" method="post">
        ISBN编号：<input type="text" name="ISBN"/><br/>
		书名：<input type="text" name="Title"/><br/>
		作者编 号：<input type="text" name="AuthorID"/><br/>
		出版社：<input type="text" name="Publisher"/><br/>
		出版日期：<input type="text" name="PublishDate"/><br/>
		价格：<input type="text" name="Price"/><br/>
        <input type="submit" value="确认添加"/>

</form>



</body>
</html>