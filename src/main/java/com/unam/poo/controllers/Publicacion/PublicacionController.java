package com.unam.poo.controllers.Publicacion;

import com.unam.poo.models.*;
import com.unam.poo.services.*;
import com.unam.poo.services.CaracteristicaComodidad.CaracteristicaComodidadService;
import com.unam.poo.services.Ciudad.CiudadService;
import com.unam.poo.services.Comodidad.ComodidadService;
import com.unam.poo.services.Provincia.ProvinciaService;
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
    UsuarioService usuarioService;

    @Autowired
    ProvinciaService provinciaService;

    @Autowired
    ComodidadService comodidadService;

    @Autowired
    CaracteristicaComodidadService caracteristicaComodidadService;

    @Autowired
    CiudadService ciudadService;





//    Crear publicacion
//    Ruta localhost:8080/publicacion/crearPublicacion
    @GetMapping("/crearPublicacion")
    public String publicacionLoad(Model model){

        List<Type> types = tipoService.findAll();
        List<Province> provinces = provinciaService.findAll();
        List<City> ciudades = ciudadService.findAll();
        List<Comfort> comodidades = comodidadService.findAll();
        List<FeatureComfort> caracteristicaComodidades = caracteristicaComodidadService.findAll();


        model.addAttribute("ciudades", ciudades);
        model.addAttribute("provincias", provinces);
        model.addAttribute("tipos", types);
        model.addAttribute("comodidades", comodidades);
        model.addAttribute("caracteristicaComodidades", caracteristicaComodidades);
        model.addAttribute("publicacion", new Publication());
        return "Publicacion/crearPublicacion";
    }

//    Ruta localhost:8080/publication/nuevaPublicacion
    @PostMapping("/nuevaPublicacion")
    public String crearPublicacion(@Validated @ModelAttribute ("publicacion") Publication publication, BindingResult result, Model model, @RequestParam("file[]") List<MultipartFile> imagen) {
    if (result.hasErrors()) {
        //aca deberia ir una pagina de error o algo xd
        // retornar y pasarle el objeto publication, tipo, provincia, ciudad, comodidad, caracteristicaComodidad;
        List<Type> types = tipoService.findAll();
        List<Province> provinces = provinciaService.findAll();
        List<City> ciudades = ciudadService.findAll();
        List<Comfort> comodidades = comodidadService.findAll();
        List<FeatureComfort> caracteristicaComodidades = caracteristicaComodidadService.findAll();


        model.addAttribute("tipos", types);
        model.addAttribute("comodidades", comodidades);
        model.addAttribute("caracteristicaComodidades", caracteristicaComodidades);

        return "Publicacion/crearPublicacion";
    }
//        @RequestParam("file[]")List<MultipartFile> imagen
    if (!imagen.isEmpty()) {
        try {
//            imprimir el nombre de todos los archivos de imagen
            Path directorioImagenes = Path.of("src//main//webapp//assets//img//rents");
            String rutaAbsoluta = directorioImagenes.toFile().getAbsolutePath();

            List<PhotoPublication> fotos = new ArrayList<>();

            for (MultipartFile file : imagen) {
                System.out.println(file.getOriginalFilename());

                byte[] bytes = file.getBytes();



                String nombreImagen = Math.random() + file.getOriginalFilename();
                Path rutaCompleta = Paths.get(rutaAbsoluta + "//" + nombreImagen);
                Files.write(rutaCompleta, bytes);

                PhotoPublication photoPublication = new PhotoPublication();
                photoPublication.setUrl(nombreImagen);
                photoPublication.setIdPublication(publication);

                fotos.add(photoPublication);
            }
            publication.setImagenes(fotos);

//            publicacionService.save(publication, imagen);
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
        List<Province> provinces = provinciaService.findAll();
        List<City> ciudades = ciudadService.findAll();
        List<Comfort> comodidades = comodidadService.findAll();
        List<FeatureComfort> caracteristicaComodidades = caracteristicaComodidadService.findAll();

        model.addAttribute("ciudades", ciudades);
        model.addAttribute("provincias", provinces);
        model.addAttribute("tipos", types);
        model.addAttribute("comodidades", comodidades);
        model.addAttribute("caracteristicaComodidades", caracteristicaComodidades);

        model.addAttribute("publicacion", publication);

//        publicacionService.deletePublicacionById(4L);

        return "Publicacion/editarPublicacion";
    }

    @PostMapping("/editarPublicacion/{id}")
    public String editarPublicacion(@PathVariable("id") Long id, @Validated @ModelAttribute ("publicacion") Publication publication, BindingResult result, @RequestParam("file[]") List<MultipartFile> imagen ) {
        if (result.hasErrors()) {
            //aca deberia ir una pagina de error o algo xd
            return "Publicacion/editarPublicacion";
        }
        if (!imagen.isEmpty()) {
            try {
//            imprimir el nombre de todos los archivos de imagen
                Path directorioImagenes = Path.of("src//main//webapp//assets//img//rents");
                String rutaAbsoluta = directorioImagenes.toFile().getAbsolutePath();

                List<PhotoPublication> fotos = new ArrayList<>();

                for (MultipartFile file : imagen) {
                    System.out.println(file.getOriginalFilename());

                    byte[] bytes = file.getBytes();



                    String nombreImagen = Math.random() + file.getOriginalFilename();
                    Path rutaCompleta = Paths.get(rutaAbsoluta + "//" + nombreImagen);
                    Files.write(rutaCompleta, bytes);

                    PhotoPublication photoPublication = new PhotoPublication();
                    photoPublication.setUrl(nombreImagen);
                    photoPublication.setIdPublication(publication);

                    fotos.add(photoPublication);
                }
                publication.setImagenes(fotos);

//            publicacionService.save(publication, imagen);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        publicacionService.updatePublicacion(publication, id);
        return "redirect:/publicacion/consultarPublicacion";
    }



//    Consultar todas las publicaciones de un usuario
//    Ruta localhost:8080/publicacion/consultarPublicacion
    @GetMapping("/consultarPublicacion")
    public String consultarPublicacion(Model model){

        List<Publication> publicaciones = publicacionService.findAllByEstadoPublicacion("activo");
        publicaciones.addAll(publicacionService.findAllByEstadoPublicacion("Alquilado"));
        List<FeatureComfort> caracteristicaComodidades = caracteristicaComodidadService.findAll();

        model.addAttribute("publicaciones", publicaciones);
        model.addAttribute("caracteristicaComodidades", caracteristicaComodidades);

        return "Publicacion/consultarPublicacion";
    }

    @GetMapping("/consultarAlquiler")
    public String consultarAlquiler(Model model){

        List<Publication> publicaciones = publicacionService.findAllByEstadoPublicacion("Alquilado");

        model.addAttribute("publicaciones", publicaciones);

        return "Publicacion/consultarAlquileres";
    }



//    Ver una publicacion
//    Ruta localhost:8080/publicacion/verPublicacion/{id}
    @GetMapping("/verPublicacion/{id}")
    public String verPublicacion(@PathVariable("id") Long id, Model model, HttpServletRequest request){

        Publication publication = publicacionService.getPublicacionById(id);
        Long idUsuario = (Long) request.getSession().getAttribute("userId");
        User user = usuarioService.getUsuarioById(idUsuario);

        model.addAttribute("usuario", user);
        model.addAttribute("publicacion", publication);
//        usuarioService.agregarFavoritos(id,1L);

//        usuarioService.quitarFavoritos(1L,1L);
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

        List<Publication> publicaciones = publicacionService.findAllByEstadoPublicacion("activo");

        model.addAttribute("publicaciones", publicaciones);

        return "Publicacion/verPublicaciones2";
    }

//    agregar a favoritos
    @PostMapping("/agregarFavorito/{id}")
    public String agregarFavorito(@PathVariable("id") Long id,  HttpServletRequest request) {
        Long idUsuario = (Long) request.getSession().getAttribute("userId");
        usuarioService.agregarFavoritos(id,idUsuario);
        return "redirect:/publicacion/verPublicacion/{id}";
    }

    @PostMapping("/quitarFavorito/{id}")
    public String quitarFavorito(@PathVariable("id") Long id,  HttpServletRequest request) {
        Long idUsuario = (Long) request.getSession().getAttribute("userId");
        usuarioService.quitarFavoritos(id,idUsuario);
        return "redirect:/publicacion/verPublicacion/{id}";
    }


//    @GetMapping("/verFavoritos")
//    public String verFavoritos(Model model){
//
////        List<Publication> publicaciones = publicacionService.findAllByFavorito("si");
//
//        model.addAttribute("publicaciones", publicaciones);
//
//        return "Publication/verFavoritos";
//    }



}


