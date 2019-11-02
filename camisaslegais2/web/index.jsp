<%@page import="br.com.camisaslegais.beans.Pedido"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.com.camisaslegais.beans.Produto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Camisas Legais</title>
        <meta charset="UTF-8">

        <link href="img/favicon.ico" rel="shortcut icon"/>

        <link href="https://fonts.googleapis.com/css?family=Josefin+Sans:300,300i,400,400i,700,700i" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="css/bootstrap.css"/>
        <link rel="stylesheet" href="css/animate.css"/>
        <link rel="stylesheet" href="css/style.css"/>

    </head>
    <body>
	<!-- Page Preloder -->
	<div id="preloder">
        <div class="loader"></div>
	</div>

        <jsp:include page="header.jsp" />

	<section class="hero-section">
        <div class="hero-slider owl-carousel">
            <div class="hs-item set-bg" data-setbg="img/mens-tshirts.jpg">
                <div class="container">
                    <div class="row">
                        <div class="col-xl-7">
                            <span>Camisas bem bacanas</span>
                            <p>Nossas camisas são projetadas para todos os tipos de corpos, querendo levar à todos uma individualidade diferenciada.</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
	</section>

        <jsp:include page="footer.jsp" />

	<!--====== Javascripts & Jquery ======-->
	<script src="js/jquery-3.2.1.min.js"></script>
	<script src="js/owl.carousel.min.js"></script>
        <script src="js/main.js"></script>
    </body>
</html>
