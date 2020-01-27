<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
 <title>Registro de Edificios</title>
</head>
<body>
 <center>
  <h1>Registro de Edificios</h1>
        <h2>
         <a href="new">Añadir Nuevo Edificio</a>
         &nbsp;&nbsp;&nbsp;
         <a href="list">Lista de Todos los Edificios</a>
         
        </h2>
 </center>
    <div align="center">
  <c:if test="${edificio != null}">
   <form action="update" method="post">
        </c:if>
        <c:if test="${edificio == null}">
   <form action="insert" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
             <h2>
              <c:if test="${edificio != null}">
               Editar Edificio
              </c:if>
              <c:if test="${edificio == null}">
               Añadir nuevo edificio
              </c:if>
             </h2>
            </caption>
          <c:if test="${edificio != null}">
           <input type="hidden" name="id" value="<c:out value='${edificio.id}' />" />
          </c:if>            
            <tr>
                <th>Nombre del Edificio: </th>
                <td>
                 <input type="text" name="nombre" size="45"
                   value="<c:out value='${edificio.nombre}' />"
                  />
                </td>
            </tr>
            <tr>
                <th>Cantidad de Pisos: </th>
                <td>
                 <input type="text" name="cantidadPisos" size="45"
                   value="<c:out value='${edificio.cantidadPisos}' />"
                 />
                </td>
            </tr>
            <tr>
                <th>Altura: </th>
                <td>
                 <input type="text" name="altura" size="45"
                   value="<c:out value='${edificio.altura}' />"
                 />
                </td>
            </tr>
            <tr>
                <th>Direccion: </th>
                <td>
                 <input type="text" name="direccion" size="45"
                   value="<c:out value='${edificio.direccion}' />"
                 />
                </td>
            </tr>
            <tr>
             <td colspan="2" align="center">
              <input type="submit" value="Save" />
             </td>
            </tr>
        </table>
        </form>
    </div> 
</body>
</html>