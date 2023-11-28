package clases.vista;

import clases.controlador.Serviciocontrolador;
import clases.controlador.Usuariocontrolador;

public class Usuariovista {

	public static void main(String[] args) {
		Usuariocontrolador usuariocont=new Usuariocontrolador();
		Serviciocontrolador serviciocont=new Serviciocontrolador();
		
		String usuarioLista=usuariocont.ListadoUsuario();
		String servicioLista=serviciocont.ListadoServicio();
		
		
		System.out.println(servicioLista.toString());
		System.out.println(usuarioLista.toString());
	}

}
