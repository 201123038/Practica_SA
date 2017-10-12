/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import java.sql.ResultSet;

/**
 *
 * @author yessenia
 */
@WebService(serviceName = "Envio")
public class Envio {

        Connection conn = null;
         Statement stmt = null;

@WebMethod(operationName = "cargar_Vehiculos")
    public String cargar_Vehiculos(){        
        String catalogo = "";
        
        catalogo=vehiculos();
                
        return catalogo;
    }


    
@WebMethod(operationName = "calcular_costo_viaje")
    public String calcular_costo_viaje(@WebParam(name = "id_Vehiculo") Integer id_Vehiculo,
                                        @WebParam(name = "pais_Destino") String pais_Destino) {
        
        double costo_viaje = 0;
        String respuesta="";
        costo_viaje=Double.parseDouble(envio(pais_Destino));   

        //si todo bien
        respuesta="{" +
"\"costo_viaje\" : "+costo_viaje+"," +
"\"status\":0," +
"\"descripcion\":\"Exitoso\"" +
"}";
        //sino
        /*
        respuesta="{" +
"\"costo_viaje\" : ," +
"\"status\":1," +
"\"descripcion\":\"Tipo de dato incorrecto\"" +
"}";
*/

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
        
                respuesta="prueba";
        
        return respuesta;
    }
    
  
    
    
      String vehiculos() {
          String catalogo="",idv="", marca="", linea="", modelo="", paiso="",precio="", respuesta="";
                try {
                    Class.forName("org.postgresql.Driver");
                } catch (ClassNotFoundException e) {
                                System.out.println("Error!");
                                e.printStackTrace();
                }

		try {
			conn = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/envios", "postgres",
					"1234");
                        stmt = conn.createStatement();
                        catalogo="{"+"\"vehiculos\":[ ";

                        ResultSet rs = stmt.executeQuery( "SELECT * FROM vehiculo; ");
                         while ( rs.next() ) {
                            idv = rs.getString("id_Vehiculo");
                            marca = rs.getString("marca");
                            marca = rs.getString("linea");
                            marca = rs.getString("modelo");
                            marca = rs.getString("pais_Origen");
                            marca = rs.getString("precio_Vehiculo");

                        catalogo+= "  {\"id_Vehiculo\":"+idv+","
                            + "\"marca\":\""+marca+"\", "
                            + "\"linea\":\""+linea+"\","
                            + "\"modelo\":"+modelo+","
                            + "\"pais_Origen\":\""+paiso+"\","
                            + "\"precio_Vehiculo\":"+precio+"},";         
                            idv="";marca=""; linea=""; modelo=""; paiso="";precio="";
        
                         } 
                        catalogo+="]," +
                                "\"status\":0," +
                                "\"descripcion\":\"Exitoso\"" +
                                "}";
                        catalogo.replace("},]", "}]");
                         
                         rs.close();
                         stmt.close();
                         conn.close();                
		} catch (SQLException e) {

                            //sino
                     catalogo="{" +
                         "\"vehiculos\":[ " +
                         "]," +
                         "\"status\":1," +
                         "\"descripcion\":\"Error con la conexión a la BD de Envios\"" +
                         "}";
                    System.out.println("Error2");
			e.printStackTrace();
		}

	         return respuesta;
    }
      String envio(String pais){
        String respuesta="";
          try {
            Class.forName("org.postgresql.Driver");
	} catch (ClassNotFoundException e) {
			System.out.println("Error!");
			e.printStackTrace();
	}


		try {
			conn = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/envios", "postgres",
					"1234");
                        stmt = conn.createStatement();
                        ResultSet rs = stmt.executeQuery( "SELECT envio FROM vehiculo where pais_Origen='"+pais+"';" );
                         while ( rs.next() ) {
                            respuesta = rs.getString("envio");
                         }
                         
                         if(!(respuesta.equals(""))){
                             respuesta="100";
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
 
    
    
}
