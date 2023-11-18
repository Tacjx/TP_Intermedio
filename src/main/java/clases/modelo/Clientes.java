package clases.modelo;

import java.util.ArrayList;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Clientes")
public class Clientes {
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int ID;
	@Column(name="Cuit")
	private String Cuit;
	@Column(name="Nombre")
    private String Nombre_Cliente;
	@Column(name="Apellido")
    private String Apellido_Cliente;
	@Column(name="Razon Social")
    private String Razon_Social;
    private ArrayList<String>Servicios=new ArrayList<>();
    
    public Clientes() {
    	
    }
    
    public Clientes(String Cuit,String Nombre_Cliente,String Apellido_Cliente,String Razon_Social) {
    	
    }

    public String getCuit() {
        return Cuit;
    }

    public void setCuit(String cuit) {
        Cuit = cuit;
    }

    public String getNombre_Cliente() {
        return Nombre_Cliente;
    }

    public void setNombre_Cliente(String nombre_Cliente) {
        Nombre_Cliente = nombre_Cliente;
    }

    public String getApellido_Cliente() {
        return Apellido_Cliente;
    }

    public void setApellido_Cliente(String apellido_Cliente) {
        Apellido_Cliente = apellido_Cliente;
    }

    public String getRazon_Social() {
        return Razon_Social;
    }

    public void setRazon_Social(String razon_Social) {
        Razon_Social = razon_Social;
    }

    public ArrayList<String> getServicios() {
        return Servicios;
    }

    public void setServicios(ArrayList<String> servicios) {
        Servicios = servicios;
    }
}
