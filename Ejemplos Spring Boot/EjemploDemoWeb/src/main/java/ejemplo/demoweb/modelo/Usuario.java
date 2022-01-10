package ejemplo.demoweb.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Usuario {
	
	@Id
	private int id;
	private String nombre;
	private String pass;
	
	public Usuario() {
	}
	
	public Usuario(int id, String nombre, String pass) {		
		this.id = id;
		this.nombre = nombre;
		this.pass = pass;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	

}
