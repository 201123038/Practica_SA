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
@WebService(serviceName = "Aduana")
public class Aduana {

    /**
     * This is a sample web service operation
     */
@WebMethod(operationName = "calcular_Costo_Aduana")
    public String calcular_Costo_Aduana(
            @WebParam(name = "marca") String marca,
            @WebParam(name = "linea") String linea,
            @WebParam(name = "modelo") Integer modelo) {
        
        String respuesta = "",costo_Aduana="",status="",descripcion="";
        
        respuesta="{" +
        "\"costo_Aduana\" : "+costo_Aduana+"," +
        "\"status\":0," +
        "\"descripcion\":\"Exitoso\"" +
        "}";
        
        return respuesta;
    }
    
@WebMethod(operationName = "guardar_Id_Transferencia")
    public String guardar_Id_Transferencia(
                                @WebParam(name = "id_Transferencia") Integer id_Transferencia,
                                @WebParam(name = " monto_Compra") Integer  monto_Compra) {
        
        String respuesta = "";
        //todo bien 
        respuesta="{" +
        "\"status\":0," +
        "\"descripcion\":\"Exitoso\"" +
        "}";

        //sino
        
        respuesta="{" +
        "\"status\":1," +
        "\"descripcion\":\"Código de transferencia ya utilizado\"" +
        "}";

        return respuesta;
    }
 

}
