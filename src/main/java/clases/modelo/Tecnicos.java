package clases.modelo;

import java.util.ArrayList;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Tecnicos")
public class Tecnicos {
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String Id_Tec;
	@Column(name="Nombre")
    private String Nombre_Tec;
	@Column(name="Apellido")
    private String Apellido_Tec;
    private ArrayList<String>Especialidades=new ArrayList<>();
    @Column(name="Disponibilidad")
    private Boolean Disponible=Boolean.TRUE;

    public String getId_Tec() {
        return Id_Tec;
    }

    public void setId_Tec(String id_Tec) {
        Id_Tec = id_Tec;
    }

    public String getNombre_Tec() {
        return Nombre_Tec;
    }

    public void setNombre_Tec(String nombre_Tec) {
        Nombre_Tec = nombre_Tec;
    }

    public String getApellido_Tec() {
        return Apellido_Tec;
    }

    public void setApellido_Tec(String apellido_Tec) {
        Apellido_Tec = apellido_Tec;
    }

    public ArrayList<String> getEspecialidades() {
        return Especialidades;
    }

    public void setEspecialidades(ArrayList<String> especialidades) {
        Especialidades = especialidades;
    }

    public Boolean getDisponible() {
        return Disponible;
    }

    public void setDisponible(Boolean disponible) {
        Disponible = disponible;
    }

}
