<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
  <title>Camisas Legais - Home</title>
  <meta charset="UTF-8">

  <!-- Fonte Josefin Sans -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Josefin+Sans:300,300i,400,400i,700,700i">

  <!-- Icons Font-Awesome -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

  <link rel="stylesheet" href="css/bootstrap.css" />
  <link rel="stylesheet" href="css/animate.css"/>
  <link rel="stylesheet" href="css/style2.css" />
</head>

<body>
  <div id="preloder">
    <div class="loader"></div>
  </div>
  
  <jsp:include page="header.jsp" />

  <section class="home">
    <div class="home-img">
      <div class="hi-item bg-img">
        <div class="container">
          <div class="row">
            <div class="col-xl-7">
              <h5 id="home-titulo">Camisas bem bacanas</h5>
              <p id="home-texto">Nossas camisas são projetadas para todos os tipos de corpos, querendo levar à todos uma
                individualidade diferenciada.</p>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>

  <jsp:include page="footer.jsp" />
  
</body>
</html>
