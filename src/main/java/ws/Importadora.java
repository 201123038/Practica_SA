/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author yessenia
 */
@WebService(serviceName = "Importadora")
public class Importadora {

    
    @WebMethod(operationName = "crear_Cuenta")
    public String crear_Cuenta(
            @WebParam(name = "nombre") String nombre,
            @WebParam(name = "username") String username,
            @WebParam(name = "password") String password,
            @WebParam(name = "no_Tarjeta") String no_Tarjeta) 
    {
        String respuesta = "";
        boolean bandera=false;
       
        try {

                  Class.forName("org.postgresql.Driver");
                  bandera=true;
		} catch (ClassNotFoundException e) {

                       bandera=false;     
                    e.printStackTrace();
		
		}

        
        if(bandera==true)
            respuesta="{  \"status\":0,  \"descripcion\":\"usuario creado exitosamente\" }";
        else
            //si existe en vd
            respuesta="{  \"status\":1,  \"descripcion\":\"username ya existe\" }";
        
   
        return respuesta;
    }
        
    @WebMethod(operationName = "validar_Sesion")
    public String validar_Sesion(@WebParam(name = "username") String username,
                                  @WebParam(name = "password") String password) {
        String respuesta = "";
        //llamar a bd el nombre
        
        String nombre="",no_tarjeta="";

        respuesta="{  \"nombre\":\""+nombre+"\",  \"no_tarjeta\":\""+no_tarjeta+"\",  \"status\":0,  \"descripcion\":\"validacion correcta\" }";
        
           respuesta="{  \"nombre\":\"\",  \"no_tarjeta\":\"\",  \"status\":1,  \"descripcion\":\"usuario o password no validos\" }";
        
           respuesta="{  \"nombre\":\""+username+"\",  \"no_tarjeta\":\"123\",  \"status\":0,  \"descripcion\":\"validacion correcta\" }";
        
        //verificar en bd
        return respuesta;
    }

    @WebMethod(operationName = "solicitar_Catalogo_Vehiculos")
    public String solicitar_Catalogo_Vehiculos() {
        String listado_Vehiculos="",preciov="",precioe="",impsat="",impad="",iva="",isr="";
       //JSON catalogo de bd 
       listado_Vehiculos=" \"precio_Vehiculo\":"+preciov+", \"precio_Envio\":"+precioe+", \"impuesto_Sat\":"+impsat+", \"impuesto_Aduana\":"+impad+", \"iva\":"+iva+", \"isr\":"+isr+", \"status\":0,  \"descripcion\":\"Calculos realizados exitosamente\" }";
        
        listado_Vehiculos="prueba";
       return listado_Vehiculos;
    }
    
    @WebMethod(operationName = "cotizar_Vehiculo")
    public String cotizar_Vehiculo(@WebParam(name = "id_Vehiculo") Integer id_Vehiculo,
                                   @WebParam(name = "pais_Destino") String pais_Destino) {
        String respuesta ="";        
        //JSON catalogo cotizaciones de bd
        String  marca ="", pais_Origen="",precio_Vehiculo="",status="",descripcion="", precio_envio="",sat="", aduana="", iva="", isr="";
        
        respuesta="{ \"precio_Vehiculo\":"+precio_Vehiculo+", \"precio_Envio\":"+precio_envio+", \"impuesto_Sat\":"+sat+", \"impuesto_Aduana\":"+aduana+", \"iva\":"+iva+", \"isr\":"+isr+", \"status\":0,  \"descripcion\":\"Calculos realizados exitosamente\" }";

        respuesta="prueba";
        return respuesta;
    }
    
     @WebMethod(operationName = "comprar_Vehículo")
    public String comprar_Vehiculo(
            @WebParam(name = "id_Cliente") Integer id_Cliente,
            @WebParam(name = "no_Tarjeta") String no_Tarjeta,
            @WebParam(name = "id_Vehiculo") Integer id_Vehiculo,
            @WebParam(name = "precio_Vehiculo") Double precio_Vehiculo,
            @WebParam(name = "precio_Envio") Double precio_Envio,
            @WebParam(name = "impuesto_Sat") Double impuesto_Sat,
            @WebParam(name = "impuesto_Aduana") Double impuesto_Aduana,
            @WebParam(name = "iva") Double iva,
            @WebParam(name = "isr") Double isr,
            @WebParam(name = "pais_Origen") String  pais_Origen ,
            @WebParam(name = "pais_Destino") String  pais_Destino
    ) {
        Integer factura=0;
        String respuesta="", serie="";//JSON
            
        respuesta="{" +
                "\"serie\" : \""+serie+"\"," +
                "\"numero_Factura\" : \""+factura+"\" ," +
                "\"status\":0," +
                "\"descripcion\":\"Exitoso\"" +
                "}";
        respuesta="prueba";
        return respuesta;
    }
    
    
}
