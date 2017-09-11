/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author yessenia
 */
@WebService(serviceName = "Importadora")
public class Importadora {

    
    @WebMethod(operationName = "validar_Sesion")
    public Boolean validar_Sesion(@WebParam(name = "username") String username,
                                  @WebParam(name = "password") String password) {
        Boolean respuesta = false;

        //verificar en bd

        return respuesta;
    }
    
    @WebMethod(operationName = "crear_Cuenta")
    public Boolean crear_Cuenta(
            @WebParam(name = "nombre") String nombre,
            @WebParam(name = "username") String username,
            @WebParam(name = "password") String password,
            @WebParam(name = "no_Tarjeta") String no_Tarjeta) 
    {
        Boolean respuesta = false;
        //agregar a bd
        
        return respuesta;
    }
    
    @WebMethod(operationName = "solicitar_Catalogo_Vehiculos")
    public String solicitar_Catalogo_Vehiculos() {
        String listado_Vehiculos="";
       //JSON catalogo de bd 
        return listado_Vehiculos;
    }
    
    @WebMethod(operationName = "cotizar_Vehiculo")
    public String cotizar_Vehiculo(@WebParam(name = "linea") String linea,
                                   @WebParam(name = "modelo") String modelo) {
        String listado_Cotizaciones ="";        
        //JSON catalogo cotizaciones de bd
        return listado_Cotizaciones;
    }
    
     @WebMethod(operationName = "comprar_Vehículo")
    public String comprar_Vehículo(
            @WebParam(name = "id_Cliente") int id_Cliente,
            @WebParam(name = "no_Tarjeta") String no_Tarjeta,
            @WebParam(name = "id_Vehiculo") int id_Vehiculo
    ) {
        int numero_Factura=0;
        double impuesto_Sat=0;
        double impuesto_Aduana=0;
        double precio_Envio=0;
        double precio_Vehiculo=0;
        String respuesta="";//JSON

        
        
        return respuesta;
    }
    
    
}
