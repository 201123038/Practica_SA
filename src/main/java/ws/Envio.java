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
    public String cargar_Vehiculos(@WebParam(name = "solicitud_catalogo") int solicitud_catalogo) {
        
        String catalogo = "";
        
        return catalogo;
    }
    
@WebMethod(operationName = "calcular_costo_viaje")
    public double calcular_costo_viaje(@WebParam(name = "viaje") int viaje,
                                        @WebParam(name = "c") double costo) {
        
        double costo_viaje = 0;
        
        return costo_viaje;
    }
    
  
@WebMethod(operationName = "guardar_Transferencia")
    public boolean guardar_Transferencia(@WebParam(name = "id_transferencia") int id_transferencia,
                                        @WebParam(name = "monto") int monto) {
        
        boolean respuesta = false;
        
        return respuesta;
    }
    
  
    
    
}
