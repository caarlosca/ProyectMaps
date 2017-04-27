
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <style>
        #fondo{
            background-color: 
                #0077BE;
        }
        .campo{
            font-size: 12px;
            font-weight: bold;
            background-color:cyan; 
            
        }
        
        #tabla{
            background-color:beige;
        }
        
        #centrar
        {
                position: absolute;
                /*nos posicionamos en el centro del navegador*/
                top:50%;
                left:50%;
                /*determinamos una anchura*/
                width:700px;
                /*indicamos que el margen izquierdo, es la mitad de la anchura*/
                margin-left:-400px;
                /*determinamos una altura*/
		
                /*indicamos que el margen superior, es la mitad de la altura*/
                margin-top:-150px;
		
                padding:5px;
        }
    </style>
    <body id="fondo" >



        <div class="error">
            <s:fielderror/>
        </div>
        <div id="centrar">
            <s:form action="acceso"  theme="simple">
                <table id="tabla">
                    <tr> 
                        <td colspan="3" align="center"><h2><b>INGRESAR:</b></h2></td>
                    </tr>
        
                    <tr>
                        <td>Email:</td>
                        <td><s:textfield cssClass="campo" label="Email" name="email"/></td>
                        <td><s:property value="getFieldErrors().get('persona.email')[0]"/> </td>

                    </tr>
                    <tr>
                        <td>Contraseña:</td>
                        <td><s:textfield cssClass="campo" label="Contrasena" name="contrasena"/></td>
                        <td><s:property value="getFieldErrors().get('persona.contrasena')[0]"/> </td>
                    </tr>
                    <tr>
                        <td colspan="2"><s:submit value="acceso"/></td>
                        <td><a href="http://localhost:8084/PruebaProyectoMaps/mostrar"> mostrar </a></td>                 
                    </tr>
                    <tr>
                    
                    </tr>

                </table>
            </s:form>
        </div>
    </body>
</html>
