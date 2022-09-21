package dbases;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;

public class user {
	//Se definen las variables con las que trabajaremos
	String User;
	String contrasena;

	public static String validar(String user, String pass){
		Conectar connect = new Conectar();
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;
		String resp = "";
		
		
		try {
			cn = connect.Conexion();
			stm = cn.createStatement();
			rs = stm.executeQuery("SELECT * FROM user where username = '"+ user + "' and password = '"+ pass +"'");
			if (rs.next()==false) {
				resp = "Error Usuario o contraseña";
						}
			else { 
				//int idusuario = rs.getInt(0);
				//String uName = rs.getString(1);
				//String uPwd = rs.getString(2);
				//LocalDateTime fCreacion =rs.getString(4);
			//System.out.println(rs.getString(1) + " - " + rs.getString(1) + " - " + rs.getString(2) + " - " + "Acceso concedido");
				resp = "Acceso concedido";
				}
 		
 		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if (rs!=null) {
					rs.close();
					
				}
				if (stm!=null) {
					stm.close();
				}
				if (cn!=null) {
					cn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return resp;
	}
}