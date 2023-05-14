package tests;



import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import Modelo.Cliente;

public class TestClientes {

	@PersistenceContext(unitName = "Persistencia")
	
	private static EntityManager manager;
	
	private static EntityManagerFactory emf;
	
	private static void main(String[] args) {
		
		
	}
	
	
	public void insertarCliente() {
	

		emf = Persistence.createEntityManagerFactory("Persistencia");
		
		manager = emf.createEntityManager();
		
		Cliente ar = new Cliente("", "", "", "");
		
		manager.getTransaction().begin();
		
		manager.persist(ar);
		
		manager.getTransaction().commit();
	
		
	}
	
	private static void imprimirTodo() {
		manager = emf.createEntityManager();
		
		manager.createQuery("FROM clientes");
		
		List<Cliente> clientes = (List<Cliente>) manager.createQuery("FROM clientes").getResultList();
		
		System.out.println("En esta base de datos hay "+Cliente.size() + "clientes");
		
	}
}

