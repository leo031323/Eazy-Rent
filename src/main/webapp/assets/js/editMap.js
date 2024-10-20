function iniciarMap(){

    // Lista de tareas
    // - Visualizar la posicion del user
    // - Mostrar un marcador en el mapa
    // - Mostrar un cuadro de dialogo con la informacion del marcador
    // - Permitir que el user pueda agregar solamente un marcadores
    // - Indicar ruta desde el punto actual hasta el marcador

    // establecer un marker con el imag map-marker-2-512.png
    var icono = {
        url: '../../assets/img/map-marker-2-512.png',
        scaledSize: new google.maps.Size(30, 30),
        origin: new google.maps.Point(0,0),
        anchor: new google.maps.Point(16, 31)

    };

    // Obtenemos la posicion del user
    navigator.geolocation.getCurrentPosition(function(posicion){
        // Creamos un objeto con las coordenadas del user
        var coords = new google.maps.LatLng(document.getElementById('latitude').value, document.getElementById('longitude').value);
        // Creamos un objeto mapa y especificamos el elemento DOM donde se va a mostrar
        var map = new google.maps.Map(document.getElementById('map'), {
            zoom: 15,
            center: coords
        });
        // Creamos el marcador en el mapa con sus propiedades
        // para nuestro obetivo tenemos que poner el atributo draggable en true
        // position pondremos las mismas coordenas que obtuvimos en la geolocalizacion
        var marker = new google.maps.Marker({
            map: map,
            draggable: true,
            animation: google.maps.Animation.DROP,
            position: coords,
            icon: icono
        });

        // Creamos un evento que detecta el click sobre el marcador
        // y muestra la informacion del mismo en un cuadro de dialogo de Google Maps
        marker.addListener('click', function(event){


            // Creamos la ventana de informacion
            infoWindow = new google.maps.InfoWindow({
                content: '<p>Latitude: ' + marker.getPosition().lat() + '</p><p>Longitude: ' + marker.getPosition().lng() + '</p>'
            });

            // Abrimos la ventana de informacion
            infoWindow.open(map, marker);

            console.log("HOLA MUNDO");
        });

        // enviamos la posicion del marcador al input de latitude y longitude

        // document.getElementById('latitude').value = marker.getPosition().lat();
        // document.getElementById('longitude').value = marker.getPosition().lng();

        // Creamos un evento que actualiza la posicion del marcador
        // cada vez que se termina de arrastrar


        google.maps.event.addListener(marker, 'dragend', function(event){
            // enviamos la posicion del marcador al input de latitude y longitude
            document.getElementById('latitude').value = this.getPosition().lat();
            document.getElementById('longitude').value = this.getPosition().lng();

            // imprimir longitude y latitude
            console.log("Latitude: " + this.getPosition().lat());
            console.log("Longitude: " + this.getPosition().lng());
        });

    });

    

}



// // obtener la posicion del user y mostrar el mapa
// navigator.geolocation.getCurrentPosition(function(posicion){
//   var lat = posicion.coords.latitude;
//   var lon = posicion.coords.longitudee;
//   var map = new google.maps.Map(document.getElementById('map'),{
//       center:{lat:lat, lng:lon},
//       zoom:15
//   });

//   // permitir que el user marque solamente una posicion en el mapa
//   var marker = new google.maps.Marker({
//       position:{lat:lat, lng:lon},
//       map:map,
//       draggable:true}
//   );

//   // obtener la posicion del marcador
//   google.maps.event.addListener(marker, 'dragend', function(event){
//       document.getElementById('lat').value = this.getPosition().lat();
//       document.getElementById('lon').value = this.getPosition().lng();
//   });


// });
