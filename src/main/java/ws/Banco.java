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
@WebService(serviceName = "Banco")
public class Banco {

        Connection conn = null;
         Statement stmt = null;

    
    @WebMethod(operationName = "transferencia_cuenta")
    public String transferencia_cuenta(
            @WebParam(name = "no_Tarjeta") String no_Tarjeta,
            @WebParam(name = "cuenta_destino") String cuenta_destino,
            @WebParam(name = "monto") Double monto) {
        
        String respuesta = "", id_Transferencia="";
        
        
        String total_saldo=saldo(no_Tarjeta);
        Double saldo_cuenta= 0.00;
        if(total_saldo.equals("")){
            respuesta="{" +
            "\"valor\" : \"\"," +
            "\"status\":1," +
            "\"descripcion\":\"Cuenta inexistente\"" +
            "}";
        
        }else{
            saldo_cuenta=Double.parseDouble(total_saldo);
            
            if(saldo_cuenta<monto){
                respuesta="{" +
                "\"valor\" : \"\"," +
                "\"status\":1," +
                "\"descripcion\":\"Saldo insuficiente\"" +
                "}";            
            }else{
                id_Transferencia= transferencia(no_Tarjeta,cuenta_destino,monto);
         
               respuesta="{" +
            "\"valor\": "+id_Transferencia+"," +
            "\"status\":0," +
            "\"descripcion\":\"Transferencia exitosa\"" +
            "}";
         
            }
            
        }
                
        return respuesta;
    }
    
    String saldo(String tarjeta){
        String valor="";
        try {
            Class.forName("org.postgresql.Driver");
	} catch (ClassNotFoundException e) {
			System.out.println("Error!");
			e.printStackTrace();
	}


		try {
			conn = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/banco", "postgres",
					"1234");
                        stmt = conn.createStatement();
                        ResultSet rs = stmt.executeQuery( "SELECT saldo FROM cuenta where no_Tarjeta='"+tarjeta+"';" );
                         while ( rs.next() ) {
                            valor = rs.getString("saldo");
                         }
                     
                         rs.close();
                         stmt.close();
                         conn.close();                
		} catch (SQLException e) {
                     System.out.println("Error2");
			e.printStackTrace();
		}

                return valor;
    }

    String transferencia(String tarjeta, String cuenta, Double monto){
        String valor="";
        try {
            Class.forName("org.postgresql.Driver");
	} catch (ClassNotFoundException e) {
			System.out.println("Error!");
			e.printStackTrace();
	}


		try {
			conn = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/banco", "postgres",
					"1234");
                             stmt = conn.createStatement();
                                String sql = "INSERT INTO transferencia (cuenta_destino,no_tarjeta,monto) "
                                    + "VALUES ('"+cuenta+"', '"+tarjeta+"',"+monto+");";
                                stmt.executeUpdate(sql);
                            stmt.close();
                              conn.commit();
                              conn.close();                
		} catch (SQLException e) {
                     System.out.println("Error2");
			e.printStackTrace();
		}
                valor=id_transferencia(tarjeta,monto);
                return valor;
    }

    String id_transferencia(String tarjeta, Double monto){
        String valor="";
        try {
            Class.forName("org.postgresql.Driver");
	} catch (ClassNotFoundException e) {
			System.out.println("Error!");
			e.printStackTrace();
	}


		try {
			conn = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/banco", "postgres",
					"1234");
                        stmt = conn.createStatement();
                        ResultSet rs = stmt.executeQuery( "SELECT id_transferencia FROM transferencia where no_tarjeta='"+tarjeta+"' and monto="+monto+";" );
                         while ( rs.next() ) {
                            valor = rs.getString("id_transferencia");
                         }
                     
                         rs.close();
                         stmt.close();
                         conn.close();                
		} catch (SQLException e) {
                     System.out.println("Error2");
			e.printStackTrace();
		}

                return valor;
    }

}
