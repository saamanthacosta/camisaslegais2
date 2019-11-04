<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Camisas Legais - Cadastrar Usuário</title>
  <meta charset="UTF-8">
  <!-- Fonte Josefin Sans -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Josefin+Sans:300,300i,400,400i,700,700i">

  <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
  <link rel="stylesheet" type="text/css" href="css/animate.css">
  <link rel="stylesheet" type="text/css" href="css/form.css">
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
  </header>

  <div class="container-login100 bg-img-form container-dashboard">
    <div class="wrap-login100 p-t-30 p-b-50">
      <p class="form-title text-center text-white">Cadastro de Usuário</p>
      <div class="container">
        <form method="post" class="contact100-form validate-form p-b-33 p-t-5">
          <div class="col-12">
            <span class="text-white">Informações Pessoais</span>
          </div>
          <div class="col-sm-12">
            <div class="white-bg wrap-input100">
              <span class="label-input100">Nome</span>
              <input class="input100" type="text" name="nome" placeholder="Nome Completo">
            </div>
          </div>
          <div class="col-sm-12 col-md-6">
            <div class="white-bg wrap-input100">
              <span class="label-input100">E-mail</span>
              <input class="input100" type="email" name="email" placeholder="exemplo@email.com">
            </div>
          </div>
          <div class="col-sm-12 col-md-6">
            <div class="white-bg wrap-input100">
              <span class="label-input100">Senha</span>
              <input class="input100" type="password" name="senha" placeholder="Insira a senha">
            </div>
          </div>

          <div class="col-12">
            <span class="text-white">Endereço</span>
          </div>
          <div class="col-sm-12 col-md-8">
            <div class="white-bg wrap-input100">
              <span class="label-input100">Logradouro</span>
              <input class="input100" type="text" name="logradouro"
                placeholder="Ex.: Av. Gal. Milton Tavares de Souza, s/n">
            </div>
          </div>
          <div class="col-sm-12 col-md-4">
            <div class="white-bg wrap-input100">
              <span class="label-input100">Complemento</span>
              <input class="input100" type="text" name="complemento" placeholder="Ex.: Bloco IC">
            </div>
          </div>
          <div class="col-sm-12 col-md-6">
            <div class="white-bg wrap-input100">
              <span class="label-input100">Bairro</span>
              <input class="input100" type="text" name="bairro" placeholder="Ex.: São Domingos">
            </div>
          </div>
          <div class="col-sm-12 col-md-6">
            <div class="white-bg wrap-input100">
              <span class="label-input100">CEP</span>
              <input class="input100" type="text" name="cep" placeholder="Ex.: 24210-346">
            </div>
          </div>
          <div class="col-sm-12 col-md-8">
            <div class="white-bg wrap-input100">
              <span class="label-input100">Cidade</span>
              <input class="input100" type="text" name="cidade" placeholder="Ex.: Niterói">
            </div>
          </div>

          <div class="input100-select bg1 col-sm-12 col-md-4">
            <div class="white-bg wrap-input100">
              <span class="label-input100">Estado</span>
              <select name="uf" class="input100" id="uf-select">
                <option value="" disabled selected hidden>UF</option>
                <script>
                  const estados = [
                    "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO",
                    "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI",
                    "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"
                  ];
                  var select = document.getElementById("uf-select");
                  estados.forEach((estado) => {
                    select.options[select.options.length] = new Option(estado, estado);
                  });
                </script>
              </select>
            </div>
          </div>

          <div class="container-contact100-form-btn">
            <button class="site-btn" type="submit">Criar conta</button>
          </div>

        </form>
      </div>
    </div>
  </div>

  <script src="js/main.js"></script>
</body>

</html>