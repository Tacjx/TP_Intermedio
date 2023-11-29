package clases.modelo;

import clases.controlador.Incidentecontrolador;

public class Mesa_de_Ayuda {
	//La mesa de ayuda se encarga de recibir las llamadas y cargar los incidentes
	// informados por los clientes.
	
	Incidentecontrolador incidenteCont=new Incidentecontrolador();
	
	public void CargarIncidente() {
		System.out.println("Creando Incidente");incidenteCont.crearIncidente(1, 1, 1, "Lento funcionamiento del Sistema");
	}
}
