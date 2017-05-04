
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>

    <html lang="en">
        <head>
            <meta charset="utf-8">
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
               	

	        background: black;
                opacity: 0.9;

		position: absolute;

		

		top:50%;

		left:50%;

		

		width:400px;

		

		margin-left:-200px;

		

		height:300px;

		

		margin-top:-150px;

		border:1px solid #808080;

		padding:5px;

	
            }
        </style>    
            
        <body style="background-image: url('images/railroad.jpg');">
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
                                <a class="navbar-brand" href="#">Descubre Madrid</a>
                            </div>
                            <div id="navbar" class="navbar-collapse collapse">
                                <ul class="nav navbar-nav">
                                    <li class="active"><a href="">Home</a></li>

                                    <li><a href="#contact">Contacto</a></li>

                                </ul>
                                <ul class="nav navbar-nav navbar-right">
                                    
                                    <li> <a href="http://localhost:8084/PruebaProyectoMaps/mostrarRuta.jsp">Mostrar Ruta</a></li>
                                    <li> <a href="http://localhost:8084/PruebaProyectoMaps/muestraLugarjsp">Mostrar lugares</a></li>

                                </ul>
                            </div><!--/.nav-collapse -->
                        </div>
                    </nav>
                </div>
            </div>

            
            <div id="centrar">
            <s:form action="organizar" method="post" class="form-signin" width="400px" height="200px" align="center">
                <h2 class="form-signin-heading">ORGANIZAR RUTA</h2>
                <hr>
            <label for="inputtext" class="sr-only">Zona de Partida:</label>
            <td><s:textfield cssClass="form-control"  label="Zona de partida" name="zonaDePartida" placeholder="Zona de partida"/></td>
<!--            <td><s:property value="getFieldErrors().get('zonaDePartida')[0]"/> </td>-->
            <tr><td><br> </td>  </tr>
                
            <label for="inputPassword" class="sr-only">Kilometros:</label>
             <td><s:textfield cssClass="form-control" label="Kilometros" type="number" value="1" min="1" max="10" name="km"/></td>
                       
             <table>
                 <tr><td><br> </td>  </tr>
                <tr><td><br> </td>  </tr>
                <tr>
                <td align="right"><input type="submit" class="transaction-type-toggler btn active btn-primary" value="organizar" name="organizar"></td>
                 
                </tr>
            </table>
        </s:form>
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



	