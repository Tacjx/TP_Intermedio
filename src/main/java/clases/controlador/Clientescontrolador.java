package clases.controlador;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import clases.modelo.Clientes;

public class Clientescontrolador {
	
	public String CrearCliente(String Cuit,String Nombre, String Apellido, String Razon_Social) {
		SessionFactory sessionFactory=new
				Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Clientes.class).buildSessionFactory();
		Session session=sessionFactory.openSession();
		
		try {
				Clientes cliente=new Clientes(Cuit,Nombre,Apellido,Razon_Social);
				session.beginTransaction();
				session.persist(cliente);
				session.getTransaction().commit();
				sessionFactory.close();
				
				return "Cliente creado satisfactoriamente\n"+cliente.toString();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
