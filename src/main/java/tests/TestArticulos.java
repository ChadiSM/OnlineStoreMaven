package tests;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import Modelo.Articulo;

public class TestArticulos {

	@PersistenceContext(unitName = "Persistencia")
	
	private static EntityManager manager;
	
	private static EntityManagerFactory emf;
	
	private static void main(String[] args) {
		
		/*Creamos gestor de persistencia EM */
		/*
		emf = Persistence.createEntityManagerFactory("Persistencia");
		manager = emf.createEntityManager();
		
		manager.createQuery("FROM articulos");
		
		List<Articulo> articulos = (List<Articulo>) manager.createQuery("FROM Articulos").getResultList();
		
		System.out.println("En esta base de datos hay "+articulos.size() + "empleados");
		*/
		
		emf = Persistence.createEntityManagerFactory("Persistencia");
		
		manager = emf.createEntityManager();
		
		Articulo ar = new Articulo("descrip","codigo", 12.3, 23.5, 23);
		
		manager.getTransaction().begin();
		
		manager.getTransaction().commit();
		
		
	}
	
	
	public void insertarArticulo() {
	

		emf = Persistence.createEntityManagerFactory("Persistencia");
		
		manager = emf.createEntityManager();
		
		Articulo ar = new Articulo("descrip","codigo", 12.3, 23.5, 23);
		
		manager.getTransaction().begin();
		
		manager.persist(ar);
		
		manager.getTransaction().commit();
	
		
	}
	
	private static void imprimirTodo() {
manager = emf.createEntityManager();
		
		manager.createQuery("FROM articulos");
		
		List<Articulo> articulos = (List<Articulo>) manager.createQuery("FROM Articulos").getResultList();
		
		System.out.println("En esta base de datos hay "+articulos.size() + "empleados");
		
	}
}

