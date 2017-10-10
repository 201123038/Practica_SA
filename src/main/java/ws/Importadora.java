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
    public String validar_Sesion(@WebParam(name = "username") String username,
                                  @WebParam(name = "password") String password) {
        String respuesta = "";
        //llamar a bd el nombre
        
        String nombre="",no_tarjeta="";
        if(!nombre.equals("")){
            respuesta="{  \"nombre\":\""+nombre+"\",  \"no_tarjeta\":\""+no_tarjeta+"\",  \"status\":0,  \"descripcion\":\"validacion correcta\" }";
        
        }else{
           respuesta="{  \"nombre\":\"\",  \"no_tarjeta\":\"\",  \"status\":1,  \"descripcion\":\"usuario o password no validos\" }";
        }

        //verificar en bd

        return respuesta;
    }
    
    @WebMethod(operationName = "crear_Cuenta")
    public String crear_Cuenta(
            @WebParam(name = "nombre") String nombre,
            @WebParam(name = "username") String username,
            @WebParam(name = "password") String password,
            @WebParam(name = "no_Tarjeta") String no_Tarjeta) 
    {
        String respuesta = "";
        boolean bandera=false;
        //agregar a bd
        if(bandera==true)
            respuesta="{  \"status\":0,  \"descripcion\":\"usuario creado exitosamente\" }";
        else
            //si existe en vd
            respuesta="{  \"status\":1,  \"descripcion\":\"username ya existe\" }";
        
        return respuesta;
    }
    
    @WebMethod(operationName = "solicitar_Catalogo_Vehiculos")
    public String solicitar_Catalogo_Vehiculos() {
        String listado_Vehiculos="",preciov="",precioe="",impsat="",impad="",iva="",isr="";
       //JSON catalogo de bd 
       listado_Vehiculos=" \"precio_Vehiculo\":"+preciov+", \"precio_Envio\":"+precioe+", \"impuesto_Sat\":"+impsat+", \"impuesto_Aduana\":"+impad+", \"iva\":"+iva+", \"isr\":"+isr+", \"status\":0,  \"descripcion\":\"Calculos realizados exitosamente\" }";
        return listado_Vehiculos;
    }
    
    @WebMethod(operationName = "cotizar_Vehiculo")
    public String cotizar_Vehiculo(@WebParam(name = "linea") String linea,
                                   @WebParam(name = "modelo") String modelo) {
        String listado_Cotizaciones ="";        
        //JSON catalogo cotizaciones de bd
        String id_Vehiculo="", marca ="", pais_Origen="",precio_Vehiculo="",status="",descripcion="", precio_envio="",sat="", aduana="", iva="", isr="";
        
        listado_Cotizaciones="{ \"precio_Vehiculo\":"+precio_Vehiculo+", \"precio_Envio\":"+precio_envio+", \"impuesto_Sat\":"+sat+", \"impuesto_Aduana\":"+aduana+", \"iva\":"+iva+", \"isr\":"+isr+", \"status\":0,  \"descripcion\":\"Calculos realizados exitosamente\" }";
        return listado_Cotizaciones;
    }
    
     @WebMethod(operationName = "comprar_Vehículo")
    public String comprar_Vehiculo(
            @WebParam(name = "id_Cliente") Integer id_Cliente,
            @WebParam(name = "no_Tarjeta") String no_Tarjeta,
            @WebParam(name = "id_Vehiculo") Integer id_Vehiculo
    ) {
        Integer numero_Factura=0;
        double impuesto_Sat=0;
        double impuesto_Aduana=0;
        double precio_Envio=0;
        double precio_Vehiculo=0;
        String respuesta="";//JSON

        
        
        return respuesta;
    }
    
    
}
