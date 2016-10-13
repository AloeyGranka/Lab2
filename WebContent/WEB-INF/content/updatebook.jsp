<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="s" uri="/struts-tags" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>更新书本信息</title>
</head>
<body>
<form action="update" method="post">
        ISBN：<input type="text" name="ISBN"   value="${ISBN}"/><br/>
              Title ：<input readonly="readonly"  name="Title" value ="${Title}"/> <br/>
		AuthorID：<input type="text" name="AuthorID" value = "${AuthorID}"/><br/>
		Publisher：<input type="text" name="Publisher" value = "${Publisher}"/><br/>
        PublishDate：<input type="text" name="PublisherDate" value = "${PublishDate}"/><br/>
        Price：<input type="text" name="Price" value = "${Price}"/><br/>
          <input type="submit" value="确认更新"/>
</form>  
<!--<s:form action = "update"></s:form>-->
</body>
</html>