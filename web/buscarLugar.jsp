<%-- 
    Document   : organizarRuta
    Created on : 26-abr-2017, 11:57:16
    Author     : Curso Mañana
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
                   <s:form action="oragnizar"  theme="simple">
                <table id="tabla">
                    
                    

                    <tr> 
                        
                        <td colspan="3" align="center"><h2><b>Organizar Ruta: </b></h2></td>
                    </tr>
        
                    <tr>
                        <td>Fecha</td>
                        <td><s:textfield cssClass="fecha" label="fecha" type="date" name="fecha" /></td>
                      

                    </tr>
                    <tr>
                        <td>Zona de Partida: </td>
                        <td><s:textfield cssClass="zonapartida" label="zonapartida" name="zonaDePartida"/></td>
                        
                    </tr>
                    <tr>
                        <td>KM: </td>
                        <td><s:textfield cssClass="km" label="km" type="number" value="1" min="1" max="10" name="km"/></td>
                        
                    </tr>
                    <tr>
                        <td colspan="2"><s:submit value="oragnizar"/></td>              
                    </tr>
                    <tr>
                    
                    </tr>

                </table>
            </s:form>
    </body>
</html>
