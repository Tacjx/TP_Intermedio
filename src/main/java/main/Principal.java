package main;

import java.util.Scanner;

import clases.controlador.Incidentecontrolador;
import clases.controlador.Serviciocontrolador;
import clases.controlador.Usuariocontrolador;

public class Principal {

	public static void main(String[] args) {
		try(Scanner leer=new Scanner(System.in)) {
			Usuariocontrolador usuarioCont=new Usuariocontrolador();
			Serviciocontrolador servicioCont=new Serviciocontrolador();
			Incidentecontrolador incidenteCont=new Incidentecontrolador();
			
			char option;
			
			String ManageOption="\n\nMENU:"+"\n---------------------\n"
					+ "1 - Crear Tecnico\n"
					+ "2 - Crear Servicio\n"
					+ "3 - Alta Incidente\n"
					+ "4 - Listado Tecnicos\n"
					+ "5 - Listado Servicio\n"
					+ "6 - Listado Incidente\n"
					+ "7 - Salir";
			while(true) {
				System.out.println(ManageOption);
				option= leer.next().charAt(0);
				
				switch(option) {
				case '1':System.out.println("Creando Tecnico");usuarioCont.crearUsuario("Tomas Cabral", "tomas@gmail.com", "123456789"); ;break;
				case '2':System.out.println("Creando Servicio");servicioCont.crearServicio("Window"); ;break;
				case '3':System.out.println("Creando Incidente");incidenteCont.crearIncidente(1, 1, 1, "Lento funcionamiento del Sistema"); ;break;
				case '4':System.out.println("LISTADO TECNICOS");usuarioCont.ListadoUsuario();break;
				case '5':System.out.println("LISTADO SERVICIOS");servicioCont.ListadoServicio();break;
				case '6':System.out.println("LISTADO INCIDENTES");incidenteCont.ListadoIncidente();break;
				case '7':System.out.println("\n ");System.out.println("SALIDA DEL SISTEMA");System.exit(0);;break;
				default:System.out.println("\n");System.out.println("Opcion del Menu no valida");break;
				}
			}
		}

	}

}
