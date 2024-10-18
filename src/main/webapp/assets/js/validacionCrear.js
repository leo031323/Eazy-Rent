// crear validaciones para el formulario de crear publicacion en la vista multistepForm.jsp
const form = document.getElementById('form');

form.addEventListener('submit', (e) => {

        const tipo = document.getElementById('inputTipo');
        const street = document.getElementById('inputStreet');
        const height = document.getElementById('inputHeightPublicacion');
        const province = document.getElementById('inputProvince');
        const city = document.getElementById('inputCity');
        const latitude = document.getElementById('latitude');
        const longitude = document.getElementById('longitude');
        const environment = document.getElementById('inputEnvironment');
        const bedroom = document.getElementById('inputBedroom');
        const baths = document.getElementById('inputBath');
        const garage = document.getElementById('inputGarage');
        const surfaceDeck = document.getElementById('inputSurfaceDeck');
        const surfaceTotal = document.getElementById('inputSurfaceTotal');
        const price = document.getElementById('inputPrice');
        const qualification = document.getElementById('inputQualification');
        const description = document.getElementById('inputDescription');
        const images = document.getElementById('input-file');




    e.preventDefault();

    let errores = 0;
    // checkInputs();
    document.getElementById('divHeight').innerText = '';
    document.getElementById('divTipo').innerText = '';
    document.getElementById('divStreet').innerText = '';
    document.getElementById('divProvince').innerText = '';
    document.getElementById('divCity').innerText = '';
    document.getElementById('divMapa').innerText = '';
    document.getElementById('divEnvironment').innerText = '';
    document.getElementById('divBedroom').innerText = '';
    document.getElementById('divBath').innerText = '';
    document.getElementById('divGarage').innerText = '';
    document.getElementById('divSurfaceDeck').innerText = '';
    document.getElementById('divSurfaceTotal').innerText = '';
    document.getElementById('divPrice').innerText = '';
    document.getElementById('divQualification').innerText = '';
    document.getElementById('divDescription').innerText = '';
    document.getElementById('divImages').innerText = '';

    document.getElementById('progresTipo').className = 'multisteps-form__progress-btn js-active';
    document.getElementById('progresUbicacion').className = 'multisteps-form__progress-btn';
    document.getElementById('progresCharacteristic').className = 'multisteps-form__progress-btn';
    document.getElementById('progresImag').className = 'multisteps-form__progress-btn';
    document.getElementById('progres  Comfort').className = 'multisteps-form__progress-btn';




    if (tipo.value === '') {
        document.getElementById('divTipo').innerText = 'Debe seleccionar un tipo de propiedad';
        document.getElementById('progresTipo').className = 'multisteps-form__progress-btn js-active text-danger';
        errores++;
    }

    if(street.value === '') {
        document.getElementById('divStreet').innerText = 'Debe ingresar una street';
        document.getElementById('progresUbicacion').className = 'multisteps-form__progress-btn text-danger';
        errores++;
    }else {
        if (street.value.length > 100) {
            document.getElementById('divStreet').innerText = 'El name de la street debe tener menos de 100 caracteres';
            document.getElementById('progresUbicacion').className = 'multisteps-form__progress-btn text-danger';
            errores++;
        }
    }

    if(height.value === '') {
        document.getElementById('divHeight').innerText = 'La height es obligatoria';
        document.getElementById('progresUbicacion').className = 'multisteps-form__progress-btn text-danger';
        errores++;
    }

    if(province.value === '') {
        document.getElementById('divProvince').innerText = 'Debe seleccionar una province';
        document.getElementById('progresUbicacion').className = 'multisteps-form__progress-btn text-danger';
        errores++;
    }

    if(city.value === '') {
        document.getElementById('divCity').innerText = 'Debe seleccionar una city';
        document.getElementById('progresUbicacion').className = 'multisteps-form__progress-btn text-danger';
        errores++;
    }

    if(latitude.value === '' || longitude.value === '') {
        document.getElementById('divMapa').innerText = 'Debe seleccionar una ubicación en el mapa';
        document.getElementById('progresUbicacion').className = 'multisteps-form__progress-btn text-danger';
        errores++;
    }

    if(environment.value !== '' || environment.value !== '0') {
        if(environment.value < 0) {
            document.getElementById('divEnvironment').innerText = 'Debe ingresar un valor positivo';
            document.getElementById('progresCharacteristic').className = 'multisteps-form__progress-btn text-danger';
            errores++;
        }
        if(environment.value > 99) {
            document.getElementById('divEnvironment').innerText = 'Debe ingresar un valor menor a 100';
            document.getElementById('progresCharacteristic').className = 'multisteps-form__progress-btn text-danger';
            errores++;
        }

    }

    if(bedroom.value !== '' || bedroom.value !== '0') {
        if(bedroom.value < 0) {
            document.getElementById('divBedroom').innerText = 'Debe ingresar un valor positivo';
            document.getElementById('progresCharacteristic').className = 'multisteps-form__progress-btn text-danger';
            errores++;
        }
        if(bedroom.value > 99) {
            document.getElementById('divBedroom').innerText = 'Debe ingresar un valor menor a 100';
            document.getElementById('progresCharacteristic').className = 'multisteps-form__progress-btn text-danger';
            errores++;
        }

    }

    if(baths.value !== '' || baths.value !== '0') {
        if(baths.value < 0) {
            document.getElementById('divBath').innerText = 'Debe ingresar un valor positivo';
            document.getElementById('progresCharacteristic').className = 'multisteps-form__progress-btn text-danger';
            errores++;
        }
        if(baths.value > 99) {
            document.getElementById('divBath').innerText = 'Debe ingresar un valor menor a 100';
            document.getElementById('progresCharacteristic').className = 'multisteps-form__progress-btn text-danger';
            errores++;
        }

    }

    if(garage.value !== '' || garage.value !== '0') {
        if(garage.value < 0) {
            document.getElementById('divGarage').innerText = 'Debe ingresar un valor positivo';
            document.getElementById('progresCharacteristic').className = 'multisteps-form__progress-btn text-danger';
            errores++;
        }
        if(garage.value > 99) {
            document.getElementById('divGarage').innerText = 'Debe ingresar un valor menor a 100';
            document.getElementById('progresCharacteristic').className = 'multisteps-form__progress-btn text-danger';
            errores++;
        }

    }

    if(surfaceDeck.value !== '' || surfaceDeck.value !== '0') {
        if(surfaceDeck.value < 0) {
            document.getElementById('divSurfaceDeck').innerText = 'Debe ingresar un valor positivo';
            document.getElementById('progresCharacteristic').className = 'multisteps-form__progress-btn text-danger';
            errores++;
        }
        if(surfaceDeck.value > 999999) {
            document.getElementById('divSurfaceDeck').innerText = 'Debe ingresar un valor menor a 999999';
            document.getElementById('progresCharacteristic').className = 'multisteps-form__progress-btn text-danger';
            errores++;
        }

    }

    if(surfaceTotal.value !== '' || surfaceTotal.value !== '0') {
        if(surfaceTotal.value < 0) {
            document.getElementById('divSurfaceTotal').innerText = 'Debe ingresar un valor positivo';
            document.getElementById('progresCharacteristic').className = 'multisteps-form__progress-btn text-danger';
            errores++;
        }
        if(surfaceTotal.value > 999999) {
            document.getElementById('divSurfaceTotal').innerText = 'Debe ingresar un valor menor a 999999';
            document.getElementById('progresCharacteristic').className = 'multisteps-form__progress-btn text-danger';
            errores++;
        }
        if(surfaceTotal.value < surfaceDeck.value) {
            document.getElementById('divSurfaceTotal').innerText = 'La surface total debe ser mayor a la surface deck';
            document.getElementById('progresCharacteristic').className = 'multisteps-form__progress-btn text-danger';
            errores++;
        }

    }

    if(price.value === '') {
        document.getElementById('divPrice').innerText = 'Debe ingresar un price para la propiedad';
        document.getElementById('progresCharacteristic').className = 'multisteps-form__progress-btn text-danger';
        errores++;
    }else {
        if(price.value < 0) {
            document.getElementById('divPrice').innerText = 'Debe ingresar un valor positivo';
            document.getElementById('progresCharacteristic').className = 'multisteps-form__progress-btn text-danger';
            errores++;
        }
        if(price.value > 999999999) {
            document.getElementById('divPrice').innerText = 'Debe ingresar un valor menor a 999999999';
            document.getElementById('progresCharacteristic').className = 'multisteps-form__progress-btn text-danger';
            errores++;
        }

    }

    if(qualification.value === '') {
        document.getElementById('divQualification').innerText = 'Debe ingresar un título para la propiedad';
        document.getElementById('progresImag').className = 'multisteps-form__progress-btn text-danger';
        errores++;
    }else {
        if(qualification.value.length > 50) {
            document.getElementById('divQualification').innerText = 'El título no debe superar los 50 caracteres';
            document.getElementById('progresImag').className = 'multisteps-form__progress-btn text-danger';
            errores++;
        }
    }

    if(description.value === '') {
        document.getElementById('divDescription').innerText = 'Debe ingresar una descripción para la propiedad';
        document.getElementById('progresImag').className = 'multisteps-form__progress-btn text-danger';
        errores++;
    }else {
        if(description.value.length < 50) {
            document.getElementById('divDescription').innerText = 'La descripción debe tener al menos 50 caracteres';
            document.getElementById('progresImag').className = 'multisteps-form__progress-btn text-danger';
            errores++;
        }
        if(description.value.length > 500) {
            document.getElementById('divDescription').innerText = 'La descripción debe tener menos de 500 caracteres';
            document.getElementById('progresImag').className = 'multisteps-form__progress-btn text-danger';
            errores++;
        }
    }

    if(images.value === '') {
        document.getElementById('divImages').innerText = 'Debe ingresar al menos una imag';
        document.getElementById('progresImag').className = 'multisteps-form__progress-btn text-danger';
        errores++;
    }

    // si la cantidad de images es mayor a de 6, error
    if(images.files.length > 6) {
        document.getElementById('divImages').innerText = 'Debe ingresar un máximo de 6 imágenes';
        document.getElementById('progresImag').className = 'multisteps-form__progress-btn text-danger';
        errores++;
    }

    // si no hay errores, se envia el formulario
    if(errores === 0) {
        document.getElementById('form').submit();
    }else {
        alert('Hay ' + errores +  ' errores en el formulario');
    }
}
);


