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
@WebService(serviceName = "Sat")
public class Sat {


    @WebMethod(operationName = "calcular_Impuesto")
    public double calcular_Impuesto(
            @WebParam(name = "linea") String linea,
            @WebParam(name = "modelo") Integer modelo) {
        
        double valor=0;
        
        return valor;
    }
    
    @WebMethod(operationName = "registro_Id_Compra")
    public boolean registro_Id_Compra(
            @WebParam(name = "id_Transferencia ") Integer id_Transferencia,
            @WebParam(name = "monto_Compra ") double monto_Compra) {
        
        boolean respuesta=false;
        
        
        return respuesta;
    }
    
    @WebMethod(operationName = "guardar_Manifiesto")
    public Integer guardar_Manifiesto(
            @WebParam(name = "nombre_Cliente") String nombre_Cliente) {
        
        Integer numero_Manifiesto=0;
        
        return numero_Manifiesto;
    }
    
    @WebMethod(operationName = "guardar_Declaracion")
    public Integer guardar_Declaracion(
            @WebParam(name = "name") String entrada) {
 
        //entradas JSON
        
        Integer numero_Declaracion=0;
        
        return numero_Declaracion;
    }
    
    @WebMethod(operationName = "Generar_manifiesto")
    public Integer Generar_manifiesto(
            @WebParam(name = "codigo_Agende") Integer codigo_Agende,
            @WebParam(name = "factura") Integer factura,
            @WebParam(name = "doc_Transporte") Integer doc_Transporte,
            @WebParam(name = "titulo_Propiedad") Integer titulo_Propiedad,
            @WebParam(name = "tarjeta_Circulacion") Integer tarjeta_Circulacion,
            @WebParam(name = "declaracion_Aduanera") double declaracion_Aduanera) {
        
        Integer numero_Manifiesto=0;
        
        return numero_Manifiesto;
    }
    
     @WebMethod(operationName = "calcular_Impuesto2")
    public String calcular_Impuesto2(
            @WebParam(name = "tipo") String tipo,
            @WebParam(name = "marca") String marca,
            @WebParam(name = "linea") String linea,
            @WebParam(name = "centimetros") Integer centimetros,
            @WebParam(name = "cilindraje") Integer cilindraje,
            @WebParam(name = "puertas") Integer puertas,
            @WebParam(name = "asientos") Integer asientos,
            @WebParam(name = "modelo") Integer modelo) {
        
        //preliminar
        Integer monto_impuesto=0;
        Integer cod_Integererno=0;

        String salida="";//JSON
        
        return salida;
    }
    
}
