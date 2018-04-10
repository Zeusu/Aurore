<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Aurore</title>
		<link type="text/css" rel="stylesheet" href="console.css"/>
	</head>
	<body>
	
		<main>
		
			<ul>
				<c:forEach items="${console_messages}" var="message" varStatus="boucle">
	         	   <li>${message}</li>
	    	    </c:forEach>
			</ul>
		
			<form>
			
				<input type="text" name="command" placeholder="Type command here"/>
			
			</form>
		
		</main>

	</body>
</html>