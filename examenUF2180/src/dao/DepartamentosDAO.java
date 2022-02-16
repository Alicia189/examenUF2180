package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import conexion.ConexionBD;
import modelo.Centro;
import modelo.Departamento;

public class DepartamentosDAO {

	private ConexionBD conexion;
	
    public DepartamentosDAO() {
        this.conexion = new ConexionBD();
    }

    



    public ArrayList<Departamento> obtenerDepartamento() {
    	// Obtenemos una conexion a la base de datos.
		Connection con = conexion.getConexion();
		Statement consulta = null;
		ResultSet resultado = null;
		
		ArrayList<Departamento> lista = new ArrayList<Departamento>();
		
		try {
			consulta = con.createStatement();
			resultado = consulta.executeQuery("select * from departamentos");
			
			// Bucle para recorrer todas las filas que devuelve la consulta
			while(resultado.next()) {
				String cod_departamento = resultado.getString("cod_departamento");
				String cod_centro = resultado.getString("cod_centro");
				String tipo_dir = resultado.getString("tipo_dir");
				String presupuesto = resultado.getString("Presupuesto");
	
				String nombre = resultado.getString("nombre");
				
				 Departamento departamento = new Departamento(cod_departamento, cod_centro,tipo_dir,presupuesto,nombre);
				lista.add(departamento);
			}
			
		} catch (SQLException e) {
			System.out.println("Error al realizar la consulta sobre centros: "+e.getMessage());
		} finally {
			try {
				resultado.close();
				consulta.close();
				conexion.desconectar();
			} catch (SQLException e) {
				System.out.println("Error al liberar recursos: "+e.getMessage());
			} catch (Exception e) {
				
			}
		}
		return lista;
		
   } public int insertarDepartamento(Departamento departamento) {
   	// Obtenemos una conexion a la base de datos.
		Connection con = conexion.getConexion();
		PreparedStatement consulta = null;
		int resultado=0;
		
		try {
			consulta =  con.prepareStatement("INSERT INTO Departamento (cod_departamento,cod_centro,tipo_dir,presupuesto,nombre"
					+ ")"
					+ " VALUES (?,?,?,?,?"
					+ ") ");
			
			
			consulta.setString(1, departamento.getCod_departamento() );
			consulta.setString(2, departamento.getCod_centro());
			consulta.setString(3, departamento.getTipo_dir());
			consulta.setString(4, departamento.getPresupuesto());
			consulta.setString(5, departamento.getNombre());
			resultado=consulta.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Error al realizar la inserción del centro: "
		        +e.getMessage());
		} finally {
			try {
				consulta.close();
				conexion.desconectar();
			} catch (SQLException e) {
				System.out.println("Error al liberar recursos: "+e.getMessage());
			} catch (Exception e) {
				
			}
		}
		return resultado;
   }
}
    
		


    
