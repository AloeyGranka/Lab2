<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="s" uri="/struts-tags" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看书库</title>
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
          <td><a href = '<s:url action = "display"><s:param name="Title" value ="title"/></s:url>'>
          <s:property value = "title"/></a></td>
          <td><s:property value="authorid"/></td>
          <td><s:property value="publisher"/></td>
          <td><s:property value="publish_date"/></td>
          <td><s:property value="price"/></td>
          
         <td>
          <form action="updateshow" method="post">
          <input type ="hidden" name="ISBN" value="${ISBN}">
          <input type ="hidden" name="Title" value="${title} ">
          <input type ="hidden" name="AuthorID" value="${authorid}">
          <input type ="hidden" name="Publisher" value="${publisher}">
          <input type ="hidden" name="PublishDate" value="${publish_date}">
          <input type ="hidden" name="Price" value="${price}">
          <input type="submit" value="更新"/>
          </form>  
         </td> 	
          <td>
          <form action="deletebook" method="post">
           <input type ="hidden" name="Title" value="${title} ">
           <input type="submit" value="删除"/>
          </form>  
         </td> 	
	</tr>
	</s:iterator>
    </table>
   
    
    
</body>
</html>