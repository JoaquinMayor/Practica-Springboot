package com.bolsadeideas.springboot.web.app;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration /*Configurar en caso de que haya varios properties, por, se crea la carpeta java en el mismo lugar del archivo principal
                        le agregamos el configuration y el properties sources */
@PropertySources({   
    @PropertySource("classpath:textos.properties") /*Ingresamos nuestros properties de la siguiente manera */
})
public class TextosPropertiesConfig {
    
}
