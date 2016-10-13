<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="s" uri="/struts-tags" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>作者著作信息</title>
</head>
<body>
<table width="600" border="1">
	<tr>
          <th>ISBN</th>
          <th>Title</th>
          <th>AuthorID</th>
          <th>Publisher</th>
          <th>PublishDate</th>
          <th>Price</th>  	
	</tr>
	<s:iterator value="Books">
	<tr>
          <td><s:property value="ISBN"/></td>
          <td><s:property value="Title"/></td>
          <td><s:property value="AuthorID"/></td>
          <td><s:property value="Publisher"/></td>
          <td><s:property value="Publish_date"/></td>
          <td><s:property value="Price"/></td>     	
	</tr>
	</s:iterator>

</table>
</body>
</html>