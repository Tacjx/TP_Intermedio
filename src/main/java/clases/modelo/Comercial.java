package clases.modelo;

import clases.controlador.Usuariocontrolador;

public class Comercial {
	//El Area Comercial es la encargada de administrar la carga, eliminacion
	// y actualizacion de los Clientes.
	
	Usuariocontrolador usuarioCont=new Usuariocontrolador();
	
	
	public void CrearCliente() {
		System.out.println("Creando Cliente");usuarioCont.crearUsuario("Napoleon Bonaparte", "Fracia@gmail.com", "123456789");
	}
	
	public void EliminarCliente() {
		System.out.println("Eliminando Cliente");usuarioCont.eliminarUsuario(1);
	}
	
	public void ActualizarCliente() {
		System.out.println("Actualizando Cliente");usuarioCont.actualizarUsuario(1, "Augusto Cesar", "Roma@gmail.com", "987654321");
	}

}
