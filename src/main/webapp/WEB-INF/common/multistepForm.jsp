<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: gq
  Date: 27/09/2022
  Time: 16:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<tags:jsp_imports/>
<html>
<head>
    <title>Title</title>
  <link href="../../assets/css/multistep.css" rel="stylesheet" />
  <link rel="stylesheet" href="https://unpkg.com/leaflet@1.9.1/dist/leaflet.css" integrity="sha256-sA+zWATbFveLLNqWO2gtiw3HL/lh1giY/Inf1BJ0z14=" crossorigin=""/>
  <link href="../../assets/css/dragAndDrop.css" rel="stylesheet">

</head>

<body>
<div class="multisteps-form">
  <!--progress bar-->
  <div class="row mt-5">
    <div class=" ml-auto mr-auto mb-4">
      <div class="multisteps-form__progress">
        <button class="multisteps-form__progress-btn js-active" type="button" title="User Info" id="progresTipo">Tipo de Propiedad</button>
        <button class="multisteps-form__progress-btn" type="button" title="Address" id="progresUbicacion">Ubicación</button>
        <button class="multisteps-form__progress-btn" type="button" title="Order Info" id="progresCharacteristic">Características</button>
        <button class="multisteps-form__progress-btn" type="button" title="Comments" id="progresImag">Imágenes</button>
        <button class="multisteps-form__progress-btn" type="button" title="Comments" id="progres  Comfort">Caracerísticas específicas</button>
      </div>
    </div>
  </div>
  <!--form panels-->
  <div class="row">
    <div class="m-auto col-12 col-lg-8 ">


      <div class="multisteps-form__form">

      <%--@elvariable id="publication" type=""--%>
      <form:form role="form" method="post" action="/publication/nuevaPublicacion" modelAttribute="publication"  class="text-start" id="form" enctype="multipart/form-data" >

        <!--PANEL TIPO DE PROPIEDAD-->
        <div class="multisteps-form__panel shadow p-4 rounded bg-white js-active" data-animation="scaleIn">
          <h3 class="multisteps-form__title">Tipo de Propiedad</h3>
          <div class="multisteps-form__content">

            <div class="form-row mt-4 shadow-none p-3 mb-5 bg-light rounded">
                <%--@elvariable id="types" type=""--%>
              <form:select path="idTipo" class="multisteps-form__select form-control" id="inputTipo">
                <option value="">Seleccione un type de propiedad (*)</option>
                <c:forEach items="${types}" var="type">
                  <form:option value="${type.id}" label="${type.type}" />
                </c:forEach>
              </form:select>

              <form:errors path="idTipo" cssClass="text-danger" element="div"/>
                  <div class="text-danger"  id="divTipo" ></div>


            </div>
<%--            Los campos marcados con * son obligatorios--%>
            <div>Los campos marcados con un (*) son obligatorios</div>
            <div class="button-row d-flex mt-4">
              <button class="btn btn-primary ml-auto js-btn-next" type="button" title="Next">Siguiente</button>
            </div>
          </div>
        </div>


        <!--PANEL UBICACIÓN-->
        <div class="multisteps-form__panel shadow p-4 rounded bg-white" data-animation="scaleIn">
          <h3 class="multisteps-form__title">Direccion</h3>
          <div class="multisteps-form__content">



            <div>
              <div class="input-group input-group-outline my-3 ">
                <label class="form-label">Street (*)</label>
                <form:input class="multisteps-form__input form-control " type="text" path="callePublicacion" id="inputStreet"/>
              </div>
              <div class="text-danger"  id="divStreet" ></div>
            </div>

            <div class="mt-5">
              <div class="input-group input-group-outline my-3 ">
                <label class="form-label">Height (*)</label>
                <form:input class="multisteps-form__input form-control" type="number" path="heightPublicacion"  id="inputHeightPublicacion"/>
              </div>
              <div class="text-danger"  id="divHeight" ></div>
            </div>

            <div class="form-row mt-4 shadow-none p-3 mb-5 bg-light rounded">
              <select class="multisteps-form__select form-control" name="province" id="inputProvince">
                <option value="">Seleccione una province (*)</option>
                <option value="Misiones">Misiones</option>
              </select>
              <div class="text-danger"  id="divProvince" ></div>
            </div>

            <div class="form-row mt-4 shadow-none p-3 mb-5 bg-light rounded">
              <form:select path="idCity" class="multisteps-form__select form-control" id="inputCity">
                <option value="">Seleccione una city (*)</option>
                <c:forEach items="${cities}" var="city">
                  <form:option value="${city.id}" label="${city.city}"/>
                </c:forEach>
              </form:select>
              <div class="text-danger"  id="divCity" ></div>
            </div>


            <div class="form-row mt-4  shadow-none p-3 mb-5 bg-light rounded">
              <div class="col">
<%--                  <div id="map"></div>--%>
                <div id="map" style="width: 100%; height:450px"></div>

<%--                <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d4198.158044205938!2d-55.77119880812339!3d-27.77231641207666!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x94563758e73ae093%3A0x4642bcf36db682e7!2sKulipadel!5e0!3m2!1ses-419!2sar!4v1664591023556!5m2!1ses-419!2sar"  width="100%" height="450" frameborder="0" style="border:0" allowfullscreen></iframe>--%>

                <form:input type="hidden" id="latitude" name="latitude" path="latitudPublicacion" />
                <form:input type="hidden" id="longitude" name="longitude" path="longitudePublicacion"/>
                <div class="text-danger"  id="divMapa" ></div>
              </div>
            </div>

          <div class="button-row d-flex mt-4 " >
            <div class="col">
              <button class="btn btn-primary js-btn-prev" type="button" title="Prev">Anterior</button>
            </div>
            <div class="col text-md-end">
              <button class="btn btn-primary js-btn-next " type="button" title="Next">Siguiente</button>
            </div>
          </div>
        </div>
        </div>

        <!--PANEL CARACTERÍSTICAS-->
        <div class="multisteps-form__panel shadow p-4 rounded bg-white" data-animation="scaleIn">
          <h3 class="multisteps-form__title">Characteristics Generales</h3>
          <div class="multisteps-form__content">

            <div class="mt-5">
              <div class="input-group input-group-outline my-3 ">
                <label class="form-label">Environments</label>
                <form:input type="number" class="form-control"  path="environmentsPublicacion" id="inputEnvironment"/>
              </div>
              <div class="text-danger"  id="divEnvironment" ></div>
            </div>


            <div class="mt-5">
              <div class="input-group input-group-outline my-3">
                <label class="form-label">Bedrooms</label>
                <form:input type="number" class="form-control"  path="bedroomsPublicacion" id="inputBedroom"/>
              </div>
              <div class="text-danger"  id="divBedroom" ></div>
            </div>

            <div class="mt-5">
              <div class="input-group input-group-outline my-3 ">
                <label class="form-label">Baños</label>
                <form:input type="number" class="form-control" path="bathsPublicacion" id="inputBath"/>
              </div>
              <div class="text-danger"  id="divBath" ></div>
            </div>

            <div class="mt-5">
              <div class="input-group input-group-outline  my-3 ">
                <label class="form-label">Garage</label>
                <form:input type="number" class="form-control"  path="garagePublicacion" id="inputGarage"/>
              </div>
              <div class="text-danger"  id="divGarage" ></div>
            </div>

            <div class="mt-5">
              <div class="input-group input-group-outline my-3 ">
                <label class="form-label">Surface deck</label>
                <form:input type="number" class="form-control"  path="surfaceDeckHome" id="inputSurfaceDeck"/>
              </div>
              <div class="text-danger"  id="divSurfaceDeck" ></div>
            </div>

            <div class="mt-5">
              <div class="input-group input-group-outline my-3 ">
                <label class="form-label">Surface total</label>
                <form:input type="number" class="form-control"  path="surfaceTotalLand" id="inputSurfaceTotal"/>
              </div>
              <div class="text-danger"  id="divSurfaceTotal" ></div>
            </div>

            <div class="mt-5">
              <div class="input-group input-group-outline my-3 ">
                <label class="form-label">Price (*)</label>
                <form:input type="number" class="form-control" path="pricePublicacion"  id="inputPrice"/>
              </div>
              <div class="text-danger"  id="divPrice" ></div>
            </div>

          </div>

          <div class="button-row d-flex mt-4 " >
            <div class="col">
              <button class="btn btn-primary js-btn-prev" type="button" title="Prev">Anterior</button>
            </div>
            <div class="col text-md-end">
              <button class="btn btn-primary js-btn-next " type="button" title="Next">Siguiente</button>
            </div>
          </div>

        </div>

        <!--PANEL IMAGENES-->
        <div class="multisteps-form__panel shadow p-4 rounded bg-white" data-animation="scaleIn">
          <h3 class="multisteps-form__title">Photos de la propiedad. Puede cargar hasta 3 images</h3>
          <div class="multisteps-form__content">


            <div class="mt-5">
              <div class="input-group input-group-outline my-3">
                <label class="form-label">Título (*)</label>
                <form:input class="multisteps-form__input form-control" type="text" path="qualificationPublicacion"  id="inputQualification"/>
              </div>
              <div class="text-danger"  id="divQualification" ></div>
            </div>

            <div class="mt-5">
              <div class="input-group input-group-outline my-3 is-focused">
                <label class="form-label">Descripción de la publicación (*)</label>
                <form:textarea class="multisteps-form__input form-control" type="text" path="descriptionPublicacion" id="inputDescription"/>
              </div>
              <div class="text-danger"  id="divDescription" ></div>
            </div>

            <div class="form-row mt-4 shadow-none p-3 mb-5 bg-light rounded">
              <div class="col">
<%--                <input type="file" name="file[]" placeholder="Image" multiple id="inputImag" accept="image/*"/>--%>

                <div class="drop-area">
                  <div id="preview"></div>
                  <h2>Arrastra y suelta la imag</h2>
                  <span>O</span>
                  <button type="button">Selecciona tus archivos</button>
<%--                  <!-- <input type="file" multiple> -->--%>
                  <input type="file" name="file[]" placeholder="Imag" multiple id="input-file" accept="image/*" hidden/>
<%--                  <input type="file" name="" id="input-file"  multiple />--%>
                </div>


<%--                accept="image/png,image/jpeg"--%>
                <div class="text-danger"  id="divImages" ></div>
              </div>
            </div>

<%--            <div class="form-row mt-4  shadow-none p-3 mb-5 bg-light rounded">--%>
<%--              <div class="col">--%>
<%--                <input type="file" placeholder="Image" />--%>
<%--              </div>--%>
<%--            </div>--%>

<%--            <div class="form-row mt-4  shadow-none p-3 mb-5 bg-light rounded">--%>
<%--              <div class="col">--%>
<%--                <input type="file" placeholder="Image"/>--%>
<%--              </div>--%>
<%--            </div>--%>



          </div>

          <div class="button-row d-flex mt-4 " >
            <div class="col">
              <button class="btn btn-primary js-btn-prev" type="button" title="Prev">Anterior</button>
              </div>
            <div class="col text-md-end">
                <button class="btn btn-primary js-btn-next " type="button" title="Next">Siguiente</button>
            </div>
          </div>

        </div>

        <!--PANEL     Comforts-->
        <div class="multisteps-form__panel shadow p-4 rounded bg-white" data-animation="scaleIn">
          <h3 class="multisteps-form__title">    Comforts</h3>
          <div class="multisteps-form__content">


          <c:forEach items="${    comforts}" var="comfort">

            <div class="form-row mt-4  shadow-none p-3 mb-5 bg-light rounded">
              <h6>${comfort.comfort}</h6>
              <c:forEach items="${characteristic    Comforts}"  var="characteristic" >

                <c:if test="${characteristic.id  Comfort.id  Comfort == comfort.id  Comfort}">
                    <div class="col form-check-inline">
                      <form:checkbox path="characteristics    Comforts" value="${characteristic.idCharacteristic}" class="form-check-input "/>
                      <label class="form-check-label" >${characteristic.nameCharacteristic}</label>
                    </div>
                </c:if>

              </c:forEach>
            </div>

          </c:forEach>



          </div>



          <div class="button-row d-flex mt-4 " >
            <div class="col">
              <button class="btn btn-primary js-btn-prev" type="button" title="Prev">Anterior</button>
            </div>
            <div class="col text-md-end">
              <button class="btn btn-success ml-auto" type="submit" title="Send" id="ENVIAR">Enviar</button>
            </div>
          </div>

        </div>

      </form:form>
      </div>
    </div>
  </div>
</div>

<script src="../../assets/js/plugins/multistep.js"></script>
<%--<script src="https://unpkg.com/leaflet@1.9.1/dist/leaflet.js" integrity="sha256-NDI0K41gVbWqfkkaHj15IzU7PtMoelkzyKp8TOaFQ3s=" crossorigin=""></script>--%>
<script src="../../assets/js/createMap.js"></script>
<script src="../../assets/js/validacionCrear.js"></script>
<script src="../../assets/js/dragAndDrop.js"></script>
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDFRitCKrHHCHbh9KlJed9j697DDQEW-Go&callback=iniciarMap"></script>


</body>
</html>

