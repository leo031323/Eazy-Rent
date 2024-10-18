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
import com.unam.poo.services.Characteristic Comfort.Characteristic ComfortService;
import com.unam.poo.services.City.CityService;
import com.unam.poo.services.  Comfort.  ComfortService;
import com.unam.poo.services.Country.CountryService;
import com.unam.poo.services.Province.ProvinceService;
import com.unam.poo.services.Tipo.TipoService;

@Component  
public class StarterCommand implements CommandLineRunner {

    @Autowired
    RolService rolService;
    
    @Autowired
    CountryService countryService;

    @Autowired
    ProvinceService provinceService;

    @Autowired
    CityService cityService;

    @Autowired
    TipoService tipoService;

    @Autowired
      ComfortService   comfortService;

    @Autowired
    Characteristic ComfortService characteristic ComfortService;

    @Override
    public void run(String... args) throws Exception {

        if (!(rolService.getByRolName(RoleName.ROL_USER).isPresent())) {
            Role roleAdmin = new Role(RoleName.ROL_USER);
            rolService.save(roleAdmin);
            System.out.println("ROL_USUARIO CREADO");
        }else{
            System.out.println("ROL_USUARIO EXISTENTE");
        } 

        Boolean valor = false;
        for (Country country : countryService.findAll()) {
            if (country.getCountry().equals("Argentina")){
                valor = true;
            }
        }
        if (!valor){
            /* Carga de country */
            Country country = new Country();
            country.setCountry("Argentina");
            countryService.saveCountry(country);
            System.out.println("Country creado: " + country.getCountry());

            Boolean valor2 = false;
            for (Province prov : provinceService.findAll()) {
                if (prov.getProvince().equals("Misiones")){
                    valor = true;
                }
            }
            if (!valor2){
                /* Carga de province */
                Province province = new Province();
                province.setIdCountry(country);
                province.setProvince("Misiones");
                provinceService.saveProvince(province);
                System.out.println("Province creada: " + province.getProvince());

                Boolean valor3 = false;
                for (City city : cityService.findAll()) {
                    if (city.getCity().equals("Apostoles")){
                        valor = true;
                    }
                }
                if (!valor3){
                    /* Carga de city */
                    City city = new City();
                    city.setIdProvince(province);
                    city.setCity("Apostoles");
                    cityService.saveCity(city);
                    System.out.println("City creada: " + city.getCity());
                }
            }
        }

    }

} 