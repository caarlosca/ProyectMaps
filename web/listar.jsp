
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Listado</h1>

        <table border="2">

            <th>
                Nombre
            </th>
            <th>
                Email
            </th>
            <th>
                Contraseña
            </th>
            <s:iterator value="list">
                <tr>
                    <td>
                        <s:property value="nombre"/>
                    </td>
                    <td>
                        <s:property value="email"/>
                    </td>
                    <td>
                        <s:property value="contrasena"/>
                    </td>
                </tr>
            </s:iterator>

        </table>

    </body>
</html>
