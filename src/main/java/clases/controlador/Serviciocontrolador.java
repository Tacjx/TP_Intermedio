package clases.controlador;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import clases.modelo.Servicio;
import jakarta.persistence.criteria.CriteriaQuery;

public class Serviciocontrolador {
	public String crearServicio(String nombre) {
		SessionFactory sessionFactory=new
				Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Servicio.class).buildSessionFactory();
		Session session=sessionFactory.openSession();
		
		try {
				Servicio servicio=new Servicio(nombre);
				session.beginTransaction();
				session.persist(servicio);
				session.getTransaction().commit();
				sessionFactory.close();
				
				return "Servicio creado satisfactoriamente\n-----------\n"+servicio.toString();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "Error al intentar crear el Servicio";
	}
	
	public String eliminarServicio(int id) {
		SessionFactory sessionFactory=new
				Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Servicio.class).buildSessionFactory();
		Session session=sessionFactory.openSession();
		
		try {
			session.beginTransaction();
			Servicio servicio=session.get(Servicio.class,id);
			session.remove(servicio);
			session.getTransaction().commit();
			sessionFactory.close();
			
			return "Servicio ID:"+ id +" eliminado del sistema\n-----------\n";
	}catch(Exception e) {
		e.printStackTrace();
	}
	return "Error al intentar eliminar el Servicio";
	}
	
	public String actualizarServicio(int id, String nombre) {
		SessionFactory sessionFactory=new
				Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Servicio.class).buildSessionFactory();
		Session session=sessionFactory.openSession();
		
		try {
				session.beginTransaction();
				Servicio servicio=session.get(Servicio.class,id);
				servicio.setId(id);
				servicio.setNombre(nombre);
				session.getTransaction().commit();
				sessionFactory.close();
				
				return "Servicio ID:"+ id +" creado satisfactoriamente\n-----------\n";
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "Error al intentar actualizar el servicio";
	}
	
	public String ListadoServicio() {
		SessionFactory sessionFactory=new
				Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Servicio.class).buildSessionFactory();
		Session session=sessionFactory.openSession();
		
		try {
			session.beginTransaction();
			CriteriaQuery <Servicio> cq= session.getCriteriaBuilder().createQuery(Servicio.class);
			
			cq.from(Servicio.class);
			
			java.util.List <Servicio> servicio=session.createQuery(cq).getResultList();
			
			System.out.println("");
			System.out.println("LISTA DE USUARIOS\n----------------------");
			for(Servicio s:servicio) {
				System.out.println("NOMBRE:"+s+"\n");
				System.out.println("ID:"+s.getId());
				System.out.println("NOMBRE:"+s.getNombre()+"\n------------------------\n");
			}
			sessionFactory.close();
		}catch(Exception e){
			e.printStackTrace();
			return "Error al intentar leer la lista de Servicios";
		}
		
		return "Fin del Listado de Servicios";
	}
	
	public Servicio leerServicio(int id) {
		SessionFactory sessionFactory=new
				Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Servicio.class).buildSessionFactory();
		Session session=sessionFactory.openSession();
		
		try {
			session.beginTransaction();
			Servicio servicio=session.get(Servicio.class,id);
			session.getTransaction().commit();
			sessionFactory.close();
			
			return servicio;
			//return "Servicio ID:"+ id +": "+servicio.toString();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
		//return "Error al intentar leer el Servicio";
	}

}
