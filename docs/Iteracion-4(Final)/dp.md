# Trabajo en equipo
El lider de la cuarta iteracion sera: Emiliano Blazco

La division de las Historias de User sera la siguiente:

- Dar de baja un user (baja lógica)
    - **Encargados**: Marcela Stigelmeier y Matias Fernandez
  
- Agregar un alquiler a Favorites
    - **Encargados**: Marcela Stigelmeier, Matias Fernandez, Emiliano Blazco, Ariel Cristaldo, Guillermo Quintana, Marcelo Kachuk
  
- Eliminar un alquiler de Favorites
    - **Encargados**: Emiliano Blazco y Ariel Cristaldo
  
- Modificar propiedad(Implementacion de la funcionalidad faltante de la Iteracion 1)
    - **Encargados**: Guillermo Quintana, Marcelo Kachuk

# Tablero de Proyecto

<img src="../../src/main/webapp/assets/img/images_iteraciones/Tablero_4F.jpeg" width="800"/>

# Diseño OO

<img src="../../src/main/webapp/assets/img/images_iteraciones/DC_ite_4.png" width="800"/>

# Wireframe y caso de uso

## Wireframe Dar de baja un user (baja lógica)

<img src="../../src/main/webapp/assets/img/images_iteraciones/baja_user.jpeg" width="800"/>

<br><br>
**Caso de uso**: Dar de baja un user <br>
**Descripción**: El user ingresa a su profile y busca la opción para dar de baja su user, presiona sobre el botón "Dar de baja" y su user se desactiva <br>
**Precondición**:  Que el user se encuentre con la sesión iniciada <br>
**Postcondición**:  Que el user se haya dado de baja<br> 

**Flujo Típico de eventos**:
<table>
  <tr>
    <th>Actor</th>
    <th>Sistema</th>
  </tr>
  <tr>
    <td><b>1</b>.  Este caso de uso comienza cuando el user una vez <br>en su profile, hace click en el boton “Dar de baja” <br>
    <td></td>
  </tr>
  <tr>
    <td></td>
    <td><b>2</b>. El sistema despliega el mensaje “Una vez confirmada <br> esta acción no has retroceso” y un formulario <br> con los siguientes campos:<br>
    - Campo 1: E-Mail<br>
    - Campo 2: Password<br>
  </tr>
  <tr>
    <td><b>3</b>. El user selecciona el campo con la etiqueta <br>“E-Mail” y lo completa<br>
    <td></td>
  </tr>
  <tr>
    <td><b>4</b>. El user selecciona el campo con la etiqueta <br>“Password” y lo completa<br>
    <td></td>
  </tr>
  <tr>
    <td><b>5</b>. Una vez completos los campos el user selecciona <br> el botón “Dar de baja”
    <td></td>
  </tr>
  <tr>
    <td></td>
    <td><b>6</b>. El sistema valida los campos cargados y muestra el <br>mensaje “Este user fue dado de baja correctamente”
 </tr>
</table>

<u>**Flujo Alternativo de Eventos**.</u>  

**Paso 6**:  El sistema detecta que un campo no fue cargado correctamente e indica cuál es el campo que no cumple con lo requerido.

## Wireframe Agregar un alquiler a Favorites

<img src="../../src/main/webapp/assets/img/images_iteraciones/agregar_fav.jpeg" width="800"/>

<br><br>
**Caso de uso**: Agregar un alquiler a Favorites<br>
**Descripción**: El inquilino dentro de un alquiler seleccionado se dirige a la opción de agregar a favorites y el sistema agrega a la lista de favorites el alquiler seleccionado<br>
**Precondición**:El user debe encontrarse dentro de una publicación<br>
**Postcondición**:  Se agregó un alquiler a favorites<br>

**Flujo Típico de eventos**:
<table>
  <tr>
    <th>Actor</th>
    <th>Sistema</th>
  </tr>
  <tr>
    <td><b>1</b>. Este caso de uso comienza cuando el inquilino  <br>se encuentra dentro de la publicación elegida.<br>
    <td></td>
  </tr>
  <tr>
    <td><b>2</b>. El inquilino selecciona la opción de agregar a favorites <br> con un icono de corazón asociado<br>
    <td></td>
  </tr>
  <tr>
    <td></td>
    <td><b>6</b>. El sistema cambia el state de la publicación a favorites <br>y guarda la publicación en la lista de favorites.<br>
 </tr>
</table>


<u>**Flujo Alternativo de Eventos**.</u>  

**Paso**: El sistema no puede agregar a favorites la publicación. Pide que se vuelva a cargar la publicación

<br><br>

## Wireframe Eliminar un alquiler de Favorites

<img src="../../src/main/webapp/assets/img/images_iteraciones/quitar_fav.jpeg" width="800"/>

<br><br>
**Caso de uso**: Eliminar un alquiler de favorites  <br>
**Descripción**: Un user quiere eliminar una publicación de su lista de publicaciones favoritas.<br>
**Precondición**: El user debe ingresar a su cuenta.<br>
**Postcondición**: La publicación se elimina de la lista de favorites (base de datos). <br>

**Flujo Típico de eventos**:
<table>
  <tr>
    <th>Actor</th>
    <th>Sistema</th>
  </tr>
  <tr>
    <td><b>1.</b> Esta caso de uso comienza cuando un user ingresa a su profile y selecciona la opción de "Ver favorites".</td>
    <td></td>
  </tr>
  <tr>
    <td></td>
    <td><b>2.</b>El sistema despliega una ventana con las publicaciones etiquetadas como favorites por el user.</td>
  </tr>
  <tr>
    <td><b>3.</b>El user hace click al botón de "Eliminar" al lado de la publicación.</td>
    <td></td>
  </tr>
  <tr>
    <td></td>
    <td><b>4.</b>El sistema recarga la lista y muestra los favorites actualizados.</td>
</table>

<u>**Flujo Alternativo de Eventos**.</u>  

**Paso 2.1**: El user no posee publicaciones en su lista de favorites, por tanto el sistema da aviso de ello.<br>
**Paso 4.1**: El user eliminó el último favorite, por tanto el sistema avisa que ya no posee favorites.

<br></br>

# Backlog de iteraciones
**Iteracion 4**
- Dar de baja un user (baja lógica)
- Agregar un alquiler a Favorites
- Eliminar un alquiler de Favorites
- Modificar propiedad

# Tareas

<br><br>

## **Tareas para Dar de baja un user (baja lógica)**

**Como**  User <br>
**Quiero** dar de baja un user  <br>
**Para** eliminar una cuenta registrada <br>

<u>Criterios de aceptación</u>

- El User debe ingresar al sistema con su user.<br>
- El user debe completar los campos requeridos correctamente.<br>


<u>Las siguientes tareas comprenderán el desarrollo de la Historia de User:</u>

- Creación de wireframe
    - Creación del formulario donde contendrán los siguientes elementos
        - Incorporación de botón con la funcionalidad de dar de baja y la etiqueta “Dar de baja
- Descripción del Uso del wireframe (Caso de Uso real)
- Creación del modelo de datos(Entidad/es de Base de datos)
- Validación de campos con sus respectivas alertas


## **Tareas para Agregar un alquiler a Favorites**

**Como**  Inquilino <br>
**Quiero**  agregar un alqu8iler a favorite <br>
**Para** poder saber cuales son los alquileres que más me interesaron <br>

<u>Criterios de aceptación</u>

- Se debe poder ver una lista con las publicaciones favoritas de un inquilino

<u>Las siguientes tareas comprenderán el desarrollo de la Historia de User:</u>

- Creación de wireframe
    - Creación del formulario donde contendrán los siguientes elementos
        - Agregar un botón con un icono de un corazón para agregar a favorites


- Descripción del Uso del wireframe (Caso de Uso real)
- Creación del modelo de datos(Entidad/es de Base de datos)
- Validación de campos con sus respectivas alertas

<br><br>

## **Tareas para Eliminar un alquiler de Favorites**

**Como** user del sistema<br> 
**Quiero** eliminar un alquiler de favorites<br>
**Para** dejar de seguir una publicación que ya no le interesa.

<u>Criterios de aceptación</u>
- La lista se debe actualizar de inmediato.

<u>Las siguientes tareas comprenderán el desarrollo de la Historia de User:</u>

- Creación de wireframe
- Descripción del Uso del wireframe (Caso de Uso real)
- Creación de la funcionalidad.

<br><br>

# Retrospectiva de la Iteracion 3

Teniendo en cuenta lo realizado en la release 3 podemos decir que hubo un gran aporte por parte de todos los integrantes del grupo
cada uno cumpliendo con sus tareas asignadas y trabajando de manera correcta con el repositorio de github.
Por otra parte se realizaron de manera completa las 3 actividades (Consultar ubicación, Modificar datos de user, Consultar user) planteadas para la iteracion. 
Cumpliendo con su documentacion, desarrollo de wireframes e implemntacion de funcionalidades
Ademas de esto se mantuvo la forma de trabajo de a pares, siguiendo con esta metodologia para las siguientes iteraciones.
