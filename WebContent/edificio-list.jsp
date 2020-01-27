<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
 <title>Registro de Edificios</title>
</head>
<body>
 <center>
  <h1>Registros de Edificios</h1>
        <h2>
           <a href="new">Añadir Nuevo Edificio</a>
         &nbsp;&nbsp;&nbsp;
         <a href="list">Lista de Todos los Edificios</a>
        </h2>
 </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>Lista de Edificios</h2></caption>
            <tr>
                <th>ID</th>
                <th>Nombre</th>
                <th>Cantidad de pisos</th>
                <th>Altura</th>
                <th>Direccion</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="edificio" items="${listEdificio}">
                <tr>
                    <td><c:out value="${edificio.id}" /></td>
                    <td><c:out value="${edificio.nombre}" /></td>
                    <td><c:out value="${edificio.cantidadPisos}" /></td>
                    <td><c:out value="${edificio.altura}" /></td>
                    <td><c:out value="${edificio.direccion}" /></td>
                    <td>
                     <a href="edit?id=<c:out value='${edificio.id}' />">Edit</a>
                     &nbsp;&nbsp;&nbsp;&nbsp;
                     <a href="delete?id=<c:out value='${edificio.id}' />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div> 
</body>
</html>