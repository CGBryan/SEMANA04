package CuidadesDAO;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;



import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.owasp.esapi.ESAPI;

import edu.continental.util.conexion;
import edu.continental.util.ToJSON;

public class cuidadesDAO {
	
	public JSONArray listaCiudades(){
		
		//obterner la conexion a la bd
		conexion cn = new conexion();
		Connection con = cn.getConnection();
		
		//sentencia sql
		String sql = "select id, nombre, altitud,estado fron ciudades where estados = 'A'";
		Statement st = null;
		ResultSet rs = null;
		ToJSON convertidor = new ToJSON();
		JSONArray arreglo = new JSONArray();
		
		try {
			//creo la sentencia
			 st = con.createStatement();
			//se ejecuta la sentencia
			rs = st.executeQuery(sql);

			arreglo = convertidor.toJSONArray(rs);
			st.close();
			
			
		}catch (Exception ex) {
			System.out.println("error:" + ex.getMessage());
			ex.printStackTrace();
			return null;
		}
		return arreglo;
			
		
		
	}

}
