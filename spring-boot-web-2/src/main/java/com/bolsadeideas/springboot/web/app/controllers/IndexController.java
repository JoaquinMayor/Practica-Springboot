package com.bolsadeideas.springboot.web.app.controllers;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bolsadeideas.springboot.web.app.models.Usuarios;

import org.springframework.ui.Model;


@Controller
@RequestMapping("/app") /*Ruta base para todos los metodos del controlador*/ /*Para una pagina de inicio no debe tener la rquestMapping */
public class IndexController{

    @Value("${texto.indexcontroler.index.titulo}") /*Es lo que pusimos en el aplication properties */
    private String textoIndex;
    
    @Value("${texto.indexcontroler.perfil.titulo}")
    private String textoPerfil;

    @Value("${texto.indexcontroler.listar.titulo}")
    private String textoListar;

    /* Un Controlador tiene metodos de accion que maneja una peticion http del usuario, por ejemplo, mostrar un formulario, cargar datos, consultas, insertar, guardar
     (Maneja los datos de la aplicación, maneja las peticiones del usuario)*/

    /*Hay que mapear la ruta, para que cuando el usuario navegue Para eso:*/
    @RequestMapping(value={"/index","/","","home"}, method = RequestMethod.GET)  /*En el value se pone la ruta url, si se agregan en mas de una ruta, se pone asi ({"/index","/"."/home"}) */
    
    public String index(Model model){ /*Con model pasamos datos del controlador a la vista, el model maneja un mapa de java*/ 
        model.addAttribute("titulo",textoIndex);
        return "index"; /*Para este retorno hay que hacer una plantilla html en la carpeta de templates, siempre en minusculas y es el nombre del archivo html*/
    }

    @RequestMapping("/perfil")
    public String perfil(Model model){
        Usuarios usuario = new Usuarios();
        usuario.setNombre("Joaquín");
        usuario.setApellido("Mayor");
        usuario.setEmail("joaquin88mayor@gmail.com");
        model.addAttribute("usuario", usuario);

         model.addAttribute("titulo",textoPerfil.concat(usuario.getNombre()));
        return "perfil";
    }

    @RequestMapping("/listar")
    public String listar(Model model){
        model.addAttribute("titulo",textoListar);
        /*ArrayList<Usuarios> usuarios = new  ArrayList<>();
        Usuarios usuario1 = new Usuarios("Manuel", "Gonzales", "example@gmail.com");
        Usuarios usuario2 = new Usuarios("Carlos", "Lopez", "example@gmail.com");
        Usuarios usuario3 = new Usuarios("Rosa", "Otero", "example@gmail.com");
        Usuarios usuario4 = new Usuarios("Lola", "Perez", "example@gmail.com");
        usuarios.add(usuario3);
        usuarios.add(usuario2);
        usuarios.add(usuario1);
        usuarios.add(usuario4);*/

        //model.addAttribute("usuarios", usuarios);
        return "listar";
    }

    @ModelAttribute("usuarios") /*Esto es para pasar el atributo a todos los metodos que queramos, el nombre de como lo queremos pasar se pasa en el () es comun en todos los metodos*/
    public ArrayList<Usuarios> poblarUsuarios(){
        ArrayList<Usuarios> usuarios = new  ArrayList<>();
        Usuarios usuario1 = new Usuarios("Manuel", "Gonzales", "example@gmail.com");
        Usuarios usuario2 = new Usuarios("Carlos", "Lopez", "example@gmail.com");
        Usuarios usuario3 = new Usuarios("Rosa", "Otero", "example@gmail.com");
        Usuarios usuario4 = new Usuarios("Lola", "Perez", "example@gmail.com");
        usuarios.add(usuario3);
        usuarios.add(usuario2);
        usuarios.add(usuario1);
        usuarios.add(usuario4);

        return usuarios;
    }

    /*public ModelAndView index(ModelAndView mv){
        ,v.addObject("titulo","hola Spring Framework!");
        mv.setViewName("index");
        return mv;
    } */

}