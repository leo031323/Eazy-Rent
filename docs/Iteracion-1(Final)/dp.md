# Trabajo en equipo
El lider de la primera iteracion sera: Matias Fernandez

La division de las Historias de User sera la siguiente:
- Crear un nuevo user
    - Encargados: Marcela Stigelmeier y Matias Fernandez

- Ingresar user
    - Encargados: Emiliano Blazco y Ariel Cristaldo

- Registrar propiedad
    - Encargados: Marcela Stigelmeier, Matias Fernandez, Emiliano Blazco, Ariel Cristaldo, Guillermo Quintana, Marcelo Kachuk 

- Modificar propiedad
    - Encargados: Guillermo Quintana, Marcelo Kachuk 

# Diseño OO

<img src="../../src/main/webapp/assets/img/images_iteraciones/DC_ite_1-2.jpeg" width="800"/>

# Wireframe y caso de uso

## Wireframe Registrar User

<img src="../../src/main/webapp/assets/img/images_iteraciones/Registrar_user.jpeg" width="800"/>

<br><br>
**Caso de uso**: Registrar User  
**Descripción**:  El user quiere crear un name de user y password para poder ingresar al sistema, se dirige a la sección  “Iniciar sesión” luego a la parte inferior en “cree una cuenta” donde deberá completar los campos requeridos (E-Mail, DNI, Name, Lastname, Password) de esta manera podrá generar su user y password.  
**Precondición**: Disponer de un E-Mail válido   
**Postcondición**: El user fué registrado   

**Flujo Típico de eventos**:
<table>
  <tr>
    <th>Actor</th>
    <th>Sistema</th>
  </tr>
  <tr>
    <td><b>1</b>. Este caso de uso comienza cuando <br>el user se dirige al apartado de <br>“Cree una cuenta”</td>
    <td></td>
  </tr>
  <tr>
    <td></td>
    <td><b>2</b>. El sistema despliega un formulario de Identificación con seis campos:
    <br>Campo-1: E-mail
    <br>Campo-2: DNI
    <br>Campo-3: Name
    <br>Campo-4. Lastname
    <br>Campo-5: Password
    <br>Campo-6: Confirme su password
  </tr>
  <tr>
    <td><b>3</b>. El user selecciona el campo con la etiqueta asociada “ E-mail” y lo completa</td>
    <td></td>
  </tr>
  <tr>
    <td><b>4</b>. El user selecciona el campo con la etiqueta asociada “DNI” y lo completa</td>
    <td></td>
  </tr>
  <tr>
    <td><b>5</b>. El user selecciona el campo con la etiqueta asociada “Name” y lo completa</td>
    <td></td>
  </tr>
  <tr>
    <td><b>6</b>. El user selecciona el campo con la etiqueta asociada “Lastname” y lo completa</td>
    <td></td>
  </tr>
  <tr>
    <td><b>7</b>. El user selecciona el campo con la etiqueta asociada “Password” y lo completa</td>
    <td></td>
  </tr>
  <tr>
    <td><b>8</b>. El user selecciona el campo con la <br>etiqueta asociada “Confirme su password” y lo <br>completa</td>
    <td></td>
  <tr>
    <td><b>9</b>. El user presiona sobre el botón con la etiqueta “REGISTRARME”</td>
    <td></td>
  <tr>
    <td></td>
    <td><b>10</b>. El sistema valida los campos cargados <br>y muestra el mensaje "Registro exitoso" <br> el cual conHas un boton con la etiqueta "OK"</td>
 </tr>
   <tr>
    <td><b>11</b>. El user presiona el boton con la <br>etiqueta  “OK”</td>
    <td></td>
  </tr>
  <tr>
    <td></td>
    <td><b>12</b>. El sistema redirecciona al user a la pantalla del apartado “Iniciar sesión” <br> (Al login) </td>
 </tr>
</table>

<u>**Flujo Alternativo de Eventos**.</u>  

**Paso 8**:  El sistema detecta que la password ingresada en el campo “Confirme su password”no coincide con la del campo “Password”. Muestra un mensaje de error y remarca con color rojo el cuadro con la password errónea.

## Wireframe Ingresar User

<img src="../../src/main/webapp/assets/img/images_iteraciones/Login.jpeg" width="800"/>

<br><br>
**Caso de uso**: Ingresar User  
**Descripción**: El user quiere ingresar a su cuenta ya creada en la plataforma, se dirige al apartado de Inicio de Sesión e ingresa los datos de su cuenta.  
**Precondición**:
- Tener una cuenta registrada   

**Postcondición**: ---  

**Flujo Típico de eventos**:
<table>
  <tr>
    <th>Actor</th>
    <th>Sistema</th>
  </tr>
  <tr>
    <td><b>1</b>. Este caso de uso comienza cuando <br>el user se dirige al apartado de <br>“Inicio de  Sesion”</td>
    <td></td>
  </tr>
  <tr>
    <td></td>
    <td><b>2</b>. El sistema despliega un formulario de <br>Identificación con dos campos los <br>cuales have asociado la etiqueta de
    <br>Campo-1: User o E-mail
    <br>Campo-2: Password</td>
  </tr>
  <tr>
    <td><b>3</b>. El user selecciona el campo con la etiqueta asociada “User o E-mail” <br>y lo completa</td>
    <td></td>
  </tr>
  <tr>
    <td><b>4</b>. El user selecciona el campo con la <br>etiqueta asociada “Password” y lo <br>completa</td>
    <td></td>
  <tr>
    <td><b>5</b>. El user presiona sobre el botón con la etiqueta “Iniciar Sesión”</td>
    <td></td>
    
  </tr>
  <tr>
    <td></td>
    <td><b>6</b>. El sistema valida los campos cargados <br>y redirecciona al user a la pantalla principal con su cuenta cargada</td>
 </tr>
</table>


<u>**Flujo Alternativo de Eventos**.</u>  

**Paso 2**: El sistema no logra cargar los campos. Se reinicia la interfaz  
**Paso 4.1**: El sistema detecta que se cargó un user erróneo en el campo “User o E-mail”. Muestra un mensaje de error y remarca con color rojo el cuadro con el user erróneo  
**Paso 4.2**: El sistema detecta que la password ingresada no coincide con el user . Muestra un mensaje de error y remarca con color rojo el cuadro con la password errónea

<br><br>

## Wireframe Registrar Propiedad

<img src="../../src/main/webapp/assets/img/images_iteraciones/Registrar_Propiedad.jpeg" width="800"/>

<br><br>
**Caso de uso**: Registrar Propiedad  
**Descripción**: El propietario ingresa en el apartado de propiedades y carga información relacionada a la propiedad a alquilar como ser la localidad/province donde se encuentra la propiedad, dirección de la propiedad, type de propiedad (home, local, habitación única), price, Imag del lugar y confirma los datos cargados.  
**Precondición**: 
- Poseer una cuenta creada. Que el user se encuentre con su sesión iniciada.  

**Postcondición**: 
- Se registró de manera exitosa la propiedad

**Flujo Típico de eventos**:
<table>
  <tr>
    <th>Actor</th>
    <th>Sistema</th>
  </tr>
  <tr>
    <td><b>1</b>. Este caso de uso comienza cuando el propietario 
    ingresa en el apartado de Publicar presionando el botón ”Publicar”.</td>
    <td></td>
  </tr>
  <tr>
    <td></td>
    <td><b>2</b>. El sistema despliega un formulario de 5 pasos que conHas distintos campos
Paso 1: <br> Campo-1: Tipo de propiedad</td>
  </tr>
  <tr>
    <td><b>3</b>. El propietario selecciona el type de propiedad utilizando la lista desplegable que has la etiqueta asociada “Tipo de propiedad” y presiona en el botón de siguiente para avanzar en el formulario.</td>
    <td></td>
  </tr>
  <tr>
    <td></td>
    <td><b>4</b>. El sistema despliega el segundo paso del formulario con los campos Paso 2: <br> Campo-1: Street <br> Campo-2: Height <br> Campo-3: Province <br> Campo-4: City <br> Campo-5: Ubicación</td>
  <tr>
    <td><b>5</b>. El propietario selecciona el campo con la etiqueta asociada “Street” y lo completa.</td>
    <td></td>
  </tr>
  <tr>
    <td><b>6</b>. El propietario selecciona el campo con la etiqueta asociada “Height” y lo completa.</td>
    <td></td>
 </tr>
 <tr>
    <td><b>7</b>. El propietario selecciona una de las opciones de la lista desplegable con la etiqueta asociada “Province” y lo completa.</td>
    <td></td>
 </tr>
 <tr>
    <td><b>8</b>. El propietario selecciona una de las opciones de la lista desplegable con la etiqueta asociada “City” y lo completa.</td>
    <td></td>
 </tr>
 <tr>
    <td><b>9</b>. El propietario selecciona en el mapa asociado con la etiqueta asociada “Ubicación” la ubicación real de la propiedad, lo completa y presiona en el botón de siguiente para avanzar en el formulario.</td>
    <td></td>
 </tr>
 <tr>
    <td></td>
    <td><b>10</b>. El sistema despliega el tercer paso del formulario con los campos Paso 3: <br> Campo-1: Environments <br> Campo-2: Bedrooms <br> Campo-3: Baños <br> Campo-4: Garage <br> Campo-5: Surface deck <br> Campo-6: Surface total <br> Campo-7: Price
</td>
 </tr>
 <tr>
    <td><b>11</b>. El propietario selecciona el campo con la etiqueta asociada “Environments” y lo completa.</td>
    <td></td>
 </tr>
 <tr>
    <td><b>12</b>. El propietario selecciona el campo con la etiqueta asociada “Bedrooms” y lo completa.</td>
    <td></td>
 </tr>
 <tr>
    <td><b>13</b>. El propietario selecciona el campo con la etiqueta asociada “Baños” y lo completa.</td>
    <td></td>
 </tr>
 <tr>
    <td><b>14</b>. El propietario selecciona el campo con la etiqueta asociada “Garage” y lo completa.</td>
    <td></td>
 </tr>
 <tr>
    <td><b>15</b>. El propietario selecciona el campo con la etiqueta asociada “Surface deck” y lo completa.</td>
    <td></td>
 </tr>
 <tr>
    <td><b>16</b>. El propietario selecciona el campo con la etiqueta asociada “Surface total” y lo completa.</td>
    <td></td>
 </tr>
 <tr>
    <td><b>17</b>. El propietario selecciona el campo con la etiqueta asociada “Price”, lo completa y presiona en el botón de siguiente para avanzar en el formulario.</td>
    <td></td>
 </tr>
 <tr>
    <td></td>
    <td><b>18</b>. El sistema despliega el cuarto paso del formulario con los campos Paso 4: <br> Campo-1: Título de la Publicación <br> Campo-2: Descripción <br> Campo-3: Photo de la propiedad
</td>
 </tr>
 <tr>
    <td><b>19</b>. El propietario selecciona el campo con la etiqueta asociada “Título de la Publicación” y lo completa.</td>
    <td></td>
 </tr>
 <tr>
    <td><b>20</b>. El propietario selecciona el campo con la etiqueta asociada “Descripción” y lo completa.</td>
    <td></td>
 </tr>
 <tr>
    <td><b>21</b>. El propietario selecciona el campo con la etiqueta asociada “Photo de la propiedad” y carga de una a tres photos relacionadas a las propiedad y presiona en el botón de siguiente para avanzar en el formulario.</td>
    <td></td>
 </tr>
 <tr>
    <td></td>
    <td><b>22</b>. El sistema despliega el quinto paso del formulario con los campos Paso 5: <br> Sección-1: Características específicas  <br>Sección-2: Equipamientos <br> Sección-3: Servicios <br> Sección-4: Environments
</td>
 </tr>
 <tr>
    <td><b>23</b>. El propietario selecciona mediante el uso de checkbox opciones en la sección con la etiqueta”Características específicas”.</td>
    <td></td>
 </tr>
 <tr>
    <td><b>24</b>.El propietario selecciona mediante el uso de checkbox opciones en la sección con la etiqueta”Equipamientos”.</td>
    <td></td>
 </tr>
 <tr>
    <td><b>25</b>. El propietario selecciona mediante el uso de checkbox opciones en la sección con la etiqueta”Servicios”.</td>
    <td></td>
 </tr>
 <tr>
    <td><b>26</b>. El propietario selecciona mediante el uso de checkbox opciones en la sección con la etiqueta”Environments”.</td>
    <td></td>
 </tr>
 <tr>
    <td><b>27</b>. Una vez ingresado toda la información relacionada a la propiedad el propietario presiona en el botón con la etiqueta “Publicar”.</td>
    <td></td>
 </tr>
 <tr>
    <td></td>
    <td><b>28</b>. El sistema valida los campos cargados y muestra el mensaje  “Registro exitoso” . y redirecciona al user a sus publicaciones realizadas.</td>
 </tr>
</table>

<u>**Flujo Alternativo de Eventos**.</u>  

**Paso 2**: El sistema no logra cargar el formulario. Muestra un mensaje de error y pide que se actualice la página  
**Paso 4**: El sistema no logra cargar el formulario. Muestra un mensaje de error y pide que se actualice la página  
**Paso 10**: El sistema no logra cargar el formulario. Muestra un mensaje de error y pide que se actualice la página  
**Paso 18**: El sistema no logra cargar el formulario. Muestra un mensaje de error y pide que se actualice la página  
**Paso 22**: El sistema no logra cargar el formulario. Muestra un mensaje de error y pide que se actualice la página  
**Paso 28**: El sistema detecta que un campo obligatorio no fue cargado. Indica cuál es el campo que no cumple con lo requerido.  
**Paso 28**: El sistema detecta un dato no válido, Se le informa al user y vuelve a ingresar la información.

<br></br>

## Wireframe Modificar Propiedad

<img src="C:\Users\emili\Desktop\Facultad\Tercer Año\Segundo cuatri\POO2\IntegradorIntegro\src\main\webapp\assets\img\images_iteraciones\modif_prop.jpeg" width="800"/>

<br><br>

**Caso de uso**: Modificar Propiedad  
**Descripción**: El propietario ingresa en una propiedad propia publicada y busca la información a modificar, una vez encontrada la selecciona y realiza los cambios pertinentes confirmando los cambios realizados.  
**Precondición**:  
- Poseer una cuenta creada.Que el user se encuentre con su sesión iniciada.
- Que la propiedad se encuentre registrada.  
  
**Postcondición**: 
- Se cambiaron de manera exitosa los datos requeridos.
  

**Flujo Típico de eventos**:
<table>
  <tr>
    <th>Actor</th>
    <th>Sistema</th>
  </tr>
  <tr>
    <td><b>1</b>. Este caso de uso comienza cuando el user ingresa en el apartado de propiedades y selecciona una de las propiedades que se encuentran registradas a su cuenta y presiona en el botón con la etiqueta “modificar”</td>
    <td></td>
  </tr>
  <tr>
    <td></td>
    <td><b>2</b>. El sistema deshabilita la publicación referente a la propiedad impidiendo interactuar a otro user (Inquilino)</td>
  </tr>
  <tr>
    <td></td>
    <td><b>3</b>. El sistema despliega el formulario utilizado en el CU-05(Registrar Propiedad) con la información asociada al alquiler seleccionado</td>
  </tr>
  <tr>
    <td><b>4</b>. El propietario busca el dato a cambiar, lo modifica y se dirige al paso 5 del formulario y presiona en el botón con la etiqueta “Guardar Modificación”</td>
    <td></td>
  <tr>
    <td></td>
    <td><b>5</b>. El sistema verifica que todos los campos se encuentren cargados de manera correcta y avisa que todos los cambios se guardaron de manera correcta</td>
  </tr>
  <tr>
    <td></td>
    <td><b>6</b>. El sistema habilita la publicación referente a la propiedad nuevamente</td>
 </tr>
</table>


<u>**Flujo Alternativo de Eventos**.</u>  

**Paso 2**: El sistema no logra deshabilitar la publicación y pide al user que vuelva a ingresar en la publicación.  
**Paso 3**: El sistema no logra cargar el formulario. Pide que se vuelva ingresar en el sitio.  
**Paso 5**: El sistema detecta que un campo obligatorio no fue cargado. Indica cual es el campo que no cumple con lo requerido.  
**Paso 5**: El sistema detecta un dato no válido, Se le informa al user y vuelve a ingresar la información





# Backlog de iteraciones
**Iteracion 1**
- Crear un nuevo user
- Ingresar user
- Registrar propiedad
- Modificar propiedad


# Tareas

<br><br>

## **Tareas para Registrar user**

**Como** Inquilino/Propietario/Administrador  
**Quiero**  crear una nueva cuenta  
**Para**  poder hacer uso de las funcionalidades del sistema

<u>Criterios de aceptación</u>

-  Cuando el user intente ingresar a una URL o pantalla en la que no tenga permiso, entonces el sistema se direccionará a la pantalla de registro del sistema.
-  La password del user debe tener como mínimo 8 dígitos y como máximo 1
-  El name de user no debe contener caracteres especiales

<u>Las siguientes tareas comprenderán el desarrollo de la Historia de User:</u>

- Creación de wireframe
    - Creación del formulario donde contendrán los siguientes elementos
        - Posicionamiento de campo de texto para completar “E-Mail”
        - Posicionamiento de campo de texto para completar “DNI”
        - Posicionamiento de campo de texto para completar “Name”
        - Posicionamiento de campo de texto para completar “Lastname”
        - Posicionamiento de campo de texto para completar “Password”
        - Posicionamiento de campo de texto para completar “Confirme su password”
        - Boton de accion de “REGISTRARME” para enviar el formulario


- Descripción del Uso del wireframe (Caso de Uso real)
- Creación del modelo de datos(Entidad/es de Base de datos)
- Establecer funcion de envio de formulario 
- Validación de campos con sus respectivas alertas


## **Tareas para Ingresar user**

**Como** Inquilino/Propietario/Administrador  
**Quiero** poder ingresar mi name de user y password  
**Para** poder hacer uso de las funcionalidades del sistema e ingresar a las características relacionadas a mi cuenta

<u>Criterios de aceptación</u>

- El name de user debe existir dentro de la base de datos  
- Cuando el ingreso del user y password son correctos, entonces el sistema permitirá el ingreso  
- Si el user ingresa una password incorrecta, el sistema mostrara la opcion de restablecer password

<u>Las siguientes tareas comprenderán el desarrollo de la Historia de User:</u>

- Creación de wireframe
    - Creación del formulario donde contendrán los siguientes elementos
        - Posicionamiento de campo de texto para completar “User”
        - Posicionamiento de campo de texto para completar “Password”
        - Boton de accion de “Iniciar Sesión” para enviar el formulario
- Descripción del Uso del wireframe (Caso de Uso real)
- Creación del modelo de datos(Entidad/es de Base de datos)
- Establecer funcion de envio de formulario 
- Validación de campos con sus respectivas alertas

<br><br>

## **Tareas para Registrar Propiedad**

**Como** Propietario  
**Quiero** registrar una propiedad  
**Para** que cualquier persona pueda alquilarla

<u>Criterios de aceptacion</u>

 - Se debe poder cargar Direccion/Ubicacion, Characteristics generales y Images del lugar
 - Una propiedad está registrada cuando todos los campos obligatorios que posea hayan sido cargados y enviados.

<u>Las siguientes tareas comprenderán el desarrollo de la Historia de User:</u>

- Creación de wireframe
    - Creación del formulario multipasos donde contendrán los siguientes elementos:
        - Posicionamiento de lista desplegable para completar “Tipo de propiedad”
        - Posicionamiento de campo de texto para completar “Street”
        - Posicionamiento de campo de texto para completar “Height”
        - Posicionamiento de lista desplegable para completar “Province”
        - Posicionamiento de lista desplegable para completar “City”
        - Posicionamiento de campo de texto para completar “Environments”
        - Posicionamiento de campo de texto para completar “Bedrooms”
        - Posicionamiento de campo de texto para completar “Baños”
        - Posicionamiento de campo de texto para completar “Garage”
        - Posicionamiento de campo de texto para completar “Surface deck”
        - Posicionamiento de campo de texto para completar “Surface total”
        - Posicionamiento de campo de texto para completar “Price”
        - Posicionamiento de campo de texto para completar “Título de la Publicación”
        - Posicionamiento de campo de texto para completar “Descripción”
        - Posicionamiento de campo de inserción de imágenes para completar “Photo de la propiedad”
        - Posicionamiento de sección que posea los siguientes checkbox “Características específicas”
            - Acceso para personas con discapacidad
            - Permiten mascotas
        - Posicionamiento de sección que posea los siguientes checkbox “Equipamientos”
            - Aire acondicionado
            - Amoblado
            - Calefacción
            - Cocina equipada
            - Lavarropas
            - Termotanque
            - Vigilancia
        - Posicionamiento de sección que posea los siguientes checkbox  “Servicios”
            - Ascensor
            - Internet/Wifi
            - Lavandería
            - Servicio de limpieza
        - Posicionamiento de sección que posea los siguientes checkbox  “Environments”
            - Balcón
            - Cocina
            - Comedor
            - Hall
            - Jardín
            - Lavadero
            - Living
            - Living comedor
            - Patio
            - Sótano
            - Terraza
        - Boton de accion de “Publicar” para enviar el formulario
        - Botones de “Siguiente” y “Previo” para moverse por el formulario 
- Descripción del Uso del wireframe (Caso de Uso real)
- Creación del modelo de datos(Entidad/es de Base de datos)
- Establecer funcion de envio de formulario 
- Validación de campos con sus respectivas alertas

<br><br>

## **Tareas para Modificar Propiedad**

**Como** propietario  
**Quiero** modificar una propiedad  
**Para** actualizar características de la publicación o corregirlas. 
 
<u>Criterios de aceptación:</u>

- El propietario debe ingresar al sistema con su user.
- La publicación debe existir.
- La publicación debe estar activa y en curso (para que no hayan modificaciones una vez confirmado un alquiler).
- Se deben validar los nuevos datos.

<u>Las siguientes tareas comprenderán el desarrollo de la Historia de User:</u>

- Descripción del Uso del wireframe (Caso de Uso real)
- Validación de campos con sus respectivas alertas




# Retrospectiva

