package clases.modelo;

import clases.controlador.Usuariocontrolador;

public class RRHH {
	//El Area de Recursos Humanos es la encargada de administrar la carga, eliminacion
	// y actualizacion de los Tecnicos.
	
	Usuariocontrolador usuarioCont=new Usuariocontrolador();
	
	
	public void CrearTecnico() {
		System.out.println("Creando Tecnico");usuarioCont.crearUsuario("Napoleon Bonaparte", "Fracia@gmail.com", "123456789");
	}
	
	public void EliminarTecnico() {
		System.out.println("Eliminando Tecnico");usuarioCont.eliminarUsuario(1);
	}
	
	public void ActualizarTecnico() {
		System.out.println("Actualizando Tecnico");usuarioCont.actualizarUsuario(1, "Augusto Cesar", "Roma@gmail.com", "987654321");
	}

}
