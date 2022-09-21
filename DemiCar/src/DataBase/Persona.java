package DataBase;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Persona {

	int dni;
	String nombre;
	String apellido;
	String email;
	String contrasena;
	int NumTel;
	String Obs;
	//int vacio;
	public void validar(String user, String pass) {
		Conectar connect = new Conectar();
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;
		
		
		try {
			cn = connect.Conexion();
			stm = cn.createStatement();
			rs = stm.executeQuery("SELECT * FROM usuario_db where dni = '"+ user + "' and Contrasenia = '"+ pass +"'");
 		if (rs.next()==false) {
				System.out.println("Error Usuario o contraseña");
						}
			else { 
				int idusuario = rs.getInt(1);
				String usuario = rs.getString(2);
				String apellido = rs.getString(3);
				String clave =rs.getString(4);
			System.out.println(idusuario + " - " + usuario + " - " + apellido + " - " + clave);
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
	}
}
