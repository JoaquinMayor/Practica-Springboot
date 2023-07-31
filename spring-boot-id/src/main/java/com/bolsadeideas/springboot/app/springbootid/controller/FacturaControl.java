package com.bolsadeideas.springboot.app.springbootid.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bolsadeideas.springboot.app.springbootid.models.domain.Factura;


@Controller
@RequestMapping("/factura")
public class FacturaControl {

    @Autowired
    private Factura factura;
    
    @GetMapping("/ver")
    public String ver(Model model){
        model.addAttribute("factura", factura);
        model.addAttribute("titulo", "Ejemplo de Factura con Inyección de Dependencia"); 
        return "factura/ver";
    }
}
