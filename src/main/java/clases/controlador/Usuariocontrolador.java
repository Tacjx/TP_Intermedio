package clases.controlador;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import clases.modelo.Usuario;
import jakarta.persistence.criteria.CriteriaQuery;

public class Usuariocontrolador {
	public String crearUsuario(String nombre, String email, String telefono) {
		SessionFactory sessionFactory=new
				Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Usuario.class).buildSessionFactory();
		Session session=sessionFactory.openSession();
		
		try {
				Usuario usuario=new Usuario(nombre,email,telefono);
				session.beginTransaction();
				session.persist(usuario);
				session.getTransaction().commit();
				sessionFactory.close();
				
				return "Usuario creado satisfactoriamente\n-----------\n"+usuario.toString();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "Error al intentar crear el Usuario";
	}
	
	public String eliminarServicio(int id) {
		SessionFactory sessionFactory=new
				Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Usuario.class).buildSessionFactory();
		Session session=sessionFactory.openSession();
		
		try {
			session.beginTransaction();
			Usuario usuario=session.get(Usuario.class,id);
			session.remove(usuario);
			session.getTransaction().commit();
			sessionFactory.close();
			
			return "Usuario ID:"+ id +" eliminado del sistema\n-----------\n";
	}catch(Exception e) {
		e.printStackTrace();
	}
	return "Error al intentar eliminar el Usuario";
	}
	
	public String actualizarUsuario(int id, String nombre, String email, String telefono) {
		SessionFactory sessionFactory=new
				Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Usuario.class).buildSessionFactory();
		Session session=sessionFactory.openSession();
		
		try {
				session.beginTransaction();
				Usuario usuario=session.get(Usuario.class,id);
				usuario.setId(id);
				usuario.setNombre(nombre);
				session.getTransaction().commit();
				sessionFactory.close();
				
				return "Usuario ID:"+ id +" creado satisfactoriamente\n-----------\n";
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "Error al intentar actualizar el Usuario";
	}
	
	public String ListadoUsuario() {
		SessionFactory sessionFactory=new
				Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Usuario.class).buildSessionFactory();
		Session session=sessionFactory.openSession();
		
		try {
			session.beginTransaction();
			CriteriaQuery <Usuario> cq= session.getCriteriaBuilder().createQuery(Usuario.class);
			
			cq.from(Usuario.class);
			
			java.util.List<Usuario> usuario=session.createQuery(cq).getResultList();
			
			System.out.println("");
			System.out.println("LISTA DE USUARIOS\n----------------------");
			for(Usuario u:usuario) {
				System.out.println("NOMBRE:"+u+"\n");
				System.out.println("ID:"+u.getId());
				System.out.println("NOMBRE:"+u.getNombre());
				System.out.println("EMAIL:"+u.getEmail());
				System.out.println("TELEFONO:"+u.getTelefono()+"\n------------------------\n");
			}
			sessionFactory.close();
		}catch(Exception e){
			e.printStackTrace();
			return "Error al intentar leer la lista de usuarios";
		}
		
		return "Fin del Listado de Usuarios";
	}
	
	public String leerUsuario(int id) {
		SessionFactory sessionFactory=new
				Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Usuario.class).buildSessionFactory();
		Session session=sessionFactory.openSession();
		
		try {
			session.beginTransaction();
			Usuario usuario=session.get(Usuario.class,id);
			session.getTransaction().commit();
			sessionFactory.close();
			
			return "Usuario ID:"+ id +": "+usuario.toString();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "Error al intentar leer el Usuario";
	}

}
