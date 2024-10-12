<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <title>Gestión de Alumnos</title>
</head>
<body>
<h1>Gestión de Alumnos</h1>
<form action="buscarAlumno" method="post">
    <label for="dni">DNI:</label>
    <input type="text" name="dni" id="dni" required />

    <input type="submit" value="Buscar Alumno" />
</form>
<a href="alumnoForm">Dar de alta un nuevo alumno</a>

<%-- Mostrar mensaje de error en un h1 si existe --%>
<s:if test="hasActionErrors()">
      <h3 style="color:red;">
            <s:actionerror />
        </h3>
</s:if>
</body>
</html>
