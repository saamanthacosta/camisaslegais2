
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
	<title>Camisas Legais - Cadastrar Usuário</title>
	<meta charset="UTF-8">
        
        <link href="https://fonts.googleapis.com/css?family=Josefin+Sans:300,300i,400,400i,700,700i" rel="stylesheet">
        
	<link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="css/form.css">
    </head>
    <body>
        <div class="container-contact100">
            <div class="wrap-contact100">
                <form method="post" class="contact100-form validate-form">
                    <span class="contact100-form-title">Cadastrar Usuário</span>

                    <div class="wrap-input100">
                        <span class="label-input100">Nome</span>
                        <input class="input100" type="text" name="nome" placeholder="Insira o nome">
                    </div>

                    <div class="wrap-input100">
                        <span class="label-input100">E-mail</span>
                        <input class="input100" type="text" name="email" placeholder="Insira o e-mail">
                    </div>

                    <div class="wrap-input100">
                        <span class="label-input100">Senha</span>
                        <input class="input100" type="password" name="senha" placeholder="Insira a senha">
                    </div>
                    
                    <div class="wrap-input100">
                        <span class="label-input100">Logradouro</span>
                        <input class="input100" type="text" name="logradouro" placeholder="Insira o logradouro">
                    </div>
                    
                    <div class="wrap-input100">
                        <span class="label-input100">Complemento</span>
                        <input class="input100" type="text" name="complemento" placeholder="Insira o complemento">
                    </div>
                    
                    <div class="wrap-input100">
                        <span class="label-input100">Bairro</span>
                        <input class="input100" type="text" name="bairro" placeholder="Insira o Bairro">
                    </div>
                    <div class="wrap-input100">
                        <span class="label-input100">CEP</span>
                        <input class="input100" type="text" name="cep" placeholder="Insira o CEP">
                    </div>
                    <div class="wrap-input100">
                        <span class="label-input100">Cidade</span>
                        <input class="input100" type="text" name="cidade" placeholder="Insira a cidade">
                    </div>
                    
                    <div class="wrap-input100 input100-select bg1">
                        <span class="label-input100">Estado</span>
                        <div>
                            <select name="uf">
                                <option>AC</option>
                                <option>AL</option>
                                <option>AP</option>
                                <option>AM</option>
                                <option>BA</option>
                                <option>CE</option>
                                <option>DF</option>
                                <option>ES</option>
                                <option>GO</option>
                                <option>MA</option>
                                <option>MT</option>
                                <option>MS</option>
                                <option>MG</option>
                                <option>PA</option>
                                <option>PB</option>
                                <option>PR</option>
                                <option>PE</option>
                                <option>PI</option>
                                <option>RR</option>
                                <option>RO</option>
                                <option>RJ</option>
                                <option>RN</option>
                                <option>RS</option>
                                <option>SC</option>
                                <option>SP</option>
                                <option>SE</option>
                                <option>TO</option>
                            </select>
                            <div class="dropDownSelect2"></div>
                        </div>
                    </div>
                    <div class="container-contact100-form-btn">
                        <button class="contact100-form-btn">
                            <span>Criar conta</span>
                        </button>
                    </div>
                </form>
            </div>
	</div>
        
        <script src="js/main.js"></script>

    </body>
</html>