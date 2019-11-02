<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
        <link rel="stylesheet" href="css/dashboard.css"/>
    </head>
    <body>
	<!-- Page Preloder -->
	<div id="preloder">
            <div class="loader"></div>
	</div>

	<jsp:include page="header.jsp" />
        
	<section class="top-letest-product-section">
            <div class="container">
                <div class="section-title">
                    <h2>LISTA DE FAVORITOS</h2>
                </div>
                
                <table class="table100">
                    <thead>
                        <tr class="table100-head">
                            <th class="column1">Nome</th>
                            <th class="column">Preço</th>
                            <th class="column">Remover</th>
                        </tr>
                    </thead>
                    <tbody>
			<c:forEach items="${listaFavoritos}" var="i">    
				<tr>
				    <td class="column1">${i.produto.nome}</td>
				    <td class="column">R$ ${i.produto.preco}</td>
					<td class="column">
						<input action="removerFavorito" id="${i.produto.id}" class="fa fa-trash"/>
					</td>
				</tr>
			</c:forEach>
                    </tbody>
                </table>
                </div>
	</section>

        <jsp:include page="footer.jsp" />
        
	<!--====== Javascripts & Jquery ======-->
	<script src="js/jquery-3.2.1.min.js"></script>
        <script src="js/main.js"></script>
    </body>
</html>
