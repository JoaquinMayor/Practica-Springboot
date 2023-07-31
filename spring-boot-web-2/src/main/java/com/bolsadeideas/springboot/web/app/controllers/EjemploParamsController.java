package com.bolsadeideas.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/params")
public class EjemploParamsController {

    @GetMapping("/")
    public String index(){
        return "params/index";
    }
    
    @GetMapping("/string")
    public String param(@RequestParam(name = "texto", defaultValue = "Hola q ase") String texto, Model model){ /*Pasar otros parametros con requestparam, se le pasa un nombre y el required es por si no se pasa ningun valor*/
        model.addAttribute("resultado", "El texto enviado es : " + texto);
        return "params/ver";
    }

    @GetMapping("/mix-params")
    public String param(@RequestParam String saludo, @RequestParam Integer numero, Model model){ /*Pasar Multiples parametros*/
        model.addAttribute("resultado", "El saludo enviado es : '" + saludo +"' " + "' y el número es '"+ numero + "'");
        return "params/ver";
    }

    @GetMapping("/mix-params-request") /*No se pueden tener rutas repetidas */
    public String param(HttpServletRequest request, Model model){ /*Pasar Multiples parametros, todos los que queremos del request*/
        String saludo = request.getParameter("saludo");
        Integer numero = null;
        try{
             numero = Integer.parseInt(request.getParameter("numero")); /*Porque el getParameter siempre pasa en formato string, siempre hay que meterlo en un try y catch en estos elementos */
        }catch(NumberFormatException e){
            numero = 0;
        }
        model.addAttribute("resultado", "El saludo enviado es : '" + saludo +"' " + "' y el número es '"+ numero + "'");
        return "params/ver";
    }
}
