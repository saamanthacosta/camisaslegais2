<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<header class="header">
  
  <nav class="top-navbar">
    <div class="container">
      <div class="painel">
        <ul>
          <% HttpSession sessao = request.getSession();
            if(sessao.getAttribute("usuario-perfil") == "admin") { %>
          <li><a href="/camisaslegais/dashboard">Administrador</a></li>
          <% } %>
          <li><a href="/camisaslegais/carrinho">Carrinho</a></li>
          <% if(sessao.getAttribute("usuario-nome") != null) { %>
          <li><a href="/camisaslegais/conta">Conta</a></li>
          <li><a href="/camisaslegais/favoritos">Favoritos</a></li>
          <li><a href="/camisaslegais/logout">Sair</a></li>
          <% } else { %>  
          <li><a href="/camisaslegais/login">Entrar</a></li>
          <li><a href="/camisaslegais/cadastro">Criar Conta</a></li>
          <% } %>
        </ul>
      </div>
    </div>
  </nav>

  <nav class="navbar">
    <div class="container">
      <ul class="menu">
        <li><a href=".">Home</a></li>
        <li><a href="/camisaslegais/loja">Produtos</a></li>
        <li><a href="/camisaslegais/ranking">Melhores Avaliados</a></li>
      </ul>
    </div>
  </nav>

</header>