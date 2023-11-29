package clases.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//La clase incidente refiere al los problemas que surgen en los servicios
// de los clientes que deben ser resueltos por los tecnicos.

@Entity
@Table(name="Incidente")
public class Incidente {
	    @Id
	    @Column(name="id")
	    @GeneratedValue(strategy=GenerationType.IDENTITY)
	    private int id;
	    
	    @Column(name="idServicio")
	    private int idServicio;
	    
	    @Column(name="idTecnico")
	    private int idTecnico;
	    
	    @Column(name="idUsuario")
	    private int idUsuario;
	    
	    @Column(name="descripcion")
	    private String descripcion;

	    
	    public Incidente() {
	    	
	    }
	    public Incidente(int idServicio, int idTecnico, int idUsuario, String descripcion) {
	    	
	    }
	    
	    public int getIdServicio() {
	        return idServicio;
	    }

	    public void setIdServicio(int idServicio) {
	        this.idServicio = idServicio;
	    }
	    
	    
	    public int getIdTecnico() {
	        return idTecnico;
	    }

	    public void setIdTecnico(int idTecnico) {
	        this.idTecnico = idTecnico;
	    }
	    
	    public int getIdUsuario() {
	        return idUsuario;
	    }

	    public void setIdUsuario(int idUsuario) {
	        this.idUsuario = idUsuario;
	    }
	    
	    public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }
	    

	    public String getDescripcion() {
	        return descripcion;
	    }

	    public void setDescripcion(String descripcion) {
	        this.descripcion = descripcion;
	    }
	    
	    @Override
		public String toString() {
			return "Incidente[id=" + id + ",idServicio=" + idServicio + " ,idTecnico=" + idTecnico +
					" ,idUsuario=" + idUsuario +" ,descripcion="+descripcion+ "]";
		}


}
