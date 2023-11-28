package clases.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Usuario")
public class Usuario {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="nombre")
	private String nombre;
	@Column(name="email")
	private String email;
	@Column(name="telefono")
	private String telefono;
	
    public Usuario() {
    	
    }
    
    public Usuario(String nombre,String email,String telefono) {
    	this.nombre=nombre;
    	this.email=email;
    	this.telefono=telefono;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getTelefono() {
        return telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    @Override
	public String toString() {
		return "Servicio[id=" + id + ",nombre=" + nombre + " ,email=" + email +
				" ,telefono=" + telefono + "]";
	}

}
