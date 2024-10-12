<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Formulario de Alumno</title>
</head>
<body>
<h1>Dar de alta un nuevo alumno</h1>
<s:form action="guardar" method="post">
    <s:textfield name="alumno.dni" label="DNI" required="true" />
    <s:textfield name="alumno.nombre" label="Nombre" required="true" />
    <s:textfield name="alumno.apellido" label="Apellido" required="true" />
    <s:textfield name="alumno.direccion" label="Dirección" />
    <s:textfield name="alumno.telefono" label="Teléfono" />
    <s:textfield name="alumno.email" label="Email" />
    <s:textfield name="alumno.ciudad" label="Ciudad" />
    <s:textfield name="alumno.provincia" label="Provincia" />
    <s:textfield name="alumno.codigoPostal" label="Código Postal" />
    <s:textfield name="fechaNacimiento" label="Fecha de Nacimiento (DD-MM-YYYY)" />
    <s:submit value="Guardar" />
</s:form>

<!-- Mensajes de error generales -->
<s:actionerror />

<!-- Errores por campo -->
<s:fielderror />

</body>
</html>
