package com.bolsadeideas.springboot.app.springbootid.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bolsadeideas.springboot.app.springbootid.models.services.IServicio;

@Controller
public class IndexController {
     @Autowired /*Esto es para inyectar el elemento, se puede poner encima de un seter o un contructor*/
     @Qualifier("miServicioComplejo") /*Esto es para usarlo en caso de que no sea el primary y seleccionar la clase que quieres usar */
    private IServicio servicio;  /*Aca se puede poner clase o interfaces, con interfaces es mejor porque está más desaclopado, no depende de la clase , es mas generico*/

    @GetMapping({"/","index",""})
    public String index(Model model){
        model.addAttribute("objeto", servicio.operacion());
        return "index";
    }

   

    
}
