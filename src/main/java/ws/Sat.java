/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author yessenia
 */
@WebService(serviceName = "Sat")
public class Sat {

        Connection conn = null;
         Statement stmt = null;

    @WebMethod(operationName = "calcular_Impuesto")
    public String calcular_Impuesto(
            @WebParam(name = "linea") String linea,
            @WebParam(name = "marca") String marca,
            @WebParam(name = "modelo") Integer modelo
               ) {
        
        String respuesta="", valor="";
        valor= impuestoSat(linea,marca,modelo);
        Double v1=(Double.parseDouble(valor))/100;
        Double imp=0.0;
        
        imp=v1+(1000/(2017-modelo+1))+1000;
        
                respuesta="{" +
        "\"valor\" : "+v1+"," +
        "\"status\":0," +
        "\"descripcion\":\"Exitoso\"" +
        "}";        
        return respuesta;
    }
    
    @WebMethod(operationName = "registro_Id_Compra")
    public String registro_Id_Compra(
            @WebParam(name = "id_Transferencia ") Integer id_Transferencia,
            @WebParam(name = "monto_Compra ") double monto_Compra) {
        
        String respuesta="";
        
        //si todo bbien
        
        respuesta="{" +
            "\"status\":0," +
            "\"descripcion\":\"Exitoso\"" +
            "}";
        
        //sino 
        respuesta="{" +
            "\"status\":1," +
            "\"descripcion\":\"Tipo de dato incorrecto\"" +
            "}";
        
                respuesta="prueba";
        return respuesta;
    }
    
    @WebMethod(operationName = "guardar_Manifiesto")
    public String guardar_Manifiesto(
            @WebParam(name = "marca") String marca, 
            @WebParam(name = "linea") String linea ,
            @WebParam(name = "modelo") String modela ,
            @WebParam(name = "fecha_Entrada") String fecha_Entrada ,
            @WebParam(name = "pais_Origen") String pais_Origen)    
    {
        
        Integer numero_Manifiesto=0;
        String respuesta="";
        
        respuesta="{" +
        "\"num_Manifiesto\" : "+numero_Manifiesto+"," +
        "\"status\":0," +
        "\"descripcion\":\"Exitoso\"" +
        "}";
        
                respuesta="prueba";
        return respuesta;
    }
    
    @WebMethod(operationName = "guardar_Declaracion")
    public String guardar_Declaracion(
            @WebParam(name = "marca") String marca,
            @WebParam(name = "linea") String linea,
            @WebParam(name = "modelo") String model,
            @WebParam(name = "precio") String precio,
            @WebParam(name = "name") String fecha_Declaracion
    
    ) {
 
        //entradas JSON
        
        Integer numero_Declaracion=0;
        String respuesta="";
        
        respuesta="{" +
        "\"num_declaracion\" : "+numero_Declaracion+"," +
        "\"status\":0," +
        "\"descripcion\":\"Exitoso\"" +
        "}";
        
        
                respuesta="prueba";
        return respuesta;
    }
    
    
    String impuestoSat(String linea, String marca,Integer modelo){
        String respuesta="";
          try {
            Class.forName("org.postgresql.Driver");
	} catch (ClassNotFoundException e) {
			System.out.println("Error!");
			e.printStackTrace();
	}


		try {
			conn = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/sat", "postgres",
					"1234");
                        stmt = conn.createStatement();
                        ResultSet rs = stmt.executeQuery( "SELECT porcentaje FROM impuesto where linea='"+linea+"' and marca='"+marca+"';" );
                         while ( rs.next() ) {
                            respuesta = rs.getString("porcentaje");

                         }
                         
                         rs.close();
                         stmt.close();
                         conn.close();
                         
                    if(!(respuesta.equals(""))){
                           respuesta="1";
                            }
		} catch (SQLException e) {
                    respuesta="1";    
                    System.out.println("Error2");
                    e.printStackTrace();
		}
        
        return respuesta;
    }
    
    /* saber que puchis
    
    
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
    */
}
