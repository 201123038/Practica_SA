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
    public boolean transferencia_cuenta(@WebParam(name = "cuenta_origen") Integer cuenta_origen,
                                        @WebParam(name = "cuenta_destino") Integer cuenta_destino,
                                        @WebParam(name = "monto") Integer monto) {
        
        boolean respuesta = false;
        
        return respuesta;
    }


}
