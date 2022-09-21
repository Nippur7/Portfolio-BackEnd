package dbases;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conectar {
	
	private static final String CONTROLADOR = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/aics";
	private static final String US = "root";
	private static final String PSW = "";	
	
	static {
		try {
			Class.forName(CONTROLADOR);
		} catch (ClassNotFoundException e) {
			System.out.println("Error al cargar el controlador de Base de Datos");
			e.printStackTrace();
		}
	}
	public Connection Conexion() {
	Connection conectar = null;
	
	try {
		
		conectar = DriverManager.getConnection(URL,US,PSW);
		System.out.println("Conexion exitosa");
	}  catch (SQLException e){
		System.out.println("Error en la conexi�n");
		e.printStackTrace();
		}
	return conectar;
	}
	
}