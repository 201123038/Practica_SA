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
    public String calcular_Costo_Aduana(@WebParam(name = "linea") String linea,
                                        @WebParam(name = "modelo") Integer modelo) {
        
       // String costo_Aduana = "respuesta";
        String respuesta = "";
        
        return respuesta;
    }
    
@WebMethod(operationName = "guardar_Id_Transferencia")
    public boolean guardar_Id_Transferencia(@WebParam(name = "id_Transferencia") Integer id_Transferencia,
                                        @WebParam(name = " monto_Compra") Integer  monto_Compra) {
        
        boolean respuesta = false;
        
        return respuesta;
    }
 

}
