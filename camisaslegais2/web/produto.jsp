<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zxx">
    <head>
        <title>Camisas Legais</title>
        <meta charset="UTF-8">
        <!-- Favicon -->
        <link href="img/favicon.ico" rel="shortcut icon"/>

        <link href="https://fonts.googleapis.com/css?family=Josefin+Sans:300,300i,400,400i,700,700i" rel="stylesheet">

        <link rel="stylesheet" href="css/bootstrap.css"/>
        <link rel="stylesheet" href="css/animate.css"/>
        <link rel="stylesheet" href="css/style.css"/>
    </head>
    <body>
      
        <div id="preloder">
            <div class="loader"></div>
        </div>
        <jsp:include page="header.jsp" />
        
      <form method="post" class="contact100-form validate-form" action="loja?action=adicionarProduto">
        <section class="product-section">
            <div class="container">
                <div class="row">
                    <div class="col-lg-6">
                        <div class="product-pic-zoom">
                            <img class="product-big-img" src="img/${produto.imagem}" alt="">
                        </div>
                    </div>
                    <div class="col-lg-6 product-details">
                        <input type="hidden" name="produto" value="${produto.id}" />
                        <h2 class="p-title" value="${produto.id}">${produto.nome}</h2>
                        <h3 class="p-price">${produto.preco}</h3>
                        <h4 class="p-stock">Disponível: <span>${produto.quantidade}</span></h4>
                            <c:choose>    
                                <c:when test="${avaliacao.avaliacao ==0}">
                                    <div class="p-rating">
                                        <c:forEach var="i" begin="1" end="${produto.avaliacao}">
                                            <c:out value="⭐"/>
                                        </c:forEach>
                                    </div>
                                    <div class="p-review">
                                        <p>${produto.avaliacao}|<p>Produto já avaliado</p>
                                    </div>
                                </c:when>
                                <c:otherwise>
                                    <div class="p-review">
                                        <p>Avalie produto:<select name="avaliacao">
                                                <option>1</option>
                                                <option>2</option>
                                                <option>3</option>
                                                <option>4</option>
                                                <option>5</option>
                                            </select>
                                            <form method="POST" action="loja?action=avaliacao">
                                                <button class="contact100-form-btn" type="submit">
                                                    <span>Avaliar</span>
                                                </button></p>
                                            </form>
                                    </div>
                                </c:otherwise>
                            </c:choose>
                        <div class="quantity">
                            <p>Quantidade</p>
                            <div class="pro-qty"> 
                                <select name="quantidade" class="col-sm-12">
                                    <c:forEach var="i" begin="1" end="${produto.quantidade}">
                                        <option><c:out value="${i}"/></option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <button class="site-btn">Adicione ao carrinho</button>
                        <!--                        <a href="#" class="site-btn">Editar produto</a>
                                                <a href="#" class="site-btn">Remover produto</a>-->
                    </div>
                </div>
            </div>
        </section>
        </form>

        <jsp:include page="footer.jsp" />
        
        <!--====== Javascripts & Jquery ======-->
        <script src="js/jquery-3.2.1.min.js"></script>
        <script src="js/owl.carousel.min.js"></script>
        <script src="js/main.js"></script>
    </body>
</html>
