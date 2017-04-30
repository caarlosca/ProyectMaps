<%-- 
    Document   : mostrarRuta
    Created on : 30-abr-2017, 14:26:10
    Author     : Gema
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        
        

        <table border="2">
          
                <tr>
                    <td>Tramo  </td>
                    <td>Tiempo</td>
                    <td> Distancia</td>
                    <td> Indicaciones  </td>
                    
                </tr>
                  <s:iterator value="ruta">
                <tr>
                    <td ><s:property value="tramo"/></td>
                    <td><s:property value="tiempo"/></td>
                    <td ><s:property value="distancia"/></td>
                    <td><s:property value="indicaciones"/></td>
                </tr>

                


</s:iterator>
</table>
    </body>
</html>
