<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
        <title>Camisas Legais</title>
        <meta charset="UTF-8">
        
        <link href="img/favicon.ico" rel="shortcut icon"/>

        <link href="https://fonts.googleapis.com/css?family=Josefin+Sans:300,300i,400,400i,700,700i" rel="stylesheet">

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

	<section class="checkout-section spad">
            <div class="container">
                <div class="row">
                    <div class="col-lg-8 order-2 order-lg-1">
                        <form class="checkout-form">
                            <div class="cf-title">Opções de envio</div>
                            <div class="row shipping-btns">
                                <div class="col-6">
                                    <h4>SEDEX</h4>
                                </div>
                                <div class="col-6">
                                    <div class="cf-radio-btns">
                                        <div class="cfr-item">
                                            <input type="radio" name="shipping" id="ship-1">
                                            <label for="ship-1">R$20,00</label>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-6">
                                    <h4>PAC</h4>
                                </div>
                                <div class="col-6">
                                    <div class="cf-radio-btns">
                                        <div class="cfr-item">
                                            <input type="radio" name="shipping" id="ship-2">
                                            <label for="ship-2">R$10,00</label>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="cf-title">Pagamento</div>
                            
                            <div class="row shipping-btns">
                                <div class="col-6">
                                    <h4>Paypal</h4>
                                </div>
                                <div class="col-6">
                                    <div class="cf-radio-btns">
                                        <div class="cfr-item">
                                            <input type="radio" name="shipping" id="ship-2">
                                            <label for="ship-2"><img src="img/paypal.png" alt=""></label>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-6">
                                    <h4>Cartão de Crédito</h4>
                                </div>
                                <div class="col-6">
                                    <div class="cf-radio-btns">
                                        <div class="cfr-item">
                                            <input type="radio" name="shipping" id="ship-2">
                                            <label for="ship-2"><img src="img/mastercart.png" alt=""></label>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <a href="#" action="confirmaCompra" class="site-btn submit-order-btn">Confirmar compra</a>
                        </form>
                    </div>
		</div>
            </div>
	</section>
        
        <jsp:include page="footer.jsp" />

	<script src="js/jquery-3.2.1.min.js"></script>
	<script src="js/main.js"></script>
    </body>
</html>

