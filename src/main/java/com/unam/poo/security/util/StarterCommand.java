package com.unam.poo.security.util;

import com.unam.poo.models.City;
import com.unam.poo.models.Country;
import com.unam.poo.models.Province;
import com.unam.poo.security.modelo.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.unam.poo.security.enums.RoleName;
import com.unam.poo.security.service.RolService;
import com.unam.poo.services.CaracteristicaComodidad.CaracteristicaComodidadService;
import com.unam.poo.services.Ciudad.CiudadService;
import com.unam.poo.services.Comodidad.ComodidadService;
import com.unam.poo.services.Pais.PaisService;
import com.unam.poo.services.Provincia.ProvinciaService;
import com.unam.poo.services.Tipo.TipoService;

@Component  
public class StarterCommand implements CommandLineRunner {

    @Autowired
    RolService rolService;
    
    @Autowired
    PaisService paisService;

    @Autowired
    ProvinciaService provinciaService;

    @Autowired
    CiudadService ciudadService;

    @Autowired
    TipoService tipoService;

    @Autowired
    ComodidadService comodidadService;

    @Autowired
    CaracteristicaComodidadService caracteristicaComodidadService;

    @Override
    public void run(String... args) throws Exception {

        if (!(rolService.getByRolNombre(RoleName.ROL_USER).isPresent())) {
            Role roleAdmin = new Role(RoleName.ROL_USER);
            rolService.save(roleAdmin);
            System.out.println("ROL_USUARIO CREADO");
        }else{
            System.out.println("ROL_USUARIO EXISTENTE");
        } 

        Boolean valor = false;
        for (Country country : paisService.findAll()) {
            if (country.getCountry().equals("Argentina")){
                valor = true;
            }
        }
        if (!valor){
            /* Carga de country */
            Country country = new Country();
            country.setCountry("Argentina");
            paisService.savePais(country);
            System.out.println("Country creado: " + country.getCountry());

            Boolean valor2 = false;
            for (Province prov : provinciaService.findAll()) {
                if (prov.getProvince().equals("Misiones")){
                    valor = true;
                }
            }
            if (!valor2){
                /* Carga de province */
                Province province = new Province();
                province.setIdCountry(country);
                province.setProvince("Misiones");
                provinciaService.saveProvincia(province);
                System.out.println("Province creada: " + province.getProvince());

                Boolean valor3 = false;
                for (City city : ciudadService.findAll()) {
                    if (city.getCity().equals("Apostoles")){
                        valor = true;
                    }
                }
                if (!valor3){
                    /* Carga de city */
                    City city = new City();
                    city.setIdProvince(province);
                    city.setCity("Apostoles");
                    ciudadService.saveCiudad(city);
                    System.out.println("City creada: " + city.getCity());
                }
            }
        }

    }

} 