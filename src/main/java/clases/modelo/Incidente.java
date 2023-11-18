package clases.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Incidente")
public class Incidente {
	    @Id
	    @Column(name="ID")
	    @GeneratedValue(strategy=GenerationType.IDENTITY)
	    private int ID;
	    @Column(name="nombre del servicio")
	    private String nombreS;
	    @Column(name="descripcion")
	    private String descripcion;

	    @Column(name="tipo de incidente")
	    private String tipo;
	    @Column(name="Estado")
	    private String Estado;

	    public String getNombreS() {
	        return nombreS;
	    }

	    public void setNombreS(String nombreS) {
	        this.nombreS = nombreS;
	    }

	    public String getDescripcion() {
	        return descripcion;
	    }

	    public void setDescripcion(String descripcion) {
	        this.descripcion = descripcion;
	    }

	    public String getTipo() {
	        return tipo;
	    }

	    public void setTipo(String tipo) {
	        this.tipo = tipo;
	    }

	    public String getEstado() {
	        return Estado;
	    }

	    public void setEstado(String estado) {
	        Estado = estado;
	    }

}
