<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Camisas Legais - Login</title>
  <meta charset="UTF-8">

  <link href="https://fonts.googleapis.com/css?family=Josefin+Sans:300,300i,400,400i,700,700i" rel="stylesheet">

  <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
  <link rel="stylesheet" type="text/css" href="css/animate.css">
  <link rel="stylesheet" type="text/css" href="css/login.css">
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

  <div class="container-login100 bg-img-form">
    <div class="wrap-login100 p-t-30 p-b-50">
      <span class="login100-form-title p-b-41">Login</span>

      <form method="post" class="login100-form p-b-33 p-t-5">

        <div class="wrap-input100">
          <input class="input100" type="email" name="usuarioEmail" placeholder="Email">
        </div>

        <div class="wrap-input100">
          <input class="input100" type="password" name="usuarioSenha" placeholder="Senha">
        </div>
        <div class="register">
          <span>ou <a href="cadastro.html">cadastre-se</a></span>
        </div>
        <div class="container-login100-form-btn m-t-32">
          <button class="site-btn" type="submit">Login</button>
        </div>
      </form>
    </div>
  </div>
</body>
</html>