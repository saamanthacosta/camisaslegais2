<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<header class="header-section">
        <nav class="header-top">
            <div class="container">
                <div class="user-panel">
                    
                    <ul class="main-menu">
                      <% HttpSession sessao = request.getSession();
                        if(sessao.getAttribute("usuario-perfil") == "admin") { %>
                        <li><a href="/camisaslegais/dashboard" class="up-item">Administrador</a></li>
                      <% } %>
                      <li><a href="/camisaslegais/carrinho" class="up-item">Carrinho</a></li>
                      <% if(sessao.getAttribute("usuario-nome") != null) { %>                           
                        <li><a href="/camisaslegais/conta" class="up-item">Conta</a></li>                       
                        <li><a href="/camisaslegais/favoritos" class="up-item">Favoritos</a></li>
                        <li><a href="/camisaslegais/logout" class="up-item">Sair</a></li>
                        <% } else { %>
                        <li><a href="/camisaslegais/login" class="up-item">Entrar</a></li>
                        <li><a href="/camisaslegais/cadastro" class="up-item">Criar Conta</a></li>
                      <% } %>
                    </ul>
                </div>
            </div>
        </nav>
        <nav class="main-navbar">
            <div class="container">
                <ul class="main-menu">
                    <li><a href="/camisaslegais">Home</a></li>
                    <li><a href="/camisaslegais/loja">Produtos</a></li>
                    <li><a href="/camisaslegais/ranking">Melhores Avaliados</a></li>
                </ul>
            </div>
        </nav>
	</header>
