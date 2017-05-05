
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>

<html lang="en">
    <head>

        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="icon" href="bootstrap-3.3.6/docs/favicon.ico">

        <title>Descubre España</title>

        <!-- Bootstrap core CSS -->
        <link href="bootstrap-3.3.6/dist/css/bootstrap.min.css" rel="stylesheet">

        <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
        <link href="bootstrap-sass-3.3.6/assets/css/ie10-viewport-bug-workaround.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="navbar-static-top.css" rel="stylesheet">

        <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
        <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
        <script src="bootstrap-sass-3.3.6/assets/js/ie-emulation-modes-warning.js"></script>

        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
        <!-- Custom styles for this template -->
        <link href="bootstrap-3.3.6/docs/examples/carousel/carousel.css" rel="stylesheet">
        <link href="style.css" rel="stylesheet">

    </head>
    <style>
        #centrar{




            position: absolute;


            font-size: 5%;
            top:27%;

            left:45%;



            width:1125px;



            margin-left:-500px;



            height:500px;



            margin-top:-150px;



            padding:5px;


        }
        #tamano{

            width:1px;
            font-size: 70%;
        }

        #tamano1{
            background: silver;
            opacity: 0.99;
        }

        #imagen{

            padding-top: 8%;
            padding-left: 35%;
            width: 1450px;
        }
    </style>    

    <body style="background-color: #4A7C59;">
        <div class="navbar-wrapper">
            <div class="container">
                <!-- Static navbar -->
                <nav class="navbar navbar-default navbar-static-top">
                    <div class="container">
                        <div class="navbar-header">
                            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                                <span class="sr-only">Toggle navigation</span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                            </button>
                            <a class="navbar-brand" >Descubre España</a>
                        </div>
                        <div id="navbar" class="navbar-collapse collapse">
                            <ul class="nav navbar-nav">
                                <li class="active"><a href="http://localhost:8084/PruebaProyectoMaps/index.jsp">Home</a></li>

                                <li><a href="http://localhost:8084/PruebaProyectoMaps/contacto.jsp">Contacta</a></li>

                            </ul>
                            <ul class="nav navbar-nav navbar-right">

                                
                            </ul>
                        </div><!--/.nav-collapse -->
                    </div>
                </nav>
            </div>
        </div>

        <div id="centrar">
            <table class="table table-striped"  id="tamano1">


                <th colspan="5">Zona de busqueda <s:property value="zonaDePartida"/></th>
                <tr>

                    <th>Nombre  </th>
                    <th>Calle</td>
                    <th> Longitud</th>
                    <th> Latitud  </th>


                </tr>
                <s:iterator value="lugares2" >
                    <tr id="tamano">

                        <td > <h4>  <s:a href="%{nombreee}"><s:property value="nombre"/> </s:a>   </h4>  </td>
                        <td><s:property value="calle"/></td>
                        <td ><s:property value="longitud"/></td>
                        <td><s:property value="latitud"/></td>
                        <td>
                            <s:url id="nombreee" action="CrearRuta">
                                <s:param name="NombreLugar"><s:property value="nombre"/></s:param>
                                <s:param name="NombreSalida"><s:property value="zonaDePartida"/></s:param>
                                <s:param name="longitud2"><s:property value="longitud"/></s:param>
                                <s:param name="latitud2"><s:property value="latitud"/></s:param>
                            </s:url>
                            <s:a href="%{nombreee}">
                                <s:text name="Seleciona un lugar" />
                            </s:a> 
                            </h5>
                        </td>
                    </tr>
                </s:iterator>
            </table>
        </div>    


        <!-- Bootstrap core JavaScript
       ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script>window.jQuery || document.write('<script src="bootstrap-sass-3.3.6/assets/js/vendor/jquery.min.js"><\/script>')</script>
        <script src="bootstrap-3.3.6/dist/js/bootstrap.min.js"></script>
        <!-- Just to make our placeholder images work. Don't actually copy the next line! -->
        <script src="bootstrap-sass-3.3.6/assets/js/vendor/holder.min.js"></script>
        <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
        <script src="bootstrap-sass-3.3.6/assets/js/ie10-viewport-bug-workaround.js"></script>
    </body>
</html>
