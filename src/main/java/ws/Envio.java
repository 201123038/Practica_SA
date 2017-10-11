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
@WebService(serviceName = "Envio")
public class Envio {


@WebMethod(operationName = "cargar_Vehiculos")
    public String cargar_Vehiculos(){        
        String catalogo = "";
        String idv="", marca="", linea="", modelo="", paiso="",precio="";
        
        //si hay vehiculos
        
        catalogo="{"+"\"vehiculos\":[ ";
          //inicia for
            catalogo+= "  {\"id_Vehiculo\":"+idv+","
                + "\"marca\":\""+marca+"\", "
                + "\"linea\":\""+linea+"\","
                + "\"modelo\":"+modelo+","
                + "\"pais_Origen\":\""+paiso+"\","
                + "\"precio_Vehiculo\":"+precio+"},";         
                idv="";marca=""; linea=""; modelo=""; paiso="";precio="";
                
          //termina for
             catalogo+="]," +
                "\"status\":0," +
                "\"descripcion\":\"Exitoso\"" +
                "}";
        catalogo.replace("},]", "}]");
        
        //sino
        catalogo="{" +
            "\"vehiculos\":[ " +
            "]," +
            "\"status\":1," +
            "\"descripcion\":\"Error con la conexión a la BD de Envios\"" +
            "}";
        
        return catalogo;
    }
    
@WebMethod(operationName = "calcular_costo_viaje")
    public String calcular_costo_viaje(@WebParam(name = "id_Vehiculo") Integer id_Vehiculo,
                                        @WebParam(name = "pais_Destino") String pais_Destino) {
        
        double costo_viaje = 0;
        String respuesta="";
        
        //si todo bien
        respuesta="{" +
"\"costo_viaje\" : "+costo_viaje+"," +
"\"status\":0," +
"\"descripcion\":\"Exitoso\"" +
"}";
        //sino
        respuesta="{" +
"\"costo_viaje\" : ," +
"\"status\":1," +
"\"descripcion\":\"Tipo de dato incorrecto\"" +
"}";
        return respuesta;
    }
    
  
@WebMethod(operationName = "guardar_Transferencia")
    public String guardar_Transferencia(@WebParam(name = "id_transferencia") Integer id_transferencia,
                                        @WebParam(name = "monto") Double monto) {
        
        String respuesta = "";
        
        //si todo bien
            respuesta="{" +"\"status\":0," +
            "\"descripcion\":\"Exitoso\"" +
            "}";
        
        //sino 
            respuesta="{" +"\"status\":1," +
            "\"descripcion\":\"Tipo de dato incorrecto\"" +
            "}";
        
        
        return respuesta;
    }
    
  
    
    
}
