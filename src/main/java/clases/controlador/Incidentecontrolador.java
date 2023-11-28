package clases.controlador;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import clases.modelo.Incidente;
import clases.modelo.Servicio;
import clases.modelo.Usuario;
import jakarta.persistence.criteria.CriteriaQuery;

public class Incidentecontrolador {
	public String crearIncidente(int idServicio, int idTecnico, int idUsuario, String descripcion) {
		SessionFactory sessionFactory=new
				Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Incidente.class).buildSessionFactory();
		Session session=sessionFactory.openSession();
		
		try {
				Incidente incidente=new Incidente(idServicio, idTecnico,idUsuario,descripcion);
				session.beginTransaction();
				session.persist(incidente);
				session.getTransaction().commit();
				sessionFactory.close();
				
				return "Incidente creado satisfactoriamente\n-----------\n"+incidente.toString();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "Error al intentar crear el Incidente";
	}
	
	public String eliminarIncidente(int id) {
		SessionFactory sessionFactory=new
				Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Incidente.class).buildSessionFactory();
		Session session=sessionFactory.openSession();
		
		try {
			session.beginTransaction();
			Incidente incidente=session.get(Incidente.class,id);
			session.remove(incidente);
			session.getTransaction().commit();
			sessionFactory.close();
			
			return "Incidente ID:"+ id +" eliminado del sistema\n-----------\n";
	}catch(Exception e) {
		e.printStackTrace();
	}
	return "Error al intentar eliminar el Incidente";
	}
	
	public String actualizarIncidente(int id, int idServicio, int idTecnico, int idUsuario, String descripcion) {
		SessionFactory sessionFactory=new
				Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Incidente.class).buildSessionFactory();
		Session session=sessionFactory.openSession();
		
		try {
				session.beginTransaction();
			    Incidente incidente=session.get(Incidente.class,id);
				incidente.setId(id);
				incidente.setIdServicio(idServicio);
				incidente.setIdTecnico(idTecnico);
				incidente.setIdUsuario(idUsuario);
				incidente.setDescripcion(descripcion);
				session.getTransaction().commit();
				sessionFactory.close();
				
				return "Incidente ID:"+ id +" creado satisfactoriamente\n-----------\n";
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "Error al intentar actualizar el Incidente";
	}
	
	public String ListadoIncidente() {
		SessionFactory sessionFactory=new
				Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Incidente.class).buildSessionFactory();
		Session session=sessionFactory.openSession();
		
		try {
			session.beginTransaction();
			CriteriaQuery <Incidente> cq= session.getCriteriaBuilder().createQuery(Incidente.class);
			
			cq.from(Incidente.class);
			
			java.util.List<Incidente> incidente=session.createQuery(cq).getResultList();
			
			Usuariocontrolador user=new Usuariocontrolador();
			Serviciocontrolador serv=new Serviciocontrolador();
			
			System.out.println("");
			System.out.println("LISTA DE INCIDENTES\n----------------------");
			for(Incidente i:incidente) {
				
				Usuario user1=user.leerUsuario(i.getIdUsuario());
				Servicio serv1=serv.leerServicio(i.getIdServicio());
				
				System.out.println("ID:"+i.getId()+"\n");
				System.out.println("SERVICIO:"+i.getIdServicio()+" | "+serv1.getNombre()+"\n");
				System.out.println("TECNICO:"+i.getIdTecnico()+" | "+user1.getNombre()+"\n");
				System.out.println("USUARIO:"+i.getIdUsuario()+" | "+user1.getNombre()+"\n");
				System.out.println("DESCRIPCION"+i.getDescripcion()+"\n------------------------\n");
			}
			sessionFactory.close();
		}catch(Exception e){
			e.printStackTrace();
			return "Error al intentar leer la lista de Incidentes";
		}
		
		return "Fin del Listado de Incidentes";
	}
	
	public String leerIncidente(int id) {
		SessionFactory sessionFactory=new
				Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Incidente.class).buildSessionFactory();
		Session session=sessionFactory.openSession();
		
		try {
			session.beginTransaction();
			Incidente incidente=session.get(Incidente.class,id);
			session.getTransaction().commit();
			sessionFactory.close();
			
			return "Incidente ID:"+ id +": "+incidente.toString();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "Error al intentar leer el Incidente";
	}


}
