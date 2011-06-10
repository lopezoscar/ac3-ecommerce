<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import = "model.publicacion.Publicacion"
   %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel = "stylesheet"  type = "text/css" href = "http://localhost:8080/E-Commerce/global.css" />
<!-- 
<%
Publicacion publication = (Publicacion)session.getAttribute("publicacion");

%>

-->
<title><% publication.getTitulo();%></title>
</head>


<body>


<form action="compra" method = "post">
<ul>
	<li>Producto: <%=publication.getNombreProducto() %></li>
	<li>Precio: <%=String.valueOf(publication.getPrecio())%></li>
	<li>Categoria:<%= publication.getCategoria() %></li>
	<li>Medio de Pago: <%=publication.getMedioDePago() %></li>
	<li><input type = "submit" value= "Comprar"></li>
	<li><p><%=publication.getDescripcion() %></p></li>
</ul>
</form>

</body>
</html>