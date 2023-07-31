package com.bolsadeideas.springboot.app.springbootid;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bolsadeideas.springboot.app.springbootid.models.domain.ItemFactura;
import com.bolsadeideas.springboot.app.springbootid.models.domain.Producto;
import com.bolsadeideas.springboot.app.springbootid.models.services.IServicio;
import com.bolsadeideas.springboot.app.springbootid.models.services.MiServicio;
import com.bolsadeideas.springboot.app.springbootid.models.services.MiServicioComplejo;

@Configuration /*Con esto los metodos crean los componenetes , es una alternativa al usar Component*/
public class AppConfig {

    @Bean("MiServicioSimple") /*Nombre en caso de que haya mas de uno */
    public IServicio resgistrarMiServicio(){
        return new MiServicio();
    }

    @Bean("MiServicioComplejo") /*Nombre en caso de que haya mas de uno */
    public IServicio resgistrarMiServicioComplejo(){
        return new MiServicioComplejo();
    }

    @Bean("itemsFactura")
    public ArrayList<ItemFactura> registrarItems(){
        Producto producto1 = new Producto("Camara Sony", 100);
        Producto producto2 = new Producto("Bicicleta Bianchi aro 26", 200);

        ItemFactura linea1 = new ItemFactura(producto1,2);
        ItemFactura linea2 = new ItemFactura(producto2,4);
        ArrayList<ItemFactura> array = new ArrayList<>();
        array.add(linea2);
        array.add(linea1);
        return array;
    }


    @Bean("itemsFacturaOficina")
    public ArrayList<ItemFactura> registrarItemsOficina(){
        Producto producto1 = new Producto("Monitor LG LCD 24", 250);
        Producto producto2 = new Producto("Notebook Asus", 500);
        Producto producto3 = new Producto("Impresora HP Multifuncional", 80);
        Producto producto4 = new Producto("Escritorio Oficina", 300);

        ItemFactura linea1 = new ItemFactura(producto1,2);
        ItemFactura linea2 = new ItemFactura(producto2,1);
        ItemFactura linea3 = new ItemFactura(producto3,1);
        ItemFactura linea4 = new ItemFactura(producto4,1);
        ArrayList<ItemFactura> array = new ArrayList<>();
        array.add(linea2);
        array.add(linea1);
        array.add(linea3);
        array.add(linea4);
        return array;
    }

}
