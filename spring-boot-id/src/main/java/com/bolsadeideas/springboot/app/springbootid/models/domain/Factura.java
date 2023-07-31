package com.bolsadeideas.springboot.app.springbootid.models.domain;

import java.io.Serializable;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
@SessionScope /*La factura va durar lo que dure una peticion http del usuario, el objeto se contruye cada vez que se hace la peticion, si es unico, como el cliente en este caso se va concatenando*/
                /*Existe @RequestScope, AplicationScope , SessionScope (para sesiones), que debe iomplementar serializable ya que se almacenan los datos en algun lado, la session son varios reques y se mantienen los datos lo que dure la sesion*/
public class Factura implements Serializable{
    
    @Value("${factura.descripcion}")
    private String descripcion;
    @Autowired /*Todo lo que sea un componente se le pone el autowired */
    private Cliente cliente;

    @Autowired /*Porque se encuentra la creacion de la lista en AppConfig como un bean, asi hay que crear la listas*/
    @Qualifier("itemsFacturaOficina")
    private ArrayList<ItemFactura> items;

    @PostConstruct /*Se puede hacer en el inicio para poder inicializar algun elemento */
    public void inicializar(){
        cliente.setNombre(cliente.getNombre().concat(" ").concat("Ignacio"));
        descripcion = descripcion.concat(" del cliente: ".concat(cliente.getNombre()));
    }

    @PreDestroy
    public void destruir(){ /*El elemento solo dura lo que dure la aplicacion */
        System.out.println("Factura destruida: ".concat(descripcion));
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<ItemFactura> getItems() {
        return items;
    }

    public void setItems(ArrayList<ItemFactura> items) {
        this.items = items;
    }
    
    
    
   

    
}
