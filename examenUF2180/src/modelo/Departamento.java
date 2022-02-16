package modelo;

import java.util.Objects;

public class Departamento {
	
	
	private String cod_departamento;
	private String cod_centro;
	private String tipo_dir;
	private String nombre;
	private String presupuesto;
	
	public Departamento() {
		this.cod_departamento="";
		this.cod_centro="";
		this.tipo_dir="";
		this.nombre="";
		this.presupuesto="";
		
		
	}

	@Override
	public String toString() {
		return "Departamento [cod_departamento=" + cod_departamento + ", cod_centro=" + cod_centro + ", tipo_dir="
				+ tipo_dir + ", "+ ", nombre=" + nombre + "]";
	}

	public String getCod_departamento() {
		return cod_departamento;
	}

	public void setCod_departamento(String cod_departamento) {
		this.cod_departamento = cod_departamento;
	}

	public String getCod_centro() {
		return cod_centro;
	}

	public void setCod_centro(String cod_centro) {
		this.cod_centro = cod_centro;
	}

	public String getTipo_dir() {
		return tipo_dir;
	}

	public void setTipo_dir(String tipo_dir) {
		this.tipo_dir = tipo_dir;
	}



	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cod_departamento);
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
		return Objects.equals(cod_departamento, other.cod_departamento);
	}

	public Departamento (String cod_departamento, String cod_centro,String tipo_dir,String presupuesto,String nombre
			) {
		super();
		this.cod_departamento = cod_departamento;
		this.cod_centro = cod_centro;
		this.tipo_dir = tipo_dir;
		this.presupuesto = presupuesto;
		this.nombre = nombre;
	}
	

}
