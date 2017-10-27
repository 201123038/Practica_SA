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
@WebService(serviceName = "Importadora")
public class Importadora {

        Connection conn = null;
         Statement stmt = null;
    
    @WebMethod(operationName = "crear_Cuenta")
    public String crear_Cuenta(
            @WebParam(name = "nombre") String nombre,
            @WebParam(name = "username") String username,
            @WebParam(name = "password") String password,
            @WebParam(name = "no_Tarjeta") String no_Tarjeta) 
    {
        boolean bandera=false;
                
                String respuesta = "";
                
                bandera=conexion(nombre,username,password,no_Tarjeta);
                
                if(bandera==true)
                    respuesta="{  \"status\":0,  \"descripcion\":\"usuario creado exitosamente\" }";
                else
                    //si existe en vd
                    respuesta="{  \"status\":1,  \"descripcion\":\"username ya existe\" }";
                
                
                return respuesta;
            
    }    
    @WebMethod(operationName = "validar_Sesion")
    public String validar_Sesion(@WebParam(name = "username") String username,
                                  @WebParam(name = "password") String password) {
        String respuesta = "";
        
        respuesta=sesion(username,password);
        
        //verificar en bd
        return respuesta;
    }

    //SE LLAMA A ENVIOS
    @WebMethod(operationName = "solicitar_Catalogo_Vehiculos")
    public String solicitar_Catalogo_Vehiculos() {
        String listado_Vehiculos="",preciov="",precioe="",impsat="",impad="",iva="",isr="";
       //JSON catalogo de bd ENVIOS
       listado_Vehiculos=" \"precio_Vehiculo\":"+preciov+", \"precio_Envio\":"+precioe+", \"impuesto_Sat\":"+impsat+", \"impuesto_Aduana\":"+impad+", \"iva\":"+iva+", \"isr\":"+isr+", \"status\":0,  \"descripcion\":\"Calculos realizados exitosamente\" }";
        
       return listado_Vehiculos;
    }
    
    @WebMethod(operationName = "cotizar_Vehiculo")
    public String cotizar_Vehiculo(@WebParam(name = "id_Vehiculo") Integer id_Vehiculo,
                                   @WebParam(name = "pais_Destino") String pais_Destino) {
        String respuesta ="",valor="";        
        
        //cotizacion tallen en bd importadora
        //JSON catalogo cotizaciones de bd
//        String  marca ="", pais_Origen="",precio_Vehiculo="",status="",descripcion="", precio_envio="",sat="", aduana="", iva="", isr="";
                     
                        respuesta="{" +
        "\"valor\" : 300," +
        "\"status\":0," +
        "\"descripcion\":\"Exitoso\"" +
        "}";        

//        respueta="{ \"precio_Vehiculo\":"+precio_Vehiculo+", \"precio_Envio\":"+precio_envio+", \"impuesto_Sat\":"+sat+", \"impuesto_Aduana\":"+aduana+", \"iva\":"+iva+", \"isr\":"+isr+", \"status\":0,  \"descripcion\":\"Calculos realizados exitosamente\" }";

        return respuesta;
    }
    
     @WebMethod(operationName = "comprar_Vehiculo")
    public String comprar_Vehiculo(
            @WebParam(name = "id_Cliente") Integer id_Cliente,
            @WebParam(name = "no_Tarjeta") String no_Tarjeta,
            @WebParam(name = "id_Vehiculo") Integer id_Vehiculo,
            @WebParam(name = "precio_Vehiculo") Double precio_Vehiculo,
            @WebParam(name = "precio_Envio") Double precio_Envio,
            @WebParam(name = "impuesto_Sat") Double impuesto_Sat,
            @WebParam(name = "impuesto_Aduana") Double impuesto_Aduana,
            @WebParam(name = "iva") Double iva,
            @WebParam(name = "isr") Double isr,
            @WebParam(name = "pais_Origen") String  pais_Origen ,
            @WebParam(name = "pais_Destino") String  pais_Destino
            ) {
        String respuesta="";
        
        String cotizacio=cotizacion(id_Vehiculo.toString()); //suma


        respuesta=insertar(id_Cliente,no_Tarjeta,id_Vehiculo,cotizacio);
        respuesta=factura(id_Vehiculo.toString(),cotizacio);    

        
        return respuesta;
    }

     @WebMethod(operationName = "facturar")
    public String facturar(
            @WebParam(name = "id_Vehiculo") Integer id_Vehiculo
            ) {
        String respuesta="";
        
        String cotizacion=cotizacion(id_Vehiculo.toString()); //suma

        respuesta=factura(id_Vehiculo.toString(),cotizacion);    
        
        return respuesta;
    }

    
    
    boolean conexion(String nombre, String user, String pass, String tarj) {
        boolean bandera=false;
        try {
			Class.forName("org.postgresql.Driver");

		} catch (ClassNotFoundException e) {

			System.out.println("Error!");
			e.printStackTrace();

		}


		try {
			conn = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/importadora", "postgres",
					"1234");
                             bandera=true;
                             stmt = conn.createStatement();
                                String sql = "INSERT INTO cliente (nombre,username,pass,no_Tarjeta) "
                                    + "VALUES ('"+nombre+"', '"+user+"', '"+pass+"', '"+tarj+"');";
                             
                                stmt.executeUpdate(sql);
                            stmt.close();
                              conn.commit();
                              conn.close();       
		} catch (SQLException e) {

			System.out.println("Error2");
			e.printStackTrace();

		}
                 
                              cuenta(nombre,tarj);
	         return bandera;
    }
   
    
    
    String sesion(String user, String pass) {
        String respuesta="";
        String nombre="",no_tarjeta="";

        
        try {
            Class.forName("org.postgresql.Driver");
	} catch (ClassNotFoundException e) {
			System.out.println("Error!");
			e.printStackTrace();
	}


		try {
			conn = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/importadora", "postgres",
					"1234");
                        stmt = conn.createStatement();
                        ResultSet rs = stmt.executeQuery( "SELECT nombre,no_Tarjeta FROM cliente where username='"+user+"' and pass='"+pass+"';" );
                         while ( rs.next() ) {
                            nombre = rs.getString("nombre");
                            no_tarjeta = rs.getString("no_Tarjeta");
                         }
                     
                         rs.close();
                         stmt.close();
                         conn.close();                
		} catch (SQLException e) {
                     System.out.println("Error2");
			e.printStackTrace();
		}

                    if(!(no_tarjeta.equals(""))){
                           respuesta="{  \"nombre\":\""+nombre+"\",  \"no_tarjeta\":\""+no_tarjeta+"\",  \"status\":0,  \"descripcion\":\"validacion correcta\" }";
        
                    }else{
                       respuesta="{  \"nombre\":\"\",  \"no_tarjeta\":\"\",  \"status\":1,  \"descripcion\":\"usuario o password no validos\" }";
			
                    }
	         return respuesta;
    }
    
   @WebMethod(operationName = "comprar_Vehiculo2")
    public String comprar_Vehiculo2(
            @WebParam(name = "id_Cliente") Integer id_Cliente,
            @WebParam(name = "no_Tarjeta") String no_Tarjeta,
            @WebParam(name = "id_Vehiculo") Integer id_Vehiculo
            ) {
        String respuesta="";//JSON
        String cotizacion=cotizacion(id_Vehiculo.toString());
        insertar(id_Cliente,no_Tarjeta,id_Vehiculo,cotizacion);
        respuesta=factura(id_Vehiculo.toString(),cotizacion);    
//respuesta
        return respuesta;
    }


    String cotizacion(String id_vehiculo) {
        String respuesta="",cot="";
        
        try {
            Class.forName("org.postgresql.Driver");
	} catch (ClassNotFoundException e) {
			System.out.println("Error!");
			e.printStackTrace();
	}


		try {
			conn = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/importadora", "postgres",
					"1234");
                        stmt = conn.createStatement();
                        ResultSet rs = stmt.executeQuery( "SELECT total FROM cotizacion where id_Vehiculo="+id_vehiculo+";" );
                         while ( rs.next() ) {
                            cot = rs.getString("total");
                         }
                     
                         rs.close();
                         stmt.close();
                         conn.close();                
		} catch (SQLException e) {
                     System.out.println("Error2");
			e.printStackTrace();
		}

        /*                respuesta="{" +
        "\"valor\" : "+cot+"," +
        "\"status\":0," +
        "\"descripcion\":\"Exitoso\"" +
        "}";        
        */
                return cot;
    }
    String insertar(Integer idc,String no_Tarjeta,Integer idv,String cot){
        String resp="";
        try {
			Class.forName("org.postgresql.Driver");

		} catch (ClassNotFoundException e) {

			System.out.println("Error!");
			e.printStackTrace();

		}


		try {
                        
			conn = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/importadora", "postgres",
					"1234");
                             stmt = conn.createStatement();
                                     resp ="cliente ="+idc+" tarjeta "+no_Tarjeta+" vehiculo "+idv+" total "+cot;

                             String sql = "INSERT INTO transaccion (id_cliente,no_tarjeta,id_vehiculo,total) "
                                    + "VALUES ("+idc+", '"+no_Tarjeta+"', "+idv+", "+cot+");";
                                stmt.executeUpdate(sql);
                            stmt.close();
                              conn.commit();
                              conn.close();                
		} catch (SQLException e) {

			System.out.println("Error2");
			e.printStackTrace();

		} 
        return resp;
    }
    String factura(String id_vehiculo,String cot) {
        String respuesta="", serie="";
        
        try {
            Class.forName("org.postgresql.Driver");
	} catch (ClassNotFoundException e) {
			System.out.println("Error!");
			e.printStackTrace();
	}


		try {
			conn = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/importadora", "postgres",
					"1234");
                        stmt = conn.createStatement();
                        ResultSet rs = stmt.executeQuery( "SELECT total FROM transaccion where id_Vehiculo="+id_vehiculo+";" );
                         while ( rs.next() ) {
                            serie = rs.getString("total");
                         }
                     
                         rs.close();
                         stmt.close();
                         conn.close();                
		} catch (SQLException e) {
                     System.out.println("Error2");
			e.printStackTrace();
		}
/*
                if(serie.equals("")){
                                    respuesta="{" +
                "\"serie\" : \""+serie+"\"," +
                "\"numero_Factura\" : \""+serie+"\" ," +
                 "\"status\":0," +
                "\"descripcion\":\"Código de vehículo no encontrado\"" +
                "}";
                }else{    
                respuesta="{" +
                "\"serie\" : \""+serie+"\"," +
                "\"numero_Factura\" : \""+serie+"\" ,"+
                 "\"status\":0," +
                "\"descripcion\":\"Exito\"" +
                "}";
                }*/

        respuesta="{" +
        "\"valor\" : "+serie+"," +
        "\"status\":0," +
        "\"descripcion\":\"Exitoso\"" +
        "}";    
                return respuesta;
    }

    String linea="",marca="";
    Integer modelo=0;
    Double valor=0.0;
    @WebMethod(operationName = "cotizar_Vehiculo2")
    public String cotizar_Vehiculo2(@WebParam(name = "id_Vehiculo") Integer id_Vehiculo,
                                   @WebParam(name = "pais_Destino") String pais_Destino) {
        String respuesta ="";        
        
        //cotizacion tallen en bd importadora
        //JSON catalogo cotizaciones de bd
//        String  marca ="", pais_Origen="",precio_Vehiculo="",status="",descripcion="", precio_envio="",sat="", aduana="", iva="", isr="";
        Integer valor=300;
                        respuesta="{" +
        "\"valor\" : 300," +
        "\"status\":0," +
        "\"descripcion\":\"Exitoso\"" +
        "}";    
         Envio e = new Envio();
         e.datos(id_Vehiculo);
         Sat s = new Sat();
         Double sa=Double.parseDouble(s.calcular_Impuesto(linea, marca, modelo));
         Aduana a = new Aduana();
                 Double ad=Double.parseDouble(a.calcular_Costo_Aduana(marca, linea, modelo));
         
/*         Double.calcular_costo_viaje(id_Vehiculo, "Guatemala");
         e.total(valor, sa, ad, en, id_Vehiculo);
         */
//        respueta="{ \"precio_Vehiculo\":"+precio_Vehiculo+", \"precio_Envio\":"+precio_envio+", \"impuesto_Sat\":"+sat+", \"impuesto_Aduana\":"+aduana+", \"iva\":"+iva+", \"isr\":"+isr+", \"status\":0,  \"descripcion\":\"Calculos realizados exitosamente\" }";

        return respuesta;
    }

    void cuenta(String nombre, String tarj) {
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
                                String sql = "INSERT INTO cuenta (nombre,no_Tarjeta,saldo) "
                                    + "VALUES ('"+nombre+"', '"+tarj+"', 50000);";
                            stmt.executeUpdate(sql);
                            stmt.close();
                              conn.commit();
                              conn.close();        
                } catch (SQLException e) {

			System.out.println("Error2");
			e.printStackTrace();

		}
                
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
					"jdbc:postgresql://localhost:5432/importadora", "postgres",
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

    //cargar ve
@WebMethod(operationName = "cargar_Vehiculos")
    public String cargar_Vehiculos(){        
        String catalogo = "";
        
        catalogo=vehiculos();
                
        return catalogo;
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
                            linea = rs.getString("linea");
                            modelo = rs.getString("modelo");
                            paiso = rs.getString("pais_Origen");
                            precio = rs.getString("precio_Vehiculo");

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
              
                        String replace = catalogo.replace("},]", "}]");
                       catalogo=replace;  
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

	         return catalogo;
    }


}
