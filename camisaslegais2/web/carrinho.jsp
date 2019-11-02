<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Camisas Legais - Carrinho</title>
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
        
        <section class="cart-section spad">
            <div class="container">
                <div class="row">
                    <div class="col-lg-8">
                        <div class="cart-table">
                            <c:choose>
                                <c:when test="${empty sessionScope}">
                                    <h3>Carrinho de ${sessionScope.usuario-nome}</h3>
                                </c:when>
                                <c:otherwise>
                                    <h3>Carrinho</h3>
                                </c:otherwise>
                            </c:choose>
                            <div class="cart-table-warp">
                                <table>
                                    <thead>
                                        <tr>
                                            <th class="product-th">Produto</th>
                                            <th class="quy-th">Quantidade</th>
                                            <th class="total-th">Preço</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:choose>
                                            <c:when test="${not empty sessionScope.carrinho.itens}">
                                               <c:forEach var="item" items="${sessionScope.carrinho.itens}" varStatus="loop">
                                                <tr>
                                                    <td class="product-col">
                                                        <img src="img/${item.produto.imagem}" alt="">
                                                        <div class="pc-title">
                                                            <h4>${item.produto.nome}</h4>
                                                            <p>R$${item.produto.preco}</p>
                                                        </div>
                                                    </td>
                                                    <td class="quy-col">
                                                        <div class="quantity">
                                                            <div class="pro-qty">
                                                                <form method="POST" action="carrinho?action=alteraQuantidade">
                                                                    <input type="number" name="quantidade" value="${item.quantidade}">
                                                                    <input type="hidden" name="posicao" value="${loop.index}" class="btn btn-danger">
                                                                    <button type="submit">
                                                                        <i class="fa fa-angle-up"></i>
                                                                    </button>
                                                                </form>
                                                            </div>
                                                        </div>
                                                    </td>
                                                    <td class="total-col"><h4>R$${item.total}</h4></td>
                                                </tr>
                                               </c:forEach> 
                                            </c:when>
                                            <c:otherwise>
                                                <tr>
                                                    <td class="product-col" colspan="4">
                                                        Nenhum produto adicionado!
                                                    </td>
                                                </tr>
                                            </c:otherwise>
                                        </c:choose>
                                        
                                    </tbody>
                                </table>
                            </div>
                            <div class="total-cost">
                                <h6>Total <span>R$${sessionScope.carrinho.total}</span></h6>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4 card-right">
                        <a href="" class="site-btn">Finalizar compra</a>
                        <a href="loja" class="site-btn sb-dark">Continuar comprando</a>
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