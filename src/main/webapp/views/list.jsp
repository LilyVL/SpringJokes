<%@ page language='java' contentType='text/html; charset=UTF-8'
    pageEncoding='UTF-8'%>
<!DOCTYPE html PUBLIC '-//W3C//DTD HTML 4.01 Transitional//EN' 'http://www.w3.org/TR/html4/loose.dtd'>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<html>
<head>
<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>

<link rel='stylesheet' href='/resources/css/bootstrap.min.css'>

<title>Previous Jokes:</title>
</head>

<body>

<div class='well'>
<h1>Previous Jokes</h1>
<br/><br/>
<table  class='table'>
	<tr>
		<th>Joke</th>
	</tr>
	<c:if test='${not empty jokes}'>
		<c:forEach var='joke' items='${jokes}'>
			<tr><td>${joke.joke}</td></tr>
		</c:forEach>
	</c:if>
</table>

<br/><br/>
<a href='/'>Ridicule more people!</a>
</div>

</body>
</html>

