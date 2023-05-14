package tests;



import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import Modelo.Pedido;

public class TestPedidos {

	@PersistenceContext(unitName = "Persistencia")
	
	private static EntityManager manager;
	
	private static EntityManagerFactory emf;
	
	private static void main(String[] args) {
		
		
	}
	
	
	public void insertarPedido() {
	

		emf = Persistence.createEntityManagerFactory("Persistencia");
		
		manager = emf.createEntityManager();
		
		Pedido ar = new Pedido(numeroPedido, cliente, articulo, unidades, fechaHora);
		
		manager.getTransaction().begin();
		
		manager.persist(ar);
		
		manager.getTransaction().commit();
	
		
	}
	
	private static void imprimirTodo() {
		manager = emf.createEntityManager();
		
		manager.createQuery("FROM pedidos");
		
		List<Pedido> articulos = (List<Pedido>) manager.createQuery("FROM Pedido").getResultList();
		
		System.out.println("En esta base de datos hay "+Pedido.size() + "pedidos");
		
	}
}

