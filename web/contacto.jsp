<%-- 
    Document   : contacto
    Created on : 05-may-2017, 0:00:26
    Author     : Carlos
--%>
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
           body{
    font-family: 'Open Sans', sans-serif;
    color:#444;}

.container{
    padding:0 100px;}

.one-column-text{
    padding:80px 130px;}

.one-column-text h2{
    font-size:42px;
    font-weight:300;
    color:#057d9f;
    line-height:48px;
    text-align: center;}

.one-column-text h3{
    font-size:24px;
    font-weight:300;
    color:#057d9f;
    text-align: center;
    line-height:40px;}
    
/*-------------------------------------*/

.contact-info{
    margin-top:100px;}
    
.contact-info h3{
    font-weight:300;
    margin:30px 0;}
    
.contact-info p{
    font-weight:300;}
    
.contact-info span{
    font-size:18px;
    margin:20px 0 20px 0;
    font-weight:300;}

.contact-info hr{
    border:solid 1px #eee;
    margin:50px 0;}

        </style>    
            
        <body style="background-color:#C8D5B9;">
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                                    
                                    

                                </ul>
                            </div><!--/.nav-collapse -->
                        </div>
                    </nav>
                </div>
            </div>
<link href='http://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700,800' rel='stylesheet' type='text/css'>

<div class="container">

	<div class="row">
        <div class="col-md-12 one-column-text">
            <h2>¡Contáctenos! Queremos Saber de Ud.</h2>
            <h3>Estamos al otro lado del teléfono y de la pantalla para resolver sus dudas y consultas o simplemente para recibir sus sugerencias y comentarios</h3>
        </div>
    </div>
    
    <iframe src="https://www.google.com/maps/embed?pb=!1m5!3m3!1m2!1s0x9662cf1846549c4d%3A0x72a9d5b05cc5ded6!2sAm%C3%A9rico+Vespucio+Sur+107%2C+Las+Condes%2C+Regi%C3%B3n+Metropolitana!5e0!3m2!1ses-419!2scl!4v1388412285664&wmode=transparent" width="960" height="350" frameborder="0" style="border:2px solid #39aecf" wmode="Opaque">
</iframe>
    
    <div class="row contact-info">
        <div class="col-md-8">
            <h3>Pongámonos en Contacto</h3>
            <p>En GJC dejamos a su disposición la mejor inteligencia legal online 24/7 y estaremos respondiendo sus preguntas todos los días hábiles hasta las 18:00 horas.</p>
            <div class="row">
                <div class="col-md-4">
                    <span>Teléfono</span>
                    <p>España: +34 657 89 34 54</p>
                </div>
                <div class="col-md-4">
                    <span>Email</span>
                    <p>notificaciones@gjc.com</p>
                </div>
                <div class="col-md-4">
                    <span>Redes Sociales</span>
                    <p>Facebook:gjc</p>
                    <p>Twitter:@Gjc</a></p>
                </div>
            </div>
            <hr>
           
            
        </div>
        <div class="col-md-4">
            
            <h3>Nuestras Oficinas</h3>
            <p>C/ Explanada 8, 3ª planta, 28040 Madrid<br>España</p>
        </div>
    </div>
    
</div>
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
    
