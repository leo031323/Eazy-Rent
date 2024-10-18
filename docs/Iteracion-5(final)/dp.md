# Trabajo en equipo
El lider de la cuarta iteracion sera: Marcelo Kachuck

La division de las Historias de User sera la siguiente:

- Consultar alquileres Favorites
    - **Encargados**: Emiliano Blazco y Ariel Cristaldo

- Restablecer password
    - **Encargados**: Marcela Stigelmeier y Matias Fernandez

- Testing
    - **Encargados**: Marcela Stigelmeier, Matias Fernandez, Emiliano Blazco, Ariel Cristaldo, Guillermo Quintana, Marcelo Kachuk

# Tablero de Proyecto
<img src="../../src/main/webapp/assets/img/images_iteraciones/Tablero5F.jpeg" width="800"/>

# Diseño OO

<img src="../../src/main/webapp/assets/img/images_iteraciones/DC_ite_5F.jpeg" width="800"/>

# Wireframe y caso de uso

## Wireframe Consultar alquileres Favorites

<img src="../../src/main/webapp/assets/img/images_iteraciones/consultar_alquileres_fav.jpeg" width="800"/>

<br><br>
**Caso de uso**: Consultar alquileres Favorites <br>
**Descripción**: El inquilino se dirige a su profile e ingresa al apartado de favorites y el sistema muestra los alquileres marcados como favorites.   <br>
**Precondición**: Seleccionar al menos un alquiler como favorite. <br>
**Postcondición**: -- 

**Flujo Típico de eventos**:
<table>
  <tr>
    <th>Actor</th>
    <th>Sistema</th>
  </tr>
  <tr>
    <td><b>1</b>. Este caso de uso comienza cuando el inquilino ingresa <br>en su profile utilizando el botón con el icono de su <br>photo de profile
    <td></td>
  </tr>
  <tr>
    <td></td>
    <td><b>2</b>. El sistema despliega las opciones de profile <br>
  </tr>
  <tr>
    <td><b>3</b> El inquilino selecciona el botón con la etiqueta “Mis favorites”<br>
    <td></td>
  </tr>
  <tr>
    <td></td>
    <td><b>4</b>. El sistema despliega la lista de alquileres que se encuentran<br> seleccionados como favorites por el user <br>
  </tr>
</table>

<u>**Flujo Alternativo de Eventos**.</u>  

**Paso **:

## Wireframe Restablecer password

<img src="../../src/main/webapp/assets/img/images_iteraciones/restablecer_contra.jpeg" width="800"/>

<br><br>
**Caso de uso**:Restablecer password<br>
**Descripción**: El user desde  el login se dirige a la opción “restablecer password” el cual lo dirige a una pantalla donde debe ingresar su mail y el código de verificación (que se envía a su mail). una vez validada su identidad completa los campos con su nueva password y presiona el boton “restablecer password” <br>
**Precondición**: que el user tenga una cuenta registrada<br>
**Postcondición**: -- 

**Flujo Típico de eventos**:
<table>
  <tr>
    <th>Actor</th>
    <th>Sistema</th>
  </tr>
  <tr>
    <td><b>1</b>. Este caso de uso comienza cuando el user desde<br> el login hace clic en “restablecer password”
    <td></td>
  </tr>
  <tr>
    <td></td>
    <td><b>2</b>. El sistema dirige al user a la una pantalla con el <br>siguiente formulario:<br>
        - Ingrese su mail<br> 
        - Código de recuperación<br>
        - Nueva password<br>
        - Confirme su password<br>
  </tr>
  <tr>
    <td><b>3</b>. El user selecciona el campo con la etiqueta “Ingrese<br> su mail” y lo completa
    <td></td>
  </tr>
  <tr>
    <td><b>4</b>. Una vez completo el campo con su mail el user <br>selecciona el botón “Enviar código de recuperación”
    <td></td>
  </tr>
  <tr>
    <td></td>
    <td><b>5</b>. El sistema valida si el mail ingresado es correcto <br>y envía un código a dicho mail
    </tr>
  <tr>
    <td><b>6</b>. El user selecciona el campo con la etiqueta “Ingrese<br> su mail” y lo completa
    <td></td>
    </tr>
  <tr>
    <td><b>7</b>. El user selecciona el campo con la etiqueta “Código <br>de recuperación” y lo completa con el código que <br>recibió en su mail
    <td></td></tr>
  <tr>
    <td><b>8</b>. El user selecciona el campo con la etiqueta<br> “Nueva password” y lo completa
    <td></td></tr>
  <tr>
    <td><b>9</b>. El user selecciona el campo con la etiqueta<br> ”Confirme su password” y lo completa
    <td></td></tr>
  <tr>
    <td><b>10</b>. Una vez completos los campos el user selecciona <br>el botón “Restablecer password”
    <td></td>
  </tr>
  <tr>
    <td></td>
    <td><b>11</b>. El sistema valida los campos cargados, alerta al<br> user que su password fue restablecida exitosamente<br> y lo redirige al login.
</table>



<u>**Flujo Alternativo de Eventos**.</u>  

**Paso 5**: El sistema detecta que el mail no es el correspondiente e indica al user que vuelva a ingresarlo <br>
**Paso 11**: El sistema detecta que un campo no fue cargado correctamente e indica cuál es el campo que no cumple con lo requerido. <br>

<br><br>

# Backlog de iteraciones
**Iteracion 5**
- Consultar alquileres Favorites
- Restablecer password
- Testing

# Tareas

<br><br>

## **Tareas para Consultar alquileres Favorites**

**Como** inquilino<br>
**Quiero** consultar mis alquileres marcados como favorites<br>
**Para** poder saber cuales son exactamente mis selecciones<br>

<u>Criterios de aceptación</u>

- Se deben poder todos los alquileres marcados como favorites
- Si se desmarca de favorite un alquiler debe desaparecer de la lista


<u>Las siguientes tareas comprenderán el desarrollo de la Historia de User:</u>

- Creación de wireframe
    - Creación del formulario donde contendrán los siguientes elementos
        - Agregar boton de de redireccionamiento “Mis favorites”
        - Mostrar Lista de alquileres que posean el state de FAVORITO
- Descripción del Uso del wireframe (Caso de Uso real)
- Creación del modelo de datos(Entidad/es de Base de datos)
- Validación de campos con sus respectivas alertas


## **Tareas para Restablecer password**

**Como** user <br>
**Quiero** restablecer mi password<br>
**Para** actualizar mis credenciales<br>

<u>Criterios de aceptación</u>

- Se debe poder ingresar al sistema con la nueva

<u>Las siguientes tareas comprenderán el desarrollo de la Historia de User:</u>

- Creación de wireframe
    - Creación del formulario donde contendrán los siguientes elementos
        - Posicionamiento de campo de texto para completar “Ingrese su mail”
        - Botón de acción de “ENVIAR CÓDIGO DE RECUPERACIÓN”
        - Posicionamiento de campo de texto para completar “Ingrese su Mail”
        - Posicionamiento de campo de texto para completar “Código de Recuperación”
        - Posicionamiento de campo de texto para completar “Nueva password”
        - Posicionamiento de campo de texto para completar “Confirme su password”
        - Boton de accion de “RESTABLECER CONTRASEÑA” para enviar el formulario
- Descripción del Uso del wireframe (Caso de Uso real)
- Validación de campos con sus respectivas alertas

<br><br>

# Retrospectiva de la Iteracion 5

Teniendo en cuenta lo realizado en la release 5 podemos decir que hubo un gran aporte por parte de todos los integrantes del grupo
cada uno cumpliendo con sus tareas asignadas y trabajando de manera correcta con el repositorio de github.
Por otra parte se realizaron de manera completa las 3 actividades (Consultar alquileres Favorites, Restablecer password, Testing) planteadas para la iteracion. 
Cumpliendo con su documentacion, desarrollo de wireframes e implementacion de funcionalidades. 
Por otra parte cabe especificar que para la etapa de testing se establecio una branch separada para trabajar sobre la misma.
Ademas de esto se mantuvo la forma de trabajo de a pares, siguiendo con esta metodologia para las siguientes iteraciones.

Aclaracion: En la iteracion 5 se dejo la restrospectiva en el mismo archivo ya que el documento de la iteracion daba las 2 opciones y para seguir un formato lineal elegimos esta.

Nota: Se puedieron establecer las images de los wireframes, tableros y diagramas de clases en todos los documentos de todas las iteraciones. :D