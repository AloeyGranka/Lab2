<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>新增作者</h1>

检测到是新作者，请完成作者信息！
<form action="addauthor" method="post">
               姓名：<input type="text" name="name"/><br/>
		作者编号：<input type="text" name="AuthorID" value = value ="${AuthorID}"><br/>
		年龄：<input type="text" name="age"/><br/>
		国籍：<input type="text" name="country"/><br/>
        <input type="submit" value="确认添加"/>

</form>
</body>
</html>