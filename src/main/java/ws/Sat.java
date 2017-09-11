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
            @WebParam(name = "id_Transferencia ") int id_Transferencia,
            @WebParam(name = "monto_Compra ") double monto_Compra) {
        
        boolean respuesta=false;
        
        
        return respuesta;
    }
    
    @WebMethod(operationName = "guardar_Manifiesto")
    public int guardar_Manifiesto(
            @WebParam(name = "nombre_Cliente") String nombre_Cliente) {
        
        int numero_Manifiesto=0;
        
        return numero_Manifiesto;
    }
    
    @WebMethod(operationName = "guardar_Declaracion")
    public int guardar_Declaracion(
            @WebParam(name = "name") String entrada) {
 
        //entradas JSON
        
        int numero_Declaracion=0;
        
        return numero_Declaracion;
    }
    
    @WebMethod(operationName = "Generar_manifiesto")
    public int Generar_manifiesto(
            @WebParam(name = "codigo_Agende") int codigo_Agende,
            @WebParam(name = "factura") int factura,
            @WebParam(name = "doc_Transporte") int doc_Transporte,
            @WebParam(name = "titulo_Propiedad") int titulo_Propiedad,
            @WebParam(name = "tarjeta_Circulacion") int tarjeta_Circulacion,
            @WebParam(name = "declaracion_Aduanera") double declaracion_Aduanera) {
        
        int numero_Manifiesto=0;
        
        return numero_Manifiesto;
    }
    
     @WebMethod(operationName = "calcular_Impuesto2")
    public String calcular_Impuesto2(
            @WebParam(name = "tipo") String tipo,
            @WebParam(name = "marca") String marca,
            @WebParam(name = "linea") String linea,
            @WebParam(name = "centimetros") int centimetros,
            @WebParam(name = "cilindraje") int cilindraje,
            @WebParam(name = "puertas") int puertas,
            @WebParam(name = "asientos") int asientos,
            @WebParam(name = "modelo") int modelo) {
        
        //preliminar
        int monto_impuesto=0;
        int cod_interno=0;

        String salida="";//JSON
        
        return salida;
    }
    
}
