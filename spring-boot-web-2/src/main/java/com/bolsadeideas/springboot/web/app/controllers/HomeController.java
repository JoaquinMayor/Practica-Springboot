package com.bolsadeideas.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    
    @GetMapping("/")
    public String home(){
        return "forward:/app/index"; /*Esto para redirigir a otro controlador redirect:/app/index redirige a la pagina de inicio, se puede poner el link de una pagina*/
    }    /*con forward mantiene la ruta que tiene de donde se envia, de la otra manera lo cambia, solo es para rutas propias del proyecto */
}
