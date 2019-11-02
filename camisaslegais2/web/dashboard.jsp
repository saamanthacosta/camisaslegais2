<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zxx">
    <head>
        <title>Camisas Legais</title>
        <meta charset="UTF-8">
        
        <link href="img/favicon.ico" rel="shortcut icon"/>

        <link href="https://fonts.googleapis.com/css?family=Josefin+Sans:300,300i,400,400i,700,700i" rel="stylesheet">

        <link rel="stylesheet" href="css/bootstrap.css"/>
        <link rel="stylesheet" href="css/animate.css"/>
        <link rel="stylesheet" href="css/style.css"/>
        <link rel="stylesheet" href="css/dashboard.css"/>
    </head>
    <body>
	<!-- Page Preloder -->
	<div id="preloder">
            <div class="loader"></div>
	</div>

	<!-- Header section -->
	<header class="header-section">
            <div class="header-top">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-2 text-center text-lg-left">
                            <!-- logo -->
                            <a href="./index.html" class="site-logo">
                                👕
                            </a> Camisas Legais
                        </div>
                    </div>
		</div>
            </div>
            <nav class="main-navbar">
                <div class="container">
                    <!-- menu -->
                    <ul class="main-menu">
                        <li><a href="/camisaslegais">Home</a></li>
                        <li><a href="#">Ranking dos Produtos</a></li>
                        <li><a href="#">Logout</a></li>
                    </ul>
                </div>
            </nav>
	</header>
	<!-- Header section end -->
       
	<!-- Hero section -->
	<section class="top-letest-product-section">
            <div class="container">
                <div class="section-title">
                    <h2>ESTOQUE DA LOJA</h2>
                </div>
                
                <div class="product-item">
                    <a name="inserirProduto" href="?logica=inserir" class="site-botao">Adicione uma nova camisa</a>
                        </div>
                <table class="table100">
                    <thead>
                        <tr class="table100-head">
                            <th class="column1">Nome</th>
                            <th class="column">Preço</th>
                            <th class="column">Quantidade</th>
                            <th class="column">Avaliação</th>
                            <th class="column">Editar</th>
                            <th class="column">Remover</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:choose>
                            <c:when test="${not empty listaProdutos}">
                                <c:forEach var="produto" items="${listaProdutos}">
                                    <tr>
                                        <td class="column"><c:out value="${produto.nome}" /></td>
                                        <td class="column"><c:out value="${produto.preco}" /></td>
                                        <td class="column"><c:out value="${produto.quantidade}" /></td>
                                        <td class="column"><c:out value="${produto.avaliacao}" /></td>
                                        <td class="column"><a href="?logica=editar&id=${produto.id}">Editar</a></td>
                                        <td class="column"><a href="?logica=remover&id=${produto.id}">Remover</a></td>
                                    </tr>
                                </c:forEach>
                            </c:when>
                            <c:otherwise>
                                <tr>
                                    <td colspan=6 class="column">Nenhum produto cadastrado!</td>
                                </tr>
                            </c:otherwise>
                        </c:choose>
                    </tbody>
                </table>
                </div>
	</section>
	<!-- Hero section end -->


	<!--====== Javascripts & Jquery ======-->
	<script src="js/jquery-3.2.1.min.js"></script>
	<script src="js/owl.carousel.min.js"></script>
        <script src="js/main.js"></script>
    </body>
</html>