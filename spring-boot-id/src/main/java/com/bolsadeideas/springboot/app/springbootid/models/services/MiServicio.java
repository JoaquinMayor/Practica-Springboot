package com.bolsadeideas.springboot.app.springbootid.models.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("miServicioSimple") /*@Componet Queda registrado con esto como un pins de Spring, para poder trabajar con inyección de dependencias, si se pone service es lo mismo, solo es una cuestion descriptiva */
                                /*Dentro de los parentecis es un nombre identificador */
@Primary /*Hace que cuando en el controlador se determina por la interface, y haya mas de una clase que lo implemente, esta sea la primera opción por defecto */

public class MiServicio implements IServicio{
    
    @Override
    public String operacion(){
        return "ejecutando algún proceso importante simple...";
    }


}
