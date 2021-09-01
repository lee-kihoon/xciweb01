<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
request.setCharacterEncoding("UTF-8");
String name = request.getParameter("name");
%>
    
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
    <h2> 그래, 난 <%=name %>. 포기를 모르는 남자지</h2>
</body>

</html>
