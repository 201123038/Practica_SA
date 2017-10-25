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
@WebService(serviceName = "Aduana")
public class Aduana {

            Connection conn = null;
         Statement stmt = null;

    /**
     * This is a sample web service operation
     */
@WebMethod(operationName = "calcular_Costo_Aduana")
    public String calcular_Costo_Aduana(
            @WebParam(name = "marca") String marca,
            @WebParam(name = "linea") String linea,
            @WebParam(name = "modelo") Integer modelo) {
        
        String respuesta = "",costo_Aduana="",status="",descripcion="";
        String valor="";
        valor= impuestoAduana(linea,marca,modelo);
        Double v1=(Double.parseDouble(valor))/100;
        Double imp=0.0;
        
        imp=v1+(2000/(2017-modelo+1))+1000;
        
        
        respuesta="{" +
        "\"costo_Aduana\" : "+imp.toString()+"," +
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
                respuesta="prueba";

        return respuesta;
    }
 

        String impuestoAduana(String linea, String marca,Integer modelo){
        String respuesta="";
          try {
            Class.forName("org.postgresql.Driver");
	} catch (ClassNotFoundException e) {
			System.out.println("Error!");
			e.printStackTrace();
	}


		try {
			conn = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/aduana", "postgres",
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
            @WebMethod(operationName = "transferir")
    public String transferir(@WebParam(name = "id_transferencia") Integer id_transferencia,
                                   @WebParam(name = "monto") Double monto) {
        String respuesta ="";        

        agregar_transferencia(id_transferencia,monto);
        return respuesta;
    }

    void agregar_transferencia(Integer id, Double monto) {
        try {
			Class.forName("org.postgresql.Driver");

		} catch (ClassNotFoundException e) {

			System.out.println("Error!");
			e.printStackTrace();

		}


		try {

			conn = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/aduana", "postgres",
					"1234");
                             stmt = conn.createStatement();
                                String sql = "INSERT INTO transfer (id_transferencia,monto) "
                                    + "VALUES ("+id+","+monto+");";
                            stmt.executeUpdate(sql);
                            stmt.close();
                              conn.commit();
                              conn.close();        
                } catch (SQLException e) {

			System.out.println("Error2");
			e.printStackTrace();

		}
                
    }

}
