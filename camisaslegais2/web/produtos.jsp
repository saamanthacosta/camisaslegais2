<%@page import="br.com.camisaslegais.beans.Pedido"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.com.camisaslegais.beans.Produto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<%
    ArrayList<Produto> listarProdutos = (ArrayList<Produto>)request.getAttribute("listarProdutos");    
    ArrayList<Produto> listarAvaliados = (ArrayList<Produto>)request.getAttribute("listarAvaliados");

    // A lista de usu?rios ? colocada no contexto da p?gina. Assim o JSTL ter? acesso a ela
    pageContext.setAttribute("listarProdutos", listarProdutos);
    pageContext.setAttribute("listarAvaliados", listarAvaliados);

    Pedido carrinho = (Pedido) request.getAttribute("carrinho");
    // A lista de usu?rios ? colocada no contexto da p?gina. Assim o JSTL ter? acesso a ela
    pageContext.setAttribute("carrinho", carrinho);
%>
<html lang="zxx">
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
	<!-- Product filter section -->
	<section class="product-filter-section">
            <div class="container">
                <div class="section-title">
                    <h2>CAMISAS BEM BACANAS</h2>
                </div>
                <div class="row">
                    <c:forEach items="${listarProdutos}" var="produto" varStatus="loop">
                        <input type="hidden" name="idProduto" value="${produto.id}" />
                        <div class="col-lg-3 col-sm-6">
                            <div class="product-item" id="myDiv">
                                <div class="pi-pic">
                                    <img src="img/${produto.imagem}" alt="">
                                    <div class="pi-links">
                                        <a href="/camisaslegais/carrinhoServlet?action=adicionaProduto" class="add-card"><i class="fa fa-shopping-bag"></i></a>
                                        <a href="/camisaslegais/favoritosServlet?action=adicionaFavorito" class="wishlist-btn"><i class="fa fa-heart"></i></a>
                                    </div>
                                </div>
                                <div class="pi-text">
                                    <h6>${produto.preco}</h6>
                                    <a href="?action=visualizar&id=${produto.id}">${produto.nome}</a>
                                </div>  
                            </div>
                        </div>
                    </c:forEach>
                </div>
                <div class="text-center pt-5">
                    <button class="site-btn sb-line sb-dark">CARREGAR MAIS</button>
                </div>
            </div>
	</section>
	<!-- Product filter section end -->
	<jsp:include page="footer.jsp" />
	<!--====== Javascripts & Jquery ======-->
	<script src="js/jquery-3.2.1.min.js"></script>
	<script src="js/owl.carousel.min.js"></script>
        <script src="js/main.js"></script>
    </body>
</html>
