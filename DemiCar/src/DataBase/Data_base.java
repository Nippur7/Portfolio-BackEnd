package DataBase;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Data_base {
	
	public void listar (String db) {
		Conectar connect = new Conectar();
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;
		
		try {
			cn = connect.Conexion();
			stm = cn.createStatement();
			rs = stm.executeQuery("SELECT * FROM "+ db);
			while (rs.next()) {
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
	
	public void crear_cliente () {
		
	}

}
