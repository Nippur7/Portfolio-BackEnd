package DataBase;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conectar {
	
	private static final String CONTROLADOR = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/demicar";
	private static final String DB = "demicar";
	private static final String PSW = "LavaDemiCar159753";	
	
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
		
		conectar = DriverManager.getConnection(URL,DB,PSW);
		System.out.println("Conexion exitosa");
	}  catch (SQLException e){
		System.out.println("Error en la conexión");
		e.printStackTrace();
		}
	return conectar;
	}
	
}