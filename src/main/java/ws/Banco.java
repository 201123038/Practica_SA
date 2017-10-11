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
@WebService(serviceName = "Banco")
public class Banco {

    
    @WebMethod(operationName = "transferencia_cuenta")
    public String transferencia_cuenta(
            @WebParam(name = "no_Tarjeta") String no_Tarjeta,
            @WebParam(name = "cuenta_destino") String cuenta_destino,
            @WebParam(name = "monto") Double monto) {
        
        String respuesta = "", id_Transferencia="";
        
        respuesta="{" +
        "\"id_Transferecia\" : \""+id_Transferencia+"\"," +
        "\"status\":0," +
        "\"descripcion\":\"Transferencia exitosa\"" +
        "}";
        

        respuesta="{" +
        "\"id_Transferecia\" : \"\"," +
        "\"status\":0," +
        "\"descripcion\":\"Transferencia fallida\"" +
        "}";

        respuesta="{" +
        "\"id_Transferecia\" : \"\"," +
        "\"status\":0," +
        "\"descripcion\":\"Saldo insuficiente\"" +
        "}";

        respuesta="{" +
        "\"id_Transferecia\" : \"\"," +
        "\"status\":0," +
        "\"descripcion\":\"Cuenta inexistente\"" +
        "}";
                respuesta="prueba";
        
        return respuesta;
    }


}
