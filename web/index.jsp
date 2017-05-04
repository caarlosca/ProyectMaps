<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
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

            <title>Descubre Madrid</title>

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
                opacity: 0.8;

		position: absolute;

		

		top:75%;

		left:50%;

		

		width:400px;

		

		margin-left:-200px;

		

		height:350px;

		

		margin-top:-150px;

		border:1px solid #808080;

		padding:5px;

	
            }
        </style>    
            
        <body style="background-color:#4A7C59;">
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

                                    <li><a href="#contact">Contacto</a></li>

                                </ul>
                                <ul class="nav navbar-nav navbar-right">
                                    <li> <a href="http://localhost:8084/PruebaProyectoMaps/login.jsp">Acceso usuarios</a></li>
                                   

                                </ul>
                            </div><!--/.nav-collapse -->
                        </div>
                    </nav>
                </div>
            </div>

            <div id="myCarousel" class="carousel slide" data-ride="carousel">
                <!-- Indicators -->
                <ol class="carousel-indicators">
                    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                    <li data-target="#myCarousel" data-slide-to="1"></li>
                    <li data-target="#myCarousel" data-slide-to="2"></li>
                </ol>
                <div class="carousel-inner" role="listbox">
                    <div class="item active">
                        <img class="first-slide" src="images/Temple.jpg">
                        <div class="container">
                            <div class="carousel-caption">
                                <h1>GJC.</h1>
                                <p>MUEVETE POR LOS MEJORES LUGARES DE MADRID</p>

                            </div>
                        </div>
                    </div>
                    <div class="item">
                        
                     
                        <img class="second-slide" src="images/museo.jpg"> 
                        <div class="container">
                            <div class="carousel-caption">
                                <h1>GJC.</h1>
                                <p>ORGANIZA TU RUTA.</p>

                            </div>
                        </div>
                    </div>
                    <div class="item">
                        <img class="third-slide" src="images/Madrid1.jpg">
                        <div class="container">
                            <div class="carousel-caption">
                                <h1>GJC.</h1>
                                <p>DESCUBRE TUS POSIBILIDADES.</p>

                            </div>
                        </div>
                    </div>

                </div>
                <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
                    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                    <span class="sr-only">Previous</span>
                </a>
                <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
                    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                    <span class="sr-only">Next</span>
                </a>
            </div>   
            <div id="centrar">
            <s:form action="insertar" method="post" class="form-signin" width="400px" height="200px" align="center">
                <h2 class="form-signin-heading">REGISTRATE</h2>
                <hr>
                <label for="inputtext" class="sr-only" >Nombre:</label>
            <td><s:textfield cssClass="form-control" label="Nombre" name="nombre" placeholder="Nombre"/></td>
            <!--<td><s:property value="getFieldErrors().get('nombre')[0]"/> </td>-->
                        <tr><td><br> </td>  </tr>

            <label for="inputtext" class="sr-only" >Email</label>
            <s:textfield cssClass="form-control" label="Email" name="email" placeholder="Email"/>
            <!--<td><s:property value="getFieldErrors().get('email')[0]"/> </td>-->
                        <tr><td><br> </td>  </tr>

            <label for="inputPassword" class="sr-only">Password</label>
            
            <s:textfield cssClass="form-control"  label="Contrasena" name="contrasena" placeholder="Contraseña"/>
<!--            <td><s:property value="getFieldErrors().get('contrasena')[0]"/> </td>-->
           <table>
                           <tr><td><br> </td>  </tr>
                                       <tr><td><br> </td>  </tr>


                <tr>
                <td align="right"><input type="submit" class="transaction-type-toggler btn active btn-primary" value="insertar" name="insertar"></td>
                 
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


