<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Información del Alumno</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        .container {
            width: 60%;
            margin: auto;
            margin-top: 20px;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        h2 {
            text-align: center;
        }
        .field {
            margin-bottom: 15px;
        }
        .label {
            font-weight: bold;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        table, th, td {
            border: 1px solid #ccc;
        }
        th, td {
            padding: 10px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>

<div class="container">
    <h2>Información del Alumno</h2>

    <s:if test="alumno != null">
        <div class="field">
            <span class="label">DNI:</span>
            <span><s:property value="alumno.dni"/></span>
        </div>
        <div class="field">
            <span class="label">Nombre:</span>
            <span><s:property value="alumno.nombre"/></span>
        </div>
        <div class="field">
            <span class="label">Apellido:</span>
            <span><s:property value="alumno.apellido"/></span>
        </div>
        <div class="field">
            <span class="label">Email:</span>
            <span><s:property value="alumno.email"/></span>
        </div>
        <div class="field">
            <span class="label">Teléfono:</span>
            <span><s:property value="alumno.telefono"/></span>
        </div>
        <div class="field">
            <span class="label">Dirección:</span>
            <span><s:property value="alumno.direccion"/></span>
        </div>
        <div class="field">
            <span class="label">Ciudad:</span>
            <span><s:property value="alumno.ciudad"/></span>
        </div>
        <div class="field">
            <span class="label">Provincia:</span>
            <span><s:property value="alumno.provincia"/></span>
        </div>
        <div class="field">
            <span class="label">Código Postal:</span>
            <span><s:property value="alumno.codigoPostal"/></span>
        </div>
        <div class="field">
            <span class="label">Fecha de Nacimiento:</span>
            <span><s:property value="alumno.fechaNacimiento"/></span>
        </div>
    </s:if>

    <s:else>
        <p>No se encontró información del alumno.</p>
    </s:else>

    <h2>Lista de Todos los Alumnos</h2>
   <s:if test="listaAlumnos != null && listaAlumnos.size() > 0">
       <table>
           <thead>
               <tr>
                   <th>DNI</th>
                   <th>Nombre</th>
                   <th>Apellido</th>
                   <th>Email</th>
                   <th>Teléfono</th>
                   <th>Dirección</th>
                   <th>Ciudad</th>
                   <th>Provincia</th>
                   <th>Código Postal</th>
                   <th>Fecha de Nacimiento</th>
               </tr>
           </thead>
           <tbody>
               <s:iterator value="listaAlumnos" var="alumno">
                   <tr>
                       <td><s:property value="#alumno.dni"/></td>
                       <td><s:property value="#alumno.nombre"/></td>
                       <td><s:property value="#alumno.apellido"/></td>
                       <td><s:property value="#alumno.email"/></td>
                       <td><s:property value="#alumno.telefono"/></td>
                       <td><s:property value="#alumno.direccion"/></td>
                       <td><s:property value="#alumno.ciudad"/></td>
                       <td><s:property value="#alumno.provincia"/></td>
                       <td><s:property value="#alumno.codigoPostal"/></td>
                       <td><s:property value="#alumno.fechaNacimiento"/></td>
                   </tr>
               </s:iterator>
           </tbody>
       </table>
   </s:if>


    <s:else>
        <p>No hay alumnos registrados.</p>
    </s:else>

    <br/>
    <h3><a href="index.jsp">Volver a la página principal</a></h3>
</div>

</body>
</html>
