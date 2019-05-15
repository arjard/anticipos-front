<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title></title>
    <link href="../resources/css/jquery-ui.min.css" rel="stylesheet" id="jquery-ui">
    <link href="../resources/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <link href="../resources/css/jquery.dataTables.min.css" rel="stylesheet">
    <link href="../resources/css/style_formulario_anticipo.css" rel="stylesheet">


  </head>
  <body>
    <div class="main container">
      <div class="row">
        <div class="col-md-12">
        <div class="form_main">
                    <img src="../resources/images/logo3.png" alt="palacio de hierro" width="200px">
                    <h4 class="heading"><strong>ANTICIPOS </strong> <span></span></h4>
      <table id="tablaAnticipos" class="hover stripe cell-border order-column" style="width:100%">
        <thead>
            <tr>
                <th>Tienda</th>
                <th>Folio anticipo</th>
                <th>Fecha</th>
                <th>Terminal</th>
                <th>Operacion</th>
                <th>Importe</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach items="${listadoAnticipos}" var="anticipo">
        	  <tr>
                <td>${anticipo.tienda}</td>
                <td>${anticipo.folio}</td>
                <td>${anticipo.fecha}</td>
                <td>${anticipo.terminal}</td>
                <td>${anticipo.operacion}</td>
                <td>${anticipo.monto}</td>
            </tr>
        </c:forEach>
        </tbody>
        <tfoot>
            <tr>
              <th>Tienda</th>
              <th>Folio anticipo</th>
              <th>Fecha</th>
              <th>Terminal</th>
              <th>Operacion</th>
              <th>Importe</th>
            </tr>
        </tfoot>
    </table>


                </div>
              </div>
      </div>
    </div>

    <script src="../resources/js/jquery-3.4.1.min.js"></script>
    <script src="../resources/js/bootstrap.min.js"></script>
    <script src="../resources/js/jquery.dataTables.min.js"></script>
    <!-- <script src="../resources/js/dataTables.bootstrap.min.js"></script> -->
    <script src="../resources/js/jquery-ui.min.js"></script>
    <script src="../resources/js/tableAnticipos.js"></script>

  </body>
</html>