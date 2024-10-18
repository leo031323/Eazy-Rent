package com.unam.poo.controllers.Publicacion;

import com.unam.poo.models.*;
import com.unam.poo.services.*;
import com.unam.poo.services.Characteristic Comfort.Characteristic ComfortService;
import com.unam.poo.services.City.CityService;
import com.unam.poo.services.  Comfort.  ComfortService;
import com.unam.poo.services.Province.ProvinceService;
import com.unam.poo.services.Publicacion.PublicacionService;
import com.unam.poo.services.Tipo.TipoService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/publicacion")
@Controller
public class PublicacionController {

    @Autowired
    PublicacionService publicacionService;

    @Autowired
    TipoService tipoService;

    @Autowired
    UserService userService;

    @Autowired
    ProvinceService provinceService;

    @Autowired
      ComfortService   comfortService;

    @Autowired
    Characteristic ComfortService characteristic ComfortService;

    @Autowired
    CityService cityService;





//    Crear publicacion
//    Ruta localhost:8080/publicacion/crearPublicacion
    @GetMapping("/crearPublicacion")
    public String publicacionLoad(Model model){

        List<Type> types = tipoService.findAll();
        List<Province> provinces = provinceService.findAll();
        List<City> cities = cityService.findAll();
        List<Comfort>     comforts =   comfortService.findAll();
        List<FeatureComfort> characteristic    Comforts = characteristic ComfortService.findAll();


        model.addAttribute("cities", cities);
        model.addAttribute("provinces", provinces);
        model.addAttribute("tipos", types);
        model.addAttribute("    comforts",     comforts);
        model.addAttribute("characteristic    Comforts", characteristic    Comforts);
        model.addAttribute("publicacion", new Publication());
        return "Publicacion/crearPublicacion";
    }

//    Ruta localhost:8080/publication/nuevaPublicacion
    @PostMapping("/nuevaPublicacion")
    public String crearPublicacion(@Validated @ModelAttribute ("publicacion") Publication publication, BindingResult result, Model model, @RequestParam("file[]") List<MultipartFile> imag) {
    if (result.hasErrors()) {
        //aca deberia ir una pagina de error o algo xd
        // retornar y pasarle el objeto publication, tipo, province, city,   comfort, characteristic Comfort;
        List<Type> types = tipoService.findAll();
        List<Province> provinces = provinceService.findAll();
        List<City> cities = cityService.findAll();
        List<Comfort>     comforts =   comfortService.findAll();
        List<FeatureComfort> characteristic    Comforts = characteristic ComfortService.findAll();


        model.addAttribute("tipos", types);
        model.addAttribute("    comforts",     comforts);
        model.addAttribute("characteristic    Comforts", characteristic    Comforts);

        return "Publicacion/crearPublicacion";
    }
//        @RequestParam("file[]")List<MultipartFile> imag
    if (!imag.isEmpty()) {
        try {
//            imprimir el name de todos los archivos de imag
            Path directorioImages = Path.of("src//main//webapp//assets//img//rents");
            String rutaAbsoluta = directorioImages.toFile().getAbsolutePath();

            List<PhotoPublication> photos = new ArrayList<>();

            for (MultipartFile file : imag) {
                System.out.println(file.getOriginalFilename());

                byte[] bytes = file.getBytes();



                String nameImag = Math.random() + file.getOriginalFilename();
                Path rutaCompleta = Paths.get(rutaAbsoluta + "//" + nameImag);
                Files.write(rutaCompleta, bytes);

                PhotoPublication photoPublication = new PhotoPublication();
                photoPublication.setUrl(nameImag);
                photoPublication.setIdPublication(publication);

                photos.add(photoPublication);
            }
            publication.setImages(photos);

//            publicacionService.save(publication, imag);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    publicacionService.savePublicacion(publication);
    return "redirect:/publicacion/consultarPublicacion";
    }



//    Editar publicacion
//    Ruta localhost:8080/publicacion/editarPublicacion/{id}
    @GetMapping("/editarPublicacion/{id}")
    public String editarPublicacion(@PathVariable("id") Long id, Model model) {
        Publication publication = publicacionService.getPublicacionById(id);
        List<Type> types = tipoService.findAll();
        List<Province> provinces = provinceService.findAll();
        List<City> cities = cityService.findAll();
        List<Comfort>     comforts =   comfortService.findAll();
        List<FeatureComfort> characteristic    Comforts = characteristic ComfortService.findAll();

        model.addAttribute("cities", cities);
        model.addAttribute("provinces", provinces);
        model.addAttribute("tipos", types);
        model.addAttribute("    comforts",     comforts);
        model.addAttribute("characteristic    Comforts", characteristic    Comforts);

        model.addAttribute("publicacion", publication);

//        publicacionService.deletePublicacionById(4L);

        return "Publicacion/editarPublicacion";
    }

    @PostMapping("/editarPublicacion/{id}")
    public String editarPublicacion(@PathVariable("id") Long id, @Validated @ModelAttribute ("publicacion") Publication publication, BindingResult result, @RequestParam("file[]") List<MultipartFile> imag ) {
        if (result.hasErrors()) {
            //aca deberia ir una pagina de error o algo xd
            return "Publicacion/editarPublicacion";
        }
        if (!imag.isEmpty()) {
            try {
//            imprimir el name de todos los archivos de imag
                Path directorioImages = Path.of("src//main//webapp//assets//img//rents");
                String rutaAbsoluta = directorioImages.toFile().getAbsolutePath();

                List<PhotoPublication> photos = new ArrayList<>();

                for (MultipartFile file : imag) {
                    System.out.println(file.getOriginalFilename());

                    byte[] bytes = file.getBytes();



                    String nameImag = Math.random() + file.getOriginalFilename();
                    Path rutaCompleta = Paths.get(rutaAbsoluta + "//" + nameImag);
                    Files.write(rutaCompleta, bytes);

                    PhotoPublication photoPublication = new PhotoPublication();
                    photoPublication.setUrl(nameImag);
                    photoPublication.setIdPublication(publication);

                    photos.add(photoPublication);
                }
                publication.setImages(photos);

//            publicacionService.save(publication, imag);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        publicacionService.updatePublicacion(publication, id);
        return "redirect:/publicacion/consultarPublicacion";
    }



//    Consultar todas las publicaciones de un user
//    Ruta localhost:8080/publicacion/consultarPublicacion
    @GetMapping("/consultarPublicacion")
    public String consultarPublicacion(Model model){

        List<Publication> publicaciones = publicacionService.findAllByStatePublicacion("active");
        publicaciones.addAll(publicacionService.findAllByStatePublicacion("Alquilado"));
        List<FeatureComfort> characteristic    Comforts = characteristic ComfortService.findAll();

        model.addAttribute("publicaciones", publicaciones);
        model.addAttribute("characteristic    Comforts", characteristic    Comforts);

        return "Publicacion/consultarPublicacion";
    }

    @GetMapping("/consultarAlquiler")
    public String consultarAlquiler(Model model){

        List<Publication> publicaciones = publicacionService.findAllByStatePublicacion("Alquilado");

        model.addAttribute("publicaciones", publicaciones);

        return "Publicacion/consultarAlquileres";
    }



//    Ver una publicacion
//    Ruta localhost:8080/publicacion/verPublicacion/{id}
    @GetMapping("/verPublicacion/{id}")
    public String verPublicacion(@PathVariable("id") Long id, Model model, HttpServletRequest request){

        Publication publication = publicacionService.getPublicacionById(id);
        Long idUser = (Long) request.getSession().getAttribute("userId");
        User user = userService.getUserById(idUser);

        model.addAttribute("user", user);
        model.addAttribute("publicacion", publication);
//        userService.agregarFavorites(id,1L);

//        userService.quitarFavorites(1L,1L);
        return "Publicacion/verPublicacion";
    }

//    Dar de baja una publicacion
//    Ruta localhost:8080/publicacion/bajaPublicacion/{id}

    @PostMapping("/bajaPublicacion/{id}")
    public String bajaPublicacion(@PathVariable("id") Long id) {

        publicacionService.deletePublicacionById(id);
        return "redirect:/publicacion/consultarPublicacion";
    }

    @GetMapping("/verPublicaciones")
    public String verPublicaciones(Model model){

        List<Publication> publicaciones = publicacionService.findAllByStatePublicacion("active");

        model.addAttribute("publicaciones", publicaciones);

        return "Publicacion/verPublicaciones2";
    }

//    agregar a favorites
    @PostMapping("/agregarFavorite/{id}")
    public String agregarFavorite(@PathVariable("id") Long id,  HttpServletRequest request) {
        Long idUser = (Long) request.getSession().getAttribute("userId");
        userService.agregarFavorites(id,idUser);
        return "redirect:/publicacion/verPublicacion/{id}";
    }

    @PostMapping("/quitarFavorite/{id}")
    public String quitarFavorite(@PathVariable("id") Long id,  HttpServletRequest request) {
        Long idUser = (Long) request.getSession().getAttribute("userId");
        userService.quitarFavorites(id,idUser);
        return "redirect:/publicacion/verPublicacion/{id}";
    }


//    @GetMapping("/verFavorites")
//    public String verFavorites(Model model){
//
////        List<Publication> publicaciones = publicacionService.findAllByFavorite("si");
//
//        model.addAttribute("publicaciones", publicaciones);
//
//        return "Publication/verFavorites";
//    }



}


