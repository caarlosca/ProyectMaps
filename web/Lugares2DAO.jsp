<%-- 
    Document   : Lugares2DAO
    Created on : 01-may-2017, 16:53:18
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
             
        

        <table border="2">
   
                <tr>
                    <td>Nombre  </td>
                    <td>Calle</td>
                    <td> Longitud</td>
                    <td> Latitud  </td>
                    
                </tr>
                  <s:iterator value="lugares">
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
