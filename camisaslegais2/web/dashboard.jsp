<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
  <title>Camisas Legais - Console</title>
  <meta charset="UTF-8">

  <!-- Fonte Josefin Sans -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Josefin+Sans:300,300i,400,400i,700,700i">

  <!-- Icons Font-Awesome -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

  <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
  <link rel="stylesheet" type="text/css" href="css/form.css">
  <link rel="stylesheet" type="text/css" href="css/dashboard.css">
  <link rel="stylesheet" type="text/css" href="css/style2.css">
</head>

<body>

  <header>
    <nav class="top-navbar">
      <div class="container">
        <div class="painel">
          <ul>
            <li><a href=".">Home</a></li>
          </ul>
        </div>
      </div>
    </nav>

    <nav class="navbar">
      <div class="container">
        <ul class="menu">
          <span class="dashboard-title">Console do Administrador</span>
        </ul>
      </div>
    </nav>
  </header>

  <div class="container-dashboard bg-img-form">
    <div class="container">
      <table class="table100">

        <thead>
          <tr class="table100-head">
            <th class="column1">Nome</th>
            <th class="column">Preço</th>
            <th class="column">Quantidade</th>
            <th class="column">Avaliação</th>
            <th class="column"></th>
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
                  <td class="column">
                    <button class="edit-produto" onclick="window.dialog.showModal();">
                      <i class="fa fa-ellipsis-v" aria-hidden="true"></i>
                    </button>
                  </td>
                  <!-- TODO: Jogar para uma dialog com opções visualizar, editar e remover
                  <td class="column"><a href="?logica=editar&id=${produto.id}">Editar</a></td>
                  <td class="column"><a href="?logica=remover&id=${produto.id}">Remover</a></td>
                  -->
                </tr>
              </c:forEach>
            </c:when>
            <c:otherwise>
              <tr>
                <td colspan=5 class="column">Nenhum produto cadastrado!</td>
              </tr>
            </c:otherwise>
          </c:choose>
        </tbody>
      </table>

      <div class="text-right p-2">
        <button class="site-btn add-produto" onclick="window.dialog.showModal();">
          <i class="fa fa-plus" aria-hidden="true"></i>
        </button>
      </div>
    </div>
    
  </div>

  <dialog id="dialog" class="dialog-add-produto">
    <div class="container">
      <form method="dialog" class="contact100-form">
        <div class="col-12">
          <div class="white-bg wrap-input100">
            <span class="label-input100">Nome</span>
            <input class="input100" type="text" name="nome" placeholder="Nome do produto">
          </div>
        </div>
        <div class="col-4">
          <div class="white-bg wrap-input100">
            <span class="label-input100">Preço</span>
            <input class="input100" id="preco" type="text" name="preco" value="R$" placeholder="R$00.00" maxlength="7">
            <script>
              var inputPreco = document.querySelector('#preco');
              inputPreco.addEventListener('keypress', (e) => {
                if (e.key.match(/^\d|\.$/) == null) { e.preventDefault(); }
              });
            </script>
            <!-- <script>
                var inputPreco = document.querySelector('#preco');
                inputPreco.addEventListener('keypress', (e) => {
                  if (e.key.match(/^\d$/) !== null) {
                    if (inputPreco.value.match(/^\R\$$/) !== null) {
                      inputPreco.value.concat(e.key.value);
                    }
                    console.log(inputPreco.value);
                    if (inputPreco.value.match(/^\R\$(\d{2})$/) !== null) {
                      inputPreco.value.concat('.'+e.key.value);
                    }
                    console.log(inputPreco.value);
                    if (inputPreco.value.match(/^\R\$(\d{2})(\.\d)$/) !== null) {
                      inputPreco.value.concat(e.key.value);
                    }
                    console.log(inputPreco.value);
                  } else {
                    e.preventDefault();
                  }
                });
              </script> -->
          </div>
        </div>
        <div class="col-4">
          <div class="white-bg wrap-input100">
            <span class="label-input100">Estoque</span>
            <input class="input100" type="text" name="quantidade" placeholder="Estoque">
          </div>
        </div>
        <div class="col-4">
          <div class="white-bg wrap-input100">
            <span class="label-input100">Estoque</span>
            <select name="tamanho" class="input100">
              <option value="" disabled selected hidden>Tam</option>
              <option value="pp">PP</option>
              <option value="p">P</option>
              <option value="m">M</option>
              <option value="g">G</option>
              <option value="gg">GG</option>
            </select>
          </div>
        </div>

        <button class="site-btn justify-content-end">Cadastrar</button>
      </form>
      <button class="site-btn sb-line sb-dark" onclick="window.dialog.close();">Cancelar</button>

    </div>
  </dialog>

</body>

</html>

    <!-- TODO: associar lógica à dialog
    <div class="product-item">
      <a name="inserirProduto" href="?logica=inserir" class="site-botao">Adicione uma nova camisa</a>
    </div>
    -->