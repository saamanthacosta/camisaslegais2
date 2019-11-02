<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
	<title>Camisas Legais - Inserir Camisa</title>
	<meta charset="UTF-8">
        
        <link href="https://fonts.googleapis.com/css?family=Josefin+Sans:300,300i,400,400i,700,700i" rel="stylesheet">
        
	<link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="css/form.css">
    </head>
    <body>
      
      <jsp:include page="header.jsp" />
      
        <div class="container-contact100">
            <div class="wrap-contact100">
                <form class="contact100-form validate-form" method="post">
                    <span class="contact100-form-title">Inserir Camisa</span>

                    <div class="wrap-input100">
                        <span class="label-input100">Nome</span>
                        <input class="input100" type="text" name="nomeCamisaNV" placeholder="Coloque um nome para a camisa">
                    </div>

                    <div class="wrap-input100">
                        <span class="label-input100">Preço</span>
                        <input class="input100" type="text" name="precoCamisaNV" placeholder="Coloque um preço para a camisa">
                    </div>

                    <div class="wrap-input100 bg1 rs1-wrap-input100">
                        <span class="label-input100">Quantidade</span>
                        <input class="input100" type="number" name="qtdCamisaNV" placeholder="Coloque uma quantidade para a camisa">
                    </div>
                    
                    <div class="wrap-input100 bg1 rs1-wrap-input100">
                        <span class="label-input100">Foto</span>
                        <input class="input100" type="file" name="fotoCamisaNV" accept="image/x-png,image/gif,image/jpeg">
                    </div>
                    
                    <div class="container-contact100-form-btn">
                        <button class="contact100-form-btn" type="submit">
                            <span>Cadastrar nova camisa</span>
                        </button>
                    </div>
                </form>
            </div>
	</div>
      
      <jsp:include page="header.jsp" />
      
    </body>
</html>