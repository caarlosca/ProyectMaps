
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table border="2">
            
          
            <th colspan="4">Zona de busqueda <s:property value="zonaDePartida"/></th>
            <tr>

                <th>Nombre  </th>
                <th>Calle</td>
                <th> Longitud</th>
                <th> Latitud  </th>

            </tr>
            <s:iterator value="lugares2">
                <tr>
                    <td ><s:property value="nombre"/></td>
                    <td><s:property value="calle"/></td>
                    <td ><s:property value="longitud"/></td>
                    <td><s:property value="latitud"/></td>
                </tr>
            </s:iterator>
        </table>
    </body>
</html>
