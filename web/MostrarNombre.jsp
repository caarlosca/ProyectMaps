

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        
        <img src="<s:property></s:property>" alt="no encuentra la imagen"/>

        <table border="2">
                      <th><s:property value="imagenRuta"/></th>
             <th colspan="4">Zona de busqueda <s:property value="imagenRuta"/></th>
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
    <center><img src="foto\saved1.png" alt="no encuentra la imagen" width="50%" height="80%"/></center>

    </body>
</html>