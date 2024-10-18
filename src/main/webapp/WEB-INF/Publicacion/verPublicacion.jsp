<%--
  Created by IntelliJ IDEA.
  User: gq
  Date: 01/10/2022
  Time: 04:23
  To change this template use File | Settings | File Templates.
--%>

<%@page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<tags:jsp_imports/>
<html>
<head>
    <title>Ver publication</title>
<%--    CSS IMPORTS--%>
    <tags:css_imports/>

</head>
<body class="container bg-gray-200">
<%--            NavbarStart--%>
<%@include file="../common/navBar2.jsp"%>
<%--            NavbarEnd--%>
<div class="" style="margin-top: 100px">
    <div class="container-fluid my-lg-5">
        <div class="row px-xl-5">
            <div class="col-lg-5 pb-5">
                <div id="carousel-1" class="carousel slide shadow-lg" data-bs-ride="true">
                    <div class="carousel-inner" >
<%--                        <div class="carousel-item active ratio ratio-1x1 "><img class="rounded" style="object-fit:cover; height:100%; width: 100%;" src="../../assets/img/rents/3.webp" alt="Slide Image" /></div>--%>



                        <c:forEach items="${publication.images}" var="imag">
                            <c:if test="${imag.id == publication.images[0].id}">
                                <div class="carousel-item active ratio ratio-1x1 "><img class="rounded" style="object-fit:cover; height:100%; width: 100%;" src="../../assets/img/rents/${imag.url}" alt="Slide Image" /></div>
                            </c:if>
                            <c:if test="${imag.id != publication.images[0].id}">
                                <div class="carousel-item ratio ratio-1x1 "><img class="rounded" style="object-fit:cover; height:100%; width: 100%;" src="../../assets/img/rents/${imag.url}" alt="Slide Image" /></div>
                            </c:if>
<%--                            <div class="carousel-item ratio ratio-1x1 "><img class="rounded" style="object-fit:cover; height:100%; width: 100%;" src="../../assets/img/rents/3.webp" alt="Slide Image" /></div>--%>
                        </c:forEach>

<%--                        <div class="carousel-item active ratio ratio-1x1 "><img class="rounded" style="object-fit:cover; height:100%; width: 100%;" src="../../assets/img/rents/1.webp" alt="Slide Image" /></div>--%>
<%--                        <div class="carousel-item ratio ratio-1x1 "><img class="rounded" style="object-fit:cover; height:100%; width: 100%;" src="../../assets/img/rents/2.webp" alt="Slide Image" /></div>--%>
<%--                        <div class="carousel-item ratio ratio-1x1 "><img class="rounded" style="object-fit:cover; height:100%; width: 100%;" src="../../assets/img/rents/3.webp" alt="Slide Image" /></div>--%>
                    </div>
                    <div><a class="carousel-control-prev" href="#carousel-1" role="button" data-bs-slide="prev"><span class="carousel-control-prev-icon" aria-hidden="true"></span><span class="visually-hidden">Previous</span></a><a class="carousel-control-next" href="#carousel-1" role="button" data-bs-slide="next"><span class="carousel-control-next-icon" aria-hidden="true"></span><span class="visually-hidden">Next</span></a></div>
                    <ol class="carousel-indicators">
                        <c:choose>
                            <c:when test="${publication.images.size() == 1}">
                                <li data-bs-target="#carousel-1" data-bs-slide-to="0" class="active"></li>
                            </c:when>
                            <c:when test="${publication.images.size() == 2}">
                                <li data-bs-target="#carousel-1" data-bs-slide-to="0" class="active"></li>
                                <li data-bs-target="#carousel-1" data-bs-slide-to="1"></li>
                            </c:when>
                            <c:when test="${publication.images.size() == 3}">
                                <li data-bs-target="#carousel-1" data-bs-slide-to="0" class="active"></li>
                                <li data-bs-target="#carousel-1" data-bs-slide-to="1"></li>
                                <li data-bs-target="#carousel-1" data-bs-slide-to="2"></li>
                            </c:when>
                            <c:when test="${publication.images.size() == 4}">
                                <li data-bs-target="#carousel-1" data-bs-slide-to="0" class="active"></li>
                                <li data-bs-target="#carousel-1" data-bs-slide-to="1"></li>
                                <li data-bs-target="#carousel-1" data-bs-slide-to="2"></li>
                                <li data-bs-target="#carousel-1" data-bs-slide-to="3"></li>
                            </c:when>
                            <c:when test="${publication.images.size() == 5}">
                                <li data-bs-target="#carousel-1" data-bs-slide-to="0" class="active"></li>
                                <li data-bs-target="#carousel-1" data-bs-slide-to="1"></li>
                                <li data-bs-target="#carousel-1" data-bs-slide-to="2"></li>
                                <li data-bs-target="#carousel-1" data-bs-slide-to="3"></li>
                                <li data-bs-target="#carousel-1" data-bs-slide-to="4"></li>
                            </c:when>
                            <c:when test="${publication.images.size() == 6}">
                                <li data-bs-target="#carousel-1" data-bs-slide-to="0" class="active"></li>
                                <li data-bs-target="#carousel-1" data-bs-slide-to="1"></li>
                                <li data-bs-target="#carousel-1" data-bs-slide-to="2"></li>
                                <li data-bs-target="#carousel-1" data-bs-slide-to="3"></li>
                                <li data-bs-target="#carousel-1" data-bs-slide-to="4"></li>
                                <li data-bs-target="#carousel-1" data-bs-slide-to="5"></li>
                            </c:when>
                            <c:when test="${publication.images.size() == 7}">
                                <li data-bs-target="#carousel-1" data-bs-slide-to="0" class="active"></li>
                                <li data-bs-target="#carousel-1" data-bs-slide-to="1"></li>
                                <li data-bs-target="#carousel-1" data-bs-slide-to="2"></li>
                                <li data-bs-target="#carousel-1" data-bs-slide-to="3"></li>
                                <li data-bs-target="#carousel-1" data-bs-slide-to="4"></li>
                                <li data-bs-target="#carousel-1" data-bs-slide-to="5"></li>
                                <li data-bs-target="#carousel-1" data-bs-slide-to="6"></li>
                            </c:when>
                        </c:choose>
                    </ol>
                </div>
            </div>

            <div class="col-lg-7 pb-5">
                <h3 class="font-weight-semi-bold">${publication.qualificationPublicacion}</h3>
                <div class="d-flex mb-3">
                    <div class="text-primary mr-2">
                        <small class="fas fa-star"></small>
                        <small class="fas fa-star"></small>
                        <small class="fas fa-star"></small>
                        <small class="fas fa-star-half-alt"></small>
                        <small class="far fa-star"></small>
                    </div>
                    <small class="pt-1">(50 Reviews)</small>
                </div>
<%--                <h3 class="font-weight-semi-bold mb-4">${publication.pricePublicacion}</h3>--%>
<%--                agregar a favorites y contacto--%>
                <div class="d-flex mb-3">
                    <div class="text-primary mr-2 ms-2 me-2">

                        <%
                            if (session.getAttribute("autenticado") != "true"){
                        %>
                        <a href="${pageContext.request.contextPath}/login" class="btn btn-outline-primary btn-sm">Agregar a favorites</a>
                        <%
                            }
                        %>
                        <%
                            if (session.getAttribute("autenticado") == "true"){
                        %>
                        <c:if test="${user.favorites.contains(publication)}">
                            <form:form method="post" action="/publication/quitarFavorite/${publication.id}" >
                                <button type="submit" class="btn btn-outline-primary btn-sm">Quitar de favorites</button>
                            </form:form>
                        </c:if>
                        <c:if test="${!user.favorites.contains(publication)}">
                            <form:form method="post" action="/publication/agregarFavorite/${publication.id}" >
                                <button type="submit" class="btn btn-outline-primary btn-sm">Agregar a favorites</button>
                            </form:form>
                        </c:if>
                        <%
                            }
                        %>



                    </div>
                    <div class="text-primary mr-2 ms-2 me-2">
                        <a href="#" class="btn btn-outline-primary btn-sm">Contactar</a>
                    </div>
                </div>

                <div class="row">
                    <c:if test="${publication.bedroomsPublicacion > 0}">
                    <div class="col-6">
                        <div class="d-flex align-items-center mb-3">
                            <div class="bg-primary p-2 mr-3 rounded-circle" style="height: 32px; width: 32px;"><i class="fas fa-bed text-white"></i></div>
                            <div>
                                <h6 class="font-weight-semi-bold ms-2 mb-0">${publication.bedroomsPublicacion} Habitaciones</h6>
<%--                                <small class="text-muted ms-2">2 camas dobles y 1 simple</small>--%>
                            </div>
                        </div>
                    </div>
                    </c:if>
                    <c:if  test="${publication.bathsPublicacion > 0}">
                    <div class="col-6">
                        <div class="d-flex align-items-center mb-3">
                            <div class="bg-primary rounded-circle p-2 mr-3" style="height: 32px; width: 32px;"><i class="fas fa-bath text-white"></i></div>
                            <div>
                                <h6 class="font-weight-semi-bold ms-2 mb-0">${publication.bathsPublicacion} Baños</h6>
<%--                                <small class="text-muted ms-2">1 con bañera y 1 con ducha</small>--%>
                            </div>
                        </div>
                    </div>
                    </c:if>

                    <c:if  test="${publication.surfaceTotalLand > 0}">
                        <div class="col-6">
                            <div class="d-flex align-items-center mb-3">
                                <div class="bg-primary rounded-circle p-2 mr-3"><i class="fas fa-ruler-combined text-white"></i></div>
                                <div>
                                    <h6 class="font-weight-semi-bold ms-2 mb-0">${publication.surfaceTotalLand} m2</h6>
                                    <small class="text-muted ms-2">Surface total</small>
                                </div>
                            </div>
                        </div>
                    </c:if>

                    <c:if  test="${publication.garagePublicacion > 0}">
                        <div class="col-6">
                            <div class="d-flex align-items-center mb-3">
                                <div class="bg-primary rounded-circle p-2 mr-3"><i class="fas fa-car text-white"></i></div>
                                <div>
                                    <h6 class="font-weight-semi-bold ms-2 mb-0">${publication.garagePublicacion} Garage</h6>
                                    <small class="text-muted ms-2">Garage deck</small>
                                </div>
                            </div>
                        </div>
                    </c:if>

                </div>
                <div class="col w-70 mt-4 me-6">
                    <div class="card border-0 shadow-sm mb-4">
                        <div class="card-body">
                            <h5 class="font-weight-semi-bold">Price mensual</h5>
                            <div class="row align-items-start">
                                <h3 class="font-weight-semi-bold mb-4 col">$ ${publication.pricePublicacion.intValue()} ARS</h3>
                                <%--                                    -----------------ACÁ VA EL BOTÓN DE MERCADO PAGO-----------------------------------------------------%>
                                <a href="#" class="btn btn-primary btn-block col">Alquilar</a>
                                <%--                                    <div class="cho-container"></div>--%>
                                <%--                                            -----------------ACÁ VA EL BOTÓN DE MERCADO PAGO-------------------------------------------------------------%>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row px-xl-5">
                <div class="col">
                    <div class="card border-0 shadow-sm mb-4">
                        <div class="card-body">
                            <h5 class="font-weight-semi-bold">Descripción</h5>
                            <p class="text-muted">${publication.descriptionPublicacion}</p>
                        </div>
                    </div>
                </div>
            </div>

<%--            Listado de     comforts de la base de datos--%>
            <c:if test="${!publication.characteristicsComforts.isEmpty()}">
            <div class="row px-xl-5">
                <div class="col">
                    <div class="card border-0 shadow-sm mb-4">
                        <div class="card-body">
                            <h5 class="font-weight-semi-bold">    Comforts</h5>
                            <div class="row mt-3">
                                <div class="col-lg-6">
                                    <ul class="list-unstyled">

<%--                                        crear una variable para contar las iteraciones--%>


                                        <c:forEach items="${publication.characteristicsComforts}" var="comfort">
                                            <li class="mb-2">
                                                <div class="d-flex align-items-center">
                                                    <div class="bg-primary
                                                        rounded-circle p-2 mr-3" style="width: 32px; height: 32px"><i class="fas fa-check text-white align-items-center"></i></div>
                                                    <div>
                                                        <h6 class="font-weight-semi-bold ms-2 mb-0">${comfort.characteristicName}</h6>
                                                    </div>
                                                </div>
                                            </li>
                                        </c:forEach>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            </c:if>

<%--&lt;%&ndash;                                        Solamente visualiza 5     comforts&ndash;%&gt;--%>
<%--                                        @if($loop->iteration <= 5)--%>
<%--                                        <li class="mb-2"><i class="fas fa-check text-primary mr-2"></i>{{$comfort->name_characteristic_  comfort}}</li>--%>
<%--                                        @endif--%>

<%--&lt;%&ndash;                                        Cuando es mayor a 5 lo coloca dentro de un span oculto y con javascript lo muestra&ndash;%&gt;--%>
<%--                                        @if($loop->iteration > 5)--%>

<%--                                            @if($loop->iteration == 6)--%>
<%--                                                <span id="dots"></span><span id="more" style="display: none">--%>
<%--                                            @endif--%>
<%--                                            <li class="mb-2"><i class="fas fa-check text-primary mr-2"></i>{{$comfort->name_characteristic_  comfort}}</li>--%>
<%--                                                @if($loop->last)--%>
<%--                                                    </span>--%>
<%--                                                @endif--%>
<%--                                            @endif--%>

<%--                                        @endforeach--%>
<%--                                    </ul>--%>
<%--                                </div>--%>
<%--&lt;%&ndash;                                si el array has más de 5     comforts, muestra el botón de ver más&ndash;%&gt;--%>
<%--                                @if($publication->characteristic_    comforts()->count() > 5)--%>
<%--                                    <button onclick="myFunction()" id="myBtn" class="btn btn-link text-decoration-none text-primary p-0 align-items-center justify-content-center ">Mostrar más<i class="fas fa-chevron-down ms-2"></i></button>--%>
<%--                                @endif--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>

<%--            Ubicación de la publicación--%>
            <div class="row px-xl-5">
                <div class="col">
                    <div class="card border-0 shadow-sm mb-4">
                        <div class="card-body">
                            <div class="row">
                                <div class="col-lg-6">
                                    <h5 class="font-weight-semi-bold">Ubicación</h5>
                                    <p class="text-muted">${publication.callePublicacion} - ${publication.heightPublicacion} - ${publication.idCity.city}</p>
                                </div>
                                <div class="col-lg-6">
                                    <div class="d-flex align-items-center justify-content-lg-end">
                                        <div class="bg-primary p-2 mr-3 rounded-circle position-relative" style="height: 32px; width: 32px;"><i class="fas fa-map-marker-alt text-white w-50 h-50 position-absolute"></i></div>
                                        <div>
                                            <a class="font-weight-semi-bold ms-2 mb-0 h6" href="https://www.google.com/maps/search/?api=1&query=${publication.latitudPublicacion}+${publication.longitudePublicacion}&zoom=20" target="_blank">Ver en el mapa</a> <br>
                                            <small class="text-muted ms-2">${publication.callePublicacion} - ${publication.heightPublicacion} - ${publication.idCity.city}</small>
                                        </div>
                                    </div>
                                </div>

<%--                                Mapa PROVICIONAL--%>
                                <div class="w-90 m-auto">
                                    <div class="form-row mt-4 shadow-none p-1 mb- bg-light rounded">
                                        <div id="map" style="width: 100%; height:600px"></div>
                                    </div>
                                </div>


                            </div>
                        </div>
                    </div>
                </div>
            </div>


            <%--    JS IMPORTS--%>
            <tags:js_imports/>


        </div>

</div>
</div>

<%--importar script de google maps--%>
<script>
    function iniciarMap(){


        // establecer un marker con el imag map-marker-2-512.png
        // var icono = {
        //     url: '../../assets/img/map-marker-2-512.png',
        //     scaledSize: new google.maps.Size(30, 30),
        //     origin: new google.maps.Point(0,0),
        //     anchor: new google.maps.Point(16, 31)
        //
        // };

        // Obtenemos la posicion de la publication
        var posicion = {lat: ${publication.latitudPublicacion}, lng: ${publication.longitudePublicacion}};

        // Creamos el mapa
        var map = new google.maps.Map(document.getElementById('map'), {
            zoom: 15,
            center: posicion
        });

        // Creamos el marker
        var marker = new google.maps.Marker({
            position: posicion,
            map: map,
            // icon: icono
        });


    }
</script>
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDFRitCKrHHCHbh9KlJed9j697DDQEW-Go&callback=iniciarMap"></script>
</body>
</html>
