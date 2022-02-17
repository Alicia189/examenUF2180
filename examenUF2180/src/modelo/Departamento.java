/**
 * 
 */
package modelo;

import java.util.Objects;

/**
 * @author David
 *
 */
public class Departamento {

	private int codDepartamento;
	private int codCentro;
	private String tipoDir;
	private int presupuesto;
	private String nombre;
	
	
	public Departamento(int codDepartamento, int codCentro, 
			String tipoDir, int presupuesto, String nombre) {
		this.codDepartamento = codDepartamento;
		this.codCentro = codCentro;
		this.tipoDir = tipoDir;
		this.presupuesto = presupuesto;
		this.nombre = nombre;
	}


	public Departamento() {
	}


	/**
	 * @return el codDepartamento
	 */
	public int getCodDepartamento() {
		return codDepartamento;
	}


	/**
	 * @param codDepartamento el codDepartamento a establecer
	 */
	public void setCodDepartamento(int codDepartamento) {
		this.codDepartamento = codDepartamento;
	}


	/**
	 * @return el codCentro
	 */
	public int getCodCentro() {
		return codCentro;
	}


	/**
	 * @param codCentro el codCentro a establecer
	 */
	public void setCodCentro(int codCentro) {
		this.codCentro = codCentro;
	}


	/**
	 * @return el tipoDir
	 */
	public String getTipoDir() {
		return tipoDir;
	}


	/**
	 * @param tipoDir el tipoDir a establecer
	 */
	public void setTipoDir(String tipoDir) {
		this.tipoDir = tipoDir;
	}


	/**
	 * @return el presupuesto
	 */
	public int getPresupuesto() {
		return presupuesto;
	}


	/**
	 * @param presupuesto el presupuesto a establecer
	 */
	public void setPresupuesto(int presupuesto) {
		this.presupuesto = presupuesto;
	}


	/**
	 * @return el nombre
	 */
	public String getNombre() {
		return nombre;
	}


	/**
	 * @param nombre el nombre a establecer
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	@Override
	public int hashCode() {
		return Objects.hash(codDepartamento);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Departamento other = (Departamento) obj;
		return codDepartamento == other.codDepartamento;
	}


	@Override
	public String toString() {
		return "Departamento [codDepartamento=" + codDepartamento + ", codCentro=" + codCentro + ", tipoDir=" + tipoDir
				+ ", presupuesto=" + presupuesto + ", nombre=" + nombre + "]";
	}
	
	
	
	
}
